package com.github.AtheerAllogamani;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;




//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();

        // Go to the Amazon URL: https://www.amazon.com/
        driver.get("https://www.amazon.com");

        // Verify that it writes "Performance Metrics" or " Gateway" from the Source code
        String pageSource = driver.getPageSource();
        if (pageSource.contains("Performance Metrics") || pageSource.contains("Gateway")) {
            System.out.println("The source code contains 'Performance Metrics' or 'Gateway'.");
        } else {
            System.out.println("The source code does not contain 'Performance Metrics' or 'Gateway'.");
        }

    }
}