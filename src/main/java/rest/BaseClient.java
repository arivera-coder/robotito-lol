package rest;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.util.Map;

@Singleton
public class BaseClient {
	private ClientConfig clientConfig;
	private Client client;
	protected Map<String,String> headers;

	@Inject
	public BaseClient() {
		this.clientConfig =new DefaultClientConfig();
		this.client = Client.create(clientConfig);
	}

	public Object get (String uri){
		WebResource webResource = this.client.resource(UriBuilder.fromUri(uri).build());
		webResource.type(MediaType.APPLICATION_JSON_TYPE);
		setDataHeaders(webResource);
		return webResource.get(Object.class);
	}

	public void setDataHeaders(WebResource webResource){
		this.headers.keySet().forEach(key->{
			webResource.header(key,this.headers.get(key));
		});
	}
}
