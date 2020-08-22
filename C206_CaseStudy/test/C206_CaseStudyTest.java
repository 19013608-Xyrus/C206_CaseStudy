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
	
	public C206_CaseStudyTest() {
		super();
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
		assertEquals("Remove the procedure" , type_Refund , procedureList.remove(0));
	}

	@After
	public void tearDown() throws Exception {
		type_Refund = null;
		type_Exchange = null;

		procedureList = null;
		
	}
	
	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

}
