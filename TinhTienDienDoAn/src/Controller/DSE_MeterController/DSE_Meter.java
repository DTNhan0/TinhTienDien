package Controller.DSE_MeterController;

import Controller.DAO.E_MetersDAO;
import Controller.DSThongTinGhiDienController.DSThongTinGhiDien;
import Controller.SupportFunction.StringProcessing;
import LayMotSoUIdepTaiDay.BangDanhSach;
import Model.E_Meters;
import Model.Staffs;
import java.util.ArrayList;
import java.util.List;
import Model.E_Meter_Details;

public class DSE_Meter {
    private static List<E_Meters> ListE_Meters = new ArrayList<>();

    public static List<E_Meters> KhoiTaoListE_Meters() {
        try {
            ListE_Meters.clear();
            
            for(E_Meters e_Meters : new E_MetersDAO().getAll()){
                List <E_Meter_Details> lstE_Meter_DetailsTemp = new ArrayList<>();
                for(E_Meter_Details e_Meter_Details : DSThongTinGhiDien.KhoiTaoListE_Meters_Details()){
                    if(e_Meters.getID_E_Meter().equals(e_Meter_Details.getID_E_Meter())){
                        lstE_Meter_DetailsTemp.add(e_Meter_Details);
                    }
                }
                e_Meters.setListE_Meter_Details(lstE_Meter_DetailsTemp);
                ListE_Meters.add(e_Meters);
            }
            
            return ListE_Meters;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }    

    public static List<E_Meters> getListE_Meters() {
        return ListE_Meters;
    }

    public static void setListE_Meters(List<E_Meters> ListE_Meters) {
        DSE_Meter.ListE_Meters = ListE_Meters;
    }
    
    public static void Add(E_Meters e_Meters){
        new E_MetersDAO().AddDAO(e_Meters);
        ListE_Meters.add(e_Meters);
    }
    
    public static void Update(E_Meters e_Meters){
        new E_MetersDAO().UpdateDAO(e_Meters);
        int index = SearchIndexID(e_Meters.getID_E_Meter());
        ListE_Meters.set(index, e_Meters);                
    }    
    
    public static void UpdateID(String ID_Moi, String ID_Cu){
        new E_MetersDAO().UpdateIDDAO(ID_Moi, ID_Cu);
        
        int index = SearchIndexID(ID_Cu);
        E_Meters e_Meters = SearchObjID(ID_Cu);
        e_Meters.setID_E_Meter(ID_Moi);
        
        ListE_Meters.set(index, e_Meters);                
    }    

    public static void UpdateAssignment(E_Meters e_Meters, Staffs staffs){
        new E_MetersDAO().UpdateAssignmentDAO(staffs.getID_Staff(), e_Meters.getID_E_Meter());
        
        int index = SearchIndexID(e_Meters.getID_E_Meter());
        E_Meters e_meters = SearchObjID(e_Meters.getID_E_Meter());
        e_meters.setID_Staff_Input(staffs.getID_Staff());
        
        ListE_Meters.set(index, e_Meters);                
    } 
    
    public static E_Meters SearchObjID(String ID){
        for(E_Meters e_Meters : ListE_Meters){
            if(e_Meters.getID_E_Meter().equals(ID))
                return e_Meters;
        }
        return null;
    }

    public static int SearchIndexID(String ID){
        int index = 0;
        for(E_Meters e_Meters : ListE_Meters){
            if(e_Meters.getID_E_Meter().equals(ID))
                return index;
            index++;
        }
        return -1;
    }  
    
    public static boolean Searching(String Text, BangDanhSach bangDanhSach, int type){
        boolean check = false;   
        if(type == 1){
            check = new StringProcessing().StringSearchingTable(bangDanhSach, Text, 0);
        }else if(type == 2){
            check = new StringProcessing().StringSearchingTable(bangDanhSach, Text, 1);       
        }else if(type == 3){
            check = new StringProcessing().StringSearchingTable(bangDanhSach, Text, 2);         
        }else if(type == 4){
            check = new StringProcessing().StringSearchingTable(bangDanhSach, Text, 5);          
        }
        return check;
    }
}
