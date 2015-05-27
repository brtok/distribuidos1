/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controle.ControleLocacao;
import Modelo.Locacao;
import java.util.ArrayList;

/**
 *
 * @author Rafael
 */
public class JanelaRelatorioLocacao extends javax.swing.JDialog {

    /**
     * Creates new form JanelaRelatorioLocacao
     */
    public JanelaRelatorioLocacao() {
        initComponents();
        setModal(true);
        
        ControleLocacao controle = ControleLocacao.getInstancia();
        
        ArrayList<Locacao> locacoes = controle.getLocacoes();
        
        Object[][] tabela = new Object[locacoes.size()][5];
        for (int i = 0; i < locacoes.size(); i++) {
            tabela[i][0] = locacoes.get(i).getDataRetirada() + " " + locacoes.get(i).getHoraRetirada();
            tabela[i][1] = locacoes.get(i).getDataDevolucao() + " " + locacoes.get(i).getHoraDevolucao();
            tabela[i][2] = locacoes.get(i).getNomeCondutor();
            tabela[i][3] = locacoes.get(i).getVeiculo().getIdVeiculo();
            tabela[i][4] = locacoes.get(i).getVeiculo().getModelo();
        }
        populaTabela(tabela);
        
    }
    
    public void populaTabela(Object[][] tabela)
    {
        tabelaLocacoes.setModel(new javax.swing.table.DefaultTableModel(
                tabela,
                new String[]{
                    "Data/Hora Retirada", "Data/Hora Devolução", "Condutor", "Cod. Veículo", "Modelo"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        
        tabelaLocacoes.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tabelaLocacoes);
        tabelaLocacoes.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tabelaLocacoes.getColumnModel().getColumnCount() > 0) {
            tabelaLocacoes.getColumnModel().getColumn(0).setResizable(false);
            tabelaLocacoes.getColumnModel().getColumn(0).setPreferredWidth(80);
            tabelaLocacoes.getColumnModel().getColumn(1).setPreferredWidth(80);
            tabelaLocacoes.getColumnModel().getColumn(2).setPreferredWidth(100);
            tabelaLocacoes.getColumnModel().getColumn(3).setPreferredWidth(20);
            tabelaLocacoes.getColumnModel().getColumn(4).setPreferredWidth(100);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaLocacoes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabelaLocacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Data/Hora Retirada", "Data/Hora Devolução", "Condutor", "Veículo ID", "Veículo Modelo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaLocacoes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaLocacoes;
    // End of variables declaration//GEN-END:variables
}
