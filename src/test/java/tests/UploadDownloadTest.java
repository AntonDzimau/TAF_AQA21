package tests;

import baseEntities.BaseTest;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

public class UploadDownloadTest extends BaseTest {

    @Test
    public void fileUploadTest() {
        driver.get("http://the-internet.herokuapp.com/upload");
        WebElement fileUploadPath = wait.waitForExists(By.id("file-upload"));
        String pathToFile;
        if (Objects.equals(System.getProperties().getProperty("sun.desktop"), "windows")) {
            pathToFile = this.getClass().getClassLoader().getResource("testFile.txt").getPath().substring(1);
        } else {
            pathToFile = this.getClass().getClassLoader().getResource("testFile.txt").getPath();
        }
        fileUploadPath.sendKeys(pathToFile);
        wait.waitForExists(By.id("file-submit")).submit();
        Assert.assertEquals(wait.waitForVisibilityBy(By.id("uploaded-files")).getText(), "testFile.txt");
    }

    @Test
    public void fileDownloadTest() throws IOException {
        driver.get("http://the-internet.herokuapp.com/download");
        WebElement firstElement = driver.findElements(By.cssSelector(".example a")).get(0);
        String downloadFirstElementLink = firstElement.getAttribute("href");
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(downloadFirstElementLink);
            try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                copyInputStreamToFile(response.getEntity().getContent(), new File(firstElement.getText()));
            }
        }
        File projectFolder = new File(System.getProperty("user.dir"));
        File[] listOfFiles = projectFolder.listFiles();
        boolean found = false;
        File fileTarget = null;
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                System.out.println("File - " + listOfFile.getName());
                if (listOfFile.getName().matches(firstElement.getText())) {
                    fileTarget = new File(listOfFile.getName());
                    found = true;
                }
            }
        }
        Assert.assertTrue(found, "Downloaded file is not found");
        fileTarget.deleteOnExit();
    }

}
