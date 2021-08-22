package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener{
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */
	
	JFrame frame;
	JPanel panel;
	JButton add;
	JButton view;
	JButton remove;
	JButton save;
	JButton load;
	
	ArrayList<String> tasks;
	
	ToDoList(){
		frame = new JFrame();
		panel = new JPanel();
		add = new JButton("Add Task");
		view = new JButton("View Tasks");
		remove = new JButton("Remove Task");
		save = new JButton("Save List");
		load = new JButton("Load List");
		
		tasks = new ArrayList<String>();
		
		frame.add(panel);
		panel.add(add);
		panel.add(view);
		panel.add(remove);
		panel.add(save);
		panel.add(load);
		
		add.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
		
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 75);
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		new ToDoList();
		
	}









	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		if(e.getSource()==add) {
			String task = JOptionPane.showInputDialog("Enter the task you would like to add");
			tasks.add(task);
		}
		
		if(e.getSource()==view) {
			System.out.println(tasks);
		}
		
		if(e.getSource()==remove) {
			String removeTask = JOptionPane.showInputDialog("Which task would you like to remove?");
			for (int i = 0; i < tasks.size(); i++) {
				if(removeTask.equalsIgnoreCase(tasks.get(i))) {
					tasks.remove(i);
					JOptionPane.showMessageDialog(null, "Task removed");
				}
				
			}
		}
		
		if(e.getSource()==save) {
			
			JOptionPane.showMessageDialog(null, "List saved to file.");
			
			try {
				FileWriter fr = new FileWriter("src/_03_To_Do_List/List.txt");
				String stringTasks = "";
				for (int i = 0; i < tasks.size(); i++) {
					stringTasks += tasks.get(i) + "\n";
				}
				fr.write(stringTasks);
				fr.close();
				
			}
			catch(IOException ex) {
				ex.printStackTrace();
			}
		}
		
		if(e.getSource()==load) {
			JOptionPane.showMessageDialog(null, "Loading file...");
			JFileChooser jfc = new JFileChooser();
			int returnVal = jfc.showOpenDialog(null);
			if(returnVal==JFileChooser.APPROVE_OPTION) {
				String fileName = jfc.getSelectedFile().getAbsolutePath();
				System.out.println(fileName);
			}
			
			String loadingFile = "";
			try {
			BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List/List.txt"));
			String line = br.readLine();
			while(line!=null) {
			loadingFile += line + "\n";
			line = br.readLine();
		}
			br.close();
			
			
			FileWriter fw2 = new  FileWriter("src/_03_To_Do_List/List.txt");
			fw2.write(loadingFile);
			fw2.close();
			
			}
			catch(Exception ex2) {
				ex2.printStackTrace();
			}
		}
		
		
	}
	
	
	
}
