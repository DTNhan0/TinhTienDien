package Model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Staffs extends Accounts implements Working_Assignment{
    private List<Customers> ListCustomers = new ArrayList<>();
    private List<E_Meters> ListE_Meters = new ArrayList<>();
    private List<E_Meter_Details> ListE_Meter_Details = new ArrayList<>();
    private Integer Role_Staff;
    private Integer ID_Staff;
    
    public Staffs() {}

    public Staffs(Integer Role, Integer ID_Staff, String Account_Username, String Account_Password, int Privilege, boolean Status, String CCCD, String Firstname, String Lastname, String MiddleName, String Address, String Phone, Date DOB, boolean Sex) {
        super(Account_Username, Account_Password, Privilege, Status, CCCD, Firstname, Lastname, MiddleName, Address, Phone, DOB, Sex);
        this.Role_Staff = Role;
        this.ID_Staff = ID_Staff;
    }
    
    public void DeleteCustomer(Customers customers){
        this.ListCustomers.removeIf(customer -> customer.getCCCD().equals(customers.getCCCD()));
    }
 
    public void DeleteE_Meter(E_Meters e_Meter){
        this.ListE_Meters.removeIf(E_Meter -> E_Meter.getID_E_Meter().equals(e_Meter.getID_E_Meter()));
    }
    
    public List<Customers> getListCustomers() {
        return ListCustomers;
    }

    public void setListCustomers(List<Customers> ListCustomers) {
        this.ListCustomers = ListCustomers;
    }

    public List<E_Meters> getListE_Meters() {
        return ListE_Meters;
    }

    public void setListE_Meters(List<E_Meters> ListE_Meters) {
        this.ListE_Meters = ListE_Meters;
    }    
    
    public Integer getRoleStaff() {
        return Role_Staff;
    }

    public void setRoleStaff(Integer role) {
        this.Role_Staff = role;
    }
    
    public int getID_Staff() {
        return ID_Staff;
    }

    public void setID_Staff(Integer ID_Staff) {
        this.ID_Staff = ID_Staff;
    }

    public List<E_Meter_Details> getListE_Meter_Details() {
        return ListE_Meter_Details;
    }

    public void setListE_Meter_Details(List<E_Meter_Details> ListE_Meter_Details) {
        this.ListE_Meter_Details = ListE_Meter_Details;
    }
}
