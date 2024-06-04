package Controller.DSHoaDonDienController;

import Controller.DAO.InvoicesDAO;
import Controller.DAO.LevelsDAO;
import Controller.DSThongTinGhiDienController.DSThongTinGhiDien;
import Controller.SupportFunction.StringProcessing;
import LayMotSoUIdepTaiDay.BangDanhSach;
import Model.E_Meter_Details;
import Model.Invoices;
import Model.Levels;
import java.util.ArrayList;
import java.util.List;

public class DSHoaDonDien {
    private static List<Invoices> ListInvoices = new ArrayList<>();

    public static List<Invoices> KhoiTaoListInvoices() {
        try {
            ListInvoices.clear();
            ListInvoices = new InvoicesDAO().getAll();
            return ListInvoices;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }    

    public static List<Invoices> getListInvoices() {
        return ListInvoices;
    }

    public static void setListInvoices(List<Invoices> ListInvoices) {
        DSHoaDonDien.ListInvoices = ListInvoices;
    }
    
    public static void Add(Invoices invoices){
        new InvoicesDAO().AddDAO(invoices);
        ListInvoices.add(invoices);
    }
    
    public static void Update(Invoices invoices){
        new InvoicesDAO().UpdateDAO(invoices);
        int index = SearchIndexID(invoices.getID_Invoice());
        ListInvoices.set(index, invoices);                
    }       

    public static Invoices SearchObjID(Integer ID){
        for(Invoices invoices : ListInvoices){
            if(invoices.getID_Invoice() == ID)
                return invoices;
        }
        return null;
    }

    public static int SearchIndexID(Integer ID){
        int index = 0;
        for(Invoices invoices : ListInvoices){
            if(invoices.getID_Invoice() == ID)
                return index;
            index++;
        }
        return -1;
    }
    
    public static int CheckExitsE_Meter_Details(Integer ID){
        int index = 0;
        for(Invoices invoices : ListInvoices){
            if(invoices.getID_E_Meter_Details()== ID)
                return index;
            index++;
        }
        return -1;
    }
    
    //***********************************************************************
    public static float TinhTienDien(E_Meter_Details e_Meter_Details){
        float Res = 0;
        E_Meter_Details Before = DSThongTinGhiDien.FindClosetDateE_MeterDetails(e_Meter_Details);
        float TotalKwh;        
        if(Before == null){
              TotalKwh = e_Meter_Details.getCurrent_Num();
        }else{
              TotalKwh = e_Meter_Details.getCurrent_Num() - Before.getCurrent_Num();            
        }
        

        int index = 2;
        for(Levels levels : new LevelsDAO().getAll()){
            if(levels.getID_Level() == 4 || levels.getID_Level() == 5)
                index-=1;
                        
            float DinhMuc = levels.getMaximum() - levels.getMinimum() + index;
            System.out.println("Định mức: " + DinhMuc);            
            if(TotalKwh > DinhMuc){
                TotalKwh -= DinhMuc;
                Res += DinhMuc * levels.getValue();
            }else if(levels.getID_Level() == 6 && TotalKwh > 0){
                System.out.println(TotalKwh);
                Res += TotalKwh * levels.getValue();
                break;
            }else if(TotalKwh < DinhMuc && TotalKwh > 0){
                Res += TotalKwh * levels.getValue();
                System.out.println(TotalKwh);
                break;
            }
            index++;
        }
        return Res * 1000;
    }
    //***********************************************************************
    
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
