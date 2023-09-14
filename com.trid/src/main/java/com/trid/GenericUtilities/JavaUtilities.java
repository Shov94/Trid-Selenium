package com.trid.GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class JavaUtilities {

/**
 * This method is used for creating random number
 * @author KARMA
 * @return int
 */
	public int getRandomNo() {

		Random r=new Random();
		int random = r.nextInt(899)+100;
		return random;
	}

/**
 * This method is used to fetch date from system
 * @author KARMA
 * @return String
 */
	public String getSystemDate() {

		Date d=new Date();
		String date=d.toString();
		return date;
	}
/**
 * This method is used to fetch date from system in simple format
 * @author KARMA
 * @return String
 */
	public String getSimpleDateFormat()
	{

		SimpleDateFormat simpleDate=new SimpleDateFormat("dd_MM_yyyy_hh-mm-ss");
		Date d= new Date();
		String systemDateFormat = simpleDate.format(d);
		return systemDateFormat;
	}


}
