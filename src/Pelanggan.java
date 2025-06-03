
public class Pelanggan {
  private int idPelanggan;
    private String nama;
    private String nomorTelepon;  // ubah jadi String agar validasi digit lebih mudah
    private String alamat;

    // Konstruktor
    public Pelanggan(int idPelanggan, String nama, String nomorTelepon, String alamat) {
        setIdPelanggan(idPelanggan);
        setNama(nama);
        setNomorTelepon(nomorTelepon);
        setAlamat(alamat);
    }

    // Getter & Setter
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

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(String nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    

    @Override
    public String toString() {
        return "\n============ Pelanggan ID: " + idPelanggan + " ===========\n" +
               "Nama           : " + nama + "\n" +
               "Nomor Telepon  : " + nomorTelepon + "\n" +
            "Alamat         : " + alamat + "\n";
    }
}

  
