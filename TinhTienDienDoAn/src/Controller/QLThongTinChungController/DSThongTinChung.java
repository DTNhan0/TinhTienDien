package Controller.QLThongTinChungController;

import Controller.DAO.AccountsDAO;
import Controller.DAO.Personal_InfosDAO;
import Controller.SupportFunction.StringProcessing;
import LayMotSoUIdepTaiDay.BangDanhSach;
import Model.Accounts;
import Model.Personal_Infos;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class DSThongTinChung {
    private static List<Personal_Infos> ListPersonal_Infos = new ArrayList<>();
    
    public static List<Personal_Infos> KhoiTaoListPersonal_Infos() {
        try {
            ListPersonal_Infos.clear();
            setListPersonal_Infos(new Personal_InfosDAO().getAll());
            return ListPersonal_Infos;
        } catch (Exception ex) {
            Logger.getLogger(DSThongTinChung.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static List<Personal_Infos> getListPersonal_Infos() {
        return ListPersonal_Infos;
    }

    public static void setListPersonal_Infos(List<Personal_Infos> listPersonal_Infos) {
        DSThongTinChung.ListPersonal_Infos = listPersonal_Infos;
    }
    
    public static void Add(Personal_Infos Ps){
        new Personal_InfosDAO().AddDAO(Ps);
        ListPersonal_Infos.add(Ps);
        Accounts Acc = new Accounts();
        Acc.setAccount_Username("User-" + Ps.getCCCD());
        Acc.setAccount_Password("null");
        Acc.setCCCD(Ps.getCCCD());
        Acc.setRole(-1);
        Acc.setStatus(true);
        new AccountsDAO().AddDAO(Acc);
    }
    
    public static void Update_NoCCCD(Personal_Infos Ps){
        new Personal_InfosDAO().Update_NoCCCDDAO(Ps);
        int index = SearchIndexCCCD(Ps.getCCCD());
        ListPersonal_Infos.set(index, Ps);
    }
    
    public static void UpdateCCCD(String CCCD_Cu, String CCCD_Moi){
        new Personal_InfosDAO().UpdateCCCDDAO(CCCD_Cu, CCCD_Moi);
        int index = SearchIndexCCCD(CCCD_Cu);
        Personal_Infos Ps = SearchObjCCCD(CCCD_Cu);
        Ps.setCCCD(CCCD_Moi);
        ListPersonal_Infos.set(index, Ps);        
    }
    
    public static Personal_Infos SearchObjCCCD(String CCCD){
        for(Personal_Infos Ps : ListPersonal_Infos){
            if(Ps.getCCCD().equals(CCCD))
                return Ps;
        }
        return null;
    }

    public static int SearchIndexCCCD(String CCCD){
        int index = 0;
        for(Personal_Infos Ps : ListPersonal_Infos){
            if(Ps.getCCCD().equals(CCCD))
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
            check = new StringProcessing().StringSearchingTable(bangDanhSach, Text, 3);         
        }else if(type == 4){
            check = new StringProcessing().StringSearchingTable(bangDanhSach, Text, 4);          
        }
        return check;
    }

    public static void Sorting(int loaiSapXep, int thuocTinh, BangDanhSach bangDanhSach){
        if(thuocTinh == 1){
            if(loaiSapXep == 1)
                new StringProcessing().StringSortingTable(bangDanhSach, 0, true);
            else
                new StringProcessing().StringSortingTable(bangDanhSach, 0, false);                
        }else if(thuocTinh == 2){
            if(loaiSapXep == 1)
                new StringProcessing().StringSortingTable(bangDanhSach, 1, true);
            else
                new StringProcessing().StringSortingTable(bangDanhSach, 1, false);             
        }else if(thuocTinh == 3){
            if(loaiSapXep == 1)
                new StringProcessing().StringSortingTable(bangDanhSach, 3, true);
            else
                new StringProcessing().StringSortingTable(bangDanhSach, 3, false);             
        }else if(thuocTinh == 4){
            if(loaiSapXep == 1)
                new StringProcessing().StringSortingTable(bangDanhSach, 4, true);
            else
                new StringProcessing().StringSortingTable(bangDanhSach, 4, false);             
        }else if(thuocTinh == 5){
            DefaultTableModel model = (DefaultTableModel) bangDanhSach.getModel();
            List<Date> dates = new ArrayList<>();

            // Lấy dữ liệu từ cột ngày và chuyển đổi sang đối tượng Date
            for (int row = 0; row < model.getRowCount(); row++) {
                String dateString = (String) model.getValueAt(row, 2);
                // Chuyển đổi ngày từ chuỗi sang đối tượng Date
                try {
                    Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
                    dates.add(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            
            if(loaiSapXep == 1)
            //Trẻ nhất
                Collections.sort(dates, Collections.reverseOrder());
            else
            //Già nhất
                Collections.sort(dates);
            
            // Cập nhật lại bảng với thứ tự đã sắp xếp
            for (int row = 0; row < model.getRowCount(); row++) {
                Date date = dates.get(row);
                String formattedDate = new SimpleDateFormat("dd/MM/yyyy").format(date);
                model.setValueAt(formattedDate, row, 2);
            }                    
        }     
    }
    
    public static void Filter(String dateString, int loaiLoc, int thuocTinh, BangDanhSach bangDanhSach){
        if(thuocTinh == 1){
            if(loaiLoc == 1){
                new StringProcessing().StringDateFilteringTable(bangDanhSach, dateString, 2, "Ngày");
            }
            if(loaiLoc == 2){
                new StringProcessing().StringDateFilteringTable(bangDanhSach, dateString, 2, "Tháng");                
            }
            if(loaiLoc == 3){
                new StringProcessing().StringDateFilteringTable(bangDanhSach, dateString, 2, "Năm");                
            }
        }else if(thuocTinh == 2){
            DefaultTableModel model = (DefaultTableModel) bangDanhSach.getModel(); 
            if(loaiLoc == 1){           
                for(int row = 0; row < bangDanhSach.getRowCount(); row++){
                    String value = (String) bangDanhSach.getValueAt(row, 5);
                    if(!value.equals("Nam")){
                        model.removeRow(row);
                        row--;
                    }
                }
            }else if(loaiLoc == 2){
                for(int row = 0; row < bangDanhSach.getRowCount(); row++){
                    String value = (String) bangDanhSach.getValueAt(row, 5);
                    if(!value.equals("Nữ")){
                        model.removeRow(row);
                        row--;
                    }
                }                
            }
        }
    }
}
