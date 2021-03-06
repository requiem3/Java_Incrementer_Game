package systems;

public class ZoneSystem {
	public int[][] zones;
	private int zoneLength;
	
	public ZoneSystem() {
		zoneLength = 5;
		zones = new int[zoneLength][3];
		
		//Zone 1
		zones[0][0] = 2; // base hp
		zones[0][1] = 1; //base cash
		zones[0][2] = 100; //base exp
		
		zones[1][0] = 2;
		zones[1][1] = 1;
		zones[1][2] = 1;
		
		zones[2][0] = 2;
		zones[2][1] = 1;
		zones[2][2] = 1;
		
		zones[3][0] = 2;
		zones[3][1] = 1;
		zones[3][2] = 1;
		
		zones[4][0] = 2;
		zones[4][1] = 1;
		zones[4][2] = 1;
	}
}
