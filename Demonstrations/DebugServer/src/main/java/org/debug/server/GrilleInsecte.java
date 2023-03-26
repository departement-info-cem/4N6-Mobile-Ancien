package org.debug.server;

import java.util.Random;

public class GrilleInsecte {

    String[][][] grille3d = new String[10][10][10];

    /**
     * Remplis la grille en 3 dimensions (comme un cube), et y insère un insecte à une position aléatoire.
     */
    public void creerGrille() {
        // Interdit de mettre un point de debug ici >:(
        // Interdit de modifier le code >:(
        Random r = new Random();
        int x = r.nextInt(9);
        int y = r.nextInt(9);
        int z = r.nextInt(9);
        for (int i = 0; i < grille3d.length; i++) {
            for (int j = 0; j < grille3d[0].length; j++) {
                for (int k = 0; k < grille3d[0][0].length; k++) {
                    if (i == x && j == y && k == z) {
                        grille3d[i][j][k] = "INSECTE";
                    } else {
                        grille3d[i][j][k] = "";
                    }
                }

            }
        }
    }

    /**
     * Transforme la grille 3d en une grille 1d.
     * TODO 1 Trouver pourquoi le code crash
     * TODO 2 Trouver l'adresse de l'insecte sans modifier le code
     */
    public String[] tranformerGrille1D() {
        // Interdit de modifier le code >:(
        // Vous pouvez mettre des breakpoints :)
        String[] grille1d = new String[999];
        for (int i = 0; i < grille3d.length; i++) {
            for (int j = 0; j < grille3d[0].length; j++) {
                for (int k = 0; k < grille3d[0][0].length; k++) {
                    grille1d[(k * grille3d.length * grille3d[0].length) + (j * grille3d.length) + i] = grille3d[i][j][k];
                }
            }
        }
        return grille1d;
    }
}
