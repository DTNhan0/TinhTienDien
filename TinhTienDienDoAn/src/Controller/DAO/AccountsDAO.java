package Controller.DAO;
import Controller.DBS;
import Model.Accounts;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountsDAO {
    private List<Accounts> ListAccountDAO = new ArrayList<>();

    public List<Accounts> getListAccountDAO() {
        return ListAccountDAO;
    }

    public void setListAccountDAO(List<Accounts> ListAccountDAO) {
        this.ListAccountDAO = ListAccountDAO;
    }
    
    public List<Accounts> getAll() throws Exception{
        ListAccountDAO.clear();
        String SQL = "SELECT * FROM [dbo].[ACCOUNTS]";
        try(
            Connection con = new DBS().getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
        ){
            while(rs.next()){
                  Accounts Acc = new Accounts();
                  Acc.setAccount_Username(rs.getString("Account_Username"));
                  Acc.setCCCD(rs.getString("CCCD"));
                  Acc.setAccount_Password(rs.getString("Account_Password"));
                  Acc.setRole(rs.getInt("ID_Role"));          
                  Acc.setStatus(rs.getBoolean("Status"));  
                  
                  ListAccountDAO.add(Acc);
            }
        }
        return ListAccountDAO;
    }    
    
    public void AddDAO(Accounts Acc){
        //Thêm Account vào một Account mới 
        String SQL = "INSERT INTO [dbo].[ACCOUNTS] \n" +
                     "VALUES(?, ?, ?, ?, 0);";
        try {
            Connection con = new DBS().getConnection();
            PreparedStatement rs = con.prepareStatement(SQL);
            
            rs.setString(1, Acc.getAccount_Username());
            rs.setString(2, Acc.getAccount_Password());
            rs.setString(3, Acc.getCCCD());            
            rs.setInt(4, Acc.getRole());    
            
            int rowsAffected = rs.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Đã thêm người dùng vào hệ thống!!!");
            } else {
                System.out.println("Lỗi không thể thêm người dùng vào hệ thống!!!");
            }            
            
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Lỗi hệ thống!!! (AccountsDAO) - AddDAO");
        }
    }
    
    public void AddIsDAO(Accounts Acc){
        //Thêm Account vào một Account mới 
        String SQL = "INSERT INTO [dbo].[ACCOUNTS] \n" +
                     "VALUES(?, ?, ?, ?, 0);";
        try {
            Connection con = new DBS().getConnection();
            PreparedStatement rs = con.prepareStatement(SQL);
            
            rs.setString(1, Acc.getAccount_Username());
            rs.setString(2, Acc.getAccount_Password());
            rs.setString(3, Acc.getCCCD());            
            rs.setInt(4, Acc.getRole());    
            
            int rowsAffected = rs.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Đã thêm người dùng vào hệ thống!!!");
            } else {
                System.out.println("Lỗi không thể thêm người dùng vào hệ thống!!!");
            }            
            
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Lỗi hệ thống!!! (AccountsDAO) - AddDAO");
        }
    }
    
    public void DeleteByStatusDAO(String Account){
        String SQL = "UPDATE [dbo].[ACCOUNTS]\n" +
                     "SET [Status] = 0\n" +
                     "WHERE [Account_Username] = ?";
        try {
            Connection con = new DBS().getConnection();
            PreparedStatement rs = con.prepareStatement(SQL);
            
            rs.setString(1, Account);
            
           int rowsAffected = rs.executeUpdate();
           
           if (rowsAffected > 0) {
                System.out.println("Đã khóa account người dùng có Account: " + Account + "trên hệ thống!!!");
                
            } else {
                System.out.println("Lỗi không thể khóa account người dùng có Account: " + Account + " trên hệ thống!!!");
            }  
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Lỗi hệ thống!!! (AccountsDAO) - DeleteByStatusDAO");
        }
    }

    public void DeleteDAO(String Account_Username){
        String SQL = "DELETE [dbo].[ACCOUNTS]\n" +
                     "WHERE [Account_Username] = '?'";
        try {
            Connection con = new DBS().getConnection();
            PreparedStatement rs = con.prepareStatement(SQL);
            
            rs.setString(1, Account_Username);
            
           int rowsAffected = rs.executeUpdate();
           
           if (rowsAffected > 0) {
                System.out.println("Đã xóa account người dùng có Account: " + Account_Username + "trên hệ thống!!!");
                
            } else {
                System.out.println("Lỗi không thể xóa account người dùng có Account: " + Account_Username + " trên hệ thống!!!");
            }  
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Lỗi hệ thống!!! (AccountsDAO) - DeleteDAO");
        }
    }    
    
    public void UnlockDAO(String Account){
        String SQL = "UPDATE [dbo].[ACCOUNTS]\n" +
                     "SET [Status] = 1\n" +
                     "WHERE [Account_Username] = ?";
        try {
            Connection con = new DBS().getConnection();
            PreparedStatement rs = con.prepareStatement(SQL);
            
            rs.setString(1, Account);
            
           int rowsAffected = rs.executeUpdate();
           
           if (rowsAffected > 0) {
                System.out.println("Đã mở khóa account người dùng có Account: " + Account + "trên hệ thống!!!");
                
            } else {
                System.out.println("Lỗi không thể mở khóa account người dùng có Account: " + Account + " trên hệ thống!!!");
            }  
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Lỗi hệ thống!!! (AccountsDAO) - DeleteDAO");
        }
    }    
    
    public void UpdateTTCDAO(Accounts Acc, String UsernameCu){
        String SQL = "UPDATE [dbo].[ACCOUNTS]\n" +
                     "SET [Account_Username] = ?, \n" +
                     "    [Account_Password] = ?  \n" +
                     "WHERE [CCCD] = ? AND [Account_Username] = ?";
      try {
            Connection con = new DBS().getConnection();
            PreparedStatement stmt = con.prepareStatement(SQL);
            
            stmt.setString(1, Acc.getAccount_Username());
            stmt.setString(2, Acc.getAccount_Password());
            stmt.setString(3, Acc.getCCCD()); 
            stmt.setString(4, UsernameCu);
            int affectedRows = stmt.executeUpdate();
        
            if (affectedRows > 0) {
                System.out.println("Thông báo hệ thống đã cập nhật Account người dùng có CCCD: " + Acc.getCCCD() + " thành công!");
            } else {
                System.out.println("Cập nhật Account người dùng có CCCD: " + Acc.getCCCD() + " trên hệ thống thất bại!!!");
            }
        } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Lỗi hệ thống!!! (AccountsDAO) - UpdateDAO");
        }           
    }
    
    public void UpdateRoleDAO(Accounts Acc){
        String SQL = "UPDATE [dbo].[ACCOUNTS]\n" +
                     "SET [ID_Role] = ? \n" +
                     "WHERE [Account_Username] = ?";
      try {
            Connection con = new DBS().getConnection();
            PreparedStatement stmt = con.prepareStatement(SQL);
 
            stmt.setInt(1, Acc.getRole());            
            stmt.setString(2, Acc.getAccount_Username());
            
            int affectedRows = stmt.executeUpdate();
        
            if (affectedRows > 0) {
                System.out.println("Thông báo hệ thống đã cập nhật Account người dùng có CCCD: " + Acc.getCCCD() + " thành công!");
            } else {
                System.out.println("Cập nhật Account người dùng có CCCD: " + Acc.getCCCD() + " trên hệ thống thất bại!!!");
            }
        } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Lỗi hệ thống!!! (AccountsDAO) - UpdateDAO");
        }           
    }
    
    
}
