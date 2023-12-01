package model;

public class Loai {
	
	private int loai_id ;
	private String ten_loai;
	public Loai(int loai_id, String ten_loai) {
		super();
		this.loai_id = loai_id;
		this.ten_loai = ten_loai;
	}
	public Loai( String ten_loai) {
		super();
		
		this.ten_loai = ten_loai;
	}
	public int getLoai_id() {
		return loai_id;
	}
	public void setLoai_id(int loai_id) {
		this.loai_id = loai_id;
	}
	public String getTen_loai() {
		return ten_loai;
	}
	public void setTen_loai(String ten_loai) {
		this.ten_loai = ten_loai;
	}
	@Override
	public String toString() {
		return "Loai [loai_id=" + loai_id + ", ten_loai=" + ten_loai + "]";
	}
	
	
	
	
}
