package be.raphcho.adapterlib;

import java.util.ArrayList;

import android.view.View;

public class ViewHolder {
	
	private ArrayList<View>	views	= new ArrayList<View>();
	
	public View recupView(View parent, int id, String tag) {
		View view = parent.findViewById(id);
		view.setTag(tag);
		views.add(view);
		return view;
	}
	
	public View getView(int position) {
		return views.get(position);
	}
	
	public View getView(String tag) {
		for (View txt : views) {
			if (txt.getTag().equals(tag))
				return txt;
			
		}
		return null;
	}
	
}