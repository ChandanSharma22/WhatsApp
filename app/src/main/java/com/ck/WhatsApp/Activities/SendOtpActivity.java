package com.ck.WhatsApp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ck.WhatsApp.databinding.ActivitySendOtpBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthProvider;

public class SendOtpActivity extends AppCompatActivity {

    private ActivitySendOtpBinding binding;
    private FirebaseAuth auth;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySendOtpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        auth = FirebaseAuth.getInstance();
        if(auth.getCurrentUser() != null){
            Intent intent = new Intent(SendOtpActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        getSupportActionBar().hide();



        binding.continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SendOtpActivity.this,OtpVerifyActivity.class);
                intent.putExtra("phoneNumber",binding.phoneBox.getText().toString());
                startActivity(intent);

            }
        });


    }
}


       /* binding.btnGetOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.etPhone.getText().toString().trim().isEmpty()){
                    Toast.makeText(SendOtpActivity.this, "Invalid phone Number", Toast.LENGTH_SHORT).show();

                }else if(binding.etPhone.getText().toString().trim().length()!=10 ){
                    Toast.makeText(SendOtpActivity.this, "Type valid phone Number", Toast.LENGTH_SHORT).show();
                }else {
                    otpSend();

                }
            }

        });

    }

    private void otpSend() {

        binding.progressBar.setVisibility(View.VISIBLE);
        binding.progressBar.setVisibility(View.INVISIBLE);

        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential credential) {


            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
              binding.progressBar.setVisibility(View.GONE);
              binding.btnGetOtp.setVisibility(View.VISIBLE);
                Toast.makeText(SendOtpActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCodeSent(@NonNull String verificationId,
                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {

               binding.progressBar.setVisibility(View.GONE);
               binding.btnGetOtp.setVisibility(View.VISIBLE);
                Intent intent = new Intent(SendOtpActivity.this,OtpVerifyActivity.class);
                startActivity(intent);
                intent.putExtra("phone",binding.etPhone.getText().toString().trim());
                intent.putExtra("verificationId",verificationId);

            }
        };

        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber("+91"+ binding.etPhone.getText().toString().trim())       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // (optional) Activity for callback binding
                        // If no activity is passed, reCAPTCHA verification can not be used.
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }
}*/