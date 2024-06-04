package Model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Customers extends Accounts{
    private List<E_Meters> ListE_Meter = new  ArrayList<>();
    private Integer ID_Customer;

    public Customers(){};

    public Customers(Integer ID_Customer, String Account_Username, String Account_Password, int Privilege, boolean Status, String CCCD, String Firstname, String Lastname, String MiddleName, String Address, String Phone, Date DOB, boolean Sex) {
        super(Account_Username, Account_Password, Privilege, Status, CCCD, Firstname, Lastname, MiddleName, Address, Phone, DOB, Sex);
        this.ID_Customer = ID_Customer;
    }
    
    public List<E_Meters> getListE_Meter() {
        return ListE_Meter;
    }

    public void setListE_Meter(List<E_Meters> ListE_Meter) {
        this.ListE_Meter = ListE_Meter;
    }
    
    public int getID_Customer() {
        return ID_Customer;
    }

    public void setID_Customer(Integer ID_Customer) {
        this.ID_Customer = ID_Customer;
    }
    
}
