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

public class ButtonMenu extends JButton{
    private RippleEffect rf;
    private Color normalColor = new Color(230, 230, 230);
    private Color hoverColor = new Color(51, 204, 255);
    private Boolean Da_Nhan = false;

    public void setButtonColor(int r, int g, int b){
        this.hoverColor = new Color(r, g, b);
    }
    
    public Boolean getDa_Nhan() {
        return Da_Nhan;
    }

    public void setDa_Nhan(Boolean Da_Nhan) {
        this.Da_Nhan = Da_Nhan;
    }
    
    public ButtonMenu(){
        rf = new RippleEffect(this);
        rf.setRippleColor(new Color(220, 220, 220));
        this.setContentAreaFilled(false);
        this.setForeground(new Color(230, 230, 230));
        this.setHorizontalAlignment(SwingConstants.LEFT);
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.setFocusable(false);
        this.setIconTextGap(10);
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                    setBackground(hoverColor);
                    setOpaque(true);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                if(!Da_Nhan){
                    setBackground(normalColor);
                    setOpaque(false);
                    repaint();
                }
            }
        });
    }
    
    public void Nhan(){
        this.setDa_Nhan(true);
        setBackground(hoverColor);
        setOpaque(true);
    }
    
    public void Reset(){
        this.setDa_Nhan(false);
        setBackground(normalColor);
        setOpaque(false);
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        rf.reder(g, new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
    }
    
    
}
