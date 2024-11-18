package tn.pi.DTO;

import java.time.LocalDate;


public class FacturationDTO {

    private Long id;
    private String refAbonne;
    private LocalDate dateEmission;

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    private double montant;
    private LocalDate dateLimitPaiement;
    private String codeOrganisme;


    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRefAbonne() {
        return refAbonne;
    }

    public void setRefAbonne(String refAbonne) {
        this.refAbonne = refAbonne;
    }

    public LocalDate getDateEmission() {
        return dateEmission;
    }

    public void setDateEmission(LocalDate dateEmission) {
        this.dateEmission = dateEmission;
    }



    public LocalDate getDateLimitPaiement() {
        return dateLimitPaiement;
    }

    public void setDateLimitPaiement(LocalDate dateLimitPaiement) {
        this.dateLimitPaiement = dateLimitPaiement;
    }

    public String getCodeOrganisme() {
        return codeOrganisme;
    }

    public void setCodeOrganisme(String codeOrganisme) {
        this.codeOrganisme = codeOrganisme;
    }
}
