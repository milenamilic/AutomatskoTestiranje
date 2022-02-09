package tests;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ElementsTest extends BasePage {

    @BeforeMethod
    public void getElementsPage () {
        scroll(homePage.getPages().get(0));
        homePage.clickEachPage(0);
    }

    @Test
    public void verifyThatTheElementsPageIsOpened () {
        String currentHeader = driver.findElement(By.className("main-header")).getText();
        String expectedHeader = "Elements";
        Assert.assertEquals(currentHeader, expectedHeader);

        String actualFirstSectionName = elementsPage.getEachSection(0).getText();
        String expectedFirstSectionName = "Text Box";
        Assert.assertEquals(actualFirstSectionName, expectedFirstSectionName);
    }

    public void getSectionTextBox () {
        elementsPage.getEachSection(0);
        elementsPage.clickEachSection(0);
    }

    //TEXT BOX TESTS BELOW

    @Test
    public void verifyThatTheUserCanSubmitATextBoxWithValidDetails () {
        getSectionTextBox();
        waiter(elementsPage.getFullName());
        String validFullName = excelReader.getStringData("Elements", 2,0);
        String validEmail = excelReader.getStringData("Elements", 2, 1);
        String validCurrentAddress = excelReader.getStringData("Elements", 2, 2);
        String validPermanentAddress = excelReader.getStringData("Elements", 2, 3);

        elementsPage.insertFullName(validFullName);
        elementsPage.insertEmail(validEmail);
        elementsPage.insertCurrentAddress(validCurrentAddress);
        elementsPage.insertPermanentAddress(validPermanentAddress);
        scroll(elementsPage.getSubmitButton());
        elementsPage.clickSubmit();


        WebElement outputAfterSubmitting = driver.findElement(By.id("output"));
        Assert.assertTrue(outputAfterSubmitting.isDisplayed());

        String actualOutputAfterSubmitting = elementsPage.getOutputText();
        StringBuilder sb = new StringBuilder();
        sb.append("Name:").append(validFullName).append("\n");
        sb.append("Email:").append(validEmail).append("\n");
        sb.append("Current Address :").append(validCurrentAddress).append("\n");
        sb.append("Permananet Address :").append(validPermanentAddress).append("\n");
        Assert.assertEquals(actualOutputAfterSubmitting, sb.toString());

    }
    @Test
    public void verifyThatAllTheTextBoxFieldsAreNotCaseSensitive () throws InterruptedException {
        getSectionTextBox();
        waiter(elementsPage.getFullName());

        for (int i = 3; i < 6; i++) {
            String lowerCaseName;
            String validEmail = excelReader.getStringData("Elements", 2, 1);
            String validCurrentAddress = excelReader.getStringData("Elements", 2, 2);
            String validPermanentAddress = excelReader.getStringData("Elements", 2, 3);
            lowerCaseName = excelReader.getStringData("Elements", i, 0);
            elementsPage.insertFullName(lowerCaseName);
            elementsPage.insertEmail(validEmail);
            elementsPage.insertCurrentAddress(validCurrentAddress);
            elementsPage.insertPermanentAddress(validPermanentAddress);
            scroll(elementsPage.getSubmitButton());
            elementsPage.clickSubmit();

            WebElement outputAfterSubmitting = driver.findElement(By.id("output"));
            Assert.assertTrue(outputAfterSubmitting.isDisplayed());
        }

        for (int i = 3; i < 6; i++) {
            String validFullName = excelReader.getStringData("Elements", 2,0);
            String lowercaseEmail = excelReader.getStringData("Elements", i, 1);
            String validCurrentAddress = excelReader.getStringData("Elements", 2, 2);
            String validPermanentAddress = excelReader.getStringData("Elements", 2, 3);

            elementsPage.insertFullName(validFullName);
            elementsPage.insertEmail(lowercaseEmail);
            elementsPage.insertCurrentAddress(validCurrentAddress);
            elementsPage.insertPermanentAddress(validPermanentAddress);
            scroll(elementsPage.getSubmitButton());
            elementsPage.clickSubmit();

            WebElement outputAfterSubmitting = driver.findElement(By.id("output"));
            Assert.assertTrue(outputAfterSubmitting.isDisplayed());
        }

        for (int i = 3; i < 6; i++) {
            String validFullName = excelReader.getStringData("Elements", 2,0);
            String validEmail = excelReader.getStringData("Elements", 2, 1);
            String lowerCaseCAddress = excelReader.getStringData("Elements", i, 2);
            String validPermanentAddress = excelReader.getStringData("Elements", 2, 3);

            elementsPage.insertFullName(validFullName);
            elementsPage.insertEmail(validEmail);
            elementsPage.insertCurrentAddress(lowerCaseCAddress);
            elementsPage.insertPermanentAddress(validPermanentAddress);
            scroll(elementsPage.getSubmitButton());
            elementsPage.clickSubmit();

            WebElement outputAfterSubmitting = driver.findElement(By.id("output"));
            Assert.assertTrue(outputAfterSubmitting.isDisplayed());
        }

        for (int i = 3; i < 6; i++) {
            String validFullName = excelReader.getStringData("Elements", 2,0);
            String validEmail = excelReader.getStringData("Elements", 2, 1);
            String validCurrentAddress = excelReader.getStringData("Elements", 2, 2);
            String lowerCasePAddress = excelReader.getStringData("Elements", i, 3);

            elementsPage.insertFullName(validFullName);
            elementsPage.insertEmail(validEmail);
            elementsPage.insertCurrentAddress(validCurrentAddress);
            elementsPage.insertPermanentAddress(lowerCasePAddress);
            scroll(elementsPage.getSubmitButton());
            elementsPage.clickSubmit();

            WebElement outputAfterSubmitting = driver.findElement(By.id("output"));
            Assert.assertTrue(outputAfterSubmitting.isDisplayed());
        }


    }
    public void getSectionCheckBox () {
        elementsPage.getEachSection(1);
        elementsPage.clickEachSection(1);
    }

    //CHECK BOX TESTS BELOW

    @Test
    public void verifyThatByClickingOnThePlusSignAllTheChildElementsOfHomeAppear () {
        getSectionCheckBox();
        waiter(elementsCheckBox.getPlusSign());

        elementsCheckBox.clickOnPlus();

        int brojac = 0;

        for (int i = 1; i < elementsCheckBox.getAllCheckBoxes().size(); i++) {
            elementsCheckBox.getEachCheckBox(i);
            brojac = brojac + 1;
        }
        int actualNumberOfChildElements = brojac;
        int expectedNumberOfChildElements = 16;
        Assert.assertEquals(actualNumberOfChildElements, expectedNumberOfChildElements);

    }

    @Test
    public void verifyThatByClickingOnMinusSignAllHomeChildElementsCollapse () throws InterruptedException {
        getSectionCheckBox();
        waiter(elementsCheckBox.getPlusSign());
        elementsCheckBox.clickOnPlus();
        Thread.sleep(2000);
        elementsCheckBox.clickMinusSign();

        int brojac = 0;

        for (int i = 0; i < elementsCheckBox.getAllCheckBoxes().size(); i++) {
            elementsCheckBox.getEachCheckBox(i);
            brojac = brojac + 1;
        }
        int actualNumberOfChildElements = brojac;
        int expectedNumberOfChildElements = 1;
        Assert.assertEquals(actualNumberOfChildElements, expectedNumberOfChildElements);

    }

    @Test
    public void verifyThatTheUserCanSelectAllTheCheckBoxesOnThePage () throws InterruptedException {
        getSectionCheckBox();
        waiter(elementsCheckBox.getPlusSign());
        elementsCheckBox.clickOnPlus();

        //check if checkbox i is selected
        for (int i = 1; i < elementsCheckBox.getAllCheckBoxes().size(); i++) {
            WebElement checkBox = elementsCheckBox.getEachCheckBox(i);
            if (checkBox.isSelected() == false) {

                checkBox.click();
            }
            //the test fails in the 205th line because the checkbox is displayed as an image in HTML of this website
            //instead of a real check box, however, the test would work if it was a real check box

            Thread.sleep(1000);
            Assert.assertTrue(checkBox.isSelected());
        }


        //check if all the checkboxes are selected
        int brojacPoruka = 0;
        boolean checkedAll = true;
        for (int i = 0; i < elementsCheckBox.getAllCheckBoxes().size(); i++) {
            WebElement checkBox = elementsCheckBox.getEachCheckBox(i);
            if (checkBox.isSelected() == false) {
                checkedAll = false;
                break;
            }
            brojacPoruka = brojacPoruka + 1;
        }
        Assert.assertTrue(checkedAll);

        int actualBrojacPoruka = brojacPoruka;
        int expectedBrojacPoruka = 17;
        Assert.assertEquals(actualBrojacPoruka, expectedBrojacPoruka);
    }

    public void getSectionRadioButton () {
        scroll(elementsPage.getEachSection(2));
        elementsPage.clickEachSection(2);
    }

    //RADIO BUTTON TESTS BELOW

    @Test
    public void verifyThatTheUserCanClickOnEachRadioButton() {
        getSectionRadioButton();
        waiter(driver.findElement(By.className("mb-3")));

        for (int i = 0; i < elementsRadioButton.getRadioButtons().size(); i++) {
            clickB(elementsRadioButton.getEachRadioButton(i));
            //this assert checks if any of the buttons are selected because it
            //doesn't appear if none of the radio buttons are clicked:
            Assert.assertTrue(elementsRadioButton.getMessage().isDisplayed());
            //the following test should fail because the "no" button can't be clicked (so the test does pass
            //in the first to iterations, but fails in the third one, like it is supposed to:
            Assert.assertTrue(elementsRadioButton.getEachRadioButton(i).isSelected());
        }
    }

    @Test
    public void verifyThatRadioButtonCanBeSelectedByClickingOnTheNameOfTheRadioButton () {
        getSectionRadioButton();
        waiter(driver.findElement(By.className("mb-3")));

        //i<2 is used because the third element (with index 2) is not clickable which we can see from the previous test
        for (int i = 0; i < 2; i++) {
            clickB(elementsRadioButton.getEachRadioButtonLabel(i));
            Assert.assertTrue(elementsRadioButton.getMessage().isDisplayed());
            Assert.assertTrue(elementsRadioButton.getEachRadioButton(i).isSelected());
        }
    }

    @Test
    public void verifyThatOnlyOneRadioButtonCanBeSelectedAtTheSameTime () {

    }

    @Test
    public void test () throws InterruptedException {
        getSectionRadioButton();
        Thread.sleep(2000);

        clickB(elementsRadioButton.getEachRadioButton(0));
        elementsRadioButton.getEachRadioButton(0).clear();
    }



}
