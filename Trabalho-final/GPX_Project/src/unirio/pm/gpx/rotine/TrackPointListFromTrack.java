package unirio.pm.gpx.rotine;

import java.util.ArrayList;
import unirio.pm.gpx.model.Track;
import unirio.pm.gpx.model.TrackPoint;
import unirio.pm.gpx.model.TrackSegment;

public class TrackPointListFromTrack {
	
	static public ArrayList<TrackPoint> getTrackPointList(Track track) {
		
		//Creating new list to get the trackpoints
		ArrayList<TrackPoint> trackPointList = new ArrayList<TrackPoint>();
		
		//To count all the TrackPoints
		int trackPointTotal = 0;
					
			//Creating a loop to get into each TrackSegment
			for (TrackSegment trackSegment : track.getSegments()){
				
				//Creating a loop to get into each TrackPoint
				for (TrackPoint trackPoint : trackSegment.getTrackPoints()){
					
					//Getting the sum
					trackPointTotal++;
					
					//Creating a new TrackPoint
					TrackPoint newTrackPoint = new TrackPoint(trackPoint.getLatitude(),
							trackPoint.getLongitude(),trackPoint.getEle(),
							trackPoint.getTime());

					//Adding the new trackpoint to the list for the segments
					trackPointList.add(newTrackPoint);
				}
			
		}
		System.out.println("TOTAL DE TRACKPOINTS: " + trackPointTotal);
		
		//Returning the list with all the trackpoints
		return trackPointList;
	}

}
