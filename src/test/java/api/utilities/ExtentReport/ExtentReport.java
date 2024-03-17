package api.utilities.ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
    public static ExtentSparkReporter sparkReporter;
    public static  ExtentReports report;
    public static void initReport(){

         sparkReporter=new ExtentSparkReporter("filePath");
         report=new ExtentReports();
        sparkReporter.config().setReportName("Demo Test");
        sparkReporter.config().setDocumentTitle("API Rest Assured Test");
        sparkReporter.config().setTheme(Theme.DARK);
        report.attachReporter(sparkReporter);
        report.flush();



    }
    public static void createTest(String testCaseName){

        ExtentManager.setEtentTest(report.createTest(testCaseName));
    }


}
