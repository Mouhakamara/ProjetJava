package model;

public class Note {

    private Matiere matiere;
    private double devoir;
    private double examen;

    public Note(Matiere matiere, double devoir, double examen) {
        if (!validerNote(devoir) || !validerNote(examen))
            throw new IllegalArgumentException("Les notes doivent être entre 0 et 20.");

        this.matiere = matiere;
        this.devoir = devoir;
        this.examen = examen;
    }

    private boolean validerNote(double note) {
        return note >= 0 && note <= 20;
    }

    public double calculerMoyenneMatiere() {
        return (examen * 2 + devoir) / 3;
    }

    public Matiere getMatiere() { return matiere; }
    public double getDevoir() { return devoir; }
    public double getExamen() { return examen; }
}
