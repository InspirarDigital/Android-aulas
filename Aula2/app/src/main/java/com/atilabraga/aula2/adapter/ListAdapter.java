package com.atilabraga.aula2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.atilabraga.aula2.R;

/**
 * Created by atilabraga on 9/26/15.
 */
public class ListAdapter extends RecyclerView.Adapter {

    private String[] mArray;
    private Context mContext;

    public ListAdapter(Context context, String[] array) {
        this.mArray = array;
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            RecyclerView.ViewHolder holder, int position) {
        ViewHolder mHolder = (ViewHolder) holder;
        mHolder.bind(mArray[position]);
    }

    @Override
    public int getItemCount() {
        return mArray.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvText;

        public ViewHolder(View itemView) {
            super(itemView);
            tvText = (TextView) itemView.findViewById(
                    R.id.item_text);
        }

        public void bind(String item) {
            tvText.setText(item);
        }
    }

}
