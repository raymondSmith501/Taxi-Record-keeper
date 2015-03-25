/**
 * Fare record that stores the date and miles of fares
 * @author Raymond Smith
 */
package edu.trident.Smith;

import java.util.Date;

public class FareRecord
{
	private Date date;
	private double miles;
	
	/**
	 * Constructor
	 * @param when
	 * @param far
	 */
	public FareRecord(Date when, double far)
	{
		date = when;
		miles = far;
	}/*End FareRecord*/
	
	/**
	 * 
	 * @return date
	 */
	public Date getDate()
	{
		return date;
	}/*End getDate*/
	
	/**
	 * 
	 * @return miles
	 */
	public double getMiles()
	{
		return miles;
	}/*End getMiles*/
	
	/**
	 * sets date of fare
	 * @param when
	 */
	public void setDate(Date when)
	{
		date = when;
	}/*Ends setDate*/
	
	/**
	 * sets miles of fare
	 * @param far
	 */
	public void setMiles(double far)
	{
		miles = far;
	}/*End setMiles*/
}/*End FareRecord*/
