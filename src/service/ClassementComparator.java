package service;

import model.Etudiant;
import java.util.Comparator;

public class ClassementComparator implements Comparator<Etudiant> {

    @Override
    public int compare(Etudiant e1, Etudiant e2) {
        return Double.compare(
                e2.getMoyenneGenerale(),
                e1.getMoyenneGenerale()
        );
    }
}
