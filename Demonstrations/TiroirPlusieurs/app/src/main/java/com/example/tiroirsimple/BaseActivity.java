package com.example.tiroirsimple;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.tiroirsimple.databinding.ActivityBaseBinding;
import com.example.tiroirsimple.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

public class BaseActivity extends AppCompatActivity {
    String currentActivity; // Évite la double ouverture d'une activité
    ActivityBaseBinding bindingBase;
    @Override
    public void setContentView(View view) {
        // TODO Comment on fait pour associer un binding à MainActivity qui accède aussi au binding de BaseActivity?
        bindingBase = ActivityBaseBinding.inflate(getLayoutInflater());
        bindingBase.frameLayoutID.addView (view);
        super.setContentView(bindingBase.drawerLayoutID);
        bindingBase.navigationViewID.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent i;
                switch (item.getItemId()){
                    case (R.id.menuMain):
                        if (!currentActivity.equals("Main")){
                            i = new Intent(BaseActivity.this, MainActivity.class);
                            startActivity(i);
                        }
                        break;

                    case (R.id.menuAutre):
                        if (!currentActivity.equals("Autre")) {
                            i = new Intent(BaseActivity.this, AutreActivity.class);
                            startActivity(i);
                            break;
                        }
                }
                return false;
            }
        });
    }

    /* Sans binding */
    /*    @Override
          public void setContentView(View view) {
                DrawerLayout drawerLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_base, null);
                FrameLayout container = drawerLayout.findViewById(R.id.main_container);
                container.addView (view);
                super.setContentView(drawerLayout);
                [...]
          }*/
}