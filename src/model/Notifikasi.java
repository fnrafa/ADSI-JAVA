package model;

import java.util.Date;

public class Notifikasi {
    private int id_notifikasi;
    private String id_pengguna;
    private String isi_notifikasi;
    private Date waktu_pengiriman;

    public int getId_notifikasi() {
        return id_notifikasi;
    }

    public void setId_notifikasi(int id_notifikasi) {
        this.id_notifikasi = id_notifikasi;
    }

    public String getId_pengguna() {
        return id_pengguna;
    }

    public void setId_pengguna(String id_pengguna) {
        this.id_pengguna = id_pengguna;
    }

    public String getIsi_notifikasi() {
        return isi_notifikasi;
    }

    public void setIsi_notifikasi(String isi_notifikasi) {
        this.isi_notifikasi = isi_notifikasi;
    }

    public Date getWaktu_pengiriman() {
        return waktu_pengiriman;
    }

    public void setWaktu_pengiriman(Date waktu_pengiriman) {
        this.waktu_pengiriman = waktu_pengiriman;
    }
}
