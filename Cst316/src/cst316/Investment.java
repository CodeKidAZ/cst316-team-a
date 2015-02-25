package cst316;

import java.util.Random;
import org.json.JSONString;
import org.json.JSONObject;

/**
 * There are good investments and bad investments. Both of these follow normal
 * distribution, with the ROI mean at zero (for bad investments) or the
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
	private static Random random = new Random();
	public Investment(String name, double amount, boolean isGood) {
		this.amount = amount;
		this.name = name;
		this.isGood = isGood;
	}
	public Investment(JSONObject object) {
		this.amount = object.getDouble("Amount");
		this.name = object.getString("Name");
		this.isGood = object.getBoolean("IsGood");
	}
	public double getAmount() {
		return amount;
	}
	public String getName() {
		return name;
	}
	public boolean isGood() {
		return isGood;
	}
	public double calculateROI() {
		double distribution = random.nextGaussian();
		double adjustedDistribution = distribution + (isGood ? 1 : -1);
		return amount * adjustedDistribution;
	}
	public String toString() {
		return name + ": " + amount;
	}
	public String toJSONString() {
		JSONObject object = new JSONObject();
		object.put("Amount", amount);
		object.put("Name", name);
		object.put("IsGood", isGood);
		return object.toString();
	}
}
