package View.AdminView.DSChuHoView.DSChuHoDialog;

import Controller.DSChuHoController.DSChuHo;
import View.AdminView.DSChuHoView.DSChuHoMainView;
import View.AdminView.MainAdminView;
import javax.swing.JOptionPane;

public class SortLoaiStringDSCHDialog extends javax.swing.JDialog {
    private MainAdminView MainAdminview;
    private DSChuHoMainView DsChuHoMainView;
    
    public SortLoaiStringDSCHDialog(MainAdminView mainAdminView, DSChuHoMainView dSChuHoMainView, boolean modal) {
        initComponents();
        this.MainAdminview = mainAdminView;
        this.DsChuHoMainView = dSChuHoMainView;
        this.setModalityType(DEFAULT_MODALITY_TYPE.APPLICATION_MODAL);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoaiTuoiGrp = new javax.swing.ButtonGroup();
        OkBt = new javax.swing.JButton();
        CancelBt = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        AZCkb = new LayMotSoUIdepTaiDay.CheckBox();
        ZACkb = new LayMotSoUIdepTaiDay.CheckBox();
        jLabel2 = new javax.swing.JLabel();

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
        jLabel1.setText("SẮP XẾP THEO CHUỖI:");

        AZCkb.setBackground(new java.awt.Color(0, 0, 0));
        AZCkb.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        LoaiTuoiGrp.add(AZCkb);
        AZCkb.setForeground(new java.awt.Color(0, 0, 0));
        AZCkb.setText("Từ A đến Z (bé đến lớn)");

        ZACkb.setBackground(new java.awt.Color(0, 0, 0));
        ZACkb.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        LoaiTuoiGrp.add(ZACkb);
        ZACkb.setForeground(new java.awt.Color(0, 0, 0));
        ZACkb.setText("Từ Z đến A (lớn đến bé)");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Theo thứ tự:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(AZCkb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(OkBt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(ZACkb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CancelBt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AZCkb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ZACkb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelBt)
                    .addComponent(OkBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OkBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkBtActionPerformed
        if(!AZCkb.isSelected() && !ZACkb.isSelected()){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn loại sắp xếp!!!");             
        }else if(AZCkb.isSelected()){
            SortDialog(1);
            JOptionPane.showMessageDialog(this, "Đã sắp xếp chuỗi theo thứ tự A-Z"); 
            this.dispose();
        }else{
            SortDialog(2);
            JOptionPane.showMessageDialog(this, "Đã sắp xếp chuỗi theo thứ tự Z-A"); 
            this.dispose();
        }
    }//GEN-LAST:event_OkBtActionPerformed

    private void CancelBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtActionPerformed
        this.dispose();
    }//GEN-LAST:event_CancelBtActionPerformed

    public void SortDialog(int loaiSapXep){
        Object selected = DsChuHoMainView.getSapXepCkb().getSelectedItem();
        if(selected.equals("Theo CCCD")){
            DSChuHo.Sorting(loaiSapXep, 1, DsChuHoMainView.getBangDSChuHo());
        }else if(selected.equals("Theo họ và tên")){
            DSChuHo.Sorting(loaiSapXep, 2, DsChuHoMainView.getBangDSChuHo());                
        }else if(selected.equals("Theo địa chỉ")){
            DSChuHo.Sorting(loaiSapXep, 3, DsChuHoMainView.getBangDSChuHo());                
        }else if(selected.equals("Theo SĐT")){
            DSChuHo.Sorting(loaiSapXep, 4, DsChuHoMainView.getBangDSChuHo());                
        }else if(selected.equals("Theo Account")){
            DSChuHo.Sorting(loaiSapXep, 5, DsChuHoMainView.getBangDSChuHo());                
        }else if(selected.equals("Theo ngày sinh")){
            DSChuHo.Sorting(loaiSapXep, 6, DsChuHoMainView.getBangDSChuHo());                
        }          
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LayMotSoUIdepTaiDay.CheckBox AZCkb;
    private javax.swing.JButton CancelBt;
    private javax.swing.ButtonGroup LoaiTuoiGrp;
    private javax.swing.JButton OkBt;
    private LayMotSoUIdepTaiDay.CheckBox ZACkb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
