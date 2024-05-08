package controler.DTO;

import java.time.LocalDate;

public class WeterynariaSelectDTO {

    private Integer id_wizyta;
    private LocalDate data_wizyty;
    private String powod;
    private String diagnoza;
    private String imieNazwiskoPracownika;
    private String imieZwierzecia;

    // Gettery i settery
    public Integer getId_wizyta() {
        return id_wizyta;
    }

    public void setId_wizyta(Integer id_wizyta) {
        this.id_wizyta = id_wizyta;
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

    public String getImieNazwiskoPracownika() {
        return imieNazwiskoPracownika;
    }

    public void setImieNazwiskoPracownika(String imieNazwiskoPracownika) {
        this.imieNazwiskoPracownika = imieNazwiskoPracownika;
    }

    public String getImieZwierzecia() {
        return imieZwierzecia;
    }

    public void setImieZwierzecia(String imieZwierzecia) {
        this.imieZwierzecia = imieZwierzecia;
    }
}
