package com.fntl.app.view.Home;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fntl.app.Adapter.AdapterCommentPost;
import com.fntl.app.R;
import com.fntl.app.databinding.ActivityCommentsPostBinding;
import com.fntl.app.model.Comment;
import com.fntl.app.model.Message;
import com.fntl.app.utils.Tools;
import com.fntl.app.viewmodel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class CommentsPostActivity extends AppCompatActivity {

    ActivityCommentsPostBinding binding;
    private EditText et_content;
    private AdapterCommentPost adapter;
    private RecyclerView recycler_view;
    private List<Comment> allPost = new ArrayList<>();
    private int sizeOfList = 0, page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_comments_post);
        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.funtical_action_bar);
        iniComponent();
    }

    public void iniComponent() {
        MainActivityViewModel viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        recycler_view = binding.recyclerView;
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recycler_view.setLayoutManager(layoutManager);
        recycler_view.setHasFixedSize(true);


        adapter = new AdapterCommentPost(getApplicationContext());
        recycler_view.setAdapter(adapter);
        adapter.insertItem(new Message(adapter.getItemCount(), getString(R.string.lorm), false, adapter.getItemCount() % 5 == 0, Tools.getFormattedTimeEvent(System.currentTimeMillis())));
        adapter.insertItem(new Message(adapter.getItemCount(), "Hello!", true, adapter.getItemCount() % 5 == 0, Tools.getFormattedTimeEvent(System.currentTimeMillis())));


        binding.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendChat();
            }
        });


    }

    private void sendChat() {
        final String msg = et_content.getText().toString();
        if (msg.isEmpty()) return;
        adapter.insertItem(new Message(adapter.getItemCount(), msg, false, adapter.getItemCount() % 5 == 0, Tools.getFormattedTimeEvent(System.currentTimeMillis())));
        et_content.setText("");
        recycler_view.scrollToPosition(adapter.getItemCount() - 1);
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        hideKeyboard();
    }

    private void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}