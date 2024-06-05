package Component.DSCongToDienCSComponent;

import Component.DSCongToDienComponent.*;
import View.AdminView.DSCongToDienView.DSCongToDienMainView;
import View.AdminView.MainAdminView;
import View.CustomerView.DanhSachCongToDienCSView.DSCongToDienCSView;
import View.CustomerView.MainCustomerView;

public interface TableActionEventDSCongToCS {

    public void onDSCongToDienView(int row, MainCustomerView mainCustomerView, DSCongToDienCSView dSCongToDienMainView);
}
