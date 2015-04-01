/**
 * 
 */
package cst316;

/**
 * @author Wesley Local
 *
 */
public class MarketCompany {

	/**
	 * @param name
	 * @param marketPower
	 */
	public MarketCompany(String name, double marketPower) {
		super();
		this.name = name;
		this.marketPower = marketPower;
	}

	/**
	 * @param args
	 */
	private String name;
	private double marketPower;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the marketPower
	 */
	public double getMarketPower() {
		return marketPower;
	}

	/**
	 * @param marketPower the marketPower to set
	 */
	public void setMarketPower(double marketPower) {
		this.marketPower = marketPower;
	}

}
