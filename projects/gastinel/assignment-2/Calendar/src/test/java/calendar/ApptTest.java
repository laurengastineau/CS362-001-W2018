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
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
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
	 }

	 @Test
	  public void testToString()  throws Throwable  {
		 //Construct a new Appointment object with the initial data
		 int startHour=01;
		 int startMinute=11;
		 int startDay=01;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";

		 Appt appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);

		 int startHour2=02;
		 int startMinute2=22;
		 int startDay2=02;
		 int startMonth2=02;
		 int startYear2=2019;

		 Appt appt2 = new Appt(startHour2,
				 startMinute2 ,
				 startDay2 ,
				 startMonth2 ,
				 startYear2,
				 title,
				 description);

		 assertEquals("	1/1/2018 at 1:11am ,Birthday Party, This is my birthday party." + '\n', appt.toString());

		 appt.setStartHour(12);
		 appt.setStartMinute(01);
		 appt.setStartDay(02);
		 appt.setStartMonth(02);
		 appt.setStartYear(2018);
		 assertEquals('\t' + "2/2/2018 at 12:1pm ,Birthday Party, This is my birthday party." + '\n', appt.toString());
	 }

	@Test
	public void testCompareTo()  throws Throwable {
		//Construct a new Appointment object with the initial data
		int startHour = 01;
		int startMinute = 11;
		int startDay = 01;
		int startMonth = 01;
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

		int startHour2 = 02;
		int startMinute2 = 22;
		int startDay2 = 02;
		int startMonth2 = 02;
		int startYear2 = 2019;

		Appt appt2 = new Appt(startHour2,
				startMinute2,
				startDay2,
				startMonth2,
				startYear2,
				title,
				description);

		assertEquals(-15, appt.compareTo(appt2));
	}

	@Test
	public void testIsRecurring()  throws Throwable {
		//Construct a new Appointment object with the initial data
		int startHour = 01;
		int startMinute = 11;
		int startDay = 01;
		int startMonth = 01;
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

		appt.setStartHour(22);
		appt.setStartMinute(12);
		appt.setStartDay(01);
		appt.setStartMonth(02);
		appt.setStartYear(2019);
		appt.setTitle("Vincent is cool");
		appt.setDescription("I guess he is...");

		assertEquals(22, appt.getStartHour());
		assertEquals(12, appt.getStartMinute());
		assertEquals(01, appt.getStartDay());
		assertEquals(02, appt.getStartMonth());
		assertEquals(2019, appt.getStartYear());
		assertEquals("Vincent is cool", appt.getTitle());
		assertEquals("I guess he is...", appt.getDescription());
		assertEquals(true, appt.getValid());

		appt.setTitle(null);
		appt.setDescription(null);
		assertEquals("", appt.getTitle());
		assertEquals("", appt.getDescription());
	}

	@Test
	public void testRepresentationApp()  throws Throwable {
		//Construct a new Appointment object with the initial data
		int startHour = 26;
		int startMinute = 11;
		int startDay = 01;
		int startMonth = 01;
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
	}

	@Test
	public void testRanges()  throws Throwable {
		Appt appt = new Appt(24, 59, 31, 01, 2018, "Title", "Description");
		Appt appt2 = new Appt(25, 0, 01, 12, 2018, "Title", "Description");

		assertEquals(true, appt.getValid()); //expected for this test should be false.
		assertEquals(false,appt2.getValid());
	}

}
