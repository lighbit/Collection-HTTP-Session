package com.Collection;

/**
 * Case COLLECTION @author zulkarnaen
 */
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Servercollection {

	// TODO: Membuat variable
	private static ServerSocket serverSocket;
	private static Socket client;
	private static ObjectInputStream in;

	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) throws InterruptedException {

		// TODO: deklarasi address dan socket
		File myfile;
		Frame myFrame = new Frame();

		try {
			// TODO: Membuat socket baru dengan socket 5555
			serverSocket = new ServerSocket(5555);
			System.out.println("-------Menunggu Client...");

			// TODO: Socket client jika diterima
			client = serverSocket.accept();
			System.out.println(
					"=========================================== WELCOME TO SERVER ==============================================\n");
			System.out.println("-------->Client Terhubung!\n");

			// TODO: objectinputstream baru dengan client(socket) mengambil
			// inputstream
			in = new ObjectInputStream(client.getInputStream());

			// TODO: Mendapatkan Detail Data
			myfile = (File) in.readObject();
			System.out.println(
					"================================================= DETAIL FILE =================================================");
			System.out.println("			Asal Path	: " + myfile.getAbsolutePath());
			System.out.println(
					"----------------------------------------------------------------------------------------------------------------");
			System.out.println("			Nama File	: " + myfile.getName());
			System.out.println(
					"----------------------------------------------------------------------------------------------------------------");
			System.out.println("			Panjang		: " + myfile.length() + " bytes");
			System.out.println(
					"----------------------------------------------------------------------------------------------------------------");
			System.out.println(
					"--------------------------------------- *your DB will appear in below ------------------------------------------\n");

			// TODO: Deklarasi Fileinput (inData) dan Fileouput(outData)
			FileInputStream inData = null;
			FileOutputStream outData = null;

			// TODO: Memanggil Fileinput dan Fileouput
			inData = new FileInputStream(myfile);
			outData = new FileOutputStream("D:/Collection/Server/collection.csv");

			// TODO: Membuat looping pada data masuk dan data keluar untuk
			// membaca data nanti
			int c;
			while ((c = inData.read()) != -1) {
				outData.write(c);

			}

			// TODO: Deklarasi data di server dengan bufferedreader untuk
			// membaca datanya
			File file = new File("D:/Collection/Server/collection.csv");
			BufferedReader br = new BufferedReader(new FileReader(file));

			// TODO: panggil tabel console pada manipulasi.
			List<DataPresiden> dataPresidens = Manipulasi.dataPresidens(file);

			// TODO: Membuat kondisi untuk memunculkan semua data pada csv
			// jika bufferedreader is ready maka data br akan di split dengan
			// nama line.
			System.out.println(
					"========================================== DATABASE YANG DIDAPAT ============================================\n");
			while (br.ready()) {
				String line = br.readLine();
				String[] data = line.split(",");

				// TODO: line (bufferedreader)
				System.out.println(
						"------------------------------------------------------------------------------------------------------------");
				System.out.println(" 			" + line + " 			\n");
			}
			System.out.println(
					"============================================================================================================");
			System.out.println(
					"----------------------------*if your DB not appear, cek your (BR)----------------------------\n");

			// TODO: Memberikan delay 7s (untuk redirect)
			Thread.sleep(7000);

			// TODO: putuskan semua koneksi
			outData.close();
			inData.close();

			in.close();
			client.close();
			System.out.println("----------> Client dihentikan <--------");

			serverSocket.close();
			System.out.println("----------> Server dihentikan <--------");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
