package uts;

public class layanan {
    protected String namaLayanan;
    protected double harga;
    protected int durasi;

    public layanan(String namaLayanan, double harga, int durasi) {
        this.namaLayanan = namaLayanan;
        this.harga = harga;
        this.durasi = durasi;
    }

    public String getNamaLayanan() {
        return namaLayanan;
    }

    public double getHarga() {
        return harga;
    }

    public void tampilkanInfo() {
        System.out.println(namaLayanan + " - Rp"
                + harga + " (" + durasi + " menit)");
    }

    public double hitungTotal(int jumlah) {
        return harga * jumlah;
    }
}
