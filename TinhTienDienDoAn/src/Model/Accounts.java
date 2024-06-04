package Model;

import java.sql.Date;

public class Accounts extends Personal_Infos{
    private String Account_Username;
    private String Account_Password;
    private Integer ID_Role;
    private Boolean Status;
    
    public Accounts() {}

    public Accounts(String Account_Username, String Account_Password, Integer role_Account, boolean Status, String CCCD, String Firstname, String Lastname, String MiddleName, String Address, String Phone, Date DOB, boolean Sex) {
        super(CCCD, Firstname, Lastname, MiddleName, Address, Phone, DOB, Sex);
        this.Account_Username = Account_Username;
        this.Account_Password = Account_Password;
        this.ID_Role = role_Account;
        this.Status = Status;
    }

    public String getAccount_Username() {
        return Account_Username;
    }

    public void setAccount_Username(String Account_Username) {
        this.Account_Username = Account_Username;
    }

    public String getAccount_Password() {
        return Account_Password;
    }

    public void setAccount_Password(String Account_Password) {
        this.Account_Password = Account_Password;
    }

    public int getRole() {
        return ID_Role;
    }

    public void setRole(Integer role_Account) {
        this.ID_Role = role_Account;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(Boolean Status) {
        this.Status = Status;
    }
}
