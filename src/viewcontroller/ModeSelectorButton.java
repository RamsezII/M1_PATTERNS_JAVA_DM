package viewcontroller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ModeSelectorButton extends JButton 
{
    private boolean selected;

    public ModeSelectorButton(Window window) 
    {
        addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String name = ((JButton)e.getSource()).getName();
                window.SetMode(Modes.valueOf(name));
            }
        });
    }

    public void setSelected(boolean value)
    {
        this.selected = value;
    }

    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        int w = this.getWidth();
        int h = this.getHeight();

        if (selected)
        {
            g2D.setColor(Color.RED);
            g2D.drawRect(0, 0, w, h);
        }
    }    
}
