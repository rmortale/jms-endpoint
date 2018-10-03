package ch.dulce.dw;

import ch.dulce.dw.core.jms.JmsListener;
import com.kjetland.dropwizard.activemq.ActiveMQBundle;
import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DwApplication extends Application<DwConfiguration> {

    private ActiveMQBundle activeMQBundle;

    public static void main(final String[] args) throws Exception {
        new DwApplication().run(args);
    }

    @Override
    public String getName() {
        return "Dw";
    }

    @Override
    public void initialize(final Bootstrap<DwConfiguration> bootstrap) {
        activeMQBundle = new ActiveMQBundle();
        bootstrap.addBundle(activeMQBundle);
        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor(false)
                )
        );
    }

    @Override
    public void run(final DwConfiguration configuration,
            final Environment environment) {
        new JmsListener(activeMQBundle);
    }

}
