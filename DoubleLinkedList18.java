public class DoubleLinkedList18 {
    Node18 head;
    Node18 tail;

    public DoubleLinkedList18() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(Mahasiswa18 data) {
        Node18 newNode = new Node18(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addLast(Mahasiswa18 data) {
        Node18 newNode = new Node18(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void insertArt(String keyNim, Mahasiswa18 data) {
        Node18 current = head;

        // Cari node dengan nim = keyNim
        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node dengan NIM " + keyNim + " tidak ditemukan.");
            return;
        }

        Node18 newNode = new Node18(data);

        // Jika current adalah taail, cukup tambahkan di akhir
        if (current == tail) {
            current.next = newNode;
            newNode.prev = current;
            tail = newNode;
        } else {
            // Sisipkan di tengah
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }

        System.out.println("Node berhasil disipkan setelah NIM " + keyNim);
    }

     public void removeFirst() {
        if (isEmpty()) {
            System.out.println("List kodong, tidak bisa dihapus");
            return;
        } 
        Mahasiswa18 mhsDihapus = head.data; // simpan data sebelum dihapus

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        System.out.println("Data sudah berhasil dihapus. Data yang terhapus adalah:");
        mhsDihapus.tampil();
    }

     public void removeLast() {
        if (isEmpty()) {
            System.out.println("List kosong, tidak bisa di hapus.");
            return;
        } 
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }


    public void print() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong.");
            return;
        }
        System.out.println("Isi Linked List:");
        Node18 current = head;
        while (current != null) {
            current.data.tampil();
            current = current.next;
        }
    }

    public Node18 search(String nim) {
        Node18 current = head;
        while (current != null) {
            if (current.data.nim.equals(nim)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void add(int index, Mahasiswa18 data) {
        if (index < 0) {
            System.out.println("Indeks tidak valid.");
            return;
        }

        if (index == 0) {
            addFirst(data);
            return;
        }

        Node18 current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null) {
                System.out.println("Indeks melebihi jumlah node.");
                return;
            }
            current = current.next;
        }

        if (current == tail) {
            addLast(data);
            return;
        }

        Node18 newNode = new Node18(data);
        newNode.next = current.next;
        newNode.prev = current;
        current.next.prev = newNode;
        current.next = newNode;

        System.out.println("Data berhasil ditambahkan pada indeks ke-" + index);
    }

    public void removeAfter(String keyNim) {
        Node18 current = head;

        // Cari node dengan NIM yang sesuai
        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }

        if (current == null || current.next == null) {
            System.out.println("Tidak bisa menghapus. NIM tidak ditemukan atau tidak ada node setelahnya.");
            return;
        }

        Node18 nodeDihapus = current.next;

        // Hapus node setelah current
        current.next = nodeDihapus.next;

        if (nodeDihapus.next != null) {
            nodeDihapus.next.prev = current;
        } else {
            tail = current;
        }

        System.out.println("Berhasil menghapus node setelah NIM " + keyNim + ":");
        nodeDihapus.data.tampil();
    }    

    public void remove(int index) {
        if (isEmpty()) {
            System.out.println("List kosong, tidak bisa dihapus.");
            return;
        }

        if (index < 0) {
            System.out.println("Indeks tidak valid.");
            return;
        }

        if (index == 0) {
            removeFirst();
            return;
        }

        Node18 current = head;
        int i = 0;

        // Cari node di posisi index
        while (current != null && i < index) {
            current = current.next;
            i++;
        }

        if (current == null) {
            System.out.println("Indeks melebihi jumlah node.");
            return;
        }

        // Hapus node di tengah atau akhir
        if (current == tail) {
            removeLast();
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
            System.out.println("Node pada indeks ke-" + index + " berhasil dihapus:");
            current.data.tampil();
        }
    }

    public void getFirst() {
        if (isEmpty()) {
            System.out.println("List kosong.");
        } else {
            System.out.println("Data pada node pertama:");
            head.data.tampil();
        }
    }

    public void getLast() {
        if (isEmpty()) {
            System.out.println("List kosong.");
        } else {
            System.out.println("Data pada node terakhir:");
            tail.data.tampil();
        }
    }

    public void getIndex(int index) {
        if (isEmpty()) {
            System.out.println("List kosong.");
            return;
        }

        if (index < 0) {
            System.out.println("Indeks tidak valid.");
            return;
        }

        Node18 current = head;
        int i = 0;

        while (current != null && i < index) {
            current = current.next;
            i++;
        }

        if (current == null) {
            System.out.println("Indeks melebihi jumlah node.");
        } else {
            System.out.println("Data pada indeks ke-" + index + ":");
            current.data.tampil();
        }
    }

    public int size() {
        int count = 0;
        Node18 current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

}
