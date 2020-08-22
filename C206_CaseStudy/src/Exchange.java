
public class Exchange extends item{
	//Testing push (X)
	private int topup;
	
	
	public Exchange(int id, String name, String nameStaff, double price , int topup) {
		super(id, name, nameStaff, price);
		this.topup = topup;

	}
	public int getTopup() {
		return topup;
	}

}
