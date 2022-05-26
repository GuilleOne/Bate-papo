package frame;

import java.awt.*;
import javax.swing.*;


public class Login extends JFrame {
	
	private JButton jb_login;
	private JLabel jl_user,jl_port, jl_title;
	private JTextField jt_user, jt_port;
	
	
	public Login () {
		super ("Login");
		initComponents();
		configComponents();
		insertComponents();
		insertActions();
		start();

	}
	
	private void initComponents() {
		jb_login = new JButton ("Entrar");
		
		jl_user = new JLabel("Usuário", SwingConstants.CENTER);
		
		jl_port = new JLabel("Senha", SwingConstants.CENTER);
		
		jl_title = new JLabel();
		
		jt_user = new JTextField();
		
		jt_port = new JTextField ();
		
		
	}
	
	private void configComponents() {
		this.setLayout(null);
		this.setMinimumSize(new Dimension(400,300));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(0,100,0));
		
		jl_title.setBounds(10,10,975,100);
		ImageIcon icon = new ImageIcon("log.png");
		jl_title.setIcon(new ImageIcon(icon.getImage().getScaledInstance(375, 200, Image.SCALE_SMOOTH)));
		
		
		jb_login.setBounds(10, 220, 375, 50);
		//jb_login.setBorder(BorderFactory.createLineBorder(Color.cyan));

		
		jl_user.setBounds(10, 120, 100, 40);
		jl_user.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		jl_port.setBounds(10, 170, 100, 40);
		jl_port.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		jt_user.setBounds(120, 120, 265, 40);
		jt_port.setBounds(120, 170, 265, 40);
		
		
	}
	
	private void insertComponents() {
		this.add(jb_login);
		this.add(jl_user);
		this.add(jl_port);
		this.add(jl_title);
		this.add(jt_user);
		this.add(jt_port);
	}
	
	private void insertActions() {
		
		
	}
	
	private void start() {
		this.pack();
		this.setVisible(true);
		
	}
	
	//run
	public static void main(String[]args) {
		Login login = new Login();
		
	}
}
