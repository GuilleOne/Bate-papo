package frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Chat extends JFrame{
	

	private JLabel jl_title;
	private JEditorPane messages;
	private JTextField jt_message;
	private JButton jb_message;
	private JPanel panel;
	private JScrollPane scroll;
	private ArrayList<String> message_list;
	private String connection_info;
	
	public Chat(String connection_info, String title){
		
		super("Chat" + title);
		this.connection_info = connection_info;
		
		initComponents();
		configComponents();
		insertComponents();
		insertActions();
		start();

	}
	private void initComponents() {
		message_list = new ArrayList<String>();
		jl_title = new JLabel(connection_info.split(":")[0],SwingConstants.CENTER);
		messages = new JEditorPane();
		scroll = new JScrollPane (messages);
		jt_message = new JTextField();
		jb_message = new JButton("Enviar");
		panel = new JPanel(new BorderLayout());
	
		
	}
	
	private void configComponents() {
		this.setMinimumSize(new Dimension(480, 720));
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		messages.setContentType("texto/html");
		messages.setEditable(false);
		
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
	
	}
	
	private void insertComponents() {
		this.add(jl_title, BorderLayout.NORTH);
		this.add(scroll, BorderLayout.CENTER);
		this.add(panel, BorderLayout.SOUTH);
		panel.add(jt_message, BorderLayout.CENTER);
		panel.add(jb_message, BorderLayout.EAST);
		
		
	
		
	}
	
	private void insertActions() {
		
		
		

		
	}
	
	public void append_message(String received) {
		message_list.add(received);
		String message = "";
		for (String str : message_list) {
			//message + - str;
			
		}
		
		
	messages.setText(message);
		
	
		
	}
	
	private void send() {
	if (jt_message.getText().length() > 0);
	
	{
	DateFormat df = new SimpleDateFormat("hh:nm:ss");
	append_message("<b>" + df.format(new Date()) + " Eu <\b><i>" + jt_message.getText() + "</i><br>");
	jt_message.setText("");
	
	
	
	
	}
	
	}
	
	
		private void start() {
		this.pack();
		this.setVisible(true);
		
		
		
		
		
		
		
		
	}
		//run
		public static void main(String[]args) {
			Chat chat = new Chat("Jhon:127.0.0.1:3333", "");
			
			
			
			
			
		}
		
}