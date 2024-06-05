package Controller.DSThongTinGhiDienController;

import Controller.DAO.E_Meter_DetailsDAO;
import Controller.SupportFunction.StringProcessing;
import LayMotSoUIdepTaiDay.BangDanhSach;
import Model.E_Meter_Details;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DSThongTinGhiDien {
    private static List <E_Meter_Details> ListE_Meter_Details = new ArrayList<>();
    
    public static List<E_Meter_Details> KhoiTaoListE_Meters_Details() {
        try {
            ListE_Meter_Details = new E_Meter_DetailsDAO().getAll();
            return ListE_Meter_Details;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }    

    public List<E_Meter_Details> getListE_Meter_Details() {
        return ListE_Meter_Details;
    }

    public void setListE_Meter_Details(List<E_Meter_Details> ListE_Meter_Details) {
        this.ListE_Meter_Details = ListE_Meter_Details;
    }

    
    public static void Add(E_Meter_Details e_Meter_Details){
        new E_Meter_DetailsDAO().AddDAO(e_Meter_Details);
        ListE_Meter_Details.add(e_Meter_Details);
    }
    
    public static void Update(E_Meter_Details e_Meter_Details){
        new E_Meter_DetailsDAO().UpdateDAO(e_Meter_Details);
        int index = SearchIndexID(e_Meter_Details.getID_E_Meter_Detail());
        ListE_Meter_Details.set(index, e_Meter_Details);                
    }     
 
    public static void Delete(E_Meter_Details e_Meter_Details){
        new E_Meter_DetailsDAO().DeleteDAO(e_Meter_Details);
        int index = SearchIndexID(e_Meter_Details.getID_E_Meter_Detail());
        ListE_Meter_Details.remove(index);                
    }         
    
    public static E_Meter_Details SearchObjID(Integer ID){
        for(E_Meter_Details e_Meter_Details : ListE_Meter_Details){
            if(e_Meter_Details.getID_E_Meter_Detail().equals(ID))
                return e_Meter_Details;
        }
        return null;
    }

    public static int SearchIndexID(Integer ID){
        int index = 0;
        for(E_Meter_Details e_Meter_Details : ListE_Meter_Details){
            if(e_Meter_Details.getID_E_Meter_Detail() == ID)
                return index;
            index++;
        }
        return -1;
    } 

    public static E_Meter_Details FindClosetDateE_MeterDetails(E_Meter_Details e_Meter_Details){
        List<E_Meter_Details> lstTemp = new ArrayList<>(ListE_Meter_Details); 
        lstTemp.removeIf(E_Meter_detail -> !E_Meter_detail.getID_E_Meter().equals(e_Meter_Details.getID_E_Meter()));
        
        E_Meter_Details res = null;
        
        Date TargetDate = e_Meter_Details.getCreating_Date();
        Date CloseDate = null;
        
        for (E_Meter_Details em : lstTemp) {
            Date currentDate = em.getCreating_Date();
            // Chỉ xét những ngày nhỏ hơn ngày mục tiêu
            if (currentDate.before(TargetDate)) {
                if (CloseDate == null || (currentDate.after(CloseDate))) {
                    CloseDate = currentDate;
                    res = em;
                }
            }
        }
        return res;
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
