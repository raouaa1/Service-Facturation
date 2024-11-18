package tn.pi.Web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.pi.DTO.FacturationDTO;
import tn.pi.Services.FacturationService;

import java.util.List;

@RestController
@RequestMapping("/api/facturations") // Point d'entrée de l'API pour les facturations
public class FacturationController {

    private final FacturationService facturationService;

    @Autowired
    public FacturationController(FacturationService facturationService) {
        this.facturationService = facturationService;
    }

    // 1. Créer une nouvelle facturation
    @PostMapping("/Add")
    public ResponseEntity<FacturationDTO> creerFacturation(@RequestBody FacturationDTO facturationDTO) {
        FacturationDTO nouvelleFacturation = facturationService.creerFacturation(facturationDTO);
        return new ResponseEntity<>(nouvelleFacturation, HttpStatus.CREATED); // Retourne la facturation créée avec le statut 201
    }

    // 2. Obtenir toutes les facturations
    @GetMapping("/all")
    public ResponseEntity<List<FacturationDTO>> obtenirToutesLesFacturations() {
        List<FacturationDTO> facturations = facturationService.obtenirToutesLesFacturations();
        return new ResponseEntity<>(facturations, HttpStatus.OK); // Retourne la liste des facturations
    }

    // 3. Obtenir une facturation par ID
    @GetMapping("/{id}")
    public ResponseEntity<FacturationDTO> obtenirFacturationParId(@PathVariable Long id) {
        FacturationDTO facturation = facturationService.obtenirFacturationParId(id);
        return new ResponseEntity<>(facturation, HttpStatus.OK); // Retourne la facturation trouvée
    }
    // 4. La mise a jour par ID

    @PutMapping("/facturations/{id}")
    public ResponseEntity<FacturationDTO> mettreAJourFacturation(
            @PathVariable Long id,
            @RequestBody FacturationDTO facturationDTO) {
        FacturationDTO miseAJour = facturationService.mettreAJourFacturation(id, facturationDTO);
        return ResponseEntity.ok(miseAJour);
    }

    // Ajouter la méthode pour obtenir une facturation par référence abonné
    @GetMapping("/refAbonne/{refAbonne}")
    public ResponseEntity<FacturationDTO> obtenirFacturationParRefAbonne(@PathVariable String refAbonne) {
        FacturationDTO facturationDTO = facturationService.obtenirFacturationParRefAbonne(refAbonne);
        return new ResponseEntity<>(facturationDTO, HttpStatus.OK); // Retourne la facturation trouvée
    }

    // 5. Supprimer une facturation par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerFacturation(@PathVariable Long id) {
        facturationService.supprimerFacturation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Retourne 204 si la suppression est réussie
    }
}
