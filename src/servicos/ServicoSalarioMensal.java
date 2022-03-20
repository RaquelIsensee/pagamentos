package servicos;
	import classes.SalarioMensal;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	
public class ServicoSalarioMensal{

	    private final Conexao conexao = new Conexao();  
	    
	    public void insert(SalarioMensal salarioMensal) throws SQLException {
	        Connection con = conexao.getConexao();

	        try(PreparedStatement pst = con.prepareStatement(
	                   "insert into salario_mensal(id, mes, valor, id_funcionario) values (0,?,?,?)"
	           )){
	            pst.setDate(1, salarioMensal.getMes());
	            pst.setFloat(2, salarioMensal.getValor());
	            pst.setInt(3, salarioMensal.getFuncionario().getId());
	           
	            //Executa o codigo acima
	            pst.executeUpdate();
	         }

	        Statement st = con.createStatement(); 
	        //executa o cod abaixo
	        ResultSet rs = st.executeQuery("select last_insert_id()") ;

	        if (rs.next()){
	        	salarioMensal.setId(rs.getInt(1));
	        } 
	    conexao.close();
	    }
	}
