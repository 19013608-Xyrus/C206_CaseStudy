import java.util.ArrayList;


/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19038833, 23 Aug 2020 8:37:17 pm
 */

/**
 * @author 19038833
 *
 */
public class products_main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayList<products> productList = new ArrayList<products>();
		
		int option = 0;
		
		while (option != 6) {
			products_main.menu();
			option = Helper.readInt("Enter an option > ");
			
			if (option == 1) {
				products_main.viewAllProducts(productList);
			} else if (option == 2) {
				products pr = inputProduct(productList);
				products_main.addProducts(productList , pr );
			} else if (option == 3) {
				products_main.deleteProduct(productList);
			} else if (option == 4) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option!");
			}
		}

	}
	
	public static void menu() {
		products_main.setHeader("DISO APP");
		System.out.println("1. VIEW ALL PRODUCTS");
		System.out.println("2. ADD A PRODUCT");
		System.out.println("3. DELETE A PRODUCT");
		System.out.println("4. UPDATE PRODUCT CATEGORY");
		System.out.println("5. QUIT");
		Helper.line(80, "-");
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
		
		
		
		public static String retrieveAllProducts(ArrayList<products> productList ) {
			String output = "";
			for (int i = 0; i < productList.size(); i++) {
				
				output += String.format(" %d.%-20s(Add %-20s )%-20s \n", i+1, 
						productList.get(i).getName(), productList.get(i).getDescription(), productList.get(i).getCategory());
						}
			return output;
		}
			
		public static void viewAllProducts(ArrayList<products> productList) {
			products_main.setHeader("PRODUCTS LIST");
			String output = String.format("%20s \n", "PRODUCTS");
			      output += retrieveAllProducts(productList);
			System.out.println(output);
		}
		
		public static products inputProduct(ArrayList<products> productList) {
			String name = Helper.readString("Enter product name > ");
			String description = Helper.readString("Enter a description of the product > ");
			String category = Helper.readString("Enter the category of the product > " );
			return null;
		}
		
		public static void addProducts(ArrayList<products> productList, products pr) {
			productList.add(pr);
			System.out.println("The product has been added.");
			
		}
		
		public static void deleteProduct(ArrayList<products> productList) {
			String name = Helper.readString("Enter the product to be deleted > ");
			for(int i = 0; i < productList.size(); i++) {
				if (productList.get(i).getName().equalsIgnoreCase(name)) {
					productList.remove(i);
				}
			}
		}



		
		
		

	}


