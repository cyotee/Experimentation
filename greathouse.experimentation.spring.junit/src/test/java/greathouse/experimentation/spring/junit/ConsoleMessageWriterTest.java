/**
 * 
 */
package greathouse.experimentation.spring.junit;

import static org.junit.Assert.*;
import greathouse.experimentation.spring.junit.config.Configuration;
import greathouse.experimentation.spring.junit.model.Message;
import greathouse.experimentation.spring.junit.writers.MessageWriter;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author cyotee
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=Configuration.class)
public class ConsoleMessageWriterTest {
	@Autowired
	private Environment environment;
	
	@Autowired
	private Message testMessage;
	
	@Autowired
	private MessageWriter testMessageWriter;
	
	@Rule
	public final StandardOutputStreamLog log = new StandardOutputStreamLog();
	
	/**
	 * Test method for {@link greathouse.experimentation.junit.writers.ConsoleMessageWriter#writeMessage(greathouse.experimentation.junit.model.Message)}.
	 */
	@Test
	public void testWriteMessage() {
		testMessageWriter.writeMessage(testMessage);
		assertEquals(environment.getProperty("message.body"), log.getLog());
	}
}
