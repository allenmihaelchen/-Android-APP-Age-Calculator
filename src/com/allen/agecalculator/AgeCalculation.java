package com.allen.agecalculator;

import java.util.Calendar;

public class AgeCalculation {
    //set up the variable needed
	public int startYear;
	public int startMonth;
	public int startDay;
    public int endYear;
    public int endMonth;
    public int endDay;
    public int actualYear;
    public int actualMonth;
    public int actualDay;
    //private Calendar start;
    private Calendar end;
    public void getCurrentDate()
	{
		  end=Calendar.getInstance();
		  endYear=end.get(Calendar.YEAR);
		  endMonth=end.get(Calendar.MONTH);
		  endMonth++; //Java Calendar are 0-indexed, so we have to add 1 to reflect the reality
		  endDay=end.get(Calendar.DAY_OF_MONTH);
		  
	}
    
   
    
	public void calcualteYear()
	{
		actualYear=endYear-startYear;
		 
	}
	
	public void calcualteMonth()
	{
		if(endMonth>=(startMonth+1))
		{
			 actualMonth= endMonth-(startMonth+1);
		}
		else
		{
			actualMonth=endMonth-(startMonth+1);
			actualMonth=12+actualMonth;
			actualYear--;
		}
	 
	}
	public void  calcualteDay()
	{

		if(endDay>=startDay)
		{
			 actualDay= endDay-startDay;
		}
		else
		{
			actualDay=endDay-startDay;
			actualDay=30+actualDay;
			if(actualMonth==0)
			{
				actualMonth=11;
				actualYear--;
			}
			else
			{
				actualMonth--;
			}
			 
		}
	}
	 
	
}
