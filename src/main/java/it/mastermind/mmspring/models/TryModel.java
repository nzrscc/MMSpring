package it.mastermind.mmspring.models;

import javax.persistence.*;

@Entity
@Table(name = "try")
public class TryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_try")
    private int id_try;

    @Column(name = "id_user")
    private int id_user;

    @Column(name = "id_master")
    private int id_master;

    @Column(name = "n_tentativi")
    private int n_tentativi;

    @Column(name = "pos_esatta")
    private int pos_esatta;

    @Column(name = "num_esatto")
    private int num_esatto;

    @Column(name = "valori_inseriti")
    private String valori_inseriti;

    @Column(name = "data_operazione")
    private String dataOperazione;

    public int getId_master() {
        return id_master;
    }

    public void setId_master(int id_master) {
        this.id_master = id_master;
    }

    public TryModel() {
    }

    public TryModel(int id_user, int id_master, int n_tentativi, int pos_esatta, int num_esatto, String valori_inseriti, String dataOperazione) {
        this.id_user = id_user;
        this.id_master = id_master;
        this.n_tentativi = n_tentativi;
        this.pos_esatta = pos_esatta;
        this.num_esatto = num_esatto;
        this.valori_inseriti = valori_inseriti;
        this.dataOperazione = dataOperazione;
    }

    public int getId_try() {
        return id_try;
    }

    public void setId_try(int id_try) {
        this.id_try = id_try;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getN_tentativi() {
        return n_tentativi;
    }

    public void setN_tentativi(int n_tentativi) {
        this.n_tentativi = n_tentativi;
    }

    public int getPos_esatta() {
        return pos_esatta;
    }

    public void setPos_esatta(int pos_esatta) {
        this.pos_esatta = pos_esatta;
    }

    public int getNum_esatto() {
        return num_esatto;
    }

    public void setNum_esatto(int num_esatto) {
        this.num_esatto = num_esatto;
    }

    public String getValori_inseriti() {
        return valori_inseriti;
    }

    public void setValori_inseriti(String valori_inseriti) {
        this.valori_inseriti = valori_inseriti;
    }

    public String getDataOperazione() {
        return dataOperazione;
    }

    public void setDataOperazione(String dataOperazione) {
        this.dataOperazione = dataOperazione;
    }

    @Override
    public String toString() {
        return "TryModel{" +
                "id_try=" + id_try +
                ", id_user=" + id_user +
                ", id_master=" + id_master +
                ", n_tentativi=" + n_tentativi +
                ", pos_esatta=" + pos_esatta +
                ", num_esatto=" + num_esatto +
                ", valori_inseriti='" + valori_inseriti + '\'' +
                ", dataOperazione='" + dataOperazione + '\'' +
                '}';
    }
}

