package com.example.uangku;

public class Transaksi {
    private int type;
    private int nominal;
    private String judul;
    private String tanggal;

    public Transaksi(int type, int nominal, String judul, String tanggal) {
        this.type = type;
        this.nominal = nominal;
        this.judul = judul;
        this.tanggal = tanggal;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    @Override
    public String toString() {
        return tanggal + " " + nominal+"" + " " + judul;
    }
}
