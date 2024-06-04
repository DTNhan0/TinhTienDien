package Controller.DAO;

import Controller.DBS;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.Type_Livings;

public class Type_LivingsDAO {
    private List<Type_Livings> ListType_Livings = new ArrayList<>();

    public List<Type_Livings> getAll(){
        ListType_Livings.clear();
        String SQL = "SELECT * FROM [dbo].[TYPE_LIVINGS]";
        try{
            Connection con = new DBS().getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next()){
                  Type_Livings type_Livings = new Type_Livings();
                  type_Livings.setID_Type_Living(rs.getInt("ID_TYPE_LIVING"));
                  type_Livings.setDetails(rs.getString("Details"));
                  type_Livings.setTax(rs.getFloat("Tax"));                 
                  
                  ListType_Livings.add(type_Livings);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return ListType_Livings;
    }    
}
