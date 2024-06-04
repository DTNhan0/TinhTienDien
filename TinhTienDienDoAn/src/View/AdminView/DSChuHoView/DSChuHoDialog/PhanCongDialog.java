package View.AdminView.DSChuHoView.DSChuHoDialog;

import Model.Customers;
import Model.Staffs;
import View.AdminView.DSChuHoView.DSChuHoMainView;
import View.AdminView.MainAdminView;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Controller.DSChuHoController.DSChuHo;

public class PhanCongDialog extends javax.swing.JDialog {
    private MainAdminView MainAdminview;
    private DSChuHoMainView DsChuHoMainView;
    private  Customers customers = new Customers();  
    private  Staffs staffsSelected = new Staffs(); 
    private  List <Staffs> ListStaffs = new ArrayList<>();
    
    public PhanCongDialog(MainAdminView mainAdminView, DSChuHoMainView dSChuHoMainView, boolean modal) {
        initComponents();
        this.MainAdminview = mainAdminView;
        this.DsChuHoMainView = dSChuHoMainView;
        this.setModalityType(DEFAULT_MODALITY_TYPE.APPLICATION_MODAL);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        customers = DsChuHoMainView.getCustomer();
        ListStaffs = DsChuHoMainView.getDsNhanVien();
        ListNVCb.removeAll();
        
        for(Staffs staffs : ListStaffs){
            if(staffs.getRoleStaff() == 1 && customers.getCCCD() != staffs.getCCCD()){
                ListNVCb.addItem(staffs.getCCCD());                 
            }           
        }
        
        HoTenCHTf.setText(customers.getFirstname() + " " + customers.getMiddleName() + " " + customers.getLastname());
        SdtCHTf.setText(customers.getPhone());
        DiaChiCHTf.setText(customers.getAddress());
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        OkBt = new javax.swing.JButton();
        CancelBt = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        HoTenCHTf = new javax.swing.JTextField();
        SdtCHTf = new javax.swing.JTextField();
        DiaChiCHTf = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        DiaChiNVTf = new javax.swing.JTextField();
        SdtNVTf = new javax.swing.JTextField();
        HoTenNVTf = new javax.swing.JTextField();
        ListNVCb = new javax.swing.JComboBox<>();

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
        jLabel1.setText("PHÂN CÔNG NHÂN VIÊN NHẬP XUẤT LÀM VIỆC CHO CHỦ HỘ:");

        jSeparator4.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator4.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Chủ hộ đang chọn:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Nhân viên nhập xuất:");

        jLabel5.setText("Họ tên:");

        jLabel6.setText("Địa chỉ:");

        jLabel7.setText("SĐT:");

        HoTenCHTf.setEditable(false);
        HoTenCHTf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        SdtCHTf.setEditable(false);
        SdtCHTf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        DiaChiCHTf.setEditable(false);
        DiaChiCHTf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel8.setText("Họ tên:");

        jLabel9.setText("SĐT:");

        jLabel10.setText("Địa chỉ:");

        DiaChiNVTf.setEditable(false);
        DiaChiNVTf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        SdtNVTf.setEditable(false);
        SdtNVTf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        HoTenNVTf.setEditable(false);
        HoTenNVTf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        ListNVCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListNVCbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SdtCHTf)
                                    .addComponent(HoTenCHTf)))
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(OkBt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(CancelBt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(DiaChiCHTf, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(153, 153, 153))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ListNVCb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(DiaChiNVTf, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                                            .addComponent(SdtNVTf)
                                            .addComponent(HoTenNVTf))))
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ListNVCb, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(HoTenNVTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(SdtNVTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(DiaChiNVTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(HoTenCHTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(SdtCHTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(DiaChiCHTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(OkBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CancelBt))
                        .addGap(23, 23, 23))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OkBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkBtActionPerformed
        if(staffsSelected == null){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên cần phân công!!!");              
            this.dispose();
        }else{
            int confirm = JOptionPane.showConfirmDialog(
                this,
                "Bạn có chắc muốn phân công nhân viên có CCCD: " + staffsSelected.getCCCD() + " làm việc cho chủ hộ"
                        + " có CCCD: " + customers.getCCCD() + " không?",
            "Xác nhận",
            JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                try{
                    new DSChuHo().UpdateAssignment(customers.getID_Customer(), staffsSelected.getID_Staff());
                    
                    JOptionPane.showMessageDialog(this, "Đã phân công thành công!!!");  
                    this.DsChuHoMainView.ShowThongTinTuDBS(DsChuHoMainView.getBangDSChuHo());
                    this.dispose();
                    
                }catch(Exception e){
                    System.out.println(e);
                    JOptionPane.showMessageDialog(this, "Lỗi hệ thống!!! - Vui lòng thử lại sau", "Lỗi", 
                                                  JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_OkBtActionPerformed

    private void CancelBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtActionPerformed
        this.dispose();
    }//GEN-LAST:event_CancelBtActionPerformed

    private void ListNVCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListNVCbActionPerformed
        for(Staffs staffs : ListStaffs){
            if(staffs.getCCCD().equals(ListNVCb.getSelectedItem())){
                staffsSelected = staffs;
                break;
            }
        }
        HoTenNVTf.setText(staffsSelected.getFirstname() + " " + staffsSelected.getMiddleName() + " " + staffsSelected.getLastname());
        SdtNVTf.setText(staffsSelected.getPhone());
        DiaChiNVTf.setText(staffsSelected.getAddress());
    }//GEN-LAST:event_ListNVCbActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelBt;
    private javax.swing.JTextField DiaChiCHTf;
    private javax.swing.JTextField DiaChiNVTf;
    private javax.swing.JTextField HoTenCHTf;
    private javax.swing.JTextField HoTenNVTf;
    private javax.swing.JComboBox<String> ListNVCb;
    private javax.swing.JButton OkBt;
    private javax.swing.JTextField SdtCHTf;
    private javax.swing.JTextField SdtNVTf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    // End of variables declaration//GEN-END:variables
}
