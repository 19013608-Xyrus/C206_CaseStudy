import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Food> foodList = new ArrayList<Food>();
		ArrayList<Toys> toyList = new ArrayList<Toys>();
		
		int option = 0;
		
		while (option != 5) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");
			
			if (option == 1) {
				//View all products
			} else if (option == 2) {
				//Add products
				int itemType = Helper.readInt("Enter option to select item type > ");
				if (itemType == 1) {
					//Add a Food
				} else if (itemType == 2) {
					//Add a Toy
				}
			} else if (option == 3) {
				//Delete a product
			} else if (option == 4) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option!");
			}
		}
	}
	
	public static void menu() {
		C206_CaseStudy.setHeader("DISO APP");
		System.out.println("1. VIEW ALL PRODUCTS");
		System.out.println("2. ADD A PRODUCT");
		System.out.println("3. DELETE A PRODUCT");
		System.out.println("4. QUIT");
		Helper.line(80, "-");
	}
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");

}
