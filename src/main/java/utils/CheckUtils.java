package utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckUtils {

  /**
   * Method checking if an element exists by using the WebDriver:findElement method
   * 
   * @param test
   *          the Selenium test to retrieve driver and reporter instances
   * @param eltLocator
   *          the element locator
   * @return the first element found if it exists, null otherwise
   */
  static public WebElement getElement(WebDriver driver, By eltLocator) {
    return getElement(driver, null, eltLocator);
  }

  /**
   * Method checking if an element exists based on a referenced web element by using the WebElement:findElement method
   * 
   * @param test
   *          the Selenium test to retrieve driver and reporter instances
   * @param referenceElt
   *          the reference web element to search for
   * @param eltLocator
   *          the element locator
   * @return the first element found if it exists, null otherwise
   */
  static public WebElement getElement(WebDriver driver, WebElement referenceElt, By eltLocator) {
    // retrieve selenium and reporter objects
//    WebDriver driver = test.getDriverInstance();

    WebElement eltFound = null;
      // Debug mode activated
      try {
        if (referenceElt == null) {
          eltFound = driver.findElement(eltLocator);
        }
        else {
          eltFound = referenceElt.findElement(eltLocator);
        }
        // highlightElement(test, eltFound);
      }
      catch (NoSuchElementException e) {
        // Elt not found
        eltFound = null;
      }
    return eltFound;
  }

  /**
   * Method checking if an elements list exists by using the WebDriver:findElements method
   * 
   * @param test
   *          the Selenium test to retrieve driver and reporter instances
   * @param eltLocator
   *          the element locator
   * @return the list of elements found, or an empty list if nothing matches
   */
  static public List<WebElement> getElements(WebDriver driver, By eltLocator) {
    return getElements(driver, null, eltLocator);
  }

  /**
   * Method checking if an elements list exists based on a referenced web element by using the WebElement:findElements
   * method
   * 
   * @param test
   *          the Selenium test to retrieve driver and reporter instances
   * @param referenceElt
   *          the reference web element to search for
   * @param eltLocator
   *          the element locator
   * @return the list of elements found, or an empty list if nothing matches
   */
  static public List<WebElement> getElements(WebDriver driver, WebElement referenceElt, By eltLocator) {
    // retrieve selenium and reporter objects
//    WebDriver driver = test.getDriverInstance();

    List<WebElement> eltsFound = null;
      // Debug mode activated
//      Reporter reporter = test.getReporter();
      try {
        if (referenceElt == null) {
          eltsFound = driver.findElements(eltLocator);
        }
        else {
          eltsFound = referenceElt.findElements(eltLocator);
        }
//        reporter.debug("Number of elt found (" + eltLocator.toString() + ") = " + (eltsFound != null ? eltsFound.size() : 0) );
      }
      catch (NoSuchElementException e) {
        // Elt not found
        eltsFound = new ArrayList<WebElement>(0);
//        reporter.debug("No element found for (" + eltLocator.toString() + ")");
      }
    return eltsFound;
  }


  /**
   * Method checking an element existence and reporting the result
   * The test continues whatever the result of the check
   * 
   * @param test
   *          the Selenium test
   * @param eltLocator
   *          the element locator
   * @param eltName
   *          the element friendly name
   * @return the result of the check for an external action
   */
  public static boolean checkElementPresent(WebDriver driver, By eltLocator, String eltName) {

    return checkElementPresentProcess(driver, eltLocator, eltName, false);
  }

  /**
   * Method checking an element existence and reporting the result
   * The test continues whatever the result of the check
   * 
   * @param test
   *          the Selenium test
   * @param eltLocator
   *          the element locator
   * @return the result of the check for an external action
   */
  public static boolean checkElementPresent(WebDriver driver, By eltLocator) {

    return checkElementPresentProcess(driver, eltLocator, eltLocator.toString(), false);
  }

  /**
   * Method checking an element existence and reporting the result
   * The test stops if the result of the check is failed
   * 
   * @param test
   *          the Selenium test
   * @param eltLocator
   *          the element locator
   * @param eltName
   *          the element friendly name
   * @return the result of the check for an external action
   */
  public static boolean checkMandatoryElementPresent(WebDriver driver, By eltLocator, String eltName) {

    return checkElementPresentProcess(driver, eltLocator, eltName, true);
  }

  /**
   * Method checking an element existence and reporting the result
   * The test stops if the result of the check is failed
   * 
   * @param test
   *          the Selenium test
   * @param eltLocator
   *          the element locator
   * @return the result of the check for an external action
   */
  public static boolean checkMandatoryElementPresent(WebDriver driver, By eltLocator) {

    return checkElementPresentProcess(driver, eltLocator, eltLocator.toString(), true);
  }

  /**
   * Method comparing an element value with a value of reference
   * The test continues whatever the result of the check
   * 
   * @param test
   *          the Selenium test
   * @param eltLocator
   *          the element locator
   * @param eltName
   *          the element friendly name
   * @param referenceValue
   *          the value of reference
   * @return the result of the comparison for an external action
   */
  public static boolean checkElementValue(WebDriver driver, By eltLocator,
      String eltName,
      String referenceValue) {

    return checkElementValueProcess(driver, eltLocator, eltName, referenceValue, false);
  }

  /**
   * Method comparing an element value with a value of reference
   * The test stops if the result of the check is failed
   * 
   * @param test
   *          the Selenium test
   * @param eltLocator
   *          the element locator
   * @param eltName
   *          the element friendly name
   * @param referenceValue
   *          the value of reference
   * @return the result of the comparison for an external action
   */
  public static boolean checkMandatoryElementValue(WebDriver driver,
      By eltLocator,
      String eltName,
      String referenceValue) {

    return checkElementValueProcess(driver, eltLocator, eltName, referenceValue, true);
  }

  /**
   * Method checking an element existence and reporting the result
   * For an mandatory element, if the check is failed then the test is stopped
   * 
   * @param test
   *          the Selenium test
   * @param eltLocator
   *          the element locator
   * @param eltName
   *          the element friendly name
   * @param isCheckMandatory
   *          the flag for a mandatory element
   * @return the result of the check
   */
  private static boolean checkElementPresentProcess(WebDriver driver, By eltLocator, String eltName,
      boolean isCheckMandatory) {

    // retrieve selenium and reporter objects
//    Reporter reporter = test.getReporter();

    // verify element existence then report regarding the result
    WebElement elt = getElement(driver, eltLocator);

    boolean checkStatus = (elt != null);
    if (checkStatus) {
//      reporter.reportPassed("Check", "Element '" + eltName + "' found");
    }
    else {
      // report failed status
      if (isCheckMandatory) {
//        reporter.fail("Element '" + eltName + "' not found");
      }
      else {
//        reporter.reportWarning("Check", "Element '" + eltName + "' not found");
      }
    }

    // return the status for an external action
    return checkStatus;
  }

  /**
   * Method comparing an element value with a value of reference
   * For a mandatory check, if the result is failed then the test is stopped
   * 
   * @param test
   *          the Selenium test
   * @param eltLocator
   *          the element locator
   * @param eltName
   *          the element friendly name
   * @param referenceValue
   *          the value of reference
   * @param isCheckMandatory
   *          the flag for a mandatory element
   * @return the result of the comparison
   */
  private static boolean checkElementValueProcess(WebDriver driver,
      By eltLocator,
      String eltName,
      String referenceValue,
      boolean isCheckMandatory) {

    // retrieve selenium and reporter objects
//    WebDriver driver = test.getDriverInstance();
    ;
//    Reporter reporter = test.getReporter();

    // verify element existence then report regarding the result
    WebElement elt = getElement(driver, eltLocator);
    boolean checkStatus = (elt != null);
    if (checkStatus) {
      // verify element value
      String valueFound = driver.findElement(eltLocator).getText();
      checkStatus = (valueFound != null && (valueFound.equals(referenceValue) || valueFound.contains(referenceValue)));
      if (checkStatus) {
//        reporter.reportPassed("Check", "Element '" + eltName + "' contains the value of reference '" + referenceValue +            "'");
      }
      else {
        // report failed status
        if (isCheckMandatory) {
//          reporter.fail("Element '" + eltName + "' doesn't contain the value of reference '" + referenceValue +              "' but contains value '" + valueFound + "'");
        }
        else {
//          reporter.reportWarning("Check", "Element '" + eltName + "' doesn't contain the value of reference '" +              referenceValue + "' but contains value '" + valueFound + "'");
        }
      }
    }
    else {
      // report element not found status
      if (isCheckMandatory) {
//        reporter.fail("Element '" + eltName + "' not found, impossible to check value '" + referenceValue + "'");
      }
      else {
//        reporter.reportWarning("Check", "Element '" + eltName + "' not found, impossible to check value '" +            referenceValue + "'");
      }
    }

    // return the status for an external action
    return checkStatus;
  }

  /**
   * Highlights in yellow the found web element for 1 second.
   * Warning: This increases the test execution time and may impact some pages due to the injection of javascript.
   * 
   * @param test
   * @param eltFound
 * @throws InterruptedException 
   */
  public static void highlightElement(WebDriver driver, WebElement eltFound) throws InterruptedException {
//    Reporter reporter = test.getReporter();
//    reporter.reportPassed("Highlight", "Before javascript" + eltFound.toString());
//    WebDriver driver = test.getDriverInstance();
    ;
    for (int i = 0; i < 2; i++) {
      JavascriptExecutor js = (JavascriptExecutor)driver;
      js.executeScript("arguments[0].setAttribute('style', arguments[1]);", eltFound,
          "color: yellow; border: 2px solid yellow;");
      Thread.sleep(1000);
      js.executeScript("arguments[0].setAttribute('style', arguments[1]);", eltFound, "");
    }
//    reporter.reportPassed("Highlight", "After javascript");
  }

  /**
   * @deprecated Replaced by {@link #getElement}<br>
   * 
   *             Method checking if an element exists by using the WebDriver:findElement method
   * 
   * @param test
   *          the Selenium test to retrieve driver and reporter instances
   * @param eltLocator
   *          the element locator
   * @return the first element found if it exists, null otherwise *
   */
  @Deprecated
  static public WebElement isElementExist(WebDriver driver, By eltLocator) {
    return isElementExist(driver, null, eltLocator);
  }

  /**
   * @deprecated Replaced by {@link #getElement}<br>
   * 
   *             Method checking if an element exists based on a referenced web element by using the
   *             WebElement:findElement
   *             method
   * 
   * @param test
   *          the Selenium test to retrieve driver and reporter instances
   * @param referenceElt
   *          the reference web element to search for
   * @param eltLocator
   *          the element locator
   * @return the first element found if it exists, null otherwise *
   */
  @Deprecated
  static public WebElement isElementExist(WebDriver driver, WebElement referenceElt, By eltLocator) {
    // retrieve selenium and reporter objects
//    WebDriver driver = test.getDriverInstance();

    WebElement eltFound = null;
      // Debug mode activated
//      Reporter reporter = test.getReporter();
      try {
        if (referenceElt == null) {
          eltFound = driver.findElement(eltLocator);
        }
        else {
          eltFound = referenceElt.findElement(eltLocator);
        }
//        reporter.debug("Elt found (" + eltLocator.toString() + ")", eltFound);
      }
      catch (NoSuchElementException e) {
        // Elt not found
        eltFound = null;
//        reporter.debug("Element not found for (" + eltLocator.toString() + ")");
      }
    return eltFound;
  }

  /**
   * @deprecated Replaced by {@link #getElements}<br>
   * 
   *             Method checking if an elements list exists by using the WebDriver:findElements method
   * 
   * @param test
   *          the Selenium test to retrieve driver and reporter instances
   * @param eltLocator
   *          the element locator
   * @return the list of elements found, or an empty list if nothing matches *
   */
  @Deprecated
  static public List<WebElement> isElementsExist(WebDriver driver, By eltLocator) {
    return isElementsExist(driver, null, eltLocator);
  }

  /**
   * @deprecated Replaced by {@link #getElements}<br>
   * 
   *             Method checking if an elements list exists based on a referenced web element by using the
   *             WebElement:findElements method
   * 
   * @param test
   *          the Selenium test to retrieve driver and reporter instances
   * @param referenceElt
   *          the reference web element to search for
   * @param eltLocator
   *          the element locator
   * @return the list of elements found, or an empty list if nothing matches *
   */
  @Deprecated
  static public List<WebElement> isElementsExist(WebDriver driver, WebElement referenceElt, By eltLocator) {
    // retrieve selenium and reporter objects
//    WebDriver driver = test.getDriverInstance();

    List<WebElement> eltsFound = null;
      // Debug mode activated
//      Reporter reporter = test.getReporter();
      try {
        if (referenceElt == null) {
          eltsFound = driver.findElements(eltLocator);
        }
        else {
          eltsFound = referenceElt.findElements(eltLocator);
        }
//        reporter.debug("Number of elt found (" + eltLocator.toString() + ") = " +            (eltsFound != null ? eltsFound.size() : 0));
      }
      catch (NoSuchElementException e) {
        // Elt not found
        eltsFound = new ArrayList<WebElement>(0);
//        reporter.debug("No element found for (" + eltLocator.toString() + ")");
      }
    return eltsFound;
  }

}