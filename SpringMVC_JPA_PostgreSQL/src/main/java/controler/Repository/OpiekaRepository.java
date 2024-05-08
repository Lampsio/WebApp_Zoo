package controler.Repository;

import controler.Models.Opieka;
import controler.Models.Pracownik;
import controler.Models.Zwierze;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OpiekaRepository extends JpaRepository<Opieka, Integer> {

    List<Opieka> findByZwierze(Zwierze zwierze);

    List<Opieka> findByPracownik(Pracownik pracownik);
}