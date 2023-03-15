import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JPanel;

import viewcontroller.FormsPanel;
import viewcontroller.Window;

public class Main {

	public static void main(String[] args) {	
		Window mainWindow = new Window(800, 600);
		
		WindowListener winList = new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e) 
			{
				System.exit(0);
			}
		};
		
		JPanel contentPane = (JPanel) mainWindow.getContentPane();
		contentPane.add(mainWindow.createToolBar(), BorderLayout.NORTH);
		
		FormsPanel drawing_panel = new FormsPanel(mainWindow);		
		mainWindow.add(drawing_panel, BorderLayout.CENTER);
		
		mainWindow.addWindowListener(winList);
		mainWindow.setSize(800, 600);
		mainWindow.setVisible(true);
	}

}
