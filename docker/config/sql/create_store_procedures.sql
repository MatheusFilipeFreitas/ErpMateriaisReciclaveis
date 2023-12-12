USE RecyProTech;
GO

CREATE PROCEDURE sp_InsertProduto
    @cod varchar(50),
    @descricao varchar(50),
    @validade date,
    @estoque int
AS
BEGIN
    INSERT INTO produto (cod, descricao, validade, estoque)
    VALUES (@cod, @descricao, @validade, @estoque);
END;
GO

-- Stored Procedure para atualizar informações de um produto
CREATE PROCEDURE sp_UpdateProduto
    @id_produto int,
    @cod varchar(50),
    @descricao varchar(50),
    @validade date,
    @estoque int
AS
BEGIN
    UPDATE produto
    SET cod = @cod,
        descricao = @descricao,
        validade = @validade,
        estoque = @estoque
    WHERE id_produto = @id_produto;
END;
GO

-- Stored Procedure para excluir um produto
CREATE PROCEDURE sp_DeleteProduto
    @id_produto int
AS
BEGIN
    DELETE FROM produto
    WHERE id_produto = @id_produto;
END;
GO

-- Stored Procedure para inserir um novo usuário
CREATE PROCEDURE sp_InsertUsuario
    @nome varchar(50),
    @cpf int
AS
BEGIN
    INSERT INTO usuario (nome, cpf)
    VALUES (@nome, @cpf);
END;
GO

-- Stored Procedure para atualizar informações de um usuário
CREATE PROCEDURE sp_UpdateUsuario
    @id_usuario int,
    @nome varchar(50),
    @cpf int
AS
BEGIN
    UPDATE usuario
    SET nome = @nome,
        cpf = @cpf
    WHERE id_usuario = @id_usuario;
END;
GO

-- Stored Procedure para excluir um usuário
CREATE PROCEDURE sp_DeleteUsuario
    @id_usuario int
AS
BEGIN
    DELETE FROM usuario
    WHERE id_usuario = @id_usuario;
END;
GO

-- Stored Procedure para inserir uma nova operação
CREATE PROCEDURE sp_InsertOperacao
    @id_produto int,
    @id_usuario int,
    @tipo_operacao varchar(20),
    @motivo varchar(50),
    @quantidade int,
    @data_hora datetime
AS
BEGIN
    INSERT INTO operacao (id_produto, id_usuario, tipo_operacao, motivo, quantidade, data_hora)
    VALUES (@id_produto, @id_usuario, @tipo_operacao, @motivo, @quantidade, @data_hora);
END;
GO

-- Stored Procedure para atualizar informações de uma operação
CREATE PROCEDURE sp_UpdateOperacao
    @id_operacao int,
    @id_produto int,
    @id_usuario int,
    @tipo_operacao varchar(20),
    @motivo varchar(50),
    @quantidade int,
    @data_hora datetime
AS
BEGIN
    UPDATE operacao
    SET id_produto = @id_produto,
        id_usuario = @id_usuario,
        tipo_operacao = @tipo_operacao,
        motivo = @motivo,
        quantidade = @quantidade,
        data_hora = @data_hora
    WHERE id_operacao = @id_operacao;
END;
GO

-- Stored Procedure para excluir uma operação
CREATE PROCEDURE sp_DeleteOperacao
    @id_operacao int
AS
BEGIN
    DELETE FROM operacao
    WHERE id_operacao = @id_operacao;
END;
GO

CREATE PROCEDURE sp_InsertLog
    @evento varchar(100),
    @descricao varchar(max)
AS
BEGIN
    INSERT INTO sistema_log (data_hora, evento, descricao)
    VALUES (GETDATE(), @evento, @descricao);
END;
GO