package Component.ThongTinGhiDienComponent;

import View.AdminView.MainAdminView;
import View.AdminView.ThongTinGhiDienView.ThongTinGhiDienMainView;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author RAVEN
 */
public class TableActionCellEditorThongTinGhiDien extends DefaultCellEditor {
    
    private TableActionEventThongTinGhiDien event;
    private MainAdminView mainAdminView;
    private ThongTinGhiDienMainView thongTinGhiDienMainView;
    
    public TableActionCellEditorThongTinGhiDien(TableActionEventThongTinGhiDien event, MainAdminView mainadminView, ThongTinGhiDienMainView ttgdmv) {
        super(new JCheckBox());
        this.event = event;
        this.mainAdminView = mainadminView;
        this.thongTinGhiDienMainView = ttgdmv;
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int row, int column) {
        PanelActionThongTinGhiDien action = new PanelActionThongTinGhiDien();
        action.initEvent(event, row, mainAdminView, thongTinGhiDienMainView);
        action.setBackground(jtable.getSelectionBackground());
        return action;
    }
}
