package it.mastermind.mmspring.models;

import javax.persistence.*;

@Entity
@Table(name="combination")
public class CombinationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int ID;

    @Column(name = "username")
    private String username;

    @Column(name = "soluzione")
    private String soluzione;

    @Column(name = "data_operazione")
    private String dataOperazione;

    public CombinationModel() {
    }

    public CombinationModel(String username, String soluzione, String dataOperazione) {
        this.username = username;
        this.soluzione = soluzione;
        this.dataOperazione = dataOperazione;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSoluzione() {
        return soluzione;
    }

    public void setSoluzione(String soluzione) {
        this.soluzione = soluzione;
    }

    public String getDataOperazione() {
        return dataOperazione;
    }

    public void setDataOperazione(String dataOperazione) {
        this.dataOperazione = dataOperazione;
    }

    @Override
    public String toString() {
        return "CombinationModel{" +
                "ID=" + ID +
                ", username='" + username + '\'' +
                ", soluzione='" + soluzione + '\'' +
                ", dataOperazione='" + dataOperazione + '\'' +
                '}';
    }

}
