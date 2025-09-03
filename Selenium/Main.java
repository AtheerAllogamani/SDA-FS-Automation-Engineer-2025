package com.github.AtheerAllogamani;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        // Go to the Amazon URL : https://www.amazon.com
        driver.get("https://www.amazon.com");

        // Print the position and size of the page
        System.out.println("The Original Position: " + driver.manage().window().getPosition());
        System.out.println("The Original Size: " + driver.manage().window().getSize());

        // Adjust the position and size of the page as desired
        driver.manage().window().setPosition(new org.openqa.selenium.Point(100, 100));
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(1200, 800));

        // Test that the page is in the position and size you want
        System.out.println("The Updated  Position: " + driver.manage().window().getPosition());
        System.out.println("The Updated  Size: " + driver.manage().window().getSize());

        // Close the page
        driver.quit();

    }
}