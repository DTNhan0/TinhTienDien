package View.CustomerView.DanhSachCongToDienCSView.DSCongToDienDialog;

import Controller.DAO.Paid_InvoicesDAO;
import Controller.QLPhanQuyenTKController.DSTaiKhoanPhanQuyen;
import Model.Invoices;
import Model.Paid_Invoices;
import View.AdminView.MainAdminView;
import View.AdminView.QLPhanQuyenTKView.QLPhanQuyenTKMainView;
import View.CustomerView.DanhSachCongToDienCSView.DSCongToDienCSSubView;
import View.CustomerView.DanhSachCongToDienCSView.DSCongToDienCSView;
import View.CustomerView.MainCustomerView;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;

public class ThanhToanDialog extends javax.swing.JDialog {
    private MainCustomerView mainCustomerView;
    private DSCongToDienCSSubView dSCongToDienCSSubView;
    private Invoices invoices = new Invoices();
    private String HinhThuc;
    
    public ThanhToanDialog(MainCustomerView mcv, DSCongToDienCSSubView dsctdcsv, boolean modal) {
        initComponents();
        this.mainCustomerView = mcv;
        this.dSCongToDienCSSubView = dsctdcsv;
        this.setModalityType(DEFAULT_MODALITY_TYPE.APPLICATION_MODAL);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.invoices = dSCongToDienCSSubView.getInvoices();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PhanQuyenGrp = new javax.swing.ButtonGroup();
        OkBt = new javax.swing.JButton();
        CancelBt = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        TienMatCbk = new LayMotSoUIdepTaiDay.CheckBox();
        jLabel2 = new javax.swing.JLabel();
        ChuyenKhoanCbk = new LayMotSoUIdepTaiDay.CheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(null);
        setIconImages(null);

        OkBt.setText("Ok");
        OkBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkBtActionPerformed(evt);
            }
        });

        CancelBt.setText("Cancel");
        CancelBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("THANH TOÁN:");

        TienMatCbk.setBackground(new java.awt.Color(0, 0, 0));
        TienMatCbk.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        PhanQuyenGrp.add(TienMatCbk);
        TienMatCbk.setForeground(new java.awt.Color(0, 0, 0));
        TienMatCbk.setText("Tiền mặt");
        TienMatCbk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TienMatCbkActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Chọn phương thức thanh toán:");

        ChuyenKhoanCbk.setBackground(new java.awt.Color(0, 0, 0));
        ChuyenKhoanCbk.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        PhanQuyenGrp.add(ChuyenKhoanCbk);
        ChuyenKhoanCbk.setForeground(new java.awt.Color(0, 0, 0));
        ChuyenKhoanCbk.setText("Chuyển khoản");
        ChuyenKhoanCbk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChuyenKhoanCbkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(OkBt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(TienMatCbk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CancelBt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChuyenKhoanCbk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TienMatCbk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChuyenKhoanCbk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OkBt)
                    .addComponent(CancelBt))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OkBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkBtActionPerformed
        if(!TienMatCbk.isSelected() && !ChuyenKhoanCbk.isSelected()){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn loại lọc!!!");            
        }else{
            Paid_Invoices paid_Invoice = new Paid_Invoices();
            
            LocalDate localDate = LocalDate.now();
            Date utilDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            paid_Invoice.setDate_Paid(utilDate);
            
            paid_Invoice.setID_Invoice(invoices.getID_Invoice());
            paid_Invoice.setID_Paid_Invoices(0);
            paid_Invoice.setInvoice_Method(HinhThuc);
            
            new Paid_InvoicesDAO().AddDAO(paid_Invoice);
            
            JOptionPane.showMessageDialog(this, "Đã thanh toán thành công!!!"); 
        }
    }//GEN-LAST:event_OkBtActionPerformed

    private void CancelBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtActionPerformed
        this.dispose();
    }//GEN-LAST:event_CancelBtActionPerformed

    private void ChuyenKhoanCbkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChuyenKhoanCbkActionPerformed
        HinhThuc = "Chuyển khoản";
    }//GEN-LAST:event_ChuyenKhoanCbkActionPerformed

    private void TienMatCbkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TienMatCbkActionPerformed
        HinhThuc = "Tiền mặt";
    }//GEN-LAST:event_TienMatCbkActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelBt;
    private LayMotSoUIdepTaiDay.CheckBox ChuyenKhoanCbk;
    private javax.swing.JButton OkBt;
    private javax.swing.ButtonGroup PhanQuyenGrp;
    private LayMotSoUIdepTaiDay.CheckBox TienMatCbk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
