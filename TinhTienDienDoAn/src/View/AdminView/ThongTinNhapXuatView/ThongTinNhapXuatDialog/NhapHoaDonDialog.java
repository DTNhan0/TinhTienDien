package View.AdminView.ThongTinNhapXuatView.ThongTinNhapXuatDialog;

import Controller.DAO.LevelsDAO;
import Controller.DAO.Type_LivingsDAO;
import Controller.DSChuHoController.DSChuHo;
import Controller.DSE_MeterController.DSE_Meter;
import Controller.DSHoaDonDienController.DSHoaDonDien;
import Controller.DSNhanVienController.DSNhanVien;
import Controller.DSThongTinGhiDienController.DSThongTinGhiDien;
import Controller.QLPhanQuyenTKController.DSTaiKhoanPhanQuyen;
import Controller.QLThongTinChungController.DSThongTinChung;
import Model.E_Meter_Details;
import Model.Staffs;
import View.AdminView.MainAdminView;
import javax.swing.JOptionPane;
import Controller.SupportFunction.*;
import Model.E_Meters;
import Model.Invoices;
import Model.Levels;
import Model.Type_Livings;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import View.AdminView.ThongTinNhapXuatView.ThongTinNhapXuatSubLowView;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class NhapHoaDonDialog extends javax.swing.JDialog {
    private Staffs staffs;
    private E_Meter_Details e_Meter_Details;
    private E_Meter_Details OldEMD;
    private MainAdminView MainAdminview;
    private ThongTinNhapXuatSubLowView thongTinNhapXuatSubLowView;
    
    public NhapHoaDonDialog(MainAdminView mainAdminView, ThongTinNhapXuatSubLowView ttnxslv, boolean modal) {
        initComponents();
        this.MainAdminview = mainAdminView;
        this.thongTinNhapXuatSubLowView = ttnxslv;
        this.setModalityType(DEFAULT_MODALITY_TYPE.APPLICATION_MODAL);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        this.e_Meter_Details = thongTinNhapXuatSubLowView.getE_Meter_Details();
        this.staffs = thongTinNhapXuatSubLowView.getStaffs();
        
        LocalDate currentDate = LocalDate.now();

        Date date = Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        NgayGhiDienJDate.setDate(date);
        
        MaSoTf.setText(e_Meter_Details.getID_E_Meter());
        
        CCCDNVTf.setText(staffs.getCCCD());
        this.OldEMD = DSThongTinGhiDien.FindClosetDateE_MeterDetails(e_Meter_Details);        
            
        if(OldEMD != null){  
            int id = OldEMD.getID_E_Meter_Detail();
            String idStr = String.valueOf(id);
            IDOldEMDTf.setText(idStr);

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date1 = OldEMD.getCreating_Date();
            String dateStr = dateFormat.format(date1);
            DateOldEMDTf.setText(dateStr);
        
            int Total = e_Meter_Details.getCurrent_Num() - OldEMD.getCurrent_Num();
        
            int OldKwh = OldEMD.getCurrent_Num();
            String oldKwh = String.valueOf(OldKwh);
            NumOldEMDTf.setText(oldKwh);
        
            TotalTf.setText(String.valueOf(Total));            
        }else{
            int Total = e_Meter_Details.getCurrent_Num();
            TotalTf.setText(String.valueOf(Total));
        }

        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        OkBt = new javax.swing.JButton();
        CancelBt = new javax.swing.JButton();
        CCCDLbl = new javax.swing.JLabel();
        HoLbl = new javax.swing.JLabel();
        DemLbl = new javax.swing.JLabel();
        DiaChiLbl = new javax.swing.JLabel();
        IDTf = new javax.swing.JTextField();
        MaSoTf = new javax.swing.JTextField();
        CCCDNVTf = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        NgayGhiDienJDate = new com.toedter.calendar.JDateChooser();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        IDOldEMDTf = new javax.swing.JTextField();
        DateOldEMDTf = new javax.swing.JTextField();
        NumOldEMDTf = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TotalTf = new javax.swing.JTextField();
        TinhTienBt = new javax.swing.JButton();
        MoneyTf = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        DinhMucLbl = new javax.swing.JLabel();
        CoThueLbl = new javax.swing.JLabel();
        ThueLbl = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        LoaiNhaOLbl = new javax.swing.JLabel();

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

        CCCDLbl.setText("ID:");

        HoLbl.setText("Mã số:");

        DemLbl.setText("Ngày ghi điện:");

        DiaChiLbl.setText("CCCD nhân viên nhập:");

        IDTf.setEditable(false);
        IDTf.setText("(ID tự tăng)");

        MaSoTf.setEditable(false);

        CCCDNVTf.setEditable(false);

        jSeparator1.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("NHẬP THÔNG TIN ĐIỆN:");

        NgayGhiDienJDate.setDateFormatString("dd / MM / yyyy");
        NgayGhiDienJDate.setMinSelectableDate(new java.util.Date(-62135791102000L));

        jSeparator2.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator2.setForeground(new java.awt.Color(51, 51, 51));

        jLabel1.setText("Tính tiền điện:");

        jLabel3.setText("ID thông tin ghi điện tháng trước:");

        jLabel4.setText("Thông tin ngày ghi điện tháng trước:");

        jLabel5.setText("Số Kwh điện tháng trước:");

        IDOldEMDTf.setEditable(false);
        IDOldEMDTf.setText("NULL");

        DateOldEMDTf.setEditable(false);
        DateOldEMDTf.setText("NULL");

        NumOldEMDTf.setEditable(false);
        NumOldEMDTf.setText("NULL");

        jLabel6.setText("Tổng số Kwh điện từ tháng trước đến tháng hiện tại:");

        TotalTf.setEditable(false);
        TotalTf.setText("NULL");

        TinhTienBt.setText("Tính tiền");
        TinhTienBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TinhTienBtActionPerformed(evt);
            }
        });

        MoneyTf.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Định mức:");

        DinhMucLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DinhMucLbl.setText("NULL");

        CoThueLbl.setText("Thuế kinh doanh:");

        ThueLbl.setText("NULL");

        jLabel8.setText("Loại nhà đất:");

        LoaiNhaOLbl.setText("NULL");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DiaChiLbl)
                                    .addComponent(DemLbl))
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NgayGhiDienJDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CCCDNVTf, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(HoLbl)
                                    .addComponent(CCCDLbl))
                                .addGap(93, 93, 93)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(IDTf)
                                    .addComponent(MaSoTf))))
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(OkBt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(CancelBt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NumOldEMDTf)
                            .addComponent(DateOldEMDTf, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(IDOldEMDTf)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TotalTf))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TinhTienBt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(LoaiNhaOLbl)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(MoneyTf, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(DinhMucLbl))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CoThueLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ThueLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(53, 53, 53)))))
                .addContainerGap())
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
                    .addComponent(IDTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HoLbl)
                    .addComponent(MaSoTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DemLbl)
                    .addComponent(NgayGhiDienJDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DiaChiLbl)
                    .addComponent(CCCDNVTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(IDOldEMDTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(DateOldEMDTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(NumOldEMDTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TotalTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(LoaiNhaOLbl))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(CoThueLbl)
                    .addComponent(ThueLbl))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MoneyTf, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TinhTienBt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DinhMucLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OkBt)
                    .addComponent(CancelBt))
                .addGap(17, 17, 17))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {CCCDNVTf, IDTf, MaSoTf});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OkBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkBtActionPerformed
        if(MoneyTf.getText().replaceAll(" ", "").equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng tính tiền điện trước khi nhập!");
        }else if(OldEMD != null){
            int confirm = JOptionPane.showConfirmDialog(
                this,
                "Bạn có chắc muốn nhập dữ liệu ghi điện không?",
            "Xác nhận thêm",
            JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                Invoices invoices = new Invoices();
                
                // Giả sử bạn đã lấy được đối tượng Date từ NgayGhiDienJDate
                Date date = NgayGhiDienJDate.getDate();

                // Chuyển đổi đối tượng Date thành định dạng yyyy-MM-dd
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String formattedDateStr = dateFormat.format(date);

                try {
                    Date formattedDate = dateFormat.parse(formattedDateStr);
                    invoices.setInvoice_Date(formattedDate);                    
                } catch (ParseException e) {
                    e.printStackTrace();
                
                }             
                invoices.setID_E_Meter_Details(e_Meter_Details.getID_E_Meter_Detail());
                invoices.setID_Invoice(0);
                invoices.setID_Level(Integer.parseInt(DinhMucLbl.getText()));
                invoices.setID_Staff_Write(staffs.getID_Staff());
                invoices.setStatus(true);
                invoices.setTotal_Price(Float.parseFloat(MoneyTf.getText()));
                
                try{
                    DSHoaDonDien.Add(invoices);
                    JOptionPane.showMessageDialog(this, "Đã thêm dữ liệu ghi điện!!!");
                    new DSThongTinGhiDien().KhoiTaoListE_Meters_Details();
                    new DSE_Meter().KhoiTaoListE_Meters();
                    new DSThongTinChung().KhoiTaoListPersonal_Infos();
                    new DSTaiKhoanPhanQuyen().KhoiTaoListAccount();
                    new DSChuHo().KhoiTaoListCustomeres();
                    new DSNhanVien().KhoiTaoListStaffs();
                    
                    this.thongTinNhapXuatSubLowView.ShowThongTinTuDBS(thongTinNhapXuatSubLowView.getBangDSE_Meter());
                    this.dispose();
                }catch(Exception e){
                    System.out.println(e);
                    JOptionPane.showMessageDialog(this, "Lỗi hệ thống!!! - Vui lòng thử lại sau", "Lỗi", 
                                                  JOptionPane.ERROR_MESSAGE);
                }
            }              
        }else{
                Invoices invoices = new Invoices();
                
                // Giả sử bạn đã lấy được đối tượng Date từ NgayGhiDienJDate
                Date date = NgayGhiDienJDate.getDate();

                // Chuyển đổi đối tượng Date thành định dạng yyyy-MM-dd
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String formattedDateStr = dateFormat.format(date);

                try {
                    Date formattedDate = dateFormat.parse(formattedDateStr);
                    invoices.setInvoice_Date(formattedDate);                    
                } catch (ParseException e) {
                    e.printStackTrace();
                
                }             
                invoices.setID_E_Meter_Details(e_Meter_Details.getID_E_Meter_Detail());
                invoices.setID_Invoice(0);
                invoices.setID_Level(Integer.parseInt(DinhMucLbl.getText()));
                invoices.setID_Staff_Write(staffs.getID_Staff());
                invoices.setStatus(true);
                invoices.setTotal_Price(Float.parseFloat(MoneyTf.getText()));     
               
                try{
                    DSHoaDonDien.Add(invoices);
                    JOptionPane.showMessageDialog(this, "Đã thêm dữ liệu ghi điện!!!");
                    new DSThongTinGhiDien().KhoiTaoListE_Meters_Details();
                    new DSE_Meter().KhoiTaoListE_Meters();
                    new DSThongTinChung().KhoiTaoListPersonal_Infos();
                    new DSTaiKhoanPhanQuyen().KhoiTaoListAccount();
                    new DSChuHo().KhoiTaoListCustomeres();
                    new DSNhanVien().KhoiTaoListStaffs();
                    
                    this.thongTinNhapXuatSubLowView.ShowThongTinTuDBS(thongTinNhapXuatSubLowView.getBangDSE_Meter());
                    this.dispose();
                }catch(Exception e){
                    System.out.println(e);
                    JOptionPane.showMessageDialog(this, "Lỗi hệ thống!!! - Vui lòng thử lại sau", "Lỗi", 
                                                  JOptionPane.ERROR_MESSAGE);
                }
        }
    }//GEN-LAST:event_OkBtActionPerformed

    private void CancelBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtActionPerformed
        this.dispose();
    }//GEN-LAST:event_CancelBtActionPerformed

    private void TinhTienBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TinhTienBtActionPerformed
        float TienDien = DSHoaDonDien.TinhTienDien(e_Meter_Details);
        float SoKwh = Float.parseFloat(TotalTf.getText());

        for(Levels levels : new LevelsDAO().getAll()){
            if(SoKwh >= levels.getMinimum() && SoKwh <= levels.getMaximum()){
                DinhMucLbl.setText(String.valueOf(levels.getID_Level()));
                break;
            }
        }
        
        float ThueKinhDoanh = 0;
        E_Meters e_Meters = DSE_Meter.SearchObjID(e_Meter_Details.getID_E_Meter());
        
        for(Type_Livings type_Livings : new Type_LivingsDAO().getAll()){
            if(type_Livings.getID_Type_Living() == e_Meters.getID_Type_Living()){
                if(e_Meters.isIs_Business())
                    ThueKinhDoanh = type_Livings.getTax();
                LoaiNhaOLbl.setText(type_Livings.getDetails());
                break;
            }
        }
        
        TienDien = TienDien + TienDien * ThueKinhDoanh;
        ThueLbl.setText(String.valueOf(Math.floor(ThueKinhDoanh * 100.0)) + "%"); 
        MoneyTf.setText(String.valueOf(TienDien));
    }//GEN-LAST:event_TinhTienBtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CCCDLbl;
    private javax.swing.JTextField CCCDNVTf;
    private javax.swing.JButton CancelBt;
    private javax.swing.JLabel CoThueLbl;
    private javax.swing.JTextField DateOldEMDTf;
    private javax.swing.JLabel DemLbl;
    private javax.swing.JLabel DiaChiLbl;
    private javax.swing.JLabel DinhMucLbl;
    private javax.swing.JLabel HoLbl;
    private javax.swing.JTextField IDOldEMDTf;
    private javax.swing.JTextField IDTf;
    private javax.swing.JLabel LoaiNhaOLbl;
    private javax.swing.JTextField MaSoTf;
    private javax.swing.JTextField MoneyTf;
    private com.toedter.calendar.JDateChooser NgayGhiDienJDate;
    private javax.swing.JTextField NumOldEMDTf;
    private javax.swing.JButton OkBt;
    private javax.swing.JLabel ThueLbl;
    private javax.swing.JButton TinhTienBt;
    private javax.swing.JTextField TotalTf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
