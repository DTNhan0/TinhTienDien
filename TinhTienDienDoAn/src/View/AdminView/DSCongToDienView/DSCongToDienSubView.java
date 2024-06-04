package View.AdminView.DSCongToDienView;

import Controller.DAO.AssignmentsDAO;
import Controller.DAO.Type_LivingsDAO;
import Controller.DSChuHoController.DSChuHo;
import Controller.DSE_MeterController.DSE_Meter;
import Controller.DSNhanVienController.DSNhanVien;
import Controller.QLPhanQuyenTKController.DSTaiKhoanPhanQuyen;
import Controller.QLThongTinChungController.DSThongTinChung;
import Controller.SupportFunction.StringProcessing;
import LayMotSoUIdepTaiDay.BangDanhSach;
import LayMotSoUIdepTaiDay.ButtonThuong;
import LayMotSoUIdepTaiDay.ComboboxThuong;
import Model.Assignments;
import Model.Customers;
import Model.E_Meters;
import Model.Staffs;
import Model.Type_Livings;
import View.AdminView.DSCongToDienView.DSCongToDienDialog.CapNhatCongToDienDialog;
import View.AdminView.DSCongToDienView.DSCongToDienDialog.PhanCongNVGhiDienDialog;
import View.AdminView.DSCongToDienView.DSCongToDienDialog.ThemCongToDienDialog;
import View.AdminView.MainAdminView;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DSCongToDienSubView extends javax.swing.JPanel {
    private Customers customers;
    private E_Meters e_Meters;
    private MainAdminView MainAdminview; 
    public  List <Staffs> dsNhanVien = new ArrayList<>();

    private List <E_Meters> dsE_Meters = new ArrayList<>();
    private DSCongToDienMainView dSCongToDienMainView;
    private Staffs Staff_Write;
    private List<Type_Livings> lstType_Livingses = new ArrayList<>();
    
    public DSCongToDienSubView(MainAdminView mainAdminView, DSCongToDienMainView dsctdmv) {
        initComponents();
        this.MainAdminview = mainAdminView;
        this.setSize(MainAdminview.getMainPanel().getSize());
        this.dSCongToDienMainView = dsctdmv;
        
        this.customers = dSCongToDienMainView.getCustomer();
        this.dsNhanVien = new DSNhanVien().KhoiTaoListStaffs();
        dsE_Meters = this.customers.getListE_Meter();
        
        try {
            for(Assignments assignments : new AssignmentsDAO().getAll()){
                if(assignments.getID_Customer().equals(customers.getID_Customer()) && assignments.getID_Staff_Write() != null){
                    this.Staff_Write = DSNhanVien.SearchObjID(assignments.getID_Staff_Write());
                    break;            
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(DSCongToDienSubView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.lstType_Livingses = new Type_LivingsDAO().getAll();
        
        HoTenCHTf.setText(customers.getFirstname() + " " + customers.getMiddleName() + " " + customers.getLastname());
        SdtCHTf.setText(customers.getPhone());
        CccdCHTf.setText(customers.getCCCD());
        
        ShowThongTinTuDBS(BangDSCongToDien);
        
    }

    public void ShowThongTinTuDBS(BangDanhSach bangDS){
        DefaultTableModel model = (DefaultTableModel) bangDS.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();        
        
        for(E_Meters e_MetersTemp : dsE_Meters){
            Staffs staffs_input = new Staffs();
            Type_Livings type_Livings = new Type_Livings();
            String TrangThai;
            String KinhDoanh;
            String LoaiNhaO = null;
            
            if(e_MetersTemp.isStatus()){
                TrangThai = "Đang mở";
            }else{
                TrangThai = "Đã khóa";
            }
            
            if(e_MetersTemp.isIs_Business()){
                KinhDoanh = "Có";
            }else{
                KinhDoanh = "Không";
            }
            
            if(e_MetersTemp.getID_Type_Living() == 1){
                LoaiNhaO = "Nhà ở";
            }else if(e_MetersTemp.getID_Type_Living() == 2){
                LoaiNhaO = "Chung cư";                
            }else if(e_MetersTemp.getID_Type_Living() == 3){
                LoaiNhaO = "Nhà trọ";                
            }else if(e_MetersTemp.getID_Type_Living() == 4){
                LoaiNhaO = "Mặt tiền";                
            }
            
            for(Staffs staffs : dsNhanVien){
                if(staffs.getID_Staff() == e_MetersTemp.getID_Staff_Input()){
                    staffs_input = staffs;
                    break;
                }
            }
            
            for(Type_Livings type_LivingsTemp : lstType_Livingses){
                if(type_Livings.getID_Type_Living() == e_MetersTemp.getID_Type_Living()){
                    type_Livings = type_LivingsTemp;
                    break;
                }
            }
            
            String PhanCong;
            if(e_MetersTemp.getID_Staff_Input() == null || e_MetersTemp.getID_Staff_Input() == 0){
                PhanCong = "Chưa phân công";
            }else{
                PhanCong = staffs_input.getCCCD();
            }

            
            Object[] rowData = {
                e_MetersTemp.getID_E_Meter(), PhanCong, Staff_Write.getCCCD(), 
                LoaiNhaO, KinhDoanh, e_MetersTemp.getAddress(), TrangThai
            };
            model.addRow(rowData);
        }        
      
        StringProcessing.StringSortingTable(bangDS, 0, true);      
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
        ThemBt = new LayMotSoUIdepTaiDay.ButtonThuong();
        CapNhatBt = new LayMotSoUIdepTaiDay.ButtonThuong();
        PhanCongBt = new LayMotSoUIdepTaiDay.ButtonThuong();
        KhoaE_METERBt = new LayMotSoUIdepTaiDay.ButtonThuong();
        MoKhoaE_METERBt = new LayMotSoUIdepTaiDay.ButtonThuong();
        HoTenCHTf = new javax.swing.JLabel();
        SdtCHTf = new javax.swing.JLabel();
        CccdCHTf = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        BangDSCongToDien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã số", "NV ghi điện", "NV nhập xuất", "Loại nhà đất", "Kinh doanh", "Địa chỉ", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
        DangChonLbl.setText("Đang chọn (Mã số):");

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
        jLabel1.setText("Chủ hộ đang chọn:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Họ tên:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("SĐT:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("CCCD:");

        ThemBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Isert_icon.png"))); // NOI18N
        ThemBt.setText("Thêm công tơ điện");
        ThemBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemBtActionPerformed(evt);
            }
        });

        CapNhatBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/6.png"))); // NOI18N
        CapNhatBt.setText("Cập nhật công tơ điện");
        CapNhatBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CapNhatBtActionPerformed(evt);
            }
        });

        PhanCongBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/6.png"))); // NOI18N
        PhanCongBt.setText("Phân công NV ghi điện");
        PhanCongBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhanCongBtActionPerformed(evt);
            }
        });

        KhoaE_METERBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/lock.png"))); // NOI18N
        KhoaE_METERBt.setText("Khóa công tơ điện");
        KhoaE_METERBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KhoaE_METERBtActionPerformed(evt);
            }
        });

        MoKhoaE_METERBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/unlock.png"))); // NOI18N
        MoKhoaE_METERBt.setText("Mở khóa công tơ điện");
        MoKhoaE_METERBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoKhoaE_METERBtActionPerformed(evt);
            }
        });

        HoTenCHTf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        HoTenCHTf.setForeground(new java.awt.Color(0, 0, 0));
        HoTenCHTf.setText("NULL");

        SdtCHTf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SdtCHTf.setForeground(new java.awt.Color(0, 0, 0));
        SdtCHTf.setText("NULL");

        CccdCHTf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CccdCHTf.setForeground(new java.awt.Color(0, 0, 0));
        CccdCHTf.setText("NULL");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BangSrllp)
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
                                        .addComponent(LamMoiBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(KhoaE_METERBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(PhanCongBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(CapNhatBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(ThemBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(MoKhoaE_METERBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(26, 26, 26)
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
                                            .addComponent(CccdCHTf)
                                            .addComponent(SdtCHTf)
                                            .addComponent(HoTenCHTf)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(DangChonLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DangChonTf, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 235, Short.MAX_VALUE)))
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
                            .addComponent(HoTenCHTf))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(SdtCHTf))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(CccdCHTf)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(TimKiemCb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(TimKiemTf))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TimKiemBt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LamMoiBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(KhoaE_METERBt, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ThemBt, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CapNhatBt, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PhanCongBt, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MoKhoaE_METERBt, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DangChonLbl)
                    .addComponent(DangChonTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BangSrllp, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void LamMoiBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LamMoiBtActionPerformed
        MainAdminview.setForm(new DSCongToDienSubView(MainAdminview, new DSCongToDienMainView(MainAdminview, DSChuHo.SearchObjCCCD(customers.getCCCD()))));
    }//GEN-LAST:event_LamMoiBtActionPerformed

    private void BangDSCongToDienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BangDSCongToDienMousePressed
        int i = BangDSCongToDien.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) BangDSCongToDien.getModel();
        E_Meters E_Meters = DSE_Meter.SearchObjID((String) model.getValueAt(i, 0));
        this.e_Meters = E_Meters;
        DangChonTf.setText(e_Meters.getID_E_Meter());
    }//GEN-LAST:event_BangDSCongToDienMousePressed

    private void BangDSCongToDienMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BangDSCongToDienMouseReleased
        int i = BangDSCongToDien.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) BangDSCongToDien.getModel();
        E_Meters E_Meters = DSE_Meter.SearchObjID((String) model.getValueAt(i, 0));
        this.e_Meters = E_Meters;
        DangChonTf.setText(e_Meters.getID_E_Meter());
    }//GEN-LAST:event_BangDSCongToDienMouseReleased

    private void TimKiemBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimKiemBtActionPerformed
        BangDSCongToDien.setSelectionMode(2);
        Object selected = TimKiemCb.getSelectedItem();
        if(TimKiemTf.getText().replaceAll(" ", "").equals("") || selected == null){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn loại tìm kiếm và không bỏ trống thông tin nhập!!!");            
        }else if(selected.equals("Mã số")){
            if(!DSChuHo.Searching(TimKiemTf.getText(), BangDSCongToDien, 1))
               JOptionPane.showMessageDialog(this, "Không tìm thấy công tơ điện có mã số: " + TimKiemTf.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy công tơ điện có mã số: " + TimKiemTf.getText());  
        }else if(selected.equals("CCCD ghi điện")){
            if(!DSChuHo.Searching(TimKiemTf.getText(), BangDSCongToDien, 2))
               JOptionPane.showMessageDialog(this, "Không tìm thấy người dùng có CCCD: " + TimKiemTf.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy người dùng có CCCD: " + TimKiemTf.getText());              
        }else if(selected.equals("CCCD nhập xuất")){
            if(!DSChuHo.Searching(TimKiemTf.getText(), BangDSCongToDien, 3))
               JOptionPane.showMessageDialog(this, "Không tìm thấy người dùng có CCCD: " + TimKiemTf.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy người dùng có CCCD: " + TimKiemTf.getText());              
        }else if(selected.equals("Địa chỉ")){
            if(!DSChuHo.Searching(TimKiemTf.getText(), BangDSCongToDien, 4))
               JOptionPane.showMessageDialog(this, "Không tìm thấy công tơ điện có địa chỉ: " + TimKiemTf.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy công tơ điện có địa chỉ: " + TimKiemTf.getText());              
        }
    }//GEN-LAST:event_TimKiemBtActionPerformed

    private void ThemBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemBtActionPerformed
        try {
            for(Assignments assignments : new AssignmentsDAO().getAll()){
                if(assignments.getID_Customer() == customers.getID_Customer()){
                    if(assignments.getID_Staff_Write() == 0){
                        JOptionPane.showMessageDialog(this, "Vui lòng phân công nhân viên ghi điện trước khi thêm công tơ điện!");
                        return;
                    }
                }
            }
            ThemCongToDienDialog themCongToDienDialog = new ThemCongToDienDialog(MainAdminview, this, true);
            themCongToDienDialog.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(DSCongToDienSubView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ThemBtActionPerformed

    private void KhoaE_METERBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KhoaE_METERBtActionPerformed
        if(e_Meters == null){                
            JOptionPane.showMessageDialog(this, "Vui lòng chọn công tơ điện cần khóa trên bảng!!!");
        }else{
            int confirm = JOptionPane.showConfirmDialog(
                this,
                "Bạn có chắc muốn khóa công tơ điện: " + e_Meters.getID_E_Meter()+ " không?",
            "Xác nhận",
            JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                try{
                    e_Meters.setStatus(false);
                    DSE_Meter.Update(e_Meters);
                    JOptionPane.showMessageDialog(this, "Mã số: " + e_Meters.getID_E_Meter()+ " đã bị khóa!");
                    ShowThongTinTuDBS(BangDSCongToDien);
                    this.MainAdminview.CapNhatBangTrangThai();
                }catch(Exception e){
                    System.out.println(e);
                    JOptionPane.showMessageDialog(this, "Lỗi hệ thống!!! - Vui lòng thử lại sau", "Lỗi", 
                                                  JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_KhoaE_METERBtActionPerformed

    private void MoKhoaE_METERBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoKhoaE_METERBtActionPerformed
        if(e_Meters == null){                
            JOptionPane.showMessageDialog(this, "Vui lòng chọn công tơ điện cần khóa trên bảng!!!");
        }else{
            int confirm = JOptionPane.showConfirmDialog(
                this,
                "Bạn có chắc muốn mở khóa công tơ điện: " + e_Meters.getID_E_Meter()+ " không?",
            "Xác nhận",
            JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                try{
                    e_Meters.setStatus(true);
                    DSE_Meter.Update(e_Meters);
                    JOptionPane.showMessageDialog(this, "Mã số: " + e_Meters.getID_E_Meter()+ " đã mở khóa!");
                    ShowThongTinTuDBS(BangDSCongToDien);
                    this.MainAdminview.CapNhatBangTrangThai();
                }catch(Exception e){
                    System.out.println(e);
                    JOptionPane.showMessageDialog(this, "Lỗi hệ thống!!! - Vui lòng thử lại sau", "Lỗi", 
                                                  JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_MoKhoaE_METERBtActionPerformed

    private void CapNhatBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CapNhatBtActionPerformed
        if(e_Meters == null){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn công tơ điện cần cập nhật!!!");            
        }else{
            CapNhatCongToDienDialog capNhatCongToDienDialog = new CapNhatCongToDienDialog(MainAdminview, this, true);
            capNhatCongToDienDialog.setVisible(true);
        }
    }//GEN-LAST:event_CapNhatBtActionPerformed

    private void PhanCongBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhanCongBtActionPerformed
        if(e_Meters == null){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn công tơ điện cần cập nhật!!!");            
        }else{
            if(e_Meters.getID_Staff_Input() != 0){
                JOptionPane.showMessageDialog(this, "Hiện tại đã có nhân viên được phân công cho công tơ điện. \nBạn có thể đổi phân công nhưng phải cân nhắc kỹ trong quá trình nhân viên đang làm việc");              
            }            
            PhanCongNVGhiDienDialog phanCongNVGhiDienDialog = new PhanCongNVGhiDienDialog(MainAdminview, this, true);
            phanCongNVGhiDienDialog.setVisible(true);
        }
    }//GEN-LAST:event_PhanCongBtActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LayMotSoUIdepTaiDay.BangDanhSach BangDSCongToDien;
    private javax.swing.JScrollPane BangSrllp;
    private LayMotSoUIdepTaiDay.ButtonThuong CapNhatBt;
    private javax.swing.JLabel CccdCHTf;
    private javax.swing.JLabel DangChonLbl;
    private javax.swing.JTextField DangChonTf;
    private javax.swing.JLabel HoTenCHTf;
    private LayMotSoUIdepTaiDay.ButtonThuong KhoaE_METERBt;
    private LayMotSoUIdepTaiDay.ButtonThuong LamMoiBt;
    private LayMotSoUIdepTaiDay.ButtonThuong MoKhoaE_METERBt;
    private LayMotSoUIdepTaiDay.ButtonThuong PhanCongBt;
    private javax.swing.JLabel SdtCHTf;
    private LayMotSoUIdepTaiDay.ButtonThuong ThemBt;
    private LayMotSoUIdepTaiDay.ButtonThuong TimKiemBt;
    private LayMotSoUIdepTaiDay.ComboboxThuong TimKiemCb;
    private javax.swing.JTextField TimKiemTf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    public Customers getCustomer() {
        return customers;
    }

    public void setCustomer(Customers cs) {
        this.customers = cs;
    }
    
    public BangDanhSach getBangDSE_Meter() {
        return BangDSCongToDien;
    }

    public void setBangDSChuHo(BangDanhSach BangDSChuHo) {
        this.BangDSCongToDien = BangDSChuHo;
    }
    

    public List<Staffs> getDsNhanVien() {
        return dsNhanVien;
    }

    public void setDsNhanVien(List<Staffs> dsNhanVien) {
        this.dsNhanVien = dsNhanVien;
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
    
    
}
