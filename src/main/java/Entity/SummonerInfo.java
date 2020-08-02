package Entity;

import lombok.Data;

@Data
public class SummonerInfo {
	private Long revisionDate;
	private String id;
	private String accountId;
	private String puuid;
	private String name;
	private Long profileIconId;
	private Long summonerLevel;
}
