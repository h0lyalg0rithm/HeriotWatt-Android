package com.yoarabia.heriotwatt;

import java.util.List;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;



public class LocationsMapsActivity extends MapActivity{
    /** Called when the activity is first created. */
    
    private MapView mapView;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.locationmaps);
        mapView = (MapView) findViewById(R.id.locationmapview);
        mapView.setBuiltInZoomControls(true);
        
        List<Overlay> mapOverlays = mapView.getOverlays();
        Drawable drawable = this.getResources().getDrawable(R.drawable.pin);
        Overlayclass itemizedOverlay = new Overlayclass(drawable, this);
        GeoPoint heriot = new GeoPoint(25129900,55417013);
        OverlayItem overlayitem = new OverlayItem(heriot, "Heriot Watt University Dubai Campus", "");
        itemizedOverlay.addOverlay(overlayitem);
        mapOverlays.add(itemizedOverlay);
        MapController mapController1 = mapView.getController();
        mapController1.animateTo(heriot);
        mapController1.setZoom(11);
        GeoPoint etisalat = new GeoPoint(25260843,55410962);
        overlayitem = new OverlayItem(etisalat, "Etisalat Academy", "");
        itemizedOverlay.addOverlay(overlayitem);
        mapOverlays.add(itemizedOverlay);
        GeoPoint metro = new GeoPoint(25230741,55391586);
        overlayitem = new OverlayItem(metro, "Rashidiya Metro Station", "");
        itemizedOverlay.addOverlay(overlayitem);
        mapOverlays.add(itemizedOverlay);

    }

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
}