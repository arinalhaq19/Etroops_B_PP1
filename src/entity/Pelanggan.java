package entity;

import java.time.LocalDate;


public class Pelanggan {
    private int idPelanggan;
    
    private String nama;
    private String alamat;
    private String noTelepon;
    private LocalDate tanggalBergabung;
    private String levelMember;
    private Pelanggan next;


public Pelanggan(int idPelanggan,String nama,String alamat,String noTelepon,LocalDate tanggalBergabung,String levelMember){
    this.idPelanggan = idPelanggan; 
    this.nama = nama;
    this.alamat = alamat;
    this.noTelepon = noTelepon;
    this.tanggalBergabung = tanggalBergabung;
    this.levelMember = levelMember;
    this.next = null;
    }

    // Getter dan Setter
    public int getIdPelanggan() {
        return idPelanggan;
    }       
    
    public void setIdPelanggan(int idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public String getNama() {
        return nama;
    }               

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    public LocalDate getTanggalBergabung() {
        return tanggalBergabung;
    }

    public void setTanggalBergabung(LocalDate tanggalBergabung) {
        this.tanggalBergabung = tanggalBergabung;
    }

    public String getlevelMember() {
        return levelMember;
    }

    public void setlevelMember(String levelMember) {
        this.levelMember = levelMember;
    }

    public Pelanggan getNext() {
        return next;
    }

    public void setNext(Pelanggan next) {
        this.next = next;
    }

@Override
public String toString() {
    return "\nPelanggan\n" +
            "idPelanggan     : " + idPelanggan + "\n" +
            "nama            : " + nama + "\n" +
            "alamat          : " + alamat + "\n" +
            "noTelepon       : " + noTelepon + "\n" +
            "tanggalBergabung: " + tanggalBergabung + "\n" +
            "levelMember     : " + levelMember + "\n";
}

}