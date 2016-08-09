package com.packt.ch05;

import com.packt.ch05.NewSessionBean;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import org.junit.Assert;
import org.junit.Test;



/**
 * Unit test for simple App.
 */
public class AppTest {
    
    @Test
    public void testAddition(){            
        Map<String, Object> properties = new HashMap<String, Object>();  
        properties.put(EJBContainer.APP_NAME, "chapter05EmbeddableEJBContainer");
        properties.put(EJBContainer.MODULES, new File("target\\classes"));           
        try(EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer(properties);) {
            NewSessionBean bean = (NewSessionBean) container.getContext().lookup("java:global/chapter05EmbeddableEJBContainer/NewSessionBean");
            int restult = bean.addition(10, 10);
            Assert.assertEquals(20, restult);
        } catch (NamingException ex) {
            Logger.getLogger(AppTest.class.getName()).log(Level.FINEST, null, ex);
        }
    }
    
    @Test
    public void testAddition2(){            
        Map<String, Object> properties = new HashMap<String, Object>();  
        properties.put(EJBContainer.APP_NAME, "chapter05EmbeddableEJBContainer");
        properties.put(EJBContainer.MODULES, new File("target\\classes"));   
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer(properties);
        try {
            NewSessionBean bean = (NewSessionBean) container.getContext().lookup("java:global/chapter05EmbeddableEJBContainer/NewSessionBean");
            int restult = bean.addition(10, 10);
            Assert.assertEquals(20, restult);
        } catch (NamingException ex) {
            Logger.getLogger(AppTest.class.getName()).log(Level.FINEST, null, ex);
        } finally {
            container.close();
        }
    }
}
