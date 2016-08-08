package packt.jee.eclipse.jms.jsf_bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;

import packt.jee.eclipse.jms.dto.CourseDTO;

@ManagedBean(name="courseMessageReceiver")
@ApplicationScoped
public class CourseManagedMsgReceiverBean {
	
	@Resource(name = "jms/CourseManagemenCF")
	private QueueConnectionFactory connectionFactory;
	@Resource(lookup = "jms/courseManagementQueue")
	private Queue queue;
	
	QueueConnection connection;
	QueueSession session;
	Throwable initException = null;
	
	@PostConstruct
	public void init() {
		try {
			connection = connectionFactory.createQueueConnection();
			connection.start();
			session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			
			QueueReceiver receiver = session.createReceiver(queue);
			receiver.setMessageListener(new MessageListener() {
				
				@Override
				public void onMessage(Message message) {
					//we expect ObjectMessage here; of type CourseDTO
					//Skipping validation
					try {
						CourseDTO course = (CourseDTO) ((ObjectMessage)message).getObject();
						
						//process addCourse action. For example, save it in database
						
						System.out.println("Received addCourse message for Course name - " + course.getName());
						
					} catch (JMSException e) {
						e.printStackTrace();
						//TODO: handle and log exception
					}
				}
			});
		} catch (Throwable e) {
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
	
}
