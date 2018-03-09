package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void testGetters()  throws Throwable  {

		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(21, 30, 15,01 ,2018,"Birthday Party","This is my birthday party.");

		 // assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());

		 //NEW TESTS
		 assertEquals(0, appt.getRecurNumber());
		 assertEquals(2, appt.getRecurBy());
		 assertEquals(0, appt.getRecurIncrement());

		 appt.setRecurrence(null, 1, 1, 1);
		 assertEquals(1, appt.getRecurIncrement());
		 assertEquals(1, appt.getRecurNumber());

	 }

	 @Test
	  public void testToString()  throws Throwable  {
		 //Construct a new Appointment object with the initial data
		 Appt appt = new Appt(01, 11 , 01 , 01 , 2018 , "Birthday Party", "This is my birthday party.");

		 Appt appt2 = new Appt(02,22 ,02,02 ,2019,"Birthday Party","This is my birthday party.");

		 assertEquals("	1/1/2018 at 1:11am ,Birthday Party, This is my birthday party." + '\n', appt.toString());

		 //change appt parameters:
		 appt.setStartHour(12);
		 appt.setStartMinute(01);
		 appt.setStartDay(02);
		 appt.setStartMonth(02);
		 appt.setStartYear(2018);
		 assertEquals('\t' + "2/2/2018 at 12:1pm ,Birthday Party, This is my birthday party." + '\n', appt.toString());

		 //invalid hour, so string will return null
		 Appt appt3 = new Appt(-1, 01, 01,01, 2018, "Title", "Description" );
		 assertEquals(null, appt3.toString());

	 }

	@Test
	public void testCompareTo()  throws Throwable {
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(01, 11, 01, 01, 2018, "Birthday Party", "This is my birthday party.");
		Appt appt2 = new Appt(02, 22, 02, 02, 2019, "Birthday", "party.");
		assertEquals(-15, appt.compareTo(appt2));
	}

	@Test
	public void testIsRecurring()  throws Throwable {
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(01, 11, 01, 01, 2018, "Birthday Party", "This is my birthday party.");
		assertEquals(false, appt.isRecurring());
	}

	@Test
	public void testSetters()  throws Throwable {
		//Construct a new Appointment object with the initial data
		int startHour = 26;
		int startMinute = 61;
		int startDay = 32;
		int startMonth = 11;
		int startYear = 2018;
		String title = "Birthday Party";
		String description = "This is my birthday party.";

		Appt appt = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);
		//set valid hour
		appt.setStartHour(22);
		//set valid minute
		appt.setStartMinute(12);
		//set valid day
		appt.setStartDay(01);
		//set valid month
		appt.setStartMonth(02);
		//set valid year
		appt.setStartYear(2019);
		//set valid title
		appt.setTitle("Vincent is cool");
		//set valid description
		appt.setDescription("I guess he is...");

		assertEquals(22, appt.getStartHour());
		assertEquals(12, appt.getStartMinute());
		assertEquals(01, appt.getStartDay());
		assertEquals(02, appt.getStartMonth());
		assertEquals(2019, appt.getStartYear());
		assertEquals("Vincent is cool", appt.getTitle());
		assertEquals("I guess he is...", appt.getDescription());
		assertEquals(true, appt.getValid());

		//set null title
		appt.setTitle(null);
		//set null description
		appt.setDescription(null);
		assertEquals("", appt.getTitle());
		assertEquals("", appt.getDescription());

		//set invalid day
		appt.setStartDay(-1);
		appt.setStartDay(32);
		assertEquals(false,appt.getValid());

		appt.setStartDay(1);
		assertEquals(true, appt.getValid());

		//set invalid hour
		appt.setStartHour(-1);
		appt.setStartHour(25);
		assertEquals(false, appt.getValid());

		appt.setStartHour(1);
		assertEquals(true,appt.getValid());

		appt.setStartMinute(-1);
		appt.setStartMinute(71);
		assertEquals(false, appt.getValid());

		appt.setStartMinute(1);
		assertEquals(true, appt.getValid());

	}

	@Test
	public void testRepresentationApp()  throws Throwable {
		Appt appt = new Appt(26, 11, 01, 01, 2018, "Birthday Party", "This is my birthday party.");
		Appt appt2 = new Appt(01,02,03,03, 2019,"title", "description");
		assertEquals('\t' + "3/3/2019 at 1:2am ,title, description" + '\n', appt2.toString());

		appt2.setStartHour(13);
		assertEquals('\t' + "3/3/2019 at 1:2pm ,title, description" + '\n', appt2.toString());
		appt2.setStartHour(11);
		assertEquals('\t' + "3/3/2019 at 11:2am ,title, description" + '\n', appt2.toString());
		appt2.setStartHour(12);
		assertEquals('\t' + "3/3/2019 at 12:2pm ,title, description" + '\n', appt2.toString());
		appt2.setStartHour(0);
		assertEquals('\t' + "3/3/2019 at 12:2am ,title, description" + '\n', appt2.toString());




	}

	@Test
	public void testRanges()  throws Throwable {

	 	//has false startHour (hour > 23):
		Appt appt = new Appt(18, 59, 31, 01, 2018, "Title", "Description");
		appt.setStartHour(25);
		assertEquals(false, appt.getValid());
		appt.setStartHour(23);
		assertEquals(true, appt.getValid());
		appt.setStartHour(-1);
		assertEquals(false, appt.getValid());
		appt.setStartHour(0);
		assertEquals(true, appt.getValid());

		//has false startMinute (minute < 0)
		appt.setStartMinute(-1);
		assertEquals(false, appt.getValid());
		appt.setStartMinute(0);
		assertEquals(true, appt.getValid());
		appt.setStartMinute(61);
		assertEquals(false, appt.getValid());
		appt.setStartMinute(59);
		assertEquals(true, appt.getValid());

		//has false startHour (hour < 0):
		Appt appt2 = new Appt(-1, 0, 01, 12, 2018, "Title", "Description");
		assertEquals(false,appt2.getValid());

		//has false startMinute (minute > 59):
		Appt appt4 = new Appt (01, 60, 31, 01, 2018, "Title", "Description");
		assertEquals(false, appt4.getValid());

		//has true StartHour (0 < hour > 23) and true startMinute (0 < minute > 60):
		Appt appt5 = new Appt (01, 01, 31, 01, 2018, "Title", "Description");
		assertEquals(true, appt5.getValid());
	}

}
