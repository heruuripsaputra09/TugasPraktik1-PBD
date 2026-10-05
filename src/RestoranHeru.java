import java.util.Scanner;

class Menu {
    String nama;
    double harga;
    String kategori;

    // constuctor
	public Menu(String nama, double harga, String kategori) {
		this.nama = nama;
		this.harga = harga;
		this.kategori = kategori;
	}
}

public class RestoranHeru {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		Menu[] daftarMenu = new Menu[8];
		daftarMenu[0] = new Menu("Pecel ayam", 20000, "Makanan");
		daftarMenu[1] = new Menu("Pangsit", 15000, "Makanan");
		daftarMenu[2] = new Menu("Odading", 3000, "Makanan");
		daftarMenu[3] = new Menu("Oreo", 2000, "Makanan");
		daftarMenu[4] = new Menu("Teh tawar", 2000, "Minuman");
		daftarMenu[5] = new Menu("Teh Manis", 2000, "Minuman");
		daftarMenu[6] = new Menu("Es Thai tea", 2000, "Minuman");
		daftarMenu[7] = new Menu("Lemon Tea", 2000, "Minuman");

		tampilkanMenu(daftarMenu);

		String pesan1 = "", pesan2 = "", pesan3 = "", pesan4 = "";
		int qty1 = 0, qty2 = 0, qty3 = 0, qty4 = 0;

		System.out.println("\nMasukan pesanan anda maksimal 4");
		System.out.println("Format: Nama menu = jumlah (Contoh: Pecel ayam = 2)");
		System.out.println("Ketik '-' jika tidak ingin menambah pesanan");


		// logika
		// input pesanan1

		System.out.println("pesanan 1:");
		String input1 = input.nextLine();

		if (!input1.equals("-") && input1.contains("=")) {
			int batas = input1.indexOf("=");
			pesan1 = input1.substring(0, batas).trim();
			qty1 = Integer.parseInt(input1.substring(batas + 1).trim());
			
		}

		// input pesanan2

		System.out.println("pesanan 2:");
		String input2 = input.nextLine();

		if (!input2.equals("-") && input2.contains("=")) {
			int batas = input2.indexOf("=");
			pesan2 = input2.substring(0, batas).trim();
			qty2 = Integer.parseInt(input2.substring(batas + 1).trim());
			
		}

		// input pesanan3
		System.out.println("pesanan 3:");
		String input3 = input.nextLine();

		if (!input3.equals("-") && input3.contains("=")) {
			int batas = input3.indexOf("=");
			pesan3 = input3.substring(0, batas).trim();
			qty3 = Integer.parseInt(input3.substring(batas + 1).trim());
			
		}

		// input pesanan4
		System.out.println("pesanan 4:");
		String input4 = input.nextLine();

		if (!input4.equals("-") && input4.contains("=")) {
			int batas = input4.indexOf("=");
			pesan4 = input4.substring(0, batas).trim();
			qty4 = Integer.parseInt(input4.substring(batas + 1).trim());
			
		}

		cetakStruk(pesan1, qty1, pesan2, qty2, pesan3, qty3, pesan4, qty4, daftarMenu);

				input.close();
	}

		public static void tampilkanMenu (Menu[] menu) {

			System.out.println("==== DAFTAR MENU RESTORAN ====");
			System.out.println("[KATEGORI MAKANAN]");
			System.out.println("- " + menu[0].nama + " (Rp" + menu[0].harga + ")");
			System.out.println("- " + menu[1].nama + " (Rp" + menu[1].harga + ")");
			System.out.println("- " + menu[2].nama + " (Rp" + menu[2].harga + ")");
			System.out.println("- " + menu[3].nama + " (Rp" + menu[3].harga + ")");

			System.out.println("[KATEGORI MINUMAN]");
			System.out.println("- " + menu[4].nama + " (Rp" + menu[4].harga + ")");
			System.out.println("- " + menu[5].nama + " (Rp" + menu[5].harga + ")");
			System.out.println("- " + menu[6].nama + " (Rp" + menu[6].harga + ")");
			System.out.println("- " + menu[7].nama + " (Rp" + menu[7].harga + ")");
		}

		public static Menu cariMenu (String namaPesanan, Menu[] menu) {

			if (namaPesanan.equalsIgnoreCase(menu[0].nama)) return menu[0]; 
			else if (namaPesanan.equalsIgnoreCase(menu[1].nama)) return menu[1];
			else if (namaPesanan.equalsIgnoreCase(menu[2].nama)) return menu[2];
			else if (namaPesanan.equalsIgnoreCase(menu[3].nama)) return menu[3];
			else if (namaPesanan.equalsIgnoreCase(menu[4].nama)) return menu[4];
			else if (namaPesanan.equalsIgnoreCase(menu[5].nama)) return menu[5];
			else if (namaPesanan.equalsIgnoreCase(menu[6].nama)) return menu[6];
			else if (namaPesanan.equalsIgnoreCase(menu[7].nama)) return menu[7];

			return null;
		}

