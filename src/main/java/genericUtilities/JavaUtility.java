package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class  contains reusable methods to perform java related operations
 * @author sncsr
 *
 */
public class JavaUtility {
	
	/**
	 * This method is used to pause the script execution for specified time
	 * @param time
	 */
	public void pause(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to fetch current date and time
	 * @return
	 */
	public String getCurrentTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		return sdf.format(date);
	}
	
	/**
	 * This method generates random number within the specified limit
	 * @param limit
	 * @return
	 */
	public int generateRandomNum(int limit) {
		Random random = new Random();
		return random.nextInt(limit);
	}
}
