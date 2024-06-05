package View.AdminView.ThongKeView;

import Controller.ThongKeController.DSThongKe;
import LayMotSoUIdepTaiDay.Chart.Chart;
import View.AdminView.TrangChuView.*;
import LayMotSoUIdepTaiDay.Chart.ModelChart;
import Model.Invoices;
import View.AdminView.MainAdminView;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class ThongKeMainView extends javax.swing.JPanel {
    private MainAdminView MainAdminview;
    private List <Invoices> invoices;
    private int Nam;
    public ThongKeMainView(MainAdminView mainAdminView) {
        initComponents();
        this.MainAdminview = mainAdminView;
        this.setSize(MainAdminview.getMainPanel().getSize());   
        for(String str : DSThongKe.LayCacNamTonTai()){
            TheoNamCb.addItem(str);
        } 
    }

    public void XuLyChart(int nam){
        BarChart1.clear();
        BarChart2.clear();
        List <Float> tongtienDien  = new ArrayList<>();
        List <Float> tongKwhs = new ArrayList<>();
        tongtienDien = DSThongKe.TongTienDien(nam);
        tongKwhs = DSThongKe.TongKwh(nam);
        
        BarChart1.addLegend("Tổng số tiền", new Color(12, 84, 175), new Color(0, 108, 247));
        BarChart1.addData(new ModelChart("Tháng 1", new double[]{tongtienDien.get(0)}));
        BarChart1.addData(new ModelChart("Tháng 2", new double[]{tongtienDien.get(1)}));
        BarChart1.addData(new ModelChart("Tháng 3", new double[]{tongtienDien.get(2)}));
        BarChart1.addData(new ModelChart("Tháng 4", new double[]{tongtienDien.get(3)}));
        BarChart1.addData(new ModelChart("Tháng 5", new double[]{tongtienDien.get(4)}));
        BarChart1.addData(new ModelChart("Tháng 6", new double[]{tongtienDien.get(5)}));
        BarChart1.addData(new ModelChart("Tháng 7", new double[]{tongtienDien.get(6)}));
        BarChart1.addData(new ModelChart("Tháng 8", new double[]{tongtienDien.get(7)}));
        BarChart1.addData(new ModelChart("Tháng 9", new double[]{tongtienDien.get(8)}));
        BarChart1.addData(new ModelChart("Tháng 10", new double[]{tongtienDien.get(9)}));
        BarChart1.addData(new ModelChart("Tháng 11", new double[]{tongtienDien.get(10)}));
        BarChart1.addData(new ModelChart("Tháng 12", new double[]{tongtienDien.get(11)}));
        BarChart1.start();

        BarChart2.addLegend("Số Kwh", new Color(54, 4, 143), new Color(104, 49, 200));
        BarChart2.addData(new ModelChart("Tháng 1", new double[]{tongKwhs.get(0)}));
        BarChart2.addData(new ModelChart("Tháng 2", new double[]{tongKwhs.get(1)}));
        BarChart2.addData(new ModelChart("Tháng 3", new double[]{tongKwhs.get(2)}));
        BarChart2.addData(new ModelChart("Tháng 4", new double[]{tongKwhs.get(3)}));
        BarChart2.addData(new ModelChart("Tháng 5", new double[]{tongKwhs.get(4)}));
        BarChart2.addData(new ModelChart("Tháng 6", new double[]{tongKwhs.get(5)}));
        BarChart2.addData(new ModelChart("Tháng 7", new double[]{tongKwhs.get(6)}));
        BarChart2.addData(new ModelChart("Tháng 8", new double[]{tongKwhs.get(7)}));
        BarChart2.addData(new ModelChart("Tháng 9", new double[]{tongKwhs.get(8)}));
        BarChart2.addData(new ModelChart("Tháng 10", new double[]{tongKwhs.get(9)}));
        BarChart2.addData(new ModelChart("Tháng 11", new double[]{tongKwhs.get(10)}));
        BarChart2.addData(new ModelChart("Tháng 12", new double[]{tongKwhs.get(11)}));
        BarChart2.start();        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BarChart1 = new LayMotSoUIdepTaiDay.Chart.Chart();
        TheoNamCb = new LayMotSoUIdepTaiDay.ComboboxThuong();
        BarChart2 = new LayMotSoUIdepTaiDay.Chart.Chart();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        TheoNamCb.setSelectedItem(null
        );
        TheoNamCb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TheoNamCb.setLabeText("(Theo năm)");
        TheoNamCb.setLineColor(new java.awt.Color(0, 153, 255));
        TheoNamCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TheoNamCbActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Tổng tiền điện theo tháng/năm");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Tổng Số Kwh theo tháng/năm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(TheoNamCb, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BarChart1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BarChart2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(125, 125, 125))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TheoNamCb, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BarChart1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BarChart2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TheoNamCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TheoNamCbActionPerformed
        String selected = (String) TheoNamCb.getSelectedItem();
        Nam = Integer.parseInt(selected);
        XuLyChart(Nam);        
    }//GEN-LAST:event_TheoNamCbActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LayMotSoUIdepTaiDay.Chart.Chart BarChart1;
    private LayMotSoUIdepTaiDay.Chart.Chart BarChart2;
    private LayMotSoUIdepTaiDay.ComboboxThuong TheoNamCb;
    private LayMotSoUIdepTaiDay.ComboboxThuong TimKiemCb;
    private LayMotSoUIdepTaiDay.ComboboxThuong TimKiemCb1;
    private LayMotSoUIdepTaiDay.ComboboxThuong TimKiemCb2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
