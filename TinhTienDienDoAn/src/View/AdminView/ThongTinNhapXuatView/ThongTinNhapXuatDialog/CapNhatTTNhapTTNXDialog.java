package View.AdminView.ThongTinNhapXuatView.ThongTinNhapXuatDialog;

import Controller.DAO.LevelsDAO;
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
import Model.Invoices;
import Model.Levels;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import View.AdminView.ThongTinNhapXuatView.ThongTinNhapXuatSubLowView;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CapNhatTTNhapTTNXDialog extends javax.swing.JDialog {
    private Staffs staffs;
    private E_Meter_Details e_Meter_Details;
    private Invoices invoices;
    private MainAdminView MainAdminview;
    private ThongTinNhapXuatSubLowView thongTinNhapXuatSubLowView;
    
    public CapNhatTTNhapTTNXDialog(MainAdminView mainAdminView, ThongTinNhapXuatSubLowView ttnxslv, boolean modal) {
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
        
        for(Staffs staffs : DSNhanVien.getListStaffs()){
            if(staffs.getRoleStaff() == 1){
                CCCDTfCb.addItem(staffs.getCCCD()); 
            }
        }
        
        for(Invoices i : DSHoaDonDien.getListInvoices()){
            if(i.getID_E_Meter_Details() == e_Meter_Details.getID_E_Meter_Detail())
                invoices = i;
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
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        NgayGhiDienJDate = new com.toedter.calendar.JDateChooser();
        CCCDTfCb = new javax.swing.JComboBox<>();

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

        jSeparator1.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("NHẬP THÔNG TIN ĐIỆN:");

        NgayGhiDienJDate.setDateFormatString("dd / MM / yyyy");
        NgayGhiDienJDate.setMinSelectableDate(new java.util.Date(-62135791102000L));

        CCCDTfCb.setEditable(true);
        CCCDTfCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CCCDTfCbActionPerformed(evt);
            }
        });

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
                                    .addComponent(HoLbl)
                                    .addComponent(CCCDLbl))
                                .addGap(93, 93, 93)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(IDTf)
                                    .addComponent(MaSoTf)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DiaChiLbl)
                                    .addComponent(DemLbl))
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(OkBt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(55, 55, 55)
                                        .addComponent(CancelBt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE))
                                    .addComponent(NgayGhiDienJDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CCCDTfCb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                    .addComponent(CCCDTfCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OkBt)
                    .addComponent(CancelBt))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {IDTf, MaSoTf});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OkBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkBtActionPerformed
            int confirm = JOptionPane.showConfirmDialog(
                this,
                "Bạn có chắc muốn nhập dữ liệu ghi điện không?",
            "Xác nhận thêm",
            JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                Invoices invoices = this.invoices;
                
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
                
                invoices.setID_Staff_Write(staffs.getID_Staff());
                
                try{
                    DSHoaDonDien.Update(invoices);
                    JOptionPane.showMessageDialog(this, "Đã cập nhật dữ liệu nhập điện!!!");
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

    private void CCCDTfCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CCCDTfCbActionPerformed
        String CCCD = (String)CCCDTfCb.getSelectedItem();
        this.staffs = DSNhanVien.SearchObjCCCD(CCCD);
    }//GEN-LAST:event_CCCDTfCbActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CCCDLbl;
    private javax.swing.JComboBox<String> CCCDTfCb;
    private javax.swing.JButton CancelBt;
    private javax.swing.JLabel DemLbl;
    private javax.swing.JLabel DiaChiLbl;
    private javax.swing.JLabel HoLbl;
    private javax.swing.JTextField IDTf;
    private javax.swing.JTextField MaSoTf;
    private com.toedter.calendar.JDateChooser NgayGhiDienJDate;
    private javax.swing.JButton OkBt;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
