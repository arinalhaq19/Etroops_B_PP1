package services;

import org.w3c.dom.Node;

import entity.Pelanggan;

public class StrukturPelanggan {
    private Pelanggan head;

    private boolean isEmpty() {
      return head == null;
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
    public void addMid(Pelanggan data, int posisi) {
      if (isEmpty() || posisi <= 1) {
          addHead(data);
          return;
      }

      Pelanggan temp = head;
      for (int i = 1; temp != null && i < posisi - 1; i++) {
          temp = temp.getNext();
      }

      if (temp == null || temp.getNext() == null) {
          addTail(data);
      } else {
          data.setNext(temp.getNext());
          temp.setNext(data);
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
  
}
