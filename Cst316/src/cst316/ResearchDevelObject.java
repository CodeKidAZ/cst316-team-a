package cst316;

public class ResearchDevelObject {
	int cost; //How much does this object cost to get?
	int pointWorth; //Add this value to the player's points
	String name;
	
	public ResearchDevelObject() {
		this.setCost(0);
		this.setPointWorth(0);
		this.setName("blank");
		
	}
	
	public ResearchDevelObject(int cost, int pointWorth, String name) {
		this.setCost(cost);
		this.setPointWorth(pointWorth);
		this.setName(name);
	}
	
	
	//Getters and Setters
	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getPointWorth() {
		return pointWorth;
	}

	public void setPointWorth(int pointWorth) {
		this.pointWorth = pointWorth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
