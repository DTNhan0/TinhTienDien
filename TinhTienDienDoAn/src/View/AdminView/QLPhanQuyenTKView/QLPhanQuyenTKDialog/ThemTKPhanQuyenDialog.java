package View.AdminView.QLPhanQuyenTKView.QLPhanQuyenTKDialog;

import Controller.QLPhanQuyenTKController.DSTaiKhoanPhanQuyen;
import Controller.SupportFunction.CheckingDataExist;
import Controller.SupportFunction.StringProcessing;
import Model.Accounts;
import View.AdminView.MainAdminView;
import View.AdminView.QLPhanQuyenTKView.QLPhanQuyenTKMainView;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class ThemTKPhanQuyenDialog extends javax.swing.JDialog {
    private Accounts Acc;
    private MainAdminView MainAdminview;
    private QLPhanQuyenTKMainView QLPhanQuyenTKMainView;
    
    public ThemTKPhanQuyenDialog(MainAdminView mainAdminView, QLPhanQuyenTKMainView qLPhanQuyenTKMainView, boolean modal) {
        initComponents();
        this.MainAdminview = mainAdminView;
        this.QLPhanQuyenTKMainView = qLPhanQuyenTKMainView;
        this.setModalityType(DEFAULT_MODALITY_TYPE.APPLICATION_MODAL);
        this.setTitle("Thêm thông tin tài khoản");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        if(QLPhanQuyenTKMainView.getAcc() != null){
            this.Acc = QLPhanQuyenTKMainView.getAcc();
            CCCDTf.setText(Acc.getCCCD());
            AccountTf.setText(Acc.getAccount_Username());
            PasswordTf.setText(Acc.getAccount_Password());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GioiTinhGroup = new javax.swing.ButtonGroup();
        OkBt = new javax.swing.JButton();
        CancelBt = new javax.swing.JButton();
        CCCDLbl = new javax.swing.JLabel();
        HoLbl = new javax.swing.JLabel();
        DemLbl = new javax.swing.JLabel();
        GioiTinhLbl = new javax.swing.JLabel();
        CCCDTf = new javax.swing.JTextField();
        AccountTf = new javax.swing.JTextField();
        PasswordTf = new javax.swing.JTextField();
        NhanVienRb = new javax.swing.JRadioButton();
        ChuHoRb = new javax.swing.JRadioButton();
        Logo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Logo1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        DemLbl1 = new javax.swing.JLabel();
        PasswordConfirmTf = new javax.swing.JTextField();

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

        CCCDLbl.setText("CCCD:");

        HoLbl.setText("Account:");

        DemLbl.setText("Password:");

        GioiTinhLbl.setText("Phân quyền:");

        GioiTinhGroup.add(NhanVienRb);
        NhanVienRb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        NhanVienRb.setText("Nhân viên");

        GioiTinhGroup.add(ChuHoRb);
        ChuHoRb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ChuHoRb.setText("Chủ hộ");

        Logo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Warning.png"))); // NOI18N
        Logo.setText("Cảnh báo:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Một khi phân quyền sẽ không thể thay đổi");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("về sau, nếu muốn sửa lại phân quyền bắt buộc");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("phải tạo một tài khoản mới với quyền chỉ định");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Một CCCD chỉ được tạo và phân quyền tối đa");

        Logo1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Logo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Warning.png"))); // NOI18N
        Logo1.setText("Lưu ý:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("duy nhất: ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("2 lần (Hai lần)");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Một CCCD không tồn tại hai phân quyền  ");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("GIỐNG NHAU");

        DemLbl1.setText("Confirm password:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(Logo, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                        .addComponent(Logo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(DemLbl)
                        .addComponent(DemLbl1)
                        .addComponent(HoLbl)
                        .addComponent(CCCDLbl)
                        .addComponent(GioiTinhLbl)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(PasswordTf, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AccountTf, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CCCDTf, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PasswordConfirmTf, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(OkBt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(NhanVienRb)))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ChuHoRb)
                            .addComponent(CancelBt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {AccountTf, CCCDTf, PasswordTf});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Logo)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Logo1)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CCCDTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CCCDLbl))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AccountTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HoLbl))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PasswordTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DemLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PasswordConfirmTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DemLbl1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NhanVienRb)
                    .addComponent(ChuHoRb)
                    .addComponent(GioiTinhLbl))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelBt)
                    .addComponent(OkBt))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {AccountTf, CCCDTf, PasswordTf});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OkBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkBtActionPerformed
        if(CCCDTf.getText().replaceAll(" ", "").equals("") ||
           AccountTf.getText().replaceAll(" ", "").equals("") ||
           PasswordTf.getText().replaceAll(" ", "").equals("") ||
           PasswordConfirmTf.getText().replaceAll(" ", "").equals("") ||
           !NhanVienRb.isSelected() && !ChuHoRb.isSelected()){
           JOptionPane.showMessageDialog(this, "Vui lòng không được bỏ trống thông tin nhập!");            
        }else if(StringProcessing.CheckCCCD(CCCDTf.getText())){
            JOptionPane.showMessageDialog(this, "Sai định dạng CCCD!!! - Phải là chữ số và đủ 12 ký tự");  
        }else if(!CheckingDataExist.CheckExistCCCD(CCCDTf.getText(), null)){
            JOptionPane.showMessageDialog(this, "CCCD này không tồn tại!!! - Vui lòng kiểm tra phần thông tin chung");                         
        }else if(StringProcessing.CheckStringSpace(AccountTf.getText()) || StringProcessing.CheckStringSpace(PasswordTf.getText())){
            JOptionPane.showMessageDialog(this, "Không được cách khoảng trắng đối với Account và Password!!!");  
        }else if(CheckingDataExist.CheckExistAccount(AccountTf.getText(), null)){
            JOptionPane.showMessageDialog(this, "Tên tài khoản đã tồn tại! - Vui lòng đổi tên khác");  
        }else if(CheckingDataExist.CheckDuplicateAcc(CCCDTf.getText())){
            JOptionPane.showMessageDialog(this, "Tài khoản này đã được tạo hai lần! - Muốn chỉnh sửa hãy vào mục cập nhật");  
        }else if(!PasswordTf.getText().equals(PasswordConfirmTf.getText())){
            JOptionPane.showMessageDialog(this, "Vui lòng xác nhận lại mật khẩu!");  
        }else if(CheckingDataExist.CheckDuplicatePrivilege(CCCDTf.getText(), IntPrivilege(NhanVienRb, ChuHoRb))){
            String PhanQuyen;
            if(NhanVienRb.isSelected())
                PhanQuyen = "Nhân viên";
            else
                PhanQuyen = "Chủ hộ";
            JOptionPane.showMessageDialog(this, "Tài khoản này đã có phân quyền là " + PhanQuyen + " - Vui lòng chọn loại phân quyền khác!");  
        }else{
             int confirm = JOptionPane.showConfirmDialog(
                this,
                "Bạn có chắc muốn thêm tài khoản người dùng với CCCD: " + CCCDTf.getText() + " không?",
            "Xác nhận thêm",
            JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                Accounts Acc = new Accounts();
                Acc.setCCCD(CCCDTf.getText());
                Acc.setAccount_Username(AccountTf.getText());
                Acc.setAccount_Password(PasswordTf.getText());
                Acc.setStatus(false);
                if(NhanVienRb.isSelected())
                    Acc.setRole(1);
                else
                    Acc.setRole(0);
                try{
                    DSTaiKhoanPhanQuyen.Add(Acc);
                    JOptionPane.showMessageDialog(this, "Đã thêm tài khoản người dùng có CCCD: " + CCCDTf.getText());
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

    public int IntPrivilege(JRadioButton rb1, JRadioButton rb2){
        if(rb1.isSelected())
            return 1;
        else
            return 0;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AccountTf;
    private javax.swing.JLabel CCCDLbl;
    private javax.swing.JTextField CCCDTf;
    private javax.swing.JButton CancelBt;
    private javax.swing.JRadioButton ChuHoRb;
    private javax.swing.JLabel DemLbl;
    private javax.swing.JLabel DemLbl1;
    private javax.swing.ButtonGroup GioiTinhGroup;
    private javax.swing.JLabel GioiTinhLbl;
    private javax.swing.JLabel HoLbl;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel Logo1;
    private javax.swing.JRadioButton NhanVienRb;
    private javax.swing.JButton OkBt;
    private javax.swing.JTextField PasswordConfirmTf;
    private javax.swing.JTextField PasswordTf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
