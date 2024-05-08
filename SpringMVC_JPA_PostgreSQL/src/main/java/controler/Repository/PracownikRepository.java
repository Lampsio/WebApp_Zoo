package controler.Repository;

import controler.Models.Pracownik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PracownikRepository extends JpaRepository<Pracownik, Integer> {

    List<Pracownik> findAllByOrderByNazwiskoAsc();
    List<Pracownik> findByPlecOrderByNazwiskoAsc(String plec);

}