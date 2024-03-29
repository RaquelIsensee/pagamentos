package servicos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {
// criar variável conexao
public Connection connection;
//driver, DRIVER = banco de dados, URL referente ao caminho
public Connection getConexao(){
	final String DRIVER = "com.mysql.cj.jdbc.Driver";
	final String URL = "jdbc:mysql://127.0.0.1:3306/pagamento";
 // tenta a conexao, root e root como usuário e senha   
    try{
        Class.forName(DRIVER);
       connection = DriverManager.getConnection(URL, "root","");
        return connection;
    }catch(ClassNotFoundException e){
        JOptionPane.showMessageDialog(null, "Driver não encontrado: " + e.toString());
    }catch (SQLException e){
        JOptionPane.showMessageDialog(null, "Problemas na fonte de dados." + e.toString());
    }
    return null;
}
//fechar conexão
public void close(){
    try{
        connection.close();
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null, "Problemas ao fechar conexão" + e.toString());
    }
}     
}    
