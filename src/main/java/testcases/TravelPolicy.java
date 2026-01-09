package testcases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import extensions.UiActions;
import extensions.Verifications;
import pageObjects.*;
import static pageObjects.ManagePages.*;

public class TravelPolicy {
	
	public static void travel() {
		
		UiActions.click(page(TravelPage.class).oneTimePurchase());
		UiActions.click(page(DestinationPage.class).land("canada"));
		UiActions.click(page(DestinationPage.class).updateSelect());
		UiActions.click(page(DatePage.class).datePicker(getCurrentDate(7)));
		UiActions.click(page(DatePage.class).datePicker(getCurrentDate(37)));
		int expectedSum = getDateRange(getCurrentDate(7),getCurrentDate(37));
		String actualSum = UiActions.getText(page(DatePage.class).totalDays());
		//Verify that the number of days between the dates is equal to the actual total.
		Verifications.verifyEquals(actualSum, String.valueOf(expectedSum));
		UiActions.click(page(DatePage.class).next());
		//Verify that the title in the new page.
		Verifications.verifyText(getTile(), "מילוי פרטי הנוסעים | רכישת ביטוח נסיעות לחו\"ל");
	}

	private static String getCurrentDate(int offset) {
        return LocalDate.now().plusDays(offset).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
	
	private static int getDateRange(String startDate, String endDate) {
	    return (int) ChronoUnit.DAYS.between(LocalDate.parse(startDate),LocalDate.parse(endDate)) + 1;
	}
}