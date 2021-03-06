/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Comunicacao.RMICliente;
import Modelo.Locacao;
import Modelo.Veiculo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Janela listando locações para um determinado veículo
 * @author Bruno Tokarski e Rafael Vidal
 */
public class JanelaRelatorioLocacoes extends javax.swing.JDialog {

    private ArrayList<Veiculo> veiculos;
    private Veiculo selecionado;
    private Object[][] tabelaVeiculos;

    /**
     * Creates new form JanelaCadastroVeiculo
     */
    public JanelaRelatorioLocacoes() throws Exception {
        initComponents();
        setModal(true);

        setContentPane(jPanel1);
        jPanel1.setVisible(true);
        RMICliente rmic = new RMICliente();
        veiculos = rmic.RecuperarVeiculos();
        tabelaVeiculos = new Object[veiculos.size()][6];
        for (int i = 0; i < veiculos.size(); i++) {
            tabelaVeiculos[i][0] = veiculos.get(i).getIdVeiculo();
            tabelaVeiculos[i][1] = veiculos.get(i).getPlaca();
            tabelaVeiculos[i][2] = veiculos.get(i).getFabricante();
            tabelaVeiculos[i][3] = veiculos.get(i).getModelo();
            tabelaVeiculos[i][4] = veiculos.get(i).getAno();
            tabelaVeiculos[i][5] = veiculos.get(i).getValorDiariaString();
        }
        fazTabela1(tabelaVeiculos);
    }

    /**
     * Imprime a tabela de veículos
     * @param tabela tabela montada
     */
    public final void fazTabela1(Object[][] tabela) {
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
     * Imprime a tabela de locações
     * @param tabela tabela locações
     */
    public void fazTabela2(Object[][] tabela) {
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                tabela,
                new String[]{
                    "Data/Hora Retirada", "Data/Hora Devolução", "Local Retirada", "Local Devolução"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        jScrollPane2.setViewportView(jTable2);

        jTable2.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(130);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(130);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(88);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(89);
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
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnVoltar = new javax.swing.JButton();

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Relatório de Locações");

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
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(130);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(130);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(88);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(89);
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

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Relatório de Locações para o Veículo");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data/Hora Retirada", "Data/Hora Devolução", "Local Retirada", "Local Devolução"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setColumnSelectionAllowed(true);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable2);
        jTable2.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(130);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(130);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(88);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(89);
        }

        btnVoltar.setText("<< Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVoltar)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(btnVoltar))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                .addContainerGap())
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

    /**
     * Após selecionado o veículo, visualizar suas locações
     * @param evt acionamento do botão avançar
     */
    private void botaoAvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAvancarActionPerformed
        try {
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            int linha = jTable1.getSelectedRow();
            if (linha < 0) {
                JOptionPane.showMessageDialog(null, "É necessário selecionar um veículo, clicando na sua linha");
            } else {
                int codigo = (int) dtm.getValueAt(linha, 0);
                for (Veiculo v : veiculos) {
                    if (v.getIdVeiculo() == codigo) {
                        selecionado = v;
                    }
                }
                jLabel13.setText("Relatório de Locações para o Veículo" + selecionado.getIdVeiculo() + "-" + selecionado.getModelo());
                jPanel1.setVisible(false);
                this.setContentPane(jPanel2);
                jPanel2.setVisible(true);
                RMICliente rmic = new RMICliente();
                ArrayList<Locacao> locacoes = rmic.RecuperarLocacoesPorVeiculo(selecionado.getIdVeiculo());
                Object[][] tabelaLocacao = new Object[locacoes.size()][4];
                for (int i = 0; i < locacoes.size(); i++) {
                    
                    SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");  
                    
                    String dataRetirada = out.format(locacoes.get(i).getDataRetirada());
                    String horaRetirada = locacoes.get(i).getHoraRetirada().toString();

                    String dataDevolucao = out.format(locacoes.get(i).getDataDevolucao());
                    String horaDevolucao = locacoes.get(i).getHoraDevolucao().toString();
                    
                    tabelaLocacao[i][0] = dataRetirada + " " + horaRetirada;
                    tabelaLocacao[i][1] = dataDevolucao + " " + horaDevolucao;
                    tabelaLocacao[i][2] = locacoes.get(i).getLocalRetirada();
                    tabelaLocacao[i][3] = locacoes.get(i).getLocalDevolucao();
                }
                fazTabela2(tabelaLocacao);
            }
        } catch (Exception ex) {
            Logger.getLogger(JanelaRelatorioLocacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botaoAvancarActionPerformed

    /**
     * Voltar à tela anterior
     * @param evt acionamento do botão voltar
     */
    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        jPanel2.setVisible(false);
        this.setContentPane(jPanel1);
        jPanel1.setVisible(true);
        fazTabela1(tabelaVeiculos);
    }//GEN-LAST:event_btnVoltarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAvancar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
