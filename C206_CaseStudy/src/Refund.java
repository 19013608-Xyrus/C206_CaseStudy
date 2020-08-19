
public class Refund extends item{
	
	private int returnPts;
	
	
	public Refund(int id, String name, double price , int returnPts) {
		super(id, name, price);
		this.returnPts= returnPts;
	}

}
