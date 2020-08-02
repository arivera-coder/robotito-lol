package controller;

import rest.SummonerInfoByNameRest;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SummonerController {

	private SummonerInfoByNameRest summonerInfoByNameRest;

	@Inject
	public SummonerController(SummonerInfoByNameRest summonerInfoByNameRest) {
		this.summonerInfoByNameRest = summonerInfoByNameRest;
	}

	public void getInfo(String name){
		summonerInfoByNameRest.getInfoByNameSummoner(name);
	}

}
