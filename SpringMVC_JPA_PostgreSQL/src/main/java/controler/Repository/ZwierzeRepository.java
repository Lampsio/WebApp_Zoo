package controler.Repository;

import controler.Models.Opieka;
import controler.Models.Weterynaria;
import controler.Models.Wybieg;
import controler.Models.Zwierze;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ZwierzeRepository extends JpaRepository<Zwierze, Integer> {

    List<Zwierze> findAllByOrderByImieAsc();

    List<Zwierze> findByWybieg(Wybieg wybieg);

}
