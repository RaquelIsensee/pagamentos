/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author raquel.silva2
 */
public class ServicoSig {

      public int horasTrabalhadas() {
        int horas;
        JPanel hrs = new JPanel();
        JTextField horasTrabalhadas = new JTextField(10);

    hrs.add(new JLabel("Horas trabalhadas :"));
    hrs.add(horasTrabalhadas);
    
     JOptionPane.showConfirmDialog(null, hrs, "Horas trabalhadas : ", JOptionPane.OK_CANCEL_OPTION);
     horas = Integer.parseInt(horasTrabalhadas.getText());
     return horas;
     
    }  
    
      public void faturamento(){
      int hrs =  horasTrabalhadas();
      double faturamento = ((8* 33.33) * hrs);
      faturamento = faturamento  - (((4 *  hrs) * 20) + (faturamento * 0.3));

      JOptionPane.showMessageDialog(null, "Valor do lucro atual: " + faturamento);
     }
}
