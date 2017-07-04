package convex.hull;

import static convex.hull.MergeHull.convexPoints;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ConvexPanel extends javax.swing.JPanel {

    
    public ConvexPanel() {
        initComponents();
        scndInitComps();
       
    }
    
    private void scndInitComps(){
        this.setBackground(Color.white);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                MergeHull.allPoints.add(new Point(e.getX()-8,e.getY()-8));
                repaint();
            }
        });
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.blue);
        for (int i = 0 ; i < MergeHull.allPoints.size() ; i++){
            g.fillOval(MergeHull.allPoints.get(i).getX(), MergeHull.allPoints.get(i).getY(), 16, 16);
        }
        g.setColor(Color.red);
        if(convexPoints.size()!= 0){
             for (int i = 0 ; i < convexPoints.size() ; i++){
                g.drawLine(convexPoints.get(i).getX()+8, convexPoints.get(i).getY()+8, convexPoints.get((i+1) % convexPoints.size()).getX()+8, convexPoints.get((i+1) % convexPoints.size()).getY()+8);
            }
        }
     
   }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Drawing Area", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT Condensed", 1, 24), new java.awt.Color(0, 0, 153))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 392, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 267, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
