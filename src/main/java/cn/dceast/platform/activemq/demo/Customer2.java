package cn.dceast.platform.activemq.demo;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Customer2 {
public static String brokerURL="tcp://192.168.199.2:61616";
	
	public static void main(String[] args) throws JMSException{
		ConnectionFactory factory = new ActiveMQConnectionFactory(brokerURL); 		
		Connection connection = factory.createConnection();
		
		connection.start();
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE); 
		
		Topic topic=session.createTopic("topic1");
		MessageConsumer customer = session.createConsumer(topic);
		
		Message message=customer.receive();
		
		String name=message.getStringProperty("name");
		System.out.println("This is customer2  name="+name);
		
		customer.close();
		connection.close();
		
	}
}
