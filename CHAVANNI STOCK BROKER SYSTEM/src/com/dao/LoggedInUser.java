package com.dao;

public class LoggedInUser {
	public static int loggedInUserId;
	public static int adminLoggedIn = 0;
}

//update holding set stid = 2103 , stName = (select stockCompName from stock where stid = 2103) , cid = 1003 , quantity = 2 , wid = (select wid from wallet where cid = 1003 ),totalStockPrice = (select price from stock where  stockid = 2103 ) where cid = 1003