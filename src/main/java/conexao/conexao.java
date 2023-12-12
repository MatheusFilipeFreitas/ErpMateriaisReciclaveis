
package conexao;

import java.sql.*;

public class conexao {
    
    public Connection getConexao(){
        try{
            Connection conn = DriverManager.getConnection("Server=localhost;Database=RecyProTech;User Id=as;Password=laboratorio;");
            System.out.println("Conexao com o banco realizada com sucesso");
            
            return conn;
            
            
        }catch(Exception e){
            System.out.println("Erro ao se conectar com o banco de dados" + e.getMessage());
            return null;
        }
    }
    
    public static void main(String[] args){
        conexao c = new conexao();
        c.getConexao();
    }
}
