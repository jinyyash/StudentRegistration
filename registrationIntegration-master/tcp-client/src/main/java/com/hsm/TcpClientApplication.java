package com.hsm;

import com.google.gson.JsonObject;
import com.hsm.tcpClient.Service.MessageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App implements CommandLineRunner
{
    @Autowired
    private MessageService messageService;
    private final static Logger logger= LogManager.getLogger(App.class);


    public static void main( String[] args )
    {

        SpringApplication application =new SpringApplication(App.class);
        application.run(args);

    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Starting Application...............");

        String nic;
        String name;
        String address;
        String tel;
        Scanner scanner=new Scanner(System.in);
        while (true) {
            logger.info("Enter New Student details");
            logger.info("Enter Student National Identity card Number");
            nic = scanner.nextLine();
            logger.info("Enter Student Name");
            name = scanner.nextLine();
            logger.info("Enter Student Address");
            address = scanner.nextLine();
            logger.info("Enter Student Telephone Number");
            tel = scanner.nextLine();

            //creating student json object
            JsonObject student = new JsonObject();
            student.addProperty("nic", nic);
            student.addProperty("name", name);
            student.addProperty("address", address);
            student.addProperty("tel", tel);
            System.out.println(student.toString());

            messageService.sendMessage(student);
        }


    }
}
