package controler;

import controler.Models.*;
import controler.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private ZwierzeRepository zwierzeRepository;

    @Autowired
    private WybiegRepository wybiegRepository;

    @Autowired
    private PracownikRepository pracownikRepository;

    @Autowired
    private OpiekaRepository opiekaRepository;

    @Autowired
    private WeterynariaRepository weterynariaRepository;

    public Application(ZwierzeRepository zwierzeRepository, WybiegRepository wybiegRepository, PracownikRepository pracownikRepository, OpiekaRepository opiekaRepository, WeterynariaRepository weterynariaRepository) {
        this.zwierzeRepository = zwierzeRepository;
        this.wybiegRepository = wybiegRepository;
        this.pracownikRepository = pracownikRepository;
        this.opiekaRepository = opiekaRepository;
        this.weterynariaRepository = weterynariaRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Dane dla tabeli Zwierze
        Wybieg wybieg1 = wybiegRepository.save(new Wybieg("Serengeti", "Sawanna", 5000.0, "Duży wybieg dla zwierząt afrykańskich"));
        zwierzeRepository.save(new Zwierze(wybieg1, "Lew", "Afrykański lew", 5, "Samiec", "Simba", LocalDate.of(2018, 4, 15), "Ogród zoologiczny w Poznaniu", "Zoo w Warszawie"));
        zwierzeRepository.save(new Zwierze(wybieg1, "Lew", "Azjatycki lew", 3, "Samica", "Nala", LocalDate.of(2020, 1, 20), "Zoo w Berlinie", "Zoo w Warszawie"));

        // Dane dla tabeli Wybieg
        wybiegRepository.save(new Wybieg("Amazonia", "Las tropikalny", 3500.0, "Wybieg dla zwierząt z Ameryki Południowej"));

        // Dane dla tabeli Pracownik
        Pracownik pracownik1 = pracownikRepository.save(new Pracownik("Jan", "Kowalski", "Opiekun zwierząt", "Mężczyzna", "Dział opieki", "jan.kowalski@zoo.pl", "123456789"));
        Pracownik pracownik2 = pracownikRepository.save(new Pracownik("Anna", "Nowak", "Lekarz weterynarii", "Kobieta", "Dział weterynaryjny", "anna.nowak@zoo.pl", "987654321"));

        // Dane dla tabeli Opieka
        opiekaRepository.save(new Opieka(zwierzeRepository.findById(3).get(), pracownik1, LocalDate.of(2023, 1, 1), LocalDate.of(2024, 3, 31)));

        // Dane dla tabeli Weterynaria
        weterynariaRepository.save(new Weterynaria(zwierzeRepository.findById(2).get(), pracownik2, LocalDate.of(2024, 4, 5), "Badanie okresowe", "Zwierzę zdrowe"));
    }


}


