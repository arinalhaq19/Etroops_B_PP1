package services;

import entity.Pelanggan;

public class DaftarPelanggan {
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
}
