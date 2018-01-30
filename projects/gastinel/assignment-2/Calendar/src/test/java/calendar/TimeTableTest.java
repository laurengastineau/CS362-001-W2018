package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void testDeleteAppts()  throws Throwable  {
	 	TimeTable timetable = new TimeTable();

	 	GregorianCalendar today = new GregorianCalendar(2018,01,01);
		GregorianCalendar tomorrow = new GregorianCalendar(2018,01,10);

		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();

		CalDay calday = new CalDay(today);
	 	CalDay calday2 = new CalDay(tomorrow);

	 	Appt appt = new Appt(01, 01, 02, 01, 2018, "Birthday Party", "This is my birthday party.");
		Appt appt2 = new Appt(02,02, 01, 02, 2019, "Birthday Party", "This is my birthday party.");
		Appt appt3 = new Appt(25,22, 22, 12, 2020, "Birthday Party", "This is my birthday party.");

		listAppts.add(appt);
		listAppts.add(appt2);
		listAppts.add(appt3);

	 	calDays=timetable.getApptRange(listAppts, today, tomorrow);

		LinkedList<Appt> nullListAppts = null;

		assertEquals(null, timetable.deleteAppt(nullListAppts, appt));
		assertEquals(false, appt3.getValid());
		assertEquals(null, timetable.deleteAppt(listAppts, appt3));
		assertEquals(null, timetable.deleteAppt(listAppts, appt));

	 }
	 @Test
	  public void testSetApptOccurences()  throws Throwable  {
		 TimeTable timetable = new TimeTable();

		 GregorianCalendar today = new GregorianCalendar(2018,01,01);
		 GregorianCalendar tomorrow = new GregorianCalendar(2018,01,10);

		 LinkedList<Appt> listAppts = new LinkedList<Appt>();

		 int[] recurDays = new int[]{4};

	 	 Appt appt = new Appt(01, 01, 02, 01, 2018, "Birthday Party", "This is my birthday party.");
		 appt.setRecurrence(recurDays, 1, 1, 1000);

		 Appt appt2 = new Appt(01, 01, 02, 01, 2018, "Birthday Party", "This is my birthday party.");
		 appt2.setRecurrence(null, 2, 1, 1000);

		 Appt appt3 = new Appt(01, 01, 02, 01, 2018, "Birthday Party", "This is my birthday party.");
		 appt3.setRecurrence(null, 3, 1, 1000);

		 Appt appt4 = new Appt(01, 01, 02, 01, 2018, "Birthday Party", "This is my birthday party.");
		 appt4.setRecurrence(null, 1, 1, 1000);


		 listAppts.add(appt);
		 listAppts.add(appt2);
		 listAppts.add(appt3);

		 timetable.getApptRange(listAppts, today, tomorrow);

//		 assertEquals();
	 }

	@Test
	public void testPermute()  throws Throwable  {
		TimeTable timetable = new TimeTable();

		LinkedList<Appt> listAppts = new LinkedList<Appt>();

		Appt appt = new Appt(01, 01, 02, 01, 2018, "Birthday Party", "This is my birthday party.");
		Appt appt2 = new Appt(02,02, 01, 02, 2019, "Birthday Party", "This is my birthday party.");
		Appt appt3 = new Appt(25,22, 22, 12, 2020, "Birthday Party", "This is my birthday party.");

		listAppts.add(appt);
		listAppts.add(appt2);
		listAppts.add(appt3);

		int[] pv = {0,1,2};

		timetable.permute(listAppts, pv);
	}
}
