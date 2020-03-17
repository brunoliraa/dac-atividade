package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import org.apache.derby.jdbc.ClientDriver;
//import org.apache.derby.jdbc.EmbeddedDriver;


public class Conexao {

    //url "jdbc:derby:dac;create=true;"
    private String url;
    private String usuario;
    private String senha;

    public Connection connection;

    public Conexao (){
        this.url = "jdbc:derby:dac;create=true";
       // this.url="jdbc:derby:memory:dac;create=true";
    }

public Connection getConnection() throws Exception{
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

        try {
            connection = DriverManager.getConnection(url);
            System.out.println("works");
            return this.connection;
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        };
        return null;
}

    public void FecharConexao(){
        try{
            connection.close();
        }
        catch(Exception ex){
            System.out.println("erro na desconexao"+ex.getMessage());

        }

    }

    public void createTable() {
        try {
            this.getConnection();
            connection.createStatement().execute("create table PESSOA (id integer not null,nome varchar(32),idade integer, altura float,dataNascimento date, primary key(id))");
            System.out.println("criou");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            System.out.println("erro");
        }
    }

}
