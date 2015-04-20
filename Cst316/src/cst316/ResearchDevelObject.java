package cst316;
/**
 * 
 * Description: A research or development object that has has different
 * attributes depending on what ResearchAndDevelopment.class decided
 * for it. The player can purchase these objects and obtain them.
 * 
 * @author daniel
 *
 */

public class ResearchDevelObject {
	int cost; //How much does this object cost to get?
	int pointWorth; //Add this value to the player's points
	String name;
	
	/**
	 * Default constructor, blank object
	 */
	public ResearchDevelObject() {
		this.setCost(0);
		this.setPointWorth(0);
		this.setName("blank");
		
	}
	
	/**
	 * Set the object based on constructor values
	 * @param cost
	 * @param pointWorth
	 * @param name
	 */
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
