package com.game.tv.test;

import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.game.tv.constants.Constants;
import com.game.tv.mapper.GameTvMapper;
import com.game.tv.pageobjects.BasePage;
import com.game.tv.pageobjects.HomePage;
import com.game.tv.utilities.ExcelUtility;

public class GameTvTest {
	
	private static String[] columns = { "Game name", "Page URL", "Page Status", "Tournament count" };
	private HomePage homePage = new HomePage();
	private ExcelUtility excelUtil = new ExcelUtility();
	
	
	@BeforeMethod
	public void setUp() {
		BasePage.initialization(Constants.browser, Constants.url);
	}
	
	@Test
	public void createList() {
		List<GameTvMapper> gameMapper = homePage.getGameTvMapperList();
		excelUtil.enterTextToExcel(gameMapper, columns);
	}
	
	@AfterMethod
	public void tearDown() {
		BasePage.tearDown();
	}

}
