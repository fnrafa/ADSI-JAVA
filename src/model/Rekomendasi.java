package model;

import java.util.Date;

public class Rekomendasi {
    private String id_rekomendasi;
    private String id_pengguna;
    private String preferensi_makanan;
    private Date tgl_pemesanan;
    private String nama_katering;

    public String getId_rekomendasi() {
        return id_rekomendasi;
    }

    public void setId_rekomendasi(String id_rekomendasi) {
        this.id_rekomendasi = id_rekomendasi;
    }

    public String getId_pengguna() {
        return id_pengguna;
    }

    public void setId_pengguna(String id_pengguna) {
        this.id_pengguna = id_pengguna;
    }

    public String getPreferensi_makanan() {
        return preferensi_makanan;
    }

    public void setPreferensi_makanan(String preferensi_makanan) {
        this.preferensi_makanan = preferensi_makanan;
    }

    public Date getTgl_pemesanan() {
        return tgl_pemesanan;
    }

    public void setTgl_pemesanan(Date tgl_pemesanan) {
        this.tgl_pemesanan = tgl_pemesanan;
    }

    public String getNama_katering() {
        return nama_katering;
    }

    public void setNama_katering(String nama_katering) {
        this.nama_katering = nama_katering;
    }
}
