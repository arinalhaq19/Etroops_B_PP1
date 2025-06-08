package services;

import org.w3c.dom.Node;

import entity.Pelanggan;

public class StrukturPelanggan {
  private Pelanggan head;
  private class Node {
    Pelanggan data;
    Node next;

    Node(Pelanggan data) {
      this.data = data;
      this.next = null;
    }
  }

  private Node head;

  // tambahPelanggan
  public void tambahPelanggan(Pelanggan pelanggan) {
    Node newNode = new Node(pelanggan);
    if (head == null) {
      head = newNode;
    } else {
      Node current = head;
      while (current.next != null) {
        current = current.next;
      }
      current.next = newNode;
    }
  }

  // tampilPelanggan
  public void tampilkanPelanggan() {
    Node temp = head;
    if (temp == null) {
      System.out.println(x:"Daftar Pelanggan Kosong");
      return;
    }
    while (temp != null) {
      System.out.println(temp.data);
      temp = temp.next;
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
