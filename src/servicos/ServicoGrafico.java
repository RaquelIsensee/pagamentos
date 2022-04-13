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
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import classes.SalarioMensal;
import servicos.ServicoSalarioMensal;

/**
 *
 * @author raquel.silva2
 */
public class ServicoGrafico {

    private final Conexao conexao = new Conexao();  
    Connection con = conexao.getConexao();

    
    public ArrayList<SalarioMensal> PagamentosGrafico(String dataInicial, String dataFinal)throws SQLException{
        ArrayList<SalarioMensal> listaGrafico = new ArrayList<>();
        System.out.println("SELECT * FROM salario_mensal WHERE mes >= '"+dataInicial + "-01' AND mes <= '"+dataFinal + "-01'");
        try (Statement st = conexao.getConexao().createStatement(); 
             ResultSet rs = st.executeQuery
             ("SELECT * FROM salario_mensal WHERE mes >= '"+dataInicial + "-01' AND mes <= '"+dataFinal + "-01'")){
 
        while (rs.next()){
          listaGrafico.add(new SalarioMensal(rs.getInt("id"), rs.getDate("mes"), rs.getFloat("valor")));
            }
        }
        
         return listaGrafico;
    }
    
    
}
