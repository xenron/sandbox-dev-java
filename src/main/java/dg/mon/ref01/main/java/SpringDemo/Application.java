package SpringDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@ComponentScan
public class Application {

    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
              return "Hello World! Spring FrameWork!";
            }
        };
    }

  @SuppressWarnings("resource")
public static void main(String[] args) {
	ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
	MessagePrinter printer = context.getBean(MessagePrinter.class);
    printer.printMessage();     
  }
}
