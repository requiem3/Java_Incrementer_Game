package systems;

public class NumberSystem {
	private int cash;
	private int level;
	private int expReq;
	private int exp;
	
	public NumberSystem() {
		cash = 0;
		exp = 0;
		level = 1;
		
		setReq();
	}
	
	public void addCash(int i) {
		cash += i;
	}
	
	public int getCash() {
		return(cash);
	}
	
	public void addLevel(int i) {
		level += i;
	}
	
	public int getLevel() {
		return(level);
	}
	
	public void addExp(int i) {
		exp += i;
		while(exp >= expReq){
			addLevel(1);
			exp -= expReq;
			setReq();
		}
	}
	
	public int getExp() {
		return(exp);
	}
	
	public boolean buy(int cost) {
		if(cost > cash) {
			return(false);
		}
		cash -= cost;
		return(true);
	}
	
	public int calculateCost(int baseCost, int count) {
		double temp = baseCost * (Math.pow(1.06, count));
		return((int)temp);
	}
	
	private void setReq() {
		expReq = (int)Math.pow(level, 2);
	}
	
	public int getExpReq() {
		return(expReq);
	}
}
