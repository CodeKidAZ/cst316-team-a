/**
 * Representation of a player's product. In a Player, they're represented by
 * name, and the class loads it from the common store.
 * 
 * @author  Michael Howell
 * @version 1.0
 */
package cst316;

import org.json.JSONObject;
import org.json.JSONString;
import org.json.JSONTokener;

public class MCamp {
    
    /**
     * Generic MCamp class that all the types of marketing campaigns are based off of.
     */
    private String name;
	private double totalCost;
    private String image;
    private String description;
    

    /**
	 * @param name
	 * @param totalCost
	 * @param image
	 * @param description
	 */
	public MCamp(String name, double totalCost, String image, String description) {
		super();
		this.name = name;
		this.totalCost = totalCost;
		this.image = image;
		this.description = description;
	}
	
	public MCamp(String name) {
		super();
		this.name = name;
		this.totalCost = genCost(name);
		this.image = "res/"+name+".gif";
		this.description = genDescript(name);
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @param nameT
	 * @return a string description of the corresponding MCamp type name that is passed in.
	 */
	private String genDescript(String nameT){
		String descript = "";
		if (nameT.equals("Print Marketing")){
			descript = "HEEELLLOOModerately expensive and moderately reliable form of Marketing. +5MP to +15";
		}
		if (nameT.equals("Coupon Marketing")){
			descript = "A more expensive and more reliable form of Marketing. +15 MP to +20 MP";
		}
		if (nameT.equals("WWITM Marketing")){
			descript = "The Cheapest Marketing option, and the most unreliable. The 'Wacky Waving Inflatable Tube Man' is either hit or miss with the audience. -10 MP to +40 MP";
		}
		if (nameT.equals("Television Marketing")){
			descript = "The Most Expensive Marketing option, and the most reliable form of marketing. +33 MP to +35 MP";
		}
		return descript;
	}
		
		/**
		 * @param nameT
		 * @return a double value cost of the corresponding MCamp type name that is passed in.
		 */
		private double genCost(String nameT){
			double cost = -1;
			if (nameT.equals("Print Marketing")){
				cost = 100;
			}
			if (nameT.equals("Coupon Marketing")){
				cost = 200;
			}
			if (nameT.equals("WWITM Marketing")){
				cost = 50;
			}
			if (nameT.equals("Television Marketing")){
				cost = 275;
			}
		
		
		return cost;
		
	}

	/**
	 * @param totalCost the totalCost to set
	 */
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}



    /**
     * @return MCamp's totalcost as a double value
     */
    public double getTotalCost() {
        return this.totalCost;
    }
    
    /**
     * @return string of the image's path to the image file
     */
    public String getImage() {
    	return this.image;
    }

    /**
     * @return return MCamp's name as a string value
     */
    public String getName() {
        return this.name;
    }
    
    public String getDescription() {
    	return this.description;
    }
    
}
