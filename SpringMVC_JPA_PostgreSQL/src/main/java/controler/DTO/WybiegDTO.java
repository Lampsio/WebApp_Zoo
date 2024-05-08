package controler.DTO;

public class WybiegDTO {

    private Integer idWybiegu;
    private String nazwa;

    private String typ;
    private Double powierzchnia;

    private String opis;

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    // Gettery i settery


    public Integer getIdWybiegu() {
        return idWybiegu;
    }

    public void setIdWybiegu(Integer idWybiegu) {
        this.idWybiegu = idWybiegu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Double getPowierzchnia() {
        return powierzchnia;
    }

    public void setPowierzchnia(Double powierzchnia) {
        this.powierzchnia = powierzchnia;
    }
}

