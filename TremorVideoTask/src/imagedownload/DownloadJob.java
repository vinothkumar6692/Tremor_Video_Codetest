package imagedownload;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import javax.imageio.ImageIO;

/**
* DownloadJob class - To download an image from a given URL and save in a local folder
*
* @author  Vinoth Kumar
* @version 1.0
* @since   2016-10-03
*/

public class DownloadJob implements Runnable {
	
	private final String url;
	private static int count = 0;
	
	DownloadJob(String url) throws UnsupportedEncodingException{		
		if (url.toString().toLowerCase().startsWith("http://")||url.toString().toLowerCase().startsWith("https://"))
			this.url = url.toString().toLowerCase();
		else 
			this.url = "http://"+url.toString().toLowerCase();
	}

	@Override
	public void run() {
		 
			String status = "";
			try {				
				BufferedImage image = null;				
				URL iurl = new URL(url);
	            image = ImageIO.read(iurl);	            
	            if(image != null){
	            //Write file to Disk
	            ImageIO.write(image, "jpg",new File("src/images/image"+count+".jpg"));
	            count++;
	            status = "Success";
	            }
	            else {
	            	status = "Failed";
	            }             
	            System.out.println(status+": "+url);
	            
			} catch (MalformedURLException e) {
				System.out.println("Failed - URL is invalid"+": "+url);
					
			}
			catch(IOException e){
				System.out.println("Failed - URL is does not have valid image"+": "+url);
			}
			catch(NullPointerException e){
				System.out.println("Failed - No image found"+": "+url);
			}		
	}
	
}
