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

    // Validasi member pelanggan (GOLD,SILVER,BRONZE)
    public static boolean validasimember(String member) {
        return member!= null && (member.equalsIgnoreCase("GOLD") || member.equalsIgnoreCase("SILVER") || member.equalsIgnoreCase("BRONZE"));
    }
}
