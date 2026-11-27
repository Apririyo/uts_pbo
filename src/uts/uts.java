package uts;

import java.util.ArrayList;
import java.util.Scanner;

public class uts {

    static Scanner input = new Scanner(System.in);
    static ArrayList<layanan> daftarLayanan = new ArrayList<>();
    static ArrayList<transaksi> daftarTransaksi = new ArrayList<>();

    public static void main(String[] args) {
        isiLayanan();

        int pilihan;

        do {
            System.out.println("\n==============================");
            System.out.println("       POS BARBERSHOP");
            System.out.println("==============================");
            System.out.println("1. Data Layanan");
            System.out.println("2. Transaksi Pelanggan");
            System.out.println("3. Riwayat Transaksi");
            System.out.println("4. Laporan Pendapatan");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            pilihan = bacaInt();

            switch (pilihan) {
                case 1:
                    tampilkanLayanan();
                    break;
                case 2:
                    transaksiPelanggan();
                    break;
                case 3:
                    riwayatTransaksi();
                    break;
                case 4:
                    laporanPendapatan();
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia.");
            }

        } while (pilihan != 0);
    }

    static void isiLayanan() {
        daftarLayanan.add(
            new layanan("Potong Rambut", 15000, 30)
        );
        daftarLayanan.add(
            new layanan("Keramas", 10000, 15)
        );
        daftarLayanan.add(
            new layanan("Cukur Jenggot", 8000, 15)
        );
        daftarLayanan.add(
            new layananPaket(
                "Paket Lengkap", 22000, 45,
                "Potong Rambut + Keramas"
            )
        );
    }

    static void tampilkanLayanan() {
        System.out.println("\n======= DAFTAR LAYANAN =======");

        for (int i = 0; i < daftarLayanan.size(); i++) {
            System.out.print((i + 1) + ". ");
            daftarLayanan.get(i).tampilkanInfo();
        }
    }

    static void transaksiPelanggan() {
        tampilkanLayanan();

        System.out.print("\nNama pelanggan: ");
        String nama = input.nextLine();

        if (nama.trim().isEmpty()) {
            System.out.println("Nama pelanggan tidak boleh kosong.");
            return;
        }

        System.out.print("Pilih nomor layanan: ");
        int nomor = bacaInt();

        if (nomor < 1 || nomor > daftarLayanan.size()) {
            System.out.println("Nomor layanan tidak valid.");
            return;
        }

        layanan layanan = daftarLayanan.get(nomor - 1);

        System.out.print("Jumlah layanan: ");
        int jumlah = bacaInt();

        if (jumlah <= 0) {
            System.out.println("Jumlah harus lebih dari 0.");
            return;
        }

        double total = layanan.hitungTotal(jumlah);

        System.out.println("Total pembayaran: Rp" + total);
        System.out.print("Uang pembayaran: Rp");
        double bayar = bacaDouble();

        if (bayar < total) {
            System.out.println("Uang pembayaran kurang.");
            return;
        }

        pelanggan pelanggan = new pelanggan(nama);

        transaksi transaksi = new transaksi(
            pelanggan, layanan, jumlah, bayar
        );

        daftarTransaksi.add(transaksi);

        transaksi.tampilkanNota();
        System.out.println("Transaksi berhasil disimpan!");
    }

    static void riwayatTransaksi() {
        System.out.println("\n======= RIWAYAT TRANSAKSI =======");

        if (daftarTransaksi.isEmpty()) {
            System.out.println("Belum ada transaksi.");
            return;
        }

        for (transaksi transaksi : daftarTransaksi) {
            transaksi.tampilkanNota();
        }
    }

    static void laporanPendapatan() {
        double pendapatan = 0;

        for (transaksi transaksi : daftarTransaksi) {
            pendapatan += transaksi.getTotal();
        }

        System.out.println("\n======= LAPORAN PENJUALAN =======");
        System.out.println("Jumlah transaksi: "
                + daftarTransaksi.size());
        System.out.println("Total pendapatan: Rp" + pendapatan);
    }

    static int bacaInt() {
        try {
            return Integer.parseInt(input.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    static double bacaDouble() {
        try {
            return Double.parseDouble(input.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}