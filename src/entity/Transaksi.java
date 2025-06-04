package entity;

import java.time.LocalDate;

public class Transaksi {
    private int idTransaksi;
    private int idPelanggan;
    private LocalDate tanggal;
    private double totalPembelian;
    private String metodePembayaran;

    //Konstruktor
    public Transaksi(int idTransaksi, int idPelanggan, LocalDate tanggal, double totalPembelian, String metodePembayaran) {
        setIdTransaksi(idTransaksi);
        setIdPelanggan(idPelanggan);
        setTanggal(tanggal);
        setTotalPembelian(totalPembelian);
        setMetodePembayaran(metodePembayaran);
    }

    // Setter & Getter
    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }
     public int getIdTransaksi() {
        return idTransaksi;
    }
    public void setIdPelanggan(int idPelanggan) {
        this.idPelanggan = idPelanggan;
    }
    public int getIdPelanggan() {
        return idPelanggan;
    }
    public void setTanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
    }
     public LocalDate getTanggal() {
        return tanggal;
    }
    public void setTotalPembelian(double totalPembelian) {
        this.totalPembelian = totalPembelian;
    }
    public double getTotalPembelian() {
        return totalPembelian;
    }
    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }
     public String getMetodePembayaran() {
        return metodePembayaran;
    }

}

