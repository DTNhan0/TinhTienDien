package Controller.DAO;

import Model.Customers;
import Controller.DBS;
import Model.Accounts;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CustomerDAO {
    private List<Customers> ListCustomers = new ArrayList<Customers>();

    public List<Customers> getAll() throws Exception{
        ListCustomers.clear();
        String SQL = "SELECT CS.ID, PS.CCCD, PS.First_name, PS.Middle_name, PS.Last_name, PS.DOB, PS.Address, PS.Sex, PS.Phone, ACC.Account_Username, ACC.Account_Password\n" +
                     "FROM [dbo].[CUSTOMERS] AS CS\n" +
                     "JOIN [dbo].[ACCOUNTS] AS ACC\n" +
                     "ON [Account_Customer] = [Account_Username]\n" +
                     "JOIN [dbo].[PERSONAL_INFOS] AS PS\n" +
                     "ON ACC.CCCD = PS.CCCD\n" +
                     "WHERE [Status] = 1";
        try(
            Connection con = new DBS().getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
        ){
            while(rs.next()){
                  Customers customers = new Customers();
                  
                  customers.setCCCD(rs.getString("CCCD"));
                  customers.setFirstname(rs.getString("First_name"));
                  customers.setLastname(rs.getString("Last_name"));
                  customers.setMiddleName(rs.getString("Middle_name")); 
                  customers.setDOB(rs.getDate("DOB"));
                  customers.setAddress(rs.getString("Address"));
                  customers.setPhone(rs.getString("Phone"));
                  customers.setSex(rs.getBoolean("Sex"));
                  customers.setID_Customer(rs.getInt("ID"));
                  
                  customers.setAccount_Username(rs.getString("Account_Username"));
                  customers.setAccount_Password(rs.getString("Account_Password"));
                  
                  ListCustomers.add(customers);
            }
        }
        return ListCustomers;
    }    
    
    public void AddDAO(Accounts accounts) {
        String SQL = "INSERT INTO [dbo].[CUSTOMERS] (Account_Customer) VALUES (?)";
        try {
            Connection con = new DBS().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
        
            ps.setString(1, accounts.getAccount_Username());
        
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Đã thêm người dùng vào hệ thống!!!");
            } else {
                System.out.println("Lỗi không thể thêm người dùng vào hệ thống!!!");
            }
        
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Lỗi hệ thống!!! (CustomerDAO) - AddDAO");
        }
    }    
    
    public void DeleteDAO(Accounts accounts) {
        String SQL = "DELETE [dbo].[CUSTOMERS]\n" +
                     "WHERE [Account_Customer] = '?'";
        try {
            Connection con = new DBS().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
        
            ps.setString(1, accounts.getAccount_Username());
        
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Đã xóa chủ hộ trong hệ thống!!!");
            } else {
                System.out.println("Lỗi không thể xóa chủ hộ trong hệ thống!!!");
            }
        
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Lỗi hệ thống!!! (CustomerDAO) - DeleteDAO");
        }
    }
         
}
