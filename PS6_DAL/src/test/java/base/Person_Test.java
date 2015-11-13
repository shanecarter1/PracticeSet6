package base;

import static org.junit.Assert.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Person_Test {

	private static PersonDomainModel testper;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		Date dDate = null;
		try {
			dDate = (Date) new SimpleDateFormat("yyyy-MM-dd").parse("1972-07-31");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		testper = new PersonDomainModel();
		testper.setFirstName("Bob");
		testper.setLastName("Builder");
		testper.setBirthday(dDate);
		testper.setCity("TheCity");
		testper.setPostalCode(19717);
		testper.setStreet("28 Highway Road");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		PersonDomainModel per;	
		PersonDAL.deletePerson(testper.getPerson());
		per = PersonDAL.getPerson(testper.getPerson());
		assertNull("This person will be removed",per);		
	}
	
	@Test
	public void AddPersonTest()
	{		
		PersonDomainModel per;		
		per = PersonDAL.getPerson(testper.getPerson());		
		assertNull("This person will be removed",per);		
		PersonDAL.addPerson(testper);	
		
		per = PersonDAL.getPerson(testper.getPerson());
		System.out.println(testper.getPerson() + " located");
		assertNotNull("This person will be added",per);
	}
	
	@Test
	public void UpdatePersonTest()
	{		
		PersonDomainModel per;
		final String C_LASTNAME = "TheBuilder";
		
		per = PersonDAL.getPerson(testper.getPerson());		
		assertNull("This person will be removed",per);		
		PersonDAL.addPerson(testper);	
		
		testper.setLastName(C_LASTNAME);
		PersonDAL.updatePerson(testper);
		
		per = PersonDAL.getPerson(testper.getPerson());

		assertTrue("Name Didn't Change",testper.getLastName() == C_LASTNAME);
	}

	@Test
	public void DeletePersonTest()
	{		
		PersonDomainModel per;		
		per = PersonDAL.getPerson(testper.getPerson());		
		assertNull("This person will be removed",per);	
		
		PersonDAL.addPerson(testper);			
		per = PersonDAL.getPerson(testper.getPerson());
		System.out.println(testper.getPerson() + " found");
		assertNotNull("This person will be added",per);
		
		PersonDAL.deletePerson(testper.getPerson(per));
		per = PersonDAL.getPerson(testper.getPerson());		
		assertNull("This person will be removed",per);	
		
	}
	
}
