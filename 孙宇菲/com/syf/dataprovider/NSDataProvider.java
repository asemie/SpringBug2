package com.syf.dataprovider;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class NSDataProvider {
	
	
	@DataProvider(name="community_Listings")
	public  Object[][] getSaleUpdateData() throws IOException{
		return new TxtDataProvider().getTxtUser("data/syf11.txt");
	}
	
	@DataProvider(name="img")
	public  Object[][] getImgData() throws IOException{
		return new TxtDataProvider().getTxtUser("data/syf12.txt");
	}
	
	@DataProvider(name="search")
	public  Object[][] getSearchData() throws IOException{
		return new TxtDataProvider().getTxtUser("data/syf13.txt");
	}
	
	@DataProvider(name="filter")
	public  Object[][] getFilterData() throws IOException{
		return new TxtDataProvider().getTxtUser("data/syf14.txt");
	}
	
	@DataProvider(name="add_title")
	public  Object[][] getAddTitleData() throws IOException{
		return new TxtDataProvider().getTxtUser("data/syf15.txt");
	}
	
	@DataProvider(name="add_property")
	public  Object[][] getAddPropertyData() throws IOException{
		return new TxtDataProvider().getTxtUser("data/syf16.txt");
	}
	
	@DataProvider(name="ad_update")
	public  Object[][] getAdUpdateData() throws IOException{
		return new TxtDataProvider().getTxtUser("data/syf21.txt");
	}
	
	@DataProvider(name="member_add")
	public  Object[][] getMemberAddData() throws IOException{
		return new TxtDataProvider().getTxtUser("data/syf22.txt");
	}

	@DataProvider(name="news_search_select")
	public  Object[][] getNewsSearch1Data() throws IOException{
		return new TxtDataProvider().getTxtUser("data/syf31.txt");
	}
	
	@DataProvider(name="news_search_type")
	public  Object[][] getNewsSearch2Data() throws IOException{
		return new TxtDataProvider().getTxtUser("data/syf32.txt");
	}
	
	
}
