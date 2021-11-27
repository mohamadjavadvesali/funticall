package com.fntl.app.view.Sign_up_in;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

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
                String fullName = binding.fullName.getText().toString();
                String email = binding.email.getText().toString();
                String mobileNumber = binding.mobileNumber.getText().toString();
                String description = binding.description.getText().toString();
                String companyName = binding.companyName.getText().toString();
                String address = binding.address.getText().toString();

                Log.i(TAG, "onClick: " + fullName);
                viewModel.post_register(fullName, email, mobileNumber, check_btn, description
                        , companyName, address).observe(getViewLifecycleOwner(), new Observer<Response_Model>() {
                    @Override
                    public void onChanged(Response_Model response_model) {
                        if (response_model.getErrors() == null) {
                            Toast.makeText(getActivity(), "" + response_model.getMessage(), Toast.LENGTH_SHORT).show();

                        } else {
                            for (int i = 0; i < response_model.getErrors().size(); i++) {
                                Toast.makeText(getActivity(), "" + response_model.getErrors().get(i).getErrorMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
            }
        });
    }
}