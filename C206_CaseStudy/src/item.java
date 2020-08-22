
public class item {
	
	private int id;
	private String name;
	private String nameStaff;
	private double price;
	
	
	public item(int id, String name, String nameStaff, double price) {
		super();
		this.id = id;
		this.name = name;
		this.nameStaff = nameStaff;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustName() {
		return name;
	}
	public void setCustName(String name) {
		this.name = name;
	}
	public String getStaffName() {
		return nameStaff;
	}
	public void setStaffName(String nameStaff) {
		this.nameStaff = nameStaff;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
