package controler.Controllers;

import controler.DTO.ZwierzeDTO;
import controler.DTO.ZwierzeZWybiegiemDTO;
import controler.Models.Opieka;
import controler.Models.Weterynaria;
import controler.Models.Wybieg;
import controler.Models.Zwierze;
import controler.Repository.OpiekaRepository;
import controler.Repository.WeterynariaRepository;
import controler.Repository.WybiegRepository;
import controler.Repository.ZwierzeRepository;
import controler.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/zwierzeta")
@CrossOrigin(origins = "http://localhost:3000")
public class ZwierzeController {

    @Autowired
    private ZwierzeRepository zwierzeRepository;
    @Autowired
    private WybiegRepository wybiegRepository;
    @Autowired
    private OpiekaRepository opiekaRepository;
    @Autowired
    private WeterynariaRepository weterynariaRepository;

    @PostMapping("/dodaj")
    public ResponseEntity<?> dodajZwierze(@RequestBody ZwierzeDTO zwierzeDTO) {
        if (zwierzeDTO.getWiek() < 0) {
            return ResponseEntity.badRequest().body("Nie można ustawiać wieku mniejszego niż 0");
        }
        // Sprawdzenie gatunku
        if (zwierzeDTO.getGatunek() == null || zwierzeDTO.getGatunek().isEmpty()) {
            return ResponseEntity.badRequest().body("Gatunek zwierzęcia nie może być pusty");
        }

        // Sprawdzenie rasy
        if (zwierzeDTO.getRasa() == null || zwierzeDTO.getRasa().isEmpty()) {
            return ResponseEntity.badRequest().body("Rasa zwierzęcia nie może być pusta");
        }

        // Sprawdzenie płci
        if (zwierzeDTO.getPlec() == null) {
            return ResponseEntity.badRequest().body("Płeć zwierzęcia nie może być pusta");
        }

        // Sprawdzenie imienia
        if (zwierzeDTO.getImie() == null || zwierzeDTO.getImie().isEmpty()) {
            return ResponseEntity.badRequest().body("Imię zwierzęcia nie może być puste");
        }

        // Sprawdzenie daty urodzenia
        if (zwierzeDTO.getDataUrodzenia() == null) {
            return ResponseEntity.badRequest().body("Data urodzenia zwierzęcia nie może być pusta");
        }

        // Sprawdzenie miejsca urodzenia
        if (zwierzeDTO.getMiejsceUrodzenia() == null || zwierzeDTO.getMiejsceUrodzenia().isEmpty()) {
            return ResponseEntity.badRequest().body("Miejsce urodzenia zwierzęcia nie może być puste");
        }

        // Sprawdzenie pochodzenia
        if (zwierzeDTO.getPochodzenie() == null || zwierzeDTO.getPochodzenie().isEmpty()) {
            return ResponseEntity.badRequest().body("Pochodzenie zwierzęcia nie może być puste");
        }
        Zwierze zwierze = new Zwierze();
        Wybieg wybieg = wybiegRepository.findById(zwierzeDTO.getWybiegId()).orElseThrow(() -> new RuntimeException("Wybieg o podanym id nie istnieje"));
        zwierze.setWybieg(wybieg);
        zwierze.setGatunek(zwierzeDTO.getGatunek());
        zwierze.setRasa(zwierzeDTO.getRasa());
        zwierze.setWiek(zwierzeDTO.getWiek());
        zwierze.setPlec(zwierzeDTO.getPlec());
        zwierze.setImie(zwierzeDTO.getImie());
        zwierze.setData_urodzenia(zwierzeDTO.getDataUrodzenia());
        zwierze.setMiejsce_urodzenia(zwierzeDTO.getMiejsceUrodzenia());
        zwierze.setPochodzenie(zwierzeDTO.getPochodzenie());

        zwierzeRepository.save(zwierze);

        return ResponseEntity.ok(zwierze);
    }

    @GetMapping("/z-wybiegiem")
    public List<ZwierzeZWybiegiemDTO> getZwierzetaZWybiegiem() {
        List<Zwierze> zwierzeta = zwierzeRepository.findAll();

        List<ZwierzeZWybiegiemDTO> zwierzetaZWybiegiemDTO = new ArrayList<>();
        for (Zwierze zwierze : zwierzeta) {
            ZwierzeZWybiegiemDTO dto = new ZwierzeZWybiegiemDTO();
            dto.setIdZwierze(zwierze.getId_zwierze());
            dto.setGatunek(zwierze.getGatunek());
            dto.setRasa(zwierze.getRasa());
            dto.setWiek(zwierze.getWiek());
            dto.setPlec(zwierze.getPlec());
            dto.setImie(zwierze.getImie());
            dto.setDataUrodzenia(zwierze.getData_urodzenia());
            dto.setMiejsceUrodzenia(zwierze.getMiejsce_urodzenia());
            dto.setPochodzenie(zwierze.getPochodzenie());
            dto.setNazwaWybiegu(zwierze.getWybieg().getNazwa());

            zwierzetaZWybiegiemDTO.add(dto);
        }

        return zwierzetaZWybiegiemDTO;
    }

    @PutMapping("/edytuj/{id}")
    public ResponseEntity<Zwierze> edytujZwierze(@PathVariable Integer id, @RequestBody ZwierzeDTO zwierzeDTO) {
        Zwierze zwierze = zwierzeRepository.findById(id).orElseThrow(() -> new RuntimeException("Zwierzę o podanym id nie istnieje"));

        Wybieg wybieg = wybiegRepository.findById(zwierzeDTO.getWybiegId()).orElseThrow(() -> new RuntimeException("Wybieg o podanym id nie istnieje"));
        zwierze.setWybieg(wybieg);
        zwierze.setGatunek(zwierzeDTO.getGatunek());
        zwierze.setRasa(zwierzeDTO.getRasa());
        zwierze.setWiek(zwierzeDTO.getWiek());
        zwierze.setPlec(zwierzeDTO.getPlec());
        zwierze.setImie(zwierzeDTO.getImie());
        zwierze.setData_urodzenia(zwierzeDTO.getDataUrodzenia());
        zwierze.setMiejsce_urodzenia(zwierzeDTO.getMiejsceUrodzenia());
        zwierze.setPochodzenie(zwierzeDTO.getPochodzenie());

        zwierzeRepository.save(zwierze);

        return ResponseEntity.ok(zwierze);
    }

    @DeleteMapping("/usun/{id}")
    public ResponseEntity<Void> usunZwierze(@PathVariable Integer id) {
        Zwierze zwierze = zwierzeRepository.findById(id).orElseThrow(() -> new RuntimeException("Zwierze o podanym id nie istnieje"));

        // Usuwanie powiązanych rekordów z Opieka
        List<Opieka> opiekaList = opiekaRepository.findByZwierze(zwierze);
        opiekaRepository.deleteAll(opiekaList);

        // Usuwanie powiązanych rekordów z Weterynaria
        List<Weterynaria> weterynariaList = weterynariaRepository.findByZwierze(zwierze);
        weterynariaRepository.deleteAll(weterynariaList);

        // Usuwanie zwierzaka
        zwierzeRepository.delete(zwierze);

        return ResponseEntity.noContent().build();
    }
}



