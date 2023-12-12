/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Beans.Operacao;
import conexao.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author laboratorio
 */
public class OperacaoDao {

    private conexao conection;
    private Connection conn;

    public OperacaoDao() {
        this.conection = new conexao();
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
            JOptionPane.showMessageDialog(null, "Erro ao inserir autor: " + ex.getMessage());
        }
    }
    
    /*public Operacao Consultar(int id) {
        String sql = "SELECT * FROM operacao WHERE id_operacao  = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Operacao op = new Operacao();
            rs.first();
            op.setId_produto(rs.getPro("Id_produto"));
            a.setNacionalidade(rs.getString("nacionalidade"));
            a.setAnoNasc(rs.getString("dataNasc"));

            return a;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consulta autores: " + ex.getMessage());
            return null;
        }
    }*/
}
