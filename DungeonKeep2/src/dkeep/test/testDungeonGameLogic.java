package dkeep.test;
import org.junit.Test;
import static org.junit.Assert.*;
import dkeep.logic.*;
import dkeep.logic.Game.Direction;

public class testDungeonGameLogic {

	char[][] map = {
			{'X','X','X','X','X'},
			{'X','H',' ','G','X'},
			{'I',' ',' ',' ','X'},
			{'I','k',' ',' ','X'},
			{'X','X','X','X','X'}
	};
	
	char[][] map2 ={ {'X','X','X','X','X'},
			{'X','H',' ','O','X'},
			{'I',' ',' ',' ','X'},
			{'I','k',' ',' ','X'},
			{'X','X','X','X','X'}
	};
	
	@Test
	public void testMoveHeroIntoToFreeCell(){
		Board board = new  Board(map);
		Level level = new Level(board);
		assertEquals(1,level.getEntities().get(0).getPosx());
		assertEquals(1,level.getEntities().get(0).getPosy());
		Direction direction = Direction.DOWN;
		level.getEntities().get(0).movement(direction);
		assertEquals(2,level.getEntities().get(0).getPosx());
		assertEquals(1,level.getEntities().get(0).getPosy());
	}
	
	@Test
	public void testHeroIsCapturedByGuard(){
		Board board= new Board(map);
		Level level = new Level(board);
		Game game= new Game(level);
		assertFalse(game.getLevel().checkIfEnds(game.getLevel().getEntities().get(0),game.getLevel().getEntities().get(1) ));
		Direction direction = Direction.RIGHT;
		game.getLevel().getEntities().get(0).movement(direction);
		assertTrue(game.getLevel().checkIfEnds(game.getLevel().getEntities().get(0),game.getLevel().getEntities().get(1) ));
		
	}
	
	@Test
	public void testAdjacentPositionOgre(){
		Board board= new Board(map2);
		Level level = new Level(board);
		Game game= new Game(level);
		assertFalse(game.getLevel().checkIfEnds(game.getLevel().getEntities().get(0),game.getLevel().getEntities().get(1) ));
		Direction direction = Direction.RIGHT;
		game.getLevel().getEntities().get(0).movement(direction);
		assertTrue(game.getLevel().checkIfEnds(game.getLevel().getEntities().get(0),game.getLevel().getEntities().get(1)));
	}
	
	@Test
	public void testExitDoorKeyCell(){
		Board board= new Board(map);
		Level level = new Level(board);
		Game game= new Game(level);
		game.entityLever(game.getLevel().getEntities().get(0), game.getLevel());
		assertEquals('H',game.getLevel().getEntities().get(0).getSymbol());
		Direction direction = Direction.DOWN;
		game.getLevel().getEntities().get(0).movement(direction);
		game.getLevel().getEntities().get(0).movement(direction);
		assertTrue(game.entityLever(game.getLevel().getEntities().get(0), game.getLevel()));
		assertEquals('K',game.getLevel().getEntities().get(0).getSymbol());
	}
	
	@Test
	public void testFailsToOpenWithoutTheKey(){
		Board board= new Board(map);
		Level level = new Level(board);
		Game game= new Game(level);
		Direction direction = Direction.DOWN;
		game.getLevel().getEntities().get(0).movement(direction);
		direction = Direction.LEFT;
		game.getLevel().getEntities().get(0).movement(direction);
		assertTrue(game.invalidMovement(game.getLevel().getEntities().get(0), game.getLevel()));
	}
	
	@Test
	public void testOpenDoorWithKey(){
		Board board= new Board(map);
		Level level = new Level(board);
		Game game= new Game(level);
		Direction direction = Direction.DOWN;
		game.getLevel().getEntities().get(0).movement(direction);
	    direction = Direction.DOWN;
		game.getLevel().getEntities().get(0).movement(direction);
		game.entityLever(game.getLevel().getEntities().get(0), game.getLevel());
		game.checkLever(game.getLevel().getEntities().get(0), game.getLevel());
		//direction = Direction.LEFT;
		//game.getLevel().getEntities()[0].movement(direction);
		//assertTrue(game.changeLevel(level.getEntities()[0], game.getLevel()));
		assertEquals('S', map[2][0]);
	}
	
	@Test
	public void testWinGame(){
		Board board= new Board(map);
		Level level = new Level(board);
		Game game= new Game(level);
		Direction direction = Direction.DOWN;
		game.getLevel().getEntities().get(0).movement(direction);
	    direction = Direction.DOWN;
		game.getLevel().getEntities().get(0).movement(direction);
		game.entityLever(game.getLevel().getEntities().get(0), game.getLevel());
		game.checkLever(game.getLevel().getEntities().get(0), game.getLevel());
		direction = Direction.LEFT;
		game.getLevel().getEntities().get(0).movement(direction);
		assertTrue(game.changeLevel(level.getEntities().get(0), game.getLevel()));
	}
	
	@Test
	public void testIfChangeLeverTo$(){
		Board board= new Board(map2);
		Level level = new Level(board);
		Game game= new Game(level);
		level.getEntities().get(1).setPosx(3);
		level.getEntities().get(1).setPosy(1);
		game.entityLever(game.getLevel().getEntities().get(1), game.getLevel());
		assertEquals('$',level.getEntities().get(1).getSymbol());
		level.getEntities().get(1).setPosx(3);
		level.getEntities().get(1).setPosy(2);
		game.entityLever(game.getLevel().getEntities().get(1), game.getLevel());
		assertEquals('O',level.getEntities().get(1).getSymbol());
	}

	@Test(timeout=1000)
	public void testSomeRandomBehavior(){
		Ogre g = new Ogre(5,5);
		int x_old = g.getPosx();
		int y_old = g.getPosy();
		boolean outcome1=false, outcome2=false, outcome3 = false, outcome4 = false;
		while(!outcome1 || !outcome2 || !outcome3 || !outcome4){
			g.movement(null);
			//cima
			if(g.getPosx() == x_old - 1){
				outcome1=true;
				x_old = g.getPosx();
			}
			//baixo
			else if(g.getPosx() == x_old + 1){
				outcome2=true;
				x_old = g.getPosx();
			}
			//direita
			else if(g.getPosy() == y_old - 1){
				outcome3=true;
				y_old = g.getPosy();
			}
			//esquerda
			else{
				outcome4=true;
				y_old = g.getPosy();
			}
		}
		
		assertTrue(outcome1);
		assertTrue(outcome2);
		assertTrue(outcome3);
		assertTrue(outcome4);
	}
	
	@Test
	public void testIfClubMovementIsCorrect(){
		Board board= new Board(map2);
		Level level = new Level(board);
		Game game= new Game(level);
		level.getEntities().get(1).setPosx(3);
		level.getEntities().get(1).setPosy(1);
		game.entityLever(game.getLevel().getEntities().get(1), game.getLevel());
		assertEquals('$',level.getEntities().get(1).getSymbol());
		level.getEntities().get(1).setPosx(3);
		level.getEntities().get(1).setPosy(2);
		game.entityLever(game.getLevel().getEntities().get(1), game.getLevel());
		assertEquals('O',level.getEntities().get(1).getSymbol());
	}

}
