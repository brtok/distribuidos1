/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Janela de início do cliente
 * @author Bruno Tokarski e Rafael Vidal
 */
public class InicialClient extends javax.swing.JFrame {

    /**
     * Creates new form InicialClient
     */
    public InicialClient() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLocarCarro = new javax.swing.JButton();
        btnRegistrarInteresse = new javax.swing.JButton();
        btnLocacoes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cliente");

        btnLocarCarro.setText("Locar Carro");
        btnLocarCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocarCarroActionPerformed(evt);
            }
        });

        btnRegistrarInteresse.setText("Registrar interesse em eventos de um Carro");
        btnRegistrarInteresse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarInteresseActionPerformed(evt);
            }
        });

        btnLocacoes.setText("Ver Locações");
        btnLocacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocacoesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLocarCarro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrarInteresse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLocacoes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLocarCarro)
                    .addComponent(btnRegistrarInteresse)
                    .addComponent(btnLocacoes))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Efetuar a locação de um carro
     * @param evt acionamento do botão "Locar Carro"
     */
    private void btnLocarCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocarCarroActionPerformed
        try {
            JanelaLocacaoVeiculo jlv = new JanelaLocacaoVeiculo();
            jlv.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(InicialClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLocarCarroActionPerformed

    /**
     * Registrar interesse nos eventos de um determinado veículo
     * @param evt acionamento do botão "Registrar Interesse"
     */
    private void btnRegistrarInteresseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarInteresseActionPerformed
        try {
            JanelaInteresseEventos jie = new JanelaInteresseEventos();
            jie.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(InicialClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRegistrarInteresseActionPerformed

    /**
     * Visualizar locações para um determinado veículo
     * @param evt acionamento do botão "Ver Locações"
     */
    private void btnLocacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocacoesActionPerformed
        try {
            JanelaRelatorioLocacoes jrl = new JanelaRelatorioLocacoes();
            jrl.setVisible(true);
            jrl.repaint();
        } catch (Exception ex) {
            Logger.getLogger(InicialClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLocacoesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLocacoes;
    private javax.swing.JButton btnLocarCarro;
    private javax.swing.JButton btnRegistrarInteresse;
    // End of variables declaration//GEN-END:variables
}
