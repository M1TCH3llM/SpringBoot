package com.synergisticit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApp.class, args);
	}

}

/*

//To install lombok:
	C:\Projects4\Spring05Jun2025\day28-16Jul2025-SpringBoot-MVC-SpringForm-Lombok>cd C:\Users\Admin\.m2\repository\org\p
	rojectlombok\lombok\1.18.38

	C:\Users\Admin\.m2\repository\org\projectlombok\lombok\1.18.38>dir
	 Volume in drive C has no label.
	 Volume Serial Number is 7CC0-7DDB

	 Directory of C:\Users\Admin\.m2\repository\org\projectlombok\lombok\1.18.38

	07/16/2025  02:09 PM    <DIR>          .
	07/16/2025  02:09 PM    <DIR>          ..
	07/16/2025  02:09 PM         1,024,162 lombok-1.18.38-sources.jar
	07/16/2025  02:09 PM                40 lombok-1.18.38-sources.jar.sha1
	07/16/2025  02:09 PM         2,056,090 lombok-1.18.38.jar
	07/16/2025  02:09 PM                40 lombok-1.18.38.jar.sha1
	07/16/2025  02:08 PM             1,484 lombok-1.18.38.pom
	07/16/2025  02:08 PM                40 lombok-1.18.38.pom.sha1
	07/16/2025  02:09 PM               100 m2e-lastUpdated.properties
	07/16/2025  02:09 PM               237 _remote.repositories
	               8 File(s)      3,082,193 bytes
	               2 Dir(s)  384,151,560,192 bytes free

	C:\Users\Admin\.m2\repository\org\projectlombok\lombok\1.18.38>java -jar lombok-1.18.38.jar

1. Go to lombok directory in as shown above.
2.After pressing "enter" key a pop-up appears like one attached in resources directory. 
Select IDE locations for which you want to install lombok.
3. Press "install/update" button.
4. After that you need to restart your IDE(for ex. Eclipse)

*/
