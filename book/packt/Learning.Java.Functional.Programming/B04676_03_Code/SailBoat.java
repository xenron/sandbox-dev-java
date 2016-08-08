package packt;

//public class SailBoat extends BaseBoat {
public class SailBoat extends BaseBoat<SailBoat> {
    private int numberOfSails;
    private int numberOfHulls;
    
    public int getSails() {
        return this.numberOfSails;
    }
    
    public SailBoat sails(int numberOfSails) {
        this.numberOfSails = numberOfSails;
        return this;
    }
    
    public int getNumberOfHulls() {
        return this.numberOfHulls;
    }
    
    public SailBoat hulls(int numberOfHulls) {
        this.numberOfHulls = numberOfHulls;
        return this;
    }

    public String toString() {
        return super.toString() 
                + " Number of sails: " + this.numberOfSails 
                + " Number of hulls: " + this.numberOfHulls;
    } 
}
