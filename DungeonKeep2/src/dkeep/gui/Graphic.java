package dkeep.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Graphic {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Graphic window = new Graphic();
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
	public Graphic() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 664, 484);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNumberOfOgres = new JLabel("Number of Ogres");
		lblNumberOfOgres.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumberOfOgres.setBounds(10, 11, 121, 33);
		frame.getContentPane().add(lblNumberOfOgres);
		
		textField = new JTextField();
		textField.setBounds(139, 17, 91, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Guard personality");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(20, 55, 91, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Suspicious", "Drunken", "Rookie"}));
		comboBox.setBounds(139, 55, 127, 20);
		frame.getContentPane().add(comboBox);

		JButton blbExit = new JButton("Exit");
		blbExit.setBounds(516, 384, 89, 23);
		frame.getContentPane().add(blbExit);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(24, 97, 403, 261);
		frame.getContentPane().add(textArea);
		
		JButton btnRight = new JButton("Right");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnLeft = new JButton("Left");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLeft.setEnabled(false);
		btnLeft.setBounds(439, 214, 90, 28);
		frame.getContentPane().add(btnLeft);
		
		JButton btnDown = new JButton("Down");
		btnDown.setEnabled(false);
		btnDown.setBounds(500, 253, 90, 28);
		frame.getContentPane().add(btnDown);
		
		btnRight.setEnabled(false);
		btnRight.setBounds(552, 214, 90, 28);
		frame.getContentPane().add(btnRight);
		
		JButton btnUp = new JButton("Up");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUp.setEnabled(false);
		btnUp.setBounds(500, 174, 90, 28);
		frame.getContentPane().add(btnUp);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnUp.setEnabled(true);
				 btnDown.setEnabled(true);
				 btnRight.setEnabled(true);
				 btnLeft.setEnabled(true);
			}
		});
		btnNewGame.setBounds(310, 54, 102, 23);
		frame.getContentPane().add(btnNewGame);
		

		JLabel lblYouCanStart = new JLabel("You can start a new game");
		lblYouCanStart.setBounds(34, 371, 359, 49);
		frame.getContentPane().add(lblYouCanStart);
		
	}
}
