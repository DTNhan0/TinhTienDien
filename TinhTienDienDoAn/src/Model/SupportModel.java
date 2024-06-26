package Model;

public class SupportModel {
    private Integer ID_Staff_Write;
    private Integer ID_E_Meter_Detail;
    private Integer ID_Customer;
    private Integer ID_Invoices;
    
    public SupportModel() {
    }

    public SupportModel(Integer ID_Staff_Write, Integer ID_E_Meter_Detail) {
        this.ID_Staff_Write = ID_Staff_Write;
        this.ID_E_Meter_Detail = ID_E_Meter_Detail;
    }

    public Integer getID_Staff_Write() {
        return ID_Staff_Write;
    }

    public void setID_Staff_Write(Integer ID_Staff_Write) {
        this.ID_Staff_Write = ID_Staff_Write;
    }

    public Integer getID_E_Meter_Detail() {
        return ID_E_Meter_Detail;
    }

    public void setID_E_Meter_Detail(Integer ID_E_Meter_Detail) {
        this.ID_E_Meter_Detail = ID_E_Meter_Detail;
    }

    public Integer getID_Customer() {
        return ID_Customer;
    }

    public void setID_Customer(Integer ID_Customer) {
        this.ID_Customer = ID_Customer;
    }

    public Integer getID_Invoices() {
        return ID_Invoices;
    }

    public void setID_Invoices(Integer ID_Invoices) {
        this.ID_Invoices = ID_Invoices;
    }


}
