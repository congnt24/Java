import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main extends Minimax{
	boolean player=true;
	private JFrame frame;
	Vertex vertex=new Vertex(new int[9], 0);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		for (int i = 0; i < button.length; i++) {
			button[i]=new JButton("");
			button[i].addActionListener(buttonEvent);
			panel.add(button[i]);
		}
		
	}

	ActionListener buttonEvent=new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JButton jb=(JButton)arg0.getSource();
			if (player) {
				jb.setText("X");
				player=false;
			}
			jb.setEnabled(false);
			for (int i = 0; i < button.length; i++) {
//				vertex.board[i]=(button[i].getText().equals("X"))?1:(button[i].getText().equals("O"))?2:3;
				if (button[i].getText().equals("X")) {
					vertex.board[i]=1;
				}
			}
			vertex=alphabeta(vertex, 2, -99, 99, 2);
			if (vertex.board[vertex.position]!=1) {
				button[vertex.position].setText("O");
				button[vertex.position].setEnabled(false);
			}
			player=true;
			printf(vertex);
			System.out.println(vertex.value);
			System.out.println(checkWin(vertex));
		}
	};

}
