package controler.Models;



import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "wybieg")
public class Wybieg {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_wybieg;

    private String nazwa;
    private String typ;
    private Double powierzchnia;
    private String opis;



    public Wybieg() {}

    public Wybieg(String nazwa, String typ, Double powierzchnia, String opis) {
        this.nazwa = nazwa;
        this.typ = typ;
        this.powierzchnia = powierzchnia;
        this.opis = opis;
    }



    public Integer getId_wybieg() {
        return id_wybieg;
    }

    public void setId_wybieg(Integer id_wybieg) {
        this.id_wybieg = id_wybieg;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public Double getPowierzchnia() {
        return powierzchnia;
    }

    public void setPowierzchnia(Double powierzchnia) {
        this.powierzchnia = powierzchnia;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}

