CREATE DATABASE RecyProTech;
GO

-- Utilizar o banco de dados criado
USE RecyProTech;
GO

begin --criar tabelas
    create table usuario (
        id_usuario int primary key identity,
        nome varchar(50),
        cpf int
    );

    CREATE TABLE produto (
        id_produto int primary key identity,
        cod varchar(50),
        descricao varchar(50),
        estoque int default 0,
        validade date,
        ValidFrom datetime2 GENERATED ALWAYS AS ROW START HIDDEN NOT NULL,
        ValidTo datetime2 GENERATED ALWAYS AS ROW END HIDDEN NOT NULL,
        PERIOD FOR SYSTEM_TIME (ValidFrom, ValidTo)
    );

    -- Criar a tabela de histórico para o campo estoque
    CREATE TABLE produto_Historico
    (
        id_produto int not null,
        cod varchar(50),
        descricao varchar(50),
        estoque int,
        validade date,
        ValidFrom datetime2 not null,
        ValidTo datetime2 not null
    );




    -- Ativar a rastreabilidade temporal na tabela produto
    ALTER TABLE produto
    SET (SYSTEM_VERSIONING = ON (HISTORY_TABLE = dbo.produto_Historico));


    create table operacao (
        id_operacao int primary key identity,
        id_produto int,
        id_usuario int,
        tipo_operacao varchar(20) check(tipo_operacao in( 'Entrada', 'Saída')) not null,
        motivo varchar(50),
        quantidade int not null,
        data_hora datetime,
        foreign key (id_produto) references produto(id_produto),
        foreign key (id_usuario) references usuario(id_usuario),
    );

    CREATE TABLE tbl_log (
        id_log int primary key identity,
        data_hora datetime,
        tabela_afetada varchar(100),
        tipo_operacao varchar(20),
        descricao varchar(max)
    );
end