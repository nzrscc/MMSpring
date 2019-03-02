package it.mastermind.mmspring.models;
import javax.persistence.*;

@Entity
@Table(name="user")
public class UserModel {

    // Definizione parametri

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "data_registrazione")
    private String dataRegistrazione;


    //Definizione costruttori

    public UserModel() {
    }

    public UserModel(String username, String password, String dataRegistrazione) {
        this.username = username;
        this.password = password;
        this.dataRegistrazione = dataRegistrazione;
    }


    //Definizioni getter e setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDataRegistrazione() {
        return dataRegistrazione;
    }

    public void setDataRegistrazione(String dataRegistrazione) {
        this.dataRegistrazione = dataRegistrazione;
    }


    @Override
    public String toString() {
        return "UserModel{" +
                "ID=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", dataRegistrazione='" + dataRegistrazione + '\'' +
                '}';
    }
}

