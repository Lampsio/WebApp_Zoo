package controler.DTO;

import java.time.LocalDate;

public class ZwierzeZWybiegiemDTO {

    private Integer idZwierze;
    private String gatunek;
    private String rasa;
    private Integer wiek;
    private String plec;
    private String imie;
    private LocalDate dataUrodzenia;
    private String miejsceUrodzenia;
    private String pochodzenie;
    private String nazwaWybiegu;

    public Integer getIdZwierze() {
        return idZwierze;
    }

    public void setIdZwierze(Integer idZwierze) {
        this.idZwierze = idZwierze;
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

    public LocalDate getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(LocalDate dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public String getMiejsceUrodzenia() {
        return miejsceUrodzenia;
    }

    public void setMiejsceUrodzenia(String miejsceUrodzenia) {
        this.miejsceUrodzenia = miejsceUrodzenia;
    }

    public String getPochodzenie() {
        return pochodzenie;
    }

    public void setPochodzenie(String pochodzenie) {
        this.pochodzenie = pochodzenie;
    }

    public String getNazwaWybiegu() {
        return nazwaWybiegu;
    }

    public void setNazwaWybiegu(String nazwaWybiegu) {
        this.nazwaWybiegu = nazwaWybiegu;
    }
}
