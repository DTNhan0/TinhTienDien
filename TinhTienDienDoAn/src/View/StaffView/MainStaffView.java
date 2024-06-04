package View.StaffView;

import View.AdminView.*;
import Controller.DSChuHoController.DSChuHo;
import Controller.DSNhanVienController.DSNhanVien;
import Controller.QLPhanQuyenTKController.DSTaiKhoanPhanQuyen;
import Controller.QLThongTinChungController.DSThongTinChung;
import LayMotSoUIdepTaiDay.ButtonMenu;
import LayMotSoUIdepTaiDay.Chart.ModelChart;
import View.AdminView.DSChuHoView.DSChuHoMainView;
import View.AdminView.DSNhanVienView.DSNhanVienMainView;
import View.AdminView.QLPhanQuyenTKView.QLPhanQuyenTKMainView;
import View.AdminView.QLThongTinChungView.QLTTChungMainView;
import View.AdminView.TrangChuView.TrangChuMainView;
import View.Login.Login;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.apache.commons.compress.harmony.unpack200.bytecode.forms.ThisFieldRefForm;

public final class MainStaffView extends javax.swing.JFrame {
    public List<ButtonMenu> ListButton;
    DecimalFormat decimalFormat = new DecimalFormat("#");
    DecimalFormat decimalFormat2 = new DecimalFormat("#.##");
    
    public void CapNhatBangTrangThai(){        
        SoChuhoTrangThai.setSoLuong(decimalFormat.format(DSTaiKhoanPhanQuyen.CustomerQuantity()));
        HoaDonThanhToanTrangthai.setSoLuong(decimalFormat.format(DSTaiKhoanPhanQuyen.StaffQuantity()));
//        TrangThaiTien.setSoLuong(decimalFormat2.format(new InvoiceController().getTotalprice()) + " VNĐ");
        this.repaint();
        this.revalidate();
    }
    
