package utils;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @Author Gladson Antony
 * @Date 2021-08-09T00:22:12.478Z
 */

public class AllureAttachments {
    /**
     * To Attach the Entire Page Screenshot
     */
    @Attachment(value = "Entire Page Screenshot of {0}", type = "image/png")
    public static byte[] saveFullPageScreenshot(String name, WebDriver driver) {
        try {
            BufferedImage image = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver).getImage();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baos);
            baos.flush();
            byte[] imageInByte = baos.toByteArray();
            baos.close();
            return imageInByte;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Unable to Get Screenshot.".getBytes();
    }


    /**
     * To Attach the WebElement to the Report
     */
    @Attachment(value = "Attachment of WebElement {0}", type = "image/png")
    public static byte[] saveWebElement(WebDriver driver, WebElement element) {
        try {
            BufferedImage image = Shutterbug
                    .shootElement(driver, element)
                    .withName(element.getText())
                    .withTitle(element.getText())
                    .getImage();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baos);
            baos.flush();
            byte[] imageInByte = baos.toByteArray();
            baos.close();
            return imageInByte;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Unable to Get WebElement.".getBytes();
    }


    /**
     * To Convert File to Bytes
     */
    private static byte[] fileToBytes(String fileName) throws Exception {
        File file = new File(fileName);
        return Files.readAllBytes(Paths.get(file.getAbsolutePath()));
    }

    /**
     * To Attach the CSV File to the Allure Report
     */
    @Attachment(value = "CSV Attachment", type = "text/csv")
    public static byte[] attachFileType_CSV(String filePath) throws Exception {
        return fileToBytes(filePath);
    }

    /**
     * To Attach the XML File to the Allure Report
     */
    @Attachment(value = "XML Attachment", type = "text/xml")
    public static byte[] attachFileType_XML(String filePath) throws Exception {
        return fileToBytes(filePath);
    }

    /**
     * To Attach the XLSX File to the Allure Report
     */
    @Attachment(value = "MS Excel - XLSX Attachment", type = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
    public static byte[] attachFileType_XLSX(String filePath) throws Exception {
        return fileToBytes(filePath);
    }

    /**
     * To Attach the XLS File to the Allure Report
     */
    @Attachment(value = "MS Excel - XLS Attachment", type = "application/vnd.ms-excel")
    public static byte[] attachFileType_XLS(String filePath) throws Exception {
        return fileToBytes(filePath);
    }

    /**
     * To Attach the TXT File to the Allure Report
     */
    @Attachment(value = "TXT Attachment", type = "text/plain")
    public static byte[] attachFileType_TXT(String filePath) throws Exception {
        return fileToBytes(filePath);
    }

    /**
     * To Attach the JSON File to the Allure Report
     */
    @Attachment(value = "JSON Attachment", type = "text/json")
    public static byte[] attachFileType_JSON(String filePath) throws Exception {
        return fileToBytes(filePath);
    }

    /**
     * To Attach the DOCX File to the Allure Report
     */
    @Attachment(value = "MS Word - DOCX Attachment", type = "application/vnd.openxmlformats-officedocument.wordprocessingml.document")
    public byte[] attachFileType_DOCX(String filePath) throws Exception {
        return fileToBytes(filePath);
    }

    /**
     * To Attach the DOC File to the Allure Report
     */
    @Attachment(value = "MS Word - DOC Attachment", type = "application/msword")
    public static byte[] attachFileType_DOC(String filePath) throws Exception {
        return fileToBytes(filePath);
    }

    /**
     * To Attach the JPEG Image File to the Allure Report
     */
    @Attachment(value = "JPEG Attachment", type = "image/jpg")
    public static byte[] attachFileType_JPEG(String filePath) throws Exception {
        return fileToBytes(filePath);
    }

    /**
     * To Attach the PNG Image File to the Allure Report
     */
    @Attachment(value = "PNG Attachment", type = "image/png")
    public static byte[] attachFileType_PNG(String filePath) throws Exception {
        return fileToBytes(filePath);
    }

}