public static void cetakStruk(String p1, int q1, String p2, int q2, String p3,
 int q3, String p4, int q4, Menu[] menu) {
        System.out.println("\n========================================");
        System.out.println("             STRUK PESANAN              ");
        System.out.println("========================================");
        
        double totalBiaya = 0;
        boolean pesanMinuman = false; // Penanda untuk syarat promo Beli 1 Gratis 1
        
        // Pengecekan Pesanan 1 (Menggunakan Nested If / If Bersarang)
        Menu m1 = cariMenu(p1, menu);
        if (m1 != null) {
            if (q1 > 0) {
                double sub = m1.harga * q1;
                totalBiaya += sub;
                System.out.println(m1.nama + "\t x" + q1 + " @Rp" + m1.harga + " = Rp" + sub);
                // Cek kategori, jika yang dipesan termasuk minuman, ubah status jadi true
                if (m1.kategori.equals("Minuman")) {
                    pesanMinuman = true;
                }
            }
        }

        // Pengecekan Pesanan 2
        Menu m2 = cariMenu(p2, menu);
        if (m2 != null) {
            if (q2 > 0) {
                double sub = m2.harga * q2;
                totalBiaya += sub;
                System.out.println(m2.nama + "\t x" + q2 + " @Rp" + m2.harga + " = Rp" + sub);
                if (m2.kategori.equals("Minuman")) {
                    pesanMinuman = true;
                }
            }
        }

        // Pengecekan Pesanan 3
        Menu m3 = cariMenu(p3, menu);
        if (m3 != null) {
            if (q3 > 0) {
                double sub = m3.harga * q3;
                totalBiaya += sub;
                System.out.println(m3.nama + "\t x" + q3 + " @Rp" + m3.harga + " = Rp" + sub);
                if (m3.kategori.equals("Minuman")) {
                    pesanMinuman = true;
                }
            }
        }

        // Pengecekan Pesanan 4
        Menu m4 = cariMenu(p4, menu);
        if (m4 != null) {
            if (q4 > 0) {
                double sub = m4.harga * q4;
                totalBiaya += sub;
                System.out.println(m4.nama + "\t x" + q4 + " @Rp" + m4.harga + " = Rp" + sub);
                if (m4.kategori.equals("Minuman")) {
                    pesanMinuman = true;
                }
            }
        }

        System.out.println("----------------------------------------");
        System.out.println("Subtotal Harga  : Rp" + totalBiaya);
        
        // Komponen Tambahan (Pajak 10% dan Biaya Layanan Rp20.000)
        double pajak = totalBiaya * 0.10;
        double biayaLayanan = 20000;
        System.out.println("Pajak PPN (10%) : Rp" + pajak);
        System.out.println("Biaya Pelayanan : Rp" + biayaLayanan);
        
        // Struktur Keputusan: Logika Diskon 10% jika total > Rp100.000
        double diskon = 0;
        if (totalBiaya > 100000) {
            diskon = totalBiaya * 0.10;
            System.out.println("Diskon (10%)    : -Rp" + diskon);
        }

        // Struktur Keputusan: Promo Beli 1 Gratis 1 Minuman jika total > Rp50.000
        if (totalBiaya > 50000) {
            if (pesanMinuman) {
                System.out.println("* PROMO AKTIF   : Selamat, Anda berhak mendapatkan [Beli 1 Gratis 1 Minuman!]");
            }
        }

        // Perhitungan Total Keseluruhan (Grand Total)
        double grandTotal = (totalBiaya + pajak + biayaLayanan) - diskon;
        System.out.println("----------------------------------------");
        System.out.println("GRAND TOTAL     : Rp" + grandTotal);
        System.out.println("========================================");
    }


}
