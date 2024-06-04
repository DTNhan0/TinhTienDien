package View.AdminView.QLPhanQuyenTKView;

import Controller.QLPhanQuyenTKController.DSTaiKhoanPhanQuyen;
import Controller.SupportFunction.StringProcessing;
import LayMotSoUIdepTaiDay.BangDanhSach;
import LayMotSoUIdepTaiDay.ComboboxThuong;
import Model.Accounts;
import View.AdminView.MainAdminView;
import View.AdminView.QLPhanQuyenTKView.QLPhanQuyenTKDialog.CapNhatAccountTKPhanQuyenDialog;
import View.AdminView.QLPhanQuyenTKView.QLPhanQuyenTKDialog.FilterLoaiPhanQuyenDialog;
import View.AdminView.QLPhanQuyenTKView.QLPhanQuyenTKDialog.FilterSoLanPhanQuyenTKDialog;
import View.AdminView.QLPhanQuyenTKView.QLPhanQuyenTKDialog.FilterTrangThaiPQTKDialog;
import View.AdminView.QLPhanQuyenTKView.QLPhanQuyenTKDialog.PhanQuyenTaiKhoanDialog;
import View.AdminView.QLPhanQuyenTKView.QLPhanQuyenTKDialog.SortLoaiStringPQTKDialog;
import View.AdminView.QLPhanQuyenTKView.QLPhanQuyenTKDialog.ThemTKPhanQuyenDialog;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class QLPhanQuyenTKMainView extends javax.swing.JPanel {
    private Accounts Acc;
    private MainAdminView MainAdminview;
    public  List<Accounts> dsAccounts;    
    
    public QLPhanQuyenTKMainView(MainAdminView mainAdminView) {
        initComponents();
        this.MainAdminview = mainAdminView;
        this.setSize(MainAdminview.getMainPanel().getSize());
        
        this.dsAccounts = new DSTaiKhoanPhanQuyen().KhoiTaoListAccount();
        ShowThongTinTuDBS(BangDSPQTKChung);        
    }

    public void ShowThongTinTuDBS(BangDanhSach bangDS){       
        DefaultTableModel model = (DefaultTableModel) bangDS.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged(); 
        
        dsAccounts = DSTaiKhoanPhanQuyen.KhoiTaoListAccount();
        
        model.setRowCount(0);    
        
        for(Accounts acc : dsAccounts){
            String PhanQuyen;
            if(acc.getRole()== 0){
                PhanQuyen = "Chủ hộ";
            }else if(acc.getRole() == 1){
                PhanQuyen = "Nhân viên";
            }else if(acc.getRole() == 2){
                PhanQuyen = "Admin";                
            }else{
                PhanQuyen = "(Chưa phân quyền)";
            }
            String TrangThai;
            if(acc.isStatus()){
                TrangThai = "Mở";
            }else{
                TrangThai = "Đã bị khóa";
            }
            Object[] rowData = {
                acc.getCCCD(), acc.getAccount_Username(), acc.getAccount_Password(),
                PhanQuyen, TrangThai
            };

            model.addRow(rowData);
        }   
        StringProcessing.StringSortingTable(bangDS, 0, true);        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BangSrllp = new javax.swing.JScrollPane();
        BangDSPQTKChung = new LayMotSoUIdepTaiDay.BangDanhSach();
        ThemBt = new LayMotSoUIdepTaiDay.ButtonThuong();
        CapNhatBt = new LayMotSoUIdepTaiDay.ButtonThuong();
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
        PhanQuyenBt = new LayMotSoUIdepTaiDay.ButtonThuong();
        KhoaTKBt = new LayMotSoUIdepTaiDay.ButtonThuong();
        MoTKBt = new LayMotSoUIdepTaiDay.ButtonThuong();

        setBackground(new java.awt.Color(255, 255, 255));

        BangDSPQTKChung.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "CCCD", "Account", "Password", "Phân quyền", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
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
        BangDSPQTKChung.setMaximumSize(new java.awt.Dimension(2147483647, 420));
        BangDSPQTKChung.setMinimumSize(new java.awt.Dimension(75, 420));
        BangDSPQTKChung.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        BangDSPQTKChung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BangDSPQTKChungMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                BangDSPQTKChungMouseReleased(evt);
            }
        });
        BangSrllp.setViewportView(BangDSPQTKChung);

        ThemBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Isert_icon.png"))); // NOI18N
        ThemBt.setText("Tạo tài khoản và phân quyền");
        ThemBt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ThemBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemBtActionPerformed(evt);
            }
        });

        CapNhatBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/6.png"))); // NOI18N
        CapNhatBt.setText("Cập nhật thông tin tài khoản");
        CapNhatBt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CapNhatBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CapNhatBtActionPerformed(evt);
            }
        });

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
        DangChonLbl.setText("Đang chọn (Account):");

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
        TimKiemCb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CCCD", "Account" }));
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
        LocCkb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Theo phân quyền", "Theo trạng thái", "Theo số lần phân quyền" }));
        LocCkb.setSelectedItem(null);
        LocCkb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LocCkb.setLabeText("(Chọn thuộc tính cần lọc)");

        SapXepCkb.setForeground(new java.awt.Color(0, 0, 0));
        SapXepCkb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Theo CCCD", "Theo Account" }));
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

        PhanQuyenBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/flag.png"))); // NOI18N
        PhanQuyenBt.setText("Phân quyền tài khoản");
        PhanQuyenBt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        PhanQuyenBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhanQuyenBtActionPerformed(evt);
            }
        });

        KhoaTKBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/lock.png"))); // NOI18N
        KhoaTKBt.setText("Khóa tài khoản");
        KhoaTKBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KhoaTKBtActionPerformed(evt);
            }
        });

        MoTKBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/unlock.png"))); // NOI18N
        MoTKBt.setText("Mở khóa Tài khoản");
        MoTKBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoTKBtActionPerformed(evt);
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
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(TimKiemTf, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TimKiemCb, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TimKiemBt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(ThemBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(LamMoiBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 93, Short.MAX_VALUE)
                                        .addComponent(MoTKBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(KhoaTKBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(PhanQuyenBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(CapNhatBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(32, 32, 32)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LocCkb, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                                    .addComponent(SapXepCkb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(LocBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(SapXepBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(DangChonLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DangChonTf, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addComponent(BangSrllp, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(LocCkb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LocBt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(15, 15, 15)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(SapXepCkb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SapXepBt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ThemBt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TimKiemBt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LamMoiBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(TimKiemCb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(TimKiemTf)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CapNhatBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PhanQuyenBt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KhoaTKBt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MoTKBt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DangChonLbl)
                    .addComponent(DangChonTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BangSrllp, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ThemBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemBtActionPerformed
        showThemAccDialog();
    }//GEN-LAST:event_ThemBtActionPerformed

    private void LamMoiBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LamMoiBtActionPerformed
        MainAdminview.setForm(new QLPhanQuyenTKMainView(MainAdminview));
    }//GEN-LAST:event_LamMoiBtActionPerformed

    private void CapNhatBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CapNhatBtActionPerformed
        if(Acc != null){          
            showCapNhatAccDialog();              
        }else{
            JOptionPane.showMessageDialog(this, "Vui lòng chọn thông tin người dùng cần cập nhật trên bảng!!!");
        }
    }//GEN-LAST:event_CapNhatBtActionPerformed

    private void BangDSPQTKChungMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BangDSPQTKChungMousePressed
        int i = BangDSPQTKChung.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) BangDSPQTKChung.getModel();
        Accounts acc = DSTaiKhoanPhanQuyen.SearchObjAccount((String) model.getValueAt(i, 1));
        this.Acc = acc;
        DangChonTf.setText(Acc.getAccount_Username());
    }//GEN-LAST:event_BangDSPQTKChungMousePressed

    private void BangDSPQTKChungMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BangDSPQTKChungMouseReleased
        int i = BangDSPQTKChung.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) BangDSPQTKChung.getModel();
        Accounts acc = DSTaiKhoanPhanQuyen.SearchObjAccount((String) model.getValueAt(i, 1));
        this.Acc = acc;
        DangChonTf.setText(Acc.getAccount_Username());
    }//GEN-LAST:event_BangDSPQTKChungMouseReleased

    private void TimKiemBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimKiemBtActionPerformed
        BangDSPQTKChung.setSelectionMode(2);
        Object selected = TimKiemCb.getSelectedItem();
        if(TimKiemTf.getText().replaceAll(" ", "").equals("") || selected == null){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn loại tìm kiếm và không bỏ trống thông tin nhập!!!");            
        }else if(selected.equals("CCCD")){
            if(!DSTaiKhoanPhanQuyen.Searching(TimKiemTf.getText(), BangDSPQTKChung, 1))
               JOptionPane.showMessageDialog(this, "Không tìm thấy người dùng có CCCD: " + TimKiemTf.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy người dùng có CCCD: " + TimKiemTf.getText());  
        }else if(selected.equals("Account")){
            if(!DSTaiKhoanPhanQuyen.Searching(TimKiemTf.getText(), BangDSPQTKChung, 2))
               JOptionPane.showMessageDialog(this, "Không tìm thấy người dùng có Account: " + TimKiemTf.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy người dùng có Account: " + TimKiemTf.getText());              
        }
    }//GEN-LAST:event_TimKiemBtActionPerformed

    private void LocBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocBtActionPerformed
        Object selected = LocCkb.getSelectedItem();
        if(selected == null){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn thuộc tính cần lọc!!!");             
        }else if(selected.equals("Theo phân quyền")){
            showFilterLoaiPhanQuyenTKDialog();
        }else if(selected.equals("Theo trạng thái")){
            showFilterTrangThaiPQTKDialog();    
        }else if(selected.equals("Theo số lần phân quyền")){
            showFilterSoLanPhanQuyenTKDialog();            
        }
    }//GEN-LAST:event_LocBtActionPerformed

    private void SapXepBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SapXepBtActionPerformed
        Object selected = SapXepCkb.getSelectedItem();
        if(selected == null){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn thuộc tính cần sắp xếp!!!");             
        }else if(selected.equals("Theo CCCD")){
            SortLoaiStringPQTKDialog sortLoaiStringPQTKDialog = new SortLoaiStringPQTKDialog(this.MainAdminview, this, true);
            sortLoaiStringPQTKDialog.setVisible(true);           
        }else{
            SortLoaiStringPQTKDialog sortLoaiStringPQTKDialog = new SortLoaiStringPQTKDialog(this.MainAdminview, this, true);
            sortLoaiStringPQTKDialog.setVisible(true);  
        }
    }//GEN-LAST:event_SapXepBtActionPerformed

    private void PhanQuyenBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhanQuyenBtActionPerformed
        if(Acc == null){                
            JOptionPane.showMessageDialog(this, "Vui lòng chọn thông tin người dùng cần phân quyền trên bảng!!!");
        }else if(Acc.getRole()!= -1){
            JOptionPane.showMessageDialog(this, "Tài khoản đã được phân quyền!!! - Vui lòng chọn tài khoản khác");            
        }else{
            showPhanQuyenTKDialog();
        }        
    }//GEN-LAST:event_PhanQuyenBtActionPerformed

    private void KhoaTKBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KhoaTKBtActionPerformed
        if(Acc == null){                
            JOptionPane.showMessageDialog(this, "Vui lòng chọn tài khoản cần khóa trên bảng!!!");
        }else{
            int confirm = JOptionPane.showConfirmDialog(
                this,
                "Bạn có chắc muốn khóa tài khoản người dùng: " + Acc.getAccount_Username() + " không?",
            "Xác nhận",
            JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                try{
                    DSTaiKhoanPhanQuyen.DeleteByStatus(Acc.getAccount_Username());
                    JOptionPane.showMessageDialog(this, "Account: " + Acc.getAccount_Username() + " đã bị khóa!");
                    ShowThongTinTuDBS(BangDSPQTKChung);
                    this.MainAdminview.CapNhatBangTrangThai();
                }catch(Exception e){
                    System.out.println(e);
                    JOptionPane.showMessageDialog(this, "Lỗi hệ thống!!! - Vui lòng thử lại sau", "Lỗi", 
                                                  JOptionPane.ERROR_MESSAGE);
                }
            }
        }         
    }//GEN-LAST:event_KhoaTKBtActionPerformed

    private void MoTKBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoTKBtActionPerformed
        if(Acc == null){                
            JOptionPane.showMessageDialog(this, "Vui lòng chọn tài khoản cần khóa trên bảng!!!");
        }else{
            int confirm = JOptionPane.showConfirmDialog(
                this,
                "Bạn có chắc muốn mở khóa tài khoản người dùng: " + Acc.getAccount_Username() + " không?",
            "Xác nhận",
            JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                try{
                    DSTaiKhoanPhanQuyen.Unlock(Acc.getAccount_Username());
                    JOptionPane.showMessageDialog(this, "Đã mở khóa tài khoản người dùng có Account: " + Acc.getAccount_Username());
                    ShowThongTinTuDBS(BangDSPQTKChung);
                    this.MainAdminview.CapNhatBangTrangThai();
                }catch(Exception e){
                    System.out.println(e);
                    JOptionPane.showMessageDialog(this, "Lỗi hệ thống!!! - Vui lòng thử lại sau", "Lỗi", 
                                                  JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_MoTKBtActionPerformed

    private void showThemAccDialog() {
        ThemTKPhanQuyenDialog themTKPhanQuyenDialog = new ThemTKPhanQuyenDialog(MainAdminview, this, true);
        themTKPhanQuyenDialog.setVisible(true);
    }

    private void showCapNhatAccDialog() {
        CapNhatAccountTKPhanQuyenDialog accountTKPhanQuyenDialog = new CapNhatAccountTKPhanQuyenDialog(MainAdminview, this, true);
        accountTKPhanQuyenDialog.setVisible(true);
    }    
    
    private void showPhanQuyenTKDialog() {
        PhanQuyenTaiKhoanDialog phanQuyenTaiKhoanDialog = new PhanQuyenTaiKhoanDialog(MainAdminview, this, true);
        phanQuyenTaiKhoanDialog.setVisible(true);
    }    
    
    private void showFilterLoaiPhanQuyenTKDialog() {
        FilterLoaiPhanQuyenDialog filterLoaiPhanQuyenDialog = new FilterLoaiPhanQuyenDialog(MainAdminview, this, true);
        filterLoaiPhanQuyenDialog.setVisible(true);
    }    

    private void showFilterTrangThaiPQTKDialog() {
        FilterTrangThaiPQTKDialog filterTrangThaiPQTKDialog = new FilterTrangThaiPQTKDialog(MainAdminview, this, true);
        filterTrangThaiPQTKDialog.setVisible(true);
    }   
    
    private void showFilterSoLanPhanQuyenTKDialog() {
        FilterSoLanPhanQuyenTKDialog filterSoLanPhanQuyenTKDialog = new FilterSoLanPhanQuyenTKDialog(MainAdminview, this, true);
        filterSoLanPhanQuyenTKDialog.setVisible(true);
    } 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LayMotSoUIdepTaiDay.BangDanhSach BangDSPQTKChung;
    private javax.swing.JScrollPane BangSrllp;
    private LayMotSoUIdepTaiDay.ButtonThuong CapNhatBt;
    private javax.swing.JLabel DangChonLbl;
    private javax.swing.JTextField DangChonTf;
    private LayMotSoUIdepTaiDay.ButtonThuong KhoaTKBt;
    private LayMotSoUIdepTaiDay.ButtonThuong LamMoiBt;
    private LayMotSoUIdepTaiDay.ButtonThuong LocBt;
    private LayMotSoUIdepTaiDay.ComboboxThuong LocCkb;
    private LayMotSoUIdepTaiDay.ButtonThuong MoTKBt;
    private LayMotSoUIdepTaiDay.ButtonThuong PhanQuyenBt;
    private LayMotSoUIdepTaiDay.ButtonThuong SapXepBt;
    private LayMotSoUIdepTaiDay.ComboboxThuong SapXepCkb;
    private LayMotSoUIdepTaiDay.ButtonThuong ThemBt;
    private LayMotSoUIdepTaiDay.ButtonThuong TimKiemBt;
    private LayMotSoUIdepTaiDay.ComboboxThuong TimKiemCb;
    private javax.swing.JTextField TimKiemTf;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    public BangDanhSach getBangDSPQTKChung() {
        return BangDSPQTKChung;
    }

    public void setBangDSPQTKChung(BangDanhSach BangDSPQTKChung) {
        this.BangDSPQTKChung = BangDSPQTKChung;
    }
    
    public Accounts getAcc() {
        return Acc;
    }

    public void setAcc(Accounts Acc) {
        this.Acc = Acc;
    }

    public ComboboxThuong getSapXepCkb() {
        return SapXepCkb;
    }

    public void setSapXepCkb(ComboboxThuong SapXepCkb) {
        this.SapXepCkb = SapXepCkb;
    }
}
