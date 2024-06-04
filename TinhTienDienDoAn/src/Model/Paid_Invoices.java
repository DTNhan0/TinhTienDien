package Model;

import java.util.Date;

public class Paid_Invoices {
    private Integer ID_Paid_Invoices;
    private Integer ID_Invoice;
    private Date Date_Paid;
    private String Invoice_Method;

    public Paid_Invoices() {}

    public Paid_Invoices(Integer ID_Paid_Invoices, Integer ID_Invoice, Date Date_Paid, String Invoice_Method) {
        this.ID_Paid_Invoices = ID_Paid_Invoices;
        this.ID_Invoice = ID_Invoice;
        this.Date_Paid = Date_Paid;
        this.Invoice_Method = Invoice_Method;
    }

    public Integer getID_Paid_Invoices() {
        return ID_Paid_Invoices;
    }

    public void setID_Paid_Invoices(Integer ID_Paid_Invoices) {
        this.ID_Paid_Invoices = ID_Paid_Invoices;
    }

    public Integer getID_Invoice() {
        return ID_Invoice;
    }

    public void setID_Invoice(Integer ID_Invoice) {
        this.ID_Invoice = ID_Invoice;
    }

    public Date getDate_Paid() {
        return Date_Paid;
    }

    public void setDate_Paid(Date Date_Paid) {
        this.Date_Paid = Date_Paid;
    }

    public String getInvoice_Method() {
        return Invoice_Method;
    }

    public void setInvoice_Method(String Invoice_Method) {
        this.Invoice_Method = Invoice_Method;
    }


            
}
