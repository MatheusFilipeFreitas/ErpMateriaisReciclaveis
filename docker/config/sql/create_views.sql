USE RecyProTech;
GO

create view vw_produtoHistorico as
SELECT * FROM produto_Historico;

create view vw_operacaoEntrada as
select * from operacao
where tipo_operacao = 'Entrada';

create view vw_operacaoSaida as
select * from operacao
where tipo_operacao = 'Saída';

CREATE VIEW vw_ProdutosDetalhados
AS
SELECT
    p.id_produto,
    p.cod,
    p.descricao,
    p.estoque,
    p.validade,
    h.ValidFrom AS Historico_ValidFrom,
    h.ValidTo AS Historico_ValidTo,
    h.estoque AS Historico_Estoque,
    h.validade AS Historico_Validade
FROM
    produto p
LEFT JOIN
    produto_Historico h ON p.id_produto = h.id_produto;

create view vw_operacaoEntrada as
select * from vw_ProdutosDetalhados;

create view vw_operacaoEntrada as
select * from vw_operacaoEntrada;

create view vw_operacaoEntrada as
select * from vw_operacaoSaida; 

create view vw_logs as
select * from tbl_log;
