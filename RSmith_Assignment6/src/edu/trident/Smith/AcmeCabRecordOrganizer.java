/**
 * AcmeCabRecordOrganizer takes records from the file through the reaper and 
 * creates a cab object for each new cabID, and stores the record in the correct
 * type array in the correct cab object.  
 * @author Raymond Smith
 */
package edu.trident.Smith;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import edu.trident.Smith.CabRecord.RecordType;

public class AcmeCabRecordOrganizer 
{
		private String cabID = null;
		private RecordType type = null;
		private Date date = null;
		private double value = 0.0;
		private double gasPrice = 0.0;
		private ArrayList<Cab> cabAL = new ArrayList<Cab>();
		private Cab c;
		private CabRecordReaper reaper;
		private Record rec = new Record();
		private final String CAB_RECORD_FILE = "C:/path/to/input.csv";
	
	/**
	 * Constructor
	 * @throws ParseException
	 * @throws IOException 
	 */
	public AcmeCabRecordOrganizer() throws ParseException, IOException
	{		
		reaper = new CabRecordReaper(CAB_RECORD_FILE);
		
		loadRecords();
		for (Cab c : cabAL)
		{			
			c.sortRecordListsByDate();
		}/*End for each loop*/
		
		CabSummaryOutput out = new CabSummaryOutput(cabAL);		
	}/*End AcmeCabRecordOrganizer*/
	
	/**
	 * loads the records into the correct cab object and record array.  
	 * Creates a new cab object when new cabID is discovered
	 * @throws ParseException
	 */
	public void loadRecords()
	{
		int ct = 0;
		while (reaper.hasMoreRecords())
		{
			rec = reaper.getNextRecord();
			cabID = rec.getCabId();
			type = rec.getType();
			value = rec.getValue();		
			ct ++;
			try {
				date = new SimpleDateFormat("yyyy/MM/dd").parse(rec.getDateString());
			} catch (ParseException e) {
				
				System.err.println("Invalid Date on record number " + ct + " in the file\n"
						+ "Record was for " + cabID +" of type "+ type);
				loadRecords();
			}
			if (listContainsCabID(cabAL, cabID))
			{
				
				for (Cab c : cabAL)
				{
					if (c.getCabID().equals(cabID))
					{
						addRecordToCab(c);
					}/*End if cabID exists*/
				}/*End for each loop*/		
			}
			else
			{
				c = new Cab(cabID);
				addRecordToCab(c);
				cabAL.add(c);	
			}/*End if cabId is in list or not*/
		}/*End while reaper has more records*/
	}/*End loadRecords*/
	
	/**
	 * add records to the appropriate array list
	 * @param t
	 */
	public void addRecordToCab(Cab t)
	{
		if(type.equals(RecordType.GAS))
		{
			gasPrice = rec.getPerGallonCost();
			t.addGasRecord(date, value, gasPrice);
		}
		else if(type.equals(RecordType.FARE))
		{
			t.addFareRecord(date, value);
		}
		else if(type.equals(RecordType.SERVICE))
		{
			t.addServiceRecord(date, value);
		}
		else
		{
			System.out.println("Record has incorrect or no Type");
		}/*End if selection for Record Type*/
	}/*End addRecordToCab*/
	
	/**
	 * find out if the cab array list contains the cabID from the record
	 * @param cabAL
	 * @param id
	 * @return
	 */
	public boolean listContainsCabID(ArrayList<Cab> cabAL, String id) 
	{
	    for (Cab c : cabAL) 
	    {
	        if (c.getCabID().equals(id))
	        {
	            return true;
	        }
	    }
	    return false;
	}/*End listContainsCabID*/
	
}/*End AcmeCabRecordOrganizer*/
