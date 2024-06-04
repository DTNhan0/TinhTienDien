package View.AdminView.ThongTinGhiDienView;

import Controller.DAO.Type_LivingsDAO;
import Controller.DSChuHoController.DSChuHo;
import Controller.DSE_MeterController.DSE_Meter;
import Controller.DSNhanVienController.DSNhanVien;
import Controller.DSThongTinGhiDienController.DSThongTinGhiDien;
import Controller.QLPhanQuyenTKController.DSTaiKhoanPhanQuyen;
import Controller.QLThongTinChungController.DSThongTinChung;
import Controller.SupportFunction.StringProcessing;
import LayMotSoUIdepTaiDay.BangDanhSach;
import LayMotSoUIdepTaiDay.ButtonThuong;
import Model.E_Meter_Details;
import Model.E_Meters;
import Model.Staffs;
import Model.Type_Livings;
import View.AdminView.MainAdminView;
import View.AdminView.ThongTinGhiDienView.ThongTinGhiDienDialog.CapNhatGhiDienDialog;
import View.AdminView.ThongTinGhiDienView.ThongTinGhiDienDialog.GhiDienDialog;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ThongTinGhiDienSubLowView extends javax.swing.JPanel {
    private E_Meters e_Meters;
    private MainAdminView MainAdminview; 
    private Staffs staffs;
    private List <E_Meter_Details> ListE_Meter_Details = new ArrayList<>();
    private E_Meter_Details e_Meter_Details;
    
    private ThongTinGhiDienSubHighView thongTinGhiDienSubHighView;
    
    public ThongTinGhiDienSubLowView(MainAdminView mainAdminView, ThongTinGhiDienSubHighView ttgdshv, Boolean model) {
        initComponents();
        this.MainAdminview = mainAdminView;
        this.setSize(MainAdminview.getMainPanel().getSize());
        this.thongTinGhiDienSubHighView = ttgdshv;
        this.staffs = thongTinGhiDienSubHighView.getStaffs();
        this.e_Meters = thongTinGhiDienSubHighView.getE_Meters();
        this.ListE_Meter_Details = e_Meters.getListE_Meter_Details();
        
        String LoaiNhaO = null;
        for(Type_Livings tl : new Type_LivingsDAO().getAll()){
            if(e_Meters.getID_Type_Living() == tl.getID_Type_Living()){
                LoaiNhaO = tl.getDetails();
            }
        }
        
        MaSoTf.setText(e_Meters.getID_E_Meter());
        DiaChiTf.setText(e_Meters.getAddress());
        LoaiNhaOTf.setText(LoaiNhaO);
        
        ShowThongTinTuDBS(BangDSCongToDien);
        
    }

    public void ShowThongTinTuDBS(BangDanhSach bangDS){
        DefaultTableModel model = (DefaultTableModel) bangDS.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();        
        
        for(E_Meter_Details e_Meter_DetailsTemp : ListE_Meter_Details){
            Object[] rowData = {
                e_Meter_DetailsTemp.getID_E_Meter_Detail(), e_Meter_DetailsTemp.getID_E_Meter(),
                e_Meter_DetailsTemp.getCurrent_Num(), e_Meter_DetailsTemp.getCreating_Date(), 
                staffs.getCCCD()
            };
            model.addRow(rowData);
        }        
      
        StringProcessing.StringSortingTable(bangDS, 1, true);      
        model.fireTableDataChanged();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BangSrllp = new javax.swing.JScrollPane();
        BangDSCongToDien = new LayMotSoUIdepTaiDay.BangDanhSach();
        LamMoiBt = new LayMotSoUIdepTaiDay.ButtonThuong();
        DangChonTf = new javax.swing.JTextField();
        DangChonLbl = new javax.swing.JLabel();
        TimKiemTf = new javax.swing.JTextField();
        TimKiemBt = new LayMotSoUIdepTaiDay.ButtonThuong();
        TimKiemCb = new LayMotSoUIdepTaiDay.ComboboxThuong();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        MaSoTf = new javax.swing.JLabel();
        DiaChiTf = new javax.swing.JLabel();
        LoaiNhaOTf = new javax.swing.JLabel();
        GhiDienBt = new LayMotSoUIdepTaiDay.ButtonThuong();
        XoaBt = new LayMotSoUIdepTaiDay.ButtonThuong();
        CapNhatBt = new LayMotSoUIdepTaiDay.ButtonThuong();

        setBackground(new java.awt.Color(255, 255, 255));

        BangDSCongToDien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã số", "Tổng số Kwh theo tháng", "Ngày tạo", "CCCD NV ghi điện"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        BangDSCongToDien.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        BangDSCongToDien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BangDSCongToDienMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                BangDSCongToDienMouseReleased(evt);
            }
        });
        BangSrllp.setViewportView(BangDSCongToDien);

        LamMoiBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Refresh.png"))); // NOI18N
        LamMoiBt.setText("Làm mới");
        LamMoiBt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LamMoiBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LamMoiBtActionPerformed(evt);
            }
        });

        DangChonTf.setBackground(new java.awt.Color(255, 255, 255));
        DangChonTf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DangChonTf.setForeground(new java.awt.Color(102, 102, 102));
        DangChonTf.setText("NULL");
        DangChonTf.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        DangChonLbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DangChonLbl.setForeground(new java.awt.Color(0, 0, 0));
        DangChonLbl.setText("Đang chọn (ID):");

        TimKiemTf.setBackground(new java.awt.Color(204, 204, 204));
        TimKiemTf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TimKiemTf.setForeground(new java.awt.Color(102, 102, 102));
        TimKiemTf.setToolTipText("");
        TimKiemTf.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        TimKiemTf.setName(""); // NOI18N

        TimKiemBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/search.png"))); // NOI18N
        TimKiemBt.setText("Tìm kiếm");
        TimKiemBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimKiemBtActionPerformed(evt);
            }
        });

        TimKiemCb.setForeground(new java.awt.Color(0, 0, 0));
        TimKiemCb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mã số", "CCCD ghi điện", "CCCD nhập xuất", "Địa chỉ" }));
        TimKiemCb.setSelectedItem(null
        );
        TimKiemCb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TimKiemCb.setLabeText("(Tìm kiếm theo)");
        TimKiemCb.setLineColor(new java.awt.Color(0, 153, 255));

        jSeparator1.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Công tơ điện đang chọn:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Mã số:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Địa chỉ:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Loại nhà đất:");

        MaSoTf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MaSoTf.setForeground(new java.awt.Color(0, 0, 0));
        MaSoTf.setText("NULL");

        DiaChiTf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DiaChiTf.setForeground(new java.awt.Color(0, 0, 0));
        DiaChiTf.setText("NULL");

        LoaiNhaOTf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LoaiNhaOTf.setForeground(new java.awt.Color(0, 0, 0));
        LoaiNhaOTf.setText("NULL");

        GhiDienBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Isert_icon.png"))); // NOI18N
        GhiDienBt.setText("Ghi điện");
        GhiDienBt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GhiDienBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GhiDienBtActionPerformed(evt);
            }
        });

        XoaBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/delete_icon.png"))); // NOI18N
        XoaBt.setText("Xóa");
        XoaBt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        XoaBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaBtActionPerformed(evt);
            }
        });

        CapNhatBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/6.png"))); // NOI18N
        CapNhatBt.setText("Cập nhật thông tin ghi điện");
        CapNhatBt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CapNhatBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CapNhatBtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(TimKiemTf, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TimKiemCb, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TimKiemBt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(LamMoiBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(CapNhatBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(XoaBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(GhiDienBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(LoaiNhaOTf)
                                            .addComponent(DiaChiTf)
                                            .addComponent(MaSoTf)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(DangChonLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DangChonTf, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE))
                    .addComponent(BangSrllp))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(MaSoTf))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(DiaChiTf))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(LoaiNhaOTf)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(TimKiemCb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(TimKiemTf))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TimKiemBt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LamMoiBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(GhiDienBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(XoaBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CapNhatBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DangChonLbl)
                    .addComponent(DangChonTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BangSrllp, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void LamMoiBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LamMoiBtActionPerformed
        new DSThongTinGhiDien().KhoiTaoListE_Meters_Details();
        new DSE_Meter().KhoiTaoListE_Meters();
        new DSThongTinChung().KhoiTaoListPersonal_Infos();
        new DSTaiKhoanPhanQuyen().KhoiTaoListAccount();
        new DSChuHo().KhoiTaoListCustomeres();
        new DSNhanVien().KhoiTaoListStaffs();
        MainAdminview.setForm(new ThongTinGhiDienSubLowView(MainAdminview, thongTinGhiDienSubHighView, true)); 
    }//GEN-LAST:event_LamMoiBtActionPerformed

    private void BangDSCongToDienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BangDSCongToDienMousePressed
        int i = BangDSCongToDien.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) BangDSCongToDien.getModel();
        E_Meter_Details E_Meters = DSThongTinGhiDien.SearchObjID((Integer) model.getValueAt(i, 0));
        this.e_Meter_Details = E_Meters;
        DangChonTf.setText(e_Meter_Details.getID_E_Meter());
    }//GEN-LAST:event_BangDSCongToDienMousePressed

    private void BangDSCongToDienMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BangDSCongToDienMouseReleased
        int i = BangDSCongToDien.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) BangDSCongToDien.getModel();
        E_Meter_Details E_Meters = DSThongTinGhiDien.SearchObjID((Integer) model.getValueAt(i, 0));
        this.e_Meter_Details = E_Meters;
        DangChonTf.setText((String.valueOf(e_Meter_Details.getID_E_Meter_Detail())));
    }//GEN-LAST:event_BangDSCongToDienMouseReleased

    private void TimKiemBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimKiemBtActionPerformed
