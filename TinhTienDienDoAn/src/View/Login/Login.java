
package View.Login;

import Controller.DSChuHoController.DSChuHo;
import Controller.DSE_MeterController.DSE_Meter;
import Controller.DSNhanVienController.DSNhanVien;
import Controller.LoginController.LoginController;
import Controller.QLPhanQuyenTKController.DSTaiKhoanPhanQuyen;
import Controller.QLThongTinChungController.DSThongTinChung;
import MainRunCode.AccountLogin;
import Model.Accounts;
import Model.Customers;
import Model.Personal_Infos;
import Model.Staffs;
import View.AdminView.MainAdminView;
import View.AdminView.QLPhanQuyenTKView.QLPhanQuyenTKMainView;
import View.CustomerView.MainCustomerView;
import View.StaffView.MainStaffView;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    private int priviledge;
    public Login() {
        initComponents();
//        txtUserName.setBackground(new java.awt.Color(0,0,0,1));
//        txtPassWord.setBackground(new java.awt.Color(0,0,0,1));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Exit = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        UserName = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPassWord = new javax.swing.JPasswordField();
        Password = new javax.swing.JLabel();
        disable = new javax.swing.JLabel();
        show = new javax.swing.JLabel();
        Login = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/LogoUngDung.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 70, 440, 280));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 440));

        jPanel2.setBackground(new java.awt.Color(25, 118, 211));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Exit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Exit.setForeground(new java.awt.Color(255, 255, 255));
        Exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Exit.setText("X");
        Exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitMouseClicked(evt);
            }
        });
        jPanel2.add(Exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 40, 29));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("LOGIN");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 47, 420, 41));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Hello! Let's get started");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 94, 420, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(199, 226, 255));
        jLabel5.setText("Username");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 123, 341, -1));

        txtUserName.setBackground(new java.awt.Color(25, 118, 211));
        txtUserName.setFont(txtUserName.getFont().deriveFont(txtUserName.getFont().getSize()+2f));
        txtUserName.setForeground(new java.awt.Color(255, 255, 255));
        txtUserName.setBorder(null);
        jPanel2.add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 140, 240, 30));

        UserName.setForeground(new java.awt.Color(255, 255, 255));
        UserName.setText("_________________________________________");
        jPanel2.add(UserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 147, 290, 39));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/8.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 40, 39));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(199, 226, 255));
        jLabel8.setText("Password");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 192, 341, -1));

        txtPassWord.setBackground(new java.awt.Color(25, 118, 211));
        txtPassWord.setFont(txtPassWord.getFont().deriveFont(txtPassWord.getFont().getSize()+2f));
        txtPassWord.setForeground(new java.awt.Color(255, 255, 255));
        txtPassWord.setBorder(null);
        txtPassWord.setCaretColor(new java.awt.Color(255, 255, 255));
        txtPassWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassWordActionPerformed(evt);
            }
        });
        jPanel2.add(txtPassWord, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 240, 30));

        Password.setForeground(new java.awt.Color(255, 255, 255));
        Password.setText("_________________________________________");
        jPanel2.add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 216, 290, 40));

        disable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        disable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_invisible_20px_1.png"))); // NOI18N
        disable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        disable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                disableMouseClicked(evt);
            }
        });
        jPanel2.add(disable, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 40, 40));

        show.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_eye_20px_1.png"))); // NOI18N
        show.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showMouseClicked(evt);
            }
        });
        jPanel2.add(show, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 40, 40));

        Login.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Login.setForeground(new java.awt.Color(25, 118, 211));
        Login.setText("LOGIN");
        Login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });
        jPanel2.add(Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 306, 341, 40));

        jButton1.setBackground(new java.awt.Color(25, 118, 211));
        jButton1.setForeground(java.awt.Color.white);
        jButton1.setText("Forget Password ?");
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setDefaultCapable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 420, 440));

        setSize(new java.awt.Dimension(854, 439));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_ExitMouseClicked

    private void disableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_disableMouseClicked
        txtPassWord.setEchoChar((char)0);
        disable.setVisible(false);
        disable.setEnabled(false);
        show.setEnabled(true);
        show.setEnabled(true);
    }//GEN-LAST:event_disableMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        for (double i = 0.0; i <=1.0; i = i+0.1){
            String val = i+ "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try{
                Thread.sleep(50);
            }catch(Exception e){
                
            }
        }
    }//GEN-LAST:event_formWindowOpened
    
    private void showMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMouseClicked
        txtPassWord.setEchoChar((char)8226);
        disable.setVisible(true);
        disable.setEnabled(true);
        show.setEnabled(false);
        show.setEnabled(false);
    }//GEN-LAST:event_showMouseClicked

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        try {
            String userName=txtUserName.getText();
            char [] passWordchar=txtPassWord.getPassword();
            String passWord =new String(passWordchar);
            String user=new LoginController().login(userName, passWord);
            if(!user.isEmpty()){
                JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");
                
                //Khởi tạo các list khi login thành công
                new DSE_Meter().KhoiTaoListE_Meters();
                new DSThongTinChung().KhoiTaoListPersonal_Infos();
                new DSTaiKhoanPhanQuyen().KhoiTaoListAccount();
                new DSChuHo().KhoiTaoListCustomeres();
                new DSNhanVien().KhoiTaoListStaffs();
                new DSE_Meter().KhoiTaoListE_Meters();
                
                AccountLogin accountLogin = new AccountLogin();
                
                int privilege=new LoginController().getPrivilege(userName, passWord);
                
                
                if(privilege==2){
                    this.dispose();
                    MainAdminView mainAdminView= new MainAdminView();
                    mainAdminView.setVisible(true);
                    mainAdminView.setSize(1500, 800);
                    mainAdminView.setLocationRelativeTo(null);
                }else if(privilege==1){
                    this.dispose();
                    
                    Accounts Acc = new DSTaiKhoanPhanQuyen().SearchObjAccount(userName);
                    Staffs staffs = new DSNhanVien().SearchObjCCCD(Acc.getCCCD());
                    accountLogin.setStaffsLogin(staffs);
                    
                    this.dispose();
                    MainAdminView mainAdminView= new MainAdminView();
                    mainAdminView.setVisible(true);
                    mainAdminView.setSize(1500, 800);
                    mainAdminView.setLocationRelativeTo(null);
                }else if(privilege==0){
                    this.dispose();
                    
                    Accounts Acc = new DSTaiKhoanPhanQuyen().SearchObjAccount(userName);
                    Customers customers = new DSChuHo().SearchObjCCCD(Acc.getCCCD());
                    accountLogin.setCustomersLogin(customers);
                    
                    MainCustomerView mainCustomerView=new MainCustomerView();
                    mainCustomerView.setVisible(true);
                    mainCustomerView.setSize(1500, 800);
                    mainCustomerView.setLocationRelativeTo(null);
                }
                
            }else{
                JOptionPane.showMessageDialog(this,"Username hoặc Password đã bị sai" ,"Lỗi", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_LoginActionPerformed

    private void txtPassWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassWordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassWordActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new ForgetPassword().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Exit;
    private javax.swing.JButton Login;
    private javax.swing.JLabel Password;
    private javax.swing.JLabel UserName;
    private javax.swing.JLabel disable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel show;
    private javax.swing.JPasswordField txtPassWord;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
