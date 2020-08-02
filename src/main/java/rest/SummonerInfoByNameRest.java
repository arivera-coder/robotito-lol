package rest;

import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Singleton;
import java.io.IOException;
import java.util.HashMap;

@Singleton
public class SummonerInfoByNameRest extends BaseClient {

	private static String URL = "https://la2.api.riotgames.com/lol/summoner/v4/summoners/by-name/%s";

	@Inject
	public SummonerInfoByNameRest() throws IOException {
		super.headers = new HashMap<>();
		super.headers.put("X-Riot-Token","RGAPI-8a8f1e8f-1e0a-48d0-af80-1ca9030e19a4");
		super.headers.put("Accept-Charset","application/x-www-form-urlencoded; charset=UTF-8");
	}

	public void getInfoByNameSummoner(String nameSummoner){
		try{
			Object res = super.get(String.format(URL,nameSummoner));
		}catch (Exception e){
		}
	}

}
