/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Comunicacao.RMICliente;
import Modelo.Locacao;
import Modelo.Veiculo;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
<<<<<<< HEAD
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
=======
>>>>>>> origin/master
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rafael
 */
public class JanelaLocacaoVeiculo extends javax.swing.JDialog {

    private ArrayList<Veiculo> veiculos;
    private Veiculo selecionado;

    /**
     * Creates new form JanelaCadastroVeiculo
     */
    public JanelaLocacaoVeiculo() throws Exception {
        initComponents();
        setModal(true);

        setContentPane(jPanel1);
        jPanel1.setVisible(true);
        RMICliente crmic = new RMICliente();
        veiculos = crmic.RecuperarVeiculos();
        Object[][] tabela = new Object[veiculos.size()][6];
        for (int i = 0; i < veiculos.size(); i++) {
            tabela[i][0] = veiculos.get(i).getIdVeiculo();
            tabela[i][1] = veiculos.get(i).getPlaca();
            tabela[i][2] = veiculos.get(i).getFabricante();
            tabela[i][3] = veiculos.get(i).getModelo();
            tabela[i][4] = veiculos.get(i).getAno();
            tabela[i][5] = veiculos.get(i).getValorDiariaString();
        }
        fazTabela(tabela);
    }

    public final void fazTabela(Object[][] tabela) {
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                tabela,
                new String[]{
                    "ID", "Placa", "Fabricante", "Modelo", "Ano", "Valor Diária"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(28);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(95);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(95);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(95);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(47);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(77);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        botaoAvancar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        labelLocalRetirada = new javax.swing.JTextField();
        labelLocalDevolucao = new javax.swing.JTextField();
        labelDataInicio = new javax.swing.JFormattedTextField();
        labelHorarioInicio = new javax.swing.JFormattedTextField();
        labelHorarioTermino = new javax.swing.JFormattedTextField();
        labelDataTermino = new javax.swing.JFormattedTextField();
        labelNomeCondutor = new javax.swing.JTextField();
        labelNumeroCartao = new javax.swing.JTextField();
        spinnerIdade = new javax.swing.JSpinner();
        spinnerParcelas = new javax.swing.JSpinner();
        botaoConfirmar = new javax.swing.JButton();
        labelDados = new javax.swing.JLabel();
        botaoVoltar = new javax.swing.JButton();

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Selecione um Veículo Cadastrado");

        botaoAvancar.setText("Avançar >>");
        botaoAvancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAvancarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Placa", "Fabricante", "Modelo", "Ano"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(42);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(115);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(115);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(115);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoAvancar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(botaoAvancar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Locação do Veículo");

        jLabel1.setText("Local de Retirada do Veículo:");

        jLabel2.setText("Local de Devolução do Veículo:");

        jLabel3.setText("Data de Início:");

        jLabel4.setText("Horário de Início:");

        jLabel5.setText("Horário de Término:");

        jLabel6.setText("Data de Término:");

        jLabel9.setText("Idade do Condutor:");

        jLabel10.setText("Número do Cartão:");

        jLabel11.setText("Nome:");

        jLabel12.setText("Número de Parcelas:");

        labelDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));

        labelHorarioInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));

        labelHorarioTermino.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));

        labelDataTermino.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));

        spinnerIdade.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(18), Integer.valueOf(18), null, Integer.valueOf(1)));

        spinnerParcelas.setModel(new javax.swing.SpinnerNumberModel(1, 1, 6, 1));

        botaoConfirmar.setText("Confirmar Locação");
        botaoConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConfirmarActionPerformed(evt);
            }
        });

        labelDados.setText("Dados do Veículo Selecionado");

        botaoVoltar.setText("<< Voltar e Escolher outro Carro");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(labelLocalDevolucao)
                                .addComponent(labelDataInicio)
                                .addComponent(labelHorarioInicio)
                                .addComponent(labelHorarioTermino)
                                .addComponent(labelDataTermino)
                                .addComponent(labelLocalRetirada)
                                .addComponent(labelNomeCondutor)
                                .addComponent(labelNumeroCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(spinnerIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spinnerParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(botaoVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoConfirmar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(labelDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelDados)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelLocalRetirada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(labelLocalDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(labelDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(labelHorarioInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(labelDataTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(labelHorarioTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(labelNomeCondutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(spinnerIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(spinnerParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(labelNumeroCartao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoConfirmar)
                    .addComponent(botaoVoltar))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar Veículo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 366, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(473, 405));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoAvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAvancarActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        int linha = jTable1.getSelectedRow();
        if (linha < 0) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar um carro, clicando na sua linha");
        } else {
            int codigo = (int) dtm.getValueAt(linha, 0);
            for (Veiculo v : veiculos) {
                if (v.getIdVeiculo() == codigo) {
                    selecionado = v;
                }
            }
            jPanel1.setVisible(false);
            this.setContentPane(jPanel2);
            jPanel2.setVisible(true);
            labelDados.setText(selecionado.getIdVeiculo() + " - " + selecionado.getFabricante() + " - "
                    + selecionado.getModelo() + " - " + selecionado.getAno() + " - " + selecionado.getPlaca());
        }
    }//GEN-LAST:event_botaoAvancarActionPerformed

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        jPanel2.setVisible(false);
        this.setContentPane(jPanel1);
        jPanel1.setVisible(true);
    }//GEN-LAST:event_botaoVoltarActionPerformed

    private void botaoConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmarActionPerformed
<<<<<<< HEAD
        try {
            Locacao loc = new Locacao();
            String dataInicio = labelDataInicio.getText();
            String horarioInicio = labelHorarioInicio.getText() + ":00";
            String dataTermino = labelDataTermino.getText();
            String horarioTermino = labelHorarioTermino.getText() + ":00";
            loc.setDataRetirada(Date.valueOf(dataInicio));
            loc.setHoraRetirada(Time.valueOf(horarioInicio));
            loc.setDataDevolucao(Date.valueOf(dataTermino));
            loc.setHoraDevolucao(Time.valueOf(horarioTermino));
            loc.setIdadeCondutor(Integer.parseInt(spinnerIdade.getValue().toString()));
            loc.setLocalDevolucao(labelLocalDevolucao.getText());
            loc.setLocalRetirada(labelLocalRetirada.getText());
            loc.setNomeCondutor(labelNomeCondutor.getText());
            loc.setNumeroCartao(labelNumeroCartao.getText());
            loc.setParcelasCartao(Integer.parseInt(spinnerParcelas.getValue().toString()));
            loc.setVeiculo(selecionado);
            if (loc.getDataDevolucao().before(loc.getDataRetirada())) {
                JOptionPane.showMessageDialog(null, "<html><center>Incorreto!<br>Data de devolução anterior a data de retirada.");
            } else {
                if (loc.getDataDevolucao().equals(loc.getDataRetirada()) && loc.getHoraDevolucao().before(loc.getHoraRetirada())) {
                    JOptionPane.showMessageDialog(null, "<html><center>Incorreto!<br>Hora de devolução anterior a hora de retirada.");
                } else {
                    java.util.Date hoje = new java.util.Date();
                    Calendar gregoriano = new GregorianCalendar();
                    String agoraString = gregoriano.get(Calendar.HOUR_OF_DAY) + ":" + gregoriano.get(Calendar.MINUTE) + ":00";
                    Time agora = Time.valueOf(agoraString);
                    if (hoje.after(loc.getDataRetirada())) {
                        JOptionPane.showMessageDialog(null, "<html><center>Incorreto!<br>A data de retirada é anterior ao dia de hoje.");
                    } else {
                        if (hoje.equals(loc.getDataRetirada()) && agora.after(loc.getHoraRetirada())) {
                            JOptionPane.showMessageDialog(null, "<html><center>Incorreto!<br>A hora de retirada já passou.");
                        } else {
                            RMICliente rmi = new RMICliente();
                            boolean sucesso = rmi.EfetuarLocacao(loc);
                            if (sucesso) {
                                JOptionPane.showMessageDialog(null, "Locação efetuada com sucesso.");
                                dispose();
                            } else {
                                JOptionPane.showMessageDialog(null, "<html><center>A locação solicitada não pode ser realizada.<br>"
                                        + "Na data e horário solicitados já foi feita uma reserva.");
                            }
                        }
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(JanelaLocacaoVeiculo.class.getName()).log(Level.SEVERE, null, ex);
        }

=======
        Locacao loc = new Locacao();
        String dataInicio = labelDataInicio.getText();
        String horarioInicio = labelHorarioInicio.getText() + ":00";
        String dataTermino = labelDataTermino.getText();
        String horarioTermino = labelHorarioTermino.getText() + ":00";
        loc.setDataRetirada(Date.valueOf(dataInicio));
        loc.setHoraRetirada(Time.valueOf(horarioInicio));
        loc.setDataDevolucao(Date.valueOf(dataTermino));
        loc.setHoraDevolucao(Time.valueOf(horarioTermino));
        loc.setIdadeCondutor(Integer.parseInt(spinnerIdade.getValue().toString()));
        loc.setLocalDevolucao(labelLocalDevolucao.getText());
        loc.setLocalRetirada(labelLocalRetirada.getText());
        loc.setNomeCondutor(labelNomeCondutor.getText());
        loc.setNumeroCartao(labelNumeroCartao.getText());
        loc.setParcelasCartao(Integer.parseInt(spinnerParcelas.getValue().toString()));
        loc.setVeiculo(selecionado);
        System.out.println(loc);
        
        try
        {
            RMICliente rmic = new RMICliente();
            rmic.EfetuarLocacao(loc);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        
>>>>>>> origin/master
    }//GEN-LAST:event_botaoConfirmarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAvancar;
    private javax.swing.JButton botaoConfirmar;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelDados;
    private javax.swing.JFormattedTextField labelDataInicio;
    private javax.swing.JFormattedTextField labelDataTermino;
    private javax.swing.JFormattedTextField labelHorarioInicio;
    private javax.swing.JFormattedTextField labelHorarioTermino;
    private javax.swing.JTextField labelLocalDevolucao;
    private javax.swing.JTextField labelLocalRetirada;
    private javax.swing.JTextField labelNomeCondutor;
    private javax.swing.JTextField labelNumeroCartao;
    private javax.swing.JSpinner spinnerIdade;
    private javax.swing.JSpinner spinnerParcelas;
    // End of variables declaration//GEN-END:variables
}
