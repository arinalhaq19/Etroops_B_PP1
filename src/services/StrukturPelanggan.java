package services;

import entity.Pelanggan;

public class StrukturPelanggan {
    private Pelanggan head;

    private boolean isEmpty() {
      return head == null;
    }

    // Tambah pelanggan berdasarkan level member
    public void tambahPelanggan(Pelanggan data) {
        String level = data.getlevelMember().toUpperCase();

        switch (level) {
            case "GOLD" -> addHead(data);     // Prioritas tinggi
            case "SILVER" -> addMid(data); // Menengah
            case "BRONZE" -> addTail(data);   // Prioritas rendah
            default -> System.out.println("Level member tidak dikenali!");
        }
    }

    // Tambah di awal (GOLD)
    public void addHead(Pelanggan data) {
      data.setNext(head);
      head = data;
    }

    // Tambah di akhir (BRONZE)
    public void addTail(Pelanggan data) {
      if (isEmpty()) {
          head = data;
      } else {
          Pelanggan temp = head;
          while (temp.getNext() != null) {
              temp = temp.getNext();
          }
          temp.setNext(data);
      }
   }

     // Tambah di tengah (SILVER)
   // Tambah di antara GOLD dan BRONZE (khusus SILVER)
    public void addMid(Pelanggan data) {
         if (isEmpty()) {
              head = data;
         return;
    }

    Pelanggan temp = head;
    Pelanggan prev = null;

    // Cari GOLD terakhir
    while (temp != null && temp.getlevelMember().equalsIgnoreCase("GOLD")) {
        prev = temp;
        temp = temp.getNext();
    }

    // Jika tidak ada GOLD, sisipkan di head
    if (prev == null) {
        data.setNext(head);
        head = data;
    } else {
        data.setNext(prev.getNext());
        prev.setNext(data);
    }
}

  

// Hapus Pelanggan GOLD (dari head)
    public void removeHead(int id) {
        if (isEmpty()) {
            System.out.println(" Daftar kosong.");
            return;
        }

        Pelanggan current = head;
        Pelanggan prev = null;

        while (current != null) {
            if (current.getIdPelanggan() == id && current.getlevelMember().equalsIgnoreCase("GOLD")) {
                if (prev == null) {
                    head = current.getNext();
                } else {
                    prev.setNext(current.getNext());
                }
                System.out.println("Pelanggan GOLD dengan ID " + id + " telah dihapus.");
                return;
            }
            prev = current;
            current = current.getNext();
        }

        System.out.println(" Pelanggan GOLD dengan ID " + id + " tidak ditemukan.");
    }


    // Hapus Pelanggan BRONZE (dari tail)
    public void removeTail(int id) {
        if (isEmpty()) {
            System.out.println(" Daftar kosong.");
            return;
        }

        Pelanggan current = head;
        Pelanggan prev = null;

        while (current != null) {
            if (current.getIdPelanggan() == id && current.getlevelMember().equalsIgnoreCase("BRONZE")) {
                if (prev == null) {
                    head = current.getNext();
                } else {
                    prev.setNext(current.getNext());
                }
                System.out.println("Pelanggan BRONZE dengan ID " + id + " telah dihapus.");
                return;
            }
            prev = current;
            current = current.getNext();
        }

        System.out.println(" Pelanggan BRONZE dengan ID " + id + " tidak ditemukan.");
    }
    
    

    // Hapus pelanggan SILVER berdasarkan ID
    public void removeMid(int id) {
        if (isEmpty()) {
            System.out.println(" Daftar kosong.");
            return;
        }

        Pelanggan current = head;
        Pelanggan prev = null;

        while (current != null) {
            if (current.getIdPelanggan() == id && current.getlevelMember().equalsIgnoreCase("SILVER")) {
                if (prev == null) {
                    head = current.getNext();
                } else {
                    prev.setNext(current.getNext());
                }
                System.out.println("Pelanggan SILVER dengan ID " + id + " telah dihapus.");
                return;
            }
            prev = current;
            current = current.getNext();
        }

        System.out.println(" Pelanggan SILVER dengan ID " + id + " tidak ditemukan.");
    }

    //cari pelanggan berdasarkan ID
    public Pelanggan cariPelanggan(int id) {
        Pelanggan temp = head;
        while (temp != null) {
            if (temp.getIdPelanggan() == id) {
                return temp;
            }
            temp = temp.getNext();
        }
        return null; // Jika tidak ditemukan
    }

    // Edit data pelanggan berdasarkan ID
    public void editPelanggan(int id, String nama, String alamat, String noTelepon, String levelMemberBaru) {
        Pelanggan temp = head;
        Pelanggan prev = null;

        while (temp != null) {
            if (temp.getIdPelanggan() == id) {
                // Simpan data lama
                String namaBaru = (nama != null) ? nama : temp.getNama();
                String alamatBaru = (alamat != null) ? alamat : temp.getAlamat();
                String teleponBaru = (noTelepon != null) ? noTelepon : temp.getNoTelepon();
                String levelLama = temp.getlevelMember();
                String levelBaru = (levelMemberBaru != null) ? levelMemberBaru : levelLama;

                // Hapus node lama dari list
                if (prev == null) {
                    head = temp.getNext();
                } else {
                    prev.setNext(temp.getNext());
                }

                // Buat node baru
                Pelanggan baru = new Pelanggan(id, namaBaru, alamatBaru, teleponBaru, temp.getTanggalBergabung(),
                        levelBaru);

                // Tambahkan ulang sesuai level baru
                tambahPelanggan(baru);

                System.out
                        .println(" Data pelanggan dengan ID " + id + " telah diperbarui dan dipindahkan sesuai level.");
                return;
            }
            prev = temp;
            temp = temp.getNext();
        }

        System.out.println(" Pelanggan dengan ID " + id + " tidak ditemukan.");
    }

   
    // Tampilkan semua pelanggan dan total jumlahnya
    public void tampilkanPelanggan() {
if (isEmpty()) {
System.out.println("Daftar pelanggan kosong.");
return;
}

    Pelanggan tempHitung = head;
    int total = 0;
    while (tempHitung != null) {
    total++;
    tempHitung = tempHitung.getNext();
    }

    System.out.println("\n=== Daftar Pelanggan ===");
    System.out.println("Total pelanggan: " + total + "\n");

    Pelanggan temp = head;
    while (temp != null) {
    System.out.println(temp);
    temp = temp.getNext();
    }

}
}