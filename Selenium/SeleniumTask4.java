package com.github.AtheerAllogamani;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Invoke FireFox Driver
        WebDriver driver = new FirefoxDriver();
        
        // Go to https://www.youtube.com
        driver.get("https://www.youtube.com");

        // Verify the page title contains the word video
        String title=driver.getTitle();
        if("video".equals(title)){
            System.out.println("The title is " + title + " and it contains the word 'video'");
        }
        else{
            System.out.println("The title is " + title + " and it does not contain the word 'video'");
        }

        //Close the driver
        driver.quit();

    }
}
