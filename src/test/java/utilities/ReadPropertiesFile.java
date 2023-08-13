package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {

	public static void main(String[] args) throws IOException {

		FileReader fileRead = new FileReader("C:\\Users\\AISHWARYA\\Desktop\\Courses\\Selenium\\TestAutomationFramework\\TestAutomationFramework\\src\\test\\resources\\configFiles\\config.properties");
		
		Properties p = new Properties();
		p.load(fileRead);
		System.out.println(p.getProperty("browser"));
	}

}
