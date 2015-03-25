/**
 * CabRecord is an interface to get record information.
 * @author Raymond
 *
 */
package edu.trident.Smith;
public interface CabRecord 
{
	
	public enum RecordType {FARE, GAS, SERVICE}
	
	public String getCabId();
	
	public RecordType getType();
	 
	public String getDateString();
	
	public double getValue();
	
	public double getPerGallonCost();

}
