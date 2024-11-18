package tn.pi.Services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.pi.DTO.FacturationDTO;
import tn.pi.Entities.Facturation;
import tn.pi.Exceptions.FacturationNotFoundException;
import tn.pi.Mappers.FacturationMapper;
import tn.pi.Repositories.FacturationRepository;
import tn.pi.Services.FacturationService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacturationServiceImpl implements FacturationService {

    private final FacturationRepository factureRepository;
    private final FacturationMapper factureMapper;

    @Autowired
    public FacturationServiceImpl(FacturationRepository factureRepository, FacturationMapper factureMapper) {
        this.factureRepository = factureRepository;
        this.factureMapper = factureMapper;
    }

    @Override
    public FacturationDTO creerFacturation(FacturationDTO factureDTO) {
        Facturation facturation = factureMapper.toEntity(factureDTO);
        facturation = factureRepository.save(facturation);
        return factureMapper.toDTO(facturation);
    }

    @Override
    public List<FacturationDTO> obtenirToutesLesFacturations() {
        return factureRepository.findAll().stream()
                .map(factureMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FacturationDTO obtenirFacturationParId(Long id) {
        Facturation facturation = factureRepository.findById(id)
                .orElseThrow(() -> new FacturationNotFoundException(id));
        return factureMapper.toDTO(facturation);
    }

    @Override
    public FacturationDTO obtenirFacturationParRefAbonne(String refAbonne) {
        Facturation facturation = factureRepository.findByRefAbonne(refAbonne)
                .orElseThrow(() -> new FacturationNotFoundException(refAbonne));
        return factureMapper.toDTO(facturation);
    }

    @Override
    public FacturationDTO mettreAJourFacturation(Long id, FacturationDTO facturationDTO) {
        // Rechercher la facturation existante par son ID
        Facturation facturationExistante = factureRepository.findById(id)
                .orElseThrow(() -> new FacturationNotFoundException(id)); // Passer l'ID directement

        // Mettre à jour les champs de la facturation existante avec les nouvelles données
        if (facturationDTO.getMontant() != 0) {
            facturationExistante.setMontant(facturationDTO.getMontant());
        }

        if (facturationDTO.getDateEmission() != null) {
            facturationExistante.setDateEmission(facturationDTO.getDateEmission());
        }

        if (facturationDTO.getRefAbonne() != null && !facturationDTO.getRefAbonne().isEmpty()) {
            facturationExistante.setRefAbonne(facturationDTO.getRefAbonne());
        }

        // Sauvegarder les modifications dans la base de données
        facturationExistante = factureRepository.save(facturationExistante);

        // Retourner la facturation mise à jour sous forme de DTO
        return factureMapper.toDTO(facturationExistante);
    }


    @Override
    public void supprimerFacturation(Long id) {
        if (!factureRepository.existsById(id)) {
            throw new FacturationNotFoundException(id);
        }
        factureRepository.deleteById(id);
    }
}
