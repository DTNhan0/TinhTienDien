package View.AdminView.DSCongToDienView.DSCongToDienDialog;

import Controller.DAO.AssignmentsDAO;
import Controller.DAO.Type_LivingsDAO;
import Controller.DSE_MeterController.DSE_Meter;
import Controller.DSNhanVienController.DSNhanVien;
import Controller.QLThongTinChungController.DSThongTinChung;
import Controller.SupportFunction.CheckingDataExist;
import Controller.SupportFunction.StringProcessing;
import Model.Assignments;
import Model.Customers;
import Model.E_Meters;
import Model.Personal_Infos;
import Model.Staffs;
import Model.Type_Livings;
import View.AdminView.DSCongToDienView.DSCongToDienSubView;
import View.AdminView.MainAdminView;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ThemCongToDienDialog extends javax.swing.JDialog {
    private MainAdminView MainAdminview;
    private DSCongToDienSubView dSCongToDienSubView;
    private Type_Livings type_Livings = new Type_Livings();
    private Customers customers = new Customers();
    
    public ThemCongToDienDialog(MainAdminView mainAdminView, DSCongToDienSubView dsctdsv, boolean modal) {
        initComponents();
        this.MainAdminview = mainAdminView;
        this.dSCongToDienSubView = dsctdsv;
        this.setModalityType(DEFAULT_MODALITY_TYPE.APPLICATION_MODAL);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        this.customers = dSCongToDienSubView.getCustomer();
        
        for(Type_Livings tl : new Type_LivingsDAO().getAll()){
            LoaiNhaOCb.addItem(tl.getDetails());
        }
        
        try {
            for(Assignments assignments : new AssignmentsDAO().getAll()){
                if(assignments.getID_Customer() == customers.getID_Customer() && assignments.getID_Staff_Write() != null){
                    Staffs staffs = DSNhanVien.SearchObjID(assignments.getID_Staff_Write());
                    NVNhapXuatTf.setText(staffs.getCCCD());
                    break;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ThemCongToDienDialog.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        KinhDoanhGroup = new javax.swing.ButtonGroup();
        OkBt = new javax.swing.JButton();
        CancelBt = new javax.swing.JButton();
        CCCDLbl = new javax.swing.JLabel();
        HoLbl = new javax.swing.JLabel();
        DemLbl = new javax.swing.JLabel();
        DiaChiLbl = new javax.swing.JLabel();
        GioiTinhLbl = new javax.swing.JLabel();
        MaSoTf = new javax.swing.JTextField();
        NVNhapXuatTf = new javax.swing.JTextField();
        DiaChiTf = new javax.swing.JTextField();
        CoRb = new javax.swing.JRadioButton();
        KhongRb = new javax.swing.JRadioButton();
        LoaiNhaOCb = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        ThueLbl = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
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

        CCCDLbl.setText("Mã số:");

        HoLbl.setText("Nhân viên nhập xuất:");

        DemLbl.setText("Loại nhà ở:");

        DiaChiLbl.setText("Địa chỉ:");

        GioiTinhLbl.setText("Kinh doanh:");

        NVNhapXuatTf.setEditable(false);

        KinhDoanhGroup.add(CoRb);
        CoRb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CoRb.setText("Có");

        KinhDoanhGroup.add(KhongRb);
        KhongRb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        KhongRb.setText("Không");

        LoaiNhaOCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoaiNhaOCbActionPerformed(evt);
            }
        });

        jLabel1.setText("Thuế (kinh doanh):");

        ThueLbl.setText("NULL");

        jSeparator1.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("THÊM CÔNG TƠ ĐIỆN:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DiaChiLbl)
                                    .addComponent(DemLbl))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ThueLbl)
                                        .addGap(22, 22, 22))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(82, 82, 82)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(OkBt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(CancelBt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(DiaChiTf)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(HoLbl)
                                    .addComponent(CCCDLbl))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(LoaiNhaOCb, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(NVNhapXuatTf, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(MaSoTf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(GioiTinhLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CoRb)
                                .addGap(67, 67, 67)
                                .addComponent(KhongRb)
                                .addGap(94, 94, 94)))
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CCCDLbl)
                    .addComponent(MaSoTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HoLbl)
                    .addComponent(NVNhapXuatTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DemLbl)
                    .addComponent(LoaiNhaOCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(ThueLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DiaChiLbl)
                    .addComponent(DiaChiTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GioiTinhLbl)
                    .addComponent(CoRb)
                    .addComponent(KhongRb))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OkBt)
                    .addComponent(CancelBt))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {DiaChiTf, MaSoTf, NVNhapXuatTf});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OkBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkBtActionPerformed
        if(MaSoTf.getText().replaceAll(" ", "").equals("") || NVNhapXuatTf.getText().replaceAll(" ", "").equals("") || 
           DiaChiTf.getText().replaceAll(" ", "").equals("") || !CoRb.isSelected() && !KhongRb.isSelected()){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin đầy đủ và chính xác!");
        }else if(StringProcessing.CheckID_E_Meter(MaSoTf.getText())){
            JOptionPane.showMessageDialog(this, "Sai định dạng mã số công tơ điện!!! - Phải là chữ số và đủ 8 ký tự");            
        }else if(CheckingDataExist.CheckExistIDE_Meter(MaSoTf.getText(), null)){
            JOptionPane.showMessageDialog(this, "Mã số công tơ điện này đã tồn tại!!! - Vui lòng nhập mã số khác");                         
        }else{
            int confirm = JOptionPane.showConfirmDialog(
                this,
                "Bạn có chắc muốn thêm dữ liệu công tơ điện không?",
            "Xác nhận thêm",
            JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                E_Meters e_Meters = new E_Meters();
                e_Meters.setID_E_Meter(MaSoTf.getText());
                
                try {
                    for(Assignments assignments : new AssignmentsDAO().getAll()){
                        if(assignments.getID_Customer() == customers.getID_Customer()){
                            e_Meters.setID_Assignment(assignments.getID_Assignment());
                            break;
                        }
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ThemCongToDienDialog.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                e_Meters.setID_Type_Living(type_Livings.getID_Type_Living());
                
                if(CoRb.isSelected())
                    e_Meters.setIs_Business(true);
                else
                    e_Meters.setIs_Business(false);
                
                e_Meters.setAddress(DiaChiTf.getText());
                
                try{
                    DSE_Meter.Add(e_Meters);
                    JOptionPane.showMessageDialog(this, "Đã thêm dữ liệu công tơ điện!!!");
                    this.dSCongToDienSubView.ShowThongTinTuDBS(dSCongToDienSubView.getBangDSE_Meter());
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

    private void LoaiNhaOCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoaiNhaOCbActionPerformed
        String selected;
        selected = (String) LoaiNhaOCb.getSelectedItem();
        if(selected.equals("Nhà ở")){
            type_Livings.setID_Type_Living(1);
            ThueLbl.setText("15%");
        }else if(selected.equals("Chung cư")){
            type_Livings.setID_Type_Living(2);
            ThueLbl.setText("10%");
        }else if(selected.equals("Nhà trọ")){
            type_Livings.setID_Type_Living(3);
            ThueLbl.setText("5%");
        }else if(selected.equals("Mặt tiền")){
            type_Livings.setID_Type_Living(4);
            ThueLbl.setText("20%");
        }
    }//GEN-LAST:event_LoaiNhaOCbActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CCCDLbl;
    private javax.swing.JButton CancelBt;
    private javax.swing.JRadioButton CoRb;
    private javax.swing.JLabel DemLbl;
    private javax.swing.JLabel DiaChiLbl;
    private javax.swing.JTextField DiaChiTf;
    private javax.swing.JLabel GioiTinhLbl;
    private javax.swing.JLabel HoLbl;
    private javax.swing.JRadioButton KhongRb;
    private javax.swing.ButtonGroup KinhDoanhGroup;
    private javax.swing.JComboBox<String> LoaiNhaOCb;
    private javax.swing.JTextField MaSoTf;
    private javax.swing.JTextField NVNhapXuatTf;
    private javax.swing.JButton OkBt;
    private javax.swing.JLabel ThueLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
