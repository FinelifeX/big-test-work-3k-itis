import org.openqa.selenium.By;

public class FolderHelper extends HelperBase {

    private FolderData folderData = new FolderData();

    public FolderHelper(ApplicationManager manager) {
        super(manager);
    }

    public FolderData createFolder() throws InterruptedException {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Upload'])[1]/following::button[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='I’d like to share an existing folder'])[1]/following::button[1]")).click();
        driver.findElement(By.id("unified-share-modal-title")).clear();
        driver.findElement(By.id("unified-share-modal-title")).sendKeys(folderData.getName());
        Thread.sleep(10000);
        driver.findElement(By.id("unified-share-modal-contacts-tokenizer")).click();
        driver.findElement(By.id("unified-share-modal-contacts-tokenizer")).clear();
        driver.findElement(By.id("unified-share-modal-contacts-tokenizer")).sendKeys("bulik.mu@yandex.ru");
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[4]/div/div[2]/button")).click();
        return this.folderData;
    }

    public FolderData getCreatedFolderData() {
        String name = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/main/div[1]/div/main/ul/li[2]/span/div/div/ul/li/ul/li[1]/div/div/div[2]/div[1]/a")).getText();
        FolderData folderData = new FolderData();
        folderData.setName(name);
        return folderData;
    }
}
