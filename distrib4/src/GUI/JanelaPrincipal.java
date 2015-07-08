/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Modelo.Colecionador;
import Modelo.ColecionadorEncontrado;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rafael
 */
public class JanelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form JanelaPrincipal
     */
    public JanelaPrincipal() {
        initComponents();
        Colecionador instancia = Colecionador.getInstancia();
        setTitle("Principal - " + instancia.getIdColecionador() + " - " + instancia.getNomeColecionador());
    }

    public static void atualizarTabela() {
        Colecionador instancia = Colecionador.getInstancia();
        ArrayList<ColecionadorEncontrado> usuarios = instancia.getListaParticipantes();
        Object[][] tabela = new Object[usuarios.size()][3];
        for (int i = 0; i < usuarios.size(); i++) {
            tabela[i][0] = usuarios.get(i).getIdColecionador();
            tabela[i][1] = usuarios.get(i).getNome();
            tabela[i][2] = usuarios.get(i).getNumeroCartoes();
        }

        //popularTabela
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                tabela,
                new String[]{
                    "ID Colecionador", "Nome", "Qtd. Cartões"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVisualizarCartoes = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnMeusCartoes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btnVisualizarCartoes.setText("Visualizar Cartões do Usuário Selecionado");
        btnVisualizarCartoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarCartoesActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Colecionador", "Nome", "Qtd. Cartões"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
        }

        btnMeusCartoes.setText("Meus Cartões");
        btnMeusCartoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMeusCartoesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMeusCartoes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVisualizarCartoes)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMeusCartoes)
                    .addComponent(btnVisualizarCartoes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVisualizarCartoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarCartoesActionPerformed
        try {
            int selecao = jTable2.getSelectedRow();
            if (selecao < 0) {
                JOptionPane.showMessageDialog(null, "É preciso selecionar um usuário na tabela.");
            } else {
                DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
                int quantidadeCartoes = (Integer) dtm.getValueAt(selecao, 2);
                if (quantidadeCartoes > 0) {
                    int idSelecionado = (Integer) dtm.getValueAt(selecao, 0);
                    JanelaCartoes jc = new JanelaCartoes(idSelecionado);
                    jc.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "O usuário selecionado não possui cartões.");
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(JanelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnVisualizarCartoesActionPerformed

    private void btnMeusCartoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMeusCartoesActionPerformed
        try {
            Colecionador instancia = Colecionador.getInstancia();
            JanelaCartoes jc = new JanelaCartoes(instancia.getIdColecionador());
            jc.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(JanelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMeusCartoesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMeusCartoes;
    private javax.swing.JButton btnVisualizarCartoes;
    private static javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
