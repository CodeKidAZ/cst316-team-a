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
import java.math.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Player {
	
	private int points;
	private int employees;
	private double money;
	private String name;
	private ArrayList<String> assets = new ArrayList<String>( );
	
	/**
	 * Default construction of a player
	 */
	public Player() {
		this.setPoints(0);
		this.setMoney(0.0);
		this.setEmployees(0);
		this.setName("noname");
		this.assets = new ArrayList<String>();
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
	}
	
	/**
	 * Makes a JSON string of the player data
	 * @return ret 
	 */
	public String toJsonString() {
		String ret = "";
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
		return ret; //Return the JSON string
	}
	
	/**
	 * Saves the player's data to a JSON file
	 */
	public boolean saveFile() {
		try {
			PrintWriter out = new PrintWriter(name + ".json");
			out.println(toJsonString());
			out.close();
			return true;
		} catch(Exception e) {
			System.out.println("Failed to parse.");
		}
		return false;
	}
	
	/**
	 * Initializes Player class based off JSON data
	 * @param playerName
	 */
	public boolean readFile(String playerName) {
		JSONParser parser = new JSONParser();
		try {
			//Read the file and store it in a json object
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
			return true;
		} catch (Exception e) {
			System.out.println("Failed to parse.");
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
	 * Removes an asset from the list
	 * @param str
	 */
	public boolean removeAsset(String str) {
		for(int i = 0; i < assets.size(); i++) {
			if( assets.get(i).equals(str)){
				assets.remove(i);
				return true;
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
	public ArrayList<String> getAssets() {
		return assets;
	}
	
	/**
	 * Prints the the values inside the ArrayList "assets"
	 */
	public boolean printAssets() {
		for(int i=0; i<assets.size(); i++)
			System.out.print(assets.get(i)+", ");
		return true;
	}
	
	/**
	 * Takes in an ArrayList and populates the assets list, without 
	 * replacing any data.
	 * @param assets
	 */
	public void addAssets(ArrayList<String> assets) {
		for(int i = 0; i < assets.size(); i++) {
			this.assets.add(assets.get(i));
		}
	}
	
	/**
	 * Takes in an ArrayList and replaces the current player list with the new one.
	 * @param assets
	 */
	public void setAssets(ArrayList<String> assets) {
		this.assets = assets;
	}
}
