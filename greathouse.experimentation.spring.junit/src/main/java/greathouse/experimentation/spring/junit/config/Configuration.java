/**
 * 
 */
package greathouse.experimentation.spring.junit.config;

import greathouse.experimentation.spring.junit.model.Message;
import greathouse.experimentation.spring.junit.writers.ConsoleMessageWriter;
import greathouse.experimentation.spring.junit.writers.MessageWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
/**
 * @author cyotee
 *
 */
@PropertySource(value="classpath:/config.properties")
@ComponentScan("greathouse")
public class Configuration {

	@Autowired
	private Environment environment;
	
	@Bean
	@Scope("prototype")
	public Message message(){
		Message message = new Message();
		message.setMessageBody(environment.getProperty("message.body"));
		return message;
	}
	
	@Bean
	public MessageWriter consoleMessageWriter(){
		return new ConsoleMessageWriter();
	}
}
