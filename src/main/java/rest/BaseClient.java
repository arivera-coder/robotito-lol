package rest;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import javax.ws.rs.core.MultivaluedMap;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.util.Map;

@Singleton
public class BaseClient {
	private ClientConfig clientConfig;
	private Client client;
	private Gson gson = new Gson();
	protected Map<String,String> headers;

	@Inject
	public BaseClient() {
		this.clientConfig =new DefaultClientConfig();
		this.client = Client.create(clientConfig);
	}

	public Object get (String uri){
		WebResource webResource = this.client.resource(UriBuilder.fromUri(uri).build());
		webResource.type(MediaType.APPLICATION_JSON);
		//setDataHeaders(webResource);
		return webResource.get(String.class);
	}

	public <T> T get (String uri,Class<T> clazz){
		WebResource.Builder webResource = this.client.resource(UriBuilder.fromUri(uri).build()).getRequestBuilder();
		webResource.type(MediaType.APPLICATION_JSON);
		setDataHeaders(webResource);
		return gson.fromJson(webResource.get(String.class), clazz);
	}

	public void setDataHeaders(WebResource.Builder webResource){
		this.headers.keySet().forEach(key->{
			webResource.header(key.toString(),this.headers.get(key));
		});
	}
}
