import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.stream.Collectors;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	
	private procedure_types type_Refund;
	private procedure_types type_Exchange;
	
	private ArrayList<procedure_types> procedureList;
	
	private ArrayList<products> productList;
	
	private Exchange ex1;
	private Exchange ex2;
	private Refund re1;
	private Refund re2;
	
	private ArrayList<Exchange> exchangeList;
	private ArrayList<Refund> refundList;

	private Customer customer1;
	private Customer customer2;
	
	private ArrayList<Customer> customerList;
	private ArrayList<Returns> returnsList;
	
	public C206_CaseStudyTest() {
		super();
		ex1 = new Exchange(1, "Staff 1", "Customer 1", 10, 0);
		ex2 = new Exchange(2, "Staff 2","Customer 2", 20, 0);
		re1 = new Refund(3, "Staff 3", "Customer 3", 30, 0);
		re2 = new Refund(4, "Staff 4", "Customer 4", 40, 0);
		
		exchangeList = new ArrayList<Exchange>();
		refundList = new ArrayList<Refund>();
	}
	@Before
	public void setUp() throws Exception {

		
		type_Refund = new procedure_types("Refund" , "Repay customer through points system");
		type_Exchange = new procedure_types("Exchange", "Exchange goods only if goods were spoilt");

		procedureList= new ArrayList<procedure_types>();
	}
	@Test
	public void addProcedureTest() {
		
		//Repeated items should not be duplicated - Boundary
		assertSame("Check that there are no duplicates",procedureList.size(), procedureList.stream().distinct().collect(Collectors.toList()).size());
	}
	
	@Test
	public void viewProcedureTest() {
		//List must be available for viewing 
		// Item list is not null, so that can add a new item - Normal
		assertNotNull("Check if there is valid procedure arraylist to add to", procedureList);
	}
	
	@Test
	public void deleteProcedureTest() {
		//procedure should be removed after deleted - Error
		//assertEquals("Remove the procedure" , type_Refund , procedureList.remove(0));
		//prepare test data
	}


	@After
	public void tearDown() throws Exception {

		type_Refund = null;
		type_Exchange = null;

		ex1 = null;
		ex2 = null;
		re1 = null;
		re2 = null;
		
		procedureList = null;
	}
	
	@Test
	public void addExchangeTest() {
		//=============================ADDING EXCHANGE=========================================
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Exchange arraylist to add to", exchangeList);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		C206_CaseStudy.addExchange(exchangeList, ex1);
		assertEquals("Check that Exchange arraylist size is 1", 1, exchangeList.size());
		assertSame("Check that Exchange is added", ex1, exchangeList.get(0));
				
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		C206_CaseStudy.addExchange(exchangeList, ex2);
		assertEquals("Check that Exchange arraylist size is 2", 2, exchangeList.size());
		assertSame("Check that Exchange is added", ex2, exchangeList.get(1));
	}
	
	@Test
	public void addRefundTest() {
		//=============================ADDING REFUND============================================
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Test if there is valid Refund arraylist to add to", refundList);
				
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		C206_CaseStudy.addRefund(refundList, re1);		
		assertEquals("Test that Refund arraylist size is 1", 1, refundList.size());
		assertSame("Test that Refund is added", re1, refundList.get(0));
				
		//Add another item. test The size of the list is 2? - normal
		//The item just added is as same as the second item of the list
		C206_CaseStudy.addRefund(refundList, re2);
		assertEquals("Test that Refund arraylist size is 2", 2, refundList.size());
		assertSame("Test that Refund is added", re2, refundList.get(1));
	}
		
	@Test
	public void viewAllExchangeTest() {
		//=============================VIEW ALL EXCHANGE=========================================
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Exchange arraylist to retrieve item", exchangeList);
				
		//test if the list of Exchange retrieved from the SourceCentre is empty - boundary
		String allExchange = C206_CaseStudy.retrieveAllExchange(exchangeList);
		String testOutput = "";
		assertEquals("Check that ViewAllExchangelist", testOutput, allExchange);
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addExchange(exchangeList, ex1);
		C206_CaseStudy.addExchange(exchangeList, ex2);
		assertEquals("Test that Exchange arraylist size is 2", 2, exchangeList.size());
				
		//test if the expected output string same as the list of Exchange retrieved from the SourceCentre	
		allExchange = C206_CaseStudy.retrieveAllExchange(exchangeList);
		testOutput = String.format("%-10d %-20s %-10s %-10.2f\n", 1, "Staff 1", "Customer 1", 10.00);
		testOutput += String.format("%-10d %-20s %-10s %-10.2f\n", 2, "Staff 2", "Customer 2", 20.00);
		System.out.println(testOutput);
		System.out.println(allExchange);
		assertEquals("Test that ViewAllExchangelist", testOutput, allExchange);
	}
	
	@Test
	public void viewAllRefundTest() {
		//=============================VIEW ALL REFUND===========================================
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Refund arraylist to retrieve item", refundList);
						
		//test if the list of Refund retrieved from the SourceCentre is empty - boundary
		String allRefund = C206_CaseStudy.retrieveAllRefund(refundList);
		String testOutput = "";
		assertEquals("Check that ViewAllRefundlist", testOutput, allRefund);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addRefund(refundList, re1);
		C206_CaseStudy.addRefund(refundList, re2);
		assertEquals("Test that Refund arraylist size is 2", 2, refundList.size());
						
		//test if the expected output string same as the list of Refund retrieved from the SourceCentre	
		allRefund = C206_CaseStudy.retrieveAllRefund(refundList);
		testOutput = String.format("%-10d %-20s %-10s %-10.2f\n", 3, "Staff 3", "Customer 3", 30.00);
		testOutput += String.format("%-10d %-20s %-10s %-10.2f\n", 4, "Staff 4", "Customer 4", 40.00);
		System.out.println(testOutput);
		System.out.println(allRefund);
		assertEquals("Test that ViewAllRefundlist", testOutput, allRefund);
	}
	
	@Test
	public void archivingExchangeTest() {
		//==============================ARCHIVING EXCHANGE=======================================
		//boundary
		assertNotNull("Test if there is valid Exchange arraylist to add to", exchangeList);
		C206_CaseStudy.addExchange(exchangeList, ex1);
		//error
		Boolean isArchived = C206_CaseStudy.doArchiveExchange(exchangeList, 1);
		assertTrue("Test if Exchange 1 is archived - true", isArchived);		
		//normal
		C206_CaseStudy.addExchange(exchangeList, ex2);
		isArchived = C206_CaseStudy.doArchiveExchange(exchangeList, 2);
		assertTrue("Test if Exchange 2 is archived - true", isArchived);
		//error
		isArchived = C206_CaseStudy.doArchiveExchange(exchangeList, 3);
		assertFalse("Test if non-existent Exchange 3 is archived - false?", isArchived);
	}
	
	@Test
	public void archivingRefundTest() {
		//==============================ARCHIVING EXCHANGE=======================================
		//boundary
		assertNotNull("Test if there is valid Refund arraylist to add to", refundList);
		C206_CaseStudy.addRefund(refundList, re1);
		//error
		Boolean isArchived = C206_CaseStudy.doArchiveRefund(refundList, 3);
		assertTrue("Test if Refund 3 is archived - true", isArchived);		
		//normal
		C206_CaseStudy.addRefund(refundList, re2);
		isArchived = C206_CaseStudy.doArchiveRefund(refundList, 4);
		assertTrue("Test if Refund 4 is archived - true", isArchived);
		//error
		isArchived = C206_CaseStudy.doArchiveRefund(refundList, 5);
		assertFalse("Test if non-existent Refund 5 is archived - false?", isArchived);
	}
	
	@Test
	public void addProductTest () { 
		//Check the product list  - boundary
		assertNotNull("Test if there is valid product arraylist to add to", productList);
		
		//Add product and check the product is added  - normal
		products_main.addProducts(productList, null);
		assertSame("Check that the product is added", productList.get(0));
		}
	
	@Test
	public void viewAllProductTest () {
		// to check if there is a valid list to view the products from - boundary
		assertNotNull("Test if there is valid Product arraylist to retrieve product", productList);
		
		
	}
	
	@Test
	public void deleteProductTest () {
		// ensure product not in list after deletion - error
		assertEquals("Delete the product" , productList.remove(0));
	}


	// Marcus
	@Test
	public void addCustomer() {
		// Check customer list (Normal)
		assertNotNull("Check if there is valid Customer arraylist to add to", customerList);
		
		// Add customer and check the list and ensure it is 1 (Boundary)
		Customer_Main.addCustomer(customerList, customer1);
		assertSame("Check that Customer is added", customer1, customerList.get(0));
		
		// The customer added is as same as the first customer of the list (Error)
		assertSame("Test that Customer is added same as 1st customer in the list", customer1, customerList.get(0));
	}
	
	@Test
	public void viewcustomerList() {
		// Test if customer list can be viewed (Normal)
		assertNotNull("Test if there is valid Customer arraylist to view", customerList);
		
		// If customer list is empty it should not display anything (Boundary)
		assertNull("Check if customer list is empty", customerList);
		
	    // Customer list is full and cannot add anymore customers (Error)
		Customer_Main.addCustomer(customerList, customer1);
	    assertEquals("Test that Customer arraylist size is 2", 2, customerList.size());
	
	}
	
	@Test
	public void deleteCustomer() {
		// Delete a customer in the list (Normal)
		Customer_Main.deleteCustomer(customerList, customer1);
		
		// Same customer cannot be deleted more than once (Boundary)
		assertSame("Test that the same customer is not deleted more than once", customer1, customerList.get(0));
		
		// If customer list is empty it should not delete anything (Error)
		assertNull("Check if customer list is empty", customerList);
	
	}
		
	@Test
	public void updateCustomerReturns()	{
		// View returns list (Normal)
		assertNotNull("Test if there is valid returns arraylist to view", returnsList);
		
		// If the customer does not have any returns it should not display anything (Boundary)
		assertNull("Check that returns list is empty", returnsList);
		
		// If the returns list is empty it should not update anything (Error)
		assertNull("Check if returns list is empty", returnsList);
	}

}
	

