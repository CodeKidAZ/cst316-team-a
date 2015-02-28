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
	
	/**
	 * Default construction of a player
	 */
	public Player() {
		this.setPoints(0);
		this.setMoney(0.0);
		this.setEmployees(0);
		this.setName("noname");
		this.assets = new ArrayList<String>();
<<<<<<< HEAD
		this.investments = new ArrayList<Investment>();
=======
>>>>>>> ResearchAndDevelopment
	}
	
	/**
	 * Initialize a player class
	 * @param points
	 * @param money
	 * @param name
	 * @param assets
	 */
<<<<<<< HEAD
	public Player(int points, double money, String name, List<String> assets) {
=======
	public Player(int points, int employees, double money, String name, ArrayList<String> assets) {
>>>>>>> ResearchAndDevelopment
		this.setPoints(points);
		this.setEmployees(employees);
		this.setMoney(money);
		this.setName(name);
		this.setAssets(assets);
		this.investments = new ArrayList<Investment>();
	}
	
	/**
	 * Construct a player from a JSONObject
	 */
	public Player(JSONObject jsonObject) {
		this.setFromJSONObject(jsonObject);
	}
	
	/**
	 * Makes a JSON string of the player data
	 * @return ret 
	 */
	public String toJSONString() {
		String ret = "";
<<<<<<< HEAD
		//Add the class fields to a JSON object
		JSONObject obj = new JSONObject();
		obj.put("Points", points);
		obj.put("Money", money);
		obj.put("Name", name);
		obj.put("Assets", assets);
		obj.put("Investments", investments);
		ret = obj.toString();
=======
		try {
			//Add the class fields to a JSON object
			JSONObject obj = new JSONObject();
			obj.put("Points", points);
			obj.put("Employees", employees);
			obj.put("Money", money);
			obj.put("Name", name);
			obj.put("Assets", assets);
			ret = obj.toString();
		} catch(Exception e) {
			System.out.println("Failed to parse.");
		}
>>>>>>> ResearchAndDevelopment
		return ret; //Return the JSON string
	}
	
	/**
	 * Saves the player's data to a JSON file
	 */
	public boolean saveFile() {
		try {
			PrintWriter out = new PrintWriter(name + ".json");
			out.println(toJSONString());
			out.close();
			return true;
		} catch(Exception e) {
			System.out.println("Failed to write.");
		}
		return false;
	}
	
	public void setFromJSONObject(JSONObject jsonObject) {
		
		//Extract the data from the JSON file and store it into objects
		int points = jsonObject.getInt("Points");
		double money = jsonObject.getDouble("Money");
		String name = jsonObject.getString("Name");
		
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
		
		//Set the class values to what the JSON file produced
		this.points = points;
		this.money = money;
		this.name = name;
		this.assets = assets;
		this.investments = investments;
	}
	
	/**
	 * Initializes Player class based off JSON data
	 * @param playerName
	 */
	public boolean readFile(String playerName) {
		try {
			JSONTokener tokener = new JSONTokener(new FileReader(playerName + ".json"));
			//Read the file and store it in a json object
<<<<<<< HEAD
			JSONObject jsonObject = new JSONObject(tokener);
			
			// Set all the member variables.
			this.setFromJSONObject(jsonObject);

=======
			Object obj = parser.parse(new FileReader(playerName + ".json"));
			JSONObject jsonObject = (JSONObject) obj;
			
			//Extract the data from the JSON file and store it into objects
			Object points = (Long) jsonObject.get("Points"); //JSON forces me to use Long
			Object employees = (Long) jsonObject.get("Employees");
			Object money = (Double) jsonObject.get("Money");
			Object name = (String) jsonObject.get("Name");
			//Get the list that is included in the JSON file
			JSONArray jArray = (JSONArray) jsonObject.get("Assets");
			ArrayList<String> assets = new ArrayList<String>(); 
			
			//Populate the list with the JSON array values
			for(int i = 0; i < jArray.size(); i++) {
				assets.add((String)jArray.get(i));
			}
			
			//Set the class values to what the JSON file produced
			this.points = new BigDecimal((Long) points).intValueExact(); //Work around to get it back to int
			this.employees = new BigDecimal((Long) employees).intValueExact();
			this.money = (Double) money;
			this.name = (String) name;
			this.assets = assets;
>>>>>>> ResearchAndDevelopment
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
<<<<<<< HEAD
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
=======
	public boolean removeAsset(String str) {
		for(int i = 0; i < assets.size(); i++) {
			if( assets.get(i).equals(str)){
				assets.remove(i);
				return true;
>>>>>>> ResearchAndDevelopment
			}
		}
		return false;
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
	public List<String> getAssets() {
		return assets;
	}
	
	/**
	 * @return investments
	 */
<<<<<<< HEAD
	public List<Investment> getInvestments() {
		return investments;
=======
	public boolean printAssets() {
		for(int i=0; i<assets.size(); i++)
			System.out.print(assets.get(i)+", ");
		return true;
>>>>>>> ResearchAndDevelopment
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
		this.money += inv.calculateROI();
	}
}
