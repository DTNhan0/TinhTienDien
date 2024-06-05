package Component.DSCongToDienCSComponent;

import Component.DSCongToDienComponent.*;
import View.AdminView.DSCongToDienView.DSCongToDienMainView;
import View.AdminView.MainAdminView;
import View.CustomerView.DanhSachCongToDienCSView.DSCongToDienCSView;
import View.CustomerView.MainCustomerView;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author RAVEN
 */
public class TableActionCellEditorCS extends DefaultCellEditor {
    
    private TableActionEventDSCongToCS event;
    private MainCustomerView mainCustomerView;
    private DSCongToDienCSView dSCongToDienCSView;
    
    public TableActionCellEditorCS(TableActionEventDSCongToCS event, MainCustomerView mcv, DSCongToDienCSView dsctdcsv) {
        super(new JCheckBox());
        this.event = event;
        this.mainCustomerView = mcv;
        this.dSCongToDienCSView = dsctdcsv;
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int row, int column) {
        PanelActionDSCongToDienCS action = new PanelActionDSCongToDienCS();
        action.initEvent(event, row, mainCustomerView, dSCongToDienCSView);
        action.setBackground(jtable.getSelectionBackground());
        return action;
    }
}
