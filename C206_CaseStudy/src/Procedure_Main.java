import java.util.ArrayList;

public class Procedure_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Refund> refundList = new ArrayList<Refund>();
		ArrayList<Exchange> exchangeList = new ArrayList<Exchange>();
		
		
		int option = 0;
		
		while (option != 5) {
			Procedure_Main.menu();
			option = Helper.readInt("Enter an option > ");
			
			if (option == 1) {
				//View all procedures
			} else if (option == 2) {
				//Add procedures
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
		Procedure_Main.setHeader("DISO APP");
		System.out.println("1. VIEW ALL PROCEDURES");
		System.out.println("2. ADD A PROCEDURE");
		System.out.println("3. DELETE A PROCEDURE");
		System.out.println("4. QUIT");
		Helper.line(80, "-");
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");

}
}
