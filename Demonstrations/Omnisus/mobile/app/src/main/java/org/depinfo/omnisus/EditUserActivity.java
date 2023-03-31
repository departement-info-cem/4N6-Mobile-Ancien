package org.depinfo.omnisus;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.depinfo.omnisus.databinding.ActivityEditUserBinding;
import org.depinfo.omnisus.http.RetrofitUtil;
import org.depinfo.omnisus.http.Service;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditUserActivity extends AppCompatActivity {
    private ActivityEditUserBinding binding;
    private Service service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditUserBinding.inflate(getLayoutInflater());
        service = RetrofitUtil.get();
        setContentView(binding.getRoot());

        prepareUI();
        onEditUserClick();
    }

    private void prepareUI() {
        String publicUsername = getIntent().getStringExtra("PUBLIC_NAME");
        binding.tvUsername.setText(publicUsername);
        binding.editTextTextPersonName.setText(publicUsername);
    }

    private void onEditUserClick() {
        binding.btnEditUser.setOnClickListener(v -> {
            String newPublicUsername = binding.editTextTextPersonName.getText().toString();
            service.editUser(newPublicUsername).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(EditUserActivity.this, getBaseContext().getText(R.string.txt_new_name), Toast.LENGTH_SHORT).show();
                        Intent gradeActivityIntent = new Intent(getBaseContext(), GradeActivity.class);
                        startActivity(gradeActivityIntent);
                    } else {
                        Toast.makeText(EditUserActivity.this, getBaseContext().getText(R.string.error_unexpected), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Toast.makeText(EditUserActivity.this, R.string.error_com, Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}
