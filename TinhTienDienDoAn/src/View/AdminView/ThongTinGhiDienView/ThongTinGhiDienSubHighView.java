package View.AdminView.ThongTinGhiDienView;

import Component.ThongTinGhiDienComponent.TableActionCellEditorThongTinGhiDienLow;
import Component.ThongTinGhiDienComponent.TableActionCellRenderThongTinGhiDienLow;
import Component.ThongTinGhiDienComponent.TableActionEventThongTinGhiDienLow;
import Controller.DAO.AssignmentsDAO;
import Controller.DAO.Type_LivingsDAO;
import Controller.DSChuHoController.DSChuHo;
import Controller.DSE_MeterController.DSE_Meter;
import Controller.DSNhanVienController.DSNhanVien;
import Controller.SupportFunction.StringProcessing;
import LayMotSoUIdepTaiDay.BangDanhSach;
import LayMotSoUIdepTaiDay.ButtonThuong;
import Model.Assignments;
import Model.Customers;
import Model.E_Meters;
import Model.Staffs;
import Model.Type_Livings;
import View.AdminView.MainAdminView;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ThongTinGhiDienSubHighView extends javax.swing.JPanel {
    private Customers customers;
    private E_Meters e_Meters;
    private MainAdminView MainAdminview; 
    private Staffs staffs;
    private Staffs Staff_Write;
    
    public  List <Staffs> dsNhanVien = new ArrayList<>();

    private List <E_Meters> dsE_Meters = new ArrayList<>();
    
    private List<Type_Livings> lstType_Livingses = new ArrayList<>();
    
    private ThongTinGhiDienMainView thongTinGhiDienMainView;
    
    public ThongTinGhiDienSubHighView(MainAdminView mainAdminView, ThongTinGhiDienMainView ttgdmv, Boolean model) {
        initComponents();
        this.MainAdminview = mainAdminView;
        this.setSize(MainAdminview.getMainPanel().getSize());
        this.thongTinGhiDienMainView = ttgdmv;
        this.staffs = thongTinGhiDienMainView.getSt();
        this.dsNhanVien = DSNhanVien.getListStaffs();
        this.dsE_Meters = staffs.getListE_Meters();  
        
        this.lstType_Livingses = new Type_LivingsDAO().getAll();
        
        HoTenTf.setText(staffs.getFirstname() + " " + staffs.getMiddleName() + " " + staffs.getLastname());
        SdtTf.setText(staffs.getPhone());
        DiaChiTf.setText(staffs.getAddress());
        CCCDTf.setText(staffs.getCCCD());
        
        ShowThongTinTuDBS(BangDSCongToDien);
        
    }

    public void ShowThongTinTuDBS(BangDanhSach bangDS){
        DefaultTableModel model = (DefaultTableModel) bangDS.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();      
        
        TableActionEventThongTinGhiDienLow event = new TableActionEventThongTinGhiDienLow() {
            @Override
            public void onTTGhiDienView(int row, MainAdminView mainAdminView, ThongTinGhiDienSubHighView ttgdshv) {
                MainAdminview.setForm(new ThongTinGhiDienSubLowView(mainAdminView, ttgdshv, true));
            }
        };         
        
        for(E_Meters e_MetersTemp : dsE_Meters){
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
            
            try {
                for(Assignments assignments : new AssignmentsDAO().getAll()){
                    if(e_MetersTemp.getID_Assignment() == assignments.getID_Assignment()){
                        Staff_Write = DSNhanVien.SearchObjID(assignments.getID_Staff_Write());
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(ThongTinGhiDienSubHighView.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            for(Type_Livings type_LivingsTemp : lstType_Livingses){
                if(type_Livings.getID_Type_Living() == e_MetersTemp.getID_Type_Living()){
                    type_Livings = type_LivingsTemp;
                    break;
                }
            }
            
            Object[] rowData = {
                e_MetersTemp.getID_E_Meter(), staffs.getCCCD(), Staff_Write.getCCCD(), 
                LoaiNhaO, KinhDoanh, e_MetersTemp.getAddress(), TrangThai
            };
            model.addRow(rowData);
        }        
        bangDS.getColumnModel().getColumn(7).setCellRenderer(new TableActionCellRenderThongTinGhiDienLow());
        bangDS.getColumnModel().getColumn(7).setCellEditor(new TableActionCellEditorThongTinGhiDienLow(event, MainAdminview, this));      
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
        HoTenTf = new javax.swing.JLabel();
        SdtTf = new javax.swing.JLabel();
        DiaChiTf = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        CCCDTf = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        BangDSCongToDien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã số", "NV ghi điện", "NV nhập xuất", "Loại nhà đất", "Kinh doanh", "Địa chỉ", "Trạng thái", "Thông tin ghi điện"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
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
        jLabel1.setText("Nhân viên đang chọn:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Họ tên:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Sđt:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Địa chỉ:");

        HoTenTf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        HoTenTf.setForeground(new java.awt.Color(0, 0, 0));
        HoTenTf.setText("NULL");

        SdtTf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SdtTf.setForeground(new java.awt.Color(0, 0, 0));
        SdtTf.setText("NULL");

        DiaChiTf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DiaChiTf.setForeground(new java.awt.Color(0, 0, 0));
        DiaChiTf.setText("NULL");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("CCCD:");

        CCCDTf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CCCDTf.setForeground(new java.awt.Color(0, 0, 0));
        CCCDTf.setText("NULL");

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
                                .addComponent(TimKiemTf, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TimKiemCb, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TimKiemBt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LamMoiBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                            .addComponent(DiaChiTf)
                                            .addComponent(SdtTf)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(HoTenTf)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                                                .addComponent(jLabel5)
                                                .addGap(18, 18, 18)
                                                .addComponent(CCCDTf))))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(DangChonLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DangChonTf, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(36, 36, 36))
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(CCCDTf))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(HoTenTf)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(SdtTf))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(DiaChiTf)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(TimKiemCb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(TimKiemTf))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TimKiemBt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LamMoiBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DangChonLbl)
                    .addComponent(DangChonTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BangSrllp, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void LamMoiBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LamMoiBtActionPerformed
        MainAdminview.setForm(new ThongTinGhiDienSubHighView(MainAdminview, thongTinGhiDienMainView, true)); 
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

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LayMotSoUIdepTaiDay.BangDanhSach BangDSCongToDien;
    private javax.swing.JScrollPane BangSrllp;
    private javax.swing.JLabel CCCDTf;
    private javax.swing.JLabel DangChonLbl;
    private javax.swing.JTextField DangChonTf;
    private javax.swing.JLabel DiaChiTf;
    private javax.swing.JLabel HoTenTf;
    private LayMotSoUIdepTaiDay.ButtonThuong LamMoiBt;
    private javax.swing.JLabel SdtTf;
    private LayMotSoUIdepTaiDay.ButtonThuong TimKiemBt;
    private LayMotSoUIdepTaiDay.ComboboxThuong TimKiemCb;
    private javax.swing.JTextField TimKiemTf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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

    public Staffs getStaffs() {
        return staffs;
    }

    public void setStaffs(Staffs staffs) {
        this.staffs = staffs;
    }
    
}
