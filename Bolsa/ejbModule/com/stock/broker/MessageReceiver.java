package com.stock.broker;
import com.rabbitmq.client.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class MessageReceiver {

  private final static String QUEUE_NAME = "bolsa";

  public static void main(String[] argv) throws Exception {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();

    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
    System.out.println(" [*]La bolsa en la espera de mensajes ");

    Consumer consumer = new DefaultConsumer(channel) {
      @Override
      public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
          throws IOException {
    	  
    	File file =  getFile(body);
       // String message = new String(body, "UTF-8");
      //  System.out.println(" [x] Received '" + message + "'");
        //Cuando recibo un mensaje realizó la lógica de la bolsa
      }

	private File getFile(byte[] bFile) {
	    
		try {
	       
	    //convert array of bytes into file
	    FileOutputStream fileOuputStream = 
                  new FileOutputStream("D:\\especializacion\\Doc xml patrones\\fileOut.xml"); 
	    fileOuputStream.write(bFile);
	    fileOuputStream.close();
	    
	    File file = new File("D:\\especializacion\\Doc xml patrones\\fileOut.xml");
	    
	    System.out.println("Done");
	    return file;
	       
        }catch(Exception e){
            e.printStackTrace();
        }
		return null;
	}
    };
    channel.basicConsume(QUEUE_NAME, true, consumer);
  }
}