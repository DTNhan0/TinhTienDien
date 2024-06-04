package View.AdminView.QLThongTinChungView;

import View.AdminView.QLThongTinChungView.QLTTChungDialog.ThemTTChungDialog;
import Controller.QLThongTinChungController.DSThongTinChung;
import Controller.SupportFunction.StringProcessing;
import LayMotSoUIdepTaiDay.BangDanhSach;
import LayMotSoUIdepTaiDay.ComboboxThuong;
import Model.Personal_Infos;
import View.AdminView.MainAdminView;
import View.AdminView.QLThongTinChungView.QLTTChungDialog.CapNhatCCCDTTChungDialog;
import View.AdminView.QLThongTinChungView.QLTTChungDialog.CapNhatTTChungDialog;
import View.AdminView.QLThongTinChungView.QLTTChungDialog.FilterLoaiDateTTCDialog;
import View.AdminView.QLThongTinChungView.QLTTChungDialog.FilterLoaiGioiTinhTTCDialog;
import View.AdminView.QLThongTinChungView.QLTTChungDialog.SortLoaiDateTTCDialog;
import View.AdminView.QLThongTinChungView.QLTTChungDialog.SortLoaiStringTTCDialog;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class QLTTChungMainView extends javax.swing.JPanel {
    private Personal_Infos Ps;
    private MainAdminView MainAdminview;
    public  List<Personal_Infos> dsInfos;  
    
    public QLTTChungMainView(MainAdminView mainAdminView) {
        initComponents();
        this.MainAdminview = mainAdminView;
        this.setSize(MainAdminview.getMainPanel().getSize());
        
        this.dsInfos = new DSThongTinChung().KhoiTaoListPersonal_Infos();
        ShowThongTinTuDBS(BangDSTTChung);    
    }

    public void ShowThongTinTuDBS(BangDanhSach bangDS){
        DefaultTableModel model = (DefaultTableModel) bangDS.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged(); 
        
        dsInfos = DSThongTinChung.getListPersonal_Infos();
        
        model.setRowCount(0);    
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        for(Personal_Infos ps : dsInfos){
            String Gioi_tinh;
            String name = ps.getFirstname() + " " + ps.getMiddleName()+ " " + ps.getLastname();
            String Ten = new StringProcessing().Name(name);
            if(ps.isSex())
                Gioi_tinh = "Nam";
            else
                Gioi_tinh = "Nữ";
            Object[] rowData = {
                ps.getCCCD(), Ten, dateFormat.format(ps.getDOB()), 
                ps.getAddress(), ps.getPhone(), Gioi_tinh
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
        BangDSTTChung = new LayMotSoUIdepTaiDay.BangDanhSach();
        ThemBt = new LayMotSoUIdepTaiDay.ButtonThuong();
        CapNhatBt = new LayMotSoUIdepTaiDay.ButtonThuong();
        CapNhatCb = new LayMotSoUIdepTaiDay.ComboboxThuong();
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

        BangDSTTChung.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "CCCD", "Họ và tên", "Ngày sinh", "Địa chỉ", "SĐT", "Giới tính"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        BangDSTTChung.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        BangDSTTChung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BangDSTTChungMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                BangDSTTChungMouseReleased(evt);
            }
        });
        BangSrllp.setViewportView(BangDSTTChung);

        ThemBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Isert_icon.png"))); // NOI18N
        ThemBt.setText("Thêm thông tin người dùng");
        ThemBt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ThemBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemBtActionPerformed(evt);
            }
        });

        CapNhatBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/6.png"))); // NOI18N
        CapNhatBt.setText("Cập nhật thông tin người dùng");
        CapNhatBt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CapNhatBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CapNhatBtActionPerformed(evt);
            }
        });

        CapNhatCb.setForeground(new java.awt.Color(0, 0, 0));
        CapNhatCb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cập nhật thông tin chung", "Cập nhật CCCD" }));
        CapNhatCb.setSelectedItem(null
        );
        CapNhatCb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CapNhatCb.setLabeText("(Chọn loại cập nhật)");
        CapNhatCb.setLineColor(new java.awt.Color(0, 153, 255));

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
        TimKiemCb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CCCD", "Họ và tên", "Địa chỉ", "SĐT" }));
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
        LocCkb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Theo ngày sinh", "Theo giới tính" }));
        LocCkb.setSelectedItem(null);
        LocCkb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LocCkb.setLabeText("(Chọn thuộc tính cần lọc)");

        SapXepCkb.setForeground(new java.awt.Color(0, 0, 0));
        SapXepCkb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Theo CCCD", "Theo họ và tên", "Theo địa chỉ", "Theo SĐT", "Theo ngày sinh" }));
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BangSrllp)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TimKiemTf, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TimKiemCb, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(DangChonLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DangChonTf, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TimKiemBt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ThemBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LamMoiBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CapNhatCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CapNhatBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(32, 32, 32)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LocCkb, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(SapXepCkb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LocBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SapXepBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(DangChonLbl)
                                .addComponent(DangChonTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(9, 9, 9))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ThemBt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TimKiemBt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LamMoiBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(CapNhatBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(CapNhatCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(BangSrllp, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ThemBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemBtActionPerformed
        showThemTTChungDialog();
    }//GEN-LAST:event_ThemBtActionPerformed

    private void LamMoiBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LamMoiBtActionPerformed
        MainAdminview.setForm(new QLTTChungMainView(MainAdminview));
    }//GEN-LAST:event_LamMoiBtActionPerformed

    private void CapNhatBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CapNhatBtActionPerformed
        Object selected = CapNhatCb.getSelectedItem();
        if(!(BangDSTTChung.getSelectionModel().isSelectionEmpty()) && (selected != null) && (Ps != null)){          
            if(selected.equals("Cập nhật thông tin chung")){
                showCapNhatTTCDialog();
            }else{
                showCapNhatCCCDTTCDialog();
            }                    
        }else{
            JOptionPane.showMessageDialog(this, "Vui lòng chọn thông tin người dùng cần cập nhật và loại cập nhật trên bảng!!!");
        }
    }//GEN-LAST:event_CapNhatBtActionPerformed

    private void BangDSTTChungMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BangDSTTChungMousePressed
        int i = BangDSTTChung.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) BangDSTTChung.getModel();
        Personal_Infos ps = DSThongTinChung.SearchObjCCCD((String) model.getValueAt(i, 0));
        this.Ps = ps;
        DangChonTf.setText(Ps.getCCCD());
    }//GEN-LAST:event_BangDSTTChungMousePressed

    private void BangDSTTChungMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BangDSTTChungMouseReleased
        int i = BangDSTTChung.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) BangDSTTChung.getModel();
        Personal_Infos ps = DSThongTinChung.SearchObjCCCD((String) model.getValueAt(i, 0));
        this.Ps = ps;
        DangChonTf.setText(Ps.getCCCD());
    }//GEN-LAST:event_BangDSTTChungMouseReleased

    private void TimKiemBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimKiemBtActionPerformed
        BangDSTTChung.setSelectionMode(2);
        Object selected = TimKiemCb.getSelectedItem();
        if(TimKiemTf.getText().replaceAll(" ", "").equals("") || selected == null){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn loại tìm kiếm và không bỏ trống thông tin nhập!!!");            
        }else if(selected.equals("CCCD")){
            if(!DSThongTinChung.Searching(TimKiemTf.getText(), BangDSTTChung, 1))
               JOptionPane.showMessageDialog(this, "Không tìm thấy người dùng có CCCD: " + TimKiemTf.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy người dùng có CCCD: " + TimKiemTf.getText());  
        }else if(selected.equals("Họ và tên")){
            if(!DSThongTinChung.Searching(TimKiemTf.getText(), BangDSTTChung, 2))
               JOptionPane.showMessageDialog(this, "Không tìm thấy người dùng có họ tên: " + TimKiemTf.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy người dùng có họ tên: " + TimKiemTf.getText());              
        }else if(selected.equals("Địa chỉ")){
            if(!DSThongTinChung.Searching(TimKiemTf.getText(), BangDSTTChung, 3))
               JOptionPane.showMessageDialog(this, "Không tìm thấy người dùng có địa chỉ: " + TimKiemTf.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy người dùng có địa chỉ: " + TimKiemTf.getText());              
        }else if(selected.equals("SĐT")){
            if(!DSThongTinChung.Searching(TimKiemTf.getText(), BangDSTTChung, 4))
               JOptionPane.showMessageDialog(this, "Không tìm thấy người dùng có SĐT: " + TimKiemTf.getText());
            else
               JOptionPane.showMessageDialog(this, "Đã tìm thấy người dùng có SĐT: " + TimKiemTf.getText());              
        }
    }//GEN-LAST:event_TimKiemBtActionPerformed

    private void LocBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocBtActionPerformed
        Object selected = LocCkb.getSelectedItem();
        if(selected == null){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn thuộc tính cần lọc!!!");             
        }else if(selected.equals("Theo ngày sinh")){
            FilterLoaiDateTTCDialog filterLoaiDateTTCDialog = new FilterLoaiDateTTCDialog(this.MainAdminview, this, true);
            filterLoaiDateTTCDialog.setVisible(true);           
        }else{
            FilterLoaiGioiTinhTTCDialog filterLoaiGioiTinhTTCDialog = new FilterLoaiGioiTinhTTCDialog(this.MainAdminview, this, true);
            filterLoaiGioiTinhTTCDialog.setVisible(true); 
        }
    }//GEN-LAST:event_LocBtActionPerformed

    private void SapXepBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SapXepBtActionPerformed
        Object selected = SapXepCkb.getSelectedItem();
        if(selected == null){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn thuộc tính cần sắp xếp!!!");             
        }else if(selected.equals("Theo ngày sinh")){
            SortLoaiDateTTCDialog sortLoaiDateTTCDialog = new SortLoaiDateTTCDialog(this.MainAdminview, this, true);
            sortLoaiDateTTCDialog.setVisible(true);           
        }else{
            SortLoaiStringTTCDialog sortLoaiStringTTCDialog = new SortLoaiStringTTCDialog(this.MainAdminview, this, true);
            sortLoaiStringTTCDialog.setVisible(true);  
        }
    }//GEN-LAST:event_SapXepBtActionPerformed

    private void showThemTTChungDialog() {
        ThemTTChungDialog themTTChungDialog = new ThemTTChungDialog(this.MainAdminview, this, true);
        themTTChungDialog.setVisible(true);
    }

    private void showCapNhatTTCDialog() {
        CapNhatTTChungDialog capNhatTTChungDialog = new CapNhatTTChungDialog(this.MainAdminview, this, true);
        capNhatTTChungDialog.setVisible(true);
    }    
    
    private void showCapNhatCCCDTTCDialog() {
        CapNhatCCCDTTChungDialog capNhatCCCDTTChungDialog = new CapNhatCCCDTTChungDialog(this.MainAdminview, this, true);
        capNhatCCCDTTChungDialog.setVisible(true);
    }    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LayMotSoUIdepTaiDay.BangDanhSach BangDSTTChung;
    private javax.swing.JScrollPane BangSrllp;
    private LayMotSoUIdepTaiDay.ButtonThuong CapNhatBt;
    private LayMotSoUIdepTaiDay.ComboboxThuong CapNhatCb;
    private javax.swing.JLabel DangChonLbl;
    private javax.swing.JTextField DangChonTf;
    private LayMotSoUIdepTaiDay.ButtonThuong LamMoiBt;
    private LayMotSoUIdepTaiDay.ButtonThuong LocBt;
    private LayMotSoUIdepTaiDay.ComboboxThuong LocCkb;
    private LayMotSoUIdepTaiDay.ButtonThuong SapXepBt;
    private LayMotSoUIdepTaiDay.ComboboxThuong SapXepCkb;
    private LayMotSoUIdepTaiDay.ButtonThuong ThemBt;
    private LayMotSoUIdepTaiDay.ButtonThuong TimKiemBt;
    private LayMotSoUIdepTaiDay.ComboboxThuong TimKiemCb;
    private javax.swing.JTextField TimKiemTf;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    public Personal_Infos getPs() {
        return Ps;
    }

    public void setPs(Personal_Infos Ps) {
        this.Ps = Ps;
    }
    
    public BangDanhSach getBangDSTTChung() {
        return BangDSTTChung;
    }

    public void setBangDSTTChung(BangDanhSach BangDSTTChung) {
        this.BangDSTTChung = BangDSTTChung;
    }
    
    public ComboboxThuong getSapXepCkb() {
        return SapXepCkb;
    }

    public void setSapXepCkb(ComboboxThuong SapXepCkb) {
        this.SapXepCkb = SapXepCkb;
    }
}
