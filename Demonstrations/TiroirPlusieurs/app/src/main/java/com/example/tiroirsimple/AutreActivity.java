package com.example.tiroirsimple;
import android.os.Bundle;
import com.example.tiroirsimple.databinding.ActivityAutreBinding;

// TODO On extends BaseActivity plutôt que AppCompatActivity
public class AutreActivity extends BaseActivity {
    ActivityAutreBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Tout le code ci-dessous est normal
        super.onCreate(savedInstanceState);
        binding = ActivityAutreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("Autre");
        currentActivity = "Autre";
    }
}