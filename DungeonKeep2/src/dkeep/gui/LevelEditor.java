package dkeep.gui;

import javax.swing.JFrame;
import java.awt.CardLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import java.awt.Color;

public class LevelEditor extends JFrame{
	
	private JButton btnJerry;
	private JButton btnCheese;
	private JButton btnDog;
	private JButton btnFloor;
	private JButton btnDoor;
	private JButton btnWall;
	private JButton btnExit; 
	private JButton btnStart;
	private JComboBox comboBox_columns, comboBox_rows, comboBox_level;
	private JLabel lblColumns,lblRow, lblLevel;
	private JPanel panel,panel_1;
	
	public LevelEditor() {
	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        setTitle("Level Editor");
        setBounds(100, 100, 730, 542);
		
		btnJerry = new JButton("Jerry");
		btnJerry.setBounds(543, 53, 89, 23);
		getContentPane().add(btnJerry);
		
		btnCheese = new JButton("Cheese");
		btnCheese.setBounds(543, 87, 89, 23);
		getContentPane().add(btnCheese);
		
		btnDog = new JButton("Dog");
		btnDog.setBounds(543, 121, 89, 23);
		getContentPane().add(btnDog);
		
		btnFloor = new JButton("Floor");
		btnFloor.setBounds(543, 155, 89, 23);
		getContentPane().add(btnFloor);
		
		btnDoor = new JButton("Door");
		btnDoor.setBounds(543, 189, 89, 23);
		getContentPane().add(btnDoor);
		
		btnWall = new JButton("Wall");
		btnWall.setBounds(543, 223, 89, 23);
		getContentPane().add(btnWall);
		
		panel = new JPanel();
		panel.setBounds(46, 74, 265, 213);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		comboBox_columns = new JComboBox();
		comboBox_columns.setBounds(88, 2, 128, 20);
		panel.add(comboBox_columns);
		comboBox_columns.setModel(new DefaultComboBoxModel(new Integer[] {1,2,3,4,5,6,7,8,9,10}));
		
		lblColumns = new JLabel("Columns");
		lblColumns.setBounds(0, 0, 78, 20);
		panel.add(lblColumns);
		lblColumns.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblRow = new JLabel("Rows");
		lblRow.setBounds(0, 59, 78, 20);
		panel.add(lblRow);
		lblRow.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		comboBox_rows = new JComboBox();
		comboBox_rows.setBounds(88, 61, 128, 20);
		panel.add(comboBox_rows);
		comboBox_rows.setModel(new DefaultComboBoxModel(new Integer[] {1,2,3,4,5,6,7,8,9,10}));
		
		comboBox_level = new JComboBox();
		comboBox_level.setBounds(88, 138, 128, 20);
		panel.add(comboBox_level);
		comboBox_level.setModel(new DefaultComboBoxModel(new Integer[] {1,2}));
		
		lblLevel = new JLabel("Level");
		lblLevel.setBounds(0, 136, 78, 20);
		panel.add(lblLevel);
		lblLevel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(46, 425, 78, 32);
		getContentPane().add(btnExit);
		
		btnStart = new JButton("Start Game");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
			}
		});
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnStart.setBounds(183, 425, 128, 32);
		getContentPane().add(btnStart);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(22, 50, 405, 348);
		getContentPane().add(panel_1);
	}
}
