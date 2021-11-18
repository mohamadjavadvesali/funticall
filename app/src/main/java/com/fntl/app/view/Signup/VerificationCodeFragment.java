package com.fntl.app.view.Signup;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.fntl.app.R;
import com.fntl.app.databinding.FragmentVerificationCodeBinding;
import com.fntl.app.model.Token;
import com.fntl.app.viewmodel.MainActivityViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class VerificationCodeFragment extends Fragment {
    String TAG = "repository_Log";
    FragmentVerificationCodeBinding binding;
    MainActivityViewModel viewModel;
    TextInputEditText editText;
    Button button;

    public VerificationCodeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_verification_code, container, false);

        viewModel = new ViewModelProvider(getActivity()).get(MainActivityViewModel.class);
        editText = binding.verifactecode;
        button = binding.verifaction;
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String phonenumber = getArguments().getString("mobile_number");
        binding.phoneCode.setText("کد چهار رقمی ارسال شده به شماره " + phonenumber+ " را وارد کنید.");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                viewModel.get_verification(phonenumber, editText.getText().toString(), 1, "0.0.1", "string").observe(getViewLifecycleOwner(), new Observer<Token>() {
                    @Override
                    public void onChanged(Token token) {
                        Log.i(TAG, "onChanged:  "+token.getMessage() + token.getData().getToken() + token.getErrors() );
                        Toast.makeText(getActivity(),"عملیات با موفقیت انجام شد..." , Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
        binding.editNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view)
                        .navigate(R.id.action_verificationCodeFragment_to_verificationPhoneFragment)
                ;
            }
        });
    }
}