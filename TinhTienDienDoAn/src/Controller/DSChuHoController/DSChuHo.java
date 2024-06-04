package Controller.DSChuHoController;

import Controller.DAO.AssignmentsDAO;
import Controller.DAO.CustomerDAO;
import Controller.DSE_MeterController.DSE_Meter;
import Controller.SupportFunction.StringProcessing;
import LayMotSoUIdepTaiDay.BangDanhSach;
import Model.Assignments;
import Model.Customers;
import Model.E_Meters;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class DSChuHo {
    private static List<Customers> ListCustomer = new ArrayList<>();;

    public static List<Customers> KhoiTaoListCustomeres() {
        ListCustomer.clear();
        try {
            for(Customers customers : new CustomerDAO().getAll()){
                List <E_Meters> LstE_MetersTemp = new ArrayList<>();
                for(Assignments assignments : new AssignmentsDAO().getAll()){
                    if(assignments.getID_Customer().equals(customers.getID_Customer())){
                        for(E_Meters e_Meters : new DSE_Meter().KhoiTaoListE_Meters()){
                            if(e_Meters.getID_Assignment().equals(assignments.getID_Assignment())){
                                LstE_MetersTemp.add(e_Meters);
                            }
                        }
                    }
                }
                customers.setListE_Meter(LstE_MetersTemp);
                ListCustomer.add(customers);                
            }
        } catch (Exception ex) {
            Logger.getLogger(DSChuHo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ListCustomer;
    }
    
    public static List<Customers> getListCustomer() {
        return ListCustomer;
    }

    public static void setListCustomer(List<Customers> ListCustomer) {
        DSChuHo.ListCustomer = ListCustomer;
    }
    
    public static Customers SearchObjCCCD(String CCCD){
        for(Customers cs : ListCustomer){
            if(cs.getCCCD().equals(CCCD))
                return cs;
        }
        return null;
    }

    public static int SearchIndexCCCD(String CCCD){
        int index = 0;
        for(Customers cs : ListCustomer){
            if(cs.getCCCD().equals(CCCD))
                return index;
            index++;
        }
        return -1;
    }  

    public static Customers SearchObjID(Integer ID){
        for(Customers cs : ListCustomer){
            if(cs.getID_Customer() == ID)
                return cs;
        }
        return null;
    }
    
    public static void Delete(Customers customers) {
        new AssignmentsDAO().DeleteDAO(customers.getID_Customer());
        new CustomerDAO().DeleteDAO(customers);
        int index = SearchIndexCCCD(customers.getCCCD());
        ListCustomer.remove(index);
    }
    
    public static void UpdateAssignment(Integer ID_Customer, Integer ID_Staff){
        new AssignmentsDAO().UpdateAssignmentDAO(ID_Customer, ID_Staff);
    }

    public static void DeleteAssignment(Integer ID_Customer){
        new AssignmentsDAO().DeleteAssignmentDAO(ID_Customer);
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
            check = new StringProcessing().StringSearchingTable(bangDanhSach, Text, 3);          
        }
        return check;
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
        }
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
            if(loaiSapXep == 1)
                new StringProcessing().StringSortingTable(bangDanhSach, 5, true);
            else
                new StringProcessing().StringSortingTable(bangDanhSach, 5, false);             
        }
        else if(thuocTinh == 6){
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
}
