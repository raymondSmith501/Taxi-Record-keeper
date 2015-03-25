/**
 * CabRecordReaper reads the records from the file and 
 */
package edu.trident.Smith;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import edu.trident.Smith.CabRecord.RecordType;

public class CabRecordReaper
{
	private File inFile;
	private Scanner reader;
	private Record recs;
	private String[] line;
	private ArrayList<Record> recordList; 
	private int ct;
	
	/*
	 * Constructor
	 */
	public CabRecordReaper(String location)
	{
		inFile = new File(location);
	    try 
	    {
			reader = new Scanner(inFile);
		} catch (FileNotFoundException e) {
	
			System.err.println("File not found");
			System.exit(1);
		}
	    recordList = new ArrayList<Record>();
	    recs = new Record();
	    reader.useDelimiter(",");   
	    while (reader.hasNextLine())
	    {
	    	addRecordFromLine();
	    }
	    reader.close();
	    
	    
	    
	}/*End CabRecordReaper*/
	
	/*
	 * Returns true or false depending on if the ArrayList has more records
	 */
	public boolean hasMoreRecords()
	{	
			return (ct < recordList.size());	
	}/*End hasMoreRecords*/
	
	/**
	 * Adds next record from file 
	 * @throws FileNotFoundException 
	 */
	public void addRecordFromLine()
	{
		recs = new Record();
		line = reader.nextLine().split(",");
		
		recs.setDateString(line[0]);
		recs.setCabId(line[1]);
		recs.setType(line[2]);
		try 
		{	
		recs.setValue(Double.parseDouble(line[3]));
		} catch (NumberFormatException e)
		{
			
			System.err.println("There was an invalid number in the record: ");
			for (String s : line)
			{ 
				System.err.print(s + ", ");
			};
			addRecordFromLine();
			
		}
		if(recs.getType() == RecordType.GAS)
		{
			try 
			{	
			recs.setPerGallonCost(Double.parseDouble(line[4]));
			} catch (NumberFormatException e)
			{
				System.err.println("There was an invalid number in the record: ");
				for (String s : line)
				{ 
					System.err.print(s + ", ");
				};
				addRecordFromLine();
				
			}
		}
		recordList.add(recs);
	}/*End addRecordFromLine*/
	
	/**
	 * Returns the currently loaded cab record
	 * @return cab
	 */
	public Record getNextRecord()
	{	
		Record r;
		r = recordList.get(ct);
		ct ++;
		return r;
	}/*End getNextRecord*/
	
}/*End CabRecordReaper*/
