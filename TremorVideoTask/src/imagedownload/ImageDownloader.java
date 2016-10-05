package imagedownload;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
* ImageDownloader class - Main class to download 10 images in parallel using the DownloadJob
* @author  Vinoth Kumar
* @version 1.0
* @since   2016-10-03
*/

public class ImageDownloader {
	
	private static final int MYTHREADS = 10;
	private static final String location = "src/imagedownload/images.csv";
	
	public static void main(String args[]) throws Exception {
		
		ExecutorService executor = Executors.newFixedThreadPool(MYTHREADS);
		CsvParser csvp = new CsvParser();
		
		if (location!= null){			
			ArrayList<String> urls = csvp.parseurl(location);
			for (int i = 0; i < urls.size(); i++) {	 
				String url = urls.get(i);
				Runnable worker = new DownloadJob(url);
				executor.execute(worker);
			}
			executor.shutdown();
			while (!executor.isTerminated()) {
	 
			}
			System.out.println("\nFinished all threads");
			
		}
	}
}
