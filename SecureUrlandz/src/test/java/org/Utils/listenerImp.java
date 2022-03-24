package org.Utils;




import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.nio.charset.StandardCharsets;

import java.util.Base64;




import org.secureurlandz.SeleniumFramework.SeleniumFramework;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class listenerImp extends SeleniumFramework implements ITestListener{


    public void onTestStart(ITestResult result) {

        //before each test case
        test=extent.createTest( result.getMethod().getMethodName());
        createTest( "Pradheep", "Sanity");


    }

    public void onTestSuccess(ITestResult result) {
        stepReport("Pass", "Test Case :  "+result.getMethod().getMethodName()+"   _Is Passed");




        try {
            String ScreenshotsPath = SeleniumFramework.getScreenshot(result.getMethod().getMethodName()+".jpg");
            File file = new File(ScreenshotsPath);
            FileInputStream fileInput = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            fileInput.read(bytes);
            String base64 = new String(Base64.getEncoder().encode(bytes), StandardCharsets.UTF_8);
           // test.addScreenCaptureFromBase64String(ScreenshotsPath);

            test.pass(MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());

        } catch (IOException e) {

        }
    }


    public void onTestFailure(ITestResult result) {
       test.log(Status.FAIL, "Test Case :"+result.getMethod().getMethodName()+"___is Failed");
        test.log(Status.FAIL,result.getThrowable() );



        try {
        	
            String ScreenshotsPath = SeleniumFramework.getScreenshot(result.getMethod().getMethodName()+".jpg");
            File file = new File(ScreenshotsPath);
            FileInputStream fileInput = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            fileInput.read(bytes);
            String base64 = new String(Base64.getEncoder().encode(bytes), StandardCharsets.UTF_8);
            // test.addScreenCaptureFromBase64String(ScreenshotsPath);

            test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());

        } catch (IOException e) {
        	e.printStackTrace();

        }




//        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        BufferedImage img = null;
//        try {
//            img = ImageIO.read(screen);
//        } catch (IOException e1) {
//
//            e1.printStackTrace();
//        }
//        File filetest = Paths.get(".").toAbsolutePath().normalize().toFile();
//        try {
//            ImageIO.write(img, "png", new File(filetest + "\\Screenshots\\" +result.getName()+ ".png"));
//        } catch (IOException e) {
//
//            e.printStackTrace();
//        }
//
//        //Log Screenshot in Report
//        test.fail("Details of " + "Test screenshot", MediaEntityBuilder
//                .createScreenCaptureFromPath(System.getProperty("user.dir") + "./Screenshots/" +result.getName()+ ".png").build());

    }



    public void onTestSkipped(ITestResult result) {

        stepReport("Skip", "Test Case : "+result.getMethod().getMethodName()+"isSkiped");

    }




    public void onStart(ITestContext context) {
        //setup method call

        extent = ExtentManager.startReport();

    }





    public void onFinish(ITestContext context) {
        // close extent
        extent.flush();

    }




}
