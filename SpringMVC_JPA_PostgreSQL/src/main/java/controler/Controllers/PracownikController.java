package controler.Controllers;

import controler.DTO.PracownikDTO;
import controler.Models.Opieka;
import controler.Models.Pracownik;
import controler.Models.Weterynaria;
import controler.Repository.OpiekaRepository;
import controler.Repository.PracownikRepository;
import controler.Repository.WeterynariaRepository;
import controler.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pracownicy")
@CrossOrigin(origins = "http://localhost:3000")
public class PracownikController {

    @Autowired
    private PracownikRepository pracownikRepository;
    @Autowired
    private OpiekaRepository opiekaRepository;
    @Autowired
    private WeterynariaRepository weterynariaRepository;

    @GetMapping("/lista")
    public List<Pracownik> getPracownik() {
        return pracownikRepository.findAll();
    }

    @PostMapping("/dodaj")
    public ResponseEntity<Pracownik> dodajPracownik(@RequestBody PracownikDTO pracownikDTO) {
        Pracownik pracownik = new Pracownik();
        pracownik.setImie(pracownikDTO.getImie());
        pracownik.setNazwisko(pracownikDTO.getNazwisko());
        pracownik.setStanowisko(pracownikDTO.getStanowisko());
        pracownik.setPlec(pracownikDTO.getPlec());
        pracownik.setDzial(pracownikDTO.getDzial());
        pracownik.setEmail(pracownikDTO.getEmail());
        pracownik.setTelefon(pracownikDTO.getTelefon());

        pracownikRepository.save(pracownik);

        return ResponseEntity.ok(pracownik);
    }

    @PutMapping("/edytuj/{id}")
    public ResponseEntity<Pracownik> edytujPracownik(@PathVariable Integer id, @RequestBody PracownikDTO pracownikDTO) {
        Pracownik pracownik = pracownikRepository.findById(id).orElseThrow(() -> new RuntimeException("Pracownik o podanym id nie istnieje"));

        pracownik.setImie(pracownikDTO.getImie());
        pracownik.setNazwisko(pracownikDTO.getNazwisko());
        pracownik.setStanowisko(pracownikDTO.getStanowisko());
        pracownik.setPlec(pracownikDTO.getPlec());
        pracownik.setDzial(pracownikDTO.getDzial());
        pracownik.setEmail(pracownikDTO.getEmail());
        pracownik.setTelefon(pracownikDTO.getTelefon());

        pracownikRepository.save(pracownik);

        return ResponseEntity.ok(pracownik);
    }

    @DeleteMapping("/usun/{id}")
    public ResponseEntity<Void> usunPracownik(@PathVariable Integer id) {
        Pracownik pracownik = pracownikRepository.findById(id).orElseThrow(() -> new RuntimeException("Pracownik o podanym id nie istnieje"));

        // Usuwanie powiązanych rekordów z Opieka
        List<Opieka> opiekaList = opiekaRepository.findByPracownik(pracownik);
        opiekaRepository.deleteAll(opiekaList);

        // Usuwanie powiązanych rekordów z Weterynaria
        List<Weterynaria> weterynariaList = weterynariaRepository.findByPracownik(pracownik);
        weterynariaRepository.deleteAll(weterynariaList);

        // Usuwanie pracownika
        pracownikRepository.delete(pracownik);

        return ResponseEntity.noContent().build();
    }
}

