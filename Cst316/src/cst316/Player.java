/**
 * Description: This class's purpose is to store player's data and
 * be able to retrieve or manipulate any field using the given methods.
 * This class supports exporting and importing JSON files as a saving/loading feature.
 * 
 * Note: When importing the JSON data, be sure to prompt a player for their name.
 * The "load" method is dependent on knowing the name of the JSON file.
 * 
 * @author  Daniel Tracy
 * @version 1.0
 */
package cst316;

import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;
import org.json.JSONTokener;

public class Player implements JSONString {
	
	private int points;
	private int employees;
	private double money;
	private String name;
	private ArrayList<String> assets;
	private ArrayList<Investment> investments;
	private ArrayList<Building> buildings;
	private Product product;
	
	/**
	 * Default construction of a player
	 */
	public Player() {
		this.setPoints(0);
		this.setMoney(0.0);
		this.setEmployees(0);
		this.setName("noname");
		this.assets = new ArrayList<String>();
		this.investments = new ArrayList<Investment>();
		this.buildings = new ArrayList<Building>();
	}
	/**
	 * @param points
	 * @param employees
	 * @param money
	 * @param name
	 * @param assets
	 */
	public Player(int points, double money, String name, ArrayList<String> assets) {
		this.setPoints(points);
		this.setEmployees(employees);
		this.setMoney(money);
		this.setName(name);
		this.setAssets(assets);
		this.investments = new ArrayList<Investment>();
		this.buildings = new ArrayList<Building>();
	}
	/**
	 * Initialize a player class
	 * @param points
	 * @param money
	 * @param name
	 * @param assets
	 */

	public Player(int points, int employees, double money, String name, ArrayList<String> assets) {
		this.setPoints(points);
		this.setEmployees(employees);
		this.setMoney(money);
		this.setName(name);
		this.setAssets(assets);
		this.investments = new ArrayList<Investment>();
		this.buildings = new ArrayList<Building>();
	}
	
	/**
	 * Construct a player from a JSONObject
	 */
	public Player(JSONObject jsonObject) throws Exception {
		this.setFromJSONObject(jsonObject);
	}
	
	private static String getJSONFilePath(String playerName) {
		StringBuilder retVal = new StringBuilder();
		if (System.getProperty("os.name").startsWith("Windows")) {
			retVal.append(System.getenv("USERPROFILE"));
			retVal.append("\\Enterpreneurship Simulator\\");
		} else {
			retVal.append(System.getenv("HOME"));
			retVal.append("/.enterpreneurship-simulator/");
		}
		File directory = new File(retVal.toString()); 
		if (!directory.exists()) {
			directory.mkdir();
			
		}
		if (playerName != null) {
			if (playerName.indexOf(".") != -1 || playerName.indexOf("/") != -1 || playerName.indexOf("\\") != -1) {
				throw new IllegalArgumentException("Invalid Player Name");
			}
			retVal.append(playerName);
			retVal.append(".json");
		}
		return retVal.toString();
	}
	
	public static List<String> getAvailablePlayers() {
		File directory = new File(getJSONFilePath(null));
		ArrayList<String> retVal = new ArrayList<>();
		for (File file : directory.listFiles()) {
			if (file.isFile()) {
				String[] parts = file.getName().split("\\.");
				if (parts.length == 2 && parts[1].equals("json")) {
					retVal.add(parts[0]);
				}
			}
		}
		return retVal;
	}
	
	/**
	 * Makes a JSON string of the player data
	 * @return ret 
	 */
	public String toJSONString() {
		String ret = "";
		try {
			//Add the class fields to a JSON object
			JSONObject obj = new JSONObject();
			obj.put("Points", points);
			obj.put("Employees", employees);
			obj.put("Money", money);
			obj.put("Name", name);
			obj.put("Assets", assets);
			obj.put("Investments", investments);
			obj.put("Buildings", buildings);
			obj.put("Product", product);
			ret = obj.toString();
		} catch(Exception e) {
			System.out.println("Failed to parse.");
		}
		return ret; //Return the JSON string
	}
	
	/**
	 * Saves the player's data to a JSON file
	 */
	public boolean saveFile() {
		try {
			PrintWriter out = new PrintWriter(getJSONFilePath(name));
			out.println(toJSONString());
			out.close();
			return true;
		} catch(Exception e) {
			System.out.println("Failed to write.");
		}
		return false;
	}
	
