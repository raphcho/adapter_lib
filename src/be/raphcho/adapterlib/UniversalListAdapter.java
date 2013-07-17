package be.raphcho.adapterlib;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class UniversalListAdapter extends ArrayAdapter<Object> {
	
	private ArrayList<ViewHolder>	holders	= new ArrayList<ViewHolder>();
	private LayoutInflater	      inflater;
	private Context	              mContext;
	private Object[]	          objects;
	private Integer	              layoutId;
	
	@SuppressWarnings("unchecked")
	public UniversalListAdapter(Context context, int resource, ArrayList<?> objects) {
		super(context, resource, (ArrayList<Object>) objects);
		if (objects != null) {
			this.objects = new Object[objects.size()];
			objects.toArray(this.objects);
			init(context, resource, this.objects);
		}
	}
	
	public UniversalListAdapter(Context context, int resource, Object[] objects) {
		super(context, resource, resource, objects);
		init(context, resource, objects);
	}
	
	private void init(Context context, int resources, Object[] objs) {
		mContext = context;
		inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.objects = objs;
		layoutId = resources;
	}
	
	@Override
	public int getCount() {
		return this.objects.length;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (objects != null && getCount() > position) {
			Object obj = objects[position];
			// }
			ViewHolder holder;
			if (convertView == null) {
				convertView = inflater.inflate(layoutId, null);
				if (holders.size() > position && holders.get(position) != null)
					holder = holders.get(position);
				else {
					holder = new ViewHolder();
					holders.add(holder);
				}
				
				convertView.setTag(holder);
				onNewViewCreated(holder, convertView);
			}
			else {
				holder = (ViewHolder) convertView.getTag();
			}
			onViewLoaded(obj, position, holder, convertView);
		}
		return convertView;
		
	}
	
	public void onViewLoaded(Object obj, int position, ViewHolder holder, View convertView) {
	};
	
	public void onNewViewCreated(ViewHolder holder, View convertView) {
	};
}
