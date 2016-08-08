package packt.jee.eclipse.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CourseService {
	
	private ICourseDAO courseDAO;
	
	@Autowired
	public void setCourseDAO (@Qualifier("courseDAO1") ICourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	public ICourseDAO getCourseDAO() {
		return courseDAO;
	}	
}
