USE RecyProTech;
GO


begin -- inserir registros

    -- Criar registros

    INSERT INTO usuario (nome, cpf) VALUES ('João Silva', 123456789);

    -- Inserir dados na tabela produto
    INSERT INTO produto (cod, descricao, validade) VALUES ('P001', 'Produto A', '2023-01-01');
    INSERT INTO produto (cod, descricao, validade) VALUES ('P002', 'Produto B', '2023-02-01');

    -- Inserir dados na tabela operacao (entrada)
    INSERT INTO operacao (id_produto, id_usuario, tipo_operacao, motivo, quantidade, data_hora)
    VALUES (1, 1, 'Entrada', 'Compra', 100, GETDATE());

    -- Inserir dados na tabela operacao (saída)
    INSERT INTO operacao (id_produto, id_usuario, tipo_operacao, motivo, quantidade, data_hora)
    VALUES (2, 1, 'Saída', 'Venda', 50, GETDATE());


    -- Adicionar mais dados na tabela produto
    INSERT INTO produto (cod, descricao, validade, estoque) VALUES ('P003', 'Produto C', '2023-03-01', 75);
    INSERT INTO produto (cod, descricao, validade, estoque) VALUES ('P004', 'Produto D', '2023-04-01', 120);

    -- Alterar o estoque de alguns produtos
    UPDATE produto SET estoque = 50 WHERE id_produto = 1;
    UPDATE produto SET estoque = 80 WHERE id_produto = 2;
    UPDATE produto SET estoque = 100 WHERE id_produto = 3;



    INSERT INTO operacao (id_produto, id_usuario, tipo_operacao, motivo, quantidade, data_hora)
    VALUES (1, 1, 'Entrada', 'Compra', 3, GETDATE());

    INSERT INTO operacao (id_produto, id_usuario, tipo_operacao, motivo, quantidade, data_hora)
    VALUES (2, 1, 'Saída', 'Venda', 30, GETDATE());

    INSERT INTO operacao (id_produto, id_usuario, tipo_operacao, motivo, quantidade, data_hora)
    VALUES (1, 1, 'Entrada', 'Compra', 2, GETDATE());
end