import java.time.LocalDate;
import java.util.Scanner;
import entity.Pelanggan;
import services.StrukturPelanggan;
import util.Validasi;
public class Main {
    public static void main(String[] args) {
        StrukturPelanggan daftar = new StrukturPelanggan();
        Scanner input = new Scanner(System.in);
        int pilihan = 0;

        do {
            System.out.println("\n=== MENU MANAJEMEN PELANGGAN ===");
            System.out.println("1. Tambah Data Pelanggan");
            System.out.println("2. Tampilkan Semua Pelanggan");
            System.out.println("3. Cari Pelanggan");
            System.out.println("4. Edit Data Pelanggan");
            System.out.println("5. Hapus Data Pelanggan");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");

            if (input.hasNextInt()) {
                pilihan = input.nextInt();
                input.nextLine(); // membersihkan enter
            } else {
                System.out.println("Input tidak valid! Masukkan angka.");
                input.nextLine(); // buang input yang salah
                continue; // ulangi loop
            }

            switch (pilihan) {
                case 1 -> {
                    System.out.print("ID Pelanggan: ");
                    if (!input.hasNextInt()) {
                        System.out.println("ID harus berupa angka.");
                        input.nextLine(); // buang input salah
                        break;
                    }
                    int id = input.nextInt();
                    input.nextLine();
                if (!Validasi.validasiID(id)) {
                    System.out.println("ID harus bilangan positif (lebih dari 0).");
                    break;
                }


                    if (daftar.cekDuplikatID(id)) {
                        System.out.println("ID sudah digunakan. Gunakan ID lain.");
                        break;
                    }

                    System.out.print("Nama: ");
                    String nama = input.nextLine();

                    System.out.print("Alamat: ");
                    String alamat = input.nextLine();

                    System.out.print("Nomor Telepon: ");
                    String telp = input.nextLine();

                    if (!Validasi.validasiTelepon(telp)) {
                        System.out.println("Nomor telepon harus berupa angka dan minimal 10 digit.");
                        break;
                    }

                  System.out.print("Level Member Pelanggan (GOLD/SILVER/BRONZE): ");
                    String member = input.nextLine();

                    if (!Validasi.validasimember(member)) {
                        System.out.println("Level Member tidak valid. Harus: GOLD/SILVER/BRONZE.");
                        break;
                    }

// Tambahkan pelanggan berdasarkan level
                    Pelanggan baru = new Pelanggan(id, nama, alamat, telp, LocalDate.now(), member);
                    daftar.tambahPelanggan(baru);
                    System.out.println("Pelanggan berhasil ditambahkan.");
                }
                case 2 -> daftar.tampilkanPelanggan();
                case 3 -> {
                    System.out.print("Masukkan ID Pelanggan yang ingin dicari: ");
                    if (!input.hasNextInt()) {
                        System.out.println("ID harus berupa angka.");
                        input.nextLine(); 
                        break;
                    }
                    int idCari = input.nextInt();
                    input.nextLine();

                    Pelanggan hasil = daftar.cariPelanggan(idCari);
                    if (hasil != null) {
                        System.out.println("Pelanggan ditemukan: " + hasil);
                    } else {
                        System.out.println("Pelanggan dengan ID " + idCari + " tidak ditemukan.");
                    }
                }
                case 4 -> {
                    System.out.print("Masukkan ID Pelanggan : ");
                    if (!input.hasNextInt()) {
                        System.out.println("ID harus berupa angka.");
                        input.nextLine(); 
                        break;
                    }
                    int id = input.nextInt();
                    input.nextLine();

                    if (!Validasi.validasiID(id)) {
                        System.out.println("ID harus berupa angka.");
                        break;
                    }

                    System.out.print("Nama baru : ");
                    String nama = input.nextLine();

                    System.out.print("Alamat baru : ");
                    String alamat = input.nextLine();

                    System.out.print("Nomor Telepon baru : ");
                    String telp = input.nextLine();

                    if (!telp.isEmpty() && !Validasi.validasiTelepon(telp)) {
                        System.out.println("Nomor telepon harus berupa angka dan minimal 10 digit.");
                        break;
                    }

                    System.out.print("member Pelanggan baru (GOLD/SILVER/BRONZE) : ");
                    String member = input.nextLine();

                    if (!member.isEmpty() && !Validasi.validasimember(member)) {
                        System.out.println("member pelanggan harus 'GOLD,SILVER,BRONZE.");
                        break;
                    }

                    daftar.editPelanggan(id, nama.isEmpty() ? null : nama, alamat.isEmpty() ? null : alamat, 
                                         telp.isEmpty() ? null : telp, member.isEmpty() ? null : member);
                }
                case 5 -> {
                    System.out.print("Hapus pelanggan berdasarkan levelMember (GOLD/SILVER/BRONZE): ");
                    String memberHapus = input.nextLine();
                
                    if (!Validasi.validasimember(memberHapus)) {
                        System.out.println("Level Member harus GOLD/SILVER/BRONZE.");
                        break;
                    }
                
                    System.out.print("Masukkan ID pelanggan yang akan dihapus: ");
                    if (!input.hasNextInt()) {
                        System.out.println("ID harus berupa angka.");
                        input.nextLine(); // buang input yang salah
                        break;
                    }
                    int idHapus = input.nextInt();
                    input.nextLine();
                
                    switch (memberHapus.toUpperCase()) {
                        case "GOLD" -> daftar.removeHead(idHapus);
                        case "SILVER" -> daftar.removeMid(idHapus);
                        case "BRONZE" -> daftar.removeTail(idHapus);
                        default -> System.out.println("Level Member tidak dikenal.");
                    }
               }


                case 6 -> System.out.println("Keluar dari program.");
                default -> System.out.println("Pilihan tidak valid.");
            }

        } while (pilihan != 6);
    }
}
