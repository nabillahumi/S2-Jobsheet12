import java.util.Scanner;

public class DLLMain18 {
    
    public static Mahasiswa18 inputMahasiswa(Scanner scan) {
        System.out.print("Masukkan NIM: ");
        String nim = scan.nextLine();
        System.out.print("Masukkan Nama: ");
        String nama = scan.nextLine();
        System.out.print("Masukkan Kelas: ");
        String kelas = scan.nextLine();
        System.out.print("Masukkan IPK: ");
        double ipk = scan.nextDouble(); scan.nextLine();
        return new Mahasiswa18(nim, nama, kelas, ipk);
    }

    public static void main(String[] args) {
        DoubleLinkedList18 list = new DoubleLinkedList18();
        Scanner sc = new Scanner(System.in);

        int pilihan;

        do { 
            System.out.println("\nMenu Double LInked List Mahasiswa");
            System.out.println("1. Tambah di awal");
            System.out.println("2. Tambah di akhir");
            System.out.println("3. Hapus di awal");
            System.out.println("4. Hapus di akhir");
            System.out.println("5. Tampilkan data");
            System.out.println("6. Cari Mahasiswa berdasarkan NIM");
            System.out.println("7. Tambah setelah NIM tertentu");
            System.out.println("8. Tambahkan data pada index tertentu");
            System.out.println("9. Hapus data setelah key");
            System.out.println("10. Hapus pada index tertentu");
            System.out.println("11. Tampilkan data pertama, terakhir, dan data pd index tertentu");
            System.out.println("12. Tampilkan jumlah data");

            System.out.println("0. Keluar");
            System.out.print("Pilih menu : ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1 -> {
                    Mahasiswa18 mhs = inputMahasiswa(sc);
                    list.addFirst(mhs);
                } 
                case 2 -> {
                    Mahasiswa18 mhs = inputMahasiswa(sc);
                    list.addLast(mhs);
                }
                case 3 -> list.removeFirst();
                case 4 -> list.removeLast();
                case 5 -> list.print();
                case 6 -> {
                    System.out.print("Masukkan NIM yang dicari : ");
                    String nim = sc.nextLine();
                    Node18 found = list.search(nim);
                    if (found != null) {
                        System.out.println("Data ditemukan : ");
                        found.data.tampil();
                    } else {
                        System.out.println("Data tidak ditemukan.");
                    }
                }
                case 7 -> {
                    System.out.print("Masukkan NIM setelah data yang ingin disisipkan: ");
                    String key = sc.nextLine();
                    Mahasiswa18 mhsBaru = inputMahasiswa(sc);
                    list.insertArt(key, mhsBaru);
                }
                case 8 -> {
                    System.out.print("Masukkan indeks yang dituju: ");
                    int idx = sc.nextInt(); sc.nextLine();
                    Mahasiswa18 mhs = inputMahasiswa(sc);
                    list.add(idx, mhs);
                }
                case 9 -> {
                    System.out.print("Masukkan NIM setelah data yang ingin dihapus: ");
                    String key = sc.nextLine();
                    list.removeAfter(key);
                }
                case 10 -> {
                    System.out.print("Masukkan indeks node yang ingin dihapus: ");
                    int idx = sc.nextInt(); sc.nextLine();
                    list.remove(idx);
                }
                case 11 -> {
                    list.getFirst();
                    list.getLast();
                    list.getIndex(2); // menampilkan data di indeks ke-2
                }
                case 12-> {
                    System.out.println("Jumlah data dalam Linked List: " + list.size());
                }
                case 0 -> System.out.println("Keluar dari program.");
                default -> System.out.println("Pilihan tidak valid!");
            }
        } while (true);
    }

}
