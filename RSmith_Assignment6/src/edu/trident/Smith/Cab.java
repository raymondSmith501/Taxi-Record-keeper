/**
 * Cab represents a cab in the Acme fleet.  Holds the cabID, and lists of the 
 * service, fare and gas records seperately
 * @author Raymond Smith
 */
package edu.trident.Smith;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class Cab 
{
	private String cabID;
	private ArrayList<ServiceRecord> service;
	private ArrayList<GasRecord> gas;
	private ArrayList<FareRecord> fare;
	private ServiceRecord servRec;
	private FareRecord fareRec;
	private GasRecord gasRec;
	
	/**
	 * Constructor for the Cab
	 * @param id
	 */
	public Cab(String id)
	{
		cabID = id;
		service = new ArrayList<ServiceRecord>();
		gas = new ArrayList<GasRecord>();
		fare = new ArrayList<FareRecord>();
	}/*End Cab*/
	
	/**
	 * Overloads the toString function so when passed into
	 * the Combobox, the cabID will display
	 */
	public String toString()
    {
		return cabID;
    }/*End toString*/
	
	/**
	 * Adds service record to the service array
	 * @param when
	 * @param cost
	 */
	public void addServiceRecord(Date when, double cost)
	{
		servRec = new ServiceRecord(when, cost);
		service.add(servRec);
	}/*End addServiceRecord*/
	
	/**
	 * Adds fare record to the fare array
	 * @param when
	 * @param miles
	 */
	public void addFareRecord(Date when, double miles)
	{
		fareRec = new FareRecord(when, miles);
		fare.add(fareRec);
	}/*End addFareRecord*/
	
	/**
	 * Adds gas record to the gas array
	 * @param when
	 * @param gal
	 * @param cost
	 */
	public void addGasRecord(Date when, double gal, double cost)
	{
		gasRec = new GasRecord(when, gal, cost);
		gas.add(gasRec);
	}/*End addGasRecord*/
	
	/**
	 * 
	 * @return cabID
	 */
	public String getCabID()
	{
		return cabID;
	}/*End getCabID*/
	
	/**
	 *  
	 * @return number of service records
	 */
	public int getNumServRecs()
	{
		return service.size();
	}/*End getNumServRecs*/
	
	/**
	 * 
	 * @return number of fare records
	 */
	public int getNumFareRecs()
	{
		return fare.size();
	}/*End getNumRecs*/
	
	/**
	 * 
	 * @return number of gas records
	 */
	public int getNumGasRecs()
	{
		return gas.size();
	}/*End getNumGasRecs*/
	
	/**
	 * Comparitor for dates in the service records
	 */
	static final Comparator<ServiceRecord> SERV_DATE_COMPARITOR = new Comparator<ServiceRecord>()
		    {
		        public int compare(ServiceRecord first, ServiceRecord second) 
		        {
		            return first.getDate().compareTo(second.getDate());
		        }
		    };
	
	/**
	 * Comparitor for dates in the fare records 
	 */
	static final Comparator<FareRecord> FARE_DATE_COMPARITOR = new Comparator<FareRecord>()
			{
		 		public int compare(FareRecord first, FareRecord second) 
		 		{
		 			return first.getDate().compareTo(second.getDate());
				 }
		    };	
		    
	/**
	 * Comparitor for dates in the gas records
	 */
	static final Comparator<GasRecord> GAS_DATE_COMPARITOR = new Comparator<GasRecord>()
			{
				public int compare(GasRecord first, GasRecord second) 
		        {
		            return first.getDate().compareTo(second.getDate());
		        }
		    };
	
	/**
	 * sorts the arrays of records by date
	 */
	public void sortRecordListsByDate()
	{
		Collections.sort(service, SERV_DATE_COMPARITOR);
		Collections.sort(fare, FARE_DATE_COMPARITOR);
		Collections.sort(gas, GAS_DATE_COMPARITOR);
	}/*End sortRecordListsByDate*/
	
	/**
	 * prints records
	 */
	public void printRecords()
	{
		for (ServiceRecord servRec : service)
		{
			System.out.println("Date: " + servRec.getDate() + " Cost: " + servRec.getCost());
		}
		
		for (FareRecord fareRec : fare)
		{
			System.out.println("Date: " + fareRec.getDate() + " Miles: " + fareRec.getMiles());
		}
		
		for (GasRecord gasRec : gas)
		{
			System.out.println("Date: " + gasRec.getDate() + " Amount: " + gasRec.getGallons() + " Cost/Gal: " + gasRec.getCostPerGallons());
		}
	}/*End printRecords*/
	
	/**
	 * 
	 * @return gross earnings
	 */
	public double grossEarnings()
	{
		double gross = 0.0;
		for (FareRecord fare : fare)
		{
			gross += (2 + (fare.getMiles() *.585));
		}
		
		return gross;
	}/*End grossEarnings*/
	
	/**
	 * Returns net earnings as grossEarnings minus gas and service cost
	 * @return net
	 */
	public double netEarnings()
	{
		double net;
		
		net = (grossEarnings() - getGasCost() - getServiceCost());
		
		return net;
	}/*End netEarnings*/
	
	/**
	 * 
	 * @return total cost of gas
	 */
	public double getGasCost()
	{
		double totalCost = 0;
		for (GasRecord gasRec : gas)
		{
			totalCost += (gasRec.getGallons() * gasRec.getCostPerGallons());
		}
		
		return totalCost;
	}/*End getGasCost*/
	
	/**
	 * 
	 * @return total cost of service
	 */
	public double getServiceCost()
	{
		double totalCost = 0;
		for (ServiceRecord servRec : service)
		{
			totalCost += servRec.getCost();
		}
		
		return totalCost;
	}/*End getServiceCost*/
	
	/**
	 * 
	 * @return total number of miles Driven
	 */
	public double getMilesDriven()
	{
		double totalMiles = 0;
		for (FareRecord fareRec : fare)
		{
			totalMiles += fareRec.getMiles();
		}
		
		return totalMiles;
	}/*End getMilesDriven*/
	
	/**
	 * 
	 * @return average miles between service
	 */
	public double avgMilesService()
	{
		double total = getMilesDriven();
		int count = service.size();
		
		double avg = total / count;
		
		return avg;		
	}/*End avgMilesService*/
	
	/**
	 * 
	 * @return longest length of time between service
	 */
	public int getLongestTimeBtwServ()
	{
		int longest = 0;
		for (int f = 0; f < service.size(); f ++)
		{
			int s = 1;
			ServiceRecord first = service.get(f);
			ServiceRecord second = service.get(s);
			Date one = first.getDate();
			Date two = second.getDate();
			
			Long diff = two.getTime() - one.getTime();
			
			/*Change value from milliseconds to days*/
			Long diffDays = diff / (24 * 60 * 60 * 1000);
			
			int days = diffDays.intValue();
			
			if(days > longest)
			{
				longest = days;
			}
		
			s ++;
		}
		
		
		return longest;
	}/*End getLongestTimeBtwnServ*/
	
	/**
	 * 
	 * @return most amount of miles between service
	 */
	public double getMostMilesBetweenService()
	{
		double mostMiles = 0.0;
		double miles = 0.0;
		
		
		for (FareRecord fareRec : fare)
		{
			if(fareRec.getDate().compareTo(service.get(0).getDate()) <= 0)
			{
				miles += fareRec.getMiles();	
			}/*End if fare records are on or before first service*/
		}/*End for each loop of fare records*/
		
		mostMiles = miles;
		
		for (int f = 0; f < (service.size() - 1); f ++)
		{
			int s = f + 1;
			Date first = service.get(f).getDate();
			Date second = service.get(s).getDate();
			miles = 0.0;
			
			for (int i = 0; i < fare.size(); i ++)
			{
				FareRecord rec = fare.get(i);
				if(rec.getDate().after(first) && rec.getDate().compareTo(second) <= 0)
				{
					miles += rec.getMiles();
					
				}/*End if dates are after first service date and on or before second service date*/
			}/*End For loop going through each FareRecord in fare list*/
			if (miles > mostMiles)
			{
				mostMiles = miles;
			}/*End if miles is more than mostMiles*/
			
			s ++;
			
		}/*End for loop going through each ServiceRecord in the service class*/
		return mostMiles;
	}/*End mostMilesBetweenService*/
	
	/**
	 * Returns first date of records
	 * @return start
	 */
	public Date getStartDate()
	{
		Date start;
		if(service.get(0).getDate().before(fare.get(0).getDate()))
		{
			if (service.get(0).getDate().before(gas.get(0).getDate()))
			{
				start = service.get(0).getDate();
			}
			else
			{
				start = gas.get(0).getDate();
			}
			
		}
		else 
		{
			if (fare.get(0).getDate().before(gas.get(0).getDate()))
			{
				start = fare.get(0).getDate();
			}
			else
			{
				start = gas.get(0).getDate();
			}
		}
		return start;
	}/*End getStartDate*/
	
	/**
	 * Returns last date of records
	 * @return end
	 */
	public Date getEndDate()
	{
		Date end;
		if(service.get(service.size()-1).getDate().after(fare.get(fare.size()-1).getDate()))
		{
			if (service.get(service.size()-1).getDate().after(gas.get(gas.size()-1).getDate()))
			{
				end = service.get(service.size()-1).getDate();
			}
			else
			{
				end = gas.get(gas.size()-1).getDate();
			}
			
		}
		else 
		{
			if (fare.get(fare.size()-1).getDate().after(gas.get(gas.size()-1).getDate()))
			{
				end = fare.get(fare.size()-1).getDate();
			}
			else
			{
				end = gas.get(gas.size()-1).getDate();
			}
		}
		return end;
	}/*End getEndDate*/
	
	
	
	
}
