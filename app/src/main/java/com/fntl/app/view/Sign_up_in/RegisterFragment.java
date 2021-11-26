package com.fntl.app.view.Sign_up_in;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

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
    RadioButton genderradioButton;
    RadioGroup radioGroup;
    Button button;
    Integer check_btn;
    MainActivityViewModel viewModel;

    public RegisterFragment() {

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false);
        button = binding.reg;
        genderradioButton = binding.selectedId;
        radioGroup = binding.group;
        viewModel = new ViewModelProvider(getActivity()).get(MainActivityViewModel.class);

        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (genderradioButton.isChecked()) {
                    check_btn = 1;
                } else {
                    check_btn = 2;

                }
                viewModel.post_register(String.valueOf(binding.fullName), String.valueOf(binding.email),
                        String.valueOf(binding.mobileNumber), check_btn, String.valueOf(binding.description)
                        , String.valueOf(binding.companyName), String.valueOf(binding.address)

                ).observe(getViewLifecycleOwner(), new Observer<Response_Model>() {
                    @Override
                    public void onChanged(Response_Model response_model) {
                        Log.i(TAG, "onChanged: "+response_model);
                    }



                });

            }
        });
    }
}