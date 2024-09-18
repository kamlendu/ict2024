/*
 * ConverterBean.java
 *
 * Created on September 25, 2007, 1:01 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package ejb;

import java.math.BigDecimal;
import javax.ejb.Stateless;


@Stateless(mappedName="ejb/Converter")
public class ConverterBean implements ConverterRemote
{
	private double USD = 0.01021;
	private double INR = 80.589100;

	public double convert(String from, String to, double amount) 
	{
		if(from.equals(to))
		{
			return amount;
		}
		else
		{
			double toRate = findRate(to);
			double result = toRate*amount;
			return result;
		}
	}

	private double findRate(String to)
	{
		double returnValue = 0.0;
		if(to.equals("INR"))
		{
			returnValue = INR;
		}
		if(to.equals("USD"))
		{
			returnValue = USD;
		}
		return returnValue;
	}
}