/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19018500, 23 Aug 2020 2:49:22 pm
 */

/**
 * @author 19018500
 *
 */


	/**
	 * @param args
	 */
import java.util.ArrayList;

public class Customer_Main {
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			ArrayList<Customer> customerList = new ArrayList<Customer>();
			ArrayList<Returns> returnsList = new ArrayList<Returns>();
			
			customerList.add(new Customer("Ben"));
			customerList.add(new Customer("Tom"));
			customerList.add(new Customer("Jerry"));
			
			returnsList.add(new Returns(1));
			returnsList.add(new Returns(2));
			returnsList.add(new Returns(3));
			
			int CustomerOpt = 0;
			
			menu();
			
			while (CustomerOpt != 6) {
				Customer_Main.menu();
				CustomerOpt = Helper.readInt("Enter an option > ");
				
				if (CustomerOpt == 1) {
					//View all customers
					Customer_Main.viewAllCustomer(customerList);
					Customer_Main.retrieveAllCustomer(customerList);
					Customer_Main.retrieveAllReturns(returnsList);
					
				} else if (CustomerOpt == 2) {
					//Add customer or Add returns
					Customer customer = inputCustomer();
					Customer_Main.addCustomer(customerList, customer);
				
				} else if (CustomerOpt == 3) {
					//Delete a customer
					Customer customer = inputCustomer();
					Customer_Main.deleteCustomer(customerList, customer);
					
				} else if (CustomerOpt == 4) {
					// Update customer returns
					String name = Helper.readString("Enter updated customer name > ");
					int returns = Helper.readInt("Enter updated returns > ");
					Customer_Main.updateReturns(returnsList, returns);
					
					
				} else if (CustomerOpt == 5) {
					// Add customer returns
					Returns returns = inputReturns();
					Customer_Main.addReturns(returnsList, returns);
					
				} else if (CustomerOpt == 6) {
					System.out.println("Bye!");
					
				} else {
					System.out.println("Invalid option!");
				}
			}
		}
		
		
		
		public static void menu() {
			C206_CaseStudy.setHeader("DISO APP");
			System.out.println("1. VIEW CUSTOMERS");
			System.out.println("2. ADD CUSTOMER");
			System.out.println("3. DELETE CUSTOMER");
			System.out.println("4. UPDATE CUSTOMER RETURNS");
			System.out.println("5. ADD CUSTOMER RETURNS");
			Helper.line(80, "-");
		}
		public static void setHeader(String header) {
			Helper.line(80, "-");
			System.out.println(header);
			Helper.line(80, "-");
			
		}
		
			
			
		// Option 1 (View customer)
		public static void viewAllCustomer(ArrayList<Customer> customerList) {
			C206_CaseStudy.setHeader("CUSTOMER LIST");
			String output = String.format("%-10s %-5s", "NAME", "RETURNS");
			 output += retrieveAllCustomer(customerList);
			 ArrayList<Returns> returnsList = new ArrayList<Returns>();
			output += retrieveAllReturns(returnsList);
			System.out.println(output);
		}
		
		public static String retrieveAllCustomer(ArrayList<Customer> customerList) {
			String output = "";
			for (int i = 0; i < customerList.size(); i++) {

				output += String.format("%-10s", customerList.get(i).getName());
			}
			return output;
		}
		
		public static String retrieveAllReturns(ArrayList<Returns> returnsList) {
			String output = "";
			for (int i = 0; i < returnsList.size(); i++) {

				output += String.format("%-5s", returnsList.get(i).getReturns());
						
			}
			return output;
		}
		
		// Option 2 (Add customer)
		public static Customer inputCustomer() {
			String name = Helper.readString("Enter name > ");

			Customer customer = new Customer(name);
			return customer;
			
		}
	
		public static void addCustomer(ArrayList<Customer> customerList, Customer customer) {
			
			customerList.add(customer);
			System.out.println("Customer added!");
		}
		
		// Option 3 (Delete)
		public static void deleteCustomer(ArrayList<Customer> customerList, Customer customer) {
			
			customerList.remove(customer);
			System.out.println("Customer deleted!");
		}

		// Option 4 (Update returns)
		public static void updateReturns(ArrayList<Returns> returnsList, int returns) {
			String name = Helper.readString("Enter updated customer name > ");
			int returns1 = Helper.readInt("Enter updated returns > ");
			int pos = 0;
			for (int i=0;i< returnsList.size();i++) {
				if (returnsList.get(i).getReturns() == returns1) {
					pos = i;
					break;
				}
			}
		
		}

		// Option 5 (Add returns)
		public static Returns inputReturns() {
			int returns = Helper.readInt("Enter returns > ");
		
			Returns customer = new Returns(returns);
			return customer;
			
		}
		
		
		public static void addReturns(ArrayList<Returns> returnsList, Returns returns) {
			
			returnsList.add(returns);
			System.out.println("Returns added!");
		}
	}
