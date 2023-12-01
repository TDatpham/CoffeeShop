package model;

public class ThucDon {
	private int thucdon_id;
	private String ten_mon;
	private String images;
	private float don_gia;
	private int loai_id;
	
	public ThucDon() { }
	
	public ThucDon(String ten_mon, String images, float don_gia, int loai_id) {
		super();
		this.ten_mon = ten_mon;
		this.images = images;
		this.don_gia = don_gia;
		this.loai_id = loai_id;
	}

	public ThucDon(int thucdon_id, String ten_mon, String images, float don_gia, int loai_id) {
		super();
		this.thucdon_id = thucdon_id;
		this.ten_mon = ten_mon;
		this.images = images;
		this.don_gia = don_gia;
		this.loai_id = loai_id;
	}

	public int getThucdon_id() {
		return thucdon_id;
	}

	public void setThucdon_id(int thucdon_id) {
		this.thucdon_id = thucdon_id;
	}

	public String getTen_mon() {
		return ten_mon;
	}

	public void setTen_mon(String ten_mon) {
		this.ten_mon = ten_mon;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public float getDon_gia() {
		return don_gia;
	}

	public void setDon_gia(float don_gia) {
		this.don_gia = don_gia;
	}

	public int getLoai_id() {
		return loai_id;
	}

	public void setLoai_id(int loai_id) {
		this.loai_id = loai_id;
	}

	@Override
	public String toString() {
		return "ThucDon [thucdon_id=" + thucdon_id + ", ten_mon=" + ten_mon + ", images=" + images + ", don_gia="
				+ don_gia + ", loai_id=" + loai_id + "]";
	}

	
	
	
}