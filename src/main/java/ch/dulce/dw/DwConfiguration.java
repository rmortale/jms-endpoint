package ch.dulce.dw;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kjetland.dropwizard.activemq.ActiveMQConfig;
import com.kjetland.dropwizard.activemq.ActiveMQConfigHolder;
import io.dropwizard.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class DwConfiguration extends Configuration implements ActiveMQConfigHolder {


    @JsonProperty
    @NotNull
    @Valid
    private ActiveMQConfig activeMQ;

    @JsonProperty
    @NotNull
    private String queueName;

    public ActiveMQConfig getActiveMQ() {
        return activeMQ;
    }

    public String getQueueName() {
        return queueName;
    }
}
