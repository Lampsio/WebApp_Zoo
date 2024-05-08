package controler.Controllers;


import controler.DTO.WeterynariaCreateDTO;
import controler.DTO.WeterynariaSelectDTO;
import controler.Models.Pracownik;
import controler.Models.Weterynaria;
import controler.Models.Zwierze;
import controler.Repository.PracownikRepository;
import controler.Repository.WeterynariaRepository;
import controler.Repository.ZwierzeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/weterynaria")
@CrossOrigin(origins = "http://localhost:3000")
public class WeterynariaController {

    @Autowired
    private WeterynariaRepository weterynariaRepository;
    @Autowired
    private ZwierzeRepository zwierzeRepository;
    @Autowired
    private PracownikRepository pracownikRepository;

    @GetMapping("/lista")
    public List<WeterynariaSelectDTO> getWeterynaria() {
        List<Weterynaria> weterynariaList = weterynariaRepository.findAll();
        List<WeterynariaSelectDTO> weterynariaSelectDTOList = new ArrayList<>();

        for (Weterynaria weterynaria : weterynariaList) {
            WeterynariaSelectDTO weterynariaSelectDTO = new WeterynariaSelectDTO();
            weterynariaSelectDTO.setId_wizyta(weterynaria.getId_wizyta());
            weterynariaSelectDTO.setData_wizyty(weterynaria.getData_wizyty());
            weterynariaSelectDTO.setPowod(weterynaria.getPowod());
            weterynariaSelectDTO.setDiagnoza(weterynaria.getDiagnoza());

            // Pobranie imienia i nazwiska pracownika
            Pracownik pracownik = pracownikRepository.findById(weterynaria.getPracownik().getId_pracownik()).orElseThrow(() -> new RuntimeException("Pracownik o podanym id nie istnieje"));
            weterynariaSelectDTO.setImieNazwiskoPracownika(pracownik.getImie() + " " + pracownik.getNazwisko());

            // Pobranie imienia zwierzaka
            Zwierze zwierze = zwierzeRepository.findById(weterynaria.getZwierze().getId_zwierze()).orElseThrow(() -> new RuntimeException("Zwierze o podanym id nie istnieje"));
            weterynariaSelectDTO.setImieZwierzecia(zwierze.getImie());

            weterynariaSelectDTOList.add(weterynariaSelectDTO);
        }

        return weterynariaSelectDTOList;
    }

    @PostMapping("/dodaj")
    public ResponseEntity<Void> dodajWeterynaria(@RequestBody WeterynariaCreateDTO weterynariaCreateDTO) {
        Zwierze zwierze = zwierzeRepository.findById(weterynariaCreateDTO.getId_zwierze()).orElseThrow(() -> new RuntimeException("Zwierze o podanym id nie istnieje"));
        Pracownik pracownik = pracownikRepository.findById(weterynariaCreateDTO.getId_pracownik()).orElseThrow(() -> new RuntimeException("Pracownik o podanym id nie istnieje"));

        Weterynaria weterynaria = new Weterynaria(zwierze, pracownik, weterynariaCreateDTO.getData_wizyty(), weterynariaCreateDTO.getPowod(), weterynariaCreateDTO.getDiagnoza());
        weterynariaRepository.save(weterynaria);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/edytuj/{id}")
    public ResponseEntity<Void> edytujWeterynaria(@PathVariable Integer id, @RequestBody WeterynariaCreateDTO weterynariaCreateDTO) {
        Weterynaria weterynaria = weterynariaRepository.findById(id).orElseThrow(() -> new RuntimeException("Wizyta weterynaryjna o podanym id nie istnieje"));

        Zwierze zwierze = zwierzeRepository.findById(weterynariaCreateDTO.getId_zwierze()).orElseThrow(() -> new RuntimeException("Zwierze o podanym id nie istnieje"));
        Pracownik pracownik = pracownikRepository.findById(weterynariaCreateDTO.getId_pracownik()).orElseThrow(() -> new RuntimeException("Pracownik o podanym id nie istnieje"));

        weterynaria.setZwierze(zwierze);
        weterynaria.setPracownik(pracownik);
        weterynaria.setData_wizyty(weterynariaCreateDTO.getData_wizyty());
        weterynaria.setPowod(weterynariaCreateDTO.getPowod());
        weterynaria.setDiagnoza(weterynariaCreateDTO.getDiagnoza());

        weterynariaRepository.save(weterynaria);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/usun/{id}")
    public ResponseEntity<Void> usunWeterynaria(@PathVariable Integer id) {
        weterynariaRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
