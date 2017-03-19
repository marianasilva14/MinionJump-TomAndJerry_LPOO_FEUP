package dkeep.gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import dkeep.logic.Board;
import dkeep.logic.Drunken;
import dkeep.logic.Entity;
import dkeep.logic.Game;
import dkeep.logic.Guard;
import dkeep.logic.Game.Direction;
import dkeep.logic.Hero;
import dkeep.logic.Level;
import dkeep.logic.Ogre;
import dkeep.logic.Drunken.StateDrunken;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Graphic {


	static char[][] level1 = {{'X','X','X','X','X','X','X','X','X','X'},
			{'X','H',' ',' ','I',' ','X',' ','G','X'},
			{'X','X','X',' ','X','X','X',' ',' ','X'},
			{'X',' ','I',' ','I',' ','X',' ',' ','X'},
			{'X','X','X',' ','X','X','X',' ',' ','X'},
			{'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X','X','X',' ','X','X','X','X',' ','X'},
			{'X',' ','I',' ','I',' ','X','k',' ','X'},
			{'X','X','X','X','X','X','X','X','X','X'}};

	static char[][] level2 = {{'X','X','X','X','X','X','X','X','X','X'},
			{'I','H',' ',' ',' ',' ','O',' ','k','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X','X','X','X','X','X','X','X','X','X'}};

	private JFrame frame;
	private JTextField numberOfOgres;
	private JTextArea textArea = new JTextArea();
	private JButton btnRight;
	private JButton btnUp;
	private JButton btnLeft;
	private JButton btnDown;
	private JButton btnNewGame;
	private JComboBox comboBox;
	private JLabel lblNumberOfOgres;
	private Board board;
	private Level level;
	private Game game;
	private GameGraphics game_graphics;
	private int guardType;
	private int nrOfOgres;

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

		lblNumberOfOgres = new JLabel("Number of Ogres");
		lblNumberOfOgres.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumberOfOgres.setBounds(10, 11, 121, 33);
		frame.getContentPane().add(lblNumberOfOgres);


		numberOfOgres = new JTextField();
		numberOfOgres.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				try{
					Integer.parseInt(numberOfOgres.getText());
				}
				catch(NumberFormatException e){
					e.printStackTrace();
					textArea.setText("Invalid number of ogres");
					numberOfOgres.setText("0");
					return;
				}
				if(Integer.parseInt(numberOfOgres.getText()) > 5){
					numberOfOgres.setText("5");
					nrOfOgres = 5;
				}
				if(Integer.parseInt(numberOfOgres.getText()) < 1){
					numberOfOgres.setText("1");
					nrOfOgres = 1;
				}

				nrOfOgres = Integer.parseInt(numberOfOgres.getText());
			}
		});
		numberOfOgres.setBounds(139, 17, 91, 20);
		frame.getContentPane().add(numberOfOgres);
		numberOfOgres.setColumns(10);

		JLabel lblNewLabel = new JLabel("Guard personality");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(20, 55, 91, 20);
		frame.getContentPane().add(lblNewLabel);

		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardType = comboBox.getSelectedIndex();
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Suspicious", "Drunken", "Rookie"}));
		comboBox.setBounds(139, 55, 127, 20);
		frame.getContentPane().add(comboBox);

		JButton blbExit = new JButton("Exit");
		blbExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		blbExit.setBounds(516, 384, 89, 23);
		frame.getContentPane().add(blbExit);
		textArea.setEditable(false);

		textArea.setBounds(24, 97, 369, 307);
		frame.getContentPane().add(textArea);
		textArea.setFont(new Font("monospaced", Font.PLAIN, 22)); //definir tipo de letra e tamanho

		btnRight = new JButton("Right");
		btnRight.setEnabled(false);
		btnRight.setBounds(552, 214, 90, 28);
		frame.getContentPane().add(btnRight);

		btnLeft = new JButton("Left");
		btnLeft.setEnabled(false);
		btnLeft.setBounds(439, 214, 90, 28);
		frame.getContentPane().add(btnLeft);

		btnDown = new JButton("Down");
		btnDown.setEnabled(false);
		btnDown.setBounds(500, 253, 90, 28);
		frame.getContentPane().add(btnDown);

		btnUp = new JButton("Up");
		btnUp.setEnabled(false);
		btnUp.setBounds(500, 174, 90, 28);
		frame.getContentPane().add(btnUp);
		
		btnNewGame = new JButton("New Game");
		btnNewGame.setBounds(310, 54, 102, 23);
		frame.getContentPane().add(btnNewGame);


		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){

				for(int i=0; i < level.getEntities().size();i++){
					level.getEntities().get(i).movement(Direction.RIGHT, level.getBoard());
					if(level.getEntities().get(i) instanceof Ogre)
						((Ogre)level.getEntities().get(i)).club(game.getLevel().getBoard());
				}

				gameLogic();
			}
		});



		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for(int i=0; i < level.getEntities().size();i++){
					level.getEntities().get(i).movement(Direction.LEFT, level.getBoard());
					if(level.getEntities().get(i) instanceof Ogre)
						((Ogre)level.getEntities().get(i)).club(game.getLevel().getBoard());
				}

				gameLogic();
			}

		});

		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for(int i=0; i < level.getEntities().size();i++){
					level.getEntities().get(i).movement(Direction.DOWN, level.getBoard());
					if(level.getEntities().get(i) instanceof Ogre)
						((Ogre)level.getEntities().get(i)).club(game.getLevel().getBoard());
				}

				gameLogic();
			}
		});


		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for(int i=0; i < level.getEntities().size();i++){
					level.getEntities().get(i).movement(Direction.UP, level.getBoard());
					if(level.getEntities().get(i) instanceof Ogre)
						((Ogre)level.getEntities().get(i)).club(game.getLevel().getBoard());
				}


				gameLogic();
			}
		});
		
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				board = new Board(level1);
				level= new Level(board, guardType);
				game = new Game(level);

				checkButtons();
				printBoard();

			}
		});
	


		JLabel lblYouCanStart = new JLabel("You can start a new game");
		lblYouCanStart.setBounds(34, 396, 359, 49);
		frame.getContentPane().add(lblYouCanStart);

	}

	public void printBoard(){
		String gamestring="";
		char[][] map = new char[10][10];

		int row = game.getLevel().getBoard().getBoard().length;
		int col = game.getLevel().getBoard().getBoard()[0].length;

		ArrayList<Entity> e = game.getLevel().getEntities();
		if(game.getLevel().getBoard().checkLimits(e.get(0)))
			game.checkLever(e.get(0), game.getLevel());

		for(int i=0; i < e.size(); i++)
			game.entityLever(e.get(i), game.getLevel());

		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				map[i][j] = game.getLevel().getBoard().getBoard()[i][j];
			}
		}

		for(int i=0; i < e.size();i++){
			if(e.get(i) instanceof Guard){
				if(e.get(i) instanceof Drunken){
					if(((Drunken)e.get(i)).getState() == StateDrunken.G)
						map[e.get(i).getPosx()][e.get(i).getPosy()]=e.get(i).getSymbol();
					else{
						game.getLevel().getEntities().get(i).setSymbol('g');
						map[e.get(i).getPosx()][e.get(i).getPosy()]=e.get(i).getSymbol();
					}
				}
				else
					map[e.get(i).getPosx()][e.get(i).getPosy()]=e.get(i).getSymbol();
			}
			else
				map[e.get(i).getPosx()][e.get(i).getPosy()]=e.get(i).getSymbol();
		}

		for(int i=0; i< map.length;i++){
			for(int j=0; j < map[0].length;j++){
				gamestring+=map[i][j]+ " ";
			}
			gamestring+='\n';
		}

		gamestring += "\n";

		textArea.setText(gamestring);

	}

	public void checkButtons(){

		Entity hero = game.getLevel().getEntities().get(0);
		Hero h = (Hero)hero;

		if(game.getLevel().getBoard().checkLimits(h)){

			if(!h.checkIfMovementIsValid(Direction.UP, game.getLevel().getBoard()))
				btnUp.setEnabled(false);
			else
				btnUp.setEnabled(true);

			if(!h.checkIfMovementIsValid(Direction.DOWN, game.getLevel().getBoard()))
				btnDown.setEnabled(false);
			else
				btnDown.setEnabled(true);

			if(!h.checkIfMovementIsValid(Direction.LEFT, game.getLevel().getBoard()))
				btnLeft.setEnabled(false);
			else
				btnLeft.setEnabled(true);

			if(!h.checkIfMovementIsValid(Direction.RIGHT, game.getLevel().getBoard()))
				btnRight.setEnabled(false);
			else
				btnRight.setEnabled(true);
		}

	}

	public void gameLogic(){

		printBoard();

		for(int i=1; i < game.getLevel().getEntities().size();i++){
			if(game.getLevel().checkIfEnds(game.getLevel().getEntities().get(0),game.getLevel().getEntities().get(i))){
				btnUp.setEnabled(false);
				btnDown.setEnabled(false);
				btnRight.setEnabled(false);
				btnLeft.setEnabled(false);
				textArea.setText("You got caught!!");
				return;
			}
		}
		
		game.cleanClub(game.getLevel().getBoard());	
		
		if(game.changeLevel(game.getLevel().getEntities().get(0), game.getLevel())){

			int ogres=1;

			if(game.getLevel().getLevel() == 1){
				board = new Board(level2);
				level = new Level(board, guardType);
				game = new Game(level);
				game.getLevel().getEntities().get(0).setSymbol('A');

				while(ogres != nrOfOgres) {
					Ogre o = new Ogre(1,4);
					game.getLevel().getEntities().add(o);
					ogres++;
				}
			}
			else{
				btnUp.setEnabled(false);
				btnDown.setEnabled(false);
				btnRight.setEnabled(false);
				btnLeft.setEnabled(false);
				textArea.setText("You won!!");
				return;
			}

		}
		else
			checkButtons();
	}
}
