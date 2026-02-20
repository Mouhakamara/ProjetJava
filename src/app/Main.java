package app;

import model.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=========================================");
        System.out.println("      APPLICATION DE GESTION DES NOTES");
        System.out.println("           L3 RESEAU INFORMATIQUE");
        System.out.println("=========================================\n");

        Classe classe = new Classe("L3 Reseau Informatique");

        // Création des matières
        Matiere math = new Matiere("Mathematiques", 3);
        Matiere algo = new Matiere("Algorithmique", 2);
        Matiere reseaux = new Matiere("Reseaux", 4);
        Matiere bdd = new Matiere("Base de donnees", 2);

        classe.ajouterMatiere(math);
        classe.ajouterMatiere(algo);
        classe.ajouterMatiere(reseaux);
        classe.ajouterMatiere(bdd);

        System.out.println("Veuillez saisir le nombre d'etudiants :");
        int nombreEtudiants = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= nombreEtudiants; i++) {

            System.out.println("\n-------------------------------------------------");
            System.out.println("                SAISIE ETUDIANT " + i);
            System.out.println("-------------------------------------------------");

            System.out.print("Nom : ");
            String nom = scanner.nextLine();

            System.out.print("Prenom : ");
            String prenom = scanner.nextLine();

            System.out.print("Email : ");
            String email = scanner.nextLine();

            System.out.print("Telephone : ");
            String tel = scanner.nextLine();

            System.out.print("Matricule : ");
            String matricule = scanner.nextLine();

            Etudiant etudiant = new Etudiant(nom, prenom, email, tel, matricule);

            System.out.println("\n===== SAISIE DES NOTES =====");

            // Math
            System.out.println("\nMathematiques (Coef 3)");
            System.out.print("Note devoir : ");
            double devoirMath = saisirNoteValide(scanner);
            System.out.print("Note examen : ");
            double examMath = saisirNoteValide(scanner);
            etudiant.ajouterNote(new Note(math, devoirMath, examMath));

            // Algorithmique
            System.out.println("\nAlgorithmique (Coef 2)");
            System.out.print("Note devoir : ");
            double devoirAlgo = saisirNoteValide(scanner);
            System.out.print("Note examen : ");
            double examAlgo = saisirNoteValide(scanner);
            etudiant.ajouterNote(new Note(algo, devoirAlgo, examAlgo));

            // Reseaux
            System.out.println("\nReseaux (Coef 4)");
            System.out.print("Note devoir : ");
            double devoirReseaux = saisirNoteValide(scanner);
            System.out.print("Note examen : ");
            double examReseaux = saisirNoteValide(scanner);
            etudiant.ajouterNote(new Note(reseaux, devoirReseaux, examReseaux));

            // Base de donnees
            System.out.println("\nBase de donnees (Coef 2)");
            System.out.print("Note devoir : ");
            double devoirBdd = saisirNoteValide(scanner);
            System.out.print("Note examen : ");
            double examBdd = saisirNoteValide(scanner);
            etudiant.ajouterNote(new Note(bdd, devoirBdd, examBdd));

            scanner.nextLine();

            classe.ajouterEtudiant(etudiant);
        }

        // Calcul et classement
        classe.calculerMoyennes();
        classe.classerEtudiants();

        System.out.println("\n\n=================================================");
        System.out.println("                RESULTATS FINAUX");
        System.out.println("=================================================\n");

        for (Etudiant e : classe.getEtudiants()) {
            System.out.println(e);
        }

        scanner.close();
    }

    // ===============================
    // Méthode de validation des notes
    // ===============================
    private static double saisirNoteValide(Scanner scanner) {

        double note;

        while (true) {

            if (scanner.hasNextDouble()) {
                note = scanner.nextDouble();

                if (note >= 0 && note <= 20) {
                    return note;
                } else {
                    System.out.println("Erreur : la note doit etre comprise entre 0 et 20.");
                }

            } else {
                System.out.println("Erreur : veuillez saisir un nombre valide.");
                scanner.next();
            }

            System.out.print("Veuillez ressaisir : ");
        }
    }
}