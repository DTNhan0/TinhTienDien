package Controller.DSNhanVienController;

import Controller.DAO.AssignmentsDAO;
import Controller.DAO.StaffDAO;
import Controller.DAO.SupportDAO;
import Controller.DSChuHoController.DSChuHo;
import Controller.DSE_MeterController.DSE_Meter;
import Controller.DSThongTinGhiDienController.DSThongTinGhiDien;
import Controller.SupportFunction.StringProcessing;
import LayMotSoUIdepTaiDay.BangDanhSach;
import Model.Assignments;
import Model.Customers;
import Model.E_Meter_Details;
import Model.E_Meters;
import Model.Staffs;
import Model.SupportModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class DSNhanVien {
    private static List<Staffs> ListStaffs = new ArrayList<>();

    public static List<Staffs> KhoiTaoListStaffs() {
        try {
            ListStaffs.clear();
            for(Staffs staffs : new StaffDAO().getAll()){
                List <Customers> LstCustomerTemp = new ArrayList<>();
                List <E_Meters> LstE_MetersTemp = new ArrayList<>();
                List <E_Meter_Details> LstE_Meter_Details = new ArrayList<>();
                for(Assignments assignments : new AssignmentsDAO().getAll()){
                    if(assignments.getID_Staff_Write() == staffs.getID_Staff()){
                        LstCustomerTemp.add(DSChuHo.SearchObjID(assignments.getID_Customer()));
                    }
                }
                staffs.setListCustomers(LstCustomerTemp);
                
                if(staffs.getRoleStaff() == 0){
                    for(E_Meters e_Meters : DSE_Meter.getListE_Meters()){
                        if(e_Meters.getID_Staff_Input() == staffs.getID_Staff()){
                            LstE_MetersTemp.add(e_Meters);
                        }
                    }
                    staffs.setListE_Meters(LstE_MetersTemp);                    
                }else if(staffs.getRoleStaff() == 1){
                    for(SupportModel supportModel : new SupportDAO().getAll()){
                        if(supportModel.getID_Staff_Write() == staffs.getID_Staff()){
                            LstE_Meter_Details.add(DSThongTinGhiDien.SearchObjID(supportModel.getID_E_Meter_Detail()));
                        }
                    }
                    staffs.setListE_Meter_Details(LstE_Meter_Details);
                }
                
                ListStaffs.add(staffs);
            }
            
            return ListStaffs;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }    

    public static List<Staffs> getListStaffs() {
        return ListStaffs;
    }

    public static void setListStaffs(List<Staffs> ListStaffs) {
        DSNhanVien.ListStaffs = ListStaffs;
    }

    public static Staffs SearchObjCCCD(String CCCD){
        for(Staffs st : ListStaffs){
            if(st.getCCCD().equals(CCCD))
                return st;
        }
        return null;
    }

    public static int SearchIndexCCCD(String CCCD){
        int index = 0;
        for(Staffs st : ListStaffs){
            if(st.getCCCD().equals(CCCD))
                return index;
            index++;
        }
        return -1;
    }  

    public static Staffs SearchObjID(Integer ID){
        for(Staffs st : ListStaffs){
            if(st.getID_Staff() == ID)
                return st;
        }
        return null;
    }
    
    public static void UpdateRole(Staffs staffs){
        new StaffDAO().UpdateRoleDAO(staffs);
        int index = SearchIndexCCCD(staffs.getCCCD());
        ListStaffs.set(index, staffs);                
    }

    public static void Delete(Staffs staffs) {
        new StaffDAO().DeleteDAO(staffs);
        int index = SearchIndexCCCD(staffs.getCCCD());
        ListStaffs.remove(index);
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
        else if(type == 5){
            check = new StringProcessing().StringSearchingTable(bangDanhSach, Text, 5);          
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
