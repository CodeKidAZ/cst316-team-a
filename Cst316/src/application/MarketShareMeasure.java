/**
 * 
 */
package application;

/**
 * @author Wesley Local
 *
 */
public class MarketShareMeasure {

	/**
	 * @param args
	 */
	
	int[] myIntArray = new int[]{1,2,3};
	
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
	
	double getMarketPercent(double marketCapital){
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}

}
