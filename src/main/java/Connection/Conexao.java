
package Connection;

import java.sql.*;

public class Conexao {
    
    public Connection getConexao(){
        try{
            Connection conn = DriverManager.getConnection("jdbc:jtds:sqlserver://localhost:1433/RecyProTech;instance=v1;user=sa;password=laboratorio1@");
            System.out.println("Conexao com o banco realizada com sucesso");
            
            return conn;
            
            
        }catch(Exception e){
            System.out.println("Erro ao se conectar com o banco de dados" + e.getMessage());
            return null;
        }
    }
    
    public static void main(String[] args){
        Conexao c = new Conexao();
        c.getConexao();
    }
}