    public MainStaffView(){
        new DSTaiKhoanPhanQuyen().KhoiTaoListAccount();
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        SimpleMainTitleBar.init(this);
        ListButton = new ArrayList<>();
        SoChuhoTrangThai.setLabel("Số chủ hộ: ");
        HoaDonThanhToanTrangthai.setLabel("Số nhân viên: ");       
        HoaDonChuaThanhToanTrangthai.setLabel("Tổng doanh thu: ");
        
        CapNhatBangTrangThai();
 
        ImageIcon imageNguoi = new ImageIcon("src/Icon/profile.png");
        ImageIcon imageTien = new ImageIcon("src/Icon/profit.png");
        SoChuhoTrangThai.setIcon(imageNguoi);
        HoaDonThanhToanTrangthai.setIcon(imageNguoi);
        HoaDonChuaThanhToanTrangthai.setIcon(imageTien);
        
        //Thêm button nào thì add vào list
        ListButton.add(DSChuHoBt);
       
        ListButton.add(HoaDonDienBt);
       
        ListButton.add(DangXuatBt);
        ListButton.add(QLThongTinChungBt);
       
//        //Khởi tạo các list
//        new DSThongTinChung().KhoiTaoListPersonal_Infos();
//        new DSTaiKhoanPhanQuyen().KhoiTaoListAccount();
//        new DSChuHo().KhoiTaoListCustomeres();
//        new DSNhanVien().KhoiTaoListStaffs();
        
        //Xử lý chart
//        this.XuLyChart();
        
        //Xử lý đăng xuất
        SimpleMainTitleBar.getSimpleButtonBar().getCmdClose().addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            int confirm = JOptionPane.showConfirmDialog(
                null,
                "Bạn có chắc chắn muốn đăng xuất?",
                "Đăng xuất",
                JOptionPane.YES_NO_OPTION
                );
            if (confirm == JOptionPane.YES_OPTION) {      
                //Xử lý đăng xuất tại đây
                
                //...
                System.exit(0); 
            }}
        });
    }
    
    public void XuLyChart(){
        BarChart1.addLegend("Income", new Color(12, 84, 175), new Color(0, 108, 247));
        BarChart1.addLegend("Expense", new Color(54, 4, 143), new Color(104, 49, 200));
        BarChart1.addLegend("Profit", new Color(5, 125, 0), new Color(95, 209, 69));
        BarChart1.addLegend("Cost", new Color(186, 37, 37), new Color(241, 100, 120));
        BarChart1.addData(new ModelChart("January", new double[]{500, 200, 80, 89}));
        BarChart1.addData(new ModelChart("February", new double[]{600, 750, 90, 150}));
        BarChart1.addData(new ModelChart("March", new double[]{200, 350, 460, 900}));
        BarChart1.addData(new ModelChart("April", new double[]{480, 150, 750, 700}));
        BarChart1.addData(new ModelChart("May", new double[]{350, 540, 300, 150}));
        BarChart1.addData(new ModelChart("June", new double[]{190, 280, 81, 200}));
        BarChart1.start();

        BarChart2.addLegend("Income", new Color(12, 84, 175), new Color(0, 108, 247));
        BarChart2.addLegend("Expense", new Color(54, 4, 143), new Color(104, 49, 200));
        BarChart2.addLegend("Profit", new Color(5, 125, 0), new Color(95, 209, 69));
        BarChart2.addLegend("Cost", new Color(186, 37, 37), new Color(241, 100, 120));
        BarChart2.addData(new ModelChart("January", new double[]{500, 200, 80, 89}));
        BarChart2.addData(new ModelChart("February", new double[]{600, 750, 90, 150}));
        BarChart2.addData(new ModelChart("March", new double[]{200, 350, 460, 900}));
        BarChart2.addData(new ModelChart("April", new double[]{480, 150, 750, 700}));
        BarChart2.addData(new ModelChart("May", new double[]{350, 540, 300, 150}));
        BarChart2.addData(new ModelChart("June", new double[]{190, 280, 81, 200}));
        BarChart2.start();
        
        LineChart.addLegend("Income", new Color(12, 84, 175), new Color(0, 108, 247));
        LineChart.addLegend("Expense", new Color(54, 4, 143), new Color(104, 49, 200));
        LineChart.addLegend("Profit", new Color(5, 125, 0), new Color(95, 209, 69));
        LineChart.addLegend("Cost", new Color(186, 37, 37), new Color(241, 100, 120));
        LineChart.addData(new ModelChart("January", new double[]{500, 200, 80, 89}));
        LineChart.addData(new ModelChart("February", new double[]{600, 750, 90, 150}));
        LineChart.addData(new ModelChart("March", new double[]{200, 350, 460, 900}));
        LineChart.addData(new ModelChart("April", new double[]{480, 150, 750, 700}));
        LineChart.addData(new ModelChart("May", new double[]{350, 540, 300, 150}));
        LineChart.addData(new ModelChart("June", new double[]{190, 280, 81, 200}));
        LineChart.start();
    }
    
    public JPanel getMainPanel() {
        return MainPanel;
    }

    public void setMainPanel(JPanel MainPanel) {
        this.MainPanel = MainPanel;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainBorder = new LayMotSoUIdepTaiDay.PanelBorder();
        Menu = new LayMotSoUIdepTaiDay.Menu();
        DSChuHoBt = new LayMotSoUIdepTaiDay.ButtonMenu();
        LogoApp = new javax.swing.JLabel();
        HoaDonDienBt = new LayMotSoUIdepTaiDay.ButtonMenu();
        DangXuatBt = new LayMotSoUIdepTaiDay.ButtonMenu();
        QLThongTinChungBt = new LayMotSoUIdepTaiDay.ButtonMenu();
        MenuSpr = new javax.swing.JSeparator();
        HoaDonDienBt1 = new LayMotSoUIdepTaiDay.ButtonMenu();
        MainPanel = new javax.swing.JPanel();
        BarChart1 = new LayMotSoUIdepTaiDay.Chart.Chart();
        BarChart2 = new LayMotSoUIdepTaiDay.Chart.Chart();
        LineChart = new LayMotSoUIdepTaiDay.Chart.LineChart();
        SimpleMainTitleBar = new LayMotSoUIdepTaiDay.SimpleTitleBar();
        TrangThaiLp = new javax.swing.JLayeredPane();
        SoChuhoTrangThai = new LayMotSoUIdepTaiDay.PanelTrangThai();
        HoaDonThanhToanTrangthai = new LayMotSoUIdepTaiDay.PanelTrangThai();
        HoaDonChuaThanhToanTrangthai = new LayMotSoUIdepTaiDay.PanelTrangThai();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NHÂN VIÊN ");
        setUndecorated(true);
        setResizable(false);

        MainBorder.setBackground(new java.awt.Color(232, 232, 232));

        DSChuHoBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_user_20px_1.png"))); // NOI18N
        DSChuHoBt.setText("Danh sách chủ hộ");
        DSChuHoBt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DSChuHoBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DSChuHoBtActionPerformed(evt);
            }
        });

        LogoApp.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LogoApp.setForeground(new java.awt.Color(255, 255, 255));
        LogoApp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/logo.png"))); // NOI18N
        LogoApp.setText("Welcome Staff");

        HoaDonDienBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/2.png"))); // NOI18N
        HoaDonDienBt.setText("Hóa đơn điện");
        HoaDonDienBt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        HoaDonDienBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HoaDonDienBtActionPerformed(evt);
            }
        });

        DangXuatBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Logout.png"))); // NOI18N
        DangXuatBt.setText("Đăng xuất");
        DangXuatBt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DangXuatBt.setIconTextGap(6);
        DangXuatBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DangXuatBtActionPerformed(evt);
            }
        });

        QLThongTinChungBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/8.png"))); // NOI18N
        QLThongTinChungBt.setText("Quản lý thông tin chung");
        QLThongTinChungBt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        QLThongTinChungBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QLThongTinChungBtActionPerformed(evt);
            }
        });

        MenuSpr.setBackground(new java.awt.Color(255, 255, 255));
        MenuSpr.setForeground(new java.awt.Color(255, 255, 255));

        HoaDonDienBt1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/2.png"))); // NOI18N
        HoaDonDienBt1.setText("Ghi chỉ số");
        HoaDonDienBt1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        HoaDonDienBt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HoaDonDienBt1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuSpr)
            .addGroup(MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addComponent(LogoApp)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(DSChuHoBt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HoaDonDienBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DangXuatBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(QLThongTinChungBt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                    .addComponent(HoaDonDienBt1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LogoApp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MenuSpr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(QLThongTinChungBt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DSChuHoBt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HoaDonDienBt1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HoaDonDienBt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DangXuatBt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(BarChart1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BarChart2, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LineChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BarChart2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BarChart1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LineChart, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        SimpleMainTitleBar.setBackground(new java.awt.Color(204, 255, 204));

        TrangThaiLp.setLayout(new java.awt.GridLayout(1, 0, 10, 0));
        TrangThaiLp.add(SoChuhoTrangThai);

        HoaDonThanhToanTrangthai.setColor1(new java.awt.Color(51, 153, 255));
        HoaDonThanhToanTrangthai.setColor2(new java.awt.Color(0, 153, 255));
        TrangThaiLp.add(HoaDonThanhToanTrangthai);

        HoaDonChuaThanhToanTrangthai.setAutoscrolls(true);
        HoaDonChuaThanhToanTrangthai.setColor1(new java.awt.Color(255, 204, 51));
        HoaDonChuaThanhToanTrangthai.setColor2(new java.awt.Color(255, 204, 0));
        TrangThaiLp.add(HoaDonChuaThanhToanTrangthai);

        javax.swing.GroupLayout MainBorderLayout = new javax.swing.GroupLayout(MainBorder);
        MainBorder.setLayout(MainBorderLayout);
        MainBorderLayout.setHorizontalGroup(
            MainBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainBorderLayout.createSequentialGroup()
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(MainBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TrangThaiLp, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(SimpleMainTitleBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MainBorderLayout.setVerticalGroup(
            MainBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainBorderLayout.createSequentialGroup()
                .addComponent(SimpleMainTitleBar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainBorderLayout.createSequentialGroup()
                        .addComponent(TrangThaiLp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainBorder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainBorder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void DSChuHoBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DSChuHoBtActionPerformed
            ButtonNhan(DSChuHoBt);
//            this.setForm(new DSChuHoMainView(this));
            CapNhatBangTrangThai();
    }//GEN-LAST:event_DSChuHoBtActionPerformed

    private void HoaDonDienBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HoaDonDienBtActionPerformed
            ButtonNhan(HoaDonDienBt);
            CapNhatBangTrangThai();
    }//GEN-LAST:event_HoaDonDienBtActionPerformed

    private void DangXuatBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DangXuatBtActionPerformed
            ButtonNhan(DangXuatBt);
            this.dispose();
            new Login().setVisible(true);
    }//GEN-LAST:event_DangXuatBtActionPerformed

    private void QLThongTinChungBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QLThongTinChungBtActionPerformed
            ButtonNhan(QLThongTinChungBt);
//            this.setForm(new QLTTChungMainView(this));
            CapNhatBangTrangThai();
    }//GEN-LAST:event_QLThongTinChungBtActionPerformed

    private void HoaDonDienBt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HoaDonDienBt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HoaDonDienBt1ActionPerformed

    public void setForm(JComponent com){
        MainPanel.removeAll();
        MainPanel.setLayout(new BorderLayout());
        MainPanel.add(com, BorderLayout.CENTER);
        MainPanel.repaint();
        MainPanel.revalidate();
    }

    public void ButtonNhan(ButtonMenu bt){
        for(ButtonMenu Bt : ListButton){
            if(!Bt.equals(bt))
                Bt.Reset();
        }
        bt.Nhan();
    }
            
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LayMotSoUIdepTaiDay.Chart.Chart BarChart1;
    private LayMotSoUIdepTaiDay.Chart.Chart BarChart2;
    private LayMotSoUIdepTaiDay.ButtonMenu DSChuHoBt;
    private LayMotSoUIdepTaiDay.ButtonMenu DangXuatBt;
    private LayMotSoUIdepTaiDay.PanelTrangThai HoaDonChuaThanhToanTrangthai;
    private LayMotSoUIdepTaiDay.ButtonMenu HoaDonDienBt;
    private LayMotSoUIdepTaiDay.ButtonMenu HoaDonDienBt1;
    private LayMotSoUIdepTaiDay.PanelTrangThai HoaDonThanhToanTrangthai;
    private LayMotSoUIdepTaiDay.Chart.LineChart LineChart;
    private javax.swing.JLabel LogoApp;
    private LayMotSoUIdepTaiDay.PanelBorder MainBorder;
    private javax.swing.JPanel MainPanel;
    private LayMotSoUIdepTaiDay.Menu Menu;
    private javax.swing.JSeparator MenuSpr;
    private LayMotSoUIdepTaiDay.ButtonMenu QLThongTinChungBt;
    private LayMotSoUIdepTaiDay.SimpleTitleBar SimpleMainTitleBar;
    private LayMotSoUIdepTaiDay.PanelTrangThai SoChuhoTrangThai;
    private javax.swing.JLayeredPane TrangThaiLp;
    // End of variables declaration//GEN-END:variables

}
