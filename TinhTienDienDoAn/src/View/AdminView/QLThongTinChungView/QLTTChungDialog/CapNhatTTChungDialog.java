package View.AdminView.QLThongTinChungView.QLTTChungDialog;

import Controller.QLThongTinChungController.DSThongTinChung;
import Controller.SupportFunction.StringProcessing;
import Controller.SupportFunction.CheckingDataExist;
import Model.Personal_Infos;
import View.AdminView.MainAdminView;
import View.AdminView.QLThongTinChungView.QLTTChungMainView;
import javax.swing.JOptionPane;

public class CapNhatTTChungDialog extends javax.swing.JDialog {
    private MainAdminView MainAdminview;
    private QLTTChungMainView QlttChungMainView;
    public  Personal_Infos Ps;
    
    public CapNhatTTChungDialog(MainAdminView mainAdminView, QLTTChungMainView qLTTChungMainView, boolean modal) {
        initComponents();
        this.MainAdminview = mainAdminView;
        this.QlttChungMainView = qLTTChungMainView;
        this.setModalityType(DEFAULT_MODALITY_TYPE.APPLICATION_MODAL);
        this.setTitle("Thêm thông tin người dùng");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.Ps = QlttChungMainView.getPs();
        
        CCCDTf.setText(Ps.getCCCD());
        HoTf.setText(Ps.getFirstname());
        DemTf.setText(Ps.getMiddleName());
        TenTf.setText(Ps.getLastname());
        NgSinhTf.setDate(Ps.getDOB());
        DiaChiTf.setText(Ps.getAddress());
        SdtTf.setText(Ps.getPhone());
        if(Ps.isSex())
            NamRb.setSelected(true);
        else
            NuRb.setSelected(true);
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
        TenLbl = new javax.swing.JLabel();
        NgSinhLbl = new javax.swing.JLabel();
        DiaChiLbl = new javax.swing.JLabel();
        SdtLbl = new javax.swing.JLabel();
        GioiTinhLbl = new javax.swing.JLabel();
        CCCDTf = new javax.swing.JTextField();
        HoTf = new javax.swing.JTextField();
        DemTf = new javax.swing.JTextField();
        TenTf = new javax.swing.JTextField();
        DiaChiTf = new javax.swing.JTextField();
        SdtTf = new javax.swing.JTextField();
        NgSinhTf = new com.toedter.calendar.JDateChooser();
        NamRb = new javax.swing.JRadioButton();
        NuRb = new javax.swing.JRadioButton();

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

        HoLbl.setText("Họ:");

        DemLbl.setText("Đệm:");

        TenLbl.setText("Tên:");

        NgSinhLbl.setText("Ngày sinh:");

        DiaChiLbl.setText("Địa chỉ:");

        SdtLbl.setText("Số điện thoại:");

        GioiTinhLbl.setText("Giới tính:");

        CCCDTf.setEditable(false);
        CCCDTf.setEnabled(false);

        NgSinhTf.setDateFormatString("dd / MM / yyyy");

        GioiTinhGroup.add(NamRb);
        NamRb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        NamRb.setText("Nam");

        GioiTinhGroup.add(NuRb);
        NuRb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        NuRb.setText("Nữ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(DemLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DemTf, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(CCCDLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CCCDTf, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(NgSinhLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(NgSinhTf, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(HoLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(HoTf, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(SdtLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(SdtTf, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(TenLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TenTf, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(DiaChiLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DiaChiTf, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(GioiTinhLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(NamRb)
                                .addGap(67, 67, 67)
                                .addComponent(NuRb)
                                .addGap(65, 65, 65)))
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(OkBt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CancelBt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {CCCDTf, DemTf, DiaChiTf, HoTf, NgSinhTf, SdtTf, TenTf});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CCCDLbl)
                    .addComponent(CCCDTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HoLbl)
                    .addComponent(HoTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DemLbl)
                    .addComponent(DemTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TenLbl)
                    .addComponent(TenTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(NgSinhLbl)
                    .addComponent(NgSinhTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DiaChiLbl)
                    .addComponent(DiaChiTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SdtLbl)
                    .addComponent(SdtTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GioiTinhLbl)
                    .addComponent(NamRb)
                    .addComponent(NuRb))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OkBt)
                    .addComponent(CancelBt))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {CCCDTf, DemTf, DiaChiTf, HoTf, NgSinhTf, SdtTf, TenTf});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OkBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkBtActionPerformed
        if(HoTf.getText().replaceAll(" ", "").equals("") || 
           DemTf.getText().replaceAll(" ", "").equals("")  || NgSinhTf.getDate() == null || 
           DiaChiTf.getText().replaceAll(" ", "").equals("")  || SdtTf.getText().replaceAll(" ", "").equals("")  ||
           !NamRb.isSelected() && !NuRb.isSelected()){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin đầy đủ và chính xác!");                      
        }else if(StringProcessing.CheckPhone(SdtTf.getText())){
            JOptionPane.showMessageDialog(this, "Sai định dạng SĐT!!! - Phải là chữ số và đủ 10 ký tự");              
        }else if(CheckingDataExist.CheckExistPhone(SdtTf.getText(), Ps)){
            JOptionPane.showMessageDialog(this, "SĐT này đã tồn tại!!! - Vui lòng nhập SĐT khác"); 
        }else if(StringProcessing.CheckingDateAge(NgSinhTf.getDate())){
            JOptionPane.showMessageDialog(this, "Phải có ngày sinh đủ 18 tuổi!!! - Vui lòng kiểm tra lại thông tin"); 
        }else{
            int confirm = JOptionPane.showConfirmDialog(
                this,
                "Bạn có chắc muốn cập nhật thông tin người dùng có CCCD: " + CCCDTf.getText() + " không?",
            "Xác nhận thêm",
            JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                Personal_Infos Ps = new Personal_Infos();
                Ps.setCCCD(CCCDTf.getText());
                Ps.setFirstname(HoTf.getText());
                Ps.setMiddleName(DemTf.getText());
                Ps.setLastname(TenTf.getText());
                Ps.setAddress(DiaChiTf.getText());
                Ps.setPhone(SdtTf.getText());
                if(NamRb.isSelected())
                    Ps.setSex(true);
                else
                    Ps.setSex(false);
                Ps.setDOB(new java.sql.Date(NgSinhTf.getDate().getTime()));
                try{
                    DSThongTinChung.Update_NoCCCD(Ps);
                    JOptionPane.showMessageDialog(this, "Đã cập nhật thông tin người dùng có CCCD: " + CCCDTf.getText());
                    this.QlttChungMainView.ShowThongTinTuDBS(QlttChungMainView.getBangDSTTChung());
                    this.dispose();
                }catch(Exception e){
                    e.printStackTrace();
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
    private javax.swing.JLabel CCCDLbl;
    private javax.swing.JTextField CCCDTf;
    private javax.swing.JButton CancelBt;
    private javax.swing.JLabel DemLbl;
    private javax.swing.JTextField DemTf;
    private javax.swing.JLabel DiaChiLbl;
    private javax.swing.JTextField DiaChiTf;
    private javax.swing.ButtonGroup GioiTinhGroup;
    private javax.swing.JLabel GioiTinhLbl;
    private javax.swing.JLabel HoLbl;
    private javax.swing.JTextField HoTf;
    private javax.swing.JRadioButton NamRb;
    private javax.swing.JLabel NgSinhLbl;
    private com.toedter.calendar.JDateChooser NgSinhTf;
    private javax.swing.JRadioButton NuRb;
    private javax.swing.JButton OkBt;
    private javax.swing.JLabel SdtLbl;
    private javax.swing.JTextField SdtTf;
    private javax.swing.JLabel TenLbl;
    private javax.swing.JTextField TenTf;
    // End of variables declaration//GEN-END:variables
}
