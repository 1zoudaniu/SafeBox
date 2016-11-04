package safebox.yiye.com.safebox.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

import safebox.yiye.com.safebox.R;

public class PaiHangMainAdapter extends BaseAdapter {

	private Context context;
	private List<Map<String, Object>> list;
	private int position = 0;
	Holder hold;

	public PaiHangMainAdapter(Context context, List<Map<String, Object>> list) {
		this.context = context;
		this.list = list;
	}

	public PaiHangMainAdapter(Context context, List<Map<String, Object>> list,
							  boolean islodingimg) {
		this.context = context;
		this.list = list;
	}

	public int getCount() {
		return list.size();
	}

	public Object getItem(int position) {
		return list.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int arg0, View view, ViewGroup viewGroup) {

		if (view == null) {
			view = View.inflate(context, R.layout.item_paihang_mainlist, null);
			hold = new Holder(view);
			view.setTag(hold);
		} else {
			hold = (Holder) view.getTag();
		}
		hold.txt.setText(list.get(arg0).get("txt").toString());
		hold.layout.setBackgroundColor(0xFFEBEBEB);
		if (arg0 == position) {
			hold.layout.setBackgroundColor(0xFFFFFFFF);
		}
		return view;
	}

	public void setSelectItem(int position) {
		this.position = position;
	}

	public int getSelectItem() {
		return position;
	}

	private static class Holder {
		LinearLayout layout;

		TextView txt;

		public Holder(View view) {
			txt = (TextView) view.findViewById(R.id.mainitem_txt);

			layout = (LinearLayout) view.findViewById(R.id.mainitem_layout);
		}
	}
}