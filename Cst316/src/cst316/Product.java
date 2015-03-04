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

public class Product implements JSONString {
    
    /**
     * Product name. This is out of the fixed set of available product types
     * defined in products.json.
     */
    private String name;

    private double totalFixedCost;
    private double totalMarginalCost;
    private double marginalToFixed;
    
    /**
     * @param name              Must exist in products.json
     * @param totalFixedCost    Amount of money invested in fixed capital.
     * @param totalMarginalCost Amount of money invested in consumed capital.
     */
    public Product(String name, double totalFixedCost, double totalMarginalCost) throws Exception {
        this.name              = name;
        this.totalFixedCost    = totalFixedCost;
        this.totalMarginalCost = totalMarginalCost;
        this.loadCommonAttributes();
    }

    /**
     * @param name              Must exist in products.json
     * @param totalFixedCost    Amount of money invested in fixed capital.
     * @param totalMarginalCost Amount of money invested in consumed capital.
     */
    public Product(JSONObject jsonObject) throws Exception {
        this.name              = jsonObject.getString("Name");
        this.totalFixedCost    = jsonObject.getDouble("TotalFixedCost");
        this.totalMarginalCost = jsonObject.getDouble("TotalMarginalCost");
        this.loadCommonAttributes();
    }

    private void loadCommonAttributes() throws Exception {
        JSONTokener tokener = new JSONTokener(this.getClass().getClassLoader().getResourceAsStream("res/products.json"));
        JSONObject allProducts = new JSONObject(tokener);
        JSONObject myProduct   = allProducts.getJSONObject(name);
        this.marginalToFixed   = myProduct.getDouble("MarginalToFixed");
    }
    
    /**
     * Makes a JSON string of the player data
     * @return ret 
     */
    public String toJSONString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Name", this.name);
        jsonObject.put("TotalFixedCost", this.totalFixedCost);
        jsonObject.put("TotalMarginalCost", this.totalMarginalCost);
        return jsonObject.toString(); //Return the JSON string
    }

    public void setTotalMarginalCost(double totalMarginalCost) {
        this.totalMarginalCost = totalMarginalCost;
    }

    public double getTotalMarginalCost() {
        return this.totalMarginalCost;
    }

    public void setTotalFixedCost(double totalFixedCost) {
        this.totalFixedCost = totalFixedCost;
    }

    public double getTotalFixedCost() {
        return this.totalFixedCost;
    }

    public double getMarginalToFixed() {
        return this.marginalToFixed;
    }

    public String getName() {
        return this.name;
    }

    /**
     * Calculate the total average cost, given a quantity.
     * This uses the fixed amount spent, and the amount spent on each item.
     * This is the minimum amount the player can charge to break even,
     * considering all involved costs.
     *
     * @param quantity  The amount of items being sold.
     */
    public double getTotalAverageCost(int quantity) {
        if (quantity == 0) {
            throw new IllegalArgumentException("Cannot calculate average cost of zero quantity.");
        }
        double total = (quantity * this.totalMarginalCost) + this.totalFixedCost;
        return total / quantity;
    }
    
    public static String[] getAllProductNames() {
        JSONTokener tokener = new JSONTokener(Product.class.getClassLoader().getResourceAsStream("res/products.json"));
        JSONObject allProducts = new JSONObject(tokener);
        String[] allProductNames = new String[allProducts.length()];
        int i = 0;
        for (String s : allProducts.keySet()) {
        	allProductNames[i] = s;
        	i += 1;
        }
        return allProductNames;
    }
}
