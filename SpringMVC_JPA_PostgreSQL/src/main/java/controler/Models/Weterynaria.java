package controler.Models;



import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "weterynaria")
public class Weterynaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_wizyta;

    @ManyToOne
    @JoinColumn(name = "zwierze_id")
    private Zwierze zwierze;

    @ManyToOne
    @JoinColumn(name = "pracownik_id")
    private Pracownik pracownik;

    private LocalDate data_wizyty;
    private String powod;
    private String diagnoza;

    public Weterynaria() {}

    public Weterynaria(Zwierze zwierze, Pracownik pracownik, LocalDate data_wizyty, String powod, String diagnoza) {
        this.zwierze = zwierze;
        this.pracownik = pracownik;
        this.data_wizyty = data_wizyty;
        this.powod = powod;
        this.diagnoza = diagnoza;
    }



    public Integer getId_wizyta() {
        return id_wizyta;
    }

    public void setId_wizyta(Integer id_wizyta) {
        this.id_wizyta = id_wizyta;
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

    public LocalDate getData_wizyty() {
        return data_wizyty;
    }

    public void setData_wizyty(LocalDate data_wizyty) {
        this.data_wizyty = data_wizyty;
    }

    public String getPowod() {
        return powod;
    }

    public void setPowod(String powod) {
        this.powod = powod;
    }

    public String getDiagnoza() {
        return diagnoza;
    }

    public void setDiagnoza(String diagnoza) {
        this.diagnoza = diagnoza;
    }
}

