package hello.messaging;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.retry.MessageRecoverer;

/**
 * Created by ddcnicolasg on 11/19/14.
 */
public class MessageErrorRecoverer implements MessageRecoverer {

    @Override
    public void recover(final Message message, final Throwable cause) {
        final String messageId = new String(message.getBody());

        System.err.println("MessageErrorRecoverer - message("+messageId+") failed to be delivered after every attempts :-(");
        System.err.println("  cause:" + cause.getMessage());
        cause.printStackTrace(System.err);
    }
}
