package Model;

import java.util.List;

public interface Working_Assignment {
    List<Customers> getListCustomers();
    void setListCustomers(List<Customers> lstCustomers);

    List<E_Meters> getListE_Meters();
    void setListE_Meters(List<E_Meters> lstE_Meters);
}
