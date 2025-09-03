package com.github.AtheerAllogamani;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Invoke Chrome Driver
        WebDriver driver = new ChromeDriver();

        // Navigate to Facebook homepage URL: https://www.facebook.com/
        driver.navigate().to("https://www.facebook.com/");

        // Verify expected equals actual URL
        String url = driver.getCurrentUrl();
        if("https://www.facebook.com/".equals(url)){
            System.out.println("The URL is " + url + " and it equals the actual URL 'https://www.facebook.com/'");
        }
        else{
            System.out.println("The URL is " + url + " and it is not equal to the actual URL 'https://www.facebook.com/");
        }

        // Verify expected contains Facebook Word ( it does give true output if the F is in lower case )
        if(url.contains("Facebook")){
            System.out.println("The URL is " + url + " and it contains 'Facebook' Word");
        }
        else{
            System.out.println("The URL is " + url + " and it does not contain 'Facebook' Word");
        }

    }
}