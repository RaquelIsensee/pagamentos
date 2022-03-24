package servicos;
import classes.Funcionario;
	import classes.SalarioMensal;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
import java.util.ArrayList;
	
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
            
            
            public ArrayList<SalarioMensal> getSalarioByLista()throws SQLException{
                ArrayList<SalarioMensal> lista = new ArrayList<>();
                try (Statement st = conexao.getConexao().createStatement(); 
                     ResultSet rs = st.executeQuery
                    ("select * from salario_mensal group by mes")) {
         
                while (rs.next()){
                  lista.add(new SalarioMensal(rs.getInt("id"), rs.getDate("mes"),
                  rs.getFloat("valor")));
                    }
                }
    
                 return lista;
            }
            
            public float getSalarioTotalByMes(int mes, int ano)throws SQLException{
                float valortotal = 0;
                try (Statement st = conexao.getConexao().createStatement(); 
                     ResultSet rs = st.executeQuery
                    ("select SUM(valor) as \"valor_total\"  from salario_mensal where MONTH(mes)="+mes+" and year(mes)=" + ano)) {
                    
                    while (rs.next()){
                    valortotal = rs.getFloat("valor_total");
                    }
                }

                return valortotal;
            }
            
	}
