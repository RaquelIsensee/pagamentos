package forms;

import classes.Funcionario;
import classes.SalarioMensal;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import servicos.ServicoFuncionario;
import servicos.ServicoSalarioMensal;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import servicos.ServicoSig;

public class FLucroAtual extends javax.swing.JFrame {
    ServicoFuncionario servicofuncionario = new ServicoFuncionario();
    ServicoSalarioMensal servicoSalario = new ServicoSalarioMensal();
    ServicoSig servicosig = new ServicoSig();

    SalarioMensal salarioMensal;

    public FLucroAtual() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel2 = new javax.swing.JLabel();
        jData = new javax.swing.JComboBox<>();
        jCalcular = new javax.swing.JButton();
        jCalcular.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	}
        });
        jSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel2.setText("Data");

        jCalcular.setText("Calcular");
        jCalcular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
					jCalcularMouseClicked(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        jSair.setText("Sair");
        jSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	jSairMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jLabel2)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jData, 0, 323, Short.MAX_VALUE))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jCalcular)
        					.addPreferredGap(ComponentPlacement.RELATED, 232, Short.MAX_VALUE)
        					.addComponent(jSair, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel2))
        			.addPreferredGap(ComponentPlacement.RELATED, 223, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jCalcular, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jSair, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
    ArrayList<String> lista = new ArrayList<>();
        
    if (jData.getItemCount() > 0){
        jData.removeAllItems();

    }
        try {
            lista = servicoSalario.getDatas();
        } catch (SQLException ex) {
            Logger.getLogger(FLucroAtual.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    lista.forEach((u) -> {
        jData.addItem(u);
     }); 
   jData.setSelectedIndex(-1);
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(FLucroAtual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FLucroAtual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FLucroAtual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FLucroAtual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FLucroAtual().setVisible(true);
            }
        });
    }
    @SuppressWarnings("unused")
	private void jSairMouseClicked(java.awt.event.MouseEvent evt) {
        dispose();
    } 
    
	private void jCalcularMouseClicked(java.awt.event.MouseEvent evt) throws SQLException {
		String dataSelecionada = (String) jData.getSelectedItem();
		servicosig.faturamento(dataSelecionada);
    } 
    private javax.swing.JButton jCalcular;
    private javax.swing.JComboBox<String> jData;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jSair;
}
