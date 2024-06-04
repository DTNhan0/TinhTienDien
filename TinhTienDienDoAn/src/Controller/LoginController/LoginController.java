
package Controller.LoginController;

import Controller.DAO.LoginDAO;

public class LoginController {
    public static  String usernameLogin;
    public String login(String userName, String passWord) throws Exception{
        usernameLogin=new LoginDAO().Login(userName, passWord);
        return usernameLogin;
    }
    public void UpdateLogin(String CCCD,String userName ,String passWord) throws Exception{
        new LoginDAO().UpdateLogin(CCCD, userName, passWord);
    }
    public int getPrivilege(String userName, String passWord) throws Exception{
        return new LoginDAO().getPrivilege(userName, passWord);
    }
    public boolean checkUsername(String cccd,String userName) throws Exception{
        return new LoginDAO().CheckUsername(cccd, userName);
    }
    
}
