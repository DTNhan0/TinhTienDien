package Controller.DAO;
import Controller.DBS;
import Model.SupportModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class SupportDAO {
    private List<SupportModel> ListSupportModels = new ArrayList<SupportModel>();

    public List<SupportModel> getAll() throws Exception{
        ListSupportModels.clear();
        String SQL = "SELECT ST.ID AS ID_Staff_Write, ED.ID AS ID_E_Meter_Detail\n" +
                     "FROM [dbo].[E_METER_DETAILS] AS ED\n" +
                     "JOIN [dbo].[E_METERS] AS EM\n" +
                     "ON ED.ID_E_Meter = EM.ID_E_METER\n" +
                     "JOIN [dbo].[ASSIGNMENTS] AS A\n" +
                     "ON EM.ID_Assignment = A.ID\n" +
                     "JOIN [dbo].[STAFFS] AS ST\n" +
                     "ON A.ID_Staff_Write = ST.ID";
        
        try(
            Connection con = new DBS().getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
        ){
            while(rs.next()){
                  SupportModel supportModel = new SupportModel();
                  
                  supportModel.setID_Staff_Write(rs.getInt("ID_Staff_Write"));
                  supportModel.setID_E_Meter_Detail(rs.getInt("ID_E_Meter_Detail"));
                  
                  ListSupportModels.add(supportModel);
            }
        }
        return ListSupportModels;
    }    
}
