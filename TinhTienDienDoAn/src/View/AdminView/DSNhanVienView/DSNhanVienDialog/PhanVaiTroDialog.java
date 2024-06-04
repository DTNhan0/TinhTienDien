package View.AdminView.DSNhanVienView.DSNhanVienDialog;

import Controller.DSNhanVienController.DSNhanVien;
import Model.Staffs;
import View.AdminView.DSNhanVienView.DSNhanVienMainView;
import View.AdminView.MainAdminView;
import javax.swing.JOptionPane;

public class PhanVaiTroDialog extends javax.swing.JDialog {
    private MainAdminView MainAdminview;
    private DSNhanVienMainView DsNhanVienMainView;
    private Staffs staffs = new Staffs();
    
    public PhanVaiTroDialog(MainAdminView mainAdminView, DSNhanVienMainView dSNhanVienMainView, boolean modal) {
        initComponents();
        this.MainAdminview = mainAdminView;
        this.DsNhanVienMainView = dSNhanVienMainView;
        this.setModalityType(DEFAULT_MODALITY_TYPE.APPLICATION_MODAL);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        staffs = DsNhanVienMainView.getSt();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoaiTuoiGrp = new javax.swing.ButtonGroup();
        OkBt = new javax.swing.JButton();
        CancelBt = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        GhiDienBt = new LayMotSoUIdepTaiDay.CheckBox();
        NhapXuatBT = new LayMotSoUIdepTaiDay.CheckBox();
        jLabel2 = new javax.swing.JLabel();

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
        jLabel1.setText("CHỌN VAI TRÒ CÔNG VIỆC:");

        GhiDienBt.setBackground(new java.awt.Color(0, 0, 0));
        GhiDienBt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        LoaiTuoiGrp.add(GhiDienBt);
        GhiDienBt.setText("Nhân viên ghi điện");

        NhapXuatBT.setBackground(new java.awt.Color(0, 0, 0));
        NhapXuatBT.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        LoaiTuoiGrp.add(NhapXuatBT);
        NhapXuatBT.setText("Nhân viên nhập/xuất hóa đơn điện");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Vai trò:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NhapXuatBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GhiDienBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(OkBt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(CancelBt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(GhiDienBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(NhapXuatBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OkBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CancelBt))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OkBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkBtActionPerformed
        if(!GhiDienBt.isSelected() && !NhapXuatBT.isSelected()){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn loại sắp xếp!!!");             
        }else if(GhiDienBt.isSelected()){
            staffs.setRoleStaff(0);
            DSNhanVien.UpdateRole(staffs);
            JOptionPane.showMessageDialog(this, "Đã phân vai trò ghi điện cho nhân viên thành công"); 
            this.dispose();
        }else{
            staffs.setRoleStaff(1);
            DSNhanVien.UpdateRole(staffs);
            JOptionPane.showMessageDialog(this, "Đã phân vai trò nhập/xuất hóa đơn điện cho nhân viên thành công"); 
            this.dispose();
        }
        this.DsNhanVienMainView.ShowThongTinTuDBS(DsNhanVienMainView.getBangDSNhanVien());
    }//GEN-LAST:event_OkBtActionPerformed

    private void CancelBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtActionPerformed
        this.dispose();
    }//GEN-LAST:event_CancelBtActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelBt;
    private LayMotSoUIdepTaiDay.CheckBox GhiDienBt;
    private javax.swing.ButtonGroup LoaiTuoiGrp;
    private LayMotSoUIdepTaiDay.CheckBox NhapXuatBT;
    private javax.swing.JButton OkBt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
