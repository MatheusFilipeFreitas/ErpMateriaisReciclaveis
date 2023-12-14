/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import DAO.ProdutoDao;
import Beans.Produto;
import DAO.UsuarioDao;
import Beans.Usuario;
import DAO.OperacaoDao;
import Beans.Operacao;
import Connection.Conexao;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class InterfaceOperacao extends javax.swing.JFrame {

    /**
     * Creates new form Interface
     */
    public InterfaceOperacao() {
        initComponents();
        preencheTable();
    
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
        jPanel2 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        btnLimpar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        lblCodigo1 = new javax.swing.JLabel();
        comboUsuario = new javax.swing.JComboBox();
        lblCodigo2 = new javax.swing.JLabel();
        comboProduto = new javax.swing.JComboBox();
        lblCodigo3 = new javax.swing.JLabel();
        lblCodigo4 = new javax.swing.JLabel();
        Jdate = new com.toedter.calendar.JDateChooser();
        comboOperacao = new javax.swing.JComboBox<>();
        comboMotivo = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOperacoes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(190, 26, 43));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        jSeparator4.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1400, 10));

        jSeparator5.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1400, 10));

        jSeparator6.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1400, 10));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 670, 1410, 50));

        jPanel3.setBackground(new java.awt.Color(190, 26, 43));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ERP para ONG de Materias Reciclavéis");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 800, 60));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 130));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 2), "Formulario Operacao", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 0, 18))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCodigo.setFont(new java.awt.Font("Comic Sans MS", 2, 18)); // NOI18N
        lblCodigo.setText("Motivo");
        jPanel4.add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 120, 30));

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 2, 18)); // NOI18N
        jLabel4.setText("Id do Usuario");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 140, 30));

        txtQuantidade.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jPanel4.add(txtQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 220, 40));

        btnLimpar.setBackground(new java.awt.Color(190, 26, 43));
        btnLimpar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnLimpar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpar.setText("Limpar Campos");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        jPanel4.add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 410, 220, 40));

        btnCadastrar.setBackground(new java.awt.Color(190, 26, 43));
        btnCadastrar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        jPanel4.add(btnCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, 220, 40));

        btnExcluir.setBackground(new java.awt.Color(190, 26, 43));
        btnExcluir.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jPanel4.add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, 220, 40));

        btnEditar.setBackground(new java.awt.Color(190, 26, 43));
        btnEditar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel4.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, 220, 40));

        lblCodigo1.setFont(new java.awt.Font("Comic Sans MS", 2, 18)); // NOI18N
        lblCodigo1.setText("Id do Produto");
        jPanel4.add(lblCodigo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 120, 30));

        jPanel4.add(comboUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 220, 40));

        lblCodigo2.setFont(new java.awt.Font("Comic Sans MS", 2, 18)); // NOI18N
        lblCodigo2.setText("Data");
        jPanel4.add(lblCodigo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 120, 30));

        jPanel4.add(comboProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 220, 40));

        lblCodigo3.setFont(new java.awt.Font("Comic Sans MS", 2, 18)); // NOI18N
        lblCodigo3.setText("Operação");
        jPanel4.add(lblCodigo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 120, 30));

        lblCodigo4.setFont(new java.awt.Font("Comic Sans MS", 2, 18)); // NOI18N
        lblCodigo4.setText("Quantidade");
        jPanel4.add(lblCodigo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 120, 30));
        jPanel4.add(Jdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 220, 40));

        comboOperacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entrada", "Saída" }));
        jPanel4.add(comboOperacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 220, 40));

        comboMotivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "asdasd" }));
        jPanel4.add(comboMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 220, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 630, 540));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblOperacoes.setBackground(new java.awt.Color(210, 129, 136));
        tblOperacoes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        tblOperacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Cpf"
            }
        ));
        jScrollPane1.setViewportView(tblOperacoes);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 720, 510));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 130, 750, 540));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 730));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void preencheTable(){
        OperacaoDao oDAO = new OperacaoDao();
        List<Operacao> listaOperacao = oDAO.ConsultaOperacoes();
        
        DefaultTableModel tableOperacoes = (DefaultTableModel) tblOperacoes.getModel();
        tableOperacoes.setNumRows(0);
        
        for(Operacao p : listaOperacao){
            Object[] obj = new Object[]{
                p.getId_operacao(),
                p.getId_produto(),
                p.getId_usuario(),
                p.getTipo_operacao(),
                p.getMotivo(),
                p.getQuantidade(),
                p.getData_hora()};
            tableOperacoes.addRow(obj);
        }
    }
    
    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        Operacao o = new Operacao();
        o.setId_produto((Produto)comboProduto.getSelectedItem());
        o.setId_usuario((Usuario)comboUsuario.getSelectedItem());
        o.setTipo_operacao(comboOperacao.getSelectedItem().toString());
        o.setMotivo(comboMotivo.getSelectedItem().toString());
        o.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
        o.setData_hora(Jdate.getDate());
        
        
        
        
        OperacaoDao oDAO = new OperacaoDao();
        oDAO.inserir(o);
        preencheTable();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparFormulario();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "Exclusao", JOptionPane.YES_NO_OPTION);
        
        if(resposta == JOptionPane.YES_OPTION){
            UsuarioDao uDAO = new UsuarioDao();
            //uDAO.excluir();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed
    
    private void limparFormulario(){
       
    }
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
            java.util.logging.Logger.getLogger(InterfaceOperacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceOperacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceOperacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceOperacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new InterfaceOperacao().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Jdate;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JComboBox<String> comboMotivo;
    private javax.swing.JComboBox<String> comboOperacao;
    private javax.swing.JComboBox comboProduto;
    private javax.swing.JComboBox comboUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCodigo1;
    private javax.swing.JLabel lblCodigo2;
    private javax.swing.JLabel lblCodigo3;
    private javax.swing.JLabel lblCodigo4;
    private javax.swing.JTable tblOperacoes;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}
