package Controller.SupportFunction;

import Controller.DSE_MeterController.DSE_Meter;
import Controller.DSThongTinGhiDienController.DSThongTinGhiDien;
import Controller.QLPhanQuyenTKController.DSTaiKhoanPhanQuyen;
import Controller.QLThongTinChungController.DSThongTinChung;
import Model.Accounts;
import Model.E_Meter_Details;
import Model.E_Meters;
import Model.Personal_Infos;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CheckingDataExist {
    public static boolean CheckExistCCCD(String CCCD, Personal_Infos ps){
        List<Personal_Infos> list = new ArrayList<>(new DSThongTinChung().getListPersonal_Infos());
        if(ps != null){
            int index = DSThongTinChung.SearchIndexCCCD(ps.getCCCD());
            list.remove(index);
        }
        for(Personal_Infos Ps : list)
            if(Ps.getCCCD().equals(CCCD))
                return true;
        return false;
    }
    
    public static boolean CheckExistAccount(String Account, Accounts Acc){
        List<Accounts> list = new ArrayList<>(new DSTaiKhoanPhanQuyen().getListAccount());
        if(Acc != null){
            int index = DSTaiKhoanPhanQuyen.SearchIndexAccount(Acc.getAccount_Username());
            list.remove(index);
        }
        for(Accounts acc : list)
            if(acc.getAccount_Username().equals(Account))
                return true;
        return false;
    }
    
    public static boolean CheckExistPhone(String Sdt, Personal_Infos ps){
        List<Personal_Infos> list = new ArrayList<>(new DSThongTinChung().getListPersonal_Infos());
        if(ps != null){
            int index = DSThongTinChung.SearchIndexCCCD(ps.getCCCD());
            list.remove(index);
        }
        for(Personal_Infos Ps : list)
            if(Ps.getPhone().equals(Sdt))
                return true;            
        return false;
    }    
    
    public static boolean CheckExistIDE_Meter(String ID, E_Meters e_Meters){
        List<E_Meters> list = new ArrayList<>(new DSE_Meter().getListE_Meters());
        if(e_Meters != null){
            int index = DSE_Meter.SearchIndexID(e_Meters.getID_E_Meter());
            list.remove(index);
        }
        for(E_Meters em : list)
            if(em.getID_E_Meter().equals(ID))
                return true;            
        return false;
    }

    public static boolean CheckExistDateE_Meter_Details(Date date, E_Meter_Details e_Meter_Details, List <E_Meter_Details> lstE_Meter_Details){
        List<E_Meter_Details> list = new ArrayList<>(lstE_Meter_Details);
        
        if(e_Meter_Details != null){
            int index = 0;
            for(E_Meter_Details e_Meter_Details1 : lstE_Meter_Details){
                if(e_Meter_Details1.getID_E_Meter_Detail() == e_Meter_Details.getID_E_Meter_Detail()){
                    break;
                }
                index++;
            }
            list.remove(index);
        }
        Calendar calendarDate = Calendar.getInstance();
        calendarDate.setTime(date);        
        
        int monthDate = calendarDate.get(Calendar.MONTH) + 1; // Tháng bắt đầu từ 0, nên cần cộng thêm 1
        int yearDate = calendarDate.get(Calendar.YEAR);         
        
        for(E_Meter_Details em : list){
            Calendar calendarTemp = Calendar.getInstance();
            calendarTemp.setTime(em.getCreating_Date());
            
            int monthTemp = calendarTemp.get(Calendar.MONTH) + 1; // Tháng bắt đầu từ 0, nên cần cộng thêm 1
            int yearTemp = calendarTemp.get(Calendar.YEAR);  
            
            if(yearDate == yearTemp && monthTemp == monthDate){
                return true;
            }            
        }
        return false;
    }
    
    public static boolean CheckDuplicateAcc(String CCCD){
        int i = 0;
        for(Accounts Acc : new DSTaiKhoanPhanQuyen().getListAccount()){
            if(Acc.getCCCD().equals(CCCD))
                i++;
            if(i == 2)
                return true;
        }
        return false;
    }

    public static boolean CheckDuplicatePrivilege(String CCCD, int Privilege){
        for(Accounts Acc : new DSTaiKhoanPhanQuyen().getListAccount()){
            if(Acc.getCCCD().equals(CCCD)){
                if(Privilege == Acc.getRole())
                    return true;
            }
        }
        
        return false;
    }    
    
    public boolean KtraIDCongTo(String ID){
        if (ID.length() != 8 || !ID.matches("[0-9]+"))
            return false;        
        return true;       
    }
    
    public boolean CheckExistID_E_Meter(String ID){
//        for(ThongTinSuDung thongTinSuDung : new DSThongTinSDController().getLstThongTinSuDungs()){
//            String idE_Meter = thongTinSuDung.getID_E_Meter();
//            if(idE_Meter != null && idE_Meter.equals(ID))
//                return false;            
//        }
        return true;
    }
}
