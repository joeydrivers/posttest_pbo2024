import java.util.ArrayList;
import java.util.Scanner;

class TiketPenumpang {
    private String nama;
    private String tujuan;
    private int umur;
    private String tanggalJamKeberangkatan;

    public TiketPenumpang(String nama, String tujuan, int umur, String tanggalJamKeberangkatan) {
        this.nama = nama;
        this.tujuan = tujuan;
        this.umur = umur;
        this.tanggalJamKeberangkatan = tanggalJamKeberangkatan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getTanggalJamKeberangkatan() {
        return tanggalJamKeberangkatan;
    }

    public void setTanggalJamKeberangkatan(String tanggalJamKeberangkatan) {
        this.tanggalJamKeberangkatan = tanggalJamKeberangkatan;
    }
}

class TiketBiasa extends TiketPenumpang {
    private int harga;

    public TiketBiasa(String nama, String tujuan, int umur, String tanggalJamKeberangkatan, int harga) {
        super(nama, tujuan, umur, tanggalJamKeberangkatan);
        this.harga = harga;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}

class TiketVIP extends TiketPenumpang {
    private String fasilitas;

    public TiketVIP(String nama, String tujuan, int umur, String tanggalJamKeberangkatan, String fasilitas) {
        super(nama, tujuan, umur, tanggalJamKeberangkatan);
        this.fasilitas = fasilitas;
    }

    public String getFasilitas() {
        return fasilitas;
    }

    public void setFasilitas(String fasilitas) {
        this.fasilitas = fasilitas;
    }
}

public class App {

    private static ArrayList<TiketPenumpang> dataPenumpang = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;

        do {
            System.out.println("===== SISTEM PENDATAAN PENUMPANG =====");
            System.out.println("====== PT. DRIVERMUDA PAKINTAKI ======");
            System.out.println("1. Tambah Data Penumpang");
            System.out.println("2. Tampilkan Data Penumpang");
            System.out.println("3. Edit Data Penumpang");
            System.out.println("4. Hapus Data Penumpang");
            System.out.println("5. Exit");
            System.out.print("Pilih menu (1-5): ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    tambahDataPenumpang();
                    break;
                case 2:
                    tampilkanDataPenumpang();
                    break;
                case 3:
                    editDataPenumpang();
                    break;
                case 4:
                    hapusDataPenumpang();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan sistem pendataan tiket penumpang. Sampai jumpa!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih menu yang benar.");
            }
        } while (pilihan != 5);
    }

    private static void tambahDataPenumpang() {
        System.out.print("Masukkan nama penumpang: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan tujuan: ");
        String tujuan = scanner.nextLine();
        System.out.print("Masukkan umur penumpang (TAHUN): ");
        int umur = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan tanggal dan jam keberangkatan: ");
        String tanggalJamKeberangkatan = scanner.nextLine();
        System.out.print("Pilih jenis tiket (1 untuk Tiket Biasa, 2 untuk Tiket VIP): ");
        int jenisTiket = scanner.nextInt();
        scanner.nextLine();

        if (jenisTiket == 1) {
            System.out.print("Masukkan harga tiket biasa: ");
            int hargaBiasa = scanner.nextInt();
            scanner.nextLine();
            TiketBiasa penumpangBaru = new TiketBiasa(nama, tujuan, umur, tanggalJamKeberangkatan, hargaBiasa);
            dataPenumpang.add(penumpangBaru);
        } else if (jenisTiket == 2) {
            System.out.print("Masukkan fasilitas tiket VIP: ");
            String fasilitasVIP = scanner.nextLine();
            TiketVIP penumpangBaru = new TiketVIP(nama, tujuan, umur, tanggalJamKeberangkatan, fasilitasVIP);
            dataPenumpang.add(penumpangBaru);
        } else {
            System.out.println("Pilihan tiket tidak valid.");
        }

        System.out.println("Data penumpang berhasil ditambahkan!");
    }

    private static void tampilkanDataPenumpang() {
        System.out.println("===== DATA TIKET PENUMPANG =====");
        for (int i = 0; i < dataPenumpang.size(); i++) {
            TiketPenumpang penumpang = dataPenumpang.get(i);
            System.out.println("Nomor Tiket: " + (i + 1));
            System.out.println("Nama: " + penumpang.getNama());
            System.out.println("Tujuan: " + penumpang.getTujuan());
            System.out.println("Umur: " + penumpang.getUmur());
            System.out.println("Tanggal dan Jam Keberangkatan: " + penumpang.getTanggalJamKeberangkatan());
            if (penumpang instanceof TiketBiasa) {
                System.out.println("Harga Tiket Biasa: " + ((TiketBiasa) penumpang).getHarga());
            } else if (penumpang instanceof TiketVIP) {
                System.out.println("Fasilitas Tiket VIP: " + ((TiketVIP) penumpang).getFasilitas());
            }
            System.out.println("---------------------------");
        }
    }

    private static void editDataPenumpang() {
        tampilkanDataPenumpang();
        System.out.print("Masukkan nomor tiket penumpang yang akan diedit: ");
        int nomorTiket = scanner.nextInt();
        scanner.nextLine();

        if (nomorTiket >= 1 && nomorTiket <= dataPenumpang.size()) {
            TiketPenumpang penumpang = dataPenumpang.get(nomorTiket - 1);
            System.out.println("Data saat ini:");
            System.out.println("Nama: " + penumpang.getNama());
            System.out.println("Tujuan: " + penumpang.getTujuan());
            System.out.println("Umur: " + penumpang.getUmur());
            System.out.println("Tanggal dan Jam Keberangkatan: " + penumpang.getTanggalJamKeberangkatan());

            System.out.println("Masukkan data baru:");

            System.out.print("Masukkan nama penumpang: ");
            penumpang.setNama(scanner.nextLine());
            System.out.print("Masukkan tujuan: ");
            penumpang.setTujuan(scanner.nextLine());
            System.out.print("Masukkan umur penumpang: ");
            penumpang.setUmur(scanner.nextInt());
            scanner.nextLine();
            System.out.print("Masukkan tanggal dan jam keberangkatan: ");
            penumpang.setTanggalJamKeberangkatan(scanner.nextLine());

            if (penumpang instanceof TiketBiasa) {
                System.out.print("Masukkan harga tiket biasa: ");
                ((TiketBiasa) penumpang).setHarga(scanner.nextInt());
                scanner.nextLine();
            } else if (penumpang instanceof TiketVIP) {
                System.out.print("Masukkan fasilitas tiket VIP: ");
                ((TiketVIP) penumpang).setFasilitas(scanner.nextLine());
            }

            System.out.println("Data penumpang berhasil diubah!");
        } else {
            System.out.println("Nomor tiket tidak valid.");
        }
    }

    private static void hapusDataPenumpang() {
        tampilkanDataPenumpang();
        System.out.print("Masukkan nomor tiket penumpang yang akan dihapus: ");
        int nomorTiket = scanner.nextInt();

        if (nomorTiket >= 1 && nomorTiket <= dataPenumpang.size()) {
            dataPenumpang.remove(nomorTiket - 1);
            System.out.println("Data penumpang berhasil dihapus!");
        } else {
            System.out.println("Nomor tiket tidak valid.");
        }
    }
}
