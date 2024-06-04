package LayMotSoUIdepTaiDay;

import Component.RippleEffect;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ButtonThuong extends JButton{
    private RippleEffect rf;
    private Color normalColor;
    private Color hoverColor;
    
    public ButtonThuong(){
        rf = new RippleEffect(this);
        rf.setRippleColor(new Color(220, 220, 220));
        this.setBackground(new Color(192, 192, 192));
        this.setForeground(new Color(64, 64, 64));
        this.setHorizontalAlignment(SwingConstants.LEFT);
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.setFocusable(false);
        this.setIconTextGap(10);
        
        normalColor = new Color(192, 192, 192);
        hoverColor = new Color(128, 128, 128); 
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                    setBackground(hoverColor);
                    setOpaque(true);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                    setBackground(normalColor);
                    repaint();
            }
        });
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        rf.reder(g, new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
    }
}
