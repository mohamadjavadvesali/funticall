package com.fntl.app.view.Home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fntl.app.Adapter.PostListAdapter;
import com.fntl.app.R;
import com.fntl.app.databinding.FragmentHomeBinding;
import com.fntl.app.model.PostModel;
import com.fntl.app.utils.App;
import com.fntl.app.viewmodel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private static final String TAG = "HomeFragment";
    Context thiscontext;
    private FragmentHomeBinding binding;
    private PostListAdapter adapter;
    private List<PostModel> allPost = new ArrayList<>();
    private int sizeOfList = 0, page = 1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        MainActivityViewModel viewModel = new ViewModelProvider(getActivity()).get(MainActivityViewModel.class);
        adapter = new PostListAdapter(App.context);

        binding.homeFragmentPosts.setLayoutManager(new LinearLayoutManager(getActivity()));

        binding.homeFragmentPosts.setAdapter(adapter);


        viewModel.getPosts(page).observe(getViewLifecycleOwner(), new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                sizeOfList = postModels.size();
                allPost = postModels;
                adapter.setPostModels(postModels);
            }
        });

        binding.homeFragmentPosts.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

                if (linearLayoutManager != null && linearLayoutManager.findLastVisibleItemPosition() == sizeOfList - 1) {
                    loadMore();
                }
            }

            private void loadMore() {
                page++;
                viewModel.getPosts(page).observe(getViewLifecycleOwner(), new Observer<List<PostModel>>() {
                    @Override
                    public void onChanged(List<PostModel> postModels) {
                        sizeOfList = sizeOfList + postModels.size();
                        allPost.addAll(postModels);
                        adapter.notifyItemInserted(allPost.size() - 1);
                    }
                });
            }
        });


        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
