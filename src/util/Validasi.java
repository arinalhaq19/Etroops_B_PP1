package util;

public class Validasi {
    // Validasi ID harus angka positif
    public static boolean validasiID(int id) {
        return id > 0;
        
    }

    // Validasi nomor telepon: minimal 10 digit dan hanya angka
    public static boolean validasiTelepon(String telp) {
        return telp != null && telp.matches("\\d{10,}");
    }
}
