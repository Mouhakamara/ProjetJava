package model;

import java.util.ArrayList;
import java.util.List;

public class Etudiant extends Personne {

    private String matricule;
    private List<Note> notes;
    private double moyenneGenerale;
    private int rang;
    private int effectifClasse;

    public Etudiant(String nom, String prenom, String email,
                    String telephone, String matricule) {
        super(nom, prenom, email, telephone);
        this.matricule = matricule;
        this.notes = new ArrayList<>();
    }

    public void ajouterNote(Note note) {
        notes.add(note);
    }

    public void setEffectifClasse(int effectifClasse) {
        this.effectifClasse = effectifClasse;
    }

    public double calculerMoyenneGenerale() {
        double somme = 0;
        int totalCoef = 0;

        for (Note n : notes) {
            somme += n.calculerMoyenneMatiere() * n.getMatiere().getCoefficient();
            totalCoef += n.getMatiere().getCoefficient();
        }

        if (totalCoef == 0) return 0;

        moyenneGenerale = somme / totalCoef;
        return moyenneGenerale;
    }

    public String getMention() {
        if (moyenneGenerale >= 16) return "Tres Bien";
        if (moyenneGenerale >= 14) return "Bien";
        if (moyenneGenerale >= 12) return "Assez Bien";
        if (moyenneGenerale >= 10) return "Passable";
        return "Ajourne";
    }

    public int getTotalCoefficients() {
        int total = 0;

        for (Note note : notes) {
            total += note.getMatiere().getCoefficient();
        }

        return total;
    }

    public List<Note> getNotes() { return notes; }
    public double getMoyenneGenerale() { return moyenneGenerale; }
    public String getMatricule() { return matricule; }

    public int getRang() { return rang; }
    public void setRang(int rang) { this.rang = rang; }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("====================================================\n");
        sb.append("                    BULLETIN\n");
        sb.append("====================================================\n\n");

        sb.append("Informations etudiant\n");
        sb.append("---------------------------------\n");
        sb.append("Nom : ").append(getNom()).append("\n");
        sb.append("Prenom : ").append(getPrenom()).append("\n");
        sb.append("Matricule : ").append(matricule).append("\n");
        sb.append("Email : ").append(getEmail()).append("\n");
        sb.append("Telephone : ").append(getTelephone()).append("\n\n");

        sb.append("Resultats par matiere\n");
        sb.append("--------------------------------------------------------------\n");
        sb.append(String.format("%-15s %-8s %-8s %-8s %-5s\n",
                "Matiere", "Devoir", "Examen", "Moyenne", "Coef"));

        for (Note n : notes) {
            sb.append(String.format("%-15s %-8.2f %-8.2f %-8.2f %-5d\n",
                    n.getMatiere().getNom(),
                    n.getDevoir(),
                    n.getExamen(),
                    n.calculerMoyenneMatiere(),
                    n.getMatiere().getCoefficient()));
        }

        sb.append("--------------------------------------------------------------\n\n");

        sb.append("Synthese\n");
        sb.append("---------------------------------\n");
        sb.append("Total Coefficients : ").append(getTotalCoefficients()).append("\n");
        sb.append("Moyenne Generale : ")
                .append(String.format("%.2f", moyenneGenerale))
                .append("\n");
        sb.append("Mention : ").append(getMention()).append("\n");
        sb.append("Rang : ").append(rang)
                .append("/").append(effectifClasse).append("\n");

        sb.append("====================================================\n");

        return sb.toString();
    }
}
