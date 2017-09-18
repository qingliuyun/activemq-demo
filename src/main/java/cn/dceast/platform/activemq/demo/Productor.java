package cn.dceast.platform.activemq.demo;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 生产者-负责发送消息
 * @author zhang
 *
 */
public class Productor {
	
	public static String brokerURL="tcp://192.168.199.2:61616";
	public static String userName="admin";
	public static String password="admin";
	
	public static void main(String[] args) throws JMSException{
		
		Connection connection = null;
		MessageProducer producer = null;
		
		try{
		ConnectionFactory factory = new ActiveMQConnectionFactory(brokerURL); 
		//需要认证调用
		//ConnectionFactory factory = new ActiveMQConnectionFactory(userName,password,brokerURL);
		connection = factory.createConnection();
		
		connection.start();
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);  
	    producer = session.createProducer(null); 
		
		Topic topic=session.createTopic("topic1");
		Message message=session.createMessage();
		message.setJMSDeliveryMode(Message.DEFAULT_DELIVERY_MODE);
		message.setStringProperty("name", "lili");
		
		producer.send(topic, message);
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(producer!=null)
				try{producer.close();}catch(Exception e){e.printStackTrace();}
			
			if(connection!=null)
				try{connection.close();}catch(Exception e){e.printStackTrace();}
		}
		
	}
}
