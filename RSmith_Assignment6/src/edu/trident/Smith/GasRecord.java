/**
 * Gas record that stores the date, gallons and cost/gallon
 * @author Raymond Smith
 */
package edu.trident.Smith;

import java.util.Date;

public class GasRecord 
{
	private Date date;
	private double gallons;
	private double costPer;
	
	/**
	 * Constructor
	 * @param when
	 * @param gal
	 * @param cost
	 */
	public GasRecord(Date when, double gal, double cost)
	{
		date = when;
		gallons = gal;
		costPer = cost;
	}/*End GasRecord*/
	
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
	 * @return gallons
	 */
	public double getGallons()
	{
		return gallons;
	}/*End getGallons*/
	
	/**
	 * 
	 * @return cost per gallons
	 */
	public double getCostPerGallons()
	{
		return costPer;
	}/*End getCostPerGallons*/
	
	/**
	 * sets the date
	 * @param when
	 */
	public void setDate(Date when)
	{
		date = when;
	}/*End setDate*/
	
	/**
	 * sets gallons filled
	 * @param gal
	 */
	public void setGallons(double gal)
	{
		gallons = gal;
	}/*End setGallons*/
	
	/**
	 * set cost per gallons
	 * @param cost
	 */
	public void setCostPerGallons(double cost)
	{
		costPer = cost;
	}/*End setCostPerGallons*/
}/*End GasRecord*/
