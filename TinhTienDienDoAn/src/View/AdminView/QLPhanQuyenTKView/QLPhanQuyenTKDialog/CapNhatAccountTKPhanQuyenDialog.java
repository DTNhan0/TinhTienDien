package View.AdminView.QLPhanQuyenTKView.QLPhanQuyenTKDialog;

import Controller.QLPhanQuyenTKController.DSTaiKhoanPhanQuyen;
import Controller.SupportFunction.CheckingDataExist;
import Controller.SupportFunction.StringProcessing;
import Model.Accounts;
import View.AdminView.MainAdminView;
import View.AdminView.QLPhanQuyenTKView.QLPhanQuyenTKMainView;
import javax.swing.JOptionPane;


public class CapNhatAccountTKPhanQuyenDialog extends javax.swing.JDialog {
    private Accounts Acc;
    private MainAdminView MainAdminview;
    private QLPhanQuyenTKMainView QLPhanQuyenTKMainView;
    
    public CapNhatAccountTKPhanQuyenDialog(MainAdminView mainAdminView, QLPhanQuyenTKMainView qLPhanQuyenTKMainView, boolean modal) {
        initComponents();
        this.MainAdminview = mainAdminView;
        this.QLPhanQuyenTKMainView = qLPhanQuyenTKMainView;
        this.setModalityType(DEFAULT_MODALITY_TYPE.APPLICATION_MODAL);
        this.setTitle("Thêm thông tin tài khoản");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.Acc = QLPhanQuyenTKMainView.getAcc();
        AccountCuTf.setText(Acc.getAccount_Username());
        PasswordCuTf.setText(Acc.getAccount_Password());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GioiTinhGroup = new javax.swing.ButtonGroup();
        OkBt = new javax.swing.JButton();
        CancelBt = new javax.swing.JButton();
        CCCDLbl = new javax.swing.JLabel();
        SdtLbl = new javax.swing.JLabel();
        AccountCuTf = new javax.swing.JTextField();
        AccountMoiTf = new javax.swing.JTextField();
        Logo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        CCCDLbl1 = new javax.swing.JLabel();
        PasswordCuTf = new javax.swing.JTextField();
        CCCDLbl2 = new javax.swing.JLabel();
        PasswordMoiTf = new javax.swing.JTextField();
        CCCDLbl3 = new javax.swing.JLabel();
        PassConfirmTf = new javax.swing.JTextField();

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

        CCCDLbl.setText("Account (Cũ):");

        SdtLbl.setText("Account (Mới):");

        AccountCuTf.setEditable(false);
        AccountCuTf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AccountCuTf.setEnabled(false);

        Logo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Warning.png"))); // NOI18N
        Logo.setText("Cảnh báo:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Việc đổi Account sang tên mới đồng nghĩa");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("với việc sau này mọi thông tin tài khoản sẽ ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("phụ thuộc vào Account mới. Bạn nên cân ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("nhắc kỹ về lựa chọn này!!!");

        CCCDLbl1.setText("Password(Cũ):");

        PasswordCuTf.setEditable(false);
        PasswordCuTf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        PasswordCuTf.setEnabled(false);

        CCCDLbl2.setText("Password(Mới):");

        CCCDLbl3.setText("Confirm password:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Logo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CCCDLbl1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(PasswordCuTf, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(CCCDLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(AccountCuTf, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SdtLbl)
                                    .addComponent(CCCDLbl2)
                                    .addComponent(CCCDLbl3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PassConfirmTf, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PasswordMoiTf, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AccountMoiTf, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(OkBt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(CancelBt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {AccountCuTf, AccountMoiTf});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Logo)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CCCDLbl)
                    .addComponent(AccountCuTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CCCDLbl1)
                    .addComponent(PasswordCuTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SdtLbl)
                    .addComponent(AccountMoiTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CCCDLbl2)
                    .addComponent(PasswordMoiTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CCCDLbl3)
                    .addComponent(PassConfirmTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OkBt)
                    .addComponent(CancelBt))
                .addGap(27, 27, 27))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {AccountCuTf, AccountMoiTf});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OkBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkBtActionPerformed
        if(AccountMoiTf.getText().replaceAll(" ", "").equals("") ||
           PasswordMoiTf.getText().replaceAll(" ", "").equals("") ||
           PassConfirmTf.getText().replaceAll(" ", "").equals("")){
           JOptionPane.showMessageDialog(this, "Vui lòng không được bỏ trống thông tin nhập!");            
        }else if(CheckingDataExist.CheckExistAccount(AccountMoiTf.getText(), Acc)){
           JOptionPane.showMessageDialog(this, "Tên Account này đã tồn tại! - Vui lòng nhập tên khác");             
        }else if(StringProcessing.CheckStringSpace(AccountMoiTf.getText()) || 
                StringProcessing.CheckStringSpace(PasswordMoiTf.getText()) ||
                StringProcessing.CheckStringSpace(PassConfirmTf.getText())){
            JOptionPane.showMessageDialog(this, "Không được cách khoảng trắng đối với Account, Password và Confirm Password!!!");  
        }else if(!PasswordMoiTf.getText().equals(PassConfirmTf.getText())){
            JOptionPane.showMessageDialog(this, "Vui lòng xác nhận lại mật khẩu!");            
        }else if(Acc.getRole()== -1){
            JOptionPane.showMessageDialog(this, "Tài khoản này hiện nay chưa được phân quyền! - Vui lòng phân quyền trước khi cập nhật");            
        }else{
             int confirm = JOptionPane.showConfirmDialog(
                this,
                "Bạn có chắc muốn cập nhật tài khoản người dùng với CCCD: " + Acc.getCCCD()+ " không?",
            "Xác nhận thêm",
            JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                Accounts acc = new Accounts();
                acc.setCCCD(Acc.getCCCD());
                acc.setAccount_Username(AccountMoiTf.getText());
                acc.setAccount_Password(PasswordMoiTf.getText());
                acc.setStatus(true);
                try{
                    DSTaiKhoanPhanQuyen.Update(acc, Acc);
                    JOptionPane.showMessageDialog(this, "Đã cập nhật tài khoản người dùng có CCCD: " + Acc.getCCCD());
                    this.QLPhanQuyenTKMainView.ShowThongTinTuDBS(QLPhanQuyenTKMainView.getBangDSPQTKChung());
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AccountCuTf;
    private javax.swing.JTextField AccountMoiTf;
    private javax.swing.JLabel CCCDLbl;
    private javax.swing.JLabel CCCDLbl1;
    private javax.swing.JLabel CCCDLbl2;
    private javax.swing.JLabel CCCDLbl3;
    private javax.swing.JButton CancelBt;
    private javax.swing.ButtonGroup GioiTinhGroup;
    private javax.swing.JLabel Logo;
    private javax.swing.JButton OkBt;
    private javax.swing.JTextField PassConfirmTf;
    private javax.swing.JTextField PasswordCuTf;
    private javax.swing.JTextField PasswordMoiTf;
    private javax.swing.JLabel SdtLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
