package configuration;

import com.google.inject.AbstractModule;
import controller.SummonerController;
import rest.BaseClient;
import rest.SummonerInfoByNameRest;

public class ControllerModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(SummonerController.class);
	}
}
