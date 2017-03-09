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
	
	@Test
	public void testeMoveHeroIntoToFreeCell(){
		Board board = new  Board(map);
		Level level = new Level(board);
		Game game= new Game(level);
		assertEquals(1,level.getEntities()[0].getPosx());
		assertEquals(1,level.getEntities()[0].getPosy());
		Direction direction = Direction.DOWN;
		level.getEntities()[0].movement(direction);
		assertEquals(2,level.getEntities()[0].getPosx());
		assertEquals(1,level.getEntities()[0].getPosy());
	}

}
