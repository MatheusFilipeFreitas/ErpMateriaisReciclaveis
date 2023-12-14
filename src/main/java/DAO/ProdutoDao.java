/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Beans.Produto;
import Beans.Usuario;
import Connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author laboratorio
 */
public class ProdutoDao {
    
    private Conexao conexao;
    private Connection conn;
    
    public ProdutoDao() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserir(Produto produto) {
        String sql = "EXEC sp_InsertProduto ?,?,?,?;";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, produto.getCod());
            stmt.setString(2, produto.getDescricao());
            stmt.setDate(3, new java.sql.Date(produto.getValidade().getTime()));
            stmt.setInt(4, produto.getEstoque());
            
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir produto: " + ex.getMessage());
        }

    }

    public void editar(Produto produto) {
        try {
            String sql = "EXEC sp_UpdateProduto ?,?,?,?,?;";
            PreparedStatement smt = conn.prepareStatement(sql);
            
            smt.setInt(1, produto.getId_produto());
            smt.setString(2, produto.getCod());
            smt.setString(3, produto.getDescricao());
            smt.setDate(4, new java.sql.Date(produto.getValidade().getTime()));
            smt.setInt(5, produto.getEstoque());

            smt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar: " + ex.getMessage());
        }
    }

    public void excluir(int id_produto) {
        try {
            String sql = "EXEC sp_DeleteProduto ?;";

            PreparedStatement stmt = this.conn.prepareStatement(sql);

            stmt.setInt(1, id_produto);
            stmt.execute();

        } catch (SQLException ex) {
            System.out.println("erro ao excluir" + ex.getMessage());
        }
    }

    public Produto getProduto(int id_produto) {
        String sql = "SELECT * FROM produto WHERE id_produto = ?";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id_produto);
            ResultSet rs = stmt.executeQuery();

            Produto p = new Produto();

            if (rs.next()) { // Verificar se existem resultados
                p.setId_produto(id_produto);
                p.setCod(rs.getString("cod"));
                p.setDescricao(rs.getString("descricao"));
                p.setEstoque(rs.getInt("estoque"));
                p.setValidade(rs.getDate("validade"));

                return p;
            } else {
                // Nenhum resultado encontrado para o ID de produto fornecido
                // Você pode lançar uma exceção ou lidar com isso de outra maneira
                System.out.println("Nenhum produto encontrado para o ID: " + id_produto);
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
            return null;
        }
    }


    public List<Produto> getProdutos() {
        String sql = "SELECT * FROM produto;";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = stmt.executeQuery();
            List<Produto> listaProdutos = new ArrayList();

            while (rs.next()) {
                Produto p = new Produto();

                p.setId_produto(rs.getInt("id_produto"));
                p.setCod(rs.getString("cod"));
                p.setDescricao(rs.getString("descricao"));
                p.setEstoque(rs.getInt("estoque"));
                p.setValidade(rs.getDate("validade"));

                listaProdutos.add(p);
            }
            return listaProdutos;
        } catch (SQLException ex) {
            System.out.println("erro" + ex.getMessage());
            return null;
        }
    }

    public Produto getProdutoCod(String cod) {
        String sql = "SELECT * FROM produto WHERE cod LIKE ?";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setString(1, "%" + cod + "%");
            ResultSet rs = stmt.executeQuery();

            Produto p = new Produto();
            
            while (rs.next()) {
                p.setId_produto(rs.getInt("id_produto"));
                p.setCod(rs.getString("cod"));
                p.setDescricao(rs.getString("descricao"));
                p.setEstoque(rs.getInt("estoque"));
                p.setValidade(rs.getDate("validade"));
                
            }
            return p;
        } catch (SQLException ex) {
            return null;
        }
    }
    
}
