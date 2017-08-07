import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatClientGUI implements ActionListener
{
	JFrame window;
	JPanel jpanel1, jpanel2;
	JButton conn,exit;
	JTextArea msgbox;
	ChatClient client;
	
	ChatClientGUI()
	{
		window = new JFrame();
		window.setLayout(new GridLayout(2,2));
		jpanel1 = new JPanel();
		jpanel1.setLayout(new GridLayout(1,1));
		jpanel2 = new JPanel();
		jpanel2.setLayout(new GridLayout(2,2));
		msgbox = new JTextArea();
		msgbox.setBounds(10, 30, 765, 200);  
		conn = new JButton("Connect");
		exit = new JButton("Exit");
		jpanel1.add(msgbox);
		jpanel2.add(conn);
		jpanel2.add(exit);
		window.add(jpanel1);
		window.add(jpanel2);
		window.setSize(800, 480);//800 width and 480 height
		window.setVisible(true);//making the frame visible
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		conn.addActionListener(this);
		exit.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Button Clicked " + e.getSource());
		Object source = e.getSource();
		
		if (source == conn)
		{
			client = new ChatClient();
			client.connect_to_server();
		}
		else if(source == exit)
		{
			System.exit(0);
		}
		else
		{
			
		}
	}
	
	public static void main(String[] args)
	{
		ChatClientGUI gui = new ChatClientGUI();
	}
}