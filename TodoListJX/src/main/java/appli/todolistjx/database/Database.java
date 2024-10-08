package appli.todolistjx.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private String serveur = "localhost";
    private String nomDeLaBase = "javafx";
    private String username = "Ahad";
    private String password = "Dugny01";


    public String getServeur() {
        return serveur;
    }

    public void setServeur(String serveur) {
        this.serveur = serveur;
    }

    public String getNomDeLaBase() {
        return nomDeLaBase;
    }

    public void setNomDeLaBase(String nomDeLaBase) {
        this.nomDeLaBase = nomDeLaBase;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        try{
            Connection cnx = DriverManager.getConnection(this.getUrl(),this.username,this.password);
            System.out.println("Etat de la connexion : ");
            System.out.println(cnx.isClosed()?"fermée":"ouverte \r\n");
            return cnx;
        }
    }

    private String getUrl() { return "jdbc.mysql://serveur/nomDeLaBase?serverTimezone=UTC";
    }
}

