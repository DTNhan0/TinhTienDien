
package View.AdminView.ThongTinNhapXuatView;

import Controller.DAO.AssignmentsDAO;
import Controller.DAO.LevelsDAO;
import Controller.DAO.Type_LivingsDAO;
import Controller.DSChuHoController.DSChuHo;
import Controller.DSE_MeterController.DSE_Meter;
import Controller.DSHoaDonDienController.DSHoaDonDien;
import Controller.DSNhanVienController.DSNhanVien;
import Controller.DSThongTinGhiDienController.DSThongTinGhiDien;
import MainRunCode.TestAdminView;
import Model.Assignments;
import Model.Customers;
import Model.E_Meter_Details;
import Model.Invoices;
import Model.Staffs;
import Model.E_Meters;
import Model.Levels;
import Model.Type_Livings;
import java.awt.Desktop;
import java.awt.Label;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class ReportFrame extends javax.swing.JFrame {
    private Customers customers = new Customers();
    private Staffs staff_write = new Staffs();
    private Staffs staff_input = new Staffs();
    private Invoices invoics = new Invoices();
    private E_Meters e_Meters = new E_Meters();
    private E_Meter_Details e_Meter_Details = new E_Meter_Details();
    private Type_Livings type_Livings = new Type_Livings();
    
    private ThongTinNhapXuatSubLowView thongTinNhapXuatSubLowView;
    
    public ReportFrame(JFrame parent, ThongTinNhapXuatSubLowView ttnxslv) {
        initComponents();
        this.setResizable(false);
        this.thongTinNhapXuatSubLowView = ttnxslv;
        this.staff_write = thongTinNhapXuatSubLowView.getStaffs();
        this.e_Meter_Details = thongTinNhapXuatSubLowView.getE_Meter_Details();
        
        setLocationRelativeTo(parent); // Center this frame relative to parent frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose on close, don't exit application
        
        DateTimeFormatter formatterNow = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        
        for(Invoices i : DSHoaDonDien.getListInvoices()){
            if(e_Meter_Details.getID_E_Meter_Detail().equals(i.getID_E_Meter_Details())){
                invoics = i;
            }
        }
        this.staff_input = DSNhanVien.SearchObjID(e_Meter_Details.getID_Staff_Input());
        
        for(E_Meters em : DSE_Meter.KhoiTaoListE_Meters()){           
            if(em.getID_E_Meter().equals(e_Meter_Details.getID_E_Meter())){
                this.e_Meters = em;
                break;
            }
        }
        
        try {
            for(Assignments assignments : new AssignmentsDAO().getAll()){
                if(assignments.getID_Assignment() == e_Meters.getID_Assignment()){
                    this.customers = DSChuHo.SearchObjID(assignments.getID_Customer());
                    break;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ReportFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
             
        //ChuHo
        HoTenCHLbl.setText(customers.getFirstname() + " " + customers.getMiddleName() + customers.getLastname());
        SdtLbl.setText(customers.getPhone());
        DiaChiCHLbl.setText(customers.getAddress());
        CCCDLbl.setText(customers.getCCCD());
        //E_Meter
        MaSoLbl.setText(e_Meter_Details.getID_E_Meter());
        
        for(Type_Livings tl : new Type_LivingsDAO().getAll()){
            if(tl.getID_Type_Living() == e_Meters.getID_Type_Living()){
                type_Livings = tl;
                break;
            }
        }
        LoaiDatLbl.setText(type_Livings.getDetails());     
        
        DiaChiELbl.setText(e_Meters.getAddress());
        if(e_Meters.isIs_Business()){
            KinhDoanhLbl.setText("có kinh doanh");
        }else{
            KinhDoanhLbl.setText("không kinh doanh");
        }
        //NhanVien
        HoTenNVGDLbl.setText(staff_input.getFirstname() + " " + staff_input.getMiddleName() + staff_input.getLastname());
        HoTenNVXLbl.setText(staff_write.getFirstname() + " " + staff_write.getMiddleName() + staff_write.getLastname());
        SdtGDLbl.setText(staff_input.getPhone());
        SdtNVXLbl.setText(staff_write.getPhone());
        
        //Ket Qua
        LocalDate time = LocalDate.now();

        String NgayXuat = time.format(formatterNow);
        DateXuatLbl.setText(NgayXuat);
                
        E_Meter_Details OldEM = DSThongTinGhiDien.FindClosetDateE_MeterDetails(e_Meter_Details);
        
        String NgayTruoc = formatter.format(OldEM.getCreating_Date());
        
        DateDauLbl.setText(NgayTruoc);
        
        String NgaySau = formatter.format(e_Meter_Details.getCreating_Date());        
        
        DateSauLbl.setText(NgaySau);
        
        String TongKwh = String.valueOf(e_Meter_Details.getCurrent_Num() - OldEM.getCurrent_Num());
        
        TotalKwhLbl.setText(TongKwh);
        
        List<String> DonGia = new ArrayList<>();
        
        for(Levels levels : new LevelsDAO().getAll()){
            DonGia.add(String.valueOf(levels.getValue()));
        }
        
        DonGia1Lbl.setText(DonGia.get(0));
        DonGia2Lbl.setText(DonGia.get(1));
        DonGia3Lbl.setText(DonGia.get(2));
        DonGia4Lbl.setText(DonGia.get(3));
        DonGia5Lbl.setText(DonGia.get(4));
        DonGia6Lbl.setText(DonGia.get(5));
        
        List<String> DinhMuc = new ArrayList<>();        
        
        for(String str : DSHoaDonDien.TinhTienDienSanLuongView(e_Meter_Details)){
            DinhMuc.add(str);
        }
        
        SanLuong1Lbl.setText(DinhMuc.get(0));
        SanLuong2Lbl.setText(DinhMuc.get(1));
        SanLuong3Lbl.setText(DinhMuc.get(2));
        SanLuong4Lbl.setText(DinhMuc.get(3));
        SanLuong5Lbl.setText(DinhMuc.get(4));
        SanLuong6Lbl.setText(DinhMuc.get(5));
        
        List<String> ThanhTien = new ArrayList<>();        
        
        for(String str : DSHoaDonDien.TinhTienDienThanhTienView(e_Meter_Details)){
            ThanhTien.add(str);
        }
        ThanhTien1Lbl.setText(ThanhTien.get(0));
        SanLuong2Lbl.setText(ThanhTien.get(1));
        SanLuong3Lbl.setText(ThanhTien.get(2));
        SanLuong4Lbl.setText(ThanhTien.get(3));
        SanLuong5Lbl.setText(ThanhTien.get(4));
        SanLuong6Lbl.setText(ThanhTien.get(5));
        //Thanh tien
        TongTienTf.setText(String.valueOf(invoics.getTotal_Price()));
        if(e_Meters.isIs_Business()){
            ThueKinhDoanhTf.setText(String.valueOf(type_Livings.getTax() * invoics.getTotal_Price()));
        }else{
            ThueKinhDoanhTf.setText("0");
        }
        TienChuaThueTf.setText(String.valueOf(DSHoaDonDien.TinhTienDien(e_Meter_Details)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        InHoaDonBt = new LayMotSoUIdepTaiDay.ButtonThuong();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        HoTenCHLbl = new javax.swing.JLabel();
        SdtLbl = new javax.swing.JLabel();
        DiaChiCHLbl = new javax.swing.JLabel();
        CCCDLbl = new javax.swing.JLabel();
        MaSoLbl = new javax.swing.JLabel();
        LoaiDatLbl = new javax.swing.JLabel();
        DiaChiELbl = new javax.swing.JLabel();
        KinhDoanhLbl = new javax.swing.JLabel();
        SdtNVXLbl = new javax.swing.JLabel();
        HoTenNVXLbl = new javax.swing.JLabel();
        SdtGDLbl = new javax.swing.JLabel();
        HoTenNVGDLbl = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        TotalKwhLbl = new javax.swing.JLabel();
        DateDauLbl = new javax.swing.JLabel();
        DateXuatLbl = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        DonGia1Lbl = new javax.swing.JLabel();
        DonGia2Lbl = new javax.swing.JLabel();
        DonGia3Lbl = new javax.swing.JLabel();
        DonGia4Lbl = new javax.swing.JLabel();
        DonGia5Lbl = new javax.swing.JLabel();
        DonGia6Lbl = new javax.swing.JLabel();
        SanLuong1Lbl = new javax.swing.JLabel();
        SanLuong2Lbl = new javax.swing.JLabel();
        SanLuong3Lbl = new javax.swing.JLabel();
        SanLuong4Lbl = new javax.swing.JLabel();
        SanLuong5Lbl = new javax.swing.JLabel();
        SanLuong6Lbl = new javax.swing.JLabel();
        ThanhTien1Lbl = new javax.swing.JLabel();
        ThanhTien2Lbl = new javax.swing.JLabel();
        ThanhTien3Lbl = new javax.swing.JLabel();
        ThanhTien4Lbl = new javax.swing.JLabel();
        ThanhTien5Lbl = new javax.swing.JLabel();
        ThanhTien6Lbl = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        TongTienTf = new javax.swing.JTextField();
        ThueKinhDoanhTf = new javax.swing.JTextField();
        TienChuaThueTf = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        DateSauLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("HÓA ĐƠN TIỀN ĐIỆN");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Họ tên chủ hộ:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Số điện thoại:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Địa chỉ:");

        InHoaDonBt.setText("IN HÓA ĐƠN");
        InHoaDonBt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        InHoaDonBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InHoaDonBtActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Mã số công tơ điện:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Loại đất sử dụng:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Địa chỉ:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Nhân viên xuất hóa đơn:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Số điện thoại (ghi điện):");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Nhân viên ghi điện:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Số điện thoại (xuất hóa đơn):");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Kinh doanh:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("CCCD:");

        HoTenCHLbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        HoTenCHLbl.setForeground(new java.awt.Color(0, 0, 0));
        HoTenCHLbl.setText("NULL");

        SdtLbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SdtLbl.setForeground(new java.awt.Color(0, 0, 0));
        SdtLbl.setText("NULL");

        DiaChiCHLbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DiaChiCHLbl.setForeground(new java.awt.Color(0, 0, 0));
        DiaChiCHLbl.setText("NULL");

        CCCDLbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CCCDLbl.setForeground(new java.awt.Color(0, 0, 0));
        CCCDLbl.setText("NULL");

        MaSoLbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MaSoLbl.setForeground(new java.awt.Color(0, 0, 0));
        MaSoLbl.setText("NULL");

        LoaiDatLbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LoaiDatLbl.setForeground(new java.awt.Color(0, 0, 0));
        LoaiDatLbl.setText("NULL");

        DiaChiELbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DiaChiELbl.setForeground(new java.awt.Color(0, 0, 0));
        DiaChiELbl.setText("NULL");

        KinhDoanhLbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        KinhDoanhLbl.setForeground(new java.awt.Color(0, 0, 0));
        KinhDoanhLbl.setText("NULL");

        SdtNVXLbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SdtNVXLbl.setForeground(new java.awt.Color(0, 0, 0));
        SdtNVXLbl.setText("NULL");

        HoTenNVXLbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        HoTenNVXLbl.setForeground(new java.awt.Color(0, 0, 0));
        HoTenNVXLbl.setText("NULL");

        SdtGDLbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SdtGDLbl.setForeground(new java.awt.Color(0, 0, 0));
        SdtGDLbl.setText("NULL");

        HoTenNVGDLbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        HoTenNVGDLbl.setForeground(new java.awt.Color(0, 0, 0));
        HoTenNVGDLbl.setText("NULL");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setText("Ngày xuất hóa đơn:");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setText("Từ ngày - đến ngày:");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setText("Tổng điện năng tiêu thụ (kWh):");

        TotalKwhLbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TotalKwhLbl.setForeground(new java.awt.Color(0, 0, 0));
        TotalKwhLbl.setText("NULL");

        DateDauLbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DateDauLbl.setForeground(new java.awt.Color(0, 0, 0));
        DateDauLbl.setText("NULL");

        DateXuatLbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DateXuatLbl.setForeground(new java.awt.Color(0, 0, 0));
        DateXuatLbl.setText("NULL");

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 51, 51));
        jLabel32.setText("Kết quả:");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setText("Bậc thang 1");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 0));
        jLabel34.setText("Bậc thang 2");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 0, 0));
        jLabel35.setText("Bậc thang 3");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 0, 0));
        jLabel36.setText("Bậc thang 4");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 0, 0));
        jLabel37.setText("Bậc thang 5");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 0, 0));
        jLabel38.setText("Bậc thang 6");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 0, 0));
        jLabel39.setText("ĐƠN GIÁ(đồng/kWh)");

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 0, 0));
        jLabel40.setText("SẢN LƯỢNG(kWh)");

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 0, 0));
        jLabel41.setText("THÀNH TIỀN(đồng)");

        DonGia1Lbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DonGia1Lbl.setForeground(new java.awt.Color(0, 0, 0));
        DonGia1Lbl.setText("NULL");

        DonGia2Lbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DonGia2Lbl.setForeground(new java.awt.Color(0, 0, 0));
        DonGia2Lbl.setText("NULL");

        DonGia3Lbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DonGia3Lbl.setForeground(new java.awt.Color(0, 0, 0));
        DonGia3Lbl.setText("NULL");

        DonGia4Lbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DonGia4Lbl.setForeground(new java.awt.Color(0, 0, 0));
        DonGia4Lbl.setText("NULL");

        DonGia5Lbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DonGia5Lbl.setForeground(new java.awt.Color(0, 0, 0));
        DonGia5Lbl.setText("NULL");

        DonGia6Lbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DonGia6Lbl.setForeground(new java.awt.Color(0, 0, 0));
        DonGia6Lbl.setText("NULL");

        SanLuong1Lbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SanLuong1Lbl.setForeground(new java.awt.Color(0, 0, 0));
        SanLuong1Lbl.setText("NULL");

        SanLuong2Lbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SanLuong2Lbl.setForeground(new java.awt.Color(0, 0, 0));
        SanLuong2Lbl.setText("NULL");

        SanLuong3Lbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SanLuong3Lbl.setForeground(new java.awt.Color(0, 0, 0));
        SanLuong3Lbl.setText("NULL");

        SanLuong4Lbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SanLuong4Lbl.setForeground(new java.awt.Color(0, 0, 0));
        SanLuong4Lbl.setText("NULL");

        SanLuong5Lbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SanLuong5Lbl.setForeground(new java.awt.Color(0, 0, 0));
        SanLuong5Lbl.setText("NULL");

        SanLuong6Lbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SanLuong6Lbl.setForeground(new java.awt.Color(0, 0, 0));
        SanLuong6Lbl.setText("NULL");

        ThanhTien1Lbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ThanhTien1Lbl.setForeground(new java.awt.Color(0, 0, 0));
        ThanhTien1Lbl.setText("NULL");

        ThanhTien2Lbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ThanhTien2Lbl.setForeground(new java.awt.Color(0, 0, 0));
        ThanhTien2Lbl.setText("NULL");

        ThanhTien3Lbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ThanhTien3Lbl.setForeground(new java.awt.Color(0, 0, 0));
        ThanhTien3Lbl.setText("NULL");

        ThanhTien4Lbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ThanhTien4Lbl.setForeground(new java.awt.Color(0, 0, 0));
        ThanhTien4Lbl.setText("NULL");

        ThanhTien5Lbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ThanhTien5Lbl.setForeground(new java.awt.Color(0, 0, 0));
        ThanhTien5Lbl.setText("NULL");

        ThanhTien6Lbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ThanhTien6Lbl.setForeground(new java.awt.Color(0, 0, 0));
        ThanhTien6Lbl.setText("NULL");

        jLabel60.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 51, 51));
        jLabel60.setText("Thành tiền:");

        jLabel61.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(0, 0, 0));
        jLabel61.setText("Tiền điện chưa thuế:");

        jLabel62.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(0, 0, 0));
        jLabel62.setText("Thuế kinh doanh(dựa đất sử dụng):");

        jLabel63.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(0, 0, 0));
        jLabel63.setText("Tổng cộng tiền thanh toán(đồng):");

        TongTienTf.setEditable(false);
        TongTienTf.setBackground(new java.awt.Color(255, 255, 255));
        TongTienTf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TongTienTf.setForeground(new java.awt.Color(255, 0, 0));
        TongTienTf.setText("NULL");

        ThueKinhDoanhTf.setEditable(false);
        ThueKinhDoanhTf.setBackground(new java.awt.Color(255, 255, 255));
        ThueKinhDoanhTf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ThueKinhDoanhTf.setForeground(new java.awt.Color(0, 0, 0));
        ThueKinhDoanhTf.setText("NULL");

        TienChuaThueTf.setEditable(false);
        TienChuaThueTf.setBackground(new java.awt.Color(255, 255, 255));
        TienChuaThueTf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TienChuaThueTf.setForeground(new java.awt.Color(0, 0, 0));
        TienChuaThueTf.setText("NULL");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        DateSauLbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DateSauLbl.setForeground(new java.awt.Color(0, 0, 0));
        DateSauLbl.setText("NULL");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CCCDLbl)
                    .addComponent(DiaChiCHLbl)
                    .addComponent(SdtLbl)
                    .addComponent(HoTenCHLbl))
                .addGap(95, 95, 95)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(KinhDoanhLbl)
                    .addComponent(DiaChiELbl)
                    .addComponent(LoaiDatLbl)
                    .addComponent(MaSoLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HoTenNVGDLbl)
                    .addComponent(SdtGDLbl)
                    .addComponent(HoTenNVXLbl)
                    .addComponent(SdtNVXLbl))
                .addGap(100, 100, 100))
            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(317, 317, 317)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel33)
                                    .addComponent(jLabel34)
                                    .addComponent(jLabel35)
                                    .addComponent(jLabel36)
                                    .addComponent(jLabel37)
                                    .addComponent(jLabel38))
                                .addGap(124, 124, 124)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DonGia1Lbl)
                                    .addComponent(DonGia2Lbl)
                                    .addComponent(DonGia3Lbl)
                                    .addComponent(DonGia4Lbl)
                                    .addComponent(DonGia5Lbl)
                                    .addComponent(DonGia6Lbl))
                                .addGap(213, 213, 213)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SanLuong2Lbl)
                                    .addComponent(SanLuong1Lbl)
                                    .addComponent(SanLuong6Lbl)
                                    .addComponent(SanLuong3Lbl)
                                    .addComponent(SanLuong4Lbl)
                                    .addComponent(SanLuong5Lbl))
                                .addGap(206, 206, 206)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ThanhTien5Lbl, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ThanhTien4Lbl, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ThanhTien3Lbl, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ThanhTien6Lbl, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ThanhTien2Lbl, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ThanhTien1Lbl, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jLabel60)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(273, 273, 273)
                                .addComponent(jLabel27)
                                .addGap(18, 18, 18)
                                .addComponent(DateDauLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(DateSauLbl))
                            .addComponent(jLabel32)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addGap(18, 18, 18)
                                .addComponent(TotalKwhLbl))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addGap(21, 21, 21)
                                .addComponent(DateXuatLbl))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(155, 155, 155)
                                        .addComponent(jLabel39)
                                        .addGap(105, 105, 105)
                                        .addComponent(jLabel40))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel62)
                                            .addComponent(jLabel61)
                                            .addComponent(jLabel63))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TienChuaThueTf, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TongTienTf, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ThueKinhDoanhTf, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(64, 64, 64)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(InHoaDonBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel41))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(HoTenCHLbl))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel3)
                                            .addComponent(SdtLbl))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel4)
                                            .addComponent(DiaChiCHLbl))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel13)
                                            .addComponent(CCCDLbl)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5)
                                            .addComponent(MaSoLbl))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel6)
                                            .addComponent(LoaiDatLbl))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel7)
                                            .addComponent(DiaChiELbl))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel12)
                                            .addComponent(KinhDoanhLbl)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel10)
                                            .addComponent(HoTenNVGDLbl))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel9)
                                            .addComponent(SdtGDLbl))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel8)
                                            .addComponent(HoTenNVXLbl))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel11)
                                            .addComponent(SdtNVXLbl)))
                                    .addComponent(jSeparator2)
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel26)
                                            .addComponent(DateXuatLbl)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(DateSauLbl))))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel27)
                        .addComponent(DateDauLbl)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(TotalKwhLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40)
                    .addComponent(jLabel41))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(DonGia1Lbl))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(DonGia2Lbl))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(DonGia3Lbl))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(DonGia4Lbl))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(DonGia5Lbl))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(DonGia6Lbl)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(SanLuong1Lbl)
                        .addGap(18, 18, 18)
                        .addComponent(SanLuong2Lbl)
                        .addGap(18, 18, 18)
                        .addComponent(SanLuong3Lbl)
                        .addGap(18, 18, 18)
                        .addComponent(SanLuong4Lbl)
                        .addGap(18, 18, 18)
                        .addComponent(SanLuong5Lbl)
                        .addGap(18, 18, 18)
                        .addComponent(SanLuong6Lbl))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ThanhTien1Lbl)
                        .addGap(18, 18, 18)
                        .addComponent(ThanhTien2Lbl)
                        .addGap(18, 18, 18)
                        .addComponent(ThanhTien3Lbl)
                        .addGap(18, 18, 18)
                        .addComponent(ThanhTien4Lbl)
                        .addGap(18, 18, 18)
                        .addComponent(ThanhTien5Lbl)
                        .addGap(18, 18, 18)
                        .addComponent(ThanhTien6Lbl)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel60)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TienChuaThueTf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(ThueKinhDoanhTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InHoaDonBt, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TongTienTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InHoaDonBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InHoaDonBtActionPerformed
        InHoaDonBt.setVisible(false);
        BufferedImage img = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
        this.paint(img.getGraphics());
        try {
            String relativePath = "src/View/ReportView/Test.jpg";
            ImageIO.write(img, "jpg", new File(relativePath));
            Desktop.getDesktop().print(new File(relativePath));
            InHoaDonBt.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(TestAdminView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_InHoaDonBtActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CCCDLbl;
    private javax.swing.JLabel DateDauLbl;
    private javax.swing.JLabel DateSauLbl;
    private javax.swing.JLabel DateXuatLbl;
    private javax.swing.JLabel DiaChiCHLbl;
    private javax.swing.JLabel DiaChiELbl;
    private javax.swing.JLabel DonGia1Lbl;
    private javax.swing.JLabel DonGia2Lbl;
    private javax.swing.JLabel DonGia3Lbl;
    private javax.swing.JLabel DonGia4Lbl;
    private javax.swing.JLabel DonGia5Lbl;
    private javax.swing.JLabel DonGia6Lbl;
    private javax.swing.JLabel HoTenCHLbl;
    private javax.swing.JLabel HoTenNVGDLbl;
    private javax.swing.JLabel HoTenNVXLbl;
    private LayMotSoUIdepTaiDay.ButtonThuong InHoaDonBt;
    private javax.swing.JLabel KinhDoanhLbl;
    private javax.swing.JLabel LoaiDatLbl;
    private javax.swing.JLabel MaSoLbl;
    private javax.swing.JLabel SanLuong1Lbl;
    private javax.swing.JLabel SanLuong2Lbl;
    private javax.swing.JLabel SanLuong3Lbl;
    private javax.swing.JLabel SanLuong4Lbl;
    private javax.swing.JLabel SanLuong5Lbl;
    private javax.swing.JLabel SanLuong6Lbl;
    private javax.swing.JLabel SdtGDLbl;
    private javax.swing.JLabel SdtLbl;
    private javax.swing.JLabel SdtNVXLbl;
    private javax.swing.JLabel ThanhTien1Lbl;
    private javax.swing.JLabel ThanhTien2Lbl;
    private javax.swing.JLabel ThanhTien3Lbl;
    private javax.swing.JLabel ThanhTien4Lbl;
    private javax.swing.JLabel ThanhTien5Lbl;
    private javax.swing.JLabel ThanhTien6Lbl;
    private javax.swing.JTextField ThueKinhDoanhTf;
    private javax.swing.JTextField TienChuaThueTf;
    private javax.swing.JTextField TongTienTf;
    private javax.swing.JLabel TotalKwhLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    // End of variables declaration//GEN-END:variables
}
