package com.selenium.cbh;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;


public class base {

    public static Properties prop1;

    public static String runOnBs;
    public static String runOnLt;
    public static String runOnSl;
    public static boolean OnCloud;
    public static String bsUser;
    public static String ltUser;
    public static String bsAccessKey;
    public static String ltAccessKey;
    public static String cloudName;
    public static String threadCount;


     public static WebDriver driver = null;
//  public WebChromePage wp = new WebChromePage(driver);

public Utilities u;

public static global config = ConfigFactory.create(global.class);

    static {
        try {
            prop1= Utilities.talkToProperties("other");
        } catch (IOException e) {
            e.printStackTrace();
        }

        String Os = System.getProperty("os.name");
        if (Os.contains("Windows")) {
            runOnBs = config.runOnBrowserStack();
            runOnLt = config.runOnLambdaTest();
            runOnSl = config.runOnSauceLabs();

            bsUser = config.BS_Username();
            bsAccessKey = config.BS_AccessKey();

            ltUser = config.LT_Username();
            ltAccessKey = config.LT_AccessKey();

        } else {
            //For Linux machine which gets allocated by Bitrise CI CD .
            try {
                cloudName = System.getenv("CLOUD_NAME");
                if (cloudName.contentEquals("BS")) {
                    System.out.println("Browserstack selected by CI tool");
                    runOnBs = "YES";
                    runOnLt = "NO";
                    runOnSl = "NO";
                    //
                    bsUser = System.getenv("CLOUD_USERNAME");
                    bsAccessKey= System.getenv("CLOUD_ACCESS_KEY");

                } else if (cloudName.contentEquals("LT")) {
                    System.out.println("LambdaTest selected by CI tool");
                    runOnBs = "NO";
                    runOnLt = "YES";
                    runOnSl = "NO";
                    //
                    ltUser = System.getenv("CLOUD_USERNAME");
                    ltAccessKey= System.getenv("CLOUD_ACCESS_KEY");

                } else if (cloudName.contentEquals("SL")) {
                    System.out.println("SauceLabs selected by CI tool");
                    runOnBs = "NO";
                    runOnLt = "NO";
                    runOnSl = "YES";
                    //Not Really using Saucelab , just a placeholder
                }
            }catch(java.lang.NullPointerException npe){
                npe.getMessage();
            }

        }

        // threadCount for Windows and linux both.
        threadCount = prop1.getProperty("threadCount");
        System.out.println("Thread count is: "+threadCount);

        try {
            OnCloud = Utilities.runOnCloud();
        } catch (IOException  | java.lang.NullPointerException e ) {
            e.printStackTrace();
        }

    }

}
