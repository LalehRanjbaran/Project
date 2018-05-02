package finalProject;

/**
 * @author Laleh
 *
 */
public class company {
	
	 private String companyName; 
	 private double suggestedCost;
// constructors--------------------	 
	 /**
	 *  default constructor
	 */
	public company() {
		 
	 }
	 /**constructor with two parameters
	 * @param companyName
	 * @param suggestedCost
	 */
	public company(String companyName,  double suggestedCost) {
			this.companyName = companyName;
			this.suggestedCost = suggestedCost;
		} 
//-------getter and setters--------------
	 
	/**
	 * @return Company Name
	 */
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
	/**
	 * @return offer
	 */
	public double getSuggestedCost() {
		return suggestedCost;
	}
	public void setSuggestedCost(double suggestedCost) {
			this.suggestedCost = suggestedCost;
	}
//--------------methods-------------
	@Override
	public String toString() {
		return "Company '" + companyName + "' : "+ suggestedCost ;
	}
		

}
