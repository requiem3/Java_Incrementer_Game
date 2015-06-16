package systems;

public class ArmySystem {
	public int[][] army;
	private int armyLength;
	
	public ArmySystem() {
		armyLength = 7;
		army = new int[armyLength][3];
		
		//Maniacal Chicken
		army[0][0] = 1; //count
		army[0][1] = 1; //base DPS
		army[0][2] = 1; //base cost
		
		//Poisonous Blob
		army[1][0] = 0;
		army[1][1] = 1;
		army[1][2] = 1;
		
		//Robot Dog
		army[2][0] = 0;
		army[2][1] = 1;
		army[2][2] = 1;
		
		//Zombie
		army[3][0] = 0;
		army[3][1] = 1;
		army[3][2] = 1;
		
		//Robot Walker
		army[4][0] = 0;
		army[4][1] = 1;
		army[4][2] = 1;

		//Robot Sniper
		army[5][0] = 0;
		army[5][1] = 1;
		army[5][2] = 1;
		
		//Doom Bot
		army[6][0] = 0;
		army[6][1] = 1;
		army[6][2] = 1;

		System.out.println(army[0][0]);
	}
	
	public int calculateDPS() {
		int finalDPS = 0;
		for(int i = 0; i < armyLength; i++) {
			finalDPS += army[i][0] * army[i][1];
		}
		return(finalDPS);
	}
}
