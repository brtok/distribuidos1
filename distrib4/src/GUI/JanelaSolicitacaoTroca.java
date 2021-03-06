/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Comunicacao.RMIClient;
import IOarquivo.IOCartao;
import IOarquivo.IOColecionador;
import Modelo.Cartao;
import Modelo.Colecionador;
import Modelo.ColecionadorEncontrado;
import Modelo.Troca;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class JanelaSolicitacaoTroca extends javax.swing.JFrame {

    Cartao meuCartao;
    Cartao outroCartao;
    int idOutroColecionador;

    /**
     * Creates new form SolicitacaoTroca
     */
    public JanelaSolicitacaoTroca() {
        initComponents();
    }

    public JanelaSolicitacaoTroca(Cartao outroCartao, int idOutroColecionador) throws Exception {
        initComponents();
        this.outroCartao = outroCartao;
        this.idOutroColecionador = idOutroColecionador;

        lblCartaoProposto.setText(outroCartao.getIdCartao() + " - " + outroCartao.getLocal());

        PopulaComboBox();

    }

    public void PopulaComboBox() throws Exception {
        IOCartao iocar = new IOCartao();
        ArrayList<Cartao> cartoes = iocar.RecuperarCartoes();

        for (Cartao c : cartoes) {
            String item = c.getIdCartao() + " - " + c.getLocal();
            cbMeusCartoes.addItem(item);
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

        jLabel1 = new javax.swing.JLabel();
        lblCartaoProposto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbMeusCartoes = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        btnConfSolicitacaoTroca = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Solicitando Troca");

        lblCartaoProposto.setEditable(false);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Trocar o meu cartão");

        cbMeusCartoes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "(Selecione)" }));
        cbMeusCartoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMeusCartoesActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("pelo cartão");

        btnConfSolicitacaoTroca.setText("Confirma Solicitação de Troca");
        btnConfSolicitacaoTroca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfSolicitacaoTrocaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblCartaoProposto)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbMeusCartoes, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConfSolicitacaoTroca)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbMeusCartoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCartaoProposto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnConfSolicitacaoTroca)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbMeusCartoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMeusCartoesActionPerformed

    }//GEN-LAST:event_cbMeusCartoesActionPerformed

    private void btnConfSolicitacaoTrocaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfSolicitacaoTrocaActionPerformed

        try {
            
            Colecionador logado = Colecionador.getInstancia();

            if (cbMeusCartoes.getSelectedItem().equals("(Selecione)")) {
                JOptionPane.showMessageDialog(null, "Selecione um cartão.");
            } else {
                String itemSelecionado = (String) cbMeusCartoes.getSelectedItem();
                String txtItemSelecionado[] = itemSelecionado.split(" ");

                int idCartaoSelecionado = Integer.parseInt(txtItemSelecionado[0]);
                
                IOCartao iocar = new IOCartao();
                meuCartao = iocar.RecuperarCartaoPorID(idCartaoSelecionado);

                IOColecionador iocol = new IOColecionador();
                Colecionador solicitado = iocol.RecuperaColecionadorPorID(idOutroColecionador);
                
                Troca troca = new Troca();
                troca.setCartaoManda(meuCartao);
                troca.setCartaoRecebe(outroCartao);
                troca.setSituacaoTroca(1);
                troca.setSolicitante(logado);
                troca.setSolicitado(solicitado);
                
                RMIClient rmic = new RMIClient();
                ColecionadorEncontrado conexao = logado.getUsuarioParticipantePorId(idOutroColecionador);
                rmic.IniciaRMI(conexao);

<<<<<<< HEAD
=======
		dispose();
>>>>>>> origin/master
                rmic.EnviaProposta(troca);

            }

            //cartoes = rmic.SolicitaListaCartoes(idUsuario);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_btnConfSolicitacaoTrocaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfSolicitacaoTroca;
    private javax.swing.JComboBox cbMeusCartoes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField lblCartaoProposto;
    // End of variables declaration//GEN-END:variables
}
