package LayMotSoUIdepTaiDay;

import Component.TableHeader;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class BangDanhSach extends JTable{
    public BangDanhSach(){
        this.setShowHorizontalLines(true);
        this.setGridColor(new Color(230, 230, 230));
        this.setRowHeight(40);
        this.getTableHeader().setReorderingAllowed(false);
        this.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                TableHeader header = new TableHeader(o + "");
                if (i1 == 4) {
                    header.setHorizontalAlignment(JLabel.LEFT);
                }
                return header;
            }
        });
    }
}
