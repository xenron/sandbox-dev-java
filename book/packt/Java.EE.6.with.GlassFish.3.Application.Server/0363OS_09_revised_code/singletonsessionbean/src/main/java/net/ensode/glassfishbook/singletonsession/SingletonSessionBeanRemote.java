package net.ensode.glassfishbook.singletonsession;

import java.util.List;
import javax.ejb.Remote;
import net.ensode.glassfishbook.entity.UsStates;

/**
 *
 * @author heffel
 */
@Remote
public interface SingletonSessionBeanRemote {

    List<UsStates> getStateList();
   
}
