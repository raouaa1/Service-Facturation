package tn.pi.Mappers;

import org.springframework.stereotype.Component;
import tn.pi.DTO.FacturationDTO;
import tn.pi.Entities.Facturation;

@Component
public class FacturationMapper {


    public FacturationDTO toDTO(Facturation facturation) {
        FacturationDTO dto = new FacturationDTO();
        dto.setId(facturation.getId());
        dto.setRefAbonne(facturation.getRefAbonne());
        dto.setDateEmission(facturation.getDateEmission());
        dto.setMontant(facturation.getMontant());
        dto.setDateLimitPaiement(facturation.getDateLimitPaiement());
        dto.setCodeOrganisme(facturation.getCodeOrganisme());
        return dto;
    }

    public Facturation toEntity(FacturationDTO dto) {
        Facturation facturation = new Facturation();
        facturation.setId(dto.getId());
        facturation.setRefAbonne(dto.getRefAbonne());
        facturation.setDateEmission(dto.getDateEmission());
        facturation.setMontant(dto.getMontant());
        facturation.setDateLimitPaiement(dto.getDateLimitPaiement());
        facturation.setCodeOrganisme(dto.getCodeOrganisme());
        return facturation;
    }

}
