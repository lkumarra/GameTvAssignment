package com.game.tv.mapper;

public class GameTvMapper {
	
	private String gameName;
	private String pageUrl;
	private int pageStatus;
	private String tournamentCount;
	
	public GameTvMapper(String gameName, String pageUrl, int pageStatus, String tournamentCount){
		this.gameName = gameName;
		this.pageUrl = pageUrl;
		this.pageStatus = pageStatus;
		this.tournamentCount = tournamentCount;
	}

	public String getGameName() {
		return gameName;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public int getPageStatus() {
		return pageStatus;
	}

	public String getTournamentCount() {
		return tournamentCount;
	}

}
