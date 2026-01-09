package il.co.harel.digital;

import java.io.IOException;
import org.testng.annotations.Test;
import base.BasePage;
import testcases.TravelPolicy;

public class SanityTest extends BasePage {

	public SanityTest() throws IOException {
		super();		
	}
	
	@Test(description = "Purchasing travel insurance for traveling abroad.")
	public void travelPolicytest() {
		
		TravelPolicy.travel();	
	}
}