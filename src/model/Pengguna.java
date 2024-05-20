package model;

import java.util.Date;

public class Pengguna {
    private String id_pengguna;
    private String nama_penguna;
    private Date tgl_lahir_pengguna;
    private String jenis_kelamin_pengguna;
    private String nmr_telepon_pengguna;
    private String email_pengguna;
    private String alamat_pengguna;

    public String getId_pengguna() {
        return id_pengguna;
    }

    public void setId_pengguna(String id_pengguna) {
        this.id_pengguna = id_pengguna;
    }

    public String getNama_penguna() {
        return nama_penguna;
    }

    public void setNama_penguna(String nama_penguna) {
        this.nama_penguna = nama_penguna;
    }

    public Date getTgl_lahir_pengguna() {
        return tgl_lahir_pengguna;
    }

    public void setTgl_lahir_pengguna(Date tgl_lahir_pengguna) {
        this.tgl_lahir_pengguna = tgl_lahir_pengguna;
    }

    public String getJenis_kelamin_pengguna() {
        return jenis_kelamin_pengguna;
    }

    public void setJenis_kelamin_pengguna(String jenis_kelamin_pengguna) {
        this.jenis_kelamin_pengguna = jenis_kelamin_pengguna;
    }

    public String getNmr_telepon_pengguna() {
        return nmr_telepon_pengguna;
    }

    public void setNmr_telepon_pengguna(String nmr_telepon_pengguna) {
        this.nmr_telepon_pengguna = nmr_telepon_pengguna;
    }

    public String getEmail_pengguna() {
        return email_pengguna;
    }

    public void setEmail_pengguna(String email_pengguna) {
        this.email_pengguna = email_pengguna;
    }

    public String getAlamat_pengguna() {
        return alamat_pengguna;
    }

    public void setAlamat_pengguna(String alamat_pengguna) {
        this.alamat_pengguna = alamat_pengguna;
    }
}
