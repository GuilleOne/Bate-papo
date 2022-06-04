package frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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

import client.Cliente;



public class Chat extends JFrame implements ActionListener, Runnable {

	private JLabel jl_title;
	private JEditorPane messages;
	private JButton jb_message;
	private JPanel panel;
	private JScrollPane scroll;
	private JTextField jt_message;
	public static ArrayList<String> message_list;
	private String connection_info;
	public String nome;
	Cliente client = new Cliente();

	
	
	public Chat(String connection_info) {

		
		
		
		
		super("Chat");
		this.connection_info = connection_info;
		initComponents();
		configComponents();
		insertComponents();
		jb_message.addActionListener(this);
		start();

	}

	private void initComponents() {
		message_list = new ArrayList<String>();
		jl_title = new JLabel(connection_info.split(":")[0], SwingConstants.CENTER);
		messages = new JEditorPane();
		scroll = new JScrollPane(messages);
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
//		scroll.setPreferredSize(new Dimension(250, 250));

	}

	private void insertComponents() {
		this.add(jl_title, BorderLayout.NORTH);
		this.add(scroll, BorderLayout.CENTER);
		this.add(panel, BorderLayout.SOUTH);
		panel.add(jt_message, BorderLayout.CENTER);
		panel.add(jb_message, BorderLayout.EAST);
	}

	public void append_message(String received) {
		messages.setText(messages.getText() + received + "\n");
	}

	private void send() {
		DateFormat df = new SimpleDateFormat("hh:m:ss");
		if (jt_message.getText().length() > 0) {
			
			append_message("<b>" + df.format(new Date()) + " Eu <\b><i>" + jt_message.getText() + "</i><br>");
			



			try {
				client.messageLoop(jt_message.getText());
			} catch (IOException e) {
				append_message(e.getMessage());
			}


			jt_message.setText("");
		}
		
	}



	public void receive(String phase) {



		message_list.add(phase);
		
		
	}

	private void start() {
		this.pack();
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj.equals(jb_message)) {
			this.send();
		}

	}

	@Override
	public void run() {
		Cliente client = new Cliente();
		try {
			client.start();
		} catch (IOException e) {
			
			e.printStackTrace();   //colocar mensagem no chat se der errado
		}
	}

	
}