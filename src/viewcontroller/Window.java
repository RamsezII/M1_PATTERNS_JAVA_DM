package viewcontroller;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;

public class Window extends JFrame
{
	private Modes mode;
	public int width = 800;
	public int height = 600;
	public static int scale = 1;
	public static int toolbarHeight = 50;
	public static int toolbarButtonWidth = 100;

	public Window(int width, int height) {
		super("FormsApp");
		this.width = width;
		this.height = height;
	}
	
	public JToolBar createToolBar() 
	{
		JToolBar tool_bar = new JToolBar();
		
		ModeSelectorButton circle_button = new ModeSelectorButton(this);
		circle_button.setName(Modes.Circle.name());
		circle_button.setIcon(new ImageIcon("src/bin/Circle.png"));
		circle_button.setToolTipText("Create circle");
		tool_bar.add(circle_button);
		
		ModeSelectorButton rectangle_button = new ModeSelectorButton(this);
		rectangle_button.setName(Modes.Rectangle.name());
		rectangle_button.setIcon(new ImageIcon("src/bin/Rectangle.png"));
		rectangle_button.setToolTipText("Create rectangle");
		tool_bar.add(rectangle_button);
		
		ModeSelectorButton remove_button = new ModeSelectorButton(this);
		remove_button.setName(Modes.Remove.name());
		remove_button.setIcon(new ImageIcon("src/bin/Remove.png"));
		remove_button.setToolTipText("Remove form");
		tool_bar.add(remove_button);
		
		ModeSelectorButton undo_button = new ModeSelectorButton(this);
		undo_button.setName(Modes.Undo.name());
		undo_button.setIcon(new ImageIcon("src/bin/Undo.png"));
		undo_button.setToolTipText("Undo");
		tool_bar.add(undo_button);
		
		ModeSelectorButton redo_button = new ModeSelectorButton(this);
		redo_button.setName(Modes.Redo.name());
		redo_button.setIcon(new ImageIcon("src/bin/Redo.png"));
		redo_button.setToolTipText("Redo");
		tool_bar.add(redo_button);
		
		return tool_bar;
	}

	public void SetMode(Modes mode)
	{
		this.mode = mode;
		switch(mode)
		{
			case Circle:
				break;
			case Rectangle:
				break;
			case Redo:
				break;
			case Remove:
				break;
			case Undo:
				break;
			default:
				break;			
		}
		System.out.println("changé de mode : " + mode);
	}
	
	public Modes getMode() {
		return this.mode;
	}
}
