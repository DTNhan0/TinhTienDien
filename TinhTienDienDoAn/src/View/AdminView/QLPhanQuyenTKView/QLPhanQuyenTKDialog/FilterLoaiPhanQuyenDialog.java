package View.AdminView.QLPhanQuyenTKView.QLPhanQuyenTKDialog;

import Controller.QLPhanQuyenTKController.DSTaiKhoanPhanQuyen;
import View.AdminView.MainAdminView;
import View.AdminView.QLPhanQuyenTKView.QLPhanQuyenTKMainView;
import javax.swing.JOptionPane;

public class FilterLoaiPhanQuyenDialog extends javax.swing.JDialog {
    private MainAdminView MainAdminview;
    private QLPhanQuyenTKMainView QLPhanQuyenTKMainView;
    
    public FilterLoaiPhanQuyenDialog(MainAdminView mainAdminView, QLPhanQuyenTKMainView qLPhanQuyenTKMainView, boolean modal) {
        initComponents();
        this.MainAdminview = mainAdminView;
        this.QLPhanQuyenTKMainView = qLPhanQuyenTKMainView;
        this.setModalityType(DEFAULT_MODALITY_TYPE.APPLICATION_MODAL);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PhanQuyenGrp = new javax.swing.ButtonGroup();
        OkBt = new javax.swing.JButton();
        CancelBt = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        NhanVienCbk = new LayMotSoUIdepTaiDay.CheckBox();
        DaPhanQuyenCbk = new LayMotSoUIdepTaiDay.CheckBox();
        jLabel2 = new javax.swing.JLabel();
        ChuHoCbk = new LayMotSoUIdepTaiDay.CheckBox();
        ChuaPhanQuyenCbk = new LayMotSoUIdepTaiDay.CheckBox();

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
        jLabel1.setText("LỌC THEO PHÂN QUYỀN:");

        NhanVienCbk.setBackground(new java.awt.Color(0, 0, 0));
        NhanVienCbk.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        PhanQuyenGrp.add(NhanVienCbk);
        NhanVienCbk.setForeground(new java.awt.Color(0, 0, 0));
        NhanVienCbk.setText("Nhân viên");

        DaPhanQuyenCbk.setBackground(new java.awt.Color(0, 0, 0));
        DaPhanQuyenCbk.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        PhanQuyenGrp.add(DaPhanQuyenCbk);
        DaPhanQuyenCbk.setForeground(new java.awt.Color(0, 0, 0));
        DaPhanQuyenCbk.setText("Đã phân quyền");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Chọn loại phân quyền cần lọc:");

        ChuHoCbk.setBackground(new java.awt.Color(0, 0, 0));
        ChuHoCbk.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        PhanQuyenGrp.add(ChuHoCbk);
        ChuHoCbk.setForeground(new java.awt.Color(0, 0, 0));
        ChuHoCbk.setText("Chủ hộ");

        ChuaPhanQuyenCbk.setBackground(new java.awt.Color(0, 0, 0));
        ChuaPhanQuyenCbk.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        PhanQuyenGrp.add(ChuaPhanQuyenCbk);
        ChuaPhanQuyenCbk.setForeground(new java.awt.Color(0, 0, 0));
        ChuaPhanQuyenCbk.setText("Chưa phân quyền");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(OkBt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CancelBt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DaPhanQuyenCbk, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NhanVienCbk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ChuHoCbk, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ChuaPhanQuyenCbk, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
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
                    .addComponent(NhanVienCbk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChuHoCbk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DaPhanQuyenCbk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChuaPhanQuyenCbk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OkBt)
                    .addComponent(CancelBt))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OkBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkBtActionPerformed
        boolean check = false;
        if(!NhanVienCbk.isSelected() && !ChuHoCbk.isSelected() && !DaPhanQuyenCbk.isSelected() && !ChuaPhanQuyenCbk.isSelected()){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn loại lọc!!!");            
        }else if(NhanVienCbk.isSelected()){
            DSTaiKhoanPhanQuyen.Filter(1, 1, QLPhanQuyenTKMainView.getBangDSPQTKChung());
            check = true;
        }else if(ChuHoCbk.isSelected()){
            DSTaiKhoanPhanQuyen.Filter(2, 1, QLPhanQuyenTKMainView.getBangDSPQTKChung());
            check = true;
        }else if(DaPhanQuyenCbk.isSelected()){
            DSTaiKhoanPhanQuyen.Filter(3, 1, QLPhanQuyenTKMainView.getBangDSPQTKChung());
            check = true;
        }else if(ChuaPhanQuyenCbk.isSelected()){
            DSTaiKhoanPhanQuyen.Filter(4, 1, QLPhanQuyenTKMainView.getBangDSPQTKChung());
            check = true;
        }
        if(check){
            JOptionPane.showMessageDialog(this, "Đã lọc bảng theo phân quyền!!!"); 
            this.dispose();
        }
    }//GEN-LAST:event_OkBtActionPerformed

    private void CancelBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtActionPerformed
        this.dispose();
    }//GEN-LAST:event_CancelBtActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelBt;
    private LayMotSoUIdepTaiDay.CheckBox ChuHoCbk;
    private LayMotSoUIdepTaiDay.CheckBox ChuaPhanQuyenCbk;
    private LayMotSoUIdepTaiDay.CheckBox DaPhanQuyenCbk;
    private LayMotSoUIdepTaiDay.CheckBox NhanVienCbk;
    private javax.swing.JButton OkBt;
    private javax.swing.ButtonGroup PhanQuyenGrp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
