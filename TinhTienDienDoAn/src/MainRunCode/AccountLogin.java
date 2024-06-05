package MainRunCode;

import Model.Customers;
import Model.Staffs;


public class AccountLogin {
    public static Customers CustomersLogin;
    public static Staffs StaffsLogin;

    public static Customers getCustomersLogin() {
        return CustomersLogin;
    }

    public static void setCustomersLogin(Customers CustomersLogin) {
        AccountLogin.CustomersLogin = CustomersLogin;
    }

    public static Staffs getStaffsLogin() {
        return StaffsLogin;
    }

    public static void setStaffsLogin(Staffs StaffsLogin) {
        AccountLogin.StaffsLogin = StaffsLogin;
    }

    public AccountLogin(){
        this.CustomersLogin = new Customers();
        this.StaffsLogin = new Staffs();
    }
}
