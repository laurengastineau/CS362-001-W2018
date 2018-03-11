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

		LinkedList<CalDay> calDays = new LinkedList<CalDay>();

		CalDay calday = new CalDay(today);
	 	CalDay calday2 = new CalDay(tomorrow);

	 	Appt appt = new Appt(01, 01, 02, 01, 2018, "Birthday Party", "This is my birthday party.");
		Appt appt2 = new Appt(02,02, 01, 02, 2019, "Birthday Party", "This is my birthday party.");
		Appt appt3 = new Appt(25,22, 22, 12, 2020, "Birthday Party", "This is my birthday party.");

		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
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
		 TimeTable timetable2 = new TimeTable();

		 GregorianCalendar today = new GregorianCalendar(2018,01,01);
		 GregorianCalendar tomorrow = new GregorianCalendar(2018,01,10);
		 GregorianCalendar today2 = new GregorianCalendar(2018,01,01);
		 GregorianCalendar tomorrow2 = new GregorianCalendar(2018,01,02);

		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
		 LinkedList<Appt> listAppts2 = new LinkedList<Appt>();

		 int[] recurDays = new int[]{4};

	 	 Appt appt = new Appt(01, 01, 02, 01, 2018, "Birthday Party", "This is my birthday party.");
		 appt.setRecurrence(recurDays, 1, 1, 1000);

		 Appt appt2 = new Appt(01, 01, 02, 01, 2018, "Birthday Party", "This is my birthday party.");
		 appt2.setRecurrence(null, 2, 1, 1000);

		 Appt appt3 = new Appt(01, 01, 02, 01, 2018, "Birthday Party", "This is my birthday party.");
		 appt3.setRecurrence(null, 3, 1, 1000);

		 Appt appt4 = new Appt(01, 01, 02, 01, 2018, "Birthday Party", "This is my birthday party.");
		 appt4.setRecurrence(null, 1, 1, 1000);

		 Appt appt5 = new Appt(25,01,02,01,2018, "Title", "Description");
		 appt4.setRecurrence(null, 1, 1, 1000);

		 Appt appt6 = new Appt(23,59,02,01,2018, "Title", "Description");
		 appt4.setRecurrence(null, 1, 1, 0);
		 assertEquals(true,appt6.getValid());

		 listAppts.add(appt);
		 listAppts.add(appt2);
		 listAppts.add(appt3);
		 listAppts.add(appt4);
		 listAppts.add(appt5);

		 timetable.getApptRange(listAppts, today, tomorrow);

		 //change recurrence of appt4
		 appt4.setRecurrence(null,0,0,1000);
		 timetable.getApptRange(listAppts, today, tomorrow);

		 //timetable given empty appt list
		 timetable2.getApptRange(listAppts2, today, tomorrow);

		 //timetable given invalid app
		 appt6.setStartHour(25);
		 assertEquals(false, appt6.getValid());

		 listAppts2.add(appt6);
		 timetable2.getApptRange(listAppts2, today, tomorrow);

	 }

	@Test
	public void testPermute()  throws Throwable  {
		TimeTable timetable = new TimeTable();

		LinkedList<Appt> listAppts = new LinkedList<Appt>();

		Appt appt = new Appt(01, 01, 02, 01, 2018, "Birthday Party", "This is my birthday party.");
		Appt appt2 = new Appt(02,02, 01, 02, 2019, "Birthday Party", "This is my birthday party.");
		Appt appt3 = new Appt(25,22, 22, 12, 2020, "Birthday Party", "This is my birthday party.");
		Appt appt4 = new Appt(25,22, 22, 12, 2020, "Birthday Party", "This is my birthday party.");

		int [] pv4 = {};
		timetable.permute(listAppts, pv4);

		listAppts.add(appt);
		listAppts.add(appt2);
		listAppts.add(appt3);
		int[] pv = {0, 1, 2};
		timetable.permute(listAppts, pv);

		listAppts.add(appt4);
		int[] pv2 = {0, 1, 2, 3};
		timetable.permute(listAppts, pv2);
	}

	@Test
	public void deleteApptTest()  throws Throwable {
		TimeTable timetable = new TimeTable();

		GregorianCalendar today = new GregorianCalendar(2018,01,01);
		GregorianCalendar tomorrow = new GregorianCalendar(2018,01,10);

		LinkedList<CalDay> calDays = new LinkedList<CalDay>();

		CalDay calday = new CalDay(today);
		CalDay calday2 = new CalDay(tomorrow);

		Appt appt = new Appt(01, 01, 02, 01, 2018, "Birthday Party", "This is my birthday party.");
		Appt appt2 = new Appt(25, 61, 02, 01, 2018, "Birthday Party", "This is my birthday party.");

		LinkedList<Appt> nullListAppts = new LinkedList<Appt>();
		LinkedList<Appt> ListAppts = new LinkedList<Appt>();

		//appts null, apt not null
		assertEquals(null, timetable.deleteAppt(nullListAppts, appt));
		//appts not null, appt null
		assertEquals(null, timetable.deleteAppt(ListAppts, null));
		//appts null, appt null
		assertEquals(null, timetable.deleteAppt(nullListAppts, null));
		//appts not null, appt not null
		assertEquals(null, timetable.deleteAppt(ListAppts, appt));
		//appt not valid
		assertEquals(false, appt2.getValid());
		assertEquals(null, timetable.deleteAppt(ListAppts, appt2));

	}
}
