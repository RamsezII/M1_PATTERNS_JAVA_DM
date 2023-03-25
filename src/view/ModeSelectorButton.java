package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * This class represents a listener on a button in the tool bar.
 */
public class ModeSelectorButton extends JButton {
	
	/**
	 * The constructor of this class. Takes a reference to the main window
	 * @param window
	 */
    public ModeSelectorButton(Window window){
        setSize(Window.TOOLBAR_WIDTH, Window.TOOLBAR_HEIGHT);
        addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String name = ((JButton)e.getSource()).getName();
                window.setMode(Modes.valueOf(name)); // Sets the current mode.
            }
        });
    }
}
