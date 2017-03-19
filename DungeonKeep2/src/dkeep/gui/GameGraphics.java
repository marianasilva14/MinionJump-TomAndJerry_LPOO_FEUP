package dkeep.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GameGraphics extends JPanel{

	private final int width=40, height=40;

	private BufferedImage hero;
	private BufferedImage ogre;
	private BufferedImage lever;
	private BufferedImage club;
	private BufferedImage floor;
	private BufferedImage guard;
	private BufferedImage wall;
	private BufferedImage guard_asleep;
	private BufferedImage door;
	private BufferedImage open_door;
	private BufferedImage hero_armed;
	private BufferedImage hero_a;
	private BufferedImage ogre_lever;
	private BufferedImage defaulti;
	private String boardToString= null;

	public GameGraphics(){
		super();
		try {
			hero =  ImageIO.read(new File("images/jerryFront.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			floor =  ImageIO.read(new File("images/floor.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			wall =  ImageIO.read(new File("images/wall.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			guard =  ImageIO.read(new File("images/tomFront.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			lever =  ImageIO.read(new File("images/cheese.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			door =  ImageIO.read(new File("images/door.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}


		try {
			guard_asleep =  ImageIO.read(new File("images/tomsleep.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			ogre =  ImageIO.read(new File("images/droopy.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			club =  ImageIO.read(new File("images/bone.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			hero_armed =  ImageIO.read(new File("images/tomK.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			hero_a =  ImageIO.read(new File("images/tomA.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			open_door =  ImageIO.read(new File("images/openDoor.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Image getImage(char c) {
		switch(c){
		case 'H': return hero;
		case 'X': return wall;
		case 'I': return door;
		case 'S': return open_door;
		case 'O': return ogre;
		case 'A': return hero_a;
		case 'g': return guard_asleep;
		case 'G': return guard;
		case 'k': return lever;
		case 'K': return hero_armed;
		case '*': return club;
		//    case '8': return stunnedOgre;
		case ' ': return floor;
		//case '$': return 
		default: return defaulti;
		}
	}

	public void updateGame(String string){
		boardToString =string;
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int x=0;
		int y=0;
		if(boardToString == null){
			g.drawRect(0, 0, 50, 50);
			return;
		}
		for(int i =0; i < boardToString.length();i++){
			if(boardToString.charAt(i)=='\n'){
				y++;
				x=0;
				continue;
			}
			g.drawImage(getImage(boardToString.charAt(i)),x*32,y*32,32,32,null);
			x++;
		}
	}
}
