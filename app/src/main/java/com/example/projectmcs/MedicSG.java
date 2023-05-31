package com.example.projectmcs;

public class MedicSG {
    String namaObat;
    String hargaObat;
    String manufaktur;
    String detailObat;
    int gambarObat;

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

    public String getManufaktur() {
        return manufaktur;
    }

    public void setManufaktur(String manufaktur) {
        this.manufaktur = manufaktur;
    }

    public String getDetailObat() {
        return detailObat;
    }

    public void setDetailObat(String detailObat) {
        this.detailObat = detailObat;
    }

    public int getGambarObat() {
        return gambarObat;
    }

    public void setGambarObat(int gambarObat) {
        this.gambarObat = gambarObat;
    }

    public MedicSG(String namaObat, String hargaObat, String manufaktur, String detailObat, int gambarObat) {
        this.namaObat = namaObat;
        this.hargaObat = hargaObat;
        this.manufaktur = manufaktur;
        this.detailObat = detailObat;
        this.gambarObat = gambarObat;
    }
}


