package cst316;

public abstract class MarketingCampaign implements java.io.Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected double duration;
    protected double risk;
    protected double capital;
    protected String name;
    protected boolean state;

    public MarketingCampaign() {
    	duration = 0.0;
    	risk = 0.0;
    	capital = 0.0;
    	name = " ";
    	state = false;
    }
    
    public MarketingCampaign(double duration, double risk, double capital, String name, boolean state) {
    	this.duration = duration;
    	this.risk = risk;
    	this.capital = capital;
    	this.name = name;
    	this.state = state;
    }


    /** 
     * return a formatted string of Marketing Campaign with its attributes name, duration, risk, and capital in a sentence form.
     */
    public String toString() {
        return "Marketing Campaign: " + name + " has " + duration + "days left to run, " + 
        		"with an estimated risk of: " + risk + "and an estimated capital of: " + capital;
    }

    /**
     * @return duration of the MarketingCampaign
     */
	public double getDuration() {
		return duration;
	}


	public void setDuration(double duration) {
		this.duration = duration;
	}

    /**
     * @return risk of the MarketingCampaign
     */
	public double getRisk() {
		return risk;
	}


	public void setRisk(double risk) {
		this.risk = risk;
	}

    /**
     * @return capital of the MarketingCampaign
     */
	public double getCapital() {
		return capital;
	}


	public void setCapital(double capital) {
		this.capital = capital;
	}
	
    /**
     * @return name of the MarketingCampaign
     */
    public final String getName() {
        return name;
    }


	public void setName(String name) {
		this.name = name;
	}

    /**
     * @return state of the MarketingCampaign
     */
    public final boolean getState() {
        return state;
    }
	
	public void setState(boolean state) {
		this.state = state;
	}
	


    public abstract double startCampaign();

    public abstract double cancelCampaign();

}
