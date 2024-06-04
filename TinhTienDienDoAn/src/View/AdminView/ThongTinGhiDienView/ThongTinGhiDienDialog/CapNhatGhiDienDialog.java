package View.AdminView.ThongTinGhiDienView.ThongTinGhiDienDialog;

import Controller.DSChuHoController.DSChuHo;
import Controller.DSE_MeterController.DSE_Meter;
import Controller.DSNhanVienController.DSNhanVien;
import Controller.DSThongTinGhiDienController.DSThongTinGhiDien;
import Controller.QLPhanQuyenTKController.DSTaiKhoanPhanQuyen;
import Controller.QLThongTinChungController.DSThongTinChung;
import Model.E_Meter_Details;
import Model.Staffs;
import View.AdminView.MainAdminView;
import View.AdminView.ThongTinGhiDienView.ThongTinGhiDienSubLowView;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Controller.SupportFunction.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import Model.E_Meters;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CapNhatGhiDienDialog extends javax.swing.JDialog {
    private Staffs staffs;
    private E_Meters e_Meters;
    private E_Meter_Details e_Meter_Details;
    private List<E_Meter_Details> lstE_MeterDetails = new ArrayList<>();
    
    private MainAdminView MainAdminview;
    private ThongTinGhiDienSubLowView thongTinGhiDienSubLowView;
    
    public CapNhatGhiDienDialog(MainAdminView mainAdminView, ThongTinGhiDienSubLowView ttgdslv, boolean modal) {
        initComponents();
        this.MainAdminview = mainAdminView;
        this.thongTinGhiDienSubLowView = ttgdslv;
        this.setModalityType(DEFAULT_MODALITY_TYPE.APPLICATION_MODAL);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.staffs = thongTinGhiDienSubLowView.getStaffs();
        this.e_Meters = thongTinGhiDienSubLowView.getE_Meters();
        this.lstE_MeterDetails = thongTinGhiDienSubLowView.getListE_Meter_Details();
        this.e_Meter_Details = thongTinGhiDienSubLowView.getE_Meter_Details();
        
        LocalDate currentDate = LocalDate.now();

        Date date = Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        NgayGhiDienJDate.setDate(date);
        MaSoTf.setText(e_Meters.getID_E_Meter());
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
        TotalDienTf = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        NgayGhiDienJDate = new com.toedter.calendar.JDateChooser();

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

        DiaChiLbl.setText("Tổng số điện theo tháng:");

        IDTf.setEditable(false);
        IDTf.setText("(ID tự tăng)");

        MaSoTf.setEditable(false);

        jSeparator1.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("THÊM THÔNG TIN GHI ĐIỆN:");

        NgayGhiDienJDate.setDateFormatString("dd / MM / yyyy");
        NgayGhiDienJDate.setMinSelectableDate(new java.util.Date(-62135791102000L));

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
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(OkBt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(CancelBt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33))
                                    .addComponent(NgayGhiDienJDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TotalDienTf, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(HoLbl)
                                    .addComponent(CCCDLbl))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(IDTf, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                                    .addComponent(MaSoTf))))
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
                    .addComponent(TotalDienTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OkBt)
                    .addComponent(CancelBt))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {IDTf, MaSoTf, TotalDienTf});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OkBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkBtActionPerformed
        if(TotalDienTf.getText().replaceAll(" ", "").equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin đầy đủ và chính xác!");
        }else if(StringProcessing.CheckIsNumber(TotalDienTf.getText())){
            JOptionPane.showMessageDialog(this, "Sai định dạng tổng số Kwh!!! - Phải là chữ số");            
        }else if(CheckingDataExist.CheckExistDateE_Meter_Details(NgayGhiDienJDate.getDate(), e_Meter_Details, lstE_MeterDetails)){
            JOptionPane.showMessageDialog(this, "Thông tin ghi điện có số tháng và năm trùng với dòng dữ liệu khác, bạn vui lòng kiểm tra kỹ lại thông tin");                         
        }else{
            int confirm = JOptionPane.showConfirmDialog(
                this,
                "Bạn có chắc muốn cập nhật dữ liệu ghi điện cho ID: " + e_Meter_Details.getID_E_Meter_Detail() + " không?",
            "Xác nhận thêm",
            JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                E_Meter_Details e_Meter_DetailsTemp = new E_Meter_Details();
                
                // Giả sử bạn đã lấy được đối tượng Date từ NgayGhiDienJDate
                Date date = NgayGhiDienJDate.getDate();

                // Chuyển đổi đối tượng Date thành định dạng yyyy-MM-dd
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String formattedDateStr = dateFormat.format(date);

                try {
                    Date formattedDate = dateFormat.parse(formattedDateStr);
                    e_Meter_DetailsTemp.setCreating_Date(formattedDate);                    
                } catch (ParseException e) {
                    e.printStackTrace();
                
                }             
                e_Meter_DetailsTemp.setID_E_Meter(e_Meters.getID_E_Meter());
                e_Meter_DetailsTemp.setCurrent_Num(Integer.parseInt(TotalDienTf.getText()));
                e_Meter_DetailsTemp.setID_Staff_Input(staffs.getID_Staff());
                e_Meter_DetailsTemp.setID_E_Meter_Detail(e_Meter_Details.getID_E_Meter_Detail());
                
                try{
                    DSThongTinGhiDien.Update(e_Meter_DetailsTemp);
                    JOptionPane.showMessageDialog(this, "Đã cập nhật dữ liệu ghi điện!!!");
                    new DSThongTinGhiDien().KhoiTaoListE_Meters_Details();
                    new DSE_Meter().KhoiTaoListE_Meters();
                    new DSThongTinChung().KhoiTaoListPersonal_Infos();
                    new DSTaiKhoanPhanQuyen().KhoiTaoListAccount();
                    new DSChuHo().KhoiTaoListCustomeres();
                    new DSNhanVien().KhoiTaoListStaffs();
                    
                    this.thongTinGhiDienSubLowView.ShowThongTinTuDBS(thongTinGhiDienSubLowView.getBangDSE_Meter());
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
    private javax.swing.JLabel CCCDLbl;
    private javax.swing.JButton CancelBt;
    private javax.swing.JLabel DemLbl;
    private javax.swing.JLabel DiaChiLbl;
    private javax.swing.JLabel HoLbl;
    private javax.swing.JTextField IDTf;
    private javax.swing.JTextField MaSoTf;
    private com.toedter.calendar.JDateChooser NgayGhiDienJDate;
    private javax.swing.JButton OkBt;
    private javax.swing.JTextField TotalDienTf;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
