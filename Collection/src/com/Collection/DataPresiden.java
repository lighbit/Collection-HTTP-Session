package com.Collection;

import java.util.Comparator;

public class DataPresiden {
	private String id;
	private String nama;
	private String tanggal;
	private String golongan;
	private String gaji;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getTanggal() {
		return tanggal;
	}

	public void setTanggal(String tanggal) {
		this.tanggal = tanggal;
	}

	public String getGolongan() {
		return golongan;
	}

	public void setGolongan(String golongan) {
		this.golongan = golongan;
	}

	public String getGaji() {
		return gaji;
	}

	public void setGaji(String gaji) {
		this.gaji = gaji;
	}

	public static Comparator<DataPresiden> StuNameComparator = new Comparator<DataPresiden>() {
		// Used for sorting in ascending order of
		// roll number
		public int compare(DataPresiden a, DataPresiden b) {
			String Nama1 = a.getNama();
			String Nama2 = b.getNama();

			// ascending order
			return Nama1.compareTo(Nama2);
		}
	};
}
