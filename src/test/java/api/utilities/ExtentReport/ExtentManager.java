package api.utilities.ExtentReport;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {

    private static  ThreadLocal<ExtentTest> extentTest=new ThreadLocal<>();
    public static ExtentTest getEtentTest() {
        return extentTest.get();
    }

    public static void setEtentTest(ExtentTest test) {
        extentTest.set(test);
    }




}
