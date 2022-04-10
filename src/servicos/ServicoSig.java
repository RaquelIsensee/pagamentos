/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import classes.SalarioMensal;

/**
 *
 * @author raquel.silva2
 */
public class ServicoSig {

    private final Conexao conexao = new Conexao();  
    Connection con = conexao.getConexao();

       public int horasTrabalhadasnoMes(String data)throws SQLException{
        int horas = 0 ;
        try (Statement st = conexao.getConexao().createStatement(); 
        		
                ResultSet rs = st.executeQuery
               ("select SUM(horas_trabalhadas) as \"horas_mes\"  from salario_mensal where mes = '" + data + "'")){
            while (rs.next()){
            	horas = rs.getInt("horas_mes");
            }
        }

        return horas;
    }
    
      public void faturamento(String data) throws SQLException{
      int hrs =  this.horasTrabalhadasnoMes(data);
      double faturamento = ((8* 33.33) * hrs);
      faturamento = faturamento  - (((4 *  hrs) * 20) + (faturamento * 0.3));

      JOptionPane.showMessageDialog(null, "Valor do lucro atual: " + faturamento);
     }

}
