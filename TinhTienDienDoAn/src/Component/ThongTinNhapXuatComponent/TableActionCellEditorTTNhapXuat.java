package Component.ThongTinNhapXuatComponent;

import View.AdminView.MainAdminView;
import View.AdminView.ThongTinNhapXuatView.ThongTinNhapXuatMainView;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableActionCellEditorTTNhapXuat extends DefaultCellEditor {
    
    private TableActionEventTTNhapXuat event;
    private MainAdminView mainAdminView;
    private ThongTinNhapXuatMainView thongTinNhapXuatMainView;
    
    public TableActionCellEditorTTNhapXuat(TableActionEventTTNhapXuat event, MainAdminView mainadminView, ThongTinNhapXuatMainView ttnxmv) {
        super(new JCheckBox());
        this.event = event;
        this.mainAdminView = mainadminView;
        this.thongTinNhapXuatMainView = ttnxmv;
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int row, int column) {
        PanelActionTTNhapXuat action = new PanelActionTTNhapXuat();
        action.initEvent(event, row, mainAdminView, thongTinNhapXuatMainView);
        action.setBackground(jtable.getSelectionBackground());
        return action;
    }
}
