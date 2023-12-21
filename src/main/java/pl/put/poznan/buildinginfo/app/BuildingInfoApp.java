/**
 * The BuildingInfoApp class is the entry point for the Building Info application.
 * It starts the Spring Boot application and scans the specified base packages.
 */
package pl.put.poznan.buildinginfo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication(scanBasePackages = {"pl.put.poznan.buildinginfo"})
public class BuildingInfoApp {

    public static void main(String[] args) {
        
        SpringApplication.run(BuildingInfoApp.class, args);
    }
}
