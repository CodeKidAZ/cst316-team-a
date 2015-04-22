/**
 * Representation of a company's marketing campaign.
 * 
 * @author  Wesley Coomber
 * @version 1.0
 */
package cst316;

import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;
import org.json.JSONTokener;

public class MarketingCamp {
    
    /**
     * Marketing Campaigns have a name, a power, a isGood boolean, and a total cost;
     */
    private String name;
	private double power;
	private boolean isGood = false;
	private static Random random = new Random();
    private double totalCost;
    
    
	public MarketingCamp() {
		super();
		this.name = "default";
		this.power = -1;
		this.isGood = true;
		this.totalCost = -1;
	}
    
	/**
	 * @param name
	 * @param power
	 * @param isGood
	 * @param totalCost
	 */
	public MarketingCamp(String name, double power, boolean isGood,
			double totalCost) {
		super();
		this.name = name;
		this.power = power;
		this.isGood = isGood;
		this.totalCost = totalCost;
	}
    
    /**Similar to the Calculate ROI on the investment.java class, except instead of affecting player's money, this affect's company's marketPower
     * 
     * @return a random double value between +0.31 and +0.01 if isGood = true, if not then returns a random double value between -0.01 and -0.61
     */
    public double calculateReturnPower() {
		if(isGood){
			// Between 1% and 31%
			power = ((random.nextDouble() * 30) + 1)/100;
		}else{
			// Between -51% and -1%
			power = ((random.nextDouble() * 30) - 31)/100;
		}
		return power;
		
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the power
	 */
	public double getPower() {
		return power;
	}

	/**
	 * @param power the power to set
	 */
	public void setPower(double power) {
		this.power = power;
	}

	/**
	 * @return the isGood
	 */
	public boolean isGood() {
		return isGood;
	}

	/**
	 * @param isGood the isGood to set
	 */
	public void setGood(boolean isGood) {
		this.isGood = isGood;
	}

	/**
	 * @return the totalCost
	 */
	public double getTotalCost() {
		return totalCost;
	}

	/**
	 * @param totalCost the totalCost to set
	 */
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

    
}
