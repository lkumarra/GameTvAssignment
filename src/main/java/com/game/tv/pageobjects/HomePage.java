package com.game.tv.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import com.game.tv.mapper.GameTvMapper;
import com.game.tv.utilities.Utilities;

public class HomePage extends BasePage {

	private static Utilities utilities = new Utilities();

	private By gameList = By.xpath("//div[@class = 'game-wrapper']/a");
	private By tournament = By.xpath("//span[@class = \"count-tournaments\"]");

	public List<GameTvMapper> getGameTvMapperList() {
		List<GameTvMapper> gameTvMapper = new ArrayList<>();
		int gameListSize = utilities.getWebelementCount(gameList);
		for (int i = 1; i <= gameListSize; i++) {
			By game = By.xpath("(//div[@class = 'game-wrapper']/a)[" + i + "]");
			String gameText = utilities.getWebElementText(game);
			utilities.clickOnWebelemet(game);
			String currentPageUrl = driver.getCurrentUrl();
			int statusCode = utilities.getStatusCode(currentPageUrl);
			String tournamenetText = utilities.getWebElementText(tournament);
			gameTvMapper.add(new GameTvMapper(gameText, currentPageUrl, statusCode, tournamenetText));
			utilities.navigateBack();
		}
		return gameTvMapper;
	}

}
