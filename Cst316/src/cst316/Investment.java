package cst316;

import java.util.Random;

import javafx.scene.image.Image;

import org.json.JSONArray;
import org.json.JSONString;
import org.json.JSONObject;

/**
 * There are good investments and bad investments. Both of these follow normal
 * distribution, with the ROI mean at -investment (for bad investments) or the
 * investment size (for good investments). The standard deviation is equal to
 * the amount invested. Note that ROI is the difference between before and after
 * making the investment.
 * @author michael
 *
 */
public class Investment implements JSONString {
	
	private double amount;
	private String name;
	private boolean isGood;
	private JSONArray gains;
	private static Random random = new Random();
	private static InvestmentLib lib = new InvestmentLib();
	public Investment(String name, double amount, boolean isGood) {
		this.amount = amount;
		this.name = name;
		this.isGood = isGood;
		gains = new JSONArray();
	}
	public Investment(JSONObject object) {
		this.amount = object.getDouble("Amount");
		this.name = object.getString("Name");
		this.isGood = object.getBoolean("IsGood");
		gains = object.getJSONArray("Gains");
	}
	public double getAmount() {
		return amount;
	}
	public void addAmount(double amt){
		amount += amt;
	}
	public String getName() {
		return name;
	}
	public boolean isGood() {
		return isGood;
	}
	public void calculateROI() {
		double percent;
		if(isGood){
			// Between -5% and 30%
			percent = ((random.nextGaussian() * 30) - 5)/100;
		}else{
			// Between -20% and 10%
			percent = ((random.nextGaussian() * 30) - 20)/100;
		}
		// Monthly interest
		amount += amount * (percent/12);
		JSONArray arr = new JSONArray();
		arr.put(gains.length());
		arr.put(amount);
		gains.put(arr);
	}
	public String toString() {
		return name + ": " + amount;
	}
	public String toJSONString() {
		JSONObject object = new JSONObject();
		object.put("Amount", amount);
		object.put("Name", name);
		object.put("IsGood", isGood);
		object.put("Gains", gains);
		return object.toString();
	}
	
	public boolean equals(Object obj) {
		boolean retVal = false;
		if (obj instanceof Investment) {
			Investment inv = (Investment)obj;
			retVal = inv.amount == this.amount && inv.name.equals(this.name) && inv.isGood == this.isGood;
		}
		return retVal;
	}
	
	public static String[] getAllCompanyNames() {
		return lib.getCompanyNames();
	}
	public int getTimeInMonths(){
		return gains.length();
	}
	public JSONArray getGains(){
		return gains;
	}
	public Double getFee(){
		if(gains.length() < 2){
			return amount*.9;
		}else if(gains.length() < 4){
			return amount * .75;
		}else if(gains.length() < 8){
			return amount * .75;
		}else if(gains.length() < 12){
			return amount * .4;
		}else{
			return amount * .1;
		}
	}
	// frnd.jpg courtesy of kev-shine (https://www.flickr.com/people/kevinshine/)
	public static Image getImage(String name){
		return new Image(Investment.class.getClassLoader().getResourceAsStream("res/"+name.toLowerCase()+".jpg"));
	}
	
	public static boolean randomBoolean(){
		return random.nextBoolean();
	}
	
	public static String[] getTimedInvestment(){
		return lib.getRandomTimedInvestment();
	}
}
