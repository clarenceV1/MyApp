package com.wodejia.myapp.ui.manager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wodejia.myapp.R;
import com.wodejia.myapp.data.manager.FunctionDO;

import java.util.List;

/**
 * Created by clarence on 16/9/19.
 */
public class ManagerMainAdapter extends BaseAdapter {
    List<FunctionDO> functionDOList;
    Context context;
    LayoutInflater layoutInflater;

    public ManagerMainAdapter(Context context, List<FunctionDO> functionDOList) {
        this.context = context;
        this.functionDOList = functionDOList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return functionDOList == null ? 0 : functionDOList.size();
    }

    @Override
    public FunctionDO getItem(int position) {
        return functionDOList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Hodler hodler = null;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.manager_main_fragment_item, null);
            hodler = new Hodler(convertView);
            convertView.setTag(hodler);
        } else {
            hodler = (Hodler) convertView.getTag();
        }
        FunctionDO functionDO = getItem(position);
        if (functionDO != null) {
            hodler.tvName.setText(functionDO.getName());
        }
        return convertView;
    }

    public class Hodler {
        View view;
        TextView tvName;

        public Hodler(View view) {
            this.view = view;
            this.tvName = (TextView) view.findViewById(R.id.tvName);
        }
    }
}