//        BangDSCongToDien.setSelectionMode(2);
//        Object selected = TimKiemCb.getSelectedItem();
//        if(TimKiemTf.getText().replaceAll(" ", "").equals("") || selected == null){
//            JOptionPane.showMessageDialog(this, "Vui lòng chọn loại tìm kiếm và không bỏ trống thông tin nhập!!!");            
//        }else if(selected.equals("Mã số")){
//            if(!DSChuHo.Searching(TimKiemTf.getText(), BangDSCongToDien, 1))
//               JOptionPane.showMessageDialog(this, "Không tìm thấy công tơ điện có mã số: " + TimKiemTf.getText());
//            else
//               JOptionPane.showMessageDialog(this, "Đã tìm thấy công tơ điện có mã số: " + TimKiemTf.getText());  
//        }else if(selected.equals("CCCD ghi điện")){
//            if(!DSChuHo.Searching(TimKiemTf.getText(), BangDSCongToDien, 2))
//               JOptionPane.showMessageDialog(this, "Không tìm thấy người dùng có CCCD: " + TimKiemTf.getText());
//            else
//               JOptionPane.showMessageDialog(this, "Đã tìm thấy người dùng có CCCD: " + TimKiemTf.getText());              
//        }else if(selected.equals("CCCD nhập xuất")){
//            if(!DSChuHo.Searching(TimKiemTf.getText(), BangDSCongToDien, 3))
//               JOptionPane.showMessageDialog(this, "Không tìm thấy người dùng có CCCD: " + TimKiemTf.getText());
//            else
//               JOptionPane.showMessageDialog(this, "Đã tìm thấy người dùng có CCCD: " + TimKiemTf.getText());              
//        }else if(selected.equals("Địa chỉ")){
//            if(!DSChuHo.Searching(TimKiemTf.getText(), BangDSCongToDien, 4))
//               JOptionPane.showMessageDialog(this, "Không tìm thấy công tơ điện có địa chỉ: " + TimKiemTf.getText());
//            else
//               JOptionPane.showMessageDialog(this, "Đã tìm thấy công tơ điện có địa chỉ: " + TimKiemTf.getText());              
//        }
    }//GEN-LAST:event_TimKiemBtActionPerformed

    private void GhiDienBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GhiDienBtActionPerformed
        GhiDienDialog ghiDienDialog = new GhiDienDialog(MainAdminview, this, true);
        ghiDienDialog.setVisible(true);
    }//GEN-LAST:event_GhiDienBtActionPerformed

    private void XoaBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaBtActionPerformed
        if(e_Meter_Details == null){
               JOptionPane.showMessageDialog(this, "Vui lòng chọn thông tin cần xóa!!!");            
        }else{
            int confirm = JOptionPane.showConfirmDialog(
                this,
                "Bạn có chắc muốn xóa dữ liệu ghi điện đối với ID: " + e_Meter_Details.getID_E_Meter_Detail() + " không?",
            "Xác nhận thêm",
            JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                try{
                    DSThongTinGhiDien.Delete(e_Meter_Details);
                    JOptionPane.showMessageDialog(this, "Đã xóa dữ liệu ghi điện!!!");
                }catch(Exception e){
                    System.out.println(e);
                    JOptionPane.showMessageDialog(this, "Lỗi hệ thống!!! - Vui lòng thử lại sau", "Lỗi", 
                                                  JOptionPane.ERROR_MESSAGE);
                }
            }              
        }            
    }//GEN-LAST:event_XoaBtActionPerformed

    private void CapNhatBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CapNhatBtActionPerformed
        if(e_Meter_Details == null){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn thông tin cần cập nhật!!!");            
        }else{
            CapNhatGhiDienDialog capNhatGhiDienDialog = new CapNhatGhiDienDialog(MainAdminview, this, true);
            capNhatGhiDienDialog.setVisible(true);
        } 
    }//GEN-LAST:event_CapNhatBtActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LayMotSoUIdepTaiDay.BangDanhSach BangDSCongToDien;
    private javax.swing.JScrollPane BangSrllp;
    private LayMotSoUIdepTaiDay.ButtonThuong CapNhatBt;
    private javax.swing.JLabel DangChonLbl;
    private javax.swing.JTextField DangChonTf;
    private javax.swing.JLabel DiaChiTf;
    private LayMotSoUIdepTaiDay.ButtonThuong GhiDienBt;
    private LayMotSoUIdepTaiDay.ButtonThuong LamMoiBt;
    private javax.swing.JLabel LoaiNhaOTf;
    private javax.swing.JLabel MaSoTf;
    private LayMotSoUIdepTaiDay.ButtonThuong TimKiemBt;
    private LayMotSoUIdepTaiDay.ComboboxThuong TimKiemCb;
    private javax.swing.JTextField TimKiemTf;
    private LayMotSoUIdepTaiDay.ButtonThuong XoaBt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    public BangDanhSach getBangDSE_Meter() {
        return BangDSCongToDien;
    }

    public void setBangDSChuHo(BangDanhSach BangDSChuHo) {
        this.BangDSCongToDien = BangDSChuHo;
    }
    
    public E_Meters getE_Meters() {
        return e_Meters;
    }

    public void setE_Meters(E_Meters e_Meters) {
        this.e_Meters = e_Meters;
    }

    public ButtonThuong getLamMoiBt() {
        return LamMoiBt;
    }

    public void setLamMoiBt(ButtonThuong LamMoiBt) {
        this.LamMoiBt = LamMoiBt;
    }

    public Staffs getStaffs() {
        return staffs;
    }

    public void setStaffs(Staffs staffs) {
        this.staffs = staffs;
    }

    public List<E_Meter_Details> getListE_Meter_Details() {
        return ListE_Meter_Details;
    }

    public void setListE_Meter_Details(List<E_Meter_Details> ListE_Meter_Details) {
        this.ListE_Meter_Details = ListE_Meter_Details;
    }

    public E_Meter_Details getE_Meter_Details() {
        return e_Meter_Details;
    }

    public void setE_Meter_Details(E_Meter_Details e_Meter_Details) {
        this.e_Meter_Details = e_Meter_Details;
    }
    
}
