package model;

public class HoaDon {
	private int hoadon_id;
	private int ban_id;
	private float thanh_tien;
	private int user_id;
	private String create_at;
	private String create_update;
	private String ten_nguoi_mua;
	private String so_dien_thoai;
	public HoaDon(int hoadon_id, int ban_id, float thanh_tien, int user_id, String create_at, String create_update,
			String ten_nguoi_mua, String so_dien_thoai) {
		super();
		this.hoadon_id = hoadon_id;
		this.ban_id = ban_id;
		this.thanh_tien = thanh_tien;
		this.user_id = user_id;
		this.create_at = create_at;
		this.create_update = create_update;
		this.ten_nguoi_mua = ten_nguoi_mua;
		this.so_dien_thoai = so_dien_thoai;
	}
	public HoaDon(int ban_id, float thanh_tien, int user_id, String create_at, String create_update,
			String ten_nguoi_mua, String so_dien_thoai) {
		super();
		this.ban_id = ban_id;
		this.thanh_tien = thanh_tien;
		this.user_id = user_id;
		this.create_at = create_at;
		this.create_update = create_update;
		this.ten_nguoi_mua = ten_nguoi_mua;
		this.so_dien_thoai = so_dien_thoai;
	}
	public int getHoadon_id() {
		return hoadon_id;
	}
	public void setHoadon_id(int hoadon_id) {
		this.hoadon_id = hoadon_id;
	}
	public int getBan_id() {
		return ban_id;
	}
	public void setBan_id(int ban_id) {
		this.ban_id = ban_id;
	}
	public float getThanh_tien() {
		return thanh_tien;
	}
	public void setThanh_tien(float thanh_tien) {
		this.thanh_tien = thanh_tien;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getCreate_at() {
		return create_at;
	}
	public void setCreate_at(String create_at) {
		this.create_at = create_at;
	}
	public String getCreate_update() {
		return create_update;
	}
	public void setCreate_update(String create_update) {
		this.create_update = create_update;
	}
	public String getTen_nguoi_mua() {
		return ten_nguoi_mua;
	}
	public void setTen_nguoi_mua(String ten_nguoi_mua) {
		this.ten_nguoi_mua = ten_nguoi_mua;
	}
	public String getSo_dien_thoai() {
		return so_dien_thoai;
	}
	public void setSo_dien_thoai(String so_dien_thoai) {
		this.so_dien_thoai = so_dien_thoai;
	}
	@Override
	public String toString() {
		return "HoaDon [hoadon_id=" + hoadon_id + ", ban_id=" + ban_id + ", thanh_tien=" + thanh_tien + ", user_id="
				+ user_id + ", create_at=" + create_at + ", create_update=" + create_update + ", ten_nguoi_mua="
				+ ten_nguoi_mua + ", so_dien_thoai=" + so_dien_thoai + "]";
	}
	
}
