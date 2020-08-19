
public class Exchange extends item{
	
	private int topup;
	
	
	public Exchange(int id, String name, double price , int topup) {
		super(id, name, price);
		this.topup = topup;

	}
	public int getTopup() {
		return topup;
	}

}
