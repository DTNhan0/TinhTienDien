package Component.ThongTinGhiDienComponent;

import View.AdminView.MainAdminView;
import View.AdminView.ThongTinGhiDienView.ThongTinGhiDienMainView;
import View.AdminView.ThongTinGhiDienView.ThongTinGhiDienSubHighView;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableActionCellEditorThongTinGhiDienLow extends DefaultCellEditor {
    
    private TableActionEventThongTinGhiDienLow event;
    private MainAdminView mainAdminView;
    private ThongTinGhiDienSubHighView thongTinGhiDienSubHighView;
    
    public TableActionCellEditorThongTinGhiDienLow(TableActionEventThongTinGhiDienLow event, MainAdminView mainadminView, ThongTinGhiDienSubHighView ttgdshv) {
        super(new JCheckBox());
        this.event = event;
        this.mainAdminView = mainadminView;
        this.thongTinGhiDienSubHighView = ttgdshv;
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int row, int column) {
        PanelActionThongTinGhiDienLow action = new PanelActionThongTinGhiDienLow();
        action.initEvent(event, row, mainAdminView, thongTinGhiDienSubHighView);
        action.setBackground(jtable.getSelectionBackground());
        return action;
    }
}
