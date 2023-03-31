package org.depinfo.omnisus;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import org.depinfo.omnisus.databinding.ActivityGradeBinding;
import org.depinfo.omnisus.http.RetrofitUtil;
import org.depinfo.omnisus.http.Service;
import org.depinfo.omnisus.http.dto.UserDetailsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GradeActivity extends AppCompatActivity {
    private ActivityGradeBinding binding;
    private Service service;
    private GradeAdapter gradeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGradeBinding.inflate(getLayoutInflater());
        service = RetrofitUtil.get();
        setContentView(binding.getRoot());

        initRecycler();
        onEditIntentClick();
        requestGrades();
    }

    private void onEditIntentClick() {
        binding.btnEditUser.setOnClickListener(v -> {
            Intent editIntent = new Intent(GradeActivity.this, EditUserActivity.class);
            editIntent.putExtra("PUBLIC_NAME", binding.tvUsername.getText().toString());
            startActivity(editIntent);
        });
    }

    private void requestGrades() {
        service.getGrade().enqueue(new Callback<UserDetailsResponse>() {
            @Override
            public void onResponse(Call<UserDetailsResponse> call, Response<UserDetailsResponse> response) {
                if (response.isSuccessful()) {
                    prepareUI(response.body());
                } else {
                    Toast.makeText(GradeActivity.this, R.string.error_unexpected, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserDetailsResponse> call, Throwable t) {
                Toast.makeText(GradeActivity.this, R.string.error_com, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void prepareUI(UserDetailsResponse response) {
        binding.tvUsername.setText(response.publicName);
        gradeAdapter.list.addAll(response.grades);
        gradeAdapter.notifyDataSetChanged();
//        gradeAdapter.notifyItemRangeInserted(0, response.grades.size());
    }

    private void initRecycler() {
        binding.rvGrades.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.rvGrades.setLayoutManager(layoutManager);
        gradeAdapter = new GradeAdapter();
        binding.rvGrades.setAdapter(gradeAdapter);
    }
}
