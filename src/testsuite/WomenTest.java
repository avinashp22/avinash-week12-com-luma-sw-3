package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WomenTest extends Utility {

    String baseURL = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp(){openBrowser(baseURL);}

    @Test
    public void verifyTheSortByProductNameFilter() throws InterruptedException {
        //* Mouse Hover on Women Menu
        Thread.sleep(2000);
        mouseHoverToElement(By.xpath("//span[contains(text(),'Women')]"));
        //* Mouse Hover on Tops
        //li[contains(@class,'nav-2-1 ')]/child::a
        mouseHoverToElement(By.xpath("//li[contains(@class,'nav-2-1 ')]/child::a"));
        //* Click on Jackets
        mouseHoverAndClickOnElement(By.xpath("//li[contains(@class,'nav-2-1 ')]/child::ul/child::li[1]/child::a"));
        //* Select Sort By filter “Product Name”
        selectFromVisibleTextFromDropdown((By.xpath("//div[@class='column main']/child::div[2]/child::div[3]/child::select[1]")), "Product Name");
        //* Verify the products name display in alphabetical order
        List<WebElement> originalList = driver.findElements(By.xpath("//strong[contains(@class,'product name product-item-name')]/child::a"));
        List<String> originalProductList = new ArrayList<>();
        for (WebElement product : originalList) {
            originalProductList.add(product.getText());
        }
        System.out.println("Before: " + originalProductList);
        List<WebElement> afterSortingList = driver.findElements(By.xpath("//strong[contains(@class,'product name product-item-name')]/child::a"));
        List<String> afterSortingProductNames = new ArrayList<>();
        for (WebElement product : afterSortingList) {
            afterSortingProductNames.add(product.getText());
        }
        Collections.sort(originalProductList);
        System.out.println("After: " + afterSortingProductNames);
        Assert.assertEquals(originalProductList, afterSortingProductNames);


    }@Test

    public void verifyTheSortByPriceFilter() throws InterruptedException {
//  Mouse Hover on Women Menu
        Thread.sleep(2000);
        mouseHoverToElement(By.xpath("//span[contains(text(),'Women')]"));
//* Mouse Hover on Tops
        Thread.sleep(2000);
        mouseHoverToElement(By.xpath("//li[contains(@class,'nav-2-1 ')]/child::a"));
//* Click on Jackets
        Thread.sleep(2000);
        mouseHoverAndClickOnElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));

//  Select Sort By filter “Price”
        selectFromVisibleTextFromDropdown(By.id("sorter"), "Price");
//* Verify the products price display in Low to High
        List<WebElement> originalList = driver.findElements(By.cssSelector("span[data-price-type='finalPrice']"));
        List<Double> originalProductPriceList = new ArrayList<>();
        for (WebElement product : originalList) {
            originalProductPriceList.add(Double.valueOf(product.getText().replace("$", "")));
        }
        System.out.println("Before: " + originalProductPriceList);
        List<WebElement> afterSortingList = driver.findElements(By.cssSelector("span[data-price-type='finalPrice']"));
        List<Double> afterSortingProductPrice = new ArrayList<>();
        for (WebElement product : afterSortingList) {
            afterSortingProductPrice.add(Double.valueOf(product.getText().replace("$", "")));
        }
        Collections.sort(originalProductPriceList);
        System.out.println("After: " + afterSortingProductPrice);
        Assert.assertEquals(originalProductPriceList, afterSortingProductPrice);
    }

    @After
    public void tearDown(){closeBrowser();}

}
