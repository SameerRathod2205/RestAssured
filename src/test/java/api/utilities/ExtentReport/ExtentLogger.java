package api.utilities.ExtentReport;

public class ExtentLogger {

    public static void info(String message){
        ExtentManager.getEtentTest().info(message);
    }

    public static void pass(String message){
        ExtentManager.getEtentTest().pass(message);
    }

    public static void fail(String message){
        ExtentManager.getEtentTest().fail(message) ;
    }

    public static void skip(String message){
        ExtentManager.getEtentTest().pass(message);
    }


}
