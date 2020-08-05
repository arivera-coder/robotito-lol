package configuration;

import com.google.gson.Gson;
import com.google.inject.AbstractModule;

public class ServiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Gson.class);
    }
}
