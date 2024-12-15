package com.app.mqs.producer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.app.mqs.producer.dto.Person;
import com.app.mqs.producer.utils.HelperUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableScheduling
public class MessageProducerApplication {

	
	@Autowired
	JmsTemplate sender;

	public static void main(String[] args) {
		SpringApplication.run(MessageProducerApplication.class, args);
		}

	long lastLineSize = 0;
	
	@Scheduled(fixedRate = 100000) 
	public void readCsvFile() {
		try (BufferedReader reader = new BufferedReader(new FileReader("D:\\Files\\persons.csv"))){
			long currentLineSize = 0;
			String line;
			while ((line = reader.readLine()) != null) {
				currentLineSize++;
				
                if(currentLineSize==1)
                	continue;
                
				if (currentLineSize > lastLineSize) {
					String[] data = line.split(",");
					Person dto = new Person();
					dto.setSno(Integer.parseInt(data[0]));
					dto.setName(data[1]);
					dto.setCity(data[2]);
//					sender.convertAndSend("Person", HelperUtils.convertDtoToJsonString(dto));
					System.out.println("Message line "+currentLineSize+ " sent");
				}
			}
 
			lastLineSize = currentLineSize;
		} catch (Exception e) {
			log.error("Exception while sending message -> "+e.getMessage());
		}
	}
}


