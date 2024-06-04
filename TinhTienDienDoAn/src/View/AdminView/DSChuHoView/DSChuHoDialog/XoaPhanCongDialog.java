package View.AdminView.DSChuHoView.DSChuHoDialog;

import Controller.DAO.AssignmentsDAO;
import Controller.DSChuHoController.DSChuHo;
import Controller.DSNhanVienController.DSNhanVien;
import Model.Assignments;
import Model.Customers;
import Model.Staffs;
import View.AdminView.DSChuHoView.DSChuHoMainView;
import View.AdminView.MainAdminView;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class XoaPhanCongDialog extends javax.swing.JDialog {
    private MainAdminView MainAdminview;
    private DSChuHoMainView DsChuHoMainView;
    private  Customers customers = new Customers();  
    private  Staffs staff_write = new Staffs(); 
    private  List <Staffs> ListStaffs = new ArrayList<>();
    
    public XoaPhanCongDialog(MainAdminView mainAdminView, DSChuHoMainView dSChuHoMainView, boolean modal) {
        initComponents();
        this.MainAdminview = mainAdminView;
        this.DsChuHoMainView = dSChuHoMainView;
        this.setModalityType(DEFAULT_MODALITY_TYPE.APPLICATION_MODAL);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        customers = DsChuHoMainView.getCustomer();
        ListStaffs = DsChuHoMainView.getDsNhanVien();
        
        HoTenCHTf.setText(customers.getFirstname() + " " + customers.getMiddleName() + " " + customers.getLastname());
        SdtCHTf.setText(customers.getPhone());
        DiaChiCHTf.setText(customers.getAddress());
        
        staff_write = new Staffs();
        
        try {
            for(Assignments assignments : new AssignmentsDAO().getAll())
                if(assignments.getID_Customer().equals(customers.getID_Customer()))
                    staff_write = new DSNhanVien().SearchObjID(assignments.getID_Staff_Write());
        } catch (Exception ex) {
            Logger.getLogger(XoaPhanCongDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        HoTenNVTf.setText(staff_write.getFirstname() + " " + staff_write.getMiddleName() + " " + staff_write.getLastname());
        SdtNVTf.setText(staff_write.getPhone());
        DiaChiNVTf.setText(staff_write.getAddress());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoaiTuoiGrp = new javax.swing.ButtonGroup();
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
        jLabel1.setText("XOÁ PHÂN CÔNG:");

        jSeparator4.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator4.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Chủ hộ đang chọn:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Nhân viên:");

        jLabel5.setText("Họ tên:");

        jLabel6.setText("Địa chỉ:");

        jLabel7.setText("SĐT:");

        HoTenCHTf.setEditable(false);
        HoTenCHTf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        HoTenCHTf.setEnabled(false);

        SdtCHTf.setEditable(false);
        SdtCHTf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SdtCHTf.setEnabled(false);

        DiaChiCHTf.setEditable(false);
        DiaChiCHTf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DiaChiCHTf.setEnabled(false);

        jLabel8.setText("Họ tên:");

        jLabel9.setText("SĐT:");

        jLabel10.setText("Địa chỉ:");

        DiaChiNVTf.setEditable(false);
        DiaChiNVTf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DiaChiNVTf.setEnabled(false);

        SdtNVTf.setEditable(false);
        SdtNVTf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SdtNVTf.setEnabled(false);

        HoTenNVTf.setEditable(false);
        HoTenNVTf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        HoTenNVTf.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(DiaChiCHTf))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(OkBt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(CancelBt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(HoTenCHTf)
                            .addComponent(SdtCHTf))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(153, 153, 153))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DiaChiNVTf, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                            .addComponent(SdtNVTf)
                            .addComponent(HoTenNVTf))
                        .addContainerGap())))
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CancelBt)
                            .addComponent(OkBt)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
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
                                .addComponent(DiaChiNVTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OkBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkBtActionPerformed
        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Bạn có chắc chắn xóa phân công nhân viên đang làm việc cho chủ hộ không?",
            "Xác nhận",
            JOptionPane.YES_NO_OPTION
            );
        if (confirm == JOptionPane.YES_OPTION) {
                try{
                    new DSChuHo().DeleteAssignment(customers.getID_Customer());
                    JOptionPane.showMessageDialog(this, "Đã xóa phân công thành công!!!");  
                    this.DsChuHoMainView.ShowThongTinTuDBS(DsChuHoMainView.getBangDSChuHo());
                    this.dispose();
                    
                }catch(Exception e){
                    System.out.println(e);
                    JOptionPane.showMessageDialog(this, "Lỗi hệ thống!!! - Vui lòng thử lại sau", "Lỗi", 
                                                  JOptionPane.ERROR_MESSAGE);
                }
            }
    }//GEN-LAST:event_OkBtActionPerformed

    private void CancelBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtActionPerformed
        this.dispose();
    }//GEN-LAST:event_CancelBtActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelBt;
    private javax.swing.JTextField DiaChiCHTf;
    private javax.swing.JTextField DiaChiNVTf;
    private javax.swing.JTextField HoTenCHTf;
    private javax.swing.JTextField HoTenNVTf;
    private javax.swing.ButtonGroup LoaiTuoiGrp;
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
