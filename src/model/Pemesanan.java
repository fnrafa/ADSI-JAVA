package model;

import java.util.Date;

public class Pemesanan {
    private String id_pemesanan;
    private String id_pengguna;
    private Date tgl_pemesanan;
    private int jumlah_pemesanan;
    private String status_pemesanan;

    public String getId_pemesanan() {
        return id_pemesanan;
    }

    public void setId_pemesanan(String id_pemesanan) {
        this.id_pemesanan = id_pemesanan;
    }

    public String getId_pengguna() {
        return id_pengguna;
    }

    public void setId_pengguna(String id_pengguna) {
        this.id_pengguna = id_pengguna;
    }

    public Date getTgl_pemesanan() {
        return tgl_pemesanan;
    }

    public void setTgl_pemesanan(Date tgl_pemesanan) {
        this.tgl_pemesanan = tgl_pemesanan;
    }

    public int getJumlah_pemesanan() {
        return jumlah_pemesanan;
    }

    public void setJumlah_pemesanan(int jumlah_pemesanan) {
        this.jumlah_pemesanan = jumlah_pemesanan;
    }

    public String getStatus_pemesanan() {
        return status_pemesanan;
    }

    public void setStatus_pemesanan(String status_pemesanan) {
        this.status_pemesanan = status_pemesanan;
    }
}
