package com.Collection;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.Koneksi.Koneksi;
import com.opencsv.CSVReader;

public class SendCSVtoDatabaseCollection {
	public static void main(String[] args) {
		readCsv1();
		readCsvUsingLoad1();
	}

// ====================================================================================================================================================================================
	// TODO: READ CSV dan READCSVUSING LOAD
	public static void readCsv1() {
		Koneksi db = new Koneksi();
		Connection conn = db.getKoneksi();

		DataPresiden ambil = new DataPresiden();

		try (CSVReader reader = new CSVReader(new FileReader("D:\\Collection\\Server\\collection.csv"), ',');) {
			String insertQuery = "INSERT INTO `karyawaninsentif`.`presiden` (`idpresiden`, `nama`, `tanggalmasuk`, `golongan`, `gaji`) VALUES (?, ?, ?, ?, ?);";
			PreparedStatement preparedStmt = conn.prepareStatement(insertQuery);

			preparedStmt.setString(1, ambil.getId());
			preparedStmt.setString(2, ambil.getNama());
			preparedStmt.setString(3, ambil.getTanggal());
			preparedStmt.setString(4, ambil.getGolongan());
			preparedStmt.setString(5, ambil.getGaji());

			System.out.println("sukses");

			// execute the preparedstatement
			preparedStmt.execute();
			conn.close();
		} catch (Exception e) {
		}

	}

	public static void readCsvUsingLoad1() {
		Koneksi db = new Koneksi();
		Connection conn = db.getKoneksi();
		try {

			String loadQuery = "LOAD DATA LOCAL INFILE '" + "D://Collection//Server//collection.csv"
					+ "' INTO TABLE presiden FIELDS TERMINATED BY ','"
					+ " LINES TERMINATED BY '\n' (idpresiden, nama, tanggalmasuk, golongan, gaji) ";
			// System.out.println(loadQuery);
			Statement stmt = conn.createStatement();
			stmt.execute(loadQuery);
		} catch (Exception e) {
		}
	}
// ===================================================================================================================
}
