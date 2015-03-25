/**
 * Service Record that stores the date and the cost of service
 * @author Raymond Smith
 */
package edu.trident.Smith;

import java.util.Date;

public class ServiceRecord 
{
	private Date date;
	private double cost;
	
	/**
	 * Constructor
	 * @param when
	 * @param price
	 */
	public ServiceRecord(Date when, double price)
	{
		date = when;
		cost = price;
	}/*End ServiceRecord*/
	
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
	 * @return cost
	 */
	public double getCost()
	{
		return cost;
	}/*End getCost*/
	
	/**
	 * set date of service
	 * @param when
	 */
	public void setDate(Date when)
	{
		date = when;
	}/*End setDate*/
	
	/**
	 * set cost of service
	 * @param price
	 */
	public void setCost(double price)
	{
		cost = price;
	}/*End setCost*/
	
}/*End ServiceRecord*/
