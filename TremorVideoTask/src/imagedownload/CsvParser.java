package imagedownload;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
* CsvParser class - To read a csv file from a location and return the list of URLs
*
* @author  Vinoth Kumar
* @version 1.0
* @since   2016-10-03
*/
public class CsvParser {
	
	/**
	 * Parse a CSV file at a given location and obtain the list of URLs
	 * @param  fileLocation  an absolute path of the file Location
	 * @return      list of URLs
	 */
	public ArrayList<String> parseurl(String fileLocation){
		
		BufferedReader br = null;
		String splitBy = ",";
		String line = "";
		ArrayList<String> urls = new ArrayList<String>();	
		try {
            br = new BufferedReader(new FileReader(fileLocation));
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(splitBy);
                urls.add(arr[2].trim());             
            }          
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		return urls;		
	}
}
