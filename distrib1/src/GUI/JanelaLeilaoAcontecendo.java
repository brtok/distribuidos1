/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Comunicação.ComunicacaoEnviaLance;
import Comunicação.MinhaComunicacaoEnvio;
import Modelo.Conexao;
import Modelo.Lance;
import Modelo.Livro;
import Modelo.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class JanelaLeilaoAcontecendo extends javax.swing.JFrame {

    private Lance lance;
    private static JanelaLeilaoAcontecendo instancia;
    
    public JanelaLeilaoAcontecendo()
    {
        initComponents();
    }

    public JanelaLeilaoAcontecendo(Lance lance) {
        initComponents();
        this.lance = lance;
        Usuario usuario = Usuario.getInstancia();
        setTitle(usuario.getIdPublica() + " - O livro recebeu um lance!");
        Livro leilaoAtual = Conexao.getInstancia().getLeilaoAtual();
        labelCodigo.setText(leilaoAtual.getCodigo());
        labelDescricao.setText(leilaoAtual.getDescricao());
        labelMaiorLance.setText(lance.getValorOferecidoString());
        labelNome.setText(leilaoAtual.getNome());
        labelPrecoInicial.setText(leilaoAtual.getPrecoInicialString());
        labelTempoRestante.setText(String.valueOf(leilaoAtual.getTempoTotalLeilao() - lance.getTempoNaHora()));
        if ((usuario.getIdPublica().equalsIgnoreCase(lance.getIdPublicaQuemOfereceu())) && usuario.getIdRede() == lance.getIdRedeQuemOfereceu()) {
            botaoDarLance.setVisible(false);
            botaoNaoDarLance.setText("OK");
            labelLance.setVisible(false);
            txtValorLance.setVisible(false);
        } else {
            botaoFinalizar.setVisible(false);
        }
    }
    
    public void AtualizaJanela()
    {        
        LimparCampos();
        Usuario usuario = Usuario.getInstancia();
        setTitle(usuario.getIdPublica() + " - O livro recebeu um lance!");
        Livro leilaoAtual = Conexao.getInstancia().getLeilaoAtual();
        labelCodigo.setText(leilaoAtual.getCodigo());
        labelDescricao.setText(leilaoAtual.getDescricao());
        labelMaiorLance.setText(lance.getValorOferecidoString());
        labelNome.setText(leilaoAtual.getNome());
        labelPrecoInicial.setText(leilaoAtual.getPrecoInicialString());
        labelTempoRestante.setText(String.valueOf(leilaoAtual.getTempoTotalLeilao() - lance.getTempoNaHora()));
        if ((usuario.getIdPublica().equalsIgnoreCase(lance.getIdPublicaQuemOfereceu())) && usuario.getIdRede() == lance.getIdRedeQuemOfereceu()) {
            botaoDarLance.setVisible(false);
            botaoNaoDarLance.setText("OK");
            labelLance.setVisible(false);
            txtValorLance.setVisible(false);
        } else {
            botaoFinalizar.setVisible(false);
        }
        //this.repaint();
    }
    
    public void LimparCampos()
    {
        labelCodigo.setText(null);
        labelDescricao.setText(null);
        labelMaiorLance.setText(null);
        labelNome.setText(null);
        labelPrecoInicial.setText(null);
        labelTempoRestante.setText(null);
    }
    
    //Notifica o participante quando um novo lance é recebido
    public void NotificaoNovoLance()
    {
        JOptionPane.showMessageDialog(null, "Novo Lance de " + lance.getIdPublicaQuemOfereceu());
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
        labelCodigo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelDescricao = new javax.swing.JLabel();
        labelPrecoInicial = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelMaiorLance = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        labelTempoRestante = new javax.swing.JLabel();
        botaoDarLance = new javax.swing.JButton();
        botaoNaoDarLance = new javax.swing.JButton();
        botaoFinalizar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtValorLance = new javax.swing.JTextField();
        labelLance = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Código:");

        labelCodigo.setText("labelCodigo");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nome:");

        labelNome.setText("labelNome");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Descrição:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Preço Inicial:");

        labelDescricao.setText("labelDescricao");

        labelPrecoInicial.setText("labelPrecoInicial");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Último Lance Dado:");

        labelMaiorLance.setText("labelMaiorLance");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Tempo Restante:");

        labelTempoRestante.setText("labelTempoRestante");

        botaoDarLance.setText("Dar o Lance");
        botaoDarLance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDarLanceActionPerformed(evt);
            }
        });

        botaoNaoDarLance.setText("Não dar um Lance");
        botaoNaoDarLance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNaoDarLanceActionPerformed(evt);
            }
        });

        botaoFinalizar.setText("Finalizar Leilão");
        botaoFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoFinalizarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("<html><center>Um novo lance foi dado no leilão<br>que você está participando</center>");

        labelLance.setText("Lance:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelPrecoInicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelMaiorLance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelTempoRestante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(labelLance)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValorLance))
                            .addComponent(botaoDarLance, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoNaoDarLance)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(labelNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(labelDescricao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(labelPrecoInicial))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(labelMaiorLance))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTempoRestante))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValorLance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelLance))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoFinalizar)
                    .addComponent(botaoDarLance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoNaoDarLance))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoDarLanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDarLanceActionPerformed
        try {
            if (Double.parseDouble(txtValorLance.getText().replaceAll(",", "\\.")) > lance.getValorOferecido()) {
                Usuario usuarioLocal = Usuario.getInstancia();
                Lance novoLance = new Lance(usuarioLocal.getIdPublica(), usuarioLocal.getIdRede(), 0);
                novoLance.setValorOferecidoString(txtValorLance.getText());
                ComunicacaoEnviaLance envia = new ComunicacaoEnviaLance(novoLance, labelCodigo.getText());
                envia.start();
                JOptionPane.showMessageDialog(null, "Lance efetuado com sucesso!");
                //dispose();
            } else {
                JOptionPane.showMessageDialog(null, "O valor do lance deve ser maior que o valor atual!");
            }
        } catch (Exception ex) {
            Logger.getLogger(JanelaLeilaoAcontecendo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botaoDarLanceActionPerformed

    private void botaoNaoDarLanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNaoDarLanceActionPerformed
        dispose();
    }//GEN-LAST:event_botaoNaoDarLanceActionPerformed

    private void botaoFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFinalizarActionPerformed
        Usuario u = Usuario.getInstancia();
        if (u.getPapel().equalsIgnoreCase("servidor")) {
            Conexao c = Conexao.getInstancia();
            c.setStatusLeilao("finalizando");
        } else {
            MinhaComunicacaoEnvio envia = new MinhaComunicacaoEnvio();
            envia.setMensagem("15#" + u.getIdPublica() + "#" + u.getIdRede());
            envia.start();
        }
        setVisible(false);
        EncerrarLeilao el = EncerrarLeilao.getInstancia();
        el.setVisible(false);
    }//GEN-LAST:event_botaoFinalizarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoDarLance;
    private javax.swing.JButton botaoFinalizar;
    private javax.swing.JButton botaoNaoDarLance;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelDescricao;
    private javax.swing.JLabel labelLance;
    private javax.swing.JLabel labelMaiorLance;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelPrecoInicial;
    private javax.swing.JLabel labelTempoRestante;
    private javax.swing.JTextField txtValorLance;
    // End of variables declaration//GEN-END:variables

    public static JanelaLeilaoAcontecendo getInstancia() {
        if(instancia == null)
        {
            instancia = new JanelaLeilaoAcontecendo();
        }
        return instancia;
    }

    public static void setInstancia(JanelaLeilaoAcontecendo instancia) {
        JanelaLeilaoAcontecendo.instancia = instancia;
    }

    public Lance getLance() {
        return lance;
    }

    public void setLance(Lance lance) {
        this.lance = lance;
    }
    
    

}
