package View.CustomerView.DanhSachCongToDienCSView;

import Controller.DAO.AssignmentsDAO;
import Controller.DAO.Paid_InvoicesDAO;
import Controller.DAO.Type_LivingsDAO;
import Controller.DSChuHoController.DSChuHo;
import Controller.DSE_MeterController.DSE_Meter;
import Controller.DSHoaDonDienController.DSHoaDonDien;
import Controller.DSNhanVienController.DSNhanVien;
import Controller.SupportFunction.StringProcessing;
import LayMotSoUIdepTaiDay.BangDanhSach;
import LayMotSoUIdepTaiDay.ButtonThuong;
import MainRunCode.AccountLogin;
import Model.Assignments;
import Model.Customers;
import Model.E_Meters;
import Model.Invoices;
import Model.Paid_Invoices;
import Model.Staffs;
import Model.Type_Livings;
import View.CustomerView.DanhSachCongToDienCSView.DSCongToDienDialog.ThanhToanDialog;
import View.CustomerView.MainCustomerView;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DSCongToDienCSSubView extends javax.swing.JPanel {
    private Customers customers;
    private E_Meters e_Meters;
    private MainCustomerView mainCustomerViews; 
    public  List <Invoices> dsInvoices = new ArrayList<>();
    private DSCongToDienCSView dSCongToDienCSView;
    private List <Staffs> dsNhanVien = new ArrayList<>();
    private Invoices invoices = new Invoices();
    private List <E_Meters> dsE_Meters = new ArrayList<>();
    private Staffs Staff_Write;
    
    public DSCongToDienCSSubView(MainCustomerView mcv, DSCongToDienCSView dsctdcsv) {
        initComponents();
        this.mainCustomerViews = mcv;
        this.setSize(mainCustomerViews.getMainPanel().getSize());
        this.dSCongToDienCSView = dsctdcsv;
        this.customers = AccountLogin.getCustomersLogin();
        this.dsNhanVien = new DSNhanVien().KhoiTaoListStaffs();
        this.dsInvoices = customers.getListInvoices();
        this.e_Meters = dSCongToDienCSView.getE_Meters();
        
        try {
            for(Assignments assignments : new AssignmentsDAO().getAll()){
                if(assignments.getID_Customer().equals(customers.getID_Customer()) && assignments.getID_Staff_Write() != null){
                    this.Staff_Write = DSNhanVien.SearchObjID(assignments.getID_Staff_Write());
                    break;            
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(DSCongToDienCSSubView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        MaSoTf.setText(e_Meters.getID_E_Meter());
        DiaChiTf.setText(e_Meters.getAddress());
        
        for(Type_Livings tl : new Type_LivingsDAO().getAll()){
            if(tl.getID_Type_Living().equals(e_Meters.getID_Type_Living())){
                LoaiNhaOTf.setText(tl.getDetails());
                break;
            }
        }
        
        
        ShowThongTinTuDBS(BangDSCongToDien);
        
    }

    public void ShowThongTinTuDBS(BangDanhSach bangDS){
        DefaultTableModel model = (DefaultTableModel) bangDS.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();        
     
        for(Invoices invoices : dsInvoices){
            
            String thanhtoan = "Chưa thanh toán";
            for(Paid_Invoices paid_Invoices : new Paid_InvoicesDAO().getAll()){
                if(paid_Invoices.getID_Invoice().equals(invoices.getID_Invoice())){
                    thanhtoan = "Đã thanh toán";
                    break;
                }
            }
            
            Object[] rowData = {
                invoices.getID_Invoice(), invoices.getID_E_Meter_Details(), invoices.getID_Level(), 
                invoices.getInvoice_Date(), invoices.getTotal_Price(), Staff_Write.getPhone(), thanhtoan
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
        MaSoTf = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        DiaChiTf = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        LoaiNhaOTf = new javax.swing.JLabel();
        ThanhToanBt = new LayMotSoUIdepTaiDay.ButtonThuong();

        setBackground(new java.awt.Color(255, 255, 255));

        BangDSCongToDien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "ID ghi điện", "Định mức điện", "Ngày tạo hóa đơn", "Tổng số tiền", "Sdt NV xuất hóa đơn", "Đã thanh toán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

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

        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Công tơ điện đang chọn:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Mã sô:");

        MaSoTf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MaSoTf.setForeground(new java.awt.Color(0, 0, 0));
        MaSoTf.setText("NULL");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Địa chỉ:");

        DiaChiTf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DiaChiTf.setForeground(new java.awt.Color(0, 0, 0));
        DiaChiTf.setText("NULL");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Loại nhà ở:");

        LoaiNhaOTf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LoaiNhaOTf.setForeground(new java.awt.Color(0, 0, 0));
        LoaiNhaOTf.setText("NULL");

        ThanhToanBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/profit.png"))); // NOI18N
        ThanhToanBt.setText("Thanh toán");
        ThanhToanBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThanhToanBtActionPerformed(evt);
            }
        });

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
                                .addComponent(DangChonLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DangChonTf, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TimKiemTf, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TimKiemCb, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ThanhToanBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TimKiemBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(LamMoiBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                            .addComponent(MaSoTf))))))
                        .addGap(0, 308, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(TimKiemCb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(TimKiemTf))
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
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TimKiemBt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LamMoiBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(ThanhToanBt, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jSeparator1))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DangChonLbl)
                    .addComponent(DangChonTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BangSrllp, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void LamMoiBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LamMoiBtActionPerformed
        mainCustomerViews.setForm(new DSCongToDienCSSubView(mainCustomerViews, dSCongToDienCSView));
    }//GEN-LAST:event_LamMoiBtActionPerformed

    private void BangDSCongToDienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BangDSCongToDienMousePressed
        int i = BangDSCongToDien.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) BangDSCongToDien.getModel();
        Invoices i1 = DSHoaDonDien.SearchObjID((Integer) model.getValueAt(i, 0));
        this.invoices = i1;
        DangChonTf.setText(String.valueOf(invoices.getID_Invoice()));
    }//GEN-LAST:event_BangDSCongToDienMousePressed

    private void BangDSCongToDienMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BangDSCongToDienMouseReleased
        int i = BangDSCongToDien.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) BangDSCongToDien.getModel();
        Invoices i1 = DSHoaDonDien.SearchObjID((Integer) model.getValueAt(i, 0));
        this.invoices = i1;
        DangChonTf.setText(String.valueOf(invoices.getID_Invoice()));
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

    private void ThanhToanBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThanhToanBtActionPerformed
        if(invoices == null){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn cần thanh toán!!!");                          
        }else{
            ThanhToanDialog thanhToanDialog = new ThanhToanDialog(mainCustomerViews, this, true);
            thanhToanDialog.setVisible(true);
        }
    }//GEN-LAST:event_ThanhToanBtActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LayMotSoUIdepTaiDay.BangDanhSach BangDSCongToDien;
    private javax.swing.JScrollPane BangSrllp;
    private javax.swing.JLabel DangChonLbl;
    private javax.swing.JTextField DangChonTf;
    private javax.swing.JLabel DiaChiTf;
    private LayMotSoUIdepTaiDay.ButtonThuong LamMoiBt;
    private javax.swing.JLabel LoaiNhaOTf;
    private javax.swing.JLabel MaSoTf;
    private LayMotSoUIdepTaiDay.ButtonThuong ThanhToanBt;
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

    public Invoices getInvoices() {
        return invoices;
    }

    public void setInvoices(Invoices invoices) {
        this.invoices = invoices;
    }
    
    
}
