/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Beans.Usuario;
import Connection.Conexao;
import Connection.Conexao;
import java.sql.CallableStatement;
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
public class UsuarioDao {

    private Conexao conexao;
    private Connection conn;
    
    public UsuarioDao() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public void inserir(Usuario usuario) {
        String sql = "EXEC sp_InsertUsuario ?,?;";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setInt(2, usuario.getCpf());

            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir usuario: " + ex.getMessage());
        }

    }

    public void editar(Usuario usuario) {
        try {
            String sql = "EXEC sp_UpdateUsuario ?,?,?;";
            PreparedStatement smt = conn.prepareStatement(sql);

            smt.setInt(1, usuario.getId_usuario());
            smt.setString(2, usuario.getNome());
            smt.setInt(3, usuario.getCpf());

            smt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar: " + ex.getMessage());
        }
    }

    public void excluir(int id_usuario) {
        try {
            String sql = "EXEC sp_DeleteUsuario ?;";

            PreparedStatement stmt = this.conn.prepareStatement(sql);

            stmt.setInt(1, id_usuario);
            stmt.execute();

        } catch (SQLException ex) {
            System.out.println("erro ao excluir" + ex.getMessage());
        }
    }

    public Usuario getUsuario(int id_usuario) {
        String sql = "SELECT * FROM usuario WHERE id_usuario = ?";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            stmt.setInt(1, id_usuario);
            ResultSet rs = stmt.executeQuery();
            Usuario u = new Usuario();

            if(rs.next()){
                u.setId_usuario(id_usuario);
                u.setNome(rs.getString("nome"));
                u.setCpf(rs.getInt("cpf"));
                
                return u;
            }else{
                System.out.println("Nenhum usuário encontrado para o ID: " + id_usuario);
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("erro" + ex.getMessage());
            return null;
        }
    }

    public List<Usuario> getUsuarios() {
        String sql = "SELECT * FROM usuario";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = stmt.executeQuery();
            List<Usuario> listaUsuarios = new ArrayList();

            while (rs.next()) {
                Usuario u = new Usuario();

                u.setId_usuario(rs.getInt("id_usuario"));
                u.setNome(rs.getString("nome"));
                u.setCpf(rs.getInt("cpf"));

                listaUsuarios.add(u);
            }
            return listaUsuarios;
        } catch (SQLException ex) {
            return null;
        }
    }

    public Usuario getUsuarioNome(String nome) {
        String sql = "SELECT * FROM usuario WHERE nome LIKE ?";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();
            
            Usuario u = new Usuario();
            
            while (rs.next()) {
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setNome(rs.getString("nome"));
                u.setCpf(rs.getInt("cpf"));
            }
            
            return u;
        } catch (SQLException ex) {
            return null;
        }
    }

}
