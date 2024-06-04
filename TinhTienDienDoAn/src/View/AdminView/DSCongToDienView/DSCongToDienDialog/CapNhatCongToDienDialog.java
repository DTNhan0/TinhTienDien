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
import okhttp3.internal.Util;

public class CapNhatCongToDienDialog extends javax.swing.JDialog {
    private MainAdminView MainAdminview;
    private DSCongToDienSubView dSCongToDienSubView;
    private Type_Livings type_Livings = new Type_Livings();
    private Customers customers = new Customers();
    private E_Meters e_Meters = new E_Meters();
    
    public CapNhatCongToDienDialog(MainAdminView mainAdminView, DSCongToDienSubView dsctdsv, boolean modal) {
        initComponents();
        this.MainAdminview = mainAdminView;
        this.dSCongToDienSubView = dsctdsv;
        this.setModalityType(DEFAULT_MODALITY_TYPE.APPLICATION_MODAL);
        this.setTitle("Thêm thông tin công tơ điện");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        this.customers = dSCongToDienSubView.getCustomer();
        this.e_Meters = dSCongToDienSubView.getE_Meters();
        
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
            Logger.getLogger(CapNhatCongToDienDialog.class.getName()).log(Level.SEVERE, null, ex);
        }

        MaSoTf.setText(e_Meters.getID_E_Meter());
        MaSoCuTf.setText(e_Meters.getID_E_Meter());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        KinhDoanhGroup = new javax.swing.ButtonGroup();
        LoaiCapNhatGroup = new javax.swing.ButtonGroup();
        OkBt = new javax.swing.JButton();
        CancelBt = new javax.swing.JButton();
        MaSoLbl = new javax.swing.JLabel();
        NVNhapXuatLbl = new javax.swing.JLabel();
        LoaiNhaOLbl = new javax.swing.JLabel();
        DiaChiLbl = new javax.swing.JLabel();
        KinhDoanhLbl = new javax.swing.JLabel();
        MaSoTf = new javax.swing.JTextField();
        NVNhapXuatTf = new javax.swing.JTextField();
        DiaChiTf = new javax.swing.JTextField();
        CoRb = new javax.swing.JRadioButton();
        KhongRb = new javax.swing.JRadioButton();
        LoaiNhaOCb = new javax.swing.JComboBox<>();
        ThueText = new javax.swing.JLabel();
        ThueLbl = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        ThongTinChungCkb = new LayMotSoUIdepTaiDay.CheckBox();
        MaSoCkb = new LayMotSoUIdepTaiDay.CheckBox();
        jSeparator3 = new javax.swing.JSeparator();
        Logo = new javax.swing.JLabel();
        Dong1 = new javax.swing.JLabel();
        Dong2 = new javax.swing.JLabel();
        Dong3 = new javax.swing.JLabel();
        Dong4 = new javax.swing.JLabel();
        MaSoCuLbl = new javax.swing.JLabel();
        MaSoCuTf = new javax.swing.JTextField();
        MaSoMoiLbl = new javax.swing.JLabel();
        MaSoMoiTf = new javax.swing.JTextField();

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

        MaSoLbl.setText("Mã số:");
        MaSoLbl.setEnabled(false);

        NVNhapXuatLbl.setText("Nhân viên nhập xuất:");
        NVNhapXuatLbl.setEnabled(false);

        LoaiNhaOLbl.setText("Loại nhà ở:");
        LoaiNhaOLbl.setEnabled(false);

        DiaChiLbl.setText("Địa chỉ:");
        DiaChiLbl.setEnabled(false);

        KinhDoanhLbl.setText("Kinh doanh:");
        KinhDoanhLbl.setEnabled(false);

        MaSoTf.setEditable(false);

        NVNhapXuatTf.setEditable(false);

        DiaChiTf.setEnabled(false);

        KinhDoanhGroup.add(CoRb);
        CoRb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CoRb.setText("Có");
        CoRb.setEnabled(false);

