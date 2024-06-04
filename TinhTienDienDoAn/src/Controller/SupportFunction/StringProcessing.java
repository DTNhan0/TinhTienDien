package Controller.SupportFunction;

import LayMotSoUIdepTaiDay.BangDanhSach;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;


public class StringProcessing {
    public static boolean CheckStringSpace(String Text){
        if(Text.contains(" "))
            return true;
        return false;
    }
    
    public static boolean CheckCCCD(String CCCD) {
        // Kiểm tra độ dài
        if (CCCD.length() != 12)
            return true;     
        // Kiểm tra các ký tự có phải là chữ số
        for (int i = 0; i < CCCD.length(); i++)
            if (!Character.isDigit(CCCD.charAt(i)))
                return true;     
        return false;
    }    
    
    public static boolean CheckPhone(String SDT) {
        // Kiểm tra độ dài
        if (SDT.length() != 10) 
            return true;
        // Kiểm tra các ký tự có phải là chữ số
        for (int i = 0; i < SDT.length(); i++) 
            if (!Character.isDigit(SDT.charAt(i))) 
                return true;    
        return false;
    }    
    
    public static boolean CheckID_E_Meter(String ID){
        // Kiểm tra độ dài
        if (ID.length() != 8) 
            return true;
        // Kiểm tra các ký tự có phải là chữ số
        for (int i = 0; i < ID.length(); i++) 
            if (!Character.isDigit(ID.charAt(i))) 
                return true;    
        return false;       
    }
    
    public static boolean CheckIsNumber(String text){
        for (int i = 0; i < text.length(); i++) 
            if (!Character.isDigit(text.charAt(i))) 
                return true;    
        return false;         
    }
    
    public static boolean CheckingDateFormat(Date date) {
        // Định dạng kiểm tra
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        // Kiểm tra xem ngày có đúng định dạng hay không
        String formattedDate = dateFormat.format(date);
        return !formattedDate.equals(dateFormat.format(date));
    }

    public static boolean CheckingDateAge(Date date){
        // Chuyển đổi Date thành LocalDate
        LocalDate birthDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
        // Lấy ngày hiện tại
        LocalDate currentDate = LocalDate.now();
        
        // Tính toán sự chênh lệch giữa ngày sinh và ngày hiện tại
        Period period = Period.between(birthDate, currentDate);
        
        // Kiểm tra xem tuổi có lớn hơn hoặc bằng 18 không
        return !(period.getYears() >= 18);
    }
    
    public static void StringSortingTable(BangDanhSach bangDanhSach, int column, boolean type){
        DefaultTableModel model = (DefaultTableModel) bangDanhSach.getModel();
        Vector<Vector> dataVector = model.getDataVector();

        // Sắp xếp danh sách các từ điển dựa trên cột đã chọn
        dataVector.sort((row1, row2) -> {
            String value1 = row1.get(column).toString();
            String value2 = row2.get(column).toString();
            return value1.compareTo(value2);
        });

        // Đảo ngược thứ tự nếu type là false (sắp xếp Z-A)
        if (!type) {
            Collections.reverse(dataVector);
        }

        // Cập nhật JTable với các hàng đã sắp xếp
        model.fireTableDataChanged();
    }

    public String Name(String name){
        // Xóa khoảng trắng đầu và cuối chuỗi
        name = name.trim();
    
        // Chia tách tên thành mảng các từ
        String[] words = name.split("\\s+");
    
        // Chuẩn hóa từng từ trong mảng
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            // Viết hoa chữ cái đầu của mỗi từ
            if (!word.isEmpty()) {
                result.append(word.substring(0, 1).toUpperCase()); // Viết hoa chữ cái đầu
                result.append(word.substring(1).toLowerCase());   // Chuyển các chữ cái còn lại thành chữ thường
                result.append(" "); // Thêm khoảng trắng sau mỗi từ
            }
        }
    
        // Loại bỏ khoảng trắng thừa ở cuối
        return result.toString().trim();        
    }    
    
    public static void StringDateFilteringTable(BangDanhSach bangDanhSach, String date, int column, String loaiLoc){
        DefaultTableModel model = (DefaultTableModel) bangDanhSach.getModel();
        if(loaiLoc.equals("Ngày")){
            for(int row = 0; row < bangDanhSach.getRowCount(); row++){
                String value = (String) bangDanhSach.getValueAt(row, column);
                if(!value.substring(0, 2).equals(date)){
                    model.removeRow(row);
                    row--;
                }
            }
        }else if(loaiLoc.equals("Tháng")){
            for(int row = 0; row < bangDanhSach.getRowCount(); row++){
                String value = (String) bangDanhSach.getValueAt(row, column);
                if(!value.substring(3, 5).equals(date)){
                    model.removeRow(row);
                    row--;
                }
            }            
        }else if(loaiLoc.equals("Năm")){
            for(int row = 0; row < bangDanhSach.getRowCount(); row++){
                String value = (String) bangDanhSach.getValueAt(row, column);
                if(!value.substring(6, 10).equals(date)){
                    model.removeRow(row);
                    row--;
                }
            }            
        }
    }
    
    public static void StringFiltering(BangDanhSach bangDanhSach, String Text, int column){
        DefaultTableModel model = (DefaultTableModel) bangDanhSach.getModel();
        for(int row = 0; row < bangDanhSach.getRowCount(); row++){
            String value = String.valueOf(bangDanhSach.getValueAt(row, column));
            if(!value.equals(Text)){
                model.removeRow(row);
                row--;
            }
        }   
    }
    
    public static boolean StringSearchingTable(BangDanhSach bangDanhSach, String Text, int column){
        boolean Check = false;
        for(int row = 0; row < bangDanhSach.getRowCount(); row++){
            String value = String.valueOf(bangDanhSach.getValueAt(row, column)) ;
            if(value.contains(Text)){
                bangDanhSach.getSelectionModel().addSelectionInterval(row, row);
                bangDanhSach.scrollRectToVisible(bangDanhSach.getCellRect(row, column, true));
                Check = true;
            }
        }
        return Check;
    }
    
}
