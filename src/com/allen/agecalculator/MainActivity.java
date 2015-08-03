package com.allen.agecalculator;

import com.allen.agecalculator.R;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
    private Button btnStart;
    static final int DATE_START_DIALOG_ID = 0;
    private int startYear=1975;
    private int startMonth=6;
    private int startDay=15;
    private AgeCalculation age = null;
    private TextView currentDate;
    private TextView birthDate;
    private TextView result;
   
    
    
    
    
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
        age=new AgeCalculation();
        
        //Assign the view of today 
        currentDate=(TextView) findViewById(R.id.textView1);
        
        //Display the calendar detail of today
        age.getCurrentDate(); //Get the value of today and make them correct
        currentDate.setText(getString(R.string.today_show_format)+ '\n'+ age.endYear + 
        		getString(R.string.year)+ age.endMonth + getString(R.string.month)+
        	    age.endDay + getString(R.string.day)
        		);
        
        //Assign rest views
        birthDate=(TextView) findViewById(R.id.textView2);
        result=(TextView) findViewById(R.id.textView3);
        btnStart=(Button) findViewById(R.id.button_inputbirthday);
        btnStart.setOnClickListener(this);
      
    }
    
   
  //Set click listener to see if the button is pressed 
    @SuppressWarnings("deprecation")
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button_inputbirthday:
			showDialog(DATE_START_DIALOG_ID);
			break;
        
		default:
			break;
		}
	}
    
    
    //Summon an input dialog for selecting the birthday value
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
        case DATE_START_DIALOG_ID:
            return new DatePickerDialog(this,
                        mDateSetListener,
                        startYear, startMonth, startDay);
         }
        return null;
     }
    
   //Set the values selected into birthday variables
    private DatePickerDialog.OnDateSetListener mDateSetListener 
    = new DatePickerDialog.OnDateSetListener() {
    	public void onDateSet(DatePicker view, int selectedYear,
				int selectedMonth, int selectedDay) {
    		     age.startYear=selectedYear;
    		 	 age.startMonth=selectedMonth;
    		 	 age.startDay=selectedDay;
    		 	 //age.setBirthDay(startYear, startMonth, startDay);
       		     
    		 	 //Show the values of birthday inputed
    		 	 birthDate.setText('\n'+getString(R.string.birthday_show_format)+'\n'
       		    		 +age.startYear + getString(R.string.year) +(age.startMonth+1)
       		    		 +getString(R.string.month)+age.startDay+
       		    		 getString(R.string.day)); 		 	 
    	         calculateAge();
    	}
    };
    
	
	
	private void calculateAge()
	{       
		//Calculate the age with functions in AgeCalculation.java
		age.calcualteYear();
		age.calcualteMonth();
	    age.calcualteDay();
	    
	    //Toast a message to show that the calculation process is over
	  	Toast.makeText(getBaseContext(), getString(R.string.dialogue_content) , Toast.LENGTH_SHORT).show();
	  	
	  	//Show the value of actual 
	  	result.setText('\n'+ getString(R.string.wording_actual_age) + 
	    '\n'+ age.actualYear + getString(R.string.year2)+ age.actualMonth +  getString(R.string.month2)+
	    age.actualDay + getString(R.string.day2));
	  			
	}
	
	
	
	
}
