package com.example.tiroirsimple;
import android.os.Bundle;
import com.example.tiroirsimple.databinding.ActivityMainBinding;

// TODO On extends BaseActivity plutôt que AppCompatActivity
public class MainActivity extends BaseActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO Comment on fait pour associer un binding à MainActivity qui accède aussi au binding de BaseActivity?
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("Main");
        currentActivity = "Main";
    }

}