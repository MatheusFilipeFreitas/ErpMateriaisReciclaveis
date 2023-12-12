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

CREATE TRIGGER tr_LogInsertProduto
ON produto
AFTER INSERT
AS
BEGIN
    INSERT INTO tbl_log (data_hora, tabela_afetada, tipo_operacao, descricao)
    SELECT
        GETDATE(),
        'produto',
        'Inserção',
        'Inserção de registro na tabela produto'
    FROM inserted;
END;
GO

-- Trigger para atualizações na tabela produto
CREATE TRIGGER tr_LogUpdateProduto
ON produto
AFTER UPDATE
AS
BEGIN
    INSERT INTO tbl_log (data_hora, tabela_afetada, tipo_operacao, descricao)
    SELECT
        GETDATE(),
        'produto',
        'Atualização',
        'Atualização de registro na tabela produto'
    FROM inserted;
END;
GO

-- Trigger para exclusões na tabela produto
CREATE TRIGGER tr_LogDeleteProduto
ON produto
AFTER DELETE
AS
BEGIN
    INSERT INTO tbl_log (data_hora, tabela_afetada, tipo_operacao, descricao)
    SELECT
        GETDATE(),
        'produto',
        'Exclusão',
        'Exclusão de registro na tabela produto'
    FROM deleted;
END;
GO

-- Trigger para inserções na tabela operacao
CREATE TRIGGER tr_LogInsertOperacao
ON operacao
AFTER INSERT
AS
BEGIN
    INSERT INTO tbl_log (data_hora, tabela_afetada, tipo_operacao, descricao)
    SELECT
        GETDATE(),
        'operacao',
        'Inserção',
        'Inserção de registro na tabela operacao'
    FROM inserted;
END;
GO

-- Trigger para atualizações na tabela operacao
create TRIGGER tr_LogUpdateOperacao
ON operacao
AFTER UPDATE
AS
BEGIN
    INSERT INTO tbl_log (data_hora, tabela_afetada, tipo_operacao, descricao)
    SELECT
        GETDATE(),
        'operacao',
        'Atualização',
        'Atualização de registro na tabela operacao'
    FROM inserted;
END;
GO

-- Trigger para exclusões na tabela operacao
CREATE TRIGGER tr_LogDeleteOperacao
ON operacao
AFTER DELETE
AS
BEGIN
    INSERT INTO tbl_log (data_hora, tabela_afetada, tipo_operacao, descricao)
    SELECT
        GETDATE(),
        'operacao',
        'Exclusão',
        'Exclusão de registro na tabela operacao'
    FROM deleted;
END;
GO

-- Trigger para inserções na tabela usuario
CREATE TRIGGER tr_LogInsertUsuario
ON usuario
AFTER INSERT
AS
BEGIN
    INSERT INTO tbl_log (data_hora, tabela_afetada, tipo_operacao, descricao)
    SELECT
        GETDATE(),
        'usuario',
        'Inserção',
        'Inserção de registro na tabela usuario'
    FROM inserted;
END;
GO

-- Trigger para atualizações na tabela usuario
create TRIGGER tr_LogUpdateUsuario
ON usuario
AFTER UPDATE
AS
BEGIN
    INSERT INTO tbl_log (data_hora, tabela_afetada, tipo_operacao, descricao)
    SELECT
        GETDATE(),
        'usuario',
        'Atualização',
        'Atualização de registro na tabela usuario'
    FROM inserted;
END;
GO

-- Trigger para exclusões na tabela usuario
CREATE TRIGGER tr_LogDeleteUsuario
ON usuario
AFTER DELETE
AS
BEGIN
    INSERT INTO tbl_log (data_hora, tabela_afetada, tipo_operacao, descricao)
    SELECT
        GETDATE(),
        'usuario',
        'Exclusão',
        'Exclusão de registro na tabela usuario'
    FROM deleted;
END;
GO

-- Criar uma trigger para atualizar o estoque

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