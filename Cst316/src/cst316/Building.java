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

public class Building implements JSONString {
    
    /**
     * Building type name. This is out of the fixed set of available product types
     * defined in buildings.json.
     */
    private String name;

    private double totalCost;
    private String image;
    private String description;
    
    /**
     * @param name              Must exist in products.json
     * @param totalFixedCost    Amount of money invested in fixed capital.
     * @param totalMarginalCost Amount of money invested in consumed capital.
     */
    public Building(String name) throws Exception {
        this.name              = name;
        this.loadCommonAttributes();
    }

    /**
     * @param name              Must exist in products.json
     * @param totalFixedCost    Amount of money invested in fixed capital.
     * @param totalMarginalCost Amount of money invested in consumed capital.
     */
    public Building(JSONObject jsonObject) throws Exception {
        this.name              = jsonObject.getString("Name");
        this.loadCommonAttributes();
    }

    private void loadCommonAttributes() throws Exception {
        JSONTokener tokener    = new JSONTokener(this.getClass().getClassLoader().getResourceAsStream("res/buildings.json"));
        JSONObject allProducts = new JSONObject(tokener);
        JSONObject myProduct   = allProducts.getJSONObject(name);
        this.totalCost   = myProduct.getDouble("TotalCost");
        this.image       = myProduct.getString("Image");
        this.description = myProduct.getString("Description");
    }
    
    /**
     * Makes a JSON string of the player data
     * @return ret 
     */
    public String toJSONString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Name", this.name);
        return jsonObject.toString(); //Return the JSON string
    }

    public double getTotalCost() {
        return this.totalCost;
    }
    
    public String getImage() {
    	return this.image;
    }

    public String getName() {
        return this.name;
    }
    
    public String getDescription() {
    	return this.description;
    }
    
    public static String[] getAllBuildingNames() {
        JSONTokener tokener = new JSONTokener(Building.class.getClassLoader().getResourceAsStream("res/buildings.json"));
        JSONObject allBuildings = new JSONObject(tokener);
        String[] allBuildingNames = new String[allBuildings.length()];
        int i = 0;
        for (String s : allBuildings.keySet()) {
        	allBuildingNames[i] = s;
        	i += 1;
        }
        return allBuildingNames;
    }
}
