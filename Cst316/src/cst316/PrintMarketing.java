package cst316;
import java.util.Random;

public class PrintMarketing extends MarketingCampaign {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	PrintMarketing(double a, double b, double c, String d, boolean e) {
		super(a, b, c, d, e);
	}
	
	 PrintMarketing() {
		super();
	}

	@Override
	public double StartCampaign() {
		Random rng = new Random();
		double x = ((rng.nextInt(200)) - 100);
		x = this.risk*x;
		if (x < 0){
			System.out.println("Bummer Dude, our marketing campaign actually resulted in a decrease in sales. We sold " + (x*-1) +  " less product as a result of our marketing run.");
		}
		else {
			System.out.println("Great Job, our marketing campaign resulted in an increase in sales. We sold " + x + " more products as a result of our marketing run.");
		}
		this.state = true;
		return x;
	}

	@Override
	public double CancelCampaign() {
		Random rng = new Random();
		double x = ((rng.nextInt(100)) + 1);
		if (x < 33){
			System.out.println("Bummer Dude, after prematurely canceling our marketing campaign, we only managed to recoup " + x + " percent of the original costs back.");
		}
		else {
			System.out.println("Well done, after prematurely canceling our marketing campaign, we actually managed to recoup " + x + " percent of the original costs back.");
		}
		this.state = false;
		return x;
	}
}
