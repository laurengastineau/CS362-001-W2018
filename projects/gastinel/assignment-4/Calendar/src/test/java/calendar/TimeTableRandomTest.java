package calendar;

import java.sql.Time;
import java.util.*;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
	public static String RandomSelectMethod(Random random){
		String[] methodArray = new String[] {"setTitle","setRecurrence"};// The list of the of methods to be tested in the Appt class

		int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

		return methodArray[n] ; // return the method name
	}
	/**
	 * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	 */
	public static int RandomSelectRecur(Random random){
		int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

		int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
		return RecurArray[n] ; // return the value of the  appointments to recur
	}
	/**
	 * Return a randomly selected appointments to recur forever or Never recur  !.
	 */
	public static int RandomSelectRecurForEverNever(Random random){
		int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

		int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
		return RecurArray[n] ; // return appointments to recur forever or Never recur
	}
	/**
     * Generate Random Tests that tests TimeTable Class.
     */

//	@Test
//	public void radnomtestTimeTable()  throws Throwable {
//		long startTime = Calendar.getInstance().getTimeInMillis();
//		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
//
//		System.out.println("Start testing...");
//
//		try {
//			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
//				long randomseed = System.currentTimeMillis(); //10
//				//			System.out.println(" Seed:"+randomseed );
//				Random random = new Random(randomseed);
//
//				int startHour = ValuesGenerator.RandInt(random);
//				int startMinute = ValuesGenerator.RandInt(random);
//				int startDay = ValuesGenerator.RandInt(random);
//				int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 12);
//				int startYear = ValuesGenerator.RandInt(random);
//				String title = "Birthday Party";
//				String description = "This is my birthday party.";
//
//				//Construct a new Gregorian object with initial data
////				GregorianCalendar today = new GregorianCalendar(startYear, startMonth, startDay);
////				GregorianCalendar tomorrow = new GregorianCalendar(startYear, startMonth, startDay);
//
//
//				GregorianCalendar today = new GregorianCalendar(startYear, 2, 20);
//				GregorianCalendar tomorrow = new GregorianCalendar(startYear, 1, 10);
//
//				//Construct a new Appointment object with the initial data
//				Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
////				Appt appt2 = null;
//				Appt appt3 = new Appt(-1, 61, startDay, startMonth, startYear, title, description);
//
////				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
////				if ((iteration % 10000) == 0 && iteration != 0)
////					System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);
//
//				//Construct new LinkedList<Appt> object
//				LinkedList<Appt> listAppts = new LinkedList<Appt>();
//				//Construct null LinkedList<Appt>
//				LinkedList<Appt> nullListAppts = null;
//
//				//Add initialized appt to listAppts
//				listAppts.add(appt);
//				listAppts.add(appt);
//				listAppts.add(appt);
//				//Add null appt to listAppts
//				listAppts.add(null);
//				//Add invalid appt to listAppts
//				listAppts.add(appt3);
//
//				//Construct new timetable object
//				TimeTable timeTable = new TimeTable();
//				try {
//					timeTable.getApptRange(listAppts, today, tomorrow);
//				}
//				catch (DateOutOfRangeException e) {
//					continue;
//				}
//				/*
//				//Delete initialized appt from listAppts
//				timeTable.deleteAppt(listAppts, appt);
//				//Delete null appt from listAppts
//				timeTable.deleteAppt(listAppts, null);
//				//Delete null appt from nullListAppts
//				timeTable.deleteAppt(nullListAppts, null);
//				//Delete initialzied appt from nullListAppts
//				timeTable.deleteAppt(nullListAppts, appt);
//				*/
//				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
//				if ((iteration % 10000) == 0 && iteration != 0)
//				System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);
//			}
//		}
//		catch(NullPointerException e){
//		}
//		System.out.println("Done testing...");
//	}


	@Test
	public void radnomtestTimeTable1()  throws Throwable  {
		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		System.out.println("Start testing...");

		try{
			CalDay calday = null;
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed = System.currentTimeMillis(); //10
				//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);

				int startHour = ValuesGenerator.RandInt(random);
				int startMinute = ValuesGenerator.RandInt(random);
				int startDay = ValuesGenerator.RandInt(random);
				int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 12);
				int startYear = ValuesGenerator.RandInt(random);
				String title = "Birthday Party";
				String description = "This is my birthday party.";

				int randDay = ValuesGenerator.getRandomIntBetween(random, 1, 30);
				int randDay2 = ValuesGenerator.getRandomIntBetween(random, 1, 30);
				int randMonth = ValuesGenerator.getRandomIntBetween(random, 0, 11);
				int randMonth2 = ValuesGenerator.getRandomIntBetween(random, 0, 11);

				//Construct a new Gregorian object with initial data
				GregorianCalendar today = new GregorianCalendar(startYear, randMonth, randDay);
				GregorianCalendar tomorrow = new GregorianCalendar(startYear, randMonth2, randDay2);

				//Construct a new Appointment object with the initial data
				Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
				Appt appt3 = new Appt(-1, 61, startDay, startMonth, startYear, title, description);

				//Construct new LinkedList<Appt> object
				LinkedList<Appt> listAppts = new LinkedList<Appt>();
				//Construct null LinkedList<Appt>
				LinkedList<Appt> nullListAppts = null;

				//Add initialized appt to listAppts
				listAppts.add(appt);
				listAppts.add(appt);
				listAppts.add(appt);
				//Add invalid appt to listAppts
				listAppts.add(appt3);

				//Construct new timetable object
				TimeTable timeTable = new TimeTable();
				try {
					timeTable.getApptRange(listAppts, today, tomorrow);
				}
				catch (DateOutOfRangeException e) {
					continue;
				}

				//Delete initialized appt from listAppts
				timeTable.deleteAppt(listAppts, appt);
				//Delete null appt from listAppts
				timeTable.deleteAppt(listAppts, null);
				//Delete null appt from nullListAppts
				timeTable.deleteAppt(nullListAppts, null);
				//Delete initialzied appt from nullListAppts
				timeTable.deleteAppt(nullListAppts, appt);


				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if((iteration%10000)==0 && iteration!=0 )
					System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			}
		}
		catch(NullPointerException e){
		}

		System.out.println("Done testing...");
	}

}
