/**
 * 
 */
package cst316;

import java.util.ArrayList; 

/**
 * @author Wesley Local
 *
 */
public class MarketShareMeasure {

	/**
	 * @param args
	 */

	
	static MarketCompany mcSample1 = new MarketCompany("Wendys", 15.5);
	static MarketCompany mcSample2 = new MarketCompany("BurgerKing", 35.9);
	static MarketCompany mcSample3 = new MarketCompany("McDonalds", 75.9);
	
	double getMarketCapital(double shares, double price){
		double marketCapital = (shares*price);
		return marketCapital;
	}
	
	String getCapTerm(double marketCapital){
		String capTerm = "";
		
		marketCapital = marketCapital/1000000000; //converts market capital value into a billion count, so eg. 500000000 = .5 billion
		//This is done so that way I can use smaller compare values in the if statements that do not go outside of variable range
		
		// checks if company's marketCapitalzation value is  < 2 billion
		if (marketCapital < 2){
			capTerm = "Low Cap";
		}
		// checks if company's marketCapitalzation value is  > 2 billion and < 10 billion
		else if (marketCapital > 2 && marketCapital < 10){
			capTerm = "Mid Cap";
		}
		// if it does not fulfill the previous two if statements, then the passed in value must be > 10 billion
		else{
			capTerm = "High Term Cap";
		}
		
		return capTerm;
	}
	
	//This method takes in an ArrayList of MarketCompany Type, and a String of a company name that --
	//is already in the list of MarketCompanys that will be passed in. The method iterates through 
	//the list of MarketCompanys, and totals up their 'MarketPower' values. It also checks for the passed in Name 
	//of company each time it iterates through the for loop. If it finds a company in the list matching the passed
	//in name, then it stores that value and divides it by the totalMarketPower of the entire list to get the 
	//equivalent percentage of how much the specific company owns of a market. EG. BurgerKing owns 28.65% of the fastfood Market.
	static double getMarketPercent(ArrayList<MarketCompany> mcIn, String compName){
		double targetPower = -1;
		double totalPower = -2;
		double ret = -3;
		
		for (int z = 0; z < mcIn.size(); z ++){
			  if(compName.equals(mcIn.get(z).getName()))
			  {
				  targetPower = (mcIn.get(z).getMarketPower());
			  }
			  totalPower = totalPower+(mcIn.get(z).getMarketPower());
		}
		
		ret = (targetPower / totalPower) * 100;
		return ret;
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		


		ArrayList<MarketCompany> companyList = new ArrayList<MarketCompany>();
		companyList.add(mcSample1);
		companyList.add(mcSample2);
		companyList.add(mcSample3);
		
		double d = getMarketPercent(companyList, "Wendys");
		
		System.out.println("The market percent of Wendy's is: " + d);
		
		d = getMarketPercent(companyList, "BurgerKing");
		
		System.out.println("The market percent of BurgerKing is: " + d);
		
		d = getMarketPercent(companyList, "McDonalds");
		
		System.out.println("The market percent of McDonalds's is: " + d);

	}

}
