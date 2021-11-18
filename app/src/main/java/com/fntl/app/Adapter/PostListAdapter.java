package com.fntl.app.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.fntl.app.R;
import com.fntl.app.databinding.PostItemLayoutBinding;
import com.fntl.app.model.PostModel;
import com.fntl.app.view.Home.CommentsPostActivity;

import java.util.ArrayList;
import java.util.List;

public class PostListAdapter extends RecyclerView.Adapter<PostListAdapter.Holder> {
    private final Context context;
    boolean like = true;
    private List<PostModel> postModels = new ArrayList<>();


    public PostListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PostItemLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.post_item_layout, parent, false);
        return new Holder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        PostModel postModel = postModels.get(position);
        holder.binding.setModel(postModel);
        holder.post_like_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (like) {
                    Toast.makeText(view.getContext(), "like", Toast.LENGTH_SHORT).show();
                    like = false;
                    holder.post_like.setImageDrawable(view.getContext().getResources().getDrawable(R.drawable.ic_favorites));
                } else {
                    holder.post_like.setImageDrawable(view.getContext().getResources().getDrawable(R.drawable.ic_favorite_border));
                    Toast.makeText(view.getContext(), "dislike", Toast.LENGTH_SHORT).show();
                    like = true;

                }


            }
        });
        holder.comment_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), CommentsPostActivity.class);
                view.getContext().startActivity(intent);

            }
        });
        holder.post_Share_Linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent();
                intent2.setAction(Intent.ACTION_SEND);
                intent2.setType("text/plain");
                intent2.putExtra(Intent.EXTRA_TEXT, postModel.getFullName() + "\n" + postModel.getCreatedDate() + "\n" + postModel.getContent());
                view.getContext().startActivity(Intent.createChooser(intent2, "اشتراک گذازی با"));
            }
        });

    }

    @Override
    public int getItemCount() {
        return postModels.size();
    }

    public void setPostModels(List<PostModel> postModels) {
        this.postModels = postModels;
        notifyDataSetChanged();
    }

    class Holder extends RecyclerView.ViewHolder {
        PostItemLayoutBinding binding;
        ImageView post_like;
        LinearLayout comment_linear, post_like_linear, post_Share_Linear;

        public Holder(@NonNull PostItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            post_like = binding.postLike;
            comment_linear = binding.commentLinear;
            post_like_linear = binding.postLikeLinear;
            post_Share_Linear = binding.postShareLinear;

        }
    }
}
