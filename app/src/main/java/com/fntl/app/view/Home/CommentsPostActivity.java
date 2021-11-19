package com.fntl.app.view.Home;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fntl.app.Adapter.AdapterCommentPost;
import com.fntl.app.R;
import com.fntl.app.databinding.ActivityCommentsPostBinding;
import com.fntl.app.model.Message;
import com.fntl.app.utils.Tools;

public class CommentsPostActivity extends AppCompatActivity {

    ActivityCommentsPostBinding binding;
    private ImageView btn_send;
    private EditText et_content;
    private AdapterCommentPost adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_comments_post);
        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.funtical_action_bar);


       // iniComponent();
    }

    public void iniComponent() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setHasFixedSize(true);

        adapter = new AdapterCommentPost(this);
        binding.recyclerView.setAdapter(adapter);

      //  adapter.insertItem(new Message(adapter.getItemCount(), getString(R.string.lorm), false, adapter.getItemCount() % 5 == 0, Tools.getFormattedTimeEvent(System.currentTimeMillis())));
      //  adapter.insertItem(new Message(adapter.getItemCount(), "Hello!", true, adapter.getItemCount() % 5 == 0, Tools.getFormattedTimeEvent(System.currentTimeMillis())));

        btn_send = binding.btnSend;
        et_content = binding.textContent;
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendChat();
            }
        });
        // et_content.addTextChangedListener(contentWatcher);


    }

    private void sendChat() {
        final String msg = et_content.getText().toString();
        if (msg.isEmpty()) return;
        adapter.insertItem(new Message(adapter.getItemCount(), msg, false, adapter.getItemCount() % 5 == 0, Tools.getFormattedTimeEvent(System.currentTimeMillis())));
        et_content.setText("");
        binding.recyclerView.scrollToPosition(adapter.getItemCount() - 1);
      /*  new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.insertItem(new Message(adapter.getItemCount(), msg, false, adapter.getItemCount() % 5 == 0, Tools.getFormattedTimeEvent(System.currentTimeMillis())));
                recycler_view.scrollToPosition(adapter.getItemCount() - 1);
            }
        }, 1000);*/
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

   /* private TextWatcher contentWatcher = new TextWatcher() {
        @Override
        public void afterTextChanged(Editable etd) {
            if (etd.toString().trim().length() == 0) {
                btn_send.setImageResource(R.drawable.ic_mic);
            } else {
                btn_send.setImageResource(R.drawable.ic_send);
            }
        }

        @Override
        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
        }

        @Override
        public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
        }
    };*/
}