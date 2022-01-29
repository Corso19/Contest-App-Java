package Entity;

import java.io.*;
import java.util.Scanner;

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

    public void write() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Stefan Acatrinei\\Desktop\\proiectmip2\\src\\main\\java\\Entity\\currentUser.txt");
            PrintWriter printWriter = new PrintWriter(fileOutputStream);
            printWriter.write(id + "\n" + idechipa + "\n" + username + "\n" + nume + "\n" + is_admin + "\n" + nume_echipa);
            printWriter.close();
            System.out.println("Successfuly wrote to this file");
        } catch (IOException e) {
            System.out.println("Error occured");
            e.printStackTrace();
        }
    }

    public void read(){
        try {

            File myObj = new File("C:\\Users\\Stefan Acatrinei\\Desktop\\proiectmip2\\src\\main\\java\\Entity\\currentUser.txt");
            Scanner myReader = new Scanner(myObj);
            id = Integer.parseInt(myReader.nextLine());
            idechipa = Integer.parseInt(myReader.nextLine());
            username = myReader.nextLine();
            nume = myReader.nextLine();
            is_admin = Boolean.parseBoolean(myReader.nextLine());
            nume_echipa = myReader.nextLine();
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error has occured!");
            e.printStackTrace();
        }
    }

}
