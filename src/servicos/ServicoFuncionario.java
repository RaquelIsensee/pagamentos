package servicos;

import classes.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ServicoFuncionario {
    private final Conexao conexao = new Conexao();  
    
    public void insert(Funcionario funcionario) throws SQLException {
        //Criando variavel conexao
        Connection con = conexao.getConexao();

        try(PreparedStatement pst = con.prepareStatement(
                   "insert into funcionario(id, nome, valor_hora, cpf, rg, "
                           + "data_nascimento, status_func, genero)" +
                           "values (0,?,?,?,?,?,?,?)"
           )){
            pst.setString(1, funcionario.getNome());
            pst.setFloat(2, funcionario.getValor_hora());
            pst.setString(3, funcionario.getCpf());
            pst.setString(4, funcionario.getRg());
            pst.setDate(5, funcionario.getData_nascimento());
            pst.setBoolean(6, funcionario.isStatus_func());
            pst.setString(7, Character.toString(funcionario.getGenero().charAt(0)));
            

            //Executa o codigo acima
            pst.executeUpdate();
         }

        Statement st = con.createStatement(); 
        //executa o cod abaixo
        ResultSet rs = st.executeQuery("select last_insert_id()") ;

        if (rs.next()){
            funcionario.setId(rs.getInt(1));
        } 
    conexao.close();
    }
    
    
}
