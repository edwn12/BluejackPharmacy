package com.example.projectmcs;

public class TransSG {
    String namaObat;
    String hargaObat;
    String tanggal;
    String quantity;

    public String getNamaObat() {
        return namaObat;
    }

    public void setNamaObat(String namaObat) {
        this.namaObat = namaObat;
    }

    public String getHargaObat() {
        return hargaObat;
    }

    public void setHargaObat(String hargaObat) {
        this.hargaObat = hargaObat;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public int getGambarObat() {
        return gambarObat;
    }

    public void setGambarObat(int gambarObat) {
        this.gambarObat = gambarObat;
    }

    public TransSG(String namaObat, String hargaObat, String tanggal, String quantity, int gambarObat) {
        this.namaObat = namaObat;
        this.hargaObat = hargaObat;
        this.tanggal = tanggal;
        this.quantity = quantity;
        this.gambarObat = gambarObat;
    }

    int gambarObat;
}