	public void setFromJSONObject(JSONObject jsonObject) throws Exception {
		
		//Extract the data from the JSON file and store it into objects
		int points = jsonObject.getInt("Points");
		int employees = jsonObject.getInt("Employees");
		double money = jsonObject.getDouble("Money");
		String name = jsonObject.getString("Name");
		if (!jsonObject.isNull("Product")) {
			JSONObject productObject = jsonObject.getJSONObject("Product");
			this.product = new Product(productObject);
		} else {
			this.product = null;
		}
		
		//Get the list that is included in the JSON file
		JSONArray jArrayAssets = jsonObject.getJSONArray("Assets");
		ArrayList<String> assets = new ArrayList<String>(); 
		
		//Populate the list with the JSON array values
		for(int i = 0; i < jArrayAssets.length(); i++) {
			assets.add(jArrayAssets.getString(i));
		}
		
		//Get the list that is included in the JSON file
		JSONArray jArrayInvestments = jsonObject.getJSONArray("Investments");
		ArrayList<Investment> investments = new ArrayList<Investment>();
		
		//Populate the list with the JSON array values
		for (int i = 0; i != jArrayInvestments.length(); ++i) {
			investments.add(new Investment(jArrayInvestments.getJSONObject(i)));
		}

		//Get the list that is included in the JSON file
		JSONArray jArrayBuildings = jsonObject.getJSONArray("Buildings");
		ArrayList<Building> buildings = new ArrayList<Building>();
		
		//Populate the list with the JSON array values
		for (int i = 0; i != jArrayBuildings.length(); ++i) {
			buildings.add(new Building(jArrayBuildings.getJSONObject(i)));
		}
		
		//Set the class values to what the JSON file produced
		this.points = points;
		this.money = money;
		this.name = name;
		this.assets = assets;
		this.employees = employees;
		this.investments = investments;
		this.buildings = buildings;
	}
	
	/**
	 * Initializes Player class based off JSON data
	 * @param playerName
	 */
	public boolean readFile(String playerName) {
		try {
			JSONTokener tokener = new JSONTokener(new FileReader(getJSONFilePath(playerName)));
			//Read the file and store it in a json object
			JSONObject jsonObject = new JSONObject(tokener);
			
			// Set all the member variables.
			this.setFromJSONObject(jsonObject);
			return true;
		} catch (Exception e) {
			System.out.println("Failed to read.");
		}
		return false;
	}
	
	/**
	 * Adds an asset to the list
	 * @param str
	 */
	public void addAsset(String str) {
		assets.add(str);
	}
	
	/**
	 * Adds an investment to the list
	 */
	public void addInvestment(Investment inv) {
		investments.add(inv);
	}
	
	/**
	 * Removes an asset from the list
	 * @param str
	 */

	public void removeAsset(String str) {
		for (int i = 0; i < assets.size(); i++) {
			if (assets.get(i).equals(str)) {
				assets.remove(i);
				i -= 1;
			}
		}
	}
	
	/**
	 * Removes an investment from the list
	 */
	public void removeInvestment(Investment inv) {
		for (int i = 0; i < investments.size(); ++i) {
			if (investments.get(i).equals(inv)) {
				investments.remove(i);
				i -= 1;
			}
		}
	}
	/**
	 * @return points
	 */
	public int getPoints() {
		return points;
	}
	/**
	 * @param points
	 */
	public void setPoints(int points) {
		this.points = points;
	}
	/**
	 * @param add
	 */
	public void addPoints(int points) {
		this.points += points;
	}
	/**
	 * @return money
	 */
	public double getMoney() {
		return money;
	}
	/**
	 * @param money
	 */
	public void setMoney(double money) {
		this.money = money;
	}	
	/**
	 * @param money
	 */
	public void addMoney(double money) {
		this.money += money;
	}
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return employees
	 */
	public int getEmployees() {
		return employees;
	}
	/**
	 * @param employees
	 */
	public void setEmployees(int employees) {
		this.employees = employees;
	}
	/**
	 * @param employees
	 */
	public void addEmployees(int employees) {
		this.employees += employees;
	}
	/**
	 * @return assets
	 */
	public ArrayList<String> getAssets() {
		return assets;
	}
	
	/**
	 * @return investments
	 */

	public ArrayList<Investment> getInvestments() {
		return investments;
	}
	
	/**
	 * Takes in a List and populates the assets list, without 
	 * replacing any data.
	 * @param assets
	 */
	public void addAssets(List<String> assets) {
		for (String asset : assets) {
			this.assets.add(asset);
		}
	}
	
	/**
	 * Takes in a List and populates the assets list, without
	 * replacing any data
	 * @param investments
	 */
	public void addInvestments(List<Investment> investments) {
		for (Investment investment : investments) {
			this.investments.add(investment);
		}
	}
	
	/**
	 * Takes in a List and replaces the current player list with the new one.
	 * @param assets
	 */
	public void setAssets(List<String> assets) {
		this.assets = new ArrayList<String>(assets);
	}
	
	/**
	 * Takes in a List and replaces the current player list with the new one.
	 * @param investments
	 */
	public void setInvestments(List<Investment> investments) {
		this.investments = new ArrayList<Investment>(investments);
	}
	
	/**
	 * Create an investment, removing the money put into it.
	 * @param name    Name of the investment
	 * @param amount  Amount invested
	 * @param isGood  Secret flag; good or bad investment
	 */
	public void takeInvestment(String name, double amount, boolean isGood) {
		Investment inv = new Investment(name, amount, isGood);
		this.money -= amount;
		this.addInvestment(inv);
	}
	
	/**
	 * Cash out on an investment.
	 * @param inv  Investment to take a return from.
	 */
	public void cashInvestment(Investment inv) {
		// TODO: Sell investment 
		//this.money += inv.calculateROI();
	}
	
	public Product getProduct() {
		return this.product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public List<Building> getBuildings() {
		return buildings;
	}
}
