package rest;

import Entity.SummonerInfo;
import com.google.inject.Inject;

import com.sun.jersey.core.util.MultivaluedMapImpl;
import lombok.extern.slf4j.Slf4j;
import javax.ws.rs.core.MultivaluedMap;

import javax.inject.Singleton;
import java.io.IOException;
import java.util.HashMap;

@Slf4j
@Singleton
public class SummonerInfoByNameRest extends BaseClient {

	private static String URL = "https://la2.api.riotgames.com/lol/summoner/v4/summoners/by-name/%s";

	@Inject
	public SummonerInfoByNameRest() throws IOException {
		super.headers = new HashMap<>();
		super.headers.put("X-Riot-Token","RGAPI-c9c99a88-09f0-471a-9171-e27439325c04");
		//super.headers.put("Accept-Charset","application/x-www-form-urlencoded; charset=UTF-8");
	}

	public SummonerInfo getInfoByNameSummoner(String nameSummoner){
		SummonerInfo res =null;
		try{
			res = super.get(String.format(URL,nameSummoner), SummonerInfo.class);
			return res;
		}catch (Exception e) {
			log.error("error in api riot games",e);
		}
		return res;
	}

}
