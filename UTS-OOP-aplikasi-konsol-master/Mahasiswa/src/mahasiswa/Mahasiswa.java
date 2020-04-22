/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahasiswa;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Hafizh Umar Syafiqh
 */
public class Mahasiswa {

    /**
     * @param args the command line arguments
     */
    public void printMenu() {
        Scanner Dimas = new Scanner(System.in);
        System.out.println("------------------------------------");
        System.out.println("Pendaftaran Mahasiswa Baru 2019-2020");
        System.out.println("------------------------------------");
        System.out.println("1. Tambah Data" + "\n2. Ubah Data" + "\n3. Hapus Data" + "\n4. Lihat Data" + "\n5. Keluar");
        System.out.print("Pilihan: ");
    }

    public void hapusData() {
        Scanner Dimas = new Scanner(System.in);
        System.out.print("Urutan data yang dihapus: ");
        int idx = Integer.parseInt(Dimas.nextLine());
        // proses hapus data
        Operasi.removeData(idx - 1);
    }

    public void ubahData() {
        Scanner Dimas = new Scanner(System.in);
        System.out.println();
        System.out.print("Urutan data yang diubah: ");
        int idx = Integer.parseInt(Dimas.nextLine());
        System.out.println("--------------------------");
        System.out.print("Nim       : ");
        String nim = Dimas.nextLine();
        System.out.print("Nama      : ");
        String nama = Dimas.nextLine();
        System.out.print("Prodi     : ");
        String prodi = Dimas.nextLine();
        System.out.print("alamat    : ");
        String alamat = Dimas.nextLine();
        // proses ubah data
        Operasi.editData(new Data(nim, nama, prodi, alamat), idx - 1);
    }

    public void listData() {
        List<Data> result = Operasi.getListData();
        for (int i = 0; i < result.size(); i++) {
            System.out.println();
            System.out.println("Data ke-" + (i + 1));
            System.out.println("  Nim       : " + result.get(i).getnim());
            System.out.println("  Nama      : " + result.get(i).getnama());
            System.out.println("  prodi     : " + result.get(i).getprodi());
            System.out.println("  Alamat    : " + result.get(i).getalamat());
        }
    }

    public void addData() {
        Scanner Dimas = new Scanner(System.in);
        System.out.println();
        System.out.print("Nim : ");
        String nim = Dimas.nextLine();
        System.out.print("Nama : ");
        String nama = Dimas.nextLine();
        System.out.print("prodi : ");
        String prodi = Dimas.nextLine();
        System.out.print("Alamat : ");
        String alamat = Dimas.nextLine();
        // proses tambah data
        Operasi.addData(new Data(nim, nama, prodi, alamat));
    }

    public static void main(String[] args) {
        Scanner Dimas = new Scanner(System.in);
        Mahasiswa app = new Mahasiswa();
        while (true) {
            app.printMenu();
            int pilihan = Dimas.nextInt();
            switch (pilihan) {
                case 1:
                    System.out.println("Formulir Tambah Data");
                    app.addData();
                    break;
                case 2:
                    System.out.println("Daftar Data");
                    app.listData();
                    System.out.println("Formulir Ubah Data");
                    app.ubahData();
                    break;
                case 3:
                    System.out.println("Daftar Data");
                    app.listData();
                    System.out.println("Formulir Hapus Data");
                    app.hapusData();
                    break;
                case 4:
                    System.out.println("Daftar Data");
                    app.listData();
                    break;
                case 5:
                    System.out.println("\nApakah Anda iIngin Melanjutkan Pendaftaran ?");
                    System.out.println("1.Ya \t2.Tidak");
                    char persetuju = Dimas.next().charAt(0);
                    if (persetuju == '1') {
                        app.printMenu();
//                        pilihan = Dimas.nextInt();

                    } else if (persetuju == '2') {
                        System.out.println("Terimaksih Telah Keluar di dalam");
                        System.exit(0);
                    }
            }
        }
    }
}
