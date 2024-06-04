package LayMotSoUIdepTaiDay;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.Icon;
import javax.swing.JLabel;

public class PanelTrangThai extends javax.swing.JPanel {
    
    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    private Color color1;
    private Color color2;

    public PanelTrangThai() {
        initComponents();
        this.setOpaque(false);

        //Chỉnh màu ở đây, màu 1 là nền, màu hai là hình tròn
        color1 = new Color(204, 153, 255);
        color2 = new Color(229, 204, 255);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Label = new javax.swing.JLabel();
        SoLuong = new javax.swing.JLabel();
        Icon = new javax.swing.JLabel();

        Label.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        Label.setForeground(new java.awt.Color(255, 255, 255));
        Label.setText("Số người dùng: ");

        SoLuong.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        SoLuong.setForeground(new java.awt.Color(255, 255, 255));
        SoLuong.setText("Null");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Icon)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SoLuong)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(Icon)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label)
                    .addComponent(SoLuong))
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.setColor(new Color(255, 255, 255, 50));
        g2.fillOval(getWidth() - (getHeight() / 2), 10, getHeight(), getHeight());
        g2.fillOval(getWidth() - (getHeight() / 2) - 20, getHeight() / 2 + 20, getHeight(), getHeight());
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Icon;
    private javax.swing.JLabel Label;
    private javax.swing.JLabel SoLuong;
    // End of variables declaration//GEN-END:variables

    public JLabel getIcon() {
        return Icon;
    }

    public void setIcon(Icon icon) {
        this.Icon.setIcon(icon);
    }

    public JLabel getLabel() {
        return Label;
    }

    public void setLabel(String text) {
        this.Label.setText(text);
    }

    public JLabel getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(String SoLuong) {
        this.SoLuong.setText(SoLuong);
    }


}
