package Model;

import java.util.Date;

public class Invoices {
    private Integer ID_Invoice;
    private Integer ID_E_Meter_Details;
    private Integer ID_Level;
    private Date Invoice_Date;
    private Float Total_Price;
    private Integer ID_Staff_Write;
    private Boolean Status;

    public Invoices() {};

    public Invoices(Integer ID_Invoice, Integer ID_E_Meter_Details, Integer ID_Level, Date Invoice_Date, Float Total_Price, Integer ID_Staff_Write, Boolean Status) {
        this.ID_Invoice = ID_Invoice;
        this.ID_E_Meter_Details = ID_E_Meter_Details;
        this.ID_Level = ID_Level;
        this.Invoice_Date = Invoice_Date;
        this.Total_Price = Total_Price;
        this.ID_Staff_Write = ID_Staff_Write;
        this.Status = Status;
    }

    public Integer getID_Invoice() {
        return ID_Invoice;
    }

    public void setID_Invoice(Integer ID_Invoice) {
        this.ID_Invoice = ID_Invoice;
    }

    public Integer getID_E_Meter_Details() {
        return ID_E_Meter_Details;
    }

    public void setID_E_Meter_Details(Integer ID_E_Meter_Details) {
        this.ID_E_Meter_Details = ID_E_Meter_Details;
    }

    public Integer getID_Level() {
        return ID_Level;
    }

    public void setID_Level(Integer ID_Level) {
        this.ID_Level = ID_Level;
    }

    public Date getInvoice_Date() {
        return Invoice_Date;
    }

    public void setInvoice_Date(Date Invoice_Date) {
        this.Invoice_Date = Invoice_Date;
    }

    public Float getTotal_Price() {
        return Total_Price;
    }

    public void setTotal_Price(Float Total_Price) {
        this.Total_Price = Total_Price;
    }

    public Integer getID_Staff_Write() {
        return ID_Staff_Write;
    }

    public void setID_Staff_Write(Integer ID_Staff_Write) {
        this.ID_Staff_Write = ID_Staff_Write;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean Status) {
        this.Status = Status;
    }
    
    
}
