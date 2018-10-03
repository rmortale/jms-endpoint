package ch.dulce.dw.core.jms;

import com.kjetland.dropwizard.activemq.ActiveMQBundle;

public class JmsListener {

    private final ActiveMQBundle amq;

    public JmsListener(ActiveMQBundle amq) {
        this.amq = amq;
        amq.registerReceiver("vai.to.dwtest.queue.01", // default is queue. Prefix with 'topic:' or 'queue:' to choose
                new JmsReceiver(),
                String.class,
                new JmsExceptionHandler()
        );
    }
}