        KinhDoanhGroup.add(KhongRb);
        KhongRb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        KhongRb.setText("Không");
        KhongRb.setEnabled(false);

        LoaiNhaOCb.setEnabled(false);
        LoaiNhaOCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoaiNhaOCbActionPerformed(evt);
            }
        });

        ThueText.setText("Thuế (kinh doanh):");
        ThueText.setEnabled(false);

        ThueLbl.setText("NULL");
        ThueLbl.setEnabled(false);

        jSeparator1.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("CẬP NHẬT CÔNG TƠ ĐIỆN:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Loại cập nhật:");

        jSeparator2.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator2.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        ThongTinChungCkb.setBackground(new java.awt.Color(0, 0, 0));
        ThongTinChungCkb.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        LoaiCapNhatGroup.add(ThongTinChungCkb);
        ThongTinChungCkb.setForeground(new java.awt.Color(0, 0, 0));
        ThongTinChungCkb.setText("Thông tin chung");
        ThongTinChungCkb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThongTinChungCkbActionPerformed(evt);
            }
        });

        MaSoCkb.setBackground(new java.awt.Color(0, 0, 0));
        MaSoCkb.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        LoaiCapNhatGroup.add(MaSoCkb);
        MaSoCkb.setForeground(new java.awt.Color(0, 0, 0));
        MaSoCkb.setText("Mã số công tơ điện");
        MaSoCkb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaSoCkbActionPerformed(evt);
            }
        });

        jSeparator3.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator3.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        Logo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Warning.png"))); // NOI18N
        Logo.setText("Cảnh báo:");
        Logo.setEnabled(false);

        Dong1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Dong1.setText("Việc đổi mã số công tơ điện sang tên mới ");
        Dong1.setEnabled(false);

        Dong2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Dong2.setText("đồng nghĩa với việc sau này mọi thông tin ");
        Dong2.setEnabled(false);

        Dong3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Dong3.setText("công tơ điện phụ thuộc vào mã số mới. ");
        Dong3.setEnabled(false);

        Dong4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Dong4.setText("Bạn nên cân nhắc kỹ về lựa chọn này!!!");
        Dong4.setEnabled(false);

        MaSoCuLbl.setText("Mã số(Cũ):");
        MaSoCuLbl.setEnabled(false);

        MaSoCuTf.setEditable(false);

        MaSoMoiLbl.setText("Mã số(Mới):");
        MaSoMoiLbl.setEnabled(false);

        MaSoMoiTf.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(KinhDoanhLbl)
                                .addGap(105, 105, 105)
                                .addComponent(CoRb)
                                .addGap(84, 84, 84)
                                .addComponent(KhongRb)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DiaChiLbl)
                                    .addComponent(LoaiNhaOLbl))
                                .addGap(77, 77, 77)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(DiaChiTf)
                                        .addGap(28, 28, 28))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(LoaiNhaOCb, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ThueText)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ThueLbl))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(OkBt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30)
                                                .addComponent(CancelBt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)))
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NVNhapXuatLbl)
                                    .addComponent(MaSoLbl))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(MaSoTf)
                                    .addComponent(NVNhapXuatTf))
                                .addGap(37, 37, 37)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(MaSoCuLbl)
                                .addGap(22, 22, 22)
                                .addComponent(MaSoCuTf))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Logo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Dong4)
                                            .addComponent(Dong3)
                                            .addComponent(Dong2)
                                            .addComponent(Dong1)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(MaSoMoiLbl)
                                        .addGap(16, 16, 16)
                                        .addComponent(MaSoMoiTf)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(ThongTinChungCkb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(MaSoCkb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ThongTinChungCkb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MaSoCkb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(MaSoLbl)
                                    .addComponent(MaSoTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(NVNhapXuatLbl)
                                    .addComponent(NVNhapXuatTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(LoaiNhaOLbl)
                                    .addComponent(LoaiNhaOCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ThueText)
                                    .addComponent(ThueLbl))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(DiaChiLbl)
                                    .addComponent(DiaChiTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(KinhDoanhLbl)
                                    .addComponent(CoRb)
                                    .addComponent(KhongRb)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Logo)
                                    .addComponent(Dong1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Dong2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Dong3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Dong4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(MaSoCuLbl)
                                    .addComponent(MaSoCuTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(MaSoMoiLbl)
                                    .addComponent(MaSoMoiTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CancelBt)
                                    .addComponent(OkBt))))))
                .addGap(29, 29, 29))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {DiaChiTf, MaSoTf, NVNhapXuatTf});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OkBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkBtActionPerformed
        if(!ThongTinChungCkb.isSelected() && !MaSoCkb.isSelected()){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn loại cập nhật!!!");            
        }else if(ThongTinChungCkb.isSelected()){
            if(DiaChiTf.getText().replaceAll(" ", "").equals("") || !CoRb.isSelected() && !KhongRb.isSelected()){
                JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin đầy đủ và chính xác!");
            }else{
                int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Bạn có chắc muốn cập nhật thông tin chung của công tơ điện không?",
                "Xác nhận cập nhật",
                JOptionPane.YES_NO_OPTION
                );
                if (confirm == JOptionPane.YES_OPTION) {
                    E_Meters e_meters = new E_Meters();     
                    
                    e_meters.setID_E_Meter(e_Meters.getID_E_Meter());
                    
                    e_meters.setID_Type_Living(type_Livings.getID_Type_Living());
                
                    if(CoRb.isSelected())
                        e_meters.setIs_Business(true);
                    else
                        e_meters.setIs_Business(false);
                
                    e_meters.setAddress(DiaChiTf.getText());
                
                    try{
                        DSE_Meter.Update(e_meters);
                        JOptionPane.showMessageDialog(this, "Đã cập nhật dữ liệu công tơ điện!!!");
                        this.dSCongToDienSubView.ShowThongTinTuDBS(dSCongToDienSubView.getBangDSE_Meter());
                        this.dispose();
                    }catch(Exception e){
                        System.out.println(e);
                        JOptionPane.showMessageDialog(this, "Lỗi hệ thống!!! - Vui lòng thử lại sau", "Lỗi", 
                                                    JOptionPane.ERROR_MESSAGE);
                    }
                }              
            }
        }else if(MaSoCkb.isSelected()){
            if(MaSoCuLbl.getText().replaceAll(" ", "").equals("")){
                JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin đầy đủ và chính xác!");
            }else if(StringProcessing.CheckID_E_Meter(MaSoTf.getText())){
                JOptionPane.showMessageDialog(this, "Sai định dạng mã số công tơ điện!!! - Phải là chữ số và đủ 8 ký tự");            
            }else if(CheckingDataExist.CheckExistIDE_Meter(MaSoTf.getText(), e_Meters)){
                JOptionPane.showMessageDialog(this, "Mã số công tơ điện này đã tồn tại!!! - Vui lòng nhập mã số khác");                         
            }else{
                int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Bạn có chắc muốn cập nhật thông tin chung của công tơ điện không?",
                "Xác nhận cập nhật",
                JOptionPane.YES_NO_OPTION
                );
                if (confirm == JOptionPane.YES_OPTION) {
                    try{
                        DSE_Meter.UpdateID(MaSoMoiTf.getText(), MaSoCuTf.getText());
                        JOptionPane.showMessageDialog(this, "Đã cập nhật dữ liệu công tơ điện!!!");
                        this.dSCongToDienSubView.ShowThongTinTuDBS(dSCongToDienSubView.getBangDSE_Meter());
                        this.dSCongToDienSubView.getLamMoiBt().doClick();
                        this.dSCongToDienSubView.getLamMoiBt().doClick();
                        this.dSCongToDienSubView.getLamMoiBt().doClick();
                        this.dispose();
                    }catch(Exception e){
                        System.out.println(e);
                        JOptionPane.showMessageDialog(this, "Lỗi hệ thống!!! - Vui lòng thử lại sau", "Lỗi", 
                                                    JOptionPane.ERROR_MESSAGE);
                    }
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

    private void ThongTinChungCkbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThongTinChungCkbActionPerformed
        MaSoMoiLbl.setEnabled(false);
        MaSoCuLbl.setEnabled(false);
        MaSoMoiTf.setEnabled(false);
        Dong1.setEnabled(false);
        Dong2.setEnabled(false);
        Dong3.setEnabled(false);
        Dong4.setEnabled(false);
        Logo.setEnabled(false);
        
        MaSoLbl.setEnabled(true);
        DiaChiLbl.setEnabled(true);
        DiaChiTf.setEnabled(true);
        LoaiNhaOLbl.setEnabled(true);
        DiaChiLbl.setEnabled(true);
        KinhDoanhLbl.setEnabled(true);
        ThueLbl.setEnabled(true);
        ThueText.setEnabled(true);
        CoRb.setEnabled(true);
        KhongRb.setEnabled(true);
        LoaiNhaOCb.setEnabled(true);
    }//GEN-LAST:event_ThongTinChungCkbActionPerformed

    private void MaSoCkbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaSoCkbActionPerformed
        MaSoMoiLbl.setEnabled(true);
        MaSoCuLbl.setEnabled(false);
        MaSoMoiTf.setEnabled(true);
        Dong1.setEnabled(true);
        Dong2.setEnabled(true);
        Dong3.setEnabled(true);
        Dong4.setEnabled(true);
        Logo.setEnabled(true);
        
        MaSoLbl.setEnabled(false);
        DiaChiLbl.setEnabled(false);
        DiaChiTf.setEnabled(false);
        LoaiNhaOLbl.setEnabled(false);
        DiaChiLbl.setEnabled(false);
        KinhDoanhLbl.setEnabled(false);
        ThueLbl.setEnabled(false);
        ThueText.setEnabled(false);
        CoRb.setEnabled(false);
        KhongRb.setEnabled(false);
        LoaiNhaOCb.setEnabled(false);
    }//GEN-LAST:event_MaSoCkbActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelBt;
    private javax.swing.JRadioButton CoRb;
    private javax.swing.JLabel DiaChiLbl;
    private javax.swing.JTextField DiaChiTf;
    private javax.swing.JLabel Dong1;
    private javax.swing.JLabel Dong2;
    private javax.swing.JLabel Dong3;
    private javax.swing.JLabel Dong4;
    private javax.swing.JRadioButton KhongRb;
    private javax.swing.ButtonGroup KinhDoanhGroup;
    private javax.swing.JLabel KinhDoanhLbl;
    private javax.swing.ButtonGroup LoaiCapNhatGroup;
    private javax.swing.JComboBox<String> LoaiNhaOCb;
    private javax.swing.JLabel LoaiNhaOLbl;
    private javax.swing.JLabel Logo;
    private LayMotSoUIdepTaiDay.CheckBox MaSoCkb;
    private javax.swing.JLabel MaSoCuLbl;
    private javax.swing.JTextField MaSoCuTf;
    private javax.swing.JLabel MaSoLbl;
    private javax.swing.JLabel MaSoMoiLbl;
    private javax.swing.JTextField MaSoMoiTf;
    private javax.swing.JTextField MaSoTf;
    private javax.swing.JLabel NVNhapXuatLbl;
    private javax.swing.JTextField NVNhapXuatTf;
    private javax.swing.JButton OkBt;
    private LayMotSoUIdepTaiDay.CheckBox ThongTinChungCkb;
    private javax.swing.JLabel ThueLbl;
    private javax.swing.JLabel ThueText;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
