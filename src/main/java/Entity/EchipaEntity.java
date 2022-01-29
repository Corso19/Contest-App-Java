package Entity;

import java.io.*;
import java.util.Scanner;

public class EchipaEntity {

    private Integer idechipa;
    private String nume_echipa;

    public EchipaEntity() {
    }

    public EchipaEntity(Integer idechipa, String nume_echipa) {
        this.idechipa = idechipa;
        this.nume_echipa = nume_echipa;
    }

    public Integer getIdechipa() {
        return idechipa;
    }

    public void setIdechipa(Integer idechipa) {
        this.idechipa = idechipa;
    }

    public String getNume_echipa() {
        return nume_echipa;
    }

    public void setNume_echipa(String nume_echipa) {
        this.nume_echipa = nume_echipa;
    }
}
