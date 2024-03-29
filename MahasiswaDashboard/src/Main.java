import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.*;

public class Main {

    // Deklarasi variabel-variabel yang akan digunakan
    static Scanner scan = new Scanner(System.in);
    private static List<Mahasiswa> daftarMahasiswa;


    public static void main(String[] args) {

        // Inisialisasi daftarMahasiswa sebagai ArrayList kosong
        daftarMahasiswa = new ArrayList<>();

        while (true) {
            String NIM;
            String Nama;
            int tahunLahir;

            // Menampilkan menu kepada pengguna
            System.out.println("Menu:");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Tampilkan Daftar Mahasiswa");
            System.out.println("3. Hapus Mahasiswa");
            System.out.println("4. Perbarui Informasi Mahasiswa");
            System.out.println("5. Keluar");
            System.out.print(">> ");

            // Menerima pilihan menu dari pengguna
            int chooseMenu = Integer.parseInt(scan.nextLine());

            // Menangani pilihan menu
            switch (chooseMenu) {
                case 1:
                    // Pilihan untuk menambahkan mahasiswa

                    System.out.print("Masukkan NIM: ");
                    NIM = scan.nextLine();
                    System.out.print("Masukkan Nama: ");
                    Nama = scan.nextLine();
                    System.out.print("Masukkan Tahun Lahir: ");
                    tahunLahir = Integer.parseInt(scan.nextLine());

                    Mahasiswa mahasiswa = new Mahasiswa(NIM, Nama, tahunLahir);
                    addMahasiswa(mahasiswa);
                    break;

                case 2:
                    // Pilihan untuk menampilkan daftar mahasiswa

                    List<Mahasiswa> daftar = viewMahasiswa();

                    System.out.println("Daftar Mahasiswa");
                    System.out.println("================");
                    for (Mahasiswa m : daftar) {
                        System.out.println(m);
                    }
                    break;

                case 3:
                    // Pilihan untuk menghapus mahasiswa

                    System.out.print("Masukkan NIM mahasiswa yang akan dihapus: ");
                    String nimHapus = scan.nextLine();

                    deleteMahasiswa(nimHapus);
                    break;

                case 4:
                    // Pilihan untuk memperbarui informasi mahasiswa

                    System.out.print("Masukkan NIM: ");
                    NIM = scan.nextLine();
                    System.out.print("Masukkan Nama: ");
                    Nama = scan.nextLine();
                    System.out.print("Masukkan Tahun Lahir: ");
                    tahunLahir = Integer.parseInt(scan.nextLine());

                    Mahasiswa mahasiswaBaru = new Mahasiswa(NIM, Nama, tahunLahir);
                    updateMahasiswa(NIM, mahasiswaBaru);
                    break;

                case 5:
                    // Pilihan untuk keluar dari program

                    System.out.println("Keluar dari program");
                    System.exit(0);
                default:
                    System.out.println("Menu tidak sesuai");
            }
        }
    }


    // Metode untuk menambahkan mahasiswa ke daftar
    public static void addMahasiswa(Mahasiswa mahasiswa) {
        daftarMahasiswa.add(mahasiswa);
    }

    // Metode untuk melihat daftar mahasiswa
    public static List<Mahasiswa> viewMahasiswa() {
        return daftarMahasiswa;
    }

    // Metode untuk menghapus mahasiswa berdasarkan NIM
    public static void deleteMahasiswa(String nim) {
        daftarMahasiswa.removeIf(m -> m.getNIM().equals(nim));
    }

    // Metode untuk memperbarui informasi mahasiswa berdasarkan NIM
    public static void updateMahasiswa(String nim, Mahasiswa mahasiswaBaru) {
        for (int i = 0; i < daftarMahasiswa.size(); i++) {
            Mahasiswa m = daftarMahasiswa.get(i);
            if (m.getNIM().equals(nim)) {
                daftarMahasiswa.set(i, mahasiswaBaru);
                break;
            }
        }
    }

}
