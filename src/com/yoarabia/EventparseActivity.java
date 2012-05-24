package com.yoarabia;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.yoarabia.animation.ActivitySwitcher;


public class EventparseActivity extends Activity {
    /** Called when the activity is first created. */
	int length;
    String[] titles,descriptions,links;
    HttpGet request;
    ListView newslist;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.news);
        InternetChecker internet = new InternetChecker();
        if(!internet.isOnline(this)){
        	Toast.makeText(getApplicationContext(), "Please Connect to the Internet", Toast.LENGTH_SHORT).show();
        	finish();
        }else{
        TextView parsetitle = (TextView)findViewById(R.id.parsetitle);
        newslist = (ListView)findViewById(R.id.eventslist);
        String url = this.getIntent().getStringExtra("url");
        Log.d("URL", url);
        if(url.contentEquals("1")){
        	request = new HttpGet("http://www.hw.ac.uk/feeds/news.xml?utm_source=rss&utm_medium=subscribe&utm_campaign=news"); 
        	parsetitle.setText("News");
        	
        }
        else{
        	request = new HttpGet("http://www.hw.ac.uk/feeds/events.xml?utm_source=rss&utm_medium=subscribe&utm_campaign=events");
        	parsetitle.setText("Events");
        }
        new Downloadonline().execute("1");
        }
        
    }
    private class Downloadonline extends AsyncTask<String, String, String> {
        protected String doInBackground(String... params) {
       	 //request = new HttpGet("http://www.hw.ac.uk/feeds/news.xml?utm_source=rss&utm_medium=subscribe&utm_campaign=news");
         
         HttpClient client = new DefaultHttpClient(); //HttpClient is to make a communication entry point from client side
         
         try {
             HttpResponse response = client.execute(request); //httpResponse to capture any issues retrieving data

             StatusLine status = response.getStatusLine(); // alwyays httpresponse comes with the statusLine
             if (status.getStatusCode() != 200) {
             	 Log.d("error", "No internet");
                 throw new IOException("Invalid response from server: " + status.toString());
             }

             // Pull content stream from response
             HttpEntity entity = response.getEntity();
             InputStream inputStream = entity.getContent();// Retrieves content from entity and converts to stream

             DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();//Is to read the parser that prodcues from XML DOM.
             DocumentBuilder db = dbf.newDocumentBuilder();//Once an instance of this class is obtained, XML can be parsed from a variety of input sources. These input sources are InputStreams, Files, URLs, and SAX InputSources. There are many sources to take data from internet.
             Document doc = db.parse(inputStream);//the Document represents the entire HTML or XML document. Conceptually, it is the root of the document tree, and provides the primary access to the document's data.

             doc.getDocumentElement().normalize();
             //Log.d("xml", doc.toString());
            
             NodeList title = doc.getElementsByTagName("title");
             
             length = title.getLength();
            // Log.d("length", );
             //int j =title.getLength();
             //Toast.makeText(getApplicationContext(), j, Toast.LENGTH_SHORT).show();
             String[] temp = new String[title.getLength()];
             NodeList description = doc.getElementsByTagName("description");
             String[] temp1 = new String[title.getLength()];
             NodeList link = doc.getElementsByTagName("link");
             String[] temp2 = new String[title.getLength()];
             for(int i=0;i<title.getLength();i++)
             {
             	temp[i] = title.item(i).getChildNodes().item(0).getNodeValue();
             	temp2[i] = link.item(i).getChildNodes().item(0).getNodeValue();
             }
             //Log.d("length",name);
             //titles[0] = "second";
             titles = new String[temp.length-2];
             //descriptions = new String[temp1.length-2];
             links = new String[temp2.length-2];
             for(int j=0;j<temp.length-2;j++){
             	titles[j] = temp[j+2]; 
             	//descriptions[j] = temp1[j+2];
             	links[j] = temp2[j+2];
             }
             
         } catch (IOException e) {
            Log.d("error", e.getLocalizedMessage());
         } catch (ParserConfigurationException e) {
 		} catch (SAXException e) {
 			e.printStackTrace();
 		}
         return null;
        }

		protected void onPostExecute(String result) {
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(EventparseActivity.this,android.R.layout.simple_list_item_1,titles);
	        newslist.setAdapter(adapter);
	        newslist.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int position, long arg3) {
					// TODO Auto-generated method stub
					final Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(links[position]));
					intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
					ActivitySwitcher.animationOut(findViewById(R.id.container), getWindowManager(), new ActivitySwitcher.AnimationFinishedListener() {
						@Override
						public void onAnimationFinished() {
							startActivity(intent);
						}
					});
				}
			});
		}

		
		

		
    }
   
    
    protected void onResume() {
		// animateIn this activity
		ActivitySwitcher.animationIn(findViewById(R.id.container), getWindowManager());
		super.onResume();
	}
}