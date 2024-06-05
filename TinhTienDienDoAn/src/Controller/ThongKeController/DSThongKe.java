package Controller.ThongKeController;

import Controller.DAO.InvoicesDAO;
import Controller.DSHoaDonDienController.DSHoaDonDien;
import Controller.DSThongTinGhiDienController.DSThongTinGhiDien;
import Model.E_Meter_Details;
import Model.Invoices;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DSThongKe {
    public static List <Float> TongTienDien(int SoNam){
        List <Float> TongTienDien = new ArrayList<>();
        
        for(int i = 1; i <= 12; i++){
            float Sum = 0;            
            for(Invoices invoices : DSHoaDonDien.getListInvoices()){
                Date date = invoices.getInvoice_Date();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH) + 1;                
                if(year == SoNam && month == i){
                    Sum += invoices.getTotal_Price();
                }
            }
            TongTienDien.add(Sum);
        }
        
        return TongTienDien;
    }
    
    public static List <Float> TongKwh(int SoNam){
        List <Float> Tongkwh = new ArrayList<>();
        
        for(int i = 1; i <= 12; i++){
            float Sum = 0;            
            for(E_Meter_Details e_Meter_Details : DSThongTinGhiDien.KhoiTaoListE_Meters_Details()){
                Date date = e_Meter_Details.getCreating_Date();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH) + 1;                
                if(year == SoNam && month == i){
                    E_Meter_Details OldDetails = DSThongTinGhiDien.FindClosetDateE_MeterDetails(e_Meter_Details);
                    if(OldDetails != null)
                        Sum += e_Meter_Details.getCurrent_Num() - OldDetails.getCurrent_Num();
                    else
                        Sum += e_Meter_Details.getCurrent_Num();
                }
            }
            Tongkwh.add(Sum);
        }
        
        return Tongkwh;
    }
    
    public static List<String> LayCacNamTonTai() {
        List<String> NamTonTai = new ArrayList<>();

        // Giả sử DSThongTinGhiDien.KhoiTaoListE_Meters_Details() trả về danh sách E_Meter_Details
        for (E_Meter_Details e_Meter_Details : DSThongTinGhiDien.KhoiTaoListE_Meters_Details()) {
            Date date = e_Meter_Details.getCreating_Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int year = calendar.get(Calendar.YEAR);
            NamTonTai.add(String.valueOf(year));
        }

        // Sử dụng Set để loại bỏ các phần tử trùng lặp
        Set<String> uniqueYears = new HashSet<>(NamTonTai);

        // Chuyển đổi Set trở lại List (nếu cần)
        List<String> uniqueYearsList = new ArrayList<>(uniqueYears);

        return uniqueYearsList;
    }
}
