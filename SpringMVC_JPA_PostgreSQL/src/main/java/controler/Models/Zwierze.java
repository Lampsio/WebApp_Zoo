package controler.Models;



import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "zwierze")
public class Zwierze {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_zwierze;

    @ManyToOne
    @JoinColumn(name = "wybieg_id")
    private Wybieg wybieg;
    private String gatunek;
    private String rasa;
    private Integer wiek;
    private String plec;
    private String imie;
    private LocalDate data_urodzenia;
    private String miejsce_urodzenia;
    private String pochodzenie;

    public Zwierze() {}

    public Zwierze(Wybieg wybieg, String gatunek, String rasa, Integer wiek, String plec, String imie, LocalDate data_urodzenia, String miejsce_urodzenia, String pochodzenie) {
        this.wybieg = wybieg;
        this.gatunek = gatunek;
        this.rasa = rasa;
        this.wiek = wiek;
        this.plec = plec;
        this.imie = imie;
        this.data_urodzenia = data_urodzenia;
        this.miejsce_urodzenia = miejsce_urodzenia;
        this.pochodzenie = pochodzenie;
    }

    public Integer getId_zwierze() {
        return id_zwierze;
    }

    public void setId_zwierze(Integer id_zwierze) {
        this.id_zwierze = id_zwierze;
    }

    public Wybieg getWybieg() {
        return wybieg;
    }

    public void setWybieg(Wybieg wybieg) {
        this.wybieg = wybieg;
    }

    public String getGatunek() {
        return gatunek;
    }

    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }

    public String getRasa() {
        return rasa;
    }

    public void setRasa(String rasa) {
        this.rasa = rasa;
    }

    public Integer getWiek() {
        return wiek;
    }

    public void setWiek(Integer wiek) {
        this.wiek = wiek;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public LocalDate getData_urodzenia() {
        return data_urodzenia;
    }

    public void setData_urodzenia(LocalDate data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }

    public String getMiejsce_urodzenia() {
        return miejsce_urodzenia;
    }

    public void setMiejsce_urodzenia(String miejsce_urodzenia) {
        this.miejsce_urodzenia = miejsce_urodzenia;
    }

    public String getPochodzenie() {
        return pochodzenie;
    }

    public void setPochodzenie(String pochodzenie) {
        this.pochodzenie = pochodzenie;
    }

    // Gettery i settery
}

