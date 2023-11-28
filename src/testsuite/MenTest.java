package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {

    String baseURL = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp(){openBrowser(baseURL);}

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        //Mouse Hover on Men Menu
        mouseHoverToElement(By.xpath("//a[@id='ui-id-5']"));
        //Mouse Hover on Bottoms
        Thread.sleep(2000);
        mouseHoverToElement(By.xpath("//a[@id='ui-id-18']"));
        //Click on Pants
        Thread.sleep(2000);
        mouseHoverAndClickOnElement(By.id("ui-id-23"));
        //Mouse Hover on product name‘Cronus Yoga Pant’ and click on size 32.
        mouseHoverAndClickOnElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']"));
        //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.
        mouseHoverAndClickOnElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"));
        //Mouse Hover on product name‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        mouseHoverAndClickOnElement(By.xpath("//main[@id='maincontent']/div[3]/div[1]/div[3]/ol/li[1]/div/div/div[3]/div/div[1]/form/button/span"));
        //Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        verifyText("Incorrect Text", "You added Cronus Yoga Pant to your shopping cart.", By.xpath("//div[@class='message-success success message']"));
        //Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        //Verify the text ‘Shopping Cart.’
        verifyText("Incorrect Text", "Shopping Cart", By.xpath("//span[@class='base']"));
        //Verify the product name ‘Cronus Yoga Pant’
        verifyText("Incorrect Item", "Cronus Yoga Pant", By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"));
        //Verify the product size ‘32’
        verifyText("Incorrect Size", "32", By.xpath("//dd[contains(text(),'32')]"));
        //Verify the product colour ‘Black’
        verifyText("Incorrect Colour", "Black", By.xpath("//dd[contains(text(),'Black')]"));
    }


    @After
    public void tearDown(){closeBrowser();}

}
