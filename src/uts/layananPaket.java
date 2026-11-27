package uts;

public class layananPaket extends layanan {
    private String fasilitasTambahan;

    public layananPaket(String namaLayanan, double harga,
                        int durasi, String fasilitasTambahan) {
        super(namaLayanan, harga, durasi);
        this.fasilitasTambahan = fasilitasTambahan;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Fasilitas: " + fasilitasTambahan);
    }
}
