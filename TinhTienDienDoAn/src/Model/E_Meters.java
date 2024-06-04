package Model;

import java.util.ArrayList;
import java.util.List;

public class E_Meters {
    private String ID_E_Meter;
    private Integer ID_Assignment;
    private Integer ID_Staff_Input;
    private Integer ID_Type_Living;
    private boolean Is_Business;
    private String Address;
    private boolean Status;
    private List <E_Meter_Details> ListE_Meter_Details = new ArrayList<>();

    public E_Meters() {};

    public E_Meters(String ID_E_METER, Integer Id_Assignment, Integer ID_Staff_Input, Integer ID_Type_Living, boolean Is_Business, String Address, boolean Status) {
        this.ID_E_Meter = ID_E_METER;
        this.ID_Assignment = Id_Assignment;
        this.ID_Staff_Input = ID_Staff_Input;
        this.ID_Type_Living = ID_Type_Living;
        this.Is_Business = Is_Business;
        this.Address = Address;
        this.Status = Status;
    }
    
    public String getID_E_Meter() {
        return ID_E_Meter;
    }

    public void setID_E_Meter(String ID_E_METER) {
        this.ID_E_Meter = ID_E_METER;
    }

    public Integer getID_Assignment() {
        return ID_Assignment;
    }

    public void setID_Assignment(Integer Id_Assignment) {
        this.ID_Assignment = Id_Assignment;
    }

    public Integer getID_Staff_Input() {
        return ID_Staff_Input;
    }

    public void setID_Staff_Input(Integer ID_Staff_Input) {
        this.ID_Staff_Input = ID_Staff_Input;
    }

    public Integer getID_Type_Living() {
        return ID_Type_Living;
    }

    public void setID_Type_Living(Integer ID_Type_Living) {
        this.ID_Type_Living = ID_Type_Living;
    }

    public boolean isIs_Business() {
        return Is_Business;
    }

    public void setIs_Business(boolean Is_Business) {
        this.Is_Business = Is_Business;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public List<E_Meter_Details> getListE_Meter_Details() {
        return ListE_Meter_Details;
    }

    public void setListE_Meter_Details(List<E_Meter_Details> ListE_Meter_Details) {
        this.ListE_Meter_Details = ListE_Meter_Details;
    }
    
    
}
