import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ChatServerGUI implements ActionListener
{
	JFrame window;
	JPanel jpanel1, jpanel2;
	JButton start, end;
	JTextArea msgbox;
	ChatServer server;
	
	ChatServerGUI()
	{
		window = new JFrame();
		window.setLayout(new GridLayout(2,2));
		jpanel1 = new JPanel();
		jpanel1.setLayout(new GridLayout(1,1));
		jpanel2 = new JPanel();
		jpanel2.setLayout(new GridLayout(2,2));
		msgbox = new JTextArea();
		msgbox.setBounds(10, 30, 765, 200);  
		start = new JButton("Start");
		end = new JButton("End");
		jpanel1.add(msgbox);
		jpanel2.add(start);
		jpanel2.add(end);
		window.add(jpanel1);
		window.add(jpanel2);
		window.setSize(800, 480);//800 width and 480 height
		window.setVisible(true);//making the frame visible
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		start.addActionListener(this);
		end.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();		
		if (source == start)
		{
			try{
				server = new ChatServer();
			}
			catch(IOException ioe)
			{
				ioe.printStackTrace();
			}
			server.run();
		}
		else if(source == end)
		{
			System.exit(0);
		}
		else
		{
			
		}
	}
	
	public static void main(String[] args)
	{
		ChatServerGUI gui = new ChatServerGUI();
	}
}