package model;

import java.util.Date;

public class Feedback {
    private int kode_pengguna;
    private String id_pengguna;
    private Date tanggal_feedback;
    private String kategori_feedback;
    private String isi_feedback;

    public int getKode_pengguna() {
        return kode_pengguna;
    }

    public void setKode_pengguna(int kode_pengguna) {
        this.kode_pengguna = kode_pengguna;
    }

    public String getId_pengguna() {
        return id_pengguna;
    }

    public void setId_pengguna(String id_pengguna) {
        this.id_pengguna = id_pengguna;
    }

    public Date getTanggal_feedback() {
        return tanggal_feedback;
    }

    public void setTanggal_feedback(Date tanggal_feedback) {
        this.tanggal_feedback = tanggal_feedback;
    }

    public String getKategori_feedback() {
        return kategori_feedback;
    }

    public void setKategori_feedback(String kategori_feedback) {
        this.kategori_feedback = kategori_feedback;
    }

    public String getIsi_feedback() {
        return isi_feedback;
    }

    public void setIsi_feedback(String isi_feedback) {
        this.isi_feedback = isi_feedback;
    }
}
