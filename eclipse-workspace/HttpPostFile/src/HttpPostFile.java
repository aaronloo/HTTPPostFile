

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;



public class HttpPostFile {


	public static void main(String[] args) {
		
		// Declarations
		String url = "";
		String options = "";
		String charset = "UTF-8";
		String param = "value";
		File file = new File("");
		String boundary = Long.toHexString(System.currentTimeMillis()); // Just generate some unique random value.
		String CRLF = "\r\n"; // Line separator required by multipart/form-data.
		
		
		// Prepare arguments
		int arguments = 0;
        for(String argument: args)
        {
        	switch (++arguments) {
        		case 1: url = argument;
        		System.out.println(url);
        		break;
        	
        		case 2: file = new File(argument);
        		System.out.println(file.getName());
        		break;
        	
        		case 3: options = argument;
        		System.out.println(options);
        		break;
        	}            
        }

        
		try {

			String urlParameters  = "param1=a&param2=b&param3=c";
			byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );
			int    postDataLength = postData.length;
			String request        = "http://example.com/index.php";
			URL    url1            = new URL( request );
			
			HttpURLConnection conn= (HttpURLConnection) url1.openConnection();  
			
			conn.setDoOutput( true ); // Send body with request
			conn.setInstanceFollowRedirects( false ); // Don't automatically follow redirects
			conn.setRequestMethod( "POST" ); 
			conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded"); 
			conn.setRequestProperty( "charset", "utf-8");
			conn.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));
			conn.setUseCaches( false );
			
			try( DataOutputStream wr = new DataOutputStream( conn.getOutputStream())) {
			   wr.write( postData );
			}
		    
			System.out.println("Hello, World");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
        
    }
	
}
