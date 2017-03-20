package dkeep.gui;

import javax.swing.JFrame;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
	private int size_x=0;
	private int size_y=0;
	private final int width=405, height=348;
	private char character_selected;
	private BufferedImage defaulti;
	private boolean cheese_placed=false, jerry_placed=false;
	private char[][] board;
	private JButton btnSaveLevel;
	private FileWriter fw;
	
	public LevelEditor() {
		try {
			fw = new FileWriter("images/level.txt",true);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setTitle("Level Editor");
		setBounds(100, 100, 730, 542);

		btnJerry = new JButton("Jerry");
		btnJerry.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				character_selected= 'H';
			}
		});
		btnJerry.setBounds(543, 53, 89, 23);
		getContentPane().add(btnJerry);

		btnCheese = new JButton("Cheese");
		btnCheese.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				character_selected= 'k';
			}
		});
		btnCheese.setBounds(543, 87, 89, 23);
		getContentPane().add(btnCheese);

		btnDog = new JButton("Dog");
		btnDog.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				character_selected= 'O';
			}
		});
		btnDog.setBounds(543, 121, 89, 23);
		getContentPane().add(btnDog);

		btnFloor = new JButton("Floor");
		btnFloor.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				character_selected= ' ';
			}
		});
		btnFloor.setBounds(543, 155, 89, 23);
		getContentPane().add(btnFloor);

		btnDoor = new JButton("Door");
		btnDoor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				character_selected= 'I';
			}
		});
		btnDoor.setBounds(543, 189, 89, 23);
		getContentPane().add(btnDoor);

		btnWall = new JButton("Wall");
		btnWall.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				character_selected= 'X';
			}
		});
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
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(76, 425, 63, 32);
		getContentPane().add(btnExit);

		btnStart = new JButton("Start Editor");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				int nRows = (int) comboBox_rows.getSelectedItem();
				int nCols = (int) comboBox_columns.getSelectedItem();
				drawBoard(nRows, nCols);
				size_x = width/nCols;
				size_y = height/nRows;
				
				board = new char[nRows][nCols];
			}
		});
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnStart.setBounds(183, 425, 112, 32);
		getContentPane().add(btnStart);

		panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent mouse) {
				int square_x, square_y;
				square_x = mouse.getX()/size_x;
				square_y = mouse.getY()/size_y;

				if(character_selected == 'H'){
					if(!jerry_placed){
						panel_1.getGraphics().drawImage(getImage(character_selected), square_x*size_x, square_y*size_y, size_x, size_y, null);
						board[square_x][square_y]=character_selected;
						jerry_placed= true;
					}
				}
				else if(character_selected == 'k'){
					if(!cheese_placed){
						panel_1.getGraphics().drawImage(getImage(character_selected), square_x*size_x, square_y*size_y, size_x, size_y, null);
						board[square_x][square_y]=character_selected;
						cheese_placed= true;
					}
				}
				else{
					panel_1.getGraphics().drawImage(getImage(character_selected), square_x*size_x, square_y*size_y, size_x, size_y, null);
					board[square_x][square_y]=character_selected;
				}
				revalidate();
			}
		});
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(22, 50, width, height);
		getContentPane().add(panel_1);

		btnSaveLevel = new JButton("Save level");
		btnSaveLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnSaveLevel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSaveLevel.setBounds(520, 427, 112, 29);
		getContentPane().add(btnSaveLevel);
	}

	public char[][] drawBoard(int nRows, int nColumns){
		char[][] b= new char[nRows][nColumns];

		for(int i=0; i < nRows; i++){
			for(int j=0; j < nColumns; j++){
				b[i][j]= ' ';
			}
		}
		return b;
	}

	private Image getImage(char c) {
		try{
			switch(c){
			case 'H': return ImageIO.read(new File("images/jerryFront.png"));
			case 'X': return ImageIO.read(new File("images/wall.png"));
			case 'I': return ImageIO.read(new File("images/door.png"));
			case 'S': return ImageIO.read(new File("images/openDoor.png"));
			case 'O': return ImageIO.read(new File("images/droopy.png"));
			case 'A': return ImageIO.read(new File("images/tomA.png"));
			case 'g': return ImageIO.read(new File("images/tomsleep.png"));
			case 'G': return ImageIO.read(new File("images/tomFront.png"));
			case 'k': return ImageIO.read(new File("images/cheese.png"));
			case 'K': return ImageIO.read(new File("images/tomK.png"));
			case '*': return ImageIO.read(new File("images/bone.png"));
			case '8': return ImageIO.read(new File("images/stunned.png"));
			case ' ': return ImageIO.read(new File("images/floor.png"));
			case '$': return ImageIO.read(new File("images/cifrao.png"));
			default: return defaulti;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void createBoardToFile(){

		for(int i=0; i < board.length;i++){
			for(int j=0; j< board[0].length;j++){
				try {
					fw.write(board[i][j]+"");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
