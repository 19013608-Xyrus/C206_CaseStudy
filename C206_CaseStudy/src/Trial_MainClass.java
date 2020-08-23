import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Trial_MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Imported from Transaction - Xyrus
		ArrayList<Exchange> exchangeList = new ArrayList<Exchange>();
		ArrayList<Refund> refundList = new ArrayList<Refund>();
		
		//Imported from Procedure - Elysha
		ArrayList<procedure_types> procedureList = new ArrayList <procedure_types>();
		procedureList.add(new procedure_types("Refund" , "Repay customer through points system" , new Date()));
		procedureList.add(new procedure_types("Exchange" , "Exchange goods only if goods were spoilt" , new Date()));
		
		//Imported from Product - Manmeet
		
		//Imported from Customer - Marcus
		
		//Menu for the program
		int option = 0;
		
		while (option !=6) {
			Trial_MainClass.menu();
			
			option = Helper.readInt("Enter option number> ");
			
			if(option == 1) {
				// Transaction
				
				int transOpt = 0;
		
				while (transOpt != 5) {
					
					//Transaction Menu + Method names
					Trial_MainClass.TransactionMenu();
					transOpt = Helper.readInt("Enter an option > ");

					if (transOpt == 1) {
						// View all transactions
						Trial_MainClass.viewAllExchange(exchangeList);
						Trial_MainClass.viewAllRefund(refundList);

					} else if (transOpt == 2) {
						// Add transactions
						Trial_MainClass.setHeader("ADD");
						Trial_MainClass.setHeader("ITEM TYPES");
						System.out.println("1. Exchange");
						System.out.println("2. Refund");
						int transactionType = Helper.readInt("Enter a transaction type > ");
						if (transactionType == 1) {
							// Add an exchange
							Exchange ex = inputExchange();
							Trial_MainClass.addExchange(exchangeList, ex);

						} else if (transactionType == 2) {
							// Add a refund
							Refund re = inputRefund();
							Trial_MainClass.addRefund(refundList, re);

						} else {
							System.out.println("Invalid type");
						}
					} else if (transOpt == 3) {
						// Archive a transaction
						Trial_MainClass.setHeader("ARCHIVE");
						Trial_MainClass.setHeader("ITEM TYPES");
						System.out.println("1. Exchange");
						System.out.println("2. Refund");
						int transactionType = Helper.readInt("Enter a transaction type > ");
						if (transactionType == 1) {
							// Add an exchange
							Trial_MainClass.archiveExchange(exchangeList);

						} else if (transactionType == 2) {
							// Add a refund
							Trial_MainClass.archiveRefund(refundList);
							
						}
					} else if (transOpt == 4) {
						//Update a transaction
						Trial_MainClass.setHeader("UPDATE");
						Trial_MainClass.setHeader("ITEM TYPES");
						System.out.println("1. Exchange");
						System.out.println("2. Refund");
						int transactionType = Helper.readInt("Enter a transaction type > ");
						if (transactionType == 1) {
							// Update an exchange
							int id = Helper.readInt("Enter ID of exchange to update > ");
							boolean exist = checkExchangeID(exchangeList, id);
							while (exist == false) {
								System.out.println("ID does not exist, please try again");
								id = Helper.readInt("Enter ID again > ");
								exist = checkExchangeID(exchangeList, id);
							}
							
							updateExchange(exchangeList, id);

						} else if (transactionType == 2) {
							// Update a refund
							int id = Helper.readInt("Enter ID of exchange to update > ");
							boolean exist = checkRefundID(refundList, id);
							while (exist == false) {
								System.out.println("ID does not exist, please try again");
								id = Helper.readInt("Enter ID again > ");
								exist = checkRefundID(refundList, id);
							}
							
							updateRefund(refundList, id);
						}

					} else if (transOpt == 5) {
						System.out.println("Thank you for using our service!");
					} else {
						System.out.println("Invalid option!");
					}
				}
			}	
			else if (option == 2) {
				// Procedure
				
				int ProcedureOpt = 0;
				
				while (ProcedureOpt != 5) {
					
					//Procedure Menu + Method names 
					Trial_MainClass.ProcedureMenu();
					ProcedureOpt = Helper.readInt("Enter an option > ");
					
					if (ProcedureOpt == 1) {
						Trial_MainClass.viewAllProcedures(procedureList);
					} else if (ProcedureOpt == 2) {
						procedure_types pt = inputProcedure();
						Trial_MainClass.addProcedure(procedureList , pt );
					} else if (ProcedureOpt == 3) {
						Trial_MainClass.deleteProcedure(procedureList);
					} else if (ProcedureOpt == 4) {
						Trial_MainClass.updateDate(procedureList);
					} else if (ProcedureOpt == 5) {
						System.out.println("Bye!");
					} else {
						System.out.println("Invalid option!");
					}
				}
			}
			else if (option == 3) {
				// Product
			}
			else if (option == 4) {
				// Customer
			}
			else if (option == 5) {
				System.out.println("Thank you for using the system!");
			}
			else {
				System.out.println("Invalid Option!");
			}
			
		}

	}
	//System's Header
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	// System's main menu
	public static void menu() {
		Trial_MainClass.setHeader("DISO APP");
		System.out.println("1. TRANSACTIONS");
		System.out.println("2. PROCEDURES");
		System.out.println("3. PRODUCTS");
		System.out.println("4. CUSTOMER");
		System.out.println("5. QUIT");
		Helper.line(80, "-");
	}
	
	//Transaction's Menu
	public static void TransactionMenu() {
		System.out.println("1. VIEW ALL TRANSACTIONS");
		System.out.println("2. ADD A TRANSACTION");
		System.out.println("3. ARCHIVE A TRANSACTION");
		System.out.println("4. UPDATE A TRANSACTION");
		System.out.println("5. QUIT");
		Helper.line(80, "-");
	}
	
	//Procedure's Menu
	public static void ProcedureMenu() {
		System.out.println("1. VIEW ALL PROCEDURES");
		System.out.println("2. ADD A PROCEDURE");
		System.out.println("3. DELETE A PROCEDURE");
		System.out.println("4. UPDATE PROCEDURE DATE");
		System.out.println("5. QUIT");
		Helper.line(80, "-");
	}
	
	//Product's Menu
	public static void ProductMenu() {
		
	}
	
	//Customer's Menu
	public static void CustomerMenu() {
		
	}
	
	//!!TRANSACTION METHODS!!
	
	// ================================= Option 1 View=================================
		public static String retrieveAllExchange(ArrayList<Exchange> exchangeList) {
			String output = "";

			for (int i = 0; i < exchangeList.size(); i++) {
				output += String.format("%-10d %-20s %-10s %-10.2f\n", exchangeList.get(i).getId(),
						exchangeList.get(i).getCustName(), exchangeList.get(i).getStaffName()
						, exchangeList.get(i).getPrice());
			}
			return output;
		}

		public static void viewAllExchange(ArrayList<Exchange> exchangeList) {
			C206_CaseStudy.setHeader("EXCHANGE LIST");
			String output = String.format("%-10s %-20s %-10s %-10s\n", "ID", "CUSTOMER NAME", "STAFF NAME", "PRICE");
			output += retrieveAllExchange(exchangeList);
			System.out.println(output);
		}

		public static String retrieveAllRefund(ArrayList<Refund> refundList) {
			String output = "";

			for (int i = 0; i < refundList.size(); i++) {
				output += String.format("%-10d %-20s %-10s %-10.2f\n", refundList.get(i).getId(),
						refundList.get(i).getCustName(), refundList.get(i).getStaffName()
						, refundList.get(i).getPrice());
			}
			return output;
		}

		public static void viewAllRefund(ArrayList<Refund> refundList) {
			C206_CaseStudy.setHeader("REFUND LIST");
			String output = String.format("%-10s %-20s %-10s %-10s\n", "ID", "CUSTOMER NAME", "STAFF NAME", "PRICE");
			output += retrieveAllRefund(refundList);
			System.out.println(output);
		}

		// ================================= Option 2 Add=================================
		public static Exchange inputExchange() {
			int id = Helper.readInt("Enter ID > ");
			String name = Helper.readString("Enter Name of customer > ");
			String nameStaff = Helper.readString("Enter Name of staff >");
			double price = Helper.readDouble("Enter Price > ");
			int topup = 0;

			Exchange ex = new Exchange(id, name, nameStaff, price, topup);
			return ex;

		}

		public static void addExchange(ArrayList<Exchange> exchangeList, Exchange ex) {
			
			String output = "";
			exchangeList.add(ex);
			System.out.println("Exchange added");
			System.out.println(String.format("%-10s %-20s %-10s %-10s\n", "ID", "CUSTOMER NAME", "STAFF NAME", "PRICE"));
			for (int i = 0; i < exchangeList.size(); i++) {
				if (ex.getCustName().equalsIgnoreCase(exchangeList.get(i).getCustName())) {
					output = "";
					output += String.format("%-10d %-20s %-10s %-10.2f\n", exchangeList.get(i).getId(),
							exchangeList.get(i).getCustName(), exchangeList.get(i).getStaffName()
							, exchangeList.get(i).getPrice());
					System.out.println(output);
				}
			}
		}

		public static Refund inputRefund() {
			int returnPoints = 0;
			int id = Helper.readInt("Enter ID > ");
			String name = Helper.readString("Enter Name of customer > ");
			String nameStaff = Helper.readString("Enter Name of staff > ");
			double price = Helper.readDouble("Enter Price > ");

			Refund re = new Refund(id, name, nameStaff, price, returnPoints);
			return re;

		}

		public static void addRefund(ArrayList<Refund> refundList, Refund re) {
			
			String output = "";
			refundList.add(re);
			System.out.println("Refund added");
			System.out.println(String.format("%-10s %-20s %-10s %-10s\n", "ID", "CUSTOMER NAME", "STAFF NAME", "PRICE"));
			for (int i = 0; i < refundList.size(); i++) {
				if (re.getCustName().equalsIgnoreCase(refundList.get(i).getCustName())) {
					output = "";
					output += String.format("%-10d %-20s %-10s %-10.2f\n", refundList.get(i).getId(),
							refundList.get(i).getCustName(), refundList.get(i).getStaffName()
							, refundList.get(i).getPrice());
					System.out.println(output);
				}
			}
		}

		// ================================= Option 3 Archive=================================
		public static boolean doArchiveExchange(ArrayList<Exchange> exchangeList, int id) {
			boolean isArchived = false;

			for (int i = 0; i < exchangeList.size(); i++) {
				if (id == exchangeList.get(i).getId()) {
					exchangeList.remove(i);
					isArchived = true;
				}
			}
			return isArchived;

		}

		public static void archiveExchange(ArrayList<Exchange> exchangeList) {
			C206_CaseStudy.viewAllExchange(exchangeList);
			int id = Helper.readInt("Enter ID > ");
			Boolean isArchived = doArchiveExchange(exchangeList, id);

			if (isArchived == false) {
				System.out.println("Invalid ID");
			} else {
				System.out.println("Exchange " + id + " archived");
			}
		}

		public static boolean doArchiveRefund(ArrayList<Refund> refundList, int id) {
			boolean isArchived = false;

			for (int i = 0; i < refundList.size(); i++) {
				if (id == refundList.get(i).getId()) {
					refundList.remove(i);
					isArchived = true;
				}
			}
			return isArchived;

		}

		public static void archiveRefund(ArrayList<Refund> refundList) {
			C206_CaseStudy.viewAllRefund(refundList);
			int id = Helper.readInt("Enter ID > ");
			Boolean isArchived = doArchiveRefund(refundList, id);

			if (isArchived == false) {
				System.out.println("Invalid ID");
			} else {
				System.out.println("Refund " + id + " archived");
			}
		}
		
		// ================================= Option 4 Update=================================
		public static boolean checkExchangeID(ArrayList<Exchange> exchangeList, int id) {
			boolean exist = false;
			for (int i = 0; i < exchangeList.size(); i++) {
				if (exchangeList.get(i).getId() == id)
					exist = true;
			}
			return exist;
		}
		
		public static void updateExchange(ArrayList<Exchange> exchangeList, int id) {
			
			String output = "";
			String name = Helper.readString("Enter updated name > ");
			String nameStaff = Helper.readString("Enter updated Staff name > ");
			double price = Helper.readDouble("Enter updated price > ");
			int pos = 0;
			for (int i=0;i< exchangeList.size();i++) {
				if (exchangeList.get(i).getId() == id ) {
					pos = i;
					break;
				}
			}
			
			exchangeList.get(pos).setCustName(name);
			exchangeList.get(pos).setStaffName(nameStaff);
			exchangeList.get(pos).setPrice(price);
		
			
			System.out.println("Exchange updated");
			System.out.println(String.format("%-10s %-20s %-10s %-10s\n", "ID", "CUSTOMER NAME", "STAFF NAME", "PRICE"));
			for (int i = 0; i < exchangeList.size(); i++) {
				if (exchangeList.get(pos).getCustName().equalsIgnoreCase(exchangeList.get(i).getCustName())) {
					output = "";
					output += String.format("%-10d %-20s %-10s %-10.2f\n", exchangeList.get(i).getId(),
							exchangeList.get(i).getCustName(), exchangeList.get(i).getStaffName()
							, exchangeList.get(i).getPrice());
					System.out.println(output);
				}
			}
		}
		
		public static boolean checkRefundID(ArrayList<Refund> refundList, int id) {
			boolean exist = false;
			for (int i = 0; i < refundList.size(); i++) {
				if (refundList.get(i).getId() == id)
					exist = true;
			}
			return exist;
		}

		public static void updateRefund(ArrayList<Refund> refundList, int id) {
			
			String output = "";
			String name = Helper.readString("Enter updated name > ");
			String nameStaff = Helper.readString("Enter updated Staff name > ");
			double price = Helper.readDouble("Enter updated price > ");
			int pos = 0;
			for (int i=0;i< refundList.size();i++) {
				if (refundList.get(i).getId() == id ) {
					pos = i;
					break;
				}
			}
			
			refundList.get(pos).setCustName(name);
			refundList.get(pos).setStaffName(nameStaff);
			refundList.get(pos).setPrice(price);
			
			System.out.println("Refund updated");
			System.out.println(String.format("%-10s %-20s %-10s %-10s\n", "ID", "CUSTOMER NAME", "STAFF NAME", "PRICE"));
			for (int i = 0; i < refundList.size(); i++) {
				if (refundList.get(pos).getCustName().equalsIgnoreCase(refundList.get(i).getCustName())) {
					output = "";
					output += String.format("%-10d %-20s %-10s %-10.2f\n", refundList.get(i).getId(),
							refundList.get(i).getCustName(), refundList.get(i).getStaffName()
							, refundList.get(i).getPrice());
					System.out.println(output);
				}
			}
		}
		
		// !! END OF TRANSACTION METHODS !!
		
		
		
		// !! PROCEDURE METHODS !!
		
		public static String retrieveAllProcedures(ArrayList<procedure_types> procedureList) {
			String output = "";
			
			for(int i = 0; i < procedureList.size() ; i++) {
				
				output += String.format("%d.%-10s (Added on >%-10s) %-30s \n", i+1 , 
						procedureList.get(i).getType() , 
						procedureList.get(i).getDateTime(),
						procedureList.get(i).getDescription());
				
			}
			return output;
		}
		public static void viewAllProcedures(ArrayList<procedure_types> procedureList) {
			Trial_MainClass.setHeader("PROCEDURE LIST");
			String output = String.format("%-10s \n", "PROCEDURE TYPE");
			 output += retrieveAllProcedures(procedureList);	
			System.out.println(output);
		}
		
		public static procedure_types inputProcedure() {
			String type = Helper.readString("Enter procedure type > ");
			String desc = Helper.readString("Enter short description of procedure > ");
			Date currentDateTime = new Date();
			procedure_types pt= new procedure_types(type , desc , currentDateTime);
			return pt;
			
		}
		public static void addProcedure(ArrayList<procedure_types> procedureList, procedure_types pt) {
			
			procedureList.add(pt);
			System.out.println("Procedure added!");
		}
		
		public static void deleteProcedure(ArrayList<procedure_types> procedureList) {
			String type = Helper.readString("Enter procedure type to delete> ");
			
			for (int i = 0; i < procedureList.size(); i++) {
				if (procedureList.get(i).getType().equalsIgnoreCase(type)) {
					procedureList.remove(i);
					System.out.println("Procedure deleted!");
				}
			}
		}
		public static void updateDate(ArrayList<procedure_types> procedureList) {
			String type = Helper.readString("Enter Procedure Type> ");
			String newDate = Helper.readString("Enter new Date and Time (dd/MM/yy HH:mm:ss format)> " );
			
			Date date = new Date();
			try{
			  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			  date = sdf.parse(newDate);
			} catch(ParseException ex) {
			  System.out.println("Incorrect Format");
			}
			
			for(int i = 0; i < procedureList.size() ; i++) {
				if(procedureList.get(i).getType().equalsIgnoreCase(type)) {
					procedureList.get(i).setDateTime(date);
					System.out.println("Date Updated!");
				}
			}
		}
}
