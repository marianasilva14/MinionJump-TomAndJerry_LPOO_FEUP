package dkeep.logic;
import dkeep.logic.Entity;

public class Guard extends Entity{

	BehaviorGuard behGuard;
	
	Guard(BehaviorGuard bg){
		
		behGuard = bg;
	}
	
	public void movement(){
		
		behGuard.movement();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
