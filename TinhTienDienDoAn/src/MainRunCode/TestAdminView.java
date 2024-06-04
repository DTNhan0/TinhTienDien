package MainRunCode;

import Controller.DSChuHoController.DSChuHo;
import Controller.DSE_MeterController.DSE_Meter;
import Controller.DSHoaDonDienController.DSHoaDonDien;
import Controller.DSNhanVienController.DSNhanVien;
import Controller.DSThongTinGhiDienController.DSThongTinGhiDien;
import Controller.QLPhanQuyenTKController.DSTaiKhoanPhanQuyen;
import Controller.QLThongTinChungController.DSThongTinChung;
import Model.E_Meter_Details;
import Model.Staffs;
import View.AdminView.MainAdminView;
import java.awt.Desktop;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class TestAdminView {
    private MainAdminView MF = new MainAdminView();
    public void MainFormLoadding() {
        MF.setTitle("Demo");
        MF.setLocationRelativeTo(null);
        MF.setVisible(true);
        MF.setSize(1500, 800);
    }
    public static void main(String[] args) {
        new DSHoaDonDien().KhoiTaoListInvoices();
        new DSThongTinGhiDien().KhoiTaoListE_Meters_Details();
        new DSE_Meter().KhoiTaoListE_Meters();
        new DSThongTinChung().KhoiTaoListPersonal_Infos();
        new DSTaiKhoanPhanQuyen().KhoiTaoListAccount();
        new DSChuHo().KhoiTaoListCustomeres();
        new DSNhanVien().KhoiTaoListStaffs();
        
        TestFrame te = new TestFrame();
        te.setSize(500, 500);
        te.setVisible(true);
//        new TestAdminView().MainFormLoadding();
    }
}
