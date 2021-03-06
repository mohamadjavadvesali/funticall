package com.fntl.app.view.Sign_up_in;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.fntl.app.R;
import com.fntl.app.databinding.FragmentVerificationPhoneBinding;
import com.fntl.app.model.Response_Model;
import com.fntl.app.utils.App;
import com.fntl.app.view.MainActivity;
import com.fntl.app.viewmodel.MainActivityViewModel;
import com.google.android.material.textfield.TextInputEditText;


public class VerificationPhoneFragment extends Fragment {
    String TAG = "VerificationPhoneFragment";
    FragmentVerificationPhoneBinding binding;
    AppCompatButton sendNumberPhone, cancel_verificate;
    MainActivityViewModel viewModel;
    TextInputEditText mobilenumber;

    public VerificationPhoneFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_verification_phone, container, false);


        viewModel = new ViewModelProvider(getActivity()).get(MainActivityViewModel.class);
        sendNumberPhone = binding.sendNumberPhone;
        cancel_verificate = binding.cancelVerificate;
        mobilenumber = binding.numberPhone;
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cancel_verificate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();

            }
        });

        sendNumberPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.get_Users(mobilenumber.getText().toString()).observe(getViewLifecycleOwner(), new Observer<Response_Model>() {
                    @Override
                    public void onChanged(Response_Model response_model) {
                        if (response_model.getErrors() == null) {
                            Bundle bundle = new Bundle();
                            bundle.putString("mobile_number", mobilenumber.getText().toString());
                            Navigation.findNavController(sendNumberPhone).navigate(R.id.action_verificationPhoneFragment_to_verificationCodeFragment, bundle);

                        } else {
                            Toast.makeText(App.context, "" + response_model.getErrors().get(0).getErrorMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

    }
}