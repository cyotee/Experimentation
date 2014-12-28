/**
 * 
 */
package greathouse.experimentation.junit;

import static org.junit.Assert.*;
import greathouse.experimentation.junit.model.Message;
import greathouse.experimentation.junit.writers.ConsoleMessageWriter;
import greathouse.experimentation.junit.writers.MessageWriter;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;

/**
 * @author cyotee
 *
 */
public class ConsoleMessageWriterTest {
	private Message testMessage;
	
	private String messageBody;
	
	private MessageWriter testMessageWriter;
	
	@Rule
	public final StandardOutputStreamLog log = new StandardOutputStreamLog();
	
	@Before
	public void setup(){
		initializeMessageBody();
		initializeTestMessage();
		initializeMessageWriter();
	}
	/**
	 * Test method for {@link greathouse.experimentation.junit.writers.ConsoleMessageWriter#writeMessage(greathouse.experimentation.junit.model.Message)}.
	 */
	@Test
	public void testWriteMessage() {
		testMessageWriter.writeMessage(testMessage);
		assertEquals(messageBody, log.getLog());
	}
	
	private void initializeMessageBody(){
		messageBody = "Hello World.";
	}
	
	private void initializeTestMessage(){
		testMessage = new Message();
		testMessage.setMessageBody(messageBody);
	}
	
	private void initializeMessageWriter(){
		testMessageWriter = new ConsoleMessageWriter();
	}
}
