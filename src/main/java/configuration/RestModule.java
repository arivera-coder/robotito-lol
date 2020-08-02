package configuration;

import com.google.inject.AbstractModule;
import rest.BaseClient;
import rest.SummonerInfoByNameRest;

public class RestModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(BaseClient.class);
		bind(SummonerInfoByNameRest.class);
	}

}
