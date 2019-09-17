package com.hsm;

import com.hsm.tcpclient.service.MessageService;
import com.hsm.tcpclient.codette.EncodeToJson;
import com.hsm.tcpclient.models.Student;
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
public class TcpClientApplication implements CommandLineRunner
{
    @Autowired
    private MessageService messageService;
    private final static Logger logger= LogManager.getLogger(TcpClientApplication.class);
    @Autowired
    private EncodeToJson encodeToJson;

    public static void main( String[] args )
    {

        SpringApplication application =new SpringApplication(TcpClientApplication.class);
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

            do{
                nic = scanner.nextLine();
                logger.info("nic length is too long \n Re enter Student National Identity card Number");

            }while(nic.length()>10 || nic.equals(null));

            logger.info("Enter Student Name");
            name = scanner.nextLine();
            logger.info("Enter Student Address");
            address = scanner.nextLine();
            logger.info("Enter Student Telephone Number");
            do{
                logger.info("phone number length is too long \n Re enter Student Telephone Number");
                tel = scanner.nextLine();
            }while(nic.length()>10);

            Student student=new Student(nic,name,address,tel);
            messageService.sendMessage(student);
        }


    }
}
