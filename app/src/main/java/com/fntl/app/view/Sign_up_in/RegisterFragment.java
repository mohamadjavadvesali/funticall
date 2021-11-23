package com.fntl.app.view.Sign_up_in;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.fntl.app.R;
import com.fntl.app.databinding.FragmentRegisterBinding;
import com.fntl.app.model.Response_Model;
import com.fntl.app.viewmodel.MainActivityViewModel;

public class RegisterFragment extends Fragment {
    private static final String TAG = "RegisterFragment";
    FragmentRegisterBinding binding;
    Button button;

    public RegisterFragment() {

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false);
        button = binding.reg;

        return binding.getRoot();

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainActivityViewModel viewModel = new ViewModelProvider(getActivity()).get(MainActivityViewModel.class);
  /*      button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.post_register(1).observe(getViewLifecycleOwner(), new Observer<Response_Model>() {
                    @Override
                    public void onChanged(Response_Model response_model) {
                        if (response_model.getMessage().equals(getResources().getString(R.string.okay))) {
                            Log.i(TAG, "onChanged: " + getString(R.string.okay));

                        } else if (response_model.getErrors().equals(getResources().getString(R.string.nameejabr))) {
                            Log.i(TAG, "onChanged: " + getString(R.string.nameejabr));

                        } else if (response_model.getErrors().equals(getResources().getString(R.string.beyn2_100))) {
                            Log.i(TAG, "onChanged: " + getString(R.string.beyn2_100));

                        } else if (response_model.getErrors().equals(getResources().getString(R.string.mobileedi))) {
                            Log.i(TAG, "onChanged: " + getString(R.string.mobileedi));

                        } else if (response_model.getErrors().equals(getResources().getString(R.string.emailedi))) {
                            Log.i(TAG, "onChanged: " + getString(R.string.emailedi));
                        }
                    }
                });

            }
        });*/
    }
}