package Model;

import java.util.Date;

public class E_Meter_Details {
    private Integer ID_E_Meter_Detail;
    private String ID_E_Meter;
    private Integer Current_Num;
    private Date Creating_Date;
    private Integer ID_Staff_Input;

    public E_Meter_Details() {};

    public E_Meter_Details(Integer ID_E_Meter_Detail, String ID_E_Meter, Integer Current_Num, Date Creating_Date, Integer ID_Staff_Input) {
        this.ID_E_Meter_Detail = ID_E_Meter_Detail;
        this.ID_E_Meter = ID_E_Meter;
        this.Current_Num = Current_Num;
        this.Creating_Date = Creating_Date;
        this.ID_Staff_Input = ID_Staff_Input;
    }

    public Integer getID_E_Meter_Detail() {
        return ID_E_Meter_Detail;
    }

    public void setID_E_Meter_Detail(Integer ID_E_Meter_Detail) {
        this.ID_E_Meter_Detail = ID_E_Meter_Detail;
    }

    public String getID_E_Meter() {
        return ID_E_Meter;
    }

    public void setID_E_Meter(String ID_E_Meter) {
        this.ID_E_Meter = ID_E_Meter;
    }

    public Integer getCurrent_Num() {
        return Current_Num;
    }

    public void setCurrent_Num(Integer Current_Num) {
        this.Current_Num = Current_Num;
    }

    public Date getCreating_Date() {
        return Creating_Date;
    }

    public void setCreating_Date(Date Creating_Date) {
        this.Creating_Date = Creating_Date;
    }

    public Integer getID_Staff_Input() {
        return ID_Staff_Input;
    }

    public void setID_Staff_Input(Integer ID_Staff_Input) {
        this.ID_Staff_Input = ID_Staff_Input;
    }
    
    
}
