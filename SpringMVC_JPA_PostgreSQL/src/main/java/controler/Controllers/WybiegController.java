package controler.Controllers;


import controler.DTO.WybiegDTO;
import controler.Models.Wybieg;
import controler.Models.Zwierze;
import controler.Repository.WybiegRepository;
import controler.Repository.ZwierzeRepository;
import controler.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wybiegi")
@CrossOrigin(origins = "http://localhost:3000")
public class WybiegController {

    @Autowired
    private WybiegRepository wybiegRepository;
    @Autowired
    private ZwierzeRepository zwierzeRepository;


    @GetMapping("/lista")
    public List<Wybieg> getWybiegi() {
        return wybiegRepository.findAll();
    }

    @PostMapping("/dodaj")
    public ResponseEntity<Wybieg> dodajWybieg(@RequestBody WybiegDTO wybiegDTO) {
        Wybieg wybieg = new Wybieg();
        wybieg.setNazwa(wybiegDTO.getNazwa());
        wybieg.setPowierzchnia(wybiegDTO.getPowierzchnia());
        wybieg.setTyp((wybiegDTO.getTyp()));
        wybieg.setOpis(wybiegDTO.getOpis());

        wybiegRepository.save(wybieg);

        return ResponseEntity.ok(wybieg);
    }

    @PutMapping("/edytuj/{id}")
    public ResponseEntity<Wybieg> edytujWybieg(@PathVariable Integer id, @RequestBody WybiegDTO wybiegDTO) {
        Wybieg wybieg = wybiegRepository.findById(id).orElseThrow(() -> new RuntimeException("Wybieg o podanym id nie istnieje"));

        wybieg.setNazwa(wybiegDTO.getNazwa());
        wybieg.setPowierzchnia(wybiegDTO.getPowierzchnia());
        wybieg.setTyp((wybiegDTO.getTyp()));
        wybieg.setOpis(wybiegDTO.getOpis());

        wybiegRepository.save(wybieg);

        return ResponseEntity.ok(wybieg);
    }

    @DeleteMapping("/usun/{id}")
    public ResponseEntity<Void> usunWybieg(@PathVariable Integer id) {
        Wybieg wybieg = wybiegRepository.findById(id).orElseThrow(() -> new RuntimeException("Wybieg o podanym id nie istnieje"));

        // Usuwamy zwierzęta powiązane z wybiegiem
        List<Zwierze> zwierzeta = zwierzeRepository.findByWybieg(wybieg);
        zwierzeRepository.deleteAll(zwierzeta);

        wybiegRepository.delete(wybieg);

        return ResponseEntity.noContent().build();
    }
}

