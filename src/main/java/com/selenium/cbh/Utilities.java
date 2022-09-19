package com.selenium.cbh;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Properties;

public class Utilities extends base{
    private final WebDriver driverN;

    public Utilities(WebDriver driver) {
        this.driverN = driver;
    }


    public static boolean runOnCloud(String runOnBs, String runOnLt, String runOnSl) throws IOException, NullPointerException {

        boolean c = false;

        if (runOnBs.contains("YES")) {

            System.out.println("Trying to Run on Browserstack");
            return true;
        }

        if (runOnLt.contains("YES")) {
            System.out.println(" Running on Lambdatest ");
            return true;
        }
        if (runOnSl.contains("YES")) {
            System.out.println(" Running on SauceLab ");
            return true;
        }

        return c;

    }

    //If needed, would use this code.
    public static boolean hasQuit(WebDriver driver) {

        try {

            driver.getTitle();

            return false;

        } catch (NoSuchSessionException | SessionNotCreatedException e) {

            return true;

        }
    }

    public static Properties talkToProperties(String name) throws IOException {

        /* System.getProperty("user.dir") method returns Current Project Directory */


        System.out.println(System.getProperty("os.name"));
        Properties prop = new Properties();
        //                    FileInputStream fis2 = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//resources//other.properties");
        if (name.contains("other")) {
//                    FileInputStream fis2 = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//resources//other.properties");
            prop.load(base.class.getClassLoader().getResourceAsStream("other.properties"));
            return prop;
        }

            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main/java//com//selenium//cbh//global.properties");
            prop.load(fis);
            return prop;

        /* prop.load Method will load the .properties file in Properties Java Object*/
    }

    public static boolean isElementExists(WebElement we) {
        boolean isExists = true;
        try {
            we.isDisplayed();
        } catch (StaleElementReferenceException | NoSuchElementException e) {
            isExists = false;
        }
        return isExists;
    }

    public static boolean isByExists(By by, AndroidDriver<AndroidElement> AD) {
        boolean isExists = true;
        try {
            AD.findElement(by);
        } catch (NoSuchElementException nse) {
            isExists = false;
        }
        return isExists;
    }

    public static boolean isByExists(By by, WebDriver WD) {
        boolean isExists = true;
        try {
            WD.findElement(by);
        } catch (NoSuchElementException nse) {
            isExists = false;
        }
        return isExists;
    }


    public static int minutesToMilliSecond(int min) {
        int sec;

        sec = min * 60 * 1000;

        return sec;
    }


    public static String[][] fetchArrayFromPropFile(String propertyName, Properties propFile) {

        //get array split up by the semicolin
        String[] a = propFile.getProperty(propertyName).split(";");

        //create the two dimensional array with correct size
        String[][] array = new String[a.length][a.length];

        //combine the arrays split by semicolin and comma
        for (int i = 0; i < a.length; i++) {
            array[i] = a[i].split(",");
        }
        return array;
    }

    public static byte[] scale(byte[] fileData, int width, int height) {
        ByteArrayInputStream in = new ByteArrayInputStream(fileData);
        try {
            BufferedImage img = ImageIO.read(in);
            if (height == 0) {
                height = (width * img.getHeight()) / img.getWidth();
            }
            if (width == 0) {
                width = (height * img.getWidth()) / img.getHeight();
            }
            Image scaledImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            BufferedImage imageBuff = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            imageBuff.getGraphics().drawImage(scaledImage, 0, 0, new Color(0, 0, 0), null);

            ByteArrayOutputStream buffer = new ByteArrayOutputStream();

            ImageIO.write(imageBuff, "jpg", buffer);

            return buffer.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("IOException in scale");
        }
    }


    public void scrollToViewWeb(WebElement we) throws InterruptedException {
        ((JavascriptExecutor) driverN).executeScript("arguments[0].scrollIntoView(true);", we);
        Thread.sleep(500);
    }
}




