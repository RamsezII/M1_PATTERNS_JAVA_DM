package view;
import model.Model;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.*;

/**
 * This class represents the main window of the software. It initializes different parts, such as the tool bar and the drawing panel.
 */

public class Window extends JFrame{
	private Modes mode;
	private Model model;
	
	//Constants 
	public static int TOOLBAR_WIDTH = 100;
	public static int TOOLBAR_HEIGHT = 50;

	/**
	 * The constructor of the Window class. It takes the width and height of the window, and a reference to the model.
	 * 
	 * @param width
	 * @param height
	 * @param model
	 */
	public Window(int width, int height, Model model) {
		super("FormsApp");
		this.setSize(width, height);
		this.model = model;
	}
	
	// Getters
	
	/**
	 * This method return the current mode.
	 * 
	 * @return Returns the current mode.
	 */
	public Modes getMode() {
		return this.mode;
	}
	
	// Setters	
	
	/**
	 * This method sets the current mode.
	 * @param A new mode.
	 */
	public void setMode(Modes mode){
		this.mode = mode;
		switch(mode){
			case Redo:
				model.redo();
				break;
			case Undo:
				model.undo();
				break;
			default:
				break;			
		}
		System.out.println("Changement de mode : " + mode);
	}
	
	/**
	 * This method creates the tool bar, with some buttons and their icons.
	 * @return Returns the tool bar.
	 */
	public JToolBar createToolBar() {
		JToolBar tool_bar = new JToolBar();
		
		// Create circle button
		ModeSelectorButton circle_button = new ModeSelectorButton(this);
		circle_button.setName(Modes.Circle.name());
		circle_button.setIcon(new ImageIcon(getClass().getClassLoader().getResource("bin/Circle.png")));
		circle_button.setToolTipText("Create circle");
		tool_bar.add(circle_button);
		
		// Create rectangle button
		ModeSelectorButton rectangle_button = new ModeSelectorButton(this);
		rectangle_button.setName(Modes.Rectangle.name());
		rectangle_button.setIcon(new ImageIcon(getClass().getClassLoader().getResource("bin/Rectangle.png")));
		rectangle_button.setToolTipText("Create rectangle");
		tool_bar.add(rectangle_button);
		
		// Remove form button
		ModeSelectorButton remove_button = new ModeSelectorButton(this);
		remove_button.setName(Modes.Remove.name());
		remove_button.setIcon(new ImageIcon(getClass().getClassLoader().getResource("bin/Remove.png")));
		remove_button.setToolTipText("Remove form");
		tool_bar.add(remove_button);
		
		// Undo button
		ModeSelectorButton undo_button = new ModeSelectorButton(this);
		undo_button.setName(Modes.Undo.name());
		undo_button.setIcon(new ImageIcon(getClass().getClassLoader().getResource("bin/Undo.png")));
		undo_button.setToolTipText("Undo");
		tool_bar.add(undo_button);
		
		// Redo button
		ModeSelectorButton redo_button = new ModeSelectorButton(this);
		redo_button.setName(Modes.Redo.name());
		redo_button.setIcon(new ImageIcon(getClass().getClassLoader().getResource("bin/Redo.png")));
		redo_button.setToolTipText("Redo");
		tool_bar.add(redo_button);
		
		return tool_bar;
	}

	/**
	 * This method is the main for starting software.
	 * @param args
	 */
	public static void main(String[] args) {
		//Model
		Model model = new Model();
		
		Window mainWindow = new Window(800, 600, model);
		WindowListener winList = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		
		// For add tool bar to the window
		JPanel contentPane = (JPanel) mainWindow.getContentPane();
		contentPane.add(mainWindow.createToolBar(), BorderLayout.NORTH);

		//View
		FormsPanel drawing_panel = new FormsPanel(mainWindow, model);
		mainWindow.add(drawing_panel, BorderLayout.CENTER); // For add the drawing panel in the window
		mainWindow.addWindowListener(winList);
		mainWindow.setSize(800, 600);
		mainWindow.setVisible(true);
	}
}
