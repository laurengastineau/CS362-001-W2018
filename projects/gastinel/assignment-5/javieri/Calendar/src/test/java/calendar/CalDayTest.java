package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void testToString()  throws Throwable  {
		 Appt appt = new Appt(01, 11, 01, 01, 2018, "Birthday Party", "This is my birthday party.");

		 LinkedList<Appt> listAppts = new LinkedList<Appt>();

		 GregorianCalendar today = new GregorianCalendar(2018,01,01);

		 CalDay calday = new CalDay(today);

		 assertEquals( "\t --- 1/1/2018 --- \n" +
				 " --- -------- Appointments ------------ --- \n" + "\n", calday.toString());

	 }

	 @Test
	  public void testGetSizeAppts()  throws Throwable  {
		 GregorianCalendar today = new GregorianCalendar(2018,01,01);
		 GregorianCalendar tomorrow = (GregorianCalendar)today.clone();

		 CalDay calday = new CalDay(today);

		 assertEquals(0, calday.getSizeAppts());
	 }

	@Test
	public void testAddAppt()  throws Throwable  {
		Appt appt = new Appt(20, 01, 01, 01, 2018, "Birthday Party", "This is my birthday party.");
		Appt appt2 = new Appt(02,02, 02, 02, 2019, "Birthday Party", "This is my birthday party.");
		Appt appt3 = new Appt(22,22, 22, 12, 2020, "Birthday Party", "This is my birthday party.");
		Appt appt4 = new Appt(-41,12,12,02,2018,"This","is fun!");
		Appt appt5 = new Appt(02, 01, 01, 01,2018,"title", "description");

		GregorianCalendar today = new GregorianCalendar(2018,01,01);

		CalDay calday = new CalDay(today);

		calday.addAppt(appt);
		calday.addAppt(appt2);
		calday.addAppt(appt3);
		calday.addAppt(appt4);
		calday.addAppt(appt5);

		assertEquals(true,calday.isValid());
		assertEquals(true, calday.iterator().hasNext());
		assertEquals("	 --- 1/1/2018 --- \n --- -------- Appointments ------------ --- \n\t2/2/2019 at 2:2am ,Birthday Party, This is my birthday party.\n \t1/1/2018 at 2:1am ,title, description\n \t1/1/2018 at 8:1pm ,Birthday Party, This is my birthday party.\n \t12/22/2020 at 10:22pm ,Birthday Party, This is my birthday party.\n \n", calday.toString());
	}

	@Test
	public void testEmptyCalDay()  throws Throwable {
		CalDay calday2 = new CalDay();

		assertEquals(false, calday2.isValid());
		assertEquals("", calday2.toString());
		assertEquals(null, calday2.iterator());
	}
}
