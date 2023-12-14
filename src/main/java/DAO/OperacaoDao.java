/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Beans.Operacao;
import Beans.Produto;
import Beans.Usuario;
import Connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author laboratorio
 */
public class OperacaoDao {

    private Conexao conection;
    private Connection conn;

    public OperacaoDao() {
        this.conection = new Conexao();
        this.conn = this.conection.getConexao();
    }

    public void inserir(Operacao op) {
        String sql = "EXEC sp_InsertOperacao ?,?,?,?,?,?;";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, op.getId_produto().getId_produto());
            stmt.setInt(2, op.getId_usuario().getId_usuario());
            stmt.setString(3, op.getTipo_operacao());
            stmt.setString(4, op.getMotivo());
            stmt.setInt(5, op.getQuantidade());
            stmt.setDate(6, new java.sql.Date(op.getData_hora().getTime()));

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Registro inserido com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir Operação: " + ex.getMessage());
        }
    }

    public Operacao Consultar(int id) {
        String sql = "SELECT * FROM operacao WHERE id_operacao  = ?;";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Operacao op = new Operacao();
            rs.first();
            ProdutoDao pdao = new ProdutoDao();
            UsuarioDao uDao = new UsuarioDao();

            op.setId_produto(pdao.getProduto(rs.getInt("id_produto")));
            op.setId_usuario(uDao.getUsuario(rs.getInt("id_usuario")));
            op.setTipo_operacao(rs.getString("tipo_operacao"));
            op.setMotivo(rs.getString("motivo"));
            op.setQuantidade(rs.getInt("quantidade"));
            op.setData_hora(rs.getDate("data_hora"));

            return op;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consulta Operação: " + ex.getMessage());
            return null;
        }
    }

    public void Editar(Operacao op) {
        try {
            String sql = "EXEC sp_UpdateOperacao ?,?,?,?,?,?,?;";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, op.getId_operacao());
            stmt.setInt(1, op.getId_produto().getId_produto());
            stmt.setInt(2, op.getId_usuario().getId_usuario());
            stmt.setString(3, op.getTipo_operacao());
            stmt.setString(4, op.getMotivo());
            stmt.setInt(5, op.getQuantidade());
            stmt.setDate(6, new java.sql.Date(op.getData_hora().getTime()));
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar Operacao: " + ex.getMessage());
        }
    }

    public void Excluir(int id) {
        try {
            String sql = "EXEC sp_DeleteOperacao ?;";

            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir Operação: " + ex.getMessage());
        }
    }
    
        public List<Operacao> ConsultaOperacoes() {
        String sql = "SELECT * FROM operacao;";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery();

            List<Operacao> listaOperacoes = new ArrayList<>();
            ProdutoDao pdao = new ProdutoDao();
            UsuarioDao uDao = new UsuarioDao();

            while (rs.next()) {
                Operacao op = new Operacao(); // Criar uma nova instância a cada iteração
                op.setId_operacao(rs.getInt("id_operacao"));
                Produto produto = pdao.getProduto(rs.getInt("id_produto"));
                op.setId_produto(produto);
                Usuario usuario = uDao.getUsuario(rs.getInt("id_usuario"));
                op.setId_usuario(usuario);
                op.setTipo_operacao(rs.getString("tipo_operacao"));
                op.setMotivo(rs.getString("motivo"));
                op.setQuantidade(rs.getInt("quantidade"));
                op.setData_hora(rs.getDate("data_hora"));
                listaOperacoes.add(op);
            }

            return listaOperacoes;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar Operações: " + ex.getMessage());
            return null;
        }

    }

    public List<Operacao> ConsultaOperacoesSaida() {
        String sql = "SELECT * FROM vw_operacaoSaida ";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery();
            
            Operacao op ;
            List<Operacao> listaOperacoes = new ArrayList();

            while (rs.next()) {
                op = new Operacao();
                rs.first();
                ProdutoDao pdao = new ProdutoDao();
                UsuarioDao uDao = new UsuarioDao();

                op.setId_operacao(rs.getInt("id_operacao"));
                op.setId_produto(pdao.getProduto(rs.getInt("id_produto")));
                op.setId_usuario(uDao.getUsuario(rs.getInt("id_usuario")));
                op.setTipo_operacao(rs.getString("tipo_operacao"));
                op.setMotivo(rs.getString("motivo"));
                op.setQuantidade(rs.getInt("quantidade"));
                op.setData_hora(rs.getDate("data_hora"));
                listaOperacoes.add(op);
            }
            return listaOperacoes;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consulta Operações de saída: " + ex.getMessage());
            return null;
        }
    }
    
    public List<Operacao> ConsultaOperacoesEntrada() {
        String sql = "SELECT * FROM vw_operacaoEntrada ";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery();
            
            Operacao op ;
            List<Operacao> listaOperacoes = new ArrayList();

            while (rs.next()) {
                op = new Operacao();
                rs.first();
                ProdutoDao pdao = new ProdutoDao();
                UsuarioDao uDao = new UsuarioDao();

                op.setId_operacao(rs.getInt("id_operacao"));
                op.setId_produto(pdao.getProduto(rs.getInt("id_produto")));
                op.setId_usuario(uDao.getUsuario(rs.getInt("id_usuario")));
                op.setTipo_operacao(rs.getString("tipo_operacao"));
                op.setMotivo(rs.getString("motivo"));
                op.setQuantidade(rs.getInt("quantidade"));
                op.setData_hora(rs.getDate("data_hora"));
                listaOperacoes.add(op);
            }
            return listaOperacoes;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consulta Operações de entrada: " + ex.getMessage());
            return null;
        }
    }
}
