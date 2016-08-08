package packt.jee.eclipse.jms.jsf_bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;

import packt.jee.eclipse.jms.dto.CourseDTO;

@ManagedBean(name="courseMessageSender")
@SessionScoped
public class CourseManagedMsgSenderBean {
	
	
	@Resource(name = "jms/CourseManagemenCF")
	private QueueConnectionFactory connectionFactory;
	@Resource(lookup = "jms/courseManagementQueue")
	private Queue queue;
	
	QueueConnection connection;
	QueueSession session;
	Exception initException = null;
	
	@PostConstruct
	public void init() {
		try {
			connection = connectionFactory.createQueueConnection();
			connection.start();
			session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		} catch (Exception e) {
			initException = e;
		}
	}
	
	@PreDestroy
	public void cleanup() {
		if (connection != null) {
			try {
				connection.close();
			} catch (JMSException e) {
				e.printStackTrace();
				//TODO: log exception
			}
		}
	}
	
	public void addCourse(CourseDTO courseDTO) throws Exception {
		
		if (initException != null)
			throw initException;
		
		QueueSender sender = session.createSender(queue);
		ObjectMessage objMessage = session.createObjectMessage(courseDTO);
		sender.send(objMessage);

		//Send MapMessage too. This will be processed by CourseMDB
		
		//TODO: Map message is used only to simplify the example. 
		//You might want to convert courseDTO to JSON or XML using, 
		//for example, JAXB.
		
		MapMessage mapMessage = session.createMapMessage();
		mapMessage.setString("name", courseDTO.getName());
		mapMessage.setInt("credits", courseDTO.getCredits());
		sender.send(mapMessage);
	}
}
