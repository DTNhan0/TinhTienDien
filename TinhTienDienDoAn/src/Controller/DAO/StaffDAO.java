package Controller.DAO;

import Controller.DBS;
import Model.Accounts;
import Model.Staffs;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StaffDAO {
    private List<Staffs> ListStaffs = new ArrayList<Staffs>();

    public List<Staffs> getAll() throws Exception{
        ListStaffs.clear();
        String SQL = "SELECT SF.ID, PS.CCCD, PS.First_name, PS.Middle_name, PS.Last_name, PS.DOB, PS.Address, PS.Sex, PS.Phone, ACC.Account_Username, ACC.Account_Password, SF.Role\n" +
                     "FROM [dbo].[STAFFS] AS SF\n" +
                     "JOIN [dbo].[ACCOUNTS] AS ACC\n" +
                     "ON [Account_Staff] = [Account_Username]\n" +
                     "JOIN [dbo].[PERSONAL_INFOS] AS PS\n" +
                     "ON ACC.CCCD = PS.CCCD\n" +
                     "WHERE [Status] = 1";
        try(
            Connection con = new DBS().getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
        ){
            while(rs.next()){
                  Staffs staffs = new Staffs();
                  staffs.setID_Staff(rs.getInt("ID"));
                  staffs.setCCCD(rs.getString("CCCD"));
                  staffs.setFirstname(rs.getString("First_name"));
                  staffs.setLastname(rs.getString("Last_name"));
                  staffs.setMiddleName(rs.getString("Middle_name")); 
                  staffs.setDOB(rs.getDate("DOB"));
                  staffs.setAddress(rs.getString("Address"));
                  staffs.setPhone(rs.getString("Phone"));
                  staffs.setSex(rs.getBoolean("Sex"));
                  staffs.setRoleStaff(rs.getInt("Role"));
                  
                  staffs.setAccount_Username(rs.getString("Account_Username"));
                  staffs.setAccount_Password(rs.getString("Account_Password"));
                  
                  ListStaffs.add(staffs);
            }
        }
        return ListStaffs;
    }    
    
    public void AddDAO(Accounts accounts) {
        // Thêm Account vào một Account mới 
        String SQL = "INSERT INTO [dbo].[STAFFS] VALUES (?, ?)";
        try {
            Connection con = new DBS().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
        
            ps.setString(1, accounts.getAccount_Username());
            
            ps.setNull(2, -1);
        
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Đã thêm người dùng vào hệ thống!!!");
            } else {
                System.out.println("Lỗi không thể thêm người dùng vào hệ thống!!!");
            }
        
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Lỗi hệ thống!!! (StaffDAO) - AddDAO");
        }
    }

    public void UpdateRoleDAO(Staffs staffs){
        String SQL = "UPDATE [dbo].[STAFFS]\n" +
                     "SET [Role] = ?\n" +
                     "WHERE [Account_Staff] = ?";
        try {
            Connection con = new DBS().getConnection();
            PreparedStatement stmt = con.prepareStatement(SQL);
            
            stmt.setInt(1, staffs.getRoleStaff());
            stmt.setString(2, staffs.getAccount_Username());
         
            int affectedRows = stmt.executeUpdate();
        
            if (affectedRows > 0) {
                System.out.println("Thông báo hệ thống đã cập nhật vai trò nhân viên có CCCD: " + staffs.getCCCD() + " thành công!");
            } else {
                System.out.println("Cập nhật vai trò nhân viên có CCCD: " + staffs.getCCCD() + " trên hệ thống thất bại!!!");
            }
        } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Lỗi hệ thống!!! (StaffDAO) - UpdateRoleDAO");
        }           
    }
    
    public void DeleteDAO(Accounts accounts) {
        String SQL = "DELETE [dbo].[STAFFS]\n" +
                     "WHERE [Account_Staff] = '?'";
        try {
            Connection con = new DBS().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
        
            ps.setString(1, accounts.getAccount_Username());
        
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Đã xóa nhân viên trong hệ thống!!!");
            } else {
                System.out.println("Lỗi không thể xóa nhân viên trong hệ thống!!!");
            }
        
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Lỗi hệ thống!!! (StaffDAO) - DeleteDAO");
        }
    }
}
