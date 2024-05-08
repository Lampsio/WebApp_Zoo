package controler.Models;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "opieka")
public class Opieka {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_opieka;

    @ManyToOne
    @JoinColumn(name = "zwierze_id")
    private Zwierze zwierze;

    @ManyToOne
    @JoinColumn(name = "pracownik_id")
    private Pracownik pracownik;

    private LocalDate data_rozpoczecia;
    private LocalDate data_zakonczenia;

    protected Opieka() {}

    public Opieka(Zwierze zwierze, Pracownik pracownik, LocalDate data_rozpoczecia, LocalDate data_zakonczenia) {
        this.zwierze = zwierze;
        this.pracownik = pracownik;
        this.data_rozpoczecia = data_rozpoczecia;
        this.data_zakonczenia = data_zakonczenia;
    }



    public Integer getId_opieka() {
        return id_opieka;
    }

    public void setId_opieka(Integer id_opieka) {
        this.id_opieka = id_opieka;
    }

    public Zwierze getZwierze() {
        return zwierze;
    }

    public void setZwierze(Zwierze zwierze) {
        this.zwierze = zwierze;
    }

    public Pracownik getPracownik() {
        return pracownik;
    }

    public void setPracownik(Pracownik pracownik) {
        this.pracownik = pracownik;
    }

    public LocalDate getData_rozpoczecia() {
        return data_rozpoczecia;
    }

    public void setData_rozpoczecia(LocalDate data_rozpoczecia) {
        this.data_rozpoczecia = data_rozpoczecia;
    }

    public LocalDate getData_zakonczenia() {
        return data_zakonczenia;
    }

    public void setData_zakonczenia(LocalDate data_zakonczenia) {
        this.data_zakonczenia = data_zakonczenia;
    }
}
