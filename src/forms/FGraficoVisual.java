package forms;

import classes.SalarioMensal;
import servicos.ServicoSalarioMensal;
import servicos.ServicoGrafico;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
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
	ArrayList<SalarioMensal> listaGrafico;
    ServicoSalarioMensal servicosalariomensal = new ServicoSalarioMensal();
    
    public ArrayList<SalarioMensal> getListaGrafico() {
		return listaGrafico;
	}


	public void setListaGrafico(ArrayList<SalarioMensal> listaGrafico) {
		System.out.println(listaGrafico);
		this.listaGrafico = listaGrafico;
	}


	public FGraficoVisual() {
	
		System.out.println(listaGrafico);
		
		FGraficoVisual self = this;
		
		this.addComponentListener(new ComponentAdapter() {
		    public void componentShown(ComponentEvent e) {
		       DefaultPieDataset pieDataset = new DefaultPieDataset();
		
				for (int i = 0; i < self.listaGrafico.size(); i++) {
					SalarioMensal salarioMensal = self.listaGrafico.get(i);
					pieDataset.setValue(salarioMensal.getMes(), salarioMensal.getValor());
					System.out.println(salarioMensal.getMes());
					System.out.println(salarioMensal.getValor());
				}
				   
				//Cria um objeto JFreeChart passando os seguintes parametros
				JFreeChart grafico = ChartFactory.createPieChart(
				"Titulo Do Grafico", //Titulo do grafico
				pieDataset, //DataSet
				true, //Para mostrar ou não a legenda
				true, //Para mostrar ou não os tooltips
				false);
				       
				self.add( new ChartPanel( grafico ) );
				System.out.println("add");
				
				self.pack();
		    }
		    
		});
		
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
