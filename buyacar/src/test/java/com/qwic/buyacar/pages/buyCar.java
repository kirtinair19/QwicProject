package com.qwic.buyacar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class buyCar {

  public static WebElement element;
  public static Select drpvalue;

  public static WebElement headerBuyCar (WebDriver driver) {
    element = driver.findElement(By.xpath("//div[@class='searchBoxTitle' and text()='Buy a car']"));
    return element;
  }

  public static WebElement brandLabel (WebDriver driver) {
    element = driver.findElement(By.xpath("//label[@class='FormLabel' and strong='Brand:']"));
    return element;
  }

  public static WebElement modelLabel (WebDriver driver) {
    element = driver.findElement(By.xpath("//label[@class='FormLabel' and strong='Model:']"));
    return element;
  }

  public static WebElement keywordLabel (WebDriver driver) {
    element = driver.findElement(By.xpath("//label[@class='FormLabel' and strong='Keyword:']"));
    return element;
  }

  public static WebElement brandDropdown (WebDriver driver) {
    element = driver.findElement(By.name("S1"));
    return element;

//    drpvalue = new Select(driver.findElement(By.name("S1")));
//    return drpvalue;
  }

  public static WebElement modelDropdown (WebDriver driver) {
    element = driver.findElement(By.name("S2"));
    return element;

//    drpvalue = new Select(driver.findElement(By.name("S2")));
//    return drpvalue;
  }

  public static WebElement keywordText (WebDriver driver) {
    element = driver.findElement(By.name("T"));
    return element;
  }

  public static WebElement searchButton (WebDriver driver) {
    element = driver.findElement(By.id("B"));
    return element;
  }


}
