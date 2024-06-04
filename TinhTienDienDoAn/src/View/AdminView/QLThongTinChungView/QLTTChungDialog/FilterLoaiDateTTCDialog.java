package View.AdminView.QLThongTinChungView.QLTTChungDialog;

import Controller.QLThongTinChungController.DSThongTinChung;
import Model.Personal_Infos;
import View.AdminView.MainAdminView;
import View.AdminView.QLThongTinChungView.QLTTChungMainView;
import javax.swing.JOptionPane;

public class FilterLoaiDateTTCDialog extends javax.swing.JDialog {
    private MainAdminView MainAdminview;
    private QLTTChungMainView QlttChungMainView;
    public  Personal_Infos Ps;
    
    public FilterLoaiDateTTCDialog(MainAdminView mainAdminView, QLTTChungMainView qLTTChungMainView, boolean modal) {
        initComponents();
        this.MainAdminview = mainAdminView;
        this.QlttChungMainView = qLTTChungMainView;
        this.setModalityType(DEFAULT_MODALITY_TYPE.APPLICATION_MODAL);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        NgayCb.setEnabled(false);
        NgayCb.setEditable(false);
        
        ThangCb.setEnabled(false);
        ThangCb.setEditable(false);
        
        NamCb.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        OkBt = new javax.swing.JButton();
        CancelBt = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        NgayCkb = new LayMotSoUIdepTaiDay.CheckBox();
        NamCkb = new LayMotSoUIdepTaiDay.CheckBox();
        jLabel2 = new javax.swing.JLabel();
        ThangCkb = new LayMotSoUIdepTaiDay.CheckBox();
        NgayCb = new LayMotSoUIdepTaiDay.ComboboxCoTheDien();
        ThangCb = new LayMotSoUIdepTaiDay.ComboboxCoTheDien();
        NamCb = new com.toedter.calendar.JYearChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(null);
        setIconImages(null);

        OkBt.setText("Ok");
        OkBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkBtActionPerformed(evt);
            }
        });

        CancelBt.setText("Cancel");
        CancelBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("LỌC THEO NGÀY SINH:");

        NgayCkb.setBackground(new java.awt.Color(0, 0, 0));
        NgayCkb.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        NgayCkb.setForeground(new java.awt.Color(0, 0, 0));
        NgayCkb.setText("Theo ngày");
        NgayCkb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NgayCkbActionPerformed(evt);
            }
        });

        NamCkb.setBackground(new java.awt.Color(0, 0, 0));
        NamCkb.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        NamCkb.setForeground(new java.awt.Color(0, 0, 0));
        NamCkb.setText("Theo năm");
        NamCkb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamCkbActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Chọn loại lọc:");

        ThangCkb.setBackground(new java.awt.Color(0, 0, 0));
        ThangCkb.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        ThangCkb.setForeground(new java.awt.Color(0, 0, 0));
        ThangCkb.setText("Theo tháng");
        ThangCkb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThangCkbActionPerformed(evt);
            }
        });

        NgayCb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        NgayCb.setSelectedItem(null);
        NgayCb.setPrototypeDisplayValue("(Chọn ngày)");

        ThangCb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        ThangCb.setSelectedItem(null);
        ThangCb.setPrototypeDisplayValue("(Chọn ngày)");

        NamCb.setValue(2000);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(NgayCb, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(NgayCkb, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ThangCkb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ThangCb, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NamCkb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NamCb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(OkBt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(CancelBt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(NgayCkb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(NgayCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ThangCkb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NamCkb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ThangCb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NamCb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OkBt)
                    .addComponent(CancelBt))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OkBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkBtActionPerformed
        boolean check = false;
        if(NgayCkb.isSelected()){
            DSThongTinChung.Filter((String)NgayCb.getSelectedItem(), 1, 1, QlttChungMainView.getBangDSTTChung());
            check = true;
        }
        if(ThangCkb.isSelected()){
            DSThongTinChung.Filter((String)ThangCb.getSelectedItem(), 2, 1, QlttChungMainView.getBangDSTTChung());
            check = true;
        }
        if(NamCkb.isSelected()){
            DSThongTinChung.Filter(String.valueOf(NamCb.getYear()), 3, 1, QlttChungMainView.getBangDSTTChung()); 
            check = true;
        }
        if(check)
            JOptionPane.showMessageDialog(this, "Đã lọc bảng theo ngày sinh!!!");              
    }//GEN-LAST:event_OkBtActionPerformed

    private void CancelBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtActionPerformed
        this.dispose();
    }//GEN-LAST:event_CancelBtActionPerformed

    private void NgayCkbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NgayCkbActionPerformed
        if(NgayCkb.isSelected()){
            NgayCb.setEnabled(true);
            NgayCb.setEditable(true);  
        }else{
            NgayCb.setEnabled(false);
            NgayCb.setEditable(false);            
        }
    }//GEN-LAST:event_NgayCkbActionPerformed

    private void ThangCkbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThangCkbActionPerformed
        if(ThangCkb.isSelected()){
            ThangCb.setEnabled(true);
            ThangCb.setEditable(true);  
        }else{
            ThangCb.setEnabled(false);
            ThangCb.setEditable(false);            
        }
    }//GEN-LAST:event_ThangCkbActionPerformed

    private void NamCkbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamCkbActionPerformed
        if(NamCkb.isSelected()){
            NamCb.setEnabled(true);
        }else{
            NamCb.setEnabled(false);       
        }
    }//GEN-LAST:event_NamCkbActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelBt;
    private com.toedter.calendar.JYearChooser NamCb;
    private LayMotSoUIdepTaiDay.CheckBox NamCkb;
    private LayMotSoUIdepTaiDay.ComboboxCoTheDien NgayCb;
    private LayMotSoUIdepTaiDay.CheckBox NgayCkb;
    private javax.swing.JButton OkBt;
    private LayMotSoUIdepTaiDay.ComboboxCoTheDien ThangCb;
    private LayMotSoUIdepTaiDay.CheckBox ThangCkb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
