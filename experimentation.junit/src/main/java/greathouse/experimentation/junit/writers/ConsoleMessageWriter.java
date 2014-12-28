/**
 * 
 */
package greathouse.experimentation.junit.writers;

import greathouse.experimentation.junit.model.Message;

/**
 * @author cyotee
 *
 */
public class ConsoleMessageWriter implements MessageWriter {

	/* (non-Javadoc)
	 * @see greathouse.experimentation.junit.writers.MessageWriter#writeMessage(greathouse.experimentation.junit.model.Message)
	 */
	public void writeMessage(Message message) {
		System.out.print(message.getMessageBody());
	}

}
