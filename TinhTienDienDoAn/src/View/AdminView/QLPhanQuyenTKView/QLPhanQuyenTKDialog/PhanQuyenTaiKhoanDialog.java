package View.AdminView.QLPhanQuyenTKView.QLPhanQuyenTKDialog;

import Controller.QLPhanQuyenTKController.DSTaiKhoanPhanQuyen;
import Controller.SupportFunction.CheckingDataExist;
import LayMotSoUIdepTaiDay.CheckBox;
import Model.Accounts;
import View.AdminView.MainAdminView;
import View.AdminView.QLPhanQuyenTKView.QLPhanQuyenTKMainView;
import javax.swing.JOptionPane;


public class PhanQuyenTaiKhoanDialog extends javax.swing.JDialog {
    private Accounts Acc;
    private MainAdminView MainAdminview;
    private QLPhanQuyenTKMainView QLPhanQuyenTKMainView;
    
    public PhanQuyenTaiKhoanDialog(MainAdminView mainAdminView, QLPhanQuyenTKMainView qLPhanQuyenTKMainView, boolean modal) {
        initComponents();
        this.MainAdminview = mainAdminView;
        this.QLPhanQuyenTKMainView = qLPhanQuyenTKMainView;
        this.setModalityType(DEFAULT_MODALITY_TYPE.APPLICATION_MODAL);
        this.setTitle("Thêm thông tin tài khoản");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.Acc = QLPhanQuyenTKMainView.getAcc();
        AccountTf.setText(Acc.getAccount_Username());
        CCCDTf.setText(Acc.getCCCD());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PhanQuyenGrp = new javax.swing.ButtonGroup();
        OkBt = new javax.swing.JButton();
        CancelBt = new javax.swing.JButton();
        CCCDLbl = new javax.swing.JLabel();
        AccountTf = new javax.swing.JTextField();
        CCCDLbl1 = new javax.swing.JLabel();
        CCCDTf = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        NhanVienCbk = new LayMotSoUIdepTaiDay.CheckBox();
        ChuHoCbk = new LayMotSoUIdepTaiDay.CheckBox();
        Logo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

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

        CCCDLbl.setText("Account:");

        AccountTf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AccountTf.setEnabled(false);

        CCCDLbl1.setText("CCCD:");

        CCCDTf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CCCDTf.setEnabled(false);

        jSeparator1.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("PHÂN QUYỀN TÀI KHOẢN:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Chọn loại phân quyền:");

        NhanVienCbk.setBackground(new java.awt.Color(0, 0, 0));
        NhanVienCbk.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        PhanQuyenGrp.add(NhanVienCbk);
        NhanVienCbk.setForeground(new java.awt.Color(0, 0, 0));
        NhanVienCbk.setText("Nhân viên");

        ChuHoCbk.setBackground(new java.awt.Color(0, 0, 0));
        ChuHoCbk.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        PhanQuyenGrp.add(ChuHoCbk);
        ChuHoCbk.setForeground(new java.awt.Color(0, 0, 0));
        ChuHoCbk.setText("Chủ hộ");

        Logo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Warning.png"))); // NOI18N
        Logo.setText("Cảnh báo:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Một khi phân quyền sẽ không thể thay đổi");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("về sau, nếu muốn sửa lại phân quyền bắt buộc");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("phải tạo một tài khoản mới với quyền chỉ định");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(Logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(CCCDLbl1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                    .addComponent(CCCDTf, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(CCCDLbl)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(AccountTf, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(26, 26, 26)
                                    .addComponent(CancelBt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(258, 258, 258)
                                    .addComponent(ChuHoCbk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(NhanVienCbk, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(OkBt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Logo)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CCCDLbl)
                    .addComponent(AccountTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CCCDLbl1)
                    .addComponent(CCCDTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ChuHoCbk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NhanVienCbk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelBt)
                    .addComponent(OkBt))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OkBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkBtActionPerformed
        if(!NhanVienCbk.isSelected() && !ChuHoCbk.isSelected()){
           JOptionPane.showMessageDialog(this, "Vui lòng chọn loại phân quyền!!!");             
        }else if(CheckingDataExist.CheckDuplicatePrivilege(CCCDTf.getText(), IntPrivilege(NhanVienCbk, ChuHoCbk))){
            String PhanQuyen;
            if(NhanVienCbk.isSelected())
                PhanQuyen = "Nhân viên";
            else
                PhanQuyen = "Chủ hộ";
            JOptionPane.showMessageDialog(this, "Tài khoản này đã có phân quyền là " + PhanQuyen + " - Vui lòng chọn loại phân quyền khác!");  
        }else{
            int confirm = JOptionPane.showConfirmDialog(
                this,
                "Bạn có chắc muốn phân quyền tài khoản người dùng có CCCD: " + CCCDTf.getText() + " không?",
            "Xác nhận thêm",
            JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                if(NhanVienCbk.isSelected())
                    Acc.setRole(1);
                else
                    Acc.setRole(0);
                try{
                    DSTaiKhoanPhanQuyen.UpdateRole(Acc);
                    JOptionPane.showMessageDialog(this, "Đã phân quyền tài khoản người dùng có CCCD: " + CCCDTf.getText());
                    this.QLPhanQuyenTKMainView.ShowThongTinTuDBS(QLPhanQuyenTKMainView.getBangDSPQTKChung());
                    this.MainAdminview.CapNhatBangTrangThai();
                    this.dispose();
                }catch(Exception e){
                    System.out.println(e);
                    JOptionPane.showMessageDialog(this, "Lỗi hệ thống!!! - Vui lòng thử lại sau", "Lỗi", 
                                                  JOptionPane.ERROR_MESSAGE);
                }
            }            
        }
    }//GEN-LAST:event_OkBtActionPerformed

    private void CancelBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtActionPerformed
        this.dispose();
    }//GEN-LAST:event_CancelBtActionPerformed

    public int IntPrivilege(CheckBox cbk1, CheckBox cbk2){
        if(cbk1.isSelected())
            return 1;
        else
            return 0;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AccountTf;
    private javax.swing.JLabel CCCDLbl;
    private javax.swing.JLabel CCCDLbl1;
    private javax.swing.JTextField CCCDTf;
    private javax.swing.JButton CancelBt;
    private LayMotSoUIdepTaiDay.CheckBox ChuHoCbk;
    private javax.swing.JLabel Logo;
    private LayMotSoUIdepTaiDay.CheckBox NhanVienCbk;
    private javax.swing.JButton OkBt;
    private javax.swing.ButtonGroup PhanQuyenGrp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
