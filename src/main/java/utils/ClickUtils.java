package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class ClickUtils {

  /**
   * Method clicking on a Button.
   * Return a report error in selenium and QC Report is the eltLocator is not displayed and continue the execution.
   * 
   * @param test
   *          the Selenium test to retrieve driver and reporter instances
   * @param eltLocator
   *          the element locator
   * @param failMessage
   *          the message to display in case of failure
   * @param passMessage
   *          the message to display in case of success
   */
  public static void clickButtonOrFail(WebDriver driver, By eltLocator, String failMessage, String passMessage) {
    WebElement elt = CheckUtils.getElement(driver, eltLocator);
    if (elt != null) {
      if (elt.isDisplayed()) {
        click(driver, eltLocator);
//        test.getReporter()
//            .reportPassed(
//                "Input element " + (eltLocator != null ? eltLocator.toString() : "null") + " is displayed",
//                passMessage);
      }
      else {
//        test.getReporter()
//            .reportFailed(
//                "Input element " + (eltLocator != null ? eltLocator.toString() : "null") + " is not displayed",
//                failMessage);
//        test.getReporter().fail(
//            "Button element " + (eltLocator != null ? eltLocator.toString() : "null") + " is not displayed");
      }
    }
    else {
//      test.getReporter().reportFailed(
//          "Input element " + (eltLocator != null ? eltLocator.toString() : "null") + " does not exist", failMessage);
//      test.getReporter().fail(
//          "Button element " + (eltLocator != null ? eltLocator.toString() : "null") + " does not exist");
    }
  }

  /**
   * Method clicking on a Button.
   * Return a report error in selenium and QC Report is the eltLocator is not displayed and continue the execution.
   * 
   * @param test
   *          the Selenium test to retrieve driver and reporter instances
   * @param eltLocator
   *          the element locator
   * @param failMessage
   *          the message to display in case of failure
   */
  public static void clickButtonOrFail(WebDriver driver, By eltLocator,
      String failMessage) {
    clickButtonOrFail(driver, eltLocator, failMessage, "Clicked");
  }

  /**
   * Method clicking on a Button.
   * Return a report error in selenium and QC Report is the eltLocator is not displayed and continue the execution.
   * 
   * @param test
   *          the Selenium test to retrieve driver and reporter instances
   * @param elt
   *          the WebElement
   * @param failMessage
   *          the message to display in case of failure
   * @param passMessage
   *          the message to display in case of success
   */
  public static void clickButtonOrFail(WebDriver driver, WebElement elt, String failMessage, String passMessage) {
    if (elt != null) {
      if (elt.isDisplayed()) {
        click(driver, elt);
//        test.getReporter().reportPassed("Input element is displayed", passMessage);
      }
      else {
//        test.getReporter().reportFailed("Input element is not displayed", failMessage);
//        test.getReporter().fail("Button element is not displayed");
      }
    }
    else {
//      test.getReporter().reportFailed("Input element does not exist", failMessage);
//      test.getReporter().fail("Button element does not exist");
    }
  }

  /**
   * Method clicking on a Button.
   * Return a report error in selenium and QC Report is the eltLocator is not displayed and continue the execution.
   * 
   * @param test
   *          the Selenium test to retrieve driver and reporter instances
   * @param elt
   *          the WebElement
   * @param failMessage
   *          the message to display in case of failure
   */
  public static void clickButtonOrFail(WebDriver driver, WebElement elt,
      String failMessage) {
    clickButtonOrFail(driver, elt, failMessage, "Clicked");
  }





  /**
   * Method clicking on a Button.
   * Return a report warning (in QC Report) is the elt element is not displayed and continue the execution.
   * 
   * @param test
   *          the Selenium test to retrieve driver and reporter instances
   * @param elt
   *          the WebElement
   * @param warningMessage
   *          the message to display as warning in case of non success
   * @param passMessage
   *          the message to display as passed in case of success
   */
  public static void clickButtonOrWarn(WebDriver driver, WebElement elt, String warningMessage, String passMessage) {
    if (elt != null) {
      if (elt.isDisplayed()) {
        click(driver, elt);
//        test.getReporter().reportPassed("Input element is displayed", passMessage);
      }
      else {
//        test.getReporter().reportWarning("Input element is not displayed", warningMessage);
      }
    }
    else {
//      test.getReporter().reportWarning("Input element does not exist", warningMessage);
    }
  }



  /**
   * Method clicking on a Button.
   * This method also call the savePNGLightReport method to create a report (if selenium.light.report is set to true).
   * 
   * @param test
   *          the Selenium test to retrieve driver and reporter instances
   * @param byElmt
   *          the element locator
   */
  public static void click(WebDriver driver, By byElmt) {
//    test.getReporter().savePNGLightReport();
    WebElement elmt = CheckUtils.getElement(driver, byElmt);
    if (elmt != null && elmt.isDisplayed()) {
      elmt.click();
    }
  }

  /**
   * Method clicking on a Button.
   * This method also call the savePNGLightReport method to create a report (if selenium.light.report is set to true).
   * 
   * @param test
   *          the Selenium test to retrieve driver and reporter instances
   * @param elt
   *          the WebElement
   */
  public static void click(WebDriver driver, WebElement elmt) {
//    test.getReporter().savePNGLightReport();

    if (elmt != null && elmt.isDisplayed()) {
      elmt.click();
    }
  }


  /**
   * Method to enable element display forcefully
   * 
   * @param test
   * @param idAttribute
   */
  public static void enableElementDisplay(WebDriver driver, String idAttribute) {
//    WebDriver driver = test.getDriverInstance();
    JavascriptExecutor JE = (JavascriptExecutor)driver;
    String jsCode = "document.getElementById('" + idAttribute + "')";
    for (int i = 0; i < 100; i++) {
      try {
        String style = (String)JE.executeScript("return " + jsCode + ".style.display;");
        if (style.equals("none")) {
          JE.executeScript(jsCode + ".style.display = '';");
          break;
        }
        jsCode = jsCode + ".parentNode";
      }
      catch (Exception e) {
        // Do nothing
      }
    }
  }

  /**
   * Method to click an element.This method can be used when web driver click doesn't work
   * 
   * @param test
   * @param webElt
   */
  public static void clickElement(WebDriver driver, WebElement webElt) {
//    WebDriver driver = test.getDriverInstance();
    ((JavascriptExecutor)driver)
        .executeScript(
            "var evtObj=null;document.createEvent?(evtObj=document.createEvent(\"MouseEvents\"),evtObj.initMouseEvent(\"click\",!0,!0,document.defaultView,0,0,0,0,0,!1,!1,!1,!1,0,null),arguments[0].dispatchEvent(evtObj)):"
                +
                "(evtObj=document.createEventObject(),evtObj.detail=0,evtObj.screenX=0,evtObj.screenY=0,evtObj.clientX=0,evtObj.clientY=0,evtObj.ctrlKey=!1,evtObj.altKey=!1,evtObj.shiftKey=!1,evtObj.metaKey=!1,evtObj.button=1,arguments[0].fireEvent(\"onclick\",evtObj));"
            , webElt, 0, 0);

  }

  /**
   * Method to click an element.This method can be used when web driver click doesn't work
   * 
   * @param test
   * @param webElt
   */
  public static void mouseOverElement(WebDriver driver, WebElement webElt) {
//    WebDriver driver = test.getDriverInstance();
    ((JavascriptExecutor)driver)
        .executeScript(
            "var evtObj=null;document.createEvent?(evtObj=document.createEvent(\"MouseEvents\"),evtObj.initMouseEvent(\"mouseover\",!0,!0,document.defaultView,0,0,0,0,0,!1,!1,!1,!1,0,null),arguments[0].dispatchEvent(evtObj)):"
                +
                "(evtObj=document.createEventObject(),evtObj.detail=0,evtObj.screenX=0,evtObj.screenY=0,evtObj.clientX=0,evtObj.clientY=0,evtObj.ctrlKey=!1,evtObj.altKey=!1,evtObj.shiftKey=!1,evtObj.metaKey=!1,evtObj.button=1,arguments[0].fireEvent(\"onmouseover\",evtObj));"
            , webElt, 0, 0);

  }

  /**
   * Method to select an option from the drop-down list.This method can be used when selectByVisibleText doesn't work
   * 
   * @param test
   *          SeleniumSEPTest object
   * @param webElt
   *          WebElement of the drop down select tag
   * @param value
   *          Value that has to be selected from the drop-down list
   */
  public static void selectByValue(WebDriver driver, By eltLoc, String value) {
//    WebDriver driver = test.getDriverInstance();
    WebElement elt = CheckUtils.getElement(driver, eltLoc);
    int index = -1;
    if (elt != null) {
      elt.click();
      List<WebElement> options = elt.findElements(By.tagName("option"));
      for (WebElement option : options) {
        String location = option.getText();
        if (location.contains(value)) {
          index = cStringToInt(option.getAttribute("index"));
          option.click();
          break;
        }
      }
    }
    if (index >= 0) {
      ((JavascriptExecutor)driver).executeScript("arguments[0].selectedIndex=arguments[1];", elt, index);
    }
    else {
//      test.getReporter().fail("Option: '" + value + "' not available in the drop down list");
    }
  }
  
  
  /**
   * Method converting a String into an Integer
   * @param valueStr the string containing the integer value
   * @return the integer found, null is the string does not contain a valid integer
   */
  public static Integer cStringToInt(String valueStr) {
    Integer value = null;
    try{
      value = Integer.parseInt(valueStr);
    } catch (Exception e) {
      value = null;
    }
    return value;
  }

  /**
   * Method allowing to click on small images by changing the original size
   * The size change is done through Java script, the WebElemnet must have an HTML Id
   * 
   * @param webElt
   *          the element to click with HTML Id
   */
  public static void clickSmallImage(WebDriver driver, WebElement webElt) {
//    WebDriver driver = test.getDriverInstance();
    if (driver instanceof FirefoxDriver || driver instanceof InternetExplorerDriver) {
      try {
        JavascriptExecutor JE = (JavascriptExecutor)driver;
        String eltID = webElt.getAttribute("id");
        // Save the original image size
        String jsCode = "return document.getElementById('" + eltID + "').style.width;";
        Object wobj = JE.executeScript(jsCode);
        jsCode = "return document.getElementById('" + eltID + "').style.height;";
        Object hobj = JE.executeScript(jsCode);
        // Set new size 15x15
        jsCode = "document.getElementById('" + eltID + "').style.width=\"15px\";";
        JE.executeScript(jsCode);
        jsCode = "document.getElementById('" + eltID + "').style.height=\"15px\";";
        JE.executeScript(jsCode);
        // click
        webElt.click();
        // Reset the original size
        jsCode = "document.getElementById('" + eltID + "').style.width='" + wobj + "';";
        JE.executeScript(jsCode);
        jsCode = "document.getElementById('" + eltID + "').style.height='" + hobj + "';";
        JE.executeScript(jsCode);
      }
      catch (Exception e) {
        // Java script is not working, try the simple Selenium click
        webElt.click();
      }
    }
    else {
      webElt.click();
    }
  }

  /**
   * @deprecated Replaced by {@link #clickButtonOrFail} or {@link #clickButtonOrWarn}<br>
   * 
   *             Method clicking on a Button
   *             Return a report fail is the eltLocator is not displayed.
   * 
   * @param test
   *          the Selenium test to retrieve driver and reporter instances
   * @param eltLocator
   *          the element locator
   */
  @Deprecated
  public static void clickButton(WebDriver driver,
      By eltLocator) {
    WebElement elt = CheckUtils.getElement(driver, eltLocator);
    if (elt != null) {
      if (elt.isDisplayed()) {
        click(driver, eltLocator);
      }
      else {
//        test.getReporter().fail(
//            "Button element " + (eltLocator != null ? eltLocator.toString() : "null") + " is not displayed");
      }
    }
    else {
//      test.getReporter().fail(
//          "Button element " + (eltLocator != null ? eltLocator.toString() : "null") + " does not exist");
    }
  }

}