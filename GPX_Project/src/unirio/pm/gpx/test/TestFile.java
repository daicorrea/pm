package unirio.pm.gpx.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

import unirio.pm.gpx.model.Track;
import unirio.pm.gpx.model.TrackPoint;
import unirio.pm.gpx.parser.GPXReader;

public class TestFile {

	@Test
	//Test if it's reading the file correctly
	public void testReader() {
		String testFileName = "../GPX_Project/src/unirio/pm/gpx/file/foxboroTest.gpx";
	    
	    //Creating object lists
	    ArrayList<Track> trackList = new ArrayList<Track>();
	    ArrayList<TrackPoint> trackPointsRead = new ArrayList<TrackPoint>();
	  		
	    //Read GPX File
	    try {
			trackList = GPXReader.ReadGPX(testFileName);
		} catch (IOException | ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		}
	    
	    //Getting the TrackPoint list read
	    trackPointsRead = trackList.get(0).getSegments().get(0).getTrackPoints();
	    
	    //Creating and adding TrackPoints to a list
	    ArrayList<TrackPoint> trackPointlist = new ArrayList<TrackPoint>();
	    TrackPoint firstTrackPoint = createTrackPoint("42.050664", "-71.267238", "63.584351", "2002-03-06T04:23:07Z");	
	    trackPointlist.add(firstTrackPoint);
	    TrackPoint secTrackPoint = createTrackPoint("43.050664", "-72.267238", "64.584351", "2002-03-06T05:20:07Z");	
	    trackPointlist.add(secTrackPoint);
	    
	    //Testing the list size
	    assertEquals(trackPointlist.size(), trackPointsRead.size());
	    
	    //Testing the elements of the lists
	    for (int i = 0; i < trackPointsRead.size(); i++) {
		    float elem1 = trackPointlist.get(i).getEle();
		    float elem2 = trackPointsRead.get(i).getEle();
		    
	        //assuming that both lists are sorted and the delta is 0.0002
	        assertEquals(elem1, elem2, 0.0002); 
            
        };
	}
	
	//Creating new TrackPoint
	static private TrackPoint createTrackPoint(String latitude, String longitude, String ele, String time) {
				
		//Creating new TrackPoing
		TrackPoint trackPoint = new TrackPoint(Float.valueOf(latitude),Float.valueOf(longitude),Float.valueOf(ele),time);	
		return trackPoint;
	}

}
