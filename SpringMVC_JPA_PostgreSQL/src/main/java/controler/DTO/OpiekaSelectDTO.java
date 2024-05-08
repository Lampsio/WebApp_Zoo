package controler.DTO;

import java.time.LocalDate;

public class OpiekaSelectDTO {

    private Integer id_opieka;
    private LocalDate data_rozpoczecia;
    private LocalDate data_zakonczenia;
    private String imieNazwiskoPracownika;
    private String imieZwierzecia;

    // Gettery i settery
    public Integer getId_opieka() {
        return id_opieka;
    }

    public void setId_opieka(Integer id_opieka) {
        this.id_opieka = id_opieka;
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
