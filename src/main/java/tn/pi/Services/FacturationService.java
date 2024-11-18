package tn.pi.Services;

import tn.pi.DTO.FacturationDTO;

import java.util.List;

public interface FacturationService {

    FacturationDTO creerFacturation(FacturationDTO factureDTO);
    List<FacturationDTO> obtenirToutesLesFacturations();
    FacturationDTO obtenirFacturationParId(Long id);
    FacturationDTO obtenirFacturationParRefAbonne(String refAbonne);
    FacturationDTO mettreAJourFacturation(Long id, FacturationDTO facturationDTO);
    void supprimerFacturation(Long id);
}
