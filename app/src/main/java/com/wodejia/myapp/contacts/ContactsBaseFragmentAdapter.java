package com.wodejia.myapp.contacts;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.clarence.utillibrary.CommonUtils;
import com.example.clarence.utillibrary.LogUtils;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;
import com.wodejia.myapp.R;
import com.wodejia.myapp.data.ContactsBaseDO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by clarence on 16/8/30.
 */
public abstract class ContactsBaseFragmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements StickyRecyclerHeadersAdapter<RecyclerView.ViewHolder> {
    public List<ContactsBaseDO> items = new ArrayList<>();

    public ContactsBaseFragmentAdapter() {
        setHasStableIds(true);
    }

    @Override
    public long getHeaderId(int position) {
        return getFirstLetter(position).hashCode();
    }

    @Override
    public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_fragment_head_item, parent, false);
        return new HolderHeader(view);
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, final int position) {
        HolderHeader holderHeader = (HolderHeader) holder;
        holderHeader.tvTitle.setText(String.valueOf(getFirstLetter(position)));
        holderHeader.tvTitle.setBackgroundColor(CommonUtils.getRandomColor());
    }

    @Override
    public long getItemId(int position) {
        return getFirstLetter(position).hashCode();
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    public String getFirstLetter(int position) {
        return items.get(position).getFirstLetter();
    }

    public void addAll(Collection<? extends ContactsBaseDO> collection) {
        if (collection != null) {
            items.addAll(collection);
            notifyDataSetChanged();
        }
    }

    public class HolderHeader extends RecyclerView.ViewHolder {
        public TextView tvTitle;

        public HolderHeader(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
        }
    }
}
