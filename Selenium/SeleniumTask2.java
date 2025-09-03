package com.github.AtheerAllogamani;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import java.time.Duration;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        // Open URL: https://www.google.com
        driver.get("https://www.google.com");

        // Maximize the window
        driver.manage().window().maximize();

        // Print the position and size of the page
        System.out.println("The Position: " + driver.manage().window().getPosition());
        System.out.println("The Size: " + driver.manage().window().getSize());

        // Minimize the page
        driver.manage().window().minimize();

        // Wait 5 seconds in the icon state and maximize the page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();


        // Print the position and dimensions of the page in maximized state
        System.out.println("The Maximized Position: " + driver.manage().window().getPosition());
        System.out.println("The Maximized Size: " + driver.manage().window().getSize());

        // Make the page fullscreen
        driver.manage().window().fullscreen();

        // Close the Browser
        driver.quit();


    }
}
