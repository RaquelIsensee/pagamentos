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
       

    
   public double faturamentoReal(String data) throws SQLException{
       int hrsMedia =  this.horasTrabalhadasnoMes(data) / 4;
       double faturamentoReal = (48000 * hrsMedia / 200);

       return faturamentoReal;
   }   
   
   public double custoOperacionalTotal(String data) throws SQLException{
       double faturamentoReal = faturamentoReal(data);
       double custoOperacionalTotal = faturamentoReal * 0.30;
       return custoOperacionalTotal;
   }     
   
   public double faturamentoPorMaquinaVelha(String data) throws SQLException{
       double faturamentoReal = faturamentoReal(data);
       double faturamentoPorMaquinaVelha = faturamentoReal / 8;
       return faturamentoPorMaquinaVelha;
   }
   
   public double faturamentoPorMaquinaNova(String data) throws SQLException{
       double faturamentoPorMaquinaVelha = faturamentoPorMaquinaVelha(data);
       double faturamentoPorMaquinaNova = faturamentoPorMaquinaVelha * 0.10
               + faturamentoPorMaquinaVelha;
       return faturamentoPorMaquinaNova;
       
   }
   
   public double custoOperacionalPorMaquinaVelha(String data) throws SQLException{
       double custoOperacionalTotal = custoOperacionalTotal(data);
       double custoOperacionalPorMaquinaVelha = custoOperacionalTotal / 8;
       return custoOperacionalPorMaquinaVelha;
   }
   
   public double custoOperacionalMaquinaNova(String data) throws SQLException{
       double custoOperacionalPorMaquinaVelha =
               custoOperacionalPorMaquinaVelha(data);
       double custoOperacionalMaquinaNova = custoOperacionalPorMaquinaVelha
               - custoOperacionalPorMaquinaVelha * 0.40;
       return custoOperacionalMaquinaNova;
   }
   
   public double mediaCustoMaoObraMaquina(String data) throws SQLException{
       double custoMaoObraTotal = custoMaoObraTotal(data);
      double mediaCustoMaoObraMaquina = (custoMaoObraTotal / 8) ;
      
      return mediaCustoMaoObraMaquina;
   }
   
   public double mediaCustoMaoObraMaquinaComAumento(String data) throws SQLException{
       double mediaCustoMaoObraMaquina = mediaCustoMaoObraMaquina(data);
       double mediaCustoMaoObraMaquinaComAumento = mediaCustoMaoObraMaquina *
               0.225 + mediaCustoMaoObraMaquina;
       
       return mediaCustoMaoObraMaquinaComAumento;
   }
   
   public double custoMaoObraTotalComAumento(String data) throws SQLException{
       double mediaCustoMaoObraMaquinaComAumento =
               mediaCustoMaoObraMaquinaComAumento(data);
       double custoMaoObraTotalComAumento = mediaCustoMaoObraMaquinaComAumento 
               * 8;
       
       return custoMaoObraTotalComAumento;
   }
   
   public double custoMaoObraTotal(String data) throws SQLException{
       return this.horasTrabalhadasnoMes(data) * 20;
   }
   
   public double custoMaoObraContratando(String data) throws SQLException{
      double mediaHorasTrabalhadas = this.horasTrabalhadasnoMes(data) / 4;
      double custoMaoObraTotal = custoMaoObraTotal(data);
      double custoMaoObraContratando = mediaHorasTrabalhadas * 20 + custoMaoObraTotal;
      
      return custoMaoObraContratando;
   }
   
    public double faturamento(String data) throws SQLException{
      double faturamento = faturamentoReal(data);
      double custoMaoObraTotal = custoMaoObraTotal(data);
      double custoOperacionalTotal = custoOperacionalTotal(data);
      double lucroAtual = faturamento  - custoMaoObraTotal - custoOperacionalTotal;

      return lucroAtual;
     }
    
    public double lucroSemContratar(String data) throws SQLException{
        double faturamentoReal = faturamentoReal(data);
        double custoOperacionalTotal = custoOperacionalTotal(data);
        double faturamentoPorMaquinaNova = faturamentoPorMaquinaNova(data);
        double custoOperacionalMaquinaNova = custoOperacionalMaquinaNova(data);;
        double custoMaoObraTotalComAumento = custoMaoObraTotalComAumento(data);
       
         
         return (faturamentoReal + faturamentoPorMaquinaNova) - 
                 custoOperacionalTotal - custoOperacionalMaquinaNova - 
                 custoMaoObraTotalComAumento;
         
     }
    
    public double lucroContratando(String data) throws SQLException{
        double faturamentoReal = faturamentoReal(data);
        double custoOperacionalTotal = custoOperacionalTotal(data);    
        double faturamentoPorMaquinaNova = faturamentoPorMaquinaNova(data);
        double custoOperacionalMaquinaNova = custoOperacionalMaquinaNova(data);
        double custoMaoObraContratando = custoMaoObraContratando(data);
        
        
        return (faturamentoReal + faturamentoPorMaquinaNova) -
                custoOperacionalTotal - custoOperacionalMaquinaNova -
                custoMaoObraContratando;
    }

}
