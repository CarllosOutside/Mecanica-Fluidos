/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fenomenotransporte;

import java.awt.Dimension;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author peterpc
 */
public class tela extends JFrame {
    /**
     * Creates new form tela
     */
    
    
     double img;
    
    public tela(double L, double gamma_liquido, double h, int opcao) {
       //escolhendo domínio da função
         double x = h;
         String titulo="";
         String labelx="";
         String labely="";
         String legenda="";
         int pontos=0; int passo=0;
         
       switch(opcao){
           case 1: {x = h; //alturaXbase
           titulo = "Largura da base da parede em função da altura do líquido";
           labelx = "Altura h do líquido (m)"; 
           labely = "Largura da base (m)";
           legenda = "b (m)";
           pontos = 10;
           passo = 1;} 
           break;
           case 2: {x = h; //alturaxPontosDeaplicacao
           titulo = "Altura de Aplicação da força exercida pelo líquido (em relação ao solo)"; 
           labelx = "Altura h da parede/Líquido (m)"; 
           labely = "Altura de aplicação (m)";
           legenda = "Ycp (m)";
           pontos = 10;
           passo = 1;} 
           break;
           case 3: {x = gamma_liquido; //PespecificoLiquidoXbase
           titulo = "Largura da base da parede em função do peso específico do Líquido";
           labelx = "Peso específico (kN/m^3))"; 
           labely = "Largura da base (m)";
           legenda = "b (m)";
           pontos = 10;
           passo = 10;} ; // gammaLiquidoXbase
           break;
           case 4: {x = gamma_liquido; //PespecificoLiquidoXIntensidadeForça
           titulo = "Intensidade da força hisdrostática em função do peso específico do líquido";
           labelx = "Peso específico (kN/m^3))"; 
           labely = "Intensidade da força (kN)";
           legenda = "F (kN)";
           pontos = 10;
           passo = 1;} ; 
           break;
           case 5: {x = L; //Comprimento da paredeXIntensidadeForça
           titulo = "Intensidade da força na parede em função do comprimento L";
           labelx = "Comprimento da parede (m))"; 
           labely = "Intensidade da força (kN)";
           legenda = "F (kN)";
           pontos = 10;
           passo = 1;} ; 
           break;
           case 6: {x = h; //hX Intensidade da força
           titulo = "Intensidade da força exercida na parede em função da altura do líquido";
           labelx = "Peso específico (kN/m^3))"; 
           labely = "Altura do líquido/Parede (m)";
           legenda = "F (kN)";
           pontos = 10;
           passo = 10;} ;
           break;
       }
      
        //pares ordenados, onde a imagem é calculada de acordo com o dominio
        XYSeries Goals = new XYSeries(legenda);
        for(int i = 0; i<pontos; i++){ //calcula um limite de dominios, com um passo dado (distancia entre pontos calculados)
            Goals.add(x+(i*passo), imagem(x+(i*passo), opcao, L, gamma_liquido, h));
        }
        
        //coleção de pares ordenados
        XYDataset xyDataset = new XYSeriesCollection(Goals);
        //gráfico valores discretos
        JFreeChart chart = ChartFactory.createScatterPlot(
            titulo, labelx, labely,
            xyDataset, PlotOrientation.VERTICAL, true, true, false);
         XYPlot plot = chart.getXYPlot();
    XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
    renderer.setDefaultLinesVisible(true);
        ChartPanel cp = new ChartPanel(chart) {

            public Dimension getPreferredSize() {
                return new Dimension(480, 320);
            }
        };
        cp.setMouseWheelEnabled(true);
        add(cp);
        pack();
    }


    public double imagem(double x, int opcao, double L, double gamma_liquido, double h){
    CalculaResultados calc = new CalculaResultados();
   
        if(opcao == 1) // alturaxbase
            img = calc.LarguraBase(gamma_liquido, x); //onde x = altura, gamma fixo
        if(opcao == 2) //alturaXpontoAplicacao
            img = calc.PontoDeAplicacao(x, L); //x=altura, L = comprimento, fixo
        if(opcao == 3) //gamma_liquidoxbase
            img = calc.LarguraBase(x, h); //onde x=gamma, altura fixa
        if(opcao == 4) //PespecificoLiquidoXIntensidadeForça
            img = calc.IntensidadeForca(x, h, L); //altura e L fixos, peso especifico varia
        if(opcao == 5) //Comprimento da paredeXIntensidadeForça
            img = calc.IntensidadeForca(gamma_liquido, h, x); //peso e altura fixos, compriemnto varia
        if(opcao == 6) //h X Intensidade da força
            img = calc.IntensidadeForca(gamma_liquido, x, L); //peso e comprimento fixos, altura varia
        
        return img;
    }
    
    
    
    //Função que retorna ponto de aplicação da força em função de h(altura), em relação ao solo

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tela(1, 2, 3, 1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
