package com.xebia.app.mailservice;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Sumit Agrawal
 *
 */
@Slf4j
public class MailSender {
	
	static List<String> sendersList = new ArrayList<>();

	public static void main(String[] args) {

		String[][] friendsArray = { { "rahul@test.com", "rajat@test.com", "rashmi@test.com", "vinod@test.com" },
				{ "vineet@test.com", "ajay@test.com", "rajat@test.com", "rahul@test.com" },
				{ "vinod@test.com", "rahul@test.com", "nitin@test.com", "vineet@test.com" } };

		for (int i = 0; i < friendsArray.length; i++) {
			sendersList.add(friendsArray[i][0]);
		}

		sendMail("rahul@test.com", "Hi", friendsArray);
		sendMail("vineet@test.com", "Hi", friendsArray);
		sendMail("vinod@test.com", "Hi", friendsArray);


	}

	public static void sendMail(String sender, String msg, String[][] friendsArray) {
		int index = sendersList.indexOf(sender);
		for (int i = 1; i <= friendsArray.length; i++) {
			if (!sendersList.contains(friendsArray[index][i])) {
				sendMail(friendsArray[index][i], msg);
			}
		}
	}

	public static void sendMail(String emailAddress, String msg) {
		log.info(emailAddress, " Received Mail::", msg);
	}

}
