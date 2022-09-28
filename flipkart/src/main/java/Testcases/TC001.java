package Testcases;
import org.testng.annotations.Test;

import utils.Base;



public class TC001 extends Base {
	@Test
	public static void TC001() throws Exception{
		Base.openapp();
		Base.login("9393729999","hari2247");
		Base.logout();
		Base.closeapp();
	}
	}

