/**
 * Record represents one cab record read from the file
 * @author Raymond Smith
 */
package edu.trident.Smith;

public class Record implements CabRecord 
{
	private String cabID;
	private String date;
	private RecordType type;
	private double value;
	private double perGallonCost;
	
	
	public Record()
	{
	
	}
	@Override
	public String getCabId() 
	{		
		return cabID;
	}
	
	public void setCabId(String id)
	{
		cabID = id;
	}

	@Override
	public RecordType getType()
	{	
		return type;
	}
	
	public void setType(String t)
	{
		switch(t)
		{
		case "FARE":
			type = RecordType.FARE;
			break;
		case "GAS":
			type = RecordType.GAS;
			break;
		case "SERVICE":
			type = RecordType.SERVICE;
			break;
		}
	}

	@Override
	public String getDateString() 
	{
		return date;
	}
	
	public void setDateString(String d)
	{
		date = d;
	}
	

	@Override
	public double getValue() 
	{
		return value;
	}
	
	public void setValue(double v)
	{
		value = v;
	}

	@Override
	public double getPerGallonCost() 
	{
		return perGallonCost;
	}
	
	public void setPerGallonCost(double c)
	{
		perGallonCost = c;
	}

}
