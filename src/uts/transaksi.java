package uts;

public class transaksi {
    private pelanggan pelanggan;
    private layanan layanan;
    private int jumlah;
    private double total;
    private double bayar;
    private double kembalian;

    public transaksi(pelanggan pelanggan, layanan layanan,
                     int jumlah, double bayar) {
        this.pelanggan = pelanggan;
        this.layanan = layanan;
        this.jumlah = jumlah;
        this.total = layanan.hitungTotal(jumlah);
        this.bayar = bayar;
        this.kembalian = bayar - total;
    }

    public double getTotal() {
        return total;
    }

    public void tampilkanNota() {
        System.out.println("\n======= NOTA BARBERSHOP =======");
        System.out.println("Pelanggan : " + pelanggan.getNama());
        System.out.println("Layanan   : " + layanan.getNamaLayanan());
        System.out.println("Jumlah    : " + jumlah);
        System.out.println("Total     : Rp" + total);
        System.out.println("Bayar     : Rp" + bayar);
        System.out.println("Kembalian : Rp" + kembalian);
        System.out.println("==============================");
    }
}