package Entity;

public class PersonsEntity {
    private Integer id;
    private Integer idechipa;
    private String username;
    private String nume;
    private boolean is_admin;
    private String nume_echipa;

    public PersonsEntity() {
    }

    public PersonsEntity(Integer id, Integer idEchipa, String username, String nume, boolean is_admin) {
        this.id = id;
        this.idechipa = idEchipa;
        this.username = username;
        this.nume = nume;
        this.is_admin = is_admin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdEchipa() {
        return idechipa;
    }

    public void setIdEchipa(Integer idEchipa) {
        this.idechipa = idEchipa;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public boolean isIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }

    public String getNume_echipa() {
        return nume_echipa;
    }

    public void setNume_echipa(String nume_echipa) {
        this.nume_echipa = nume_echipa;
    }
}
