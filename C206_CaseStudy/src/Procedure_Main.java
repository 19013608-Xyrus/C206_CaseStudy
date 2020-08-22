import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class Procedure_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<procedure_types> procedureList = new ArrayList <procedure_types>();
		procedureList.add(new procedure_types("Refund" , "Repay customer through points system" , new Date()));
		procedureList.add(new procedure_types("Exchange" , "Exchange goods only if goods were spoilt" , new Date()));
		
		int option = 0;
		
		while (option != 5) {
			Procedure_Main.menu();
			option = Helper.readInt("Enter an option > ");
			
			if (option == 1) {
				Procedure_Main.viewAllProcedures(procedureList);
			} else if (option == 2) {
				procedure_types pt = inputProcedure();
				Procedure_Main.addProcedure(procedureList , pt );
			} else if (option == 3) {
				Procedure_Main.deleteProcedure(procedureList);
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
	
	public static String retrieveAllProcedures(ArrayList<procedure_types> procedureList) {
		String output = "";
		
		for(int i = 0; i < procedureList.size() ; i++) {
			
			output += String.format("%d.%-10s (Added on > %-30s \n", i+1 , 
					procedureList.get(i).getType() , 
					procedureList.get(i).getDateTime(),
					procedureList.get(i).getDescription());
			
		}
		return output;
	}
	public static void viewAllProcedures(ArrayList<procedure_types> procedureList) {
		Procedure_Main.setHeader("PROCEDURE LIST");
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
}
