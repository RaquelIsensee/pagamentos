package forms;

import classes.SalarioMensal;
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


public class FGraficoVisual extends javax.swing.JFrame {

    ServicoSalarioMensal servicosalariomensal = new ServicoSalarioMensal();
    
    public FGraficoVisual() {
        
		//Cria um dataSet para inserir os dados que serão passados para a criação do gráfico tipo Pie
		DefaultPieDataset pieDataset = new DefaultPieDataset();
		
		//servicoGrafico.getDados();
		   
		//Adiciona os dados ao dataSet deve somar um total de 100%
		pieDataset.setValue("A", new Integer(75));
		pieDataset.setValue("B", new Integer(10));
		pieDataset.setValue("C", new Integer(10));
		pieDataset.setValue("D", new Integer(5));
		   
		//Cria um objeto JFreeChart passando os seguintes parametros
		JFreeChart grafico = ChartFactory.createPieChart(
		"Titulo Do Grafico", //Titulo do grafico
		pieDataset, //DataSet
		true, //Para mostrar ou não a legenda
		true, //Para mostrar ou não os tooltips
		false);
		       
		this.add( new ChartPanel( grafico ) );
		
		pack();
		
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FGraficoVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FGraficoVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FGraficoVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FGraficoVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FGraficoVisual().setVisible(true);
            }
        });
        
    }
}
