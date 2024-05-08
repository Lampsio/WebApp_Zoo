package controler.Repository;

import controler.Models.Pracownik;
import controler.Models.Weterynaria;
import controler.Models.Zwierze;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeterynariaRepository extends JpaRepository<Weterynaria, Integer> {

    List<Weterynaria> findByZwierze(Zwierze zwierze);

    List<Weterynaria> findByPracownik(Pracownik pracownik);
}
