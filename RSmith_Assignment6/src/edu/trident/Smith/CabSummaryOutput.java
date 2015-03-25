package edu.trident.Smith;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CabSummaryOutput 
{
	private ArrayList<Cab> cabList;
	private final String CAB_SUMMARY_FILE = "C:/path/to/output.csv";
	private FileWriter writer;
	
	public CabSummaryOutput(ArrayList<Cab> cabAL) throws IOException 
	{
		cabList = cabAL;
		writer = new FileWriter(CAB_SUMMARY_FILE, true);
		writeHeaders();
		writeCabsToFile();
		writer.flush();
		writer.close();
	}

	/**
	 * Writes headers to the output file
	 * @throws IOException
	 */
	public void writeHeaders() throws IOException
	{
		writer.write("Cab ID,Start Date,End Date,Gas Cost,Service Cost,Gross Earnings,Net Earnings,Miles Driven,"
				+ "Services Performed,Average Service,Max Service Days\n");
	}
	
	public void writeCabsToFile() throws IOException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
		for (Cab c : cabList)
		{
			writer.write(c.getCabID()  + "," + sdf.format(c.getStartDate()) + "," + sdf.format(c.getEndDate()) + "," + c.getGasCost() + "," + c.getServiceCost()
					+ "," + c.grossEarnings() + "," + c.netEarnings() + "," + c.getMilesDriven() + "," + c.getNumServRecs() + ","
					+ c.avgMilesService() + "," + c.getLongestTimeBtwServ() + "\n");
		}
	}
	
}
