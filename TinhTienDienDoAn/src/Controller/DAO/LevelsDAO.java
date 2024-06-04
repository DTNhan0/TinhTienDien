package Controller.DAO;
import Controller.DBS;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.Levels;

public class LevelsDAO {
    private List<Levels> ListLevels = new ArrayList<>();

    public List<Levels> getAll(){
        ListLevels.clear();
        String SQL = "SELECT * FROM [dbo].[LEVELS]";
        try{
            Connection con = new DBS().getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next()){
                  Levels levels = new Levels();
                  levels.setID_Level(rs.getInt("ID_LEVEL"));
                  levels.setMinimum(rs.getInt("Minimum"));
                  levels.setMaximum(rs.getInt("Maximum"));                 
                  levels.setValue(rs.getFloat("Value"));
                  
                  ListLevels.add(levels);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return ListLevels;
    }     
}
