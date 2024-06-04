package Component.DSCongToDienComponent;

import View.AdminView.DSCongToDienView.DSCongToDienMainView;
import View.AdminView.MainAdminView;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author RAVEN
 */
public class TableActionCellEditor extends DefaultCellEditor {
    
    private TableActionEvent event;
    private MainAdminView mainAdminView;
    private DSCongToDienMainView dSCongToDienMainView;
    
    public TableActionCellEditor(TableActionEvent event, MainAdminView mainadminView, DSCongToDienMainView dsctdmv) {
        super(new JCheckBox());
        this.event = event;
        this.mainAdminView = mainadminView;
        this.dSCongToDienMainView = dsctdmv;
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int row, int column) {
        PanelActionDSCongToDien action = new PanelActionDSCongToDien();
        action.initEvent(event, row, mainAdminView, dSCongToDienMainView);
        action.setBackground(jtable.getSelectionBackground());
        return action;
    }
}
