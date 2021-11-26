package com.fntl.app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.fntl.app.R;
import com.fntl.app.model.PostModel;

import java.util.ArrayList;
import java.util.List;

public class AdapterCommentPost extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int CHAT_ME = 100;
    private final int CHAT_YOU = 200;
    private final Context ctx;
    private List<PostModel> items = new ArrayList<>();
    private OnItemClickListener mOnItemClickListener;

    // Provide a suitable constructor (depends on the kind of dataset)


    public AdapterCommentPost(Context ctx, List<PostModel> items) {
        this.ctx = ctx;
        this.items = items;
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment_post, parent, false);
        vh = new ItemViewHolder(v);

        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            PostModel m = items.get(position);
            ItemViewHolder vItem = (ItemViewHolder) holder;
          //  vItem.text_content.setText(m.getData().get(position).getChildren().get(0).getContent());
           // vItem.text_time.setText(m.get().get(position).getChildren().get(0).getCreatedDate());
            vItem.lyt_parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(view, m, position);
                    }
                }
            });
        }
    }

    // Return the size of your data set (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public void insertItem(PostModel item) {
        this.items.add(item);
        notifyItemInserted(getItemCount());
    }

    public void setItems(List<PostModel> items) {
        this.items = items;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, PostModel obj, int position);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView text_content;
        public TextView text_time;
        public View lyt_parent;

        public ItemViewHolder(View v) {
            super(v);
            text_content = v.findViewById(R.id.text_content);
            text_time = v.findViewById(R.id.text_time);
            lyt_parent = v.findViewById(R.id.lyt_parent);
        }
    }
}