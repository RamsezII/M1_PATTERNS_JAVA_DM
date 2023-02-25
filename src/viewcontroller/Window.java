package viewcontroller;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.*;

public class Window extends JFrame
{
	private Modes mode;

	public Window() 
	{
		super("FormsApp");
		
		WindowListener winList = new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e) 
			{
				System.exit(0);
			}
		};
		
		addWindowListener(winList);
		setSize(500, 500);
		setVisible(true);
		
		JPanel contentPane = (JPanel) getContentPane();
		contentPane.add(this.createToolBar(), BorderLayout.NORTH);
		
		FormsPanel drawing_panel = new FormsPanel();
		
		this.getContentPane().add(drawing_panel);
	}
	
	public JToolBar createToolBar() 
	{
		JToolBar tool_bar = new JToolBar();
		
		ModeSelectorButton circle_button = new ModeSelectorButton(this);
		circle_button.setName(Modes.circle.name());
		circle_button.setIcon(new ImageIcon("Circle.png"));
		circle_button.setToolTipText("Create circle");
		tool_bar.add(circle_button);
		
		ModeSelectorButton rectangle_button = new ModeSelectorButton(this);
		rectangle_button.setName("Rectangle");
		rectangle_button.setIcon(new ImageIcon("Rectangle.png"));
		rectangle_button.setToolTipText("Create rectangle");
		tool_bar.add(rectangle_button);
		
		ModeSelectorButton remove_button = new ModeSelectorButton(this);
		remove_button.setName("Remove");
		remove_button.setIcon(new ImageIcon("Remove.png"));
		remove_button.setToolTipText("Remove form");
		tool_bar.add(remove_button);
		
		ModeSelectorButton undo_button = new ModeSelectorButton(this);
		undo_button.setName("Undo");
		undo_button.setIcon(new ImageIcon("Undo.png"));
		undo_button.setToolTipText("Undo");
		tool_bar.add(undo_button);
		
		ModeSelectorButton redo_button = new ModeSelectorButton(this);
		redo_button.setName("Redo");
		redo_button.setIcon(new ImageIcon("Redo.png"));
		redo_button.setToolTipText("Redo");
		tool_bar.add(redo_button);
		
		return tool_bar;
	}

	public void SetMode(Modes mode)
	{
		this.mode = mode;
		System.out.println("changé de mode : " + mode);
	}
}
