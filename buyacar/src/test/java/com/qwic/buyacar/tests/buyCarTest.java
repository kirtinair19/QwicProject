package com.qwic.buyacar.tests;

import com.qwic.buyacar.common.commonActions;
import com.qwic.buyacar.pages.buyCar;
import java.lang.reflect.Method;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class buyCarTest extends commonActions {

  public static Select drpvalue;

  @Test
  public void headerIsPresent() {
    test = extent.createTest("Verify that the header of the page is present");
    buyCar.headerBuyCar(driver).isDisplayed();
    Assert.assertEquals("Buy a car", buyCar.headerBuyCar(driver).getText());

  }

  @Test
  public void brandLabelCheck() {
    test = extent.createTest("Verify that the Brand label is present");
    buyCar.brandLabel(driver).isDisplayed();
    Assert.assertEquals("Brand:", buyCar.brandLabel(driver).getText());
  }

  @Test
  public void modelLabelCheck() {
    test = extent.createTest("Verify that the Model label is present");
    buyCar.modelLabel(driver).isDisplayed();
    Assert.assertEquals("Brand:", buyCar.modelLabel(driver).getText());
  }

  @Test
  public void keywordLabelCheck() {
    test = extent.createTest("Verify that the Keyword label is present");
    buyCar.keywordLabel(driver).isDisplayed();
    Assert.assertEquals("Brand:", buyCar.keywordLabel(driver).getText());
  }

  @Test
  public void searchButtonCheck() {
    test = extent.createTest("Verify that the Search button is present");
    drpvalue = new Select(buyCar.brandDropdown(driver));
    drpvalue.selectByVisibleText("Audi");
    buyCar.searchButton(driver).isDisplayed();
    Assert.assertEquals("Search Cars", buyCar.searchButton(driver).getText());
  }

  @Test(dataProvider = "brandmodeldata")
  public void selectBrandAndModelSuccess(String brandname, String modelname) {
    test = extent.createTest("Verify that user is able to select brand, model and submit the form successfully");
    drpvalue = new Select(buyCar.brandDropdown(driver));
    drpvalue.selectByVisibleText(brandname);

    drpvalue = new Select(buyCar.modelDropdown(driver));
    drpvalue.selectByVisibleText(modelname);

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("B"));
    buyCar.searchButton(driver).click();

    String text = driver.switchTo().alert().getText();
    System.out.println(text);
    driver.switchTo().alert().accept();
    Assert.assertEquals("{\"model\":\"modelname\",\"brand\":\"brandname\",\"keyword\":\"\"}", text);
  }

  @Test(dataProvider = "brandmodeldata")
  public void selectBrandModelAndKeywordSuccess(String brandname, String modelname, String keywordvalue) {
    test = extent.createTest("Verify that user is able to select brand, model, type the keyword and submit the form successfully");
    drpvalue = new Select(buyCar.brandDropdown(driver));
    drpvalue.selectByVisibleText(brandname);

    drpvalue = new Select(buyCar.modelDropdown(driver));
    drpvalue.selectByVisibleText(modelname);

    buyCar.keywordText(driver).sendKeys(keywordvalue);

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("B"));
    buyCar.searchButton(driver).click();

    String text = driver.switchTo().alert().getText();
    System.out.println(text);
    driver.switchTo().alert().accept();
    Assert.assertEquals("{\"model\":\"modelname\",\"brand\":\"brandname\",\"keyword\":\"keywordvalue\"}", text);
  }

  @DataProvider(name = "brandmodeldata")
  public Object[][] brandmodeldata(Method m) {
    if (m.getName().equalsIgnoreCase("selectBrandAndModelSuccess")) {

      return new Object[][]{
          // @formatter:off
          {"Audi", "A5 Sportback"},
          {"BMW", "i8"},
          {"Hyundai", "Tucson"},
          {"Jaguar", "XK8 Convertible"},
          {"Land Rover", "109"},
          {"Chevrolet", "Camaro"}
          // @formatter:on
      };
    } else {
        return new Object[][]{
            // @formatter:off
            {"Alfa Romeo", "Spider", "Spidey"},
            {"Chrysler", "300 C", "Chrys"},
            {"Mercedes-Benz", "260 - 560 SEL", "MercA1Car"},
            {"Porsche", "Macan", "DreamCar"},
            {"Ford", "Kuga", "Affordable"},
            {"Volvo", "850", "BigCar"}
            // @formatter:on
        };
      }

    }

  }