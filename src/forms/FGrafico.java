package forms;

import classes.SalarioMensal;
import servicos.ServicoGrafico;
import servicos.ServicoSalarioMensal;

import java.awt.event.ItemEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class FGrafico extends javax.swing.JFrame {
	String pontoInicial, pontoFinal;
    ServicoSalarioMensal servicosalariomensal = new ServicoSalarioMensal();
	FGraficoVisual fgraficovisual;
    ServicoGrafico servicoGrafico = new ServicoGrafico();

    public FGrafico() {
    	initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	
        lblDataInicial = new JLabel("Data Inicial:");
        JDataInicial = new javax.swing.JComboBox<>();
        JDataInicial.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jPeriodosItemStateChanged(evt);
            }
        });
        
        jSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        jSair.setText("Sair");
        jSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSairMouseClicked(evt);
            }
        });
        
        lblDataFinal = new JLabel("Data Final:");
        JDataFinal = new javax.swing.JComboBox<>();
        JDataFinal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jPeriodosItemStateChanged(evt);
            }
        });

        JButton btnGerarGrafico = new JButton("Gerar Grafico");
        btnGerarGrafico.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
				
        		System.out.println("start");
	    		
        		try {
	    			
	    			String dataInicial = JDataInicial.getSelectedItem().toString().substring(9, 16);
	    			String dataFinal = JDataFinal.getSelectedItem().toString().substring(9, 16);
	    			
					System.out.println("data inicial " + dataInicial);
					System.out.println("data final " + dataFinal);
	    			
					ArrayList<SalarioMensal> listaGrafico = servicoGrafico.PagamentosGrafico(dataInicial, dataFinal);
					
					if (fgraficovisual == null){
						fgraficovisual = new FGraficoVisual();
					}
					fgraficovisual.setListaGrafico(listaGrafico);
					fgraficovisual.setVisible(true);
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
		    }
        });
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(lblDataFinal)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(JDataFinal, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE))
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(lblDataInicial)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(JDataInicial, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE))))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(22)
        					.addComponent(btnGerarGrafico)
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(jSair)))
        			.addGap(31))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(JDataInicial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblDataInicial))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(JDataFinal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblDataFinal))
        			.addPreferredGap(ComponentPlacement.RELATED, 225, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jSair)
        				.addComponent(btnGerarGrafico))
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSairMouseClicked
        dispose();
    }//GEN-LAST:event_jSairMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
    ArrayList<SalarioMensal> lista = new ArrayList<>();
        
    if (JDataInicial.getItemCount() > 0){
        JDataInicial.removeAllItems();

    }
        try {
            lista = servicosalariomensal.getSalarioByLista();
        } catch (SQLException ex) {
            Logger.getLogger(FCalcSalarioMensal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        if (JDataFinal.getItemCount() > 0){
        	JDataFinal.removeAllItems();

        }
            try {
                lista = servicosalariomensal.getSalarioByLista();
            } catch (SQLException ex) {
                Logger.getLogger(FCalcSalarioMensal.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
    lista.forEach((u) -> {
        JDataInicial.addItem(u);
        JDataFinal.addItem(u);
        
     }); 
    
   JDataInicial.setSelectedIndex(-1);
   JDataFinal.setSelectedIndex(-1);

    }//GEN-LAST:event_formWindowActivated
    private void jPeriodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jPeriodosItemStateChanged
        if (JDataInicial.getSelectedIndex() >= 0){
     int mes, ano;
     SalarioMensal salariomensal;
     salariomensal = (SalarioMensal) JDataInicial.getSelectedItem();

     ano = Integer.parseInt(salariomensal.toString().substring(9, 13));
     mes = Integer.parseInt((salariomensal.toString().substring(15, 16)));
     try {
         pontoInicial = (Float.toString(servicosalariomensal.getSalarioTotalByMes(mes, ano)));
     } catch (SQLException ex) {
         Logger.getLogger(FConsultSalariobyMes.class.getName()).log(Level.SEVERE, null, ex);
     }
     }
        
     if (JDataFinal.getSelectedIndex() >= 0){
     int mes, ano;
     SalarioMensal salariomensal;
     salariomensal = (SalarioMensal) JDataFinal.getSelectedItem();

     ano = Integer.parseInt(salariomensal.toString().substring(9, 13));
     mes = Integer.parseInt((salariomensal.toString().substring(15, 16)));
     try {
         pontoFinal = (Float.toString(servicosalariomensal.getSalarioTotalByMes(mes, ano)));
     } catch (SQLException ex) {
         Logger.getLogger(FConsultSalariobyMes.class.getName()).log(Level.SEVERE, null, ex);
     }
     }
 
 }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FGrafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FGrafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FGrafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FGrafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FGrafico().setVisible(true);
            }
        });
    }
    private javax.swing.JComboBox<SalarioMensal> JDataInicial;
    private javax.swing.JButton jSair;
    private JLabel lblDataInicial;
    private JComboBox<SalarioMensal> JDataFinal;
    private JLabel lblDataFinal;
}
