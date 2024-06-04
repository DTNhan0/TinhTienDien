package View.AdminView.TrangChuView;

import LayMotSoUIdepTaiDay.Chart.ModelChart;
import View.AdminView.MainAdminView;
import java.awt.Color;

public class TrangChuMainView extends javax.swing.JPanel {
    private MainAdminView MainAdminview;
    public TrangChuMainView(MainAdminView mainAdminView) {
        initComponents();
        this.MainAdminview = mainAdminView;
        this.setSize(MainAdminview.getMainPanel().getSize());        
        XuLyChart();
    }

    public void XuLyChart(){
        BarChart1.addLegend("Income", new Color(12, 84, 175), new Color(0, 108, 247));
        BarChart1.addLegend("Expense", new Color(54, 4, 143), new Color(104, 49, 200));
        BarChart1.addLegend("Profit", new Color(5, 125, 0), new Color(95, 209, 69));
        BarChart1.addLegend("Cost", new Color(186, 37, 37), new Color(241, 100, 120));
        BarChart1.addData(new ModelChart("January", new double[]{500, 200, 80, 89}));
        BarChart1.addData(new ModelChart("February", new double[]{600, 750, 90, 150}));
        BarChart1.addData(new ModelChart("March", new double[]{200, 350, 460, 900}));
        BarChart1.addData(new ModelChart("April", new double[]{480, 150, 750, 700}));
        BarChart1.addData(new ModelChart("May", new double[]{350, 540, 300, 150}));
        BarChart1.addData(new ModelChart("June", new double[]{190, 280, 81, 200}));
        BarChart1.start();

        BarChart2.addLegend("Income", new Color(12, 84, 175), new Color(0, 108, 247));
        BarChart2.addLegend("Expense", new Color(54, 4, 143), new Color(104, 49, 200));
        BarChart2.addLegend("Profit", new Color(5, 125, 0), new Color(95, 209, 69));
        BarChart2.addLegend("Cost", new Color(186, 37, 37), new Color(241, 100, 120));
        BarChart2.addData(new ModelChart("January", new double[]{500, 200, 80, 89}));
        BarChart2.addData(new ModelChart("February", new double[]{600, 750, 90, 150}));
        BarChart2.addData(new ModelChart("March", new double[]{200, 350, 460, 900}));
        BarChart2.addData(new ModelChart("April", new double[]{480, 150, 750, 700}));
        BarChart2.addData(new ModelChart("May", new double[]{350, 540, 300, 150}));
        BarChart2.addData(new ModelChart("June", new double[]{190, 280, 81, 200}));
        BarChart2.start();
        
        LineChart.addLegend("Income", new Color(12, 84, 175), new Color(0, 108, 247));
        LineChart.addLegend("Expense", new Color(54, 4, 143), new Color(104, 49, 200));
        LineChart.addLegend("Profit", new Color(5, 125, 0), new Color(95, 209, 69));
        LineChart.addLegend("Cost", new Color(186, 37, 37), new Color(241, 100, 120));
        LineChart.addData(new ModelChart("January", new double[]{500, 200, 80, 89}));
        LineChart.addData(new ModelChart("February", new double[]{600, 750, 90, 150}));
        LineChart.addData(new ModelChart("March", new double[]{200, 350, 460, 900}));
        LineChart.addData(new ModelChart("April", new double[]{480, 150, 750, 700}));
        LineChart.addData(new ModelChart("May", new double[]{350, 540, 300, 150}));
        LineChart.addData(new ModelChart("June", new double[]{190, 280, 81, 200}));
        LineChart.start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BarChart1 = new LayMotSoUIdepTaiDay.Chart.Chart();
        BarChart2 = new LayMotSoUIdepTaiDay.Chart.Chart();
        LineChart = new LayMotSoUIdepTaiDay.Chart.LineChart();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BarChart1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BarChart2, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LineChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BarChart2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BarChart1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LineChart, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LayMotSoUIdepTaiDay.Chart.Chart BarChart1;
    private LayMotSoUIdepTaiDay.Chart.Chart BarChart2;
    private LayMotSoUIdepTaiDay.Chart.LineChart LineChart;
    // End of variables declaration//GEN-END:variables
}
