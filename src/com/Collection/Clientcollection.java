package com.Collection;

/**
 * Case COLLECTION @author zulkarnaen
 */
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class Clientcollection {

	private static SocketAddress address;
	private static Socket socket;
	private static ObjectOutputStream out;
	private static File myFile;

	public static void main(String[] args) {
		// TODO: Buat ip dan port
		String ip = "127.0.0.1";
		int port = 5555;

		address = new InetSocketAddress(ip, port);
		socket = new Socket();
		try {
			// TODO: kondisi jika socket koneksi ke server
			socket.connect(address);
			System.out.println("------->Berhasil Terhubung ke Client!<-------\n");
			System.out.println("============= WELCOME TO CLIENT =============\n");
			// TODO: socket get outputstream
			out = new ObjectOutputStream(socket.getOutputStream());

			// TODO: myfile = isi dari file yang mau di transfer ke server
			String msgFile = "D:/Collection/Client/collection.txt";
			myFile = new File(msgFile);
			

			// TODO: membuat detail file
			System.out.println("=============================================");
			System.out.println("--------->Asal Path	: " + myFile.getAbsolutePath());
			System.out.println("---------------------------------------------");
			System.out.println("--------->Panjang	: " + myFile.length());
			System.out.println("---------------------------------------------\n");

			// TODO: write object dari myfile
			out.writeObject(myFile);

			// TODO: menggunakan manipulasi sendcsvtodatabasecollection
			// berupa readcsv dan readcsvusingload untuk simpan ke database
			System.out.println("=============== INFO DATABASE ===============");
			// TODO: Manipulasi untuk Insert ke DB
			SendCSVtoDatabaseCollection.readCsv1();
			SendCSVtoDatabaseCollection.readCsvUsingLoad1();
			System.out.println("---------- Data Berhasil di Upload ----------");
			System.out.println("=============================================\n");

			// TODO: matikan semua koneksi.
			out.close();
			socket.close();
			System.out.println("-------------->Socket ditutup <--------------\n");
			System.out.println("*beberapa saat lagi console akan redirect ke server");
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
