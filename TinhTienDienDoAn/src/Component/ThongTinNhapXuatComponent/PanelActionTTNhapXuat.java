package Component.ThongTinNhapXuatComponent;

import View.AdminView.MainAdminView;
import View.AdminView.ThongTinNhapXuatView.ThongTinNhapXuatMainView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class PanelActionTTNhapXuat extends javax.swing.JPanel {
    public PanelActionTTNhapXuat() {
        initComponents();
    }

    public void initEvent(TableActionEventTTNhapXuat event, int row, MainAdminView mainAdminView, ThongTinNhapXuatMainView ttnxmv) {
        buttonThuong1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
                event.onThongTinNhapXuat(row, mainAdminView, ttnxmv);
            }
        });
    }
    
    public void setPanelText(String Text){
        buttonThuong1.setText(Text);
    }
 
    public void setPanelIcon(String URL){
        ImageIcon imageView = new ImageIcon(URL);
        buttonThuong1.setIcon(imageView);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonThuong1 = new LayMotSoUIdepTaiDay.ButtonThuong();

        buttonThuong1.setBackground(new java.awt.Color(255, 255, 255));
        buttonThuong1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/menu.png"))); // NOI18N
        buttonThuong1.setText("Bảng danh sách");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonThuong1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonThuong1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LayMotSoUIdepTaiDay.ButtonThuong buttonThuong1;
    // End of variables declaration//GEN-END:variables
}
