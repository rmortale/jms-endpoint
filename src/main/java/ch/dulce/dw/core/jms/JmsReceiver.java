package ch.dulce.dw.core.jms;

import com.kjetland.dropwizard.activemq.ActiveMQReceiver;

public class JmsReceiver implements ActiveMQReceiver<String> {

    @Override
    public void receive(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
