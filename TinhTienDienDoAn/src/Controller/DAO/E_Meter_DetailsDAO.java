package Controller.DAO;
import Model.E_Meter_Details;
import Controller.DBS;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class E_Meter_DetailsDAO {
    private List<E_Meter_Details> ListE_Meter_Details = new ArrayList<E_Meter_Details>();

    public List<E_Meter_Details> getAll() throws Exception{
        ListE_Meter_Details.clear();
        String SQL = "SELECT * FROM [dbo].[E_METER_DETAILS]";
        
        try(
            Connection con = new DBS().getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
        ){
            while(rs.next()){
                  E_Meter_Details e_Meter_Details = new E_Meter_Details();
                  
                  e_Meter_Details.setID_E_Meter_Detail(rs.getInt("ID"));
                  e_Meter_Details.setID_E_Meter(rs.getString("ID_E_Meter"));
                  e_Meter_Details.setCurrent_Num(rs.getInt("Current_Num"));
                  e_Meter_Details.setCreating_Date(rs.getDate("Creating_Date"));
                  e_Meter_Details.setID_Staff_Input(rs.getInt("ID_Staff_Input"));
                  
                  ListE_Meter_Details.add(e_Meter_Details);
            }
        }
        return ListE_Meter_Details;
    }    
    
    public void AddDAO(E_Meter_Details e_Meter_Details) {
        String SQL = "INSERT INTO [dbo].[E_METER_DETAILS] (ID_E_Meter, Current_Num, Creating_Date, ID_Staff_Input) VALUES (?, ?, ?, ?)";
        
        try {
            Connection con = new DBS().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);

            ps.setString(1, e_Meter_Details.getID_E_Meter());
            ps.setInt(2, e_Meter_Details.getCurrent_Num());
        
            // Chuyển đổi java.util.Date sang java.sql.Date
            Date sqlDate = new java.sql.Date(e_Meter_Details.getCreating_Date().getTime());
            ps.setDate(3, sqlDate);
        
            ps.setInt(4, e_Meter_Details.getID_Staff_Input());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Đã thêm thông tin ghi điện vào hệ thống!!!");
            } else {
                System.out.println("Lỗi không thể thêm thông tin ghi điện vào hệ thống!!!");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Lỗi hệ thống!!! (E_Meter_DetailsDAO) - AddDAO");
        }
    }
    
    
    public void DeleteDAO(E_Meter_Details e_Meter_Details) {
        String SQL = "DELETE [dbo].[E_METER_DETAILS]\n" +
                     "WHERE [ID] = ?";
        try {
            Connection con = new DBS().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
        
            ps.setInt(1, e_Meter_Details.getID_E_Meter_Detail());
        
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Đã xóa thông tin ghi điện trong hệ thống!!!");
            } else {
                System.out.println("Lỗi không thể xóa thông tin ghi điện trong hệ thống!!!");
            }
        
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Lỗi hệ thống!!! (E_Meter_DetailsDAO) - DeleteDAO");
        }
    }    
    
    public void UpdateDAO(E_Meter_Details e_Meter_Details) {
        String SQL = "UPDATE [dbo].[E_METER_DETAILS] " +
                     "SET [Current_Num] = ?, \n" +
                     "    [Creating_Date] = ?, \n" +
                     "    [ID_Staff_Input] = ? \n" +  // Thêm dấu cách ở đây
                     "WHERE [ID] = ?";
        try {
            Connection con = new DBS().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);

            ps.setInt(1, e_Meter_Details.getCurrent_Num());

            Date sqlDate = new java.sql.Date(e_Meter_Details.getCreating_Date().getTime());
            ps.setDate(2, sqlDate);

            ps.setInt(3, e_Meter_Details.getID_Staff_Input());       

            ps.setInt(4, e_Meter_Details.getID_E_Meter_Detail());
        
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Đã cập nhật thông tin ghi điện trong hệ thống!!!");
            } else {
                System.out.println("Lỗi không thể cập nhật thông tin ghi điện trong hệ thống!!!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Lỗi hệ thống!!! (E_Meter_DetailsDAO) - UpdateDAO");
        }
    }
     
}
