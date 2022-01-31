package Entity;

import java.io.*;
import java.util.Scanner;

public class FinalResultsEntity {

    private String nume;
    private String nume_echipa;
    private Integer punctaj;

    public FinalResultsEntity() {
    }

    public FinalResultsEntity(String nume, String nume_echipa, Integer punctaj) {
        this.nume = nume;
        this.nume_echipa = nume_echipa;
        this.punctaj = punctaj;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getNume_echipa() {
        return nume_echipa;
    }

    public void setNume_echipa(String nume_echipa) {
        this.nume_echipa = nume_echipa;
    }

    public Integer getPunctaj() {
        return punctaj;
    }

    public void setPunctaj(Integer punctaj) {
        this.punctaj = punctaj;
    }
}
