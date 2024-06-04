package Controller.DAO;
import Controller.DBS;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.Invoices;

public class InvoicesDAO {
    private List<Invoices> ListInvoices = new ArrayList<Invoices>();

    public List<Invoices> getAll() throws Exception{
        ListInvoices.clear();
        String SQL = "SELECT * FROM [dbo].[INVOICES]";
        
        try(
            Connection con = new DBS().getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
        ){
            while(rs.next()){
                  Invoices invoices = new Invoices();
                  
                  invoices.setID_Invoice(rs.getInt("ID"));
                  invoices.setID_E_Meter_Details(rs.getInt("ID_E_Meter_Details"));
                  invoices.setID_Level(rs.getInt("ID_Level"));
                  invoices.setInvoice_Date(rs.getDate("Invoice_Date"));
                  invoices.setTotal_Price(rs.getFloat("Total_Price"));
                  invoices.setID_Staff_Write(rs.getInt("ID_Staff_Write"));
                  invoices.setStatus(rs.getBoolean("Status"));
                  
                  ListInvoices.add(invoices);
            }
        }
        return ListInvoices;
    }    
    
    public void AddDAO(Invoices invoices) {
        String SQL = "INSERT INTO [dbo].[INVOICES] (ID_E_Meter_Details, ID_Level, Invoice_Date, Total_Price, ID_Staff_Write, Status) VALUES (?, ?, ?, ?, ?, ?)";
        
        try {
            Connection con = new DBS().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);

            ps.setInt(1, invoices.getID_E_Meter_Details());
            ps.setInt(2, invoices.getID_Level());
        
            // Chuyển đổi java.util.Date sang java.sql.Date
            Date sqlDate = new java.sql.Date(invoices.getInvoice_Date().getTime());
            ps.setDate(3, sqlDate);
        
            ps.setFloat(4, invoices.getTotal_Price());
            ps.setInt(5, invoices.getID_Staff_Write());
            ps.setBoolean(6, invoices.getStatus());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Đã thêm thông tin hóa đơn vào hệ thống!!!");
            } else {
                System.out.println("Lỗi không thể thêm thông tin hóa đơn vào hệ thống!!!");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Lỗi hệ thống!!! (InvoicesDAO) - AddDAO");
        }
    }
    
    
    public void DeleteDAO(Invoices invoices) {
        String SQL = "DELETE [dbo].[INVOICES]\n" +
                     "WHERE [ID] = ?";
        try {
            Connection con = new DBS().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
        
            ps.setInt(1, invoices.getID_Invoice());
        
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Đã xóa thông tin hóa đơn trong hệ thống!!!");
            } else {
                System.out.println("Lỗi không thể xóa thông tin hóa đơn trong hệ thống!!!");
            }
        
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Lỗi hệ thống!!! (InvoicesDAO) - DeleteDAO");
        }
    }    
    
    public void UpdateDAO(Invoices invoices) {
        String SQL = "UPDATE [dbo].[INVOICES] " +
                     "SET [Invoice_Date] = ?, \n" +
                     "    [ID_Staff_Write] = ? \n" + 
                     "WHERE [ID] = ?";
        try {
            Connection con = new DBS().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);

            Date sqlDate = new java.sql.Date(invoices.getInvoice_Date().getTime());
            ps.setDate(1, sqlDate);    

            ps.setInt(2, invoices.getID_Staff_Write());
            
            ps.setInt(3, invoices.getID_Invoice());
        
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Đã cập nhật thông tin hóa đơn trong hệ thống!!!");
            } else {
                System.out.println("Lỗi không thể cập nhật thông tin hóa đơn trong hệ thống!!!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Lỗi hệ thống!!! (InvoicesDAO) - UpdateDAO");
        }
    }    
}
