
package convex.hull;

import static convex.hull.MergeHull.allPoints;
import java.awt.Color;
import java.util.Collections;


public class ConvexFrame extends javax.swing.JFrame {

    private ConvexPanel cp;
    
    public ConvexFrame() {
        initComponents();
        scndInitComps();
    }
    
    private void scndInitComps(){
        this.getContentPane().setBackground(Color.WHITE);
        this.setLocation(550, 70);
        this.setTitle("Convex Hull");
        cp = new ConvexPanel();
        cp.setBounds(10, 10, 780, 600);
        this.add(cp);
        chButton.setFocusable(false);
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        chButton.setBackground(new java.awt.Color(204, 0, 0));
        chButton.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        chButton.setForeground(new java.awt.Color(255, 255, 255));
        chButton.setText("Draw Convex Hull!");
        chButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(chButton)
                .addContainerGap(259, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(621, Short.MAX_VALUE)
                .addComponent(chButton)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chButtonActionPerformed
        Collections.sort(allPoints);
        MergeHull.draw();
        cp.repaint();
    }//GEN-LAST:event_chButtonActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConvexFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConvexFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConvexFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConvexFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConvexFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chButton;
    // End of variables declaration//GEN-END:variables
}
