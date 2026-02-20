package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import service.ClassementComparator;

public class Classe {

    private String nom;
    private List<Etudiant> etudiants;
    private List<Matiere> matieres;

    public Classe(String nom) {
        this.nom = nom;
        this.etudiants = new ArrayList<>();
        this.matieres = new ArrayList<>();
    }

    public void ajouterEtudiant(Etudiant e) {
        etudiants.add(e);
    }

    public void ajouterMatiere(Matiere m) {
        matieres.add(m);
    }

    public void calculerMoyennes() {
        for (Etudiant e : etudiants) {
            e.calculerMoyenneGenerale();
        }
    }

    public void classerEtudiants() {
        Collections.sort(etudiants, new ClassementComparator());

        int rang = 1;
        for (int i = 0; i < etudiants.size(); i++) {
            if (i > 0 &&
                    etudiants.get(i).getMoyenneGenerale() ==
                            etudiants.get(i - 1).getMoyenneGenerale()) {

                etudiants.get(i).setRang(etudiants.get(i - 1).getRang());
            } else {
                etudiants.get(i).setRang(rang);
            }
            rang++;
            int effectif = etudiants.size();
            for (Etudiant e : etudiants) {
                e.setEffectifClasse(effectif);
            }
        }
        }


    public List<Etudiant> getEtudiants() { return etudiants; }
    public List<Matiere> getMatieres() { return matieres; }
    public String getNom() { return nom; }
}
