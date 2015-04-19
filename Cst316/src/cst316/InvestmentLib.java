package cst316;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class InvestmentLib {

	private static JSONObject investments;
	private static Random rnd = new Random(System.currentTimeMillis());
	
	public InvestmentLib(){
		if(investments == null){
			JSONTokener in = new JSONTokener(
					new BufferedReader(
							new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("res/invlib.json"))));
			setInvestments(new JSONObject(in));
		}
	}
	
	private static void setInvestments(JSONObject inv){
		investments = inv;
	}
	
	public String[] getRandomTimedInvestment(){
		JSONArray arr = investments.getJSONArray("timed");
		int index = (int)(rnd.nextGaussian() * arr.length());
		arr = arr.getJSONArray(index);
		String[] ret = new String[arr.length()];
		for(int x = 0; x < arr.length(); x++){
			ret[x] = arr.getString(x);
		}
		return ret;
	}
	public String[] getCompanyNames(){
		JSONArray arr = investments.getJSONArray("investments");
		String[] ret = new String[arr.length()];
		for(int x = 0; x< arr.length(); x++){
			ret[x] = arr.getString(x);
		}
		return ret;
	}

}
