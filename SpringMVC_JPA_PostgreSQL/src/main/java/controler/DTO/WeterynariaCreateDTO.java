package controler.DTO;

import java.time.LocalDate;

public class WeterynariaCreateDTO {

    private Integer id_zwierze;
    private Integer id_pracownik;
    private LocalDate data_wizyty;
    private String powod;
    private String diagnoza;

    // Gettery i settery
    public Integer getId_zwierze() {
        return id_zwierze;
    }

    public void setId_zwierze(Integer id_zwierze) {
        this.id_zwierze = id_zwierze;
    }

    public Integer getId_pracownik() {
        return id_pracownik;
    }

    public void setId_pracownik(Integer id_pracownik) {
        this.id_pracownik = id_pracownik;
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
