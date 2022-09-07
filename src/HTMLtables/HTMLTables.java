package HTMLtables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HTMLTables {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		//  driver.manage().window().maximize();



		//capture first what is under header colums  tr=row; td=colum
		//column COMPANY
		//*[@id="customers"]/tbody/tr[2]/td[1]
		//*[@id="customers"]/tbody/tr[3]/td[1]
		//*[@id="customers"]/tbody/tr[4]/td[1]
		//*[@id="customers"]/tbody/tr[5]/td[1]
		//*[@id="customers"]/tbody/tr[6]/td[1]
		//*[@id="customers"]/tbody/tr[7]/td[1]

		//to avoid hardcoding in java we will use row count instead (i) of because sometimes table can have 10000 rows
		List<WebElement> rows= driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
		int rowCount=rows.size();
		System.out.println("Totatl rows in webtable: "+rowCount);


		String beforeXpath = " //*[@id='customers']/tbody/tr[";
		String afterXpath = "]/td[1]";


		//create for loop to get a value from this colums and start fro col 2 to col 7
		for (int i = 2; i <= rowCount; i++) {
			String actualXpath = beforeXpath + i + afterXpath;
			WebElement element = driver.findElement(By.xpath(actualXpath));
			System.out.println(element.getText());

			//dodate su IF conditions da se proveri da li je Island Trading display or not
			// if (element.getText().equals("Island Trading")) {
			//  System.out.println("Company name: " + element.getText() + " is found" + " at position : " + (i - 1));
			//  break;
		}
		//  }

		System.out.println("******************************************");
		//column CONTACT isti proces kao i sa prvom kolonom
		//*[@id="customers"]/tbody/tr[2]/td[2]
		//*[@id="customers"]/tbody/tr[3]/td[2]
		//*[@id="customers"]/tbody/tr[4]/td[2]
		//*[@id="customers"]/tbody/tr[5]/td[2]
		//*[@id="customers"]/tbody/tr[6]/td[2]
		//*[@id="customers"]/tbody/tr[7]/td[2]

		String afterXpathContact = "]/td[2]";
		for (int i = 2; i <= rowCount; i++) {
			String actualXpath = beforeXpath + i + afterXpathContact;
			WebElement element = driver.findElement(By.xpath(actualXpath));
			System.out.println(element.getText());
		}

		System.out.println("****************************************");
		String afterXpathCountry = "]/td[3]";
		for (int i = 2; i <= rowCount; i++) {
			String actualXpath = beforeXpath + i + afterXpathCountry;
			WebElement element = driver.findElement(By.xpath(actualXpath));
			System.out.println(element.getText());
		}

		System.out.println("---------------------------------------------");
		//handle columns

		//*[@id="customers"]/tbody/tr[1]/th[1]
		//*[@id="customers"]/tbody/tr[1]/th[2]
		//*[@id="customers"]/tbody/tr[1]/th[3]

		String columnsBeforeXpath= "//*[@id='customers']/tbody/tr[1]/th[";
		String columnsAfterXpath= "]";

		List<WebElement> columns=driver.findElements(By.xpath("//*[@id='customers']/tbody/tr[1]/th"));
		int columnsCount=columns.size();
		System.out.println("Total size of columns are: " +columnsCount);

		System.out.println("Columns values are : ");
		for(int i=1; i<=columnsCount; i++){
			WebElement element= driver.findElement(By.xpath(columnsBeforeXpath+i+columnsAfterXpath));
			String columnText= element.getText();
			System.out.println(columnText);
		}








	}



}
