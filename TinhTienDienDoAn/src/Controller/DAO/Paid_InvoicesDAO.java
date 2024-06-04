package Controller.DAO;
import Controller.DBS;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.Paid_Invoices;

public class Paid_InvoicesDAO {
    private List<Paid_Invoices> ListPaid_Invoices = new ArrayList<>();

    public List<Paid_Invoices> getAll(){
        ListPaid_Invoices.clear();
        String SQL = "SELECT * FROM [dbo].[PAID_INVOICES]";
        try{
            Connection con = new DBS().getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next()){
                  Paid_Invoices paid_Invoices = new Paid_Invoices();
                  paid_Invoices.setID_Paid_Invoices(rs.getInt("ID"));
                  paid_Invoices.setID_Invoice(rs.getInt("ID_Invoice"));
                  paid_Invoices.setDate_Paid(rs.getDate("Date_Paid"));                 
                  paid_Invoices.setInvoice_Method(rs.getString("Invoice_Method"));
                  
                  ListPaid_Invoices.add(paid_Invoices);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return ListPaid_Invoices;
    }     
}
