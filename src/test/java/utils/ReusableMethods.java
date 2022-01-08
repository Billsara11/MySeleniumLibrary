package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class ReusableMethods {

    private WebDriverWait wait;
    private WebDriver driver;
    private JavascriptExecutor js;

    public ReusableMethods(WebDriverWait wait, WebDriver driver, JavascriptExecutor js) {
        this.wait = wait;
        this.driver = driver;
        this.js = js;
    }


    public void verifyAllContainsText(List<WebElement> elements, String searchTerm) {
        Assert.assertFalse(elements.isEmpty(), "The list of elements is empty, cannot find searchTerm!");
        for (WebElement element : elements) {
            verifyOneContainsText(element, searchTerm);
        }
    }

    public void verifyNoneContainsTextAndNotEmpty(List<WebElement> elements, String searchTerm) {
        Assert.assertFalse(elements.isEmpty(), "The list of elements is empty, cannot verify that not contain searchTerm!");
        boolean found = elementIsFoundIn(elements, searchTerm);
        Assert.assertFalse(found, "The list should not contain search term: " + searchTerm);

    }

    public void verifyNoneContainsText(List<WebElement> elements, String searchTerm) {
        boolean found = elementIsFoundIn(elements, searchTerm);
        Assert.assertFalse(found, "The list should not contain search term: " + searchTerm);

    }

    public void verifyAtLeastOneContainsText(List<WebElement> elements, String searchTerm) {
        Assert.assertFalse(elements.isEmpty(), "The list of elements is empty, cannot find searchTerm!");
        boolean found = elementIsFoundIn(elements, searchTerm);
        Assert.assertTrue(found, "The list doesn't contain any search term: " + searchTerm);
    }

    public void verifyOneContainsText(WebElement element, String searchTerm) {
        String elementText = element.getText().toLowerCase();
        System.out.println("elementText "+elementText);
        System.out.println("searchTerm "+searchTerm);
        Assert.assertTrue(elementText.contains(searchTerm.toLowerCase()), "'" + element.getText() + "' does not contain '" + searchTerm + "'");
    }

    public void clearAndSendKeys(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public List<WebElement> waitAndGetList(By locator) {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, 0));
        return driver.findElements(locator);
    }

    public void verifyListContainsAll(List<WebElement> elements, List<String> booksAdded) {
        for (WebElement element : elements) {
            Assert.assertTrue(booksAdded.contains(element.getText()), "The element: " + element.getText() + " is not in expected list " + booksAdded);
        }
    }

    public void waitAndClick(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        driver.findElement(locator).click();
    }


    public void waitScrollAndClick(By selector) {
        wait.until(ExpectedConditions.presenceOfElementLocated(selector));
        WebElement element = driver.findElement(selector);
        js.executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public void verifyAlertText(String expectedText) {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(expectedText, alert.getText());
        alert.accept();
    }

    public String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefgijklmopqrstuvwxyz0123456789!@#$%^&*()_+~?><";
        return getRandomString(length, passwordSet);
    }

    public String randomWord(int length) {
        String passwordSet = "abcdefgijklmopqrstuvwxyz";
        return getRandomString(length, passwordSet);
    }

    private String getRandomString(int length, String possibleLetters) {
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * possibleLetters.length());
            password[i] = possibleLetters.charAt(rand);
        }
        return new String(password);
    }

    private boolean elementIsFoundIn(List<WebElement> elements, String searchTerm) {
        boolean found = false;
        for (WebElement element : elements) {
            String elementText = element.getText().toLowerCase();
            if (elementText.contains(searchTerm.toLowerCase())) {
                found = true;
                break;
            }
        }
        return found;
    }
}
