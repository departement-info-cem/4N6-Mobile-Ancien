package org.deguet.erreurs;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

import org.deguet.erreurs.databinding.ActivityMainBinding;

// TODO snackbar with retry button
// TODO is action to retry is obvious > no need

// TODO ajouter un dialog pour

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        // Messages d'erreur localisés sur un champ
        // validation d'un champ, explication d'un format etc.
        binding.envoyer1.setOnClickListener(view -> { showMessageSurChamp();});
        binding.envoyer2.setOnClickListener(view -> { showASnackBar();});

        // Messages d'erreur qui ne correspondent pas à un endroit particulier
        // erreur d'accès réseau ou serveur, pas les autorisations etc.
        binding.envoyer3.setOnClickListener(view -> { showADialog();});
        binding.fab.setOnClickListener(view -> { showASnack2();});



    }

    private void showASnack2() {
        Snackbar snacky = Snackbar.make(binding.coordinator,
                R.string.no_network, Snackbar.LENGTH_LONG);
        snacky.setAction(R.string.retry, view1 -> {
            Toast.makeText(this, "Retrying", Toast.LENGTH_SHORT).show();
        });
        snacky.show();
    }

    private void showADialog() {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);
        builder.setTitle(R.string.no_network);
        builder.setPositiveButton(R.string.ok, (dialogInterface, i) -> {
            dialogInterface.dismiss();
        });
        builder.setNeutralButton(R.string.retry, (dialogInterface, i) -> {
            Toast.makeText(this, "Retrying", Toast.LENGTH_SHORT).show();
            dialogInterface.dismiss();
        });
        builder.show();
    }

    private void showASnackBar(){
        // On peut combiner le fait de marquer un message d'erreur avec le surlignage
        // des erreurs dans le formulaire
        binding.textInputLayout.setError(getString(R.string.error_example));

        // On peut mettre une action qui nous amène à l'erreur
        Snackbar snacky = Snackbar.make(binding.coordinator,
                R.string.snack_message, Snackbar.LENGTH_LONG);
        snacky.setAction(R.string.go_there, view1 -> {
            binding.textInputLayout.requestFocus();
        });
        snacky.show();
    }

    private void showMessageSurChamp(){
        // si le message d'erreur sur un champ texte est en dehors de la zone
        // visible, il faut demander le focus pour obliger le scroll à y aller
        binding.password.setError(getString(R.string.error_password));
        binding.password.requestFocus();
        
    }
}