package Controller.DAO;

import Model.E_Meters;
import Controller.DBS;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class E_MetersDAO {
    private List<E_Meters> ListE_Meters = new ArrayList<E_Meters>();

    public List<E_Meters> getAll() throws Exception{
        ListE_Meters.clear();
        String SQL = "SELECT * FROM [dbo].[E_METERS]";
        
        try(
            Connection con = new DBS().getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
        ){
            while(rs.next()){
                  E_Meters e_Meters = new E_Meters();
                  
                  e_Meters.setID_E_Meter(rs.getString("ID_E_METER"));
                  e_Meters.setID_Assignment(rs.getInt("ID_Assignment"));
                  e_Meters.setID_Staff_Input(rs.getInt("ID_Staff_Input"));
                  e_Meters.setID_Type_Living(rs.getInt("ID_Type_Living"));
                  e_Meters.setIs_Business(rs.getBoolean("Is_Business"));
                  e_Meters.setAddress(rs.getString("Address"));
                  e_Meters.setStatus(rs.getBoolean("Status"));
                  
                  ListE_Meters.add(e_Meters);
            }
        }
        return ListE_Meters;
    }    
    
    public void AddDAO(E_Meters e_Meters) {
        String SQL = "INSERT INTO [dbo].[E_METERS] (ID_E_METER, ID_Assignment, ID_Staff_Input, ID_Type_Living, Is_Business, Address, Status) VALUES (?, ?, NULL, ?, ?, ?, ?)";
        try {
            Connection con = new DBS().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
    
            ps.setString(1, e_Meters.getID_E_Meter());
            ps.setInt(2, e_Meters.getID_Assignment());
            ps.setInt(3, e_Meters.getID_Type_Living());
            ps.setBoolean(4, e_Meters.isIs_Business());
            ps.setString(5, e_Meters.getAddress());
            ps.setBoolean(6, e_Meters.isStatus());
                
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Đã thêm công tơ điện vào hệ thống!!!");
            } else {
                System.out.println("Lỗi không thể thêm công tơ điện vào hệ thống!!!");
            }
    
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Lỗi hệ thống!!! (E_MetersDAO) - AddDAO");
        }
    }
    
    
    public void DeleteDAO(E_Meters e_Meters) {
        String SQL = "DELETE [dbo].[E_METERS]\n" +
                     "WHERE [ID_E_METER] = '?'";
        try {
            Connection con = new DBS().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
        
            ps.setString(1, e_Meters.getID_E_Meter());
        
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Đã xóa công tơ điện trong hệ thống!!!");
            } else {
                System.out.println("Lỗi không thể xóa công tơ điện trong hệ thống!!!");
            }
        
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Lỗi hệ thống!!! (E_MetersDAO) - DeleteDAO");
        }
    }    
    
    public void UpdateDAO(E_Meters e_Meters) {
        String SQL = "UPDATE [dbo].[E_METERS] " +
                    "SET [ID_Type_Living] = ?, " +
                    "    [Is_Business] = ?, " +
                    "    [Address] = ?, " +
                    "    [Status] = ? " +
                    "WHERE [ID_E_METER] = ?";
        try {
            Connection con = new DBS().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
        
            ps.setInt(1, e_Meters.getID_Type_Living());
            ps.setBoolean(2, e_Meters.isIs_Business());
            ps.setString(3, e_Meters.getAddress());
            ps.setBoolean(4, e_Meters.isStatus());
            ps.setString(5, e_Meters.getID_E_Meter());
        
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Đã cập nhật công tơ điện trong hệ thống!!!");
            } else {
                System.out.println("Lỗi không thể cập nhật công tơ điện trong hệ thống!!!");
            }
    
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Lỗi hệ thống!!! (E_MetersDAO) - UpdateDAO");
        }
    }

 
    public void UpdateIDDAO(String ID_Moi, String ID_Cu) {
        String SQL = "UPDATE [dbo].[E_METERS]\n" +
                     "SET [ID_E_METER] = ?\n" +
                     "WHERE [ID_E_METER] = ?";
        try {
            Connection con = new DBS().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
        
            ps.setString(1, ID_Moi);
            ps.setString(2, ID_Cu);
            
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Đã cập nhật ID công tơ điện trong hệ thống!!!");
            } else {
                System.out.println("Lỗi không thể cập nhật ID công tơ điện trong hệ thống!!!");
            }
        
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Lỗi hệ thống!!! (E_MetersDAO) - UpdateDAO");
        }
    }

    public void UpdateAssignmentDAO(Integer ID_Staff_Input, String ID_E_Meter) {
        String SQL = "UPDATE [dbo].[E_METERS]\n" +
                     "SET [ID_Staff_Input] = ?\n" +
                     "WHERE [ID_E_METER] = ?";
        try {
            Connection con = new DBS().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
        
            ps.setInt(1, ID_Staff_Input);
            ps.setString(2, ID_E_Meter);
            
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Đã phân công nhân viên nhập xuất trong hệ thống!!!");
            } else {
                System.out.println("Lỗi không thể phân công nhân viên nhập xuất trong hệ thống!!!");
            }
        
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Lỗi hệ thống!!! (E_MetersDAO) - UpdateAssignmentDAO");
        }
    }
}
