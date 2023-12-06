USE RecyProTech;
GO

CREATE TRIGGER tr_LogProcedures
ON DATABASE
FOR CREATE_PROCEDURE, ALTER_PROCEDURE, DROP_PROCEDURE
AS
BEGIN
    SET NOCOUNT ON;

    DECLARE @evento varchar(100), @descricao varchar(max);

    SELECT
        @evento = EVENTDATA().value('(/EVENT_INSTANCE/EventType)[1]', 'varchar(100)'),
        @descricao = EVENTDATA().value('(/EVENT_INSTANCE/ObjectName)[1]', 'varchar(max)');

    -- Inserir log
    EXEC sp_InsertLog @evento, @descricao;
END;
GO

CREATE TRIGGER tr_atualizarEstoque
ON operacao
AFTER INSERT
AS
BEGIN
    SET NOCOUNT ON;

    DECLARE @id_produto int, @quantidade int, @tipo_operacao varchar(20), @estoque_atual int;

    -- Obter os dados da operação inserida
    SELECT @id_produto = id_produto, @quantidade = quantidade, @tipo_operacao = tipo_operacao
    FROM inserted;

    -- Obter o estoque atual
    SELECT @estoque_atual = estoque
    FROM produto
    WHERE id_produto = @id_produto;

    -- Atualizar o estoque com base no tipo de operação
    IF @tipo_operacao = 'Entrada'
    BEGIN
        UPDATE produto
        SET estoque = @estoque_atual + @quantidade
        WHERE id_produto = @id_produto;
    END
    ELSE IF @tipo_operacao = 'Saída'
    BEGIN
        -- Verificar se a quantidade a ser subtraída não é maior que o estoque atual
        IF @quantidade <= @estoque_atual
        BEGIN
            UPDATE produto
            SET estoque = @estoque_atual - @quantidade
            WHERE id_produto = @id_produto;
        END
        ELSE
        BEGIN
            -- Inserir mensagem de erro (ou tratar conforme necessário)
            RAISERROR('Quantidade a ser subtraída maior que o estoque atual.', 16, 1);
        END
    END
END;
GO