package com.Collection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Manipulasi {

	public static String baca;
	public static String ambilData = "";
	public static int iterasi = 0;
	public static String id = null, nama = null, tanggal = null, golongan = null, gaji = null;
	
	

// =========================================================================================================================================================================================
	// TODO: Membaca char dan menghitungnya untuk dipisahkan sesuai variable
	// nanti.
	@SuppressWarnings("resource")
	public static List<DataPresiden> dataPresidens(File myfile) throws IOException {
		List<DataPresiden> empList = new ArrayList<DataPresiden>();
		// TODO: Memanggil file name nya
		System.out.println(
				"\n================================================ DIDAPAT DATA ===============================================");
		System.out.println("========================================== Nama File:" + myfile.getName()
				+ " =========================================\n");

		// TODO: Membaca myfile dari collection.txt
		BufferedReader bacaBaris = new BufferedReader(new FileReader(myfile));
		// TODO: baca adalah bufferedreader untuk dikeluarkan outputnya.
		while ((baca = bacaBaris.readLine()) != null) {
			// TODO: kondisi for untuk membaca data pada file Collection.txt
			// jadi jika , dan {} tidak dihitung sisanya dihitung sebagai output
			// nanti
			for (int i = 0; i < baca.length(); ++i) {
				if (baca.charAt(i) != ',' && baca.charAt(i) != '{' && baca.charAt(i) != '}') {
					ambilData += baca.charAt(i);
				}
				if (baca.charAt(i) == ',' || baca.charAt(i) == '}') {
					iterasi++;
					// TODO: menggunakan pisahData untuk mengambiil data satu
					// persatu sesuai fungsi
					DataPresiden pisahData = PisahData(ambilData, iterasi);

					if (iterasi == 5) {

						empList.add(pisahData);
						iterasi = 0;
					}
					ambilData = "";
				}
			}

			System.out.println("");
		}
		System.out.println(
				"\n=============================================================================================================");
		// TODO: Menggunakan collection.sort untuk sorting sesuai nama
		// menggunakan stuNameComparator.
		Collections.sort(empList, DataPresiden.StuNameComparator);
		// TODO: Membuat Tabel di console.
		String leftAlignFormat = "			| %-3s | %-15s | %-15s | %-15s |%n";

		System.out.println("");
		System.out.println(
				"========================================= TABEL DISORTING COLLECTION ========================================\n");
		System.out.format("			+-----+-----------------+-----------------+-----------------+%n");
		System.out.format("			| ID  |      NAMA       |   Golongan      |      Gaji       |%n");
		System.out.format("			+-----+-----------------+-----------------+-----------------+%n");
		for (DataPresiden counter : empList) {
			// TODO: pengulangan for untuk memasukan id, nama, golongan dan gaji
			// ke tabel console
			for (int i = 0; i < 1; i++) {
				System.out.format(leftAlignFormat, counter.getId(), counter.getNama(), counter.getGolongan(),
						counter.getGaji());
			}
			System.out.format("			+-----+-----------------+-----------------+-----------------+%n");

		}
		System.out.println(
				"\n=============================================================================================================");

		return empList;
	}

	
	
// =========================================================================================================================================================================================
	// TODO: Membuat function pisah data untuk Datapresiden
	public static DataPresiden PisahData(String simpanData, int getData) {
		DataPresiden ambil = new DataPresiden();

		// TODO: getData untuk memisahkan data
		// ada 5 data 1.1(id), 2.zulkarnaen(nama), 3.22/12/2018(tanggalmasuk),
		// 4.golongan1(golongan), 5.Rp. 500000(gaji)
		if (getData == 1) {
			id = simpanData; // jika getData 1 simpan data untuk id

		} else if (getData == 2) {
			nama = simpanData;

		} else if (getData == 3) {
			tanggal = simpanData;

		} else if (getData == 4) {
			golongan = simpanData;

		} else if (getData == 5) {
			gaji = simpanData;

			// TODO: Simpan data semuanya.
			ambil.setId(id);
			ambil.setNama(nama);
			ambil.setTanggal(tanggal);
			ambil.setGolongan(golongan);
			ambil.setGaji(gaji);

			System.out.println(
					"-------------------------------------------> DIDAPAT DATA BERIKUT <------------------------------------------");
			// TODO: print
			System.out.printf("ID: %s -", id);
			System.out.printf("NAMA: %s -", nama);
			System.out.printf("Tanggal Masuk: %s -", tanggal);
			System.out.printf("Golongan: %s - ", golongan);
			System.out.printf("Gaji: %s\n", gaji);

		}

		return ambil;
	}
	// =========================================================================================================================================================================================

}
