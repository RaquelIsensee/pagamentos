package servicos;

import classes.Funcionario;
import classes.SalarioMensal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
    
  public ArrayList<Funcionario> getFuncionarioByLista()throws SQLException{
      ArrayList<Funcionario> lista = new ArrayList<>();
     try (Statement st = conexao.getConexao().createStatement(); 
            ResultSet rs = st.executeQuery
             ("select * from funcionario order by nome")) {
         
        while (rs.next()){
          lista.add(new Funcionario(rs.getInt("id"), rs.getString("nome"),
                  rs.getFloat("valor_hora"), rs.getString("cpf"), rs.getString("rg"), 
                  rs.getDate("data_nascimento"),rs.getBoolean("status_func"), rs.getString("genero")));
        }
    }
    
     return lista;
 }
    
  public void calcularSalarioMensal(SalarioMensal salario_mensal) throws SQLException{
       Connection con = conexao.getConexao();
        try(PreparedStatement pst = con.prepareStatement(
                   "insert into salario_mensal(id, mes, valor, id_funcionario "
                            +"values (0,?,?,?)"
     )){
            
            pst.setDate(1, salario_mensal.getMes());
            pst.setFloat(2, salario_mensal.getValor());
            pst.setInt(3, salario_mensal.getFuncionario().getId());
            pst.executeUpdate();
            
    } 
    Statement st = con.createStatement(); 
    //executa o cod abaixo
    ResultSet rs = st.executeQuery("select last_insert_id()") ;

    if (rs.next()){
        salario_mensal.setId(rs.getInt(1));
    } 
        conexao.close();
  }

    
}
