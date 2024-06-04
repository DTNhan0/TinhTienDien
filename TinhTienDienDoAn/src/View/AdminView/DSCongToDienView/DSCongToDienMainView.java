package View.AdminView.DSCongToDienView;

import Component.DSCongToDienComponent.TableActionCellEditor;
import Component.DSCongToDienComponent.TableActionCellRender;
import Component.DSCongToDienComponent.TableActionEvent;
import Controller.DSChuHoController.DSChuHo;
import Controller.DSNhanVienController.DSNhanVien;
import Controller.SupportFunction.StringProcessing;
import LayMotSoUIdepTaiDay.BangDanhSach;
import LayMotSoUIdepTaiDay.ComboboxThuong;
import Model.Customers;
import Model.Staffs;
import View.AdminView.DSCongToDienView.DSCongToDienDialog.FilterLoaiDateDSCHDialog;
import View.AdminView.DSCongToDienView.DSCongToDienDialog.SortLoaiStringDSCHDialog;
import View.AdminView.MainAdminView;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DSCongToDienMainView extends javax.swing.JPanel {
    private Customers customers;
    private MainAdminView MainAdminview;
    public  List <Customers> dsChuHo;  
    public  List <Staffs> dsNhanVien;
    
    
    public DSCongToDienMainView(MainAdminView mainAdminView, Customers cs) {
        initComponents();
        this.MainAdminview = mainAdminView;
        this.setSize(MainAdminview.getMainPanel().getSize());
        this.customers = cs;
        
        this.dsChuHo = new DSChuHo().KhoiTaoListCustomeres();
        this.dsNhanVien = new DSNhanVien().KhoiTaoListStaffs();
        ShowThongTinTuDBS(BangDSChuHo);
        
    }

    public void ShowThongTinTuDBS(BangDanhSach bangDS){
        DefaultTableModel model = (DefaultTableModel) bangDS.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged(); 
        
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onDSCongToDienView(int row, MainAdminView mainAdminView, DSCongToDienMainView dsctdmv) {
                MainAdminview.setForm(new DSCongToDienSubView(mainAdminView, dsctdmv));
            }
        };
        
        dsChuHo = DSChuHo.KhoiTaoListCustomeres();
        
        model.setRowCount(0);    
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");     
        
        for(Customers customers : dsChuHo){
            String name = customers.getFirstname() + " " + customers.getMiddleName()+ " " + customers.getLastname();
            String Ten = new StringProcessing().Name(name);
            
            Object[] rowData = {
                customers.getCCCD(), Ten, dateFormat.format(customers.getDOB()), 
                customers.getAddress(), customers.getPhone(), customers.getAccount_Username(),
                customers.getAccount_Password(),
            };
            model.addRow(rowData);
        }   
        bangDS.getColumnModel().getColumn(7).setCellRenderer(new TableActionCellRender());
        bangDS.getColumnModel().getColumn(7).setCellEditor(new TableActionCellEditor(event, MainAdminview, this));      
      
        StringProcessing.StringSortingTable(bangDS, 0, true);      
        model.fireTableDataChanged();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BangSrllp = new javax.swing.JScrollPane();
        BangDSChuHo = new LayMotSoUIdepTaiDay.BangDanhSach();
        LamMoiBt = new LayMotSoUIdepTaiDay.ButtonThuong();
        DangChonTf = new javax.swing.JTextField();
        DangChonLbl = new javax.swing.JLabel();
        TimKiemTf = new javax.swing.JTextField();
        TimKiemBt = new LayMotSoUIdepTaiDay.ButtonThuong();
        TimKiemCb = new LayMotSoUIdepTaiDay.ComboboxThuong();
        jSeparator1 = new javax.swing.JSeparator();
        LocBt = new LayMotSoUIdepTaiDay.ButtonThuong();
        LocCkb = new LayMotSoUIdepTaiDay.ComboboxThuong();
        SapXepCkb = new LayMotSoUIdepTaiDay.ComboboxThuong();
        SapXepBt = new LayMotSoUIdepTaiDay.ButtonThuong();

        setBackground(new java.awt.Color(255, 255, 255));

        BangDSChuHo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CCCD", "Họ và tên", "Ngày sinh", "Địa chỉ", "SĐT", "Account", "Password", "Các công tơ điện"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
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
        BangDSChuHo.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        BangDSChuHo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BangDSChuHoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                BangDSChuHoMouseReleased(evt);
            }
        });
        BangSrllp.setViewportView(BangDSChuHo);
        if (BangDSChuHo.getColumnModel().getColumnCount() > 0) {
            BangDSChuHo.getColumnModel().getColumn(7).setResizable(false);
        }

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
        DangChonLbl.setText("Đang chọn (CCCD):");

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
        TimKiemCb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CCCD", "Họ và tên", "Địa chỉ", "SĐT", "Account" }));
        TimKiemCb.setSelectedItem(null
        );
        TimKiemCb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TimKiemCb.setLabeText("(Tìm kiếm theo)");
        TimKiemCb.setLineColor(new java.awt.Color(0, 153, 255));

        jSeparator1.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        LocBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/filter.png"))); // NOI18N
        LocBt.setText("Lọc");
        LocBt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LocBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocBtActionPerformed(evt);
            }
        });

        LocCkb.setForeground(new java.awt.Color(0, 0, 0));
        LocCkb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Theo ngày sinh" }));
        LocCkb.setSelectedItem(null);
        LocCkb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LocCkb.setLabeText("(Chọn thuộc tính cần lọc)");

        SapXepCkb.setForeground(new java.awt.Color(0, 0, 0));
        SapXepCkb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Theo CCCD", "Theo họ và tên", "Theo địa chỉ", "Theo SĐT", "Theo ngày sinh", "Theo Account" }));
        SapXepCkb.setSelectedItem(null);
        SapXepCkb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SapXepCkb.setLabeText("(Chọn thuộc tính cần sắp xếp)");

        SapXepBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/sort.png"))); // NOI18N
        SapXepBt.setText("Sắp xếp");
        SapXepBt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SapXepBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SapXepBtActionPerformed(evt);
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
                                .addComponent(TimKiemTf, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TimKiemCb, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TimKiemBt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LamMoiBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(93, 93, 93)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LocCkb, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SapXepCkb, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(LocBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(SapXepBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(DangChonLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DangChonTf, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 19, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LocCkb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(SapXepCkb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(LocBt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(15, 15, 15)
                            .addComponent(SapXepBt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        MainAdminview.setForm(new DSCongToDienMainView(MainAdminview, null));
    }//GEN-LAST:event_LamMoiBtActionPerformed

    private void BangDSChuHoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BangDSChuHoMousePressed
        int i = BangDSChuHo.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) BangDSChuHo.getModel();
        Customers cs = DSChuHo.SearchObjCCCD((String) model.getValueAt(i, 0));
        this.customers = cs;
        DangChonTf.setText(customers.getCCCD());
    }//GEN-LAST:event_BangDSChuHoMousePressed

    private void BangDSChuHoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BangDSChuHoMouseReleased
        int i = BangDSChuHo.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) BangDSChuHo.getModel();
        Customers cs = DSChuHo.SearchObjCCCD((String) model.getValueAt(i, 0));
        this.customers = cs;
        DangChonTf.setText(customers.getCCCD());
    }//GEN-LAST:event_BangDSChuHoMouseReleased

    private void TimKiemBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimKiemBtActionPerformed
        BangDSChuHo.setSelectionMode(2);
        Object selected = TimKiemCb.getSelectedItem();
        if(TimKiemTf.getText().replaceAll(" ", "").equals("") || selected == null){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn loại tìm kiếm và không bỏ trống thông tin nhập!!!");            
        }else if(selected.equals("CCCD")){
            if(!DSChuHo.Searching(TimKiemTf.getText(), BangDSChuHo, 1))
               JOptionPane.showMessageDialog(this, "Không tìm thấy người dùng có CCCD: " + TimKiemTf.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy người dùng có CCCD: " + TimKiemTf.getText());  
        }else if(selected.equals("Họ và tên")){
            if(!DSChuHo.Searching(TimKiemTf.getText(), BangDSChuHo, 2))
               JOptionPane.showMessageDialog(this, "Không tìm thấy người dùng có họ tên: " + TimKiemTf.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy người dùng có họ tên: " + TimKiemTf.getText());              
        }else if(selected.equals("Địa chỉ")){
            if(!DSChuHo.Searching(TimKiemTf.getText(), BangDSChuHo, 3))
               JOptionPane.showMessageDialog(this, "Không tìm thấy người dùng có địa chỉ: " + TimKiemTf.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy người dùng có địa chỉ: " + TimKiemTf.getText());              
        }else if(selected.equals("SĐT")){
            if(!DSChuHo.Searching(TimKiemTf.getText(), BangDSChuHo, 4))
               JOptionPane.showMessageDialog(this, "Không tìm thấy người dùng có SĐT: " + TimKiemTf.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy người dùng có SĐT: " + TimKiemTf.getText());              
        }else if(selected.equals("Account")){
            if(!DSChuHo.Searching(TimKiemTf.getText(), BangDSChuHo, 5))
               JOptionPane.showMessageDialog(this, "Không tìm thấy người dùng có Account: " + TimKiemTf.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy người dùng có Account: " + TimKiemTf.getText());              
        }
    }//GEN-LAST:event_TimKiemBtActionPerformed

    private void LocBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocBtActionPerformed
        Object selected = LocCkb.getSelectedItem();
        if(selected == null){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn thuộc tính cần lọc!!!");             
        }else if(selected.equals("Theo ngày sinh")){
            FilterLoaiDateDSCHDialog filterLoaiDateDSCHDialog = new FilterLoaiDateDSCHDialog(this.MainAdminview, this, true);
            filterLoaiDateDSCHDialog.setVisible(true);           
        }
    }//GEN-LAST:event_LocBtActionPerformed

    private void SapXepBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SapXepBtActionPerformed
        Object selected = SapXepCkb.getSelectedItem();
        if(selected == null){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn thuộc tính cần sắp xếp!!!");             
        }else{
            SortLoaiStringDSCHDialog sortLoaiStringDSCHDialog = new SortLoaiStringDSCHDialog(this.MainAdminview, this, true);
            sortLoaiStringDSCHDialog.setVisible(true);  
        }
    }//GEN-LAST:event_SapXepBtActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LayMotSoUIdepTaiDay.BangDanhSach BangDSChuHo;
    private javax.swing.JScrollPane BangSrllp;
    private javax.swing.JLabel DangChonLbl;
    private javax.swing.JTextField DangChonTf;
    private LayMotSoUIdepTaiDay.ButtonThuong LamMoiBt;
    private LayMotSoUIdepTaiDay.ButtonThuong LocBt;
    private LayMotSoUIdepTaiDay.ComboboxThuong LocCkb;
    private LayMotSoUIdepTaiDay.ButtonThuong SapXepBt;
    private LayMotSoUIdepTaiDay.ComboboxThuong SapXepCkb;
    private LayMotSoUIdepTaiDay.ButtonThuong TimKiemBt;
    private LayMotSoUIdepTaiDay.ComboboxThuong TimKiemCb;
    private javax.swing.JTextField TimKiemTf;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
 
    public ComboboxThuong getSapXepCkb() {
        return SapXepCkb;
    }

    public void setSapXepCkb(ComboboxThuong SapXepCkb) {
        this.SapXepCkb = SapXepCkb;
    }
    
    public Customers getCustomer() {
        return customers;
    }

    public void setCustomer(Customers cs) {
        this.customers = cs;
    }
    
    public BangDanhSach getBangDSChuHo() {
        return BangDSChuHo;
    }

    public void setBangDSChuHo(BangDanhSach BangDSChuHo) {
        this.BangDSChuHo = BangDSChuHo;
    }
    
        public List<Customers> getDsChuHo() {
        return dsChuHo;
    }

    public void setDsChuHo(List<Customers> dsChuHo) {
        this.dsChuHo = dsChuHo;
    }

    public List<Staffs> getDsNhanVien() {
        return dsNhanVien;
    }

    public void setDsNhanVien(List<Staffs> dsNhanVien) {
        this.dsNhanVien = dsNhanVien;
    }
}
