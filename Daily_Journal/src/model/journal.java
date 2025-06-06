package model;

import java.time.LocalDate;

public class journal {
    private int id;
    private String judul;
    private String isi;
    private byte[] foto;
    private LocalDate tanggal;
    private int user_id;

    public journal(int id, String judul, String isi, byte[] foto, LocalDate tanggal, int user_id) {
        this.id = id;
        this.judul = judul;
        this.isi = isi;
        this.foto = foto;
        this.tanggal = tanggal;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public String getJudul() {
        return judul;
    }

    public String getIsi() {
        return isi;
    }

    public byte[] getFoto() {
        return foto;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }
    
    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public void setTanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
    }
    
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
