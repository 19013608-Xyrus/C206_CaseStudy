import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Exchange> exchangeList = new ArrayList<Exchange>();
		ArrayList<Refund> refundList = new ArrayList<Refund>();

		int option = 0;

		while (option != 4) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// View all transactions
				C206_CaseStudy.viewAllExchange(exchangeList);
				C206_CaseStudy.viewAllRefund(refundList);

			} else if (option == 2) {
				// Add transactions
				C206_CaseStudy.setHeader("ADD");
				C206_CaseStudy.setHeader("ITEM TYPES");
				System.out.println("1. Exchange");
				System.out.println("2. Refund");
				int transactionType = Helper.readInt("Enter a transaction type > ");
				if (transactionType == 1) {
					// Add an exchange
					Exchange ex = inputExchange();
					C206_CaseStudy.addExchange(exchangeList, ex);

				} else if (transactionType == 2) {
					// Add a refund
					Refund re = inputRefund();
					C206_CaseStudy.addRefund(refundList, re);

				} else {
					System.out.println("Invalid type");
				}
			} else if (option == 3) {
				// Archive a transaction
				C206_CaseStudy.setHeader("ARCHIVE");
				C206_CaseStudy.setHeader("ITEM TYPES");
				System.out.println("1. Exchange");
				System.out.println("2. Refund");
				int transactionType = Helper.readInt("Enter a transaction type > ");
				if (transactionType == 1) {
					// Add an exchange
					C206_CaseStudy.archiveExchange(exchangeList);

				} else if (transactionType == 2) {
					// Add a refund
					C206_CaseStudy.archiveRefund(refundList);

				} else if (option == 4) {
					System.out.println("Bye!");
				} else {
					System.out.println("Invalid option!");
				}
			}
		}
	}

	public static void menu() {
		C206_CaseStudy.setHeader("DISO APP");
		System.out.println("1. VIEW ALL TRANSACTIONS");
		System.out.println("2. ADD A TRANSACTION");
		System.out.println("3. ARCHIVE A TRANSACTION");
		System.out.println("4. QUIT");
		Helper.line(80, "-");
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	// ================================= Option 1 View=================================
	public static String retrieveAllExchange(ArrayList<Exchange> exchangeList) {
		String output = "";

		for (int i = 0; i < exchangeList.size(); i++) {
			output += String.format("%-10d %-30s %-10.2f\n", exchangeList.get(i).getId(),
					exchangeList.get(i).getName(), exchangeList.get(i).getPrice());
		}
		return output;
	}

	public static void viewAllExchange(ArrayList<Exchange> exchangeList) {
		C206_CaseStudy.setHeader("EXCHANGE LIST");
		String output = String.format("%-10s %-30s %-10s\n", "ID", "NAME", "PRICE");
		output += retrieveAllExchange(exchangeList);
		System.out.println(output);
	}

	public static String retrieveAllRefund(ArrayList<Refund> refundList) {
		String output = "";

		for (int i = 0; i < refundList.size(); i++) {
			output += String.format("%-10d %-30s %-10.2f\n", refundList.get(i).getId(),
					refundList.get(i).getName(), refundList.get(i).getPrice());
		}
		return output;
	}

	public static void viewAllRefund(ArrayList<Refund> refundList) {
		C206_CaseStudy.setHeader("REFUND LIST");
		String output = String.format("%-10s %-30s %-10s\n", "ID", "NAME", "PRICE");
		output += retrieveAllRefund(refundList);
		System.out.println(output);
	}

	// ================================= Option 2 Add=================================
	public static Exchange inputExchange() {
		int id = Helper.readInt("Enter ID > ");
		String name = Helper.readString("Enter Name > ");
		double price = Helper.readDouble("Enter Price > ");
		int topup = 0;

		Exchange ex = new Exchange(id, name, price, topup);
		return ex;

	}

	public static void addExchange(ArrayList<Exchange> exchangeList, Exchange ex) {

		exchangeList.add(ex);
		System.out.println("Exchange added");
	}

	public static Refund inputRefund() {
		int id = Helper.readInt("Enter ID > ");
		String name = Helper.readString("Enter Name > ");
		double price = Helper.readDouble("Enter Price > ");
		int returnPoints = 0;

		Refund re = new Refund(id, name, price, 0);
		return re;

	}

	public static void addRefund(ArrayList<Refund> refundList, Refund re) {

		refundList.add(re);
		System.out.println("Refund added");
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
}
