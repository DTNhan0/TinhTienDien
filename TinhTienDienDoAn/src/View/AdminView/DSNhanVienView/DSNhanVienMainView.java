package View.AdminView.DSNhanVienView;

import Controller.DSNhanVienController.DSNhanVien;
import Controller.SupportFunction.StringProcessing;
import LayMotSoUIdepTaiDay.BangDanhSach;
import LayMotSoUIdepTaiDay.ComboboxThuong;
import Model.Customers;
import Model.Staffs;
import View.AdminView.DSNhanVienView.DSNhanVienDialog.FilterLoaiDateDSNVDialog;
import View.AdminView.DSNhanVienView.DSNhanVienDialog.PhanVaiTroDialog;
import View.AdminView.DSNhanVienView.DSNhanVienDialog.SortLoaiStringDSNVDialog;
import View.AdminView.MainAdminView;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class DSNhanVienMainView extends javax.swing.JPanel {
    private Staffs St;
    private MainAdminView MainAdminview;
    public  List<Staffs> dsStaffs;  
    
    public DSNhanVienMainView(MainAdminView mainAdminView) {
        initComponents();
        this.MainAdminview = mainAdminView;
        this.setSize(MainAdminview.getMainPanel().getSize());
        
        this.dsStaffs = new DSNhanVien().KhoiTaoListStaffs();
        ShowThongTinTuDBS(BangDSNhanVien);    
    }

    public void ShowThongTinTuDBS(BangDanhSach bangDS){
        DefaultTableModel model = (DefaultTableModel) bangDS.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged(); 
        
        dsStaffs = DSNhanVien.getListStaffs();
        
        model.setRowCount(0);    
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
       
        for(Staffs st : dsStaffs){
            String name = st.getFirstname() + " " + st.getMiddleName()+ " " + st.getLastname();
            String Ten = new StringProcessing().Name(name);
            String CongViec = "(Chưa phân công việc)";
            
            if(st.getRoleStaff()!= null){
                if(st.getRoleStaff() == 1)
                    CongViec = "Nhập/xuất hóa đơn";
                else if(st.getRoleStaff() == 0)
                    CongViec = "Ghi điện";          
                else if(st.getRoleStaff() == -1)
                    CongViec = "(Chưa phân vai trò)";
            }
            
            Object[] rowData = {
                st.getCCCD(), Ten, dateFormat.format(st.getDOB()), 
                st.getAddress(), st.getPhone(), st.getAccount_Username(),
                st.getAccount_Password(), CongViec
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
        BangDSNhanVien = new LayMotSoUIdepTaiDay.BangDanhSach();
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
        PhanVaiTroBt = new LayMotSoUIdepTaiDay.ButtonThuong();
        DoiVaiTroBt = new LayMotSoUIdepTaiDay.ButtonThuong();

        setBackground(new java.awt.Color(255, 255, 255));

        BangDSNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CCCD", "Họ và tên", "Ngày sinh", "Địa chỉ", "SĐT", "Account", "Password", "Vai trò"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        BangDSNhanVien.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        BangDSNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BangDSNhanVienMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                BangDSNhanVienMouseReleased(evt);
            }
        });
        BangSrllp.setViewportView(BangDSNhanVien);

        LamMoiBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Refresh.png"))); // NOI18N
        LamMoiBt.setText("Làm mới");
        LamMoiBt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LamMoiBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LamMoiBtActionPerformed(evt);
            }
        });

        DangChonTf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DangChonTf.setForeground(new java.awt.Color(102, 102, 102));
        DangChonTf.setText("NULL");
        DangChonTf.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        DangChonLbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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

        TimKiemCb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CCCD", "Họ và tên", "Địa chỉ", "SĐT", "Account" }));
        TimKiemCb.setSelectedItem(null
        );
        TimKiemCb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TimKiemCb.setLabeText("(Tìm kiếm theo)");
        TimKiemCb.setLineColor(new java.awt.Color(0, 153, 255));
        TimKiemCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimKiemCbActionPerformed(evt);
            }
        });

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

        LocCkb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Theo ngày sinh" }));
        LocCkb.setSelectedItem(null);
        LocCkb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LocCkb.setLabeText("(Chọn thuộc tính cần lọc)");

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

        PhanVaiTroBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Refresh.png"))); // NOI18N
        PhanVaiTroBt.setText("Phân vai trò");
        PhanVaiTroBt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        PhanVaiTroBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhanVaiTroBtActionPerformed(evt);
            }
        });

        DoiVaiTroBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Refresh.png"))); // NOI18N
        DoiVaiTroBt.setText("Đổi vai trò");
        DoiVaiTroBt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DoiVaiTroBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoiVaiTroBtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BangSrllp)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TimKiemTf, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TimKiemCb, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TimKiemBt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LamMoiBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(DangChonLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DangChonTf, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DoiVaiTroBt, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(PhanVaiTroBt, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(41, 41, 41)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LocCkb, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SapXepCkb, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LocBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SapXepBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 19, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(TimKiemCb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(TimKiemTf))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(DangChonLbl)
                                .addComponent(DangChonTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(9, 9, 9))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TimKiemBt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LamMoiBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(PhanVaiTroBt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(DoiVaiTroBt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
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
                        .addGap(18, 18, 18)))
                .addComponent(BangSrllp, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void LamMoiBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LamMoiBtActionPerformed
        MainAdminview.setForm(new DSNhanVienMainView(MainAdminview));
    }//GEN-LAST:event_LamMoiBtActionPerformed

    private void BangDSNhanVienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BangDSNhanVienMousePressed
        int i = BangDSNhanVien.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) BangDSNhanVien.getModel();
        Staffs st = DSNhanVien.SearchObjCCCD((String) model.getValueAt(i, 0));
        this.St = st;
        DangChonTf.setText(St.getCCCD());
    }//GEN-LAST:event_BangDSNhanVienMousePressed

    private void BangDSNhanVienMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BangDSNhanVienMouseReleased
        int i = BangDSNhanVien.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) BangDSNhanVien.getModel();
        Staffs st = DSNhanVien.SearchObjCCCD((String) model.getValueAt(i, 0));
        this.St = st;
        DangChonTf.setText(St.getCCCD());
    }//GEN-LAST:event_BangDSNhanVienMouseReleased

    private void TimKiemBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimKiemBtActionPerformed
        BangDSNhanVien.setSelectionMode(2);
        Object selected = TimKiemCb.getSelectedItem();
        if(TimKiemTf.getText().replaceAll(" ", "").equals("") || selected == null){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn loại tìm kiếm và không bỏ trống thông tin nhập!!!");            
        }else if(selected.equals("CCCD")){
            if(!DSNhanVien.Searching(TimKiemTf.getText(), BangDSNhanVien, 1))
               JOptionPane.showMessageDialog(this, "Không tìm thấy người dùng có CCCD: " + TimKiemTf.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy người dùng có CCCD: " + TimKiemTf.getText());  
        }else if(selected.equals("Họ và tên")){
            if(!DSNhanVien.Searching(TimKiemTf.getText(), BangDSNhanVien, 2))
               JOptionPane.showMessageDialog(this, "Không tìm thấy người dùng có họ tên: " + TimKiemTf.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy người dùng có họ tên: " + TimKiemTf.getText());              
        }else if(selected.equals("Địa chỉ")){
            if(!DSNhanVien.Searching(TimKiemTf.getText(), BangDSNhanVien, 3))
               JOptionPane.showMessageDialog(this, "Không tìm thấy người dùng có địa chỉ: " + TimKiemTf.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy người dùng có địa chỉ: " + TimKiemTf.getText());              
        }else if(selected.equals("SĐT")){
            if(!DSNhanVien.Searching(TimKiemTf.getText(), BangDSNhanVien, 4))
               JOptionPane.showMessageDialog(this, "Không tìm thấy người dùng có SĐT: " + TimKiemTf.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy người dùng có SĐT: " + TimKiemTf.getText());              
        }else if(selected.equals("Account")){
            if(!DSNhanVien.Searching(TimKiemTf.getText(), BangDSNhanVien, 5))
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
            FilterLoaiDateDSNVDialog filterLoaiDateDSNVDialog = new FilterLoaiDateDSNVDialog(this.MainAdminview, this, true);
            filterLoaiDateDSNVDialog.setVisible(true);           
        }
    }//GEN-LAST:event_LocBtActionPerformed

    private void SapXepBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SapXepBtActionPerformed
        Object selected = SapXepCkb.getSelectedItem();
        if(selected == null){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn thuộc tính cần sắp xếp!!!");             
        }else{
            SortLoaiStringDSNVDialog sortLoaiStringDSNVDialog =new SortLoaiStringDSNVDialog(this.MainAdminview, this, true);
            sortLoaiStringDSNVDialog.setVisible(true);  
        }
    }//GEN-LAST:event_SapXepBtActionPerformed

    private void TimKiemCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimKiemCbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TimKiemCbActionPerformed

    private void PhanVaiTroBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhanVaiTroBtActionPerformed
        if(St == null){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên!!!");   
            return;
        }
        if(St.getRoleStaff()!= -1){
            JOptionPane.showMessageDialog(this, "Nhân viên này đã được phân công vai trò, vui lòng chọn nhân viên khác!");      
        }else{
            int confirm = JOptionPane.showConfirmDialog(
                this,
                "Cảnh báo: một khi đã phân vai trò cho nhân viên rồi,"
                + "\nthì chỉ được đổi vai trò dựa theo điều kiện cụ thể."
                + "\nBạn nên kiểm tra thông tin lại kỹ!!!",
            "Xác nhận thêm",
            JOptionPane.WARNING_MESSAGE
            );
            if (confirm == JOptionPane.YES_OPTION) {
                PhanVaiTroDialog phanVaiTroDialog = new PhanVaiTroDialog(this.MainAdminview, this, true);
                phanVaiTroDialog.setVisible(true);  
            }         
        }
    }//GEN-LAST:event_PhanVaiTroBtActionPerformed

    private void DoiVaiTroBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoiVaiTroBtActionPerformed
        if (St == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên cần đổi!!!");
            return;
        }
        
        Boolean checkStaff = false;

        if (!St.getListCustomers().isEmpty()) {
            checkStaff = true;
        }

        if (St.getRoleStaff() == null) {
            JOptionPane.showMessageDialog(this, "Nhân viên chưa được phân công vai trò, vui lòng phân công vai trò trước!");
        } else if (checkStaff) {
            String Message = "Nhân viên này hiện tại đã được phân công để" +
                    "\nlàm việc cho các chủ hộ theo chỉ định. Nếu bạn muốn thay đổi" +
                    "\nvai trò của nhân viên này, bắt buộc phải xóa phần phân công" +
                    "\ncủa nhân viên bên danh sách phân công (chứa các chủ hộ hiện tại" +
                    "\nnhân viên đang làm việc cho!!!)";
            JOptionPane.showMessageDialog(this, Message);
        } else {
            String messageNew = "";
            String messageOld = "";
            Integer Role = null;
            if (St.getRoleStaff() == 1) {
                messageNew = "nhân viên ghi hóa đơn điện";
                messageOld = "nhân viên nhập/xuất hóa đơn";
                Role = 0;
            } else if (St.getRoleStaff() == 0) {
                messageNew = "nhân viên nhập/xuất hóa đơn";
                messageOld = "nhân viên ghi hóa đơn điện";
                Role = 1;
            }

            int confirm = JOptionPane.showConfirmDialog(
                this,
                "Bạn có chắc chắn muốn đổi vai trò nhân viên từ " + messageOld + " này lại thành " + messageNew + " không?",
                "Xác nhận đổi",
                JOptionPane.WARNING_MESSAGE
            );
            if (confirm == JOptionPane.YES_OPTION) {
                St.setRoleStaff(Role);
                DSNhanVien.UpdateRole(St);
                JOptionPane.showMessageDialog(this, "Đã đổi vai trò nhân viên thành công!");
                ShowThongTinTuDBS(BangDSNhanVien);
            }
        }
    }//GEN-LAST:event_DoiVaiTroBtActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LayMotSoUIdepTaiDay.BangDanhSach BangDSNhanVien;
    private javax.swing.JScrollPane BangSrllp;
    private javax.swing.JLabel DangChonLbl;
    private javax.swing.JTextField DangChonTf;
    private LayMotSoUIdepTaiDay.ButtonThuong DoiVaiTroBt;
    private LayMotSoUIdepTaiDay.ButtonThuong LamMoiBt;
    private LayMotSoUIdepTaiDay.ButtonThuong LocBt;
    private LayMotSoUIdepTaiDay.ComboboxThuong LocCkb;
    private LayMotSoUIdepTaiDay.ButtonThuong PhanVaiTroBt;
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
    
    
    public Staffs getSt() {
        return St;
    }

    public void setSt(Staffs St) {
        this.St = St;
    }
    
    public BangDanhSach getBangDSNhanVien() {
        return BangDSNhanVien;
    }

    public void setBangDSNhanVien(BangDanhSach BangDSNhanVien) {
        this.BangDSNhanVien = BangDSNhanVien;
    }    
}
