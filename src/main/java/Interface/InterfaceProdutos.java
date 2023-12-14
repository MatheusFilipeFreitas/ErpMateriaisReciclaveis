/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import DAO.ProdutoDao;
import Beans.Produto;
import Connection.Conexao;
import java.time.LocalDate;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class InterfaceProdutos extends javax.swing.JFrame {

    /**
     * Creates new form Interface
     */
    private int getIdFromTable = 0;
    
    public InterfaceProdutos() {
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
        jLabel5 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        Jdate = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Editar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 2), "Formulario Produto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 0, 18))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCodigo.setFont(new java.awt.Font("Comic Sans MS", 2, 18)); // NOI18N
        lblCodigo.setText("Código");
        jPanel4.add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 60, 30));

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 2, 18)); // NOI18N
        jLabel4.setText("Descrição");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 100, 30));

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 2, 18)); // NOI18N
        jLabel5.setText("Data de Validade");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 150, 30));

        txtDescricao.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jPanel4.add(txtDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 220, 40));

        txtCodigo.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jPanel4.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 220, 40));
        jPanel4.add(Jdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 240, 40));

        jButton1.setBackground(new java.awt.Color(190, 26, 43));
        jButton1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Limpar Campos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, 220, 40));

        btnCadastrar.setBackground(new java.awt.Color(190, 26, 43));
        btnCadastrar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        jPanel4.add(btnCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 220, 40));

        jButton3.setBackground(new java.awt.Color(190, 26, 43));
        jButton3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Excluir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 220, 40));

        Editar.setBackground(new java.awt.Color(190, 26, 43));
        Editar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        Editar.setForeground(new java.awt.Color(255, 255, 255));
        Editar.setText("Editar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        jPanel4.add(Editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 220, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 630, 540));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblProdutos.setBackground(new java.awt.Color(210, 129, 136));
        tblProdutos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Codigo", "Descricao", "Data de Validade", "Estoque"
            }
        ));
        tblProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProdutos);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 720, 510));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 130, 750, 540));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 730));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void preencheTable(){
        ProdutoDao pDAO = new ProdutoDao();
        List<Produto> listaProdutos = pDAO.getProdutos();
        
        DefaultTableModel tableProdutos = (DefaultTableModel) tblProdutos.getModel();
        tableProdutos.setNumRows(0);
        
        for(Produto p : listaProdutos){
            Object[] obj = new Object[]{
                p.getId_produto(),
                p.getCod(),
                p.getDescricao(),
                p.getValidade(),
                p.getEstoque()};
            tableProdutos.addRow(obj);
        }
    }
    
    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        Produto p = new Produto();
        p.setCod(txtCodigo.getText());
        p.setDescricao(txtDescricao.getText());
        p.setValidade(Jdate.getDate());
        
        ProdutoDao pDAO = new ProdutoDao();
        pDAO.inserir(p);
        preencheTable();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void tblProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdutosMouseClicked
        DefaultTableModel tbProdutos = (DefaultTableModel) tblProdutos.getModel(); 
        int selectedIndex = tblProdutos.getSelectedRow();
        
        int id  = Integer.parseInt(tbProdutos.getValueAt(selectedIndex, 0).toString());
        getIdFromTable = id;
        txtCodigo.setText(tbProdutos.getValueAt(selectedIndex, 1).toString());
        txtDescricao.setText(tbProdutos.getValueAt(selectedIndex, 2).toString());
        java.sql.Date dateInSql = (java.sql.Date) tbProdutos.getValueAt(selectedIndex, 3);
        Jdate.setDate(new Date(dateInSql.getTime()));
    }//GEN-LAST:event_tblProdutosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        getIdFromTable = 0;
        txtCodigo.setText("");
        txtDescricao.setText("");
        Jdate.setDate(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ProdutoDao pDAO = new ProdutoDao();
        
        if(getIdFromTable != 0) {
            pDAO.excluir(getIdFromTable);
        }
        getIdFromTable = 0;
        txtCodigo.setText("");
        txtDescricao.setText("");
        Jdate.setDate(null);
        preencheTable();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        ProdutoDao pDAO = new ProdutoDao();
        
        Produto produto = new Produto();
        
        int id = getIdFromTable;
        if(id!= 0) {
            produto.setId_produto(id);
            produto.setCod(txtCodigo.getText());
            produto.setDescricao(txtDescricao.getText());
            try{
               produto.setValidade(Jdate.getDate());
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            pDAO.editar(produto);
            preencheTable();
        }
    }//GEN-LAST:event_EditarActionPerformed
    
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
            java.util.logging.Logger.getLogger(InterfaceProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
            new InterfaceProdutos().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Editar;
    private com.toedter.calendar.JDateChooser Jdate;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescricao;
    // End of variables declaration//GEN-END:variables
}