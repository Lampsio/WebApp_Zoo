package controler.DTO;

import java.time.LocalDate;

public class OpiekaEditDTO {

    private Integer id_zwierze;
    private Integer id_pracownik;
    private LocalDate data_rozpoczecia;
    private LocalDate data_zakonczenia;



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
