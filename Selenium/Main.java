package com.github.AtheerAllogamani;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        // Navigate to URL: https://clarusway.com
        driver.navigate().to("https://clarusway.com/");
        // Navigate to URL: http://amazon.com
        driver.navigate().to("http://amazon.com/");
        // Come back to the Clarusway using the back command.
        driver.navigate().back();
        // Again go back to the amazon website using forward command
        driver.navigate().forward();
        // Refresh the Browser using refresh command
        driver.navigate().refresh();
        // Close the Browser
        driver.quit();

    }
}