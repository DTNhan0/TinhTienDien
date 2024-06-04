
package Controller.DAO;

import Controller.DBS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginDAO {
    
    public String Login(String userName,String passWord) throws Exception{
        Connection cnn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean isValid = false;
        String user="";
        try {
            cnn = DBS.getConnection();
            String SQL="SELECT TOP 1 A.Account_Username FROM ACCOUNTS A WHERE A.Account_Username=? AND A.Account_Password=? ";
            preparedStatement = cnn.prepareStatement(SQL);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, passWord);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                user=resultSet.getString("Account_Username");
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        
        } 
        return user;
    }
    
    public int getPrivilege(String userName, String passWord) throws Exception{
        Connection cnn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int privilege=0;
        try{
            cnn = DBS.getConnection();
            String SQL="SELECT TOP 1 A.ID_Role FROM ACCOUNTS A WHERE A.Account_Username=? AND A.Account_Password=? ";
            preparedStatement = cnn.prepareStatement(SQL);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, passWord);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                privilege=resultSet.getInt("ID_Role");
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return privilege;
    }
    
    public void UpdateLogin(String CCCD,String userName,String passWord) throws Exception{
        Connection cnn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            cnn=DBS.getConnection();
            String SQL="UPDATE ACCOUNTS\n" +
                        "SET Account_Password =?\n" +
                        "WHERE CCCD = ? AND Account_Username = ?";
            preparedStatement=cnn.prepareStatement(SQL);
            preparedStatement.setString(1, passWord);
            preparedStatement.setString(2, CCCD);
            preparedStatement.setString(3, userName);
            preparedStatement.executeUpdate();

        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public boolean CheckUsername(String cccd,String username) throws Exception{
        Connection cnn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String tmp="";
        try{
            cnn=DBS.getConnection();
            String SQL="SELECT Account_Username FROM ACCOUNTS WHERE CCCD=?";
            preparedStatement=cnn.prepareStatement(SQL);
            preparedStatement.setString(1,cccd);
            ResultSet re=preparedStatement.executeQuery();
            while(re.next()){
                tmp=re.getString("Account_Username");
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return tmp.equals(username);
    }
}
