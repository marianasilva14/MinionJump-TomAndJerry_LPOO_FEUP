package dkeep.test;
import org.junit.Test;
import static org.junit.Assert.*;
import dkeep.logic.*;
import dkeep.logic.Game.Direction;

public class testBehaviorOgre {
	
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

}
