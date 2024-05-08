package controler.Models;


import javax.persistence.*;

@Entity
@Table(name = "pracownik")
public class Pracownik {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_pracownik;

    private String imie;
    private String nazwisko;
    private String stanowisko;
    private String plec;
    private String dzial;
    private String email;
    private String telefon;

    public Pracownik() {}

    public Pracownik(String imie, String nazwisko, String stanowisko, String plec, String dzial, String email, String telefon) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.stanowisko = stanowisko;
        this.plec = plec;
        this.dzial = dzial;
        this.email = email;
        this.telefon = telefon;
    }



    public Integer getId_pracownik() {
        return id_pracownik;
    }

    public void setId_pracownik(Integer id_pracownik) {
        this.id_pracownik = id_pracownik;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public String getDzial() {
        return dzial;
    }

    public void setDzial(String dzial) {
        this.dzial = dzial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}
