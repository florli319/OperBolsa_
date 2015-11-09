package com.stock.broker;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

public class MessageSender {

	private final static String QUEUE_NAME = "bolsa";

	public void sendMessage() throws java.io.IOException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		String message = "Mensaje desde el Corredor";
		File file = new File("D:\\especializacion\\Doc xml patrones\\file.xml");
		channel.basicPublish("", QUEUE_NAME, null, getBytes(file));
		System.out.println(" [x] Sent '" + message + "'");

		channel.close();
		connection.close();
	}

	private byte[] getBytes(File file) {
		byte[] bFile = new byte[(int) file.length()];
		FileInputStream fileInputStream = null;
		try {
			// convert file into array of bytes
			fileInputStream = new FileInputStream(file);
			fileInputStream.read(bFile);
			fileInputStream.close();

			for (int i = 0; i < bFile.length; i++) {
				System.out.print((char) bFile[i]);
			}

			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bFile;
	}

	public static void main(String[] args) throws IOException {
		new MessageSender().sendMessage();
	}
}
