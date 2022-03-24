package org.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.secureurlandz.SeleniumFramework.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ExtentManager extends SeleniumFramework  {
	
	public static ExtentReports extent ;
	public static ExtentTest test ;
	
	String desc= "";
	String author="";
	String category ="";
	String Os="";
	
    public static ExtentReports startReport(){
    	//get current date
    	SimpleDateFormat format= new SimpleDateFormat("dd-MM-yyy HH-MM-SS");
    	Date date= new Date();
    	String ActualDate= format.format(date);
    	//String Path=System.getProperty("user.dir"+ "./Reports/ExecutionReport_"+ActualDate +".html");
    	
		ExtentSparkReporter reporter = new ExtentSparkReporter("./Reports/TestReport"+ActualDate +".html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		
		
		reporter.config().setDocumentTitle("documentTitle");
		reporter.config().setTheme(Theme.STANDARD);
		
		
		return extent;
	}
	
   public void createTest( String author,String category) {
		
		test.assignAuthor(author);
		test.assignCategory(category);
		
		
    }
    public void stepReport(String Message, String description) {

		switch (Message.toLowerCase()) {
		case "pass":
			test.log(Status.PASS, description);
			
			break;
		case "fail":
			test.log(Status.FAIL, description);
			break;
		case "info":
			test.log(Status.INFO, description);
			break;
		case "warning":
			test.log(Status.WARNING, description);
			break;
		default:
			System.err.println("Status is not defined");
			break;
		}
	}
	

	}


