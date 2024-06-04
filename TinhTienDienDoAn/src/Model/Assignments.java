package Model;

public class Assignments {
    private Integer ID_Assignment;
    private Integer ID_Customer;
    private Integer ID_Staff_Write;

    public Assignments() {};

    public Assignments(Integer ID_Assignment, Integer ID_Customer, Integer ID_Staff_Write) {
        this.ID_Assignment = ID_Assignment;
        this.ID_Customer = ID_Customer;
        this.ID_Staff_Write = ID_Staff_Write;
    }

    public Integer getID_Assignment() {
        return ID_Assignment;
    }

    public void setID_Assignment(Integer ID_Assignment) {
        this.ID_Assignment = ID_Assignment;
    }

    public Integer getID_Customer() {
        return ID_Customer;
    }

    public void setID_Customer(Integer ID_Customer) {
        this.ID_Customer = ID_Customer;
    }

    public Integer getID_Staff_Write() {
        return ID_Staff_Write;
    }

    public void setID_Staff_Write(Integer ID_Staff_Write) {
        this.ID_Staff_Write = ID_Staff_Write;
    }
    
    
}
