/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.dulce.dw.core.jms;

import com.kjetland.dropwizard.activemq.ActiveMQExceptionHandler;

/**
 *
 * @author VIDOA
 */
public class JmsExceptionHandler implements ActiveMQExceptionHandler {

    @Override
    public boolean onException(String message, Exception exception) {
        System.out.println("exception handler: " + exception.getMessage());
        return true;
    }

}
