package pl.put.poznan.buildinginfo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"pl.put.poznan.transformer.rest"})
public class BuildingInfoApp {

    public static void main(String[] args) {
        SpringApplication.run(BuildingInfoApp.class, args);
    }
}
