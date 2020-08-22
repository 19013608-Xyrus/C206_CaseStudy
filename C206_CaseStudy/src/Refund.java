
public class Refund extends item{
	
	private int returnPts;
	
	
	public Refund(int id, String name, String nameStaff, double price , int returnPts) {
		super(id, name, nameStaff, price);
		this.returnPts= returnPts;
	}

}
