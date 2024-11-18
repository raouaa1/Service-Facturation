package tn.pi.Exceptions;

public class FacturationNotFoundException extends RuntimeException {

    public FacturationNotFoundException(Long id) {
        super("Facturation avec l'ID " + id + " non trouvée.");
    }

    // Nouvelle exception pour la référence abonné
    public FacturationNotFoundException(String refAbonne) {
        super("Facturation avec la référence abonné " + refAbonne + " non trouvée.");
    }
}
