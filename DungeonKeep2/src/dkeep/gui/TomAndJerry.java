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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TomAndJerry {

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
	private JButton btnRight;
	private JButton btnUp;
	private JButton btnLeft;
	private JButton btnDown;
	private JComboBox comboBox;
	private JLabel lblNumberOfOgres;
	private Board board;
	private Level level;
	private Game game;
	private JButton btnNewGame;
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
					TomAndJerry window = new TomAndJerry();
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
	public TomAndJerry() {
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
		frame.setFocusable(true);
		
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				int keyCode = e.getKeyCode();
				switch( keyCode ) { 
				case KeyEvent.VK_UP: move(Direction.UP); break;
				case KeyEvent.VK_DOWN: move(Direction.DOWN); break;
				case KeyEvent.VK_RIGHT: move(Direction.RIGHT); break;
				case KeyEvent.VK_LEFT: move(Direction.LEFT); break;
				}
			}
		});

		game_graphics = new GameGraphics();
		game_graphics.setBounds(20,86,320,320);
		frame.getContentPane().add(game_graphics);

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
					//	textArea.setText("Invalid number of ogres");
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


		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				move(Direction.RIGHT);
			}
		});



		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				move(Direction.LEFT);
			}

		});

		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				move(Direction.DOWN);
			}
		});


		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				move(Direction.UP);
			}
		});

		btnNewGame = new JButton("New Game");
		btnNewGame.setBounds(310, 54, 102, 23);
		frame.getContentPane().add(btnNewGame);

		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.requestFocusInWindow ();
				board = new Board(level1);
				level= new Level(board, guardType);
				game = new Game(level);

				checkButtons();
				game_graphics.updateGame(game.getLevel().getBoard().printBoardToString(game));

			}
		});



		JLabel lblYouCanStart = new JLabel("You can start a new game");
		lblYouCanStart.setBounds(34, 396, 359, 49);
		frame.getContentPane().add(lblYouCanStart);

	}

	public void move(Direction direction){

		for(int i=0; i < level.getEntities().size();i++){
			level.getEntities().get(i).movement(direction, level.getBoard());
			if(level.getEntities().get(i) instanceof Ogre)
				((Ogre)level.getEntities().get(i)).club(game.getLevel().getBoard());
		}

		gameLogic();
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

		game_graphics.updateGame(game.getLevel().getBoard().printBoardToString(game));

		for(int i=1; i < game.getLevel().getEntities().size();i++){
			if(game.getLevel().checkIfEnds(game.getLevel().getEntities().get(0),game.getLevel().getEntities().get(i))){
				btnUp.setEnabled(false);
				btnDown.setEnabled(false);
				btnRight.setEnabled(false);
				btnLeft.setEnabled(false);
				game_graphics.updateGame(null);
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
				//g.drawImage(getImage(boardToString.charAt(i)),x*32,y*32,32,32,null);
				return;
			}

		}
		else
			checkButtons();
	}
}
