package tn.pi.Web;

import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.pi.DTO.FacturationDTO;
import tn.pi.Services.FacturationService;

import java.util.List;


@RestController
@RequestMapping("/api/facturations")
@Tag(name = "Facturations", description = "API pour la gestion des facturations")
public class FacturationController {

    private final FacturationService facturationService;

    @Autowired
    public FacturationController(FacturationService facturationService) {
        this.facturationService = facturationService;
    }

    @PostMapping
    @Operation(summary = "Créer une nouvelle facturation")
    public FacturationDTO creerFacturation(@RequestBody FacturationDTO factureDTO) {
        return facturationService.creerFacturation(factureDTO);
    }

    @GetMapping
    @Operation(summary = "Obtenir toutes les facturations")
    public List<FacturationDTO> obtenirToutesLesFacturations() {
        return facturationService.obtenirToutesLesFacturations();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir une facturation par ID")
    public FacturationDTO obtenirFacturationParId(@PathVariable Long id) {
        return facturationService.obtenirFacturationParId(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer une facturation par ID")
    public void supprimerFacturation(@PathVariable Long id) {
        facturationService.supprimerFacturation(id);
    }
}
