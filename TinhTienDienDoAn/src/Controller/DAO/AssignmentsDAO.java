package Controller.DAO;

import Model.Assignments;
import Controller.DBS;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.Customers;
import Model.Staffs;

public class AssignmentsDAO {
private List<Assignments> ListAssignments = new ArrayList<Assignments>();

    public List<Assignments> getAll() throws Exception{
        ListAssignments.clear();
        String SQL = "SELECT * FROM [dbo].[ASSIGNMENTS]";
        try(
            Connection con = new DBS().getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
        ){
            while(rs.next()){
                  Assignments assignments = new Assignments();
                  
                  assignments.setID_Assignment(rs.getInt("ID"));
                  assignments.setID_Customer(rs.getInt("ID_Customer"));
                  assignments.setID_Staff_Write(rs.getInt("ID_Staff_Write"));
                  
                  ListAssignments.add(assignments);
            }
        }
        return ListAssignments;
    }    
    
    public void AddDAO(Customers customer) {
        String SQL = "INSERT INTO [dbo].[ASSIGNMENTS] (ID_Customer) VALUES (?)";
        try {
            Connection con = new DBS().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
        
            ps.setInt(1, customer.getID_Customer());
        
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Đã thêm người dùng vào hệ thống!!!");
            } else {
                System.out.println("Lỗi không thể thêm người dùng vào hệ thống!!!");
            }
        
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Lỗi hệ thống!!! (AssignmentsDAO) - AddDAO");
        }
    }    
    
    public void DeleteDAO(Integer ID_Customer) {
        String SQL = "DELETE [dbo].[ASSIGNMENTS]\n" +
                     "WHERE [ID_Customer] = '?'";
        try {
            Connection con = new DBS().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
        
            ps.setInt(1, ID_Customer);
        
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Đã xóa chủ hộ trong hệ thống!!!");
            } else {
                System.out.println("Lỗi không thể xóa chủ hộ trong hệ thống!!!");
            }
        
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Lỗi hệ thống!!! (AssignmentsDAO) - DeleteDAO");
        }
    } 
    
    public void UpdateAssignmentDAO(Integer ID_Customer, Integer ID_Staff) {
        String SQL = "UPDATE [dbo].[ASSIGNMENTS]\n" +
                     "SET [ID_Staff_Write] = ?\n" +
                     "WHERE [ID_Customer] = ?";
        try {
            Connection con = new DBS().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
        
            ps.setInt(1, ID_Staff);
            ps.setInt(2, ID_Customer);
            
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Đã cập nhật phân công trong hệ thống!!!");
            } else {
                System.out.println("Lỗi không thể cập nhật phân công trong hệ thống!!!");
            }
        
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Lỗi hệ thống!!! (AssignmentsDAO) - UpdateAssignmentDAO");
        }
    }

    public void DeleteAssignmentDAO(Integer ID_Customer) {
        String SQL = "UPDATE [dbo].[ASSIGNMENTS]\n" +
                     "SET [ID_Staff_Write] = NULL\n" +
                     "WHERE [ID_Customer] = ?";
        try {
            Connection con = new DBS().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
        
            ps.setInt(1, ID_Customer);
            
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Đã cập nhật phân công trong hệ thống!!!");
            } else {
                System.out.println("Lỗi không thể cập nhật phân công trong hệ thống!!!");
            }
        
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Lỗi hệ thống!!! (AssignmentsDAO) - UpdateAssignmentDAO");
        }
    }    
}
