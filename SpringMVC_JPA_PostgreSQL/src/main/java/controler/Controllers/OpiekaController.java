package controler.Controllers;


import controler.DTO.OpiekaCreateDTO;
import controler.DTO.OpiekaEditDTO;
import controler.DTO.OpiekaSelectDTO;
import controler.Models.Opieka;
import controler.Models.Pracownik;
import controler.Models.Zwierze;
import controler.Repository.OpiekaRepository;
import controler.Repository.PracownikRepository;
import controler.Repository.ZwierzeRepository;
import controler.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/opieka")
@CrossOrigin(origins = "http://localhost:3000")
public class OpiekaController {

    @Autowired
    private OpiekaRepository opiekaRepository;
    @Autowired
    private ZwierzeRepository zwierzeRepository;
    @Autowired
    private PracownikRepository pracownikRepository;

    @GetMapping("/lista")
    public List<OpiekaSelectDTO> getOpieka() {
        List<Opieka> opiekaList = opiekaRepository.findAll();
        List<OpiekaSelectDTO> opiekaSelectDTOList = new ArrayList<>();

        for (Opieka opieka : opiekaList) {
            OpiekaSelectDTO opiekaSelectDTO = new OpiekaSelectDTO();
            opiekaSelectDTO.setId_opieka(opieka.getId_opieka());
            opiekaSelectDTO.setData_rozpoczecia(opieka.getData_rozpoczecia());
            opiekaSelectDTO.setData_zakonczenia(opieka.getData_zakonczenia());

            // Pobranie imienia i nazwiska pracownika
            Pracownik pracownik = pracownikRepository.findById(opieka.getPracownik().getId_pracownik()).orElseThrow(() -> new RuntimeException("Pracownik o podanym id nie istnieje"));
            opiekaSelectDTO.setImieNazwiskoPracownika(pracownik.getImie() + " " + pracownik.getNazwisko());

            // Pobranie imienia zwierzaka
            Zwierze zwierze = zwierzeRepository.findById(opieka.getZwierze().getId_zwierze()).orElseThrow(() -> new RuntimeException("Zwierze o podanym id nie istnieje"));
            opiekaSelectDTO.setImieZwierzecia(zwierze.getImie());

            opiekaSelectDTOList.add(opiekaSelectDTO);
        }

        return opiekaSelectDTOList;
    }

    @PostMapping("/dodaj")
    public ResponseEntity<Void> dodajOpieka(@RequestBody OpiekaCreateDTO opiekaCreateDTO) {
        Zwierze zwierze = zwierzeRepository.findById(opiekaCreateDTO.getId_zwierze()).orElseThrow(() -> new RuntimeException("Zwierze o podanym id nie istnieje"));
        Pracownik pracownik = pracownikRepository.findById(opiekaCreateDTO.getId_pracownik()).orElseThrow(() -> new RuntimeException("Pracownik o podanym id nie istnieje"));

        Opieka opieka = new Opieka(zwierze, pracownik, opiekaCreateDTO.getData_rozpoczecia(), opiekaCreateDTO.getData_zakonczenia());
        opiekaRepository.save(opieka);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/edytuj/{id}")
    public ResponseEntity<Void> edytujOpieka(@PathVariable Integer id, @RequestBody OpiekaEditDTO opiekaCreateDTO) {
        Opieka opieka = opiekaRepository.findById(id).orElseThrow(() -> new RuntimeException("Opieka o podanym id nie istnieje"));

        Zwierze zwierze = zwierzeRepository.findById(opiekaCreateDTO.getId_zwierze()).orElseThrow(() -> new RuntimeException("Zwierze o podanym id nie istnieje"));
        Pracownik pracownik = pracownikRepository.findById(opiekaCreateDTO.getId_pracownik()).orElseThrow(() -> new RuntimeException("Pracownik o podanym id nie istnieje"));

        opieka.setZwierze(zwierze);
        opieka.setPracownik(pracownik);
        opieka.setData_rozpoczecia(opiekaCreateDTO.getData_rozpoczecia());
        opieka.setData_zakonczenia(opiekaCreateDTO.getData_zakonczenia());

        opiekaRepository.save(opieka);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/usun/{id}")
    public ResponseEntity<Void> usunOpieka(@PathVariable Integer id) {
        opiekaRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}