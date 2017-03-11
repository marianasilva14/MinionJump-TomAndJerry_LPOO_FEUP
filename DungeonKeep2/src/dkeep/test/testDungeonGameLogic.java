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

	

}
