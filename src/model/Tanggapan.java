package model;

import java.util.Date;

public class Tanggapan {
    private int kode_pengguna;
    private int id_customer_service;
    private Date tanggal_tanggapan;
    private String kategori_tanggapan;
    private String isi_tanggapan;

    public int getKode_pengguna() {
        return kode_pengguna;
    }

    public void setKode_pengguna(int kode_pengguna) {
        this.kode_pengguna = kode_pengguna;
    }

    public int getId_customer_service() {
        return id_customer_service;
    }

    public void setId_customer_service(int id_customer_service) {
        this.id_customer_service = id_customer_service;
    }

    public Date getTanggal_tanggapan() {
        return tanggal_tanggapan;
    }

    public void setTanggal_tanggapan(Date tanggal_tanggapan) {
        this.tanggal_tanggapan = tanggal_tanggapan;
    }

    public String getKategori_tanggapan() {
        return kategori_tanggapan;
    }

    public void setKategori_tanggapan(String kategori_tanggapan) {
        this.kategori_tanggapan = kategori_tanggapan;
    }

    public String getIsi_tanggapan() {
        return isi_tanggapan;
    }

    public void setIsi_tanggapan(String isi_tanggapan) {
        this.isi_tanggapan = isi_tanggapan;
    }
}
