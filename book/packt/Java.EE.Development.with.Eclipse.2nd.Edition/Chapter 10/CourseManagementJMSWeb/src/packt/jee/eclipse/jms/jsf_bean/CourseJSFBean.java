package packt.jee.eclipse.jms.jsf_bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import packt.jee.eclipse.jms.dto.CourseDTO;

@ManagedBean(name="course")
@RequestScoped
public class CourseJSFBean {
	private CourseDTO courseDTO = new CourseDTO();
	
	@ManagedProperty(value="#{courseMessageSender}")
	private CourseManagedMsgSenderBean courseMessageSender;

	public String getName() {
		return this.courseDTO.getName();
	}
	public void setName(String name) {
		this.courseDTO.setName(name); 
	}
	public int getCredits() {
		return this.courseDTO.getCredits();
	}
	public void setCredits(int credits) {
		this.courseDTO.setCredits(credits);;
	}
	public void setCourseMessageSender(CourseManagedMsgSenderBean courseMessageSender) {
		this.courseMessageSender = courseMessageSender;
	}
	
	public void addCourse() throws Exception {
		//skipping validation
		//TODO: handle exception properly and show error message
		courseMessageSender.addCourse(courseDTO);
	}
}
