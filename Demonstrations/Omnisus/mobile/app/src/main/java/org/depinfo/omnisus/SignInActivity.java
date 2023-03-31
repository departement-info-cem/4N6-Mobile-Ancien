package org.depinfo.omnisus;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import org.depinfo.omnisus.databinding.ActivitySigninBinding;
import org.depinfo.omnisus.http.RetrofitUtil;
import org.depinfo.omnisus.http.Service;
import org.depinfo.omnisus.http.dto.SigninRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInActivity extends AppCompatActivity {

    private ActivitySigninBinding binding;
    private Service service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySigninBinding.inflate(getLayoutInflater());
        service = RetrofitUtil.get();
        setContentView(binding.getRoot());

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        onSignInClick();
    }

    private void onSignInClick() {
        binding.btnConnect.setOnClickListener(v -> {
            SigninRequest request = new SigninRequest();
            request.username = binding.etUsername.getText().toString();
            request.password = binding.etPassword.getText().toString();
            requestSignIn(request);
        });
    }

    private void requestSignIn(SigninRequest request) {
        service.signIn(request).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    Intent gradeIntent = new Intent(SignInActivity.this, GradeActivity.class);
                    startActivity(gradeIntent);
                } else {
                    Toast.makeText(SignInActivity.this, getBaseContext().getText(R.string.error_wrong_username_pass), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(SignInActivity.this, R.string.error_com, Toast.LENGTH_SHORT).show();
            }
        });
    }
}