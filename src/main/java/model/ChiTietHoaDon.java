package model;

import dao.ThucDonDao;

public class ChiTietHoaDon  {

	
	private int hoadon_id;
	
	private int thucdon_id;
	
	private int so_luong;
	
	private float don_gia;
	
	public String tenThucDonById(int id) {
		String ten_mon = null;
		ThucDonDao thucDonDao = new ThucDonDao();
		ThucDon thucDon = thucDonDao.selectThucDon(id);
		ten_mon = thucDon.getTen_mon();
		return ten_mon;
		
	}
	
	public ChiTietHoaDon(int hoadon_id, int thucdon_id, int so_luong, float don_gia) {
		super();
		this.hoadon_id = hoadon_id;
		this.thucdon_id = thucdon_id;
		this.so_luong = so_luong;
		this.don_gia = don_gia;
	}

	public int getHoadon_id() {
		return hoadon_id;
	}

	public void setHoadon_id(int hoadon_id) {
		this.hoadon_id = hoadon_id;
	}

	public int getThucdon_id() {
		return thucdon_id;
	}

	public void setThucdon_id(int thucdon_id) {
		this.thucdon_id = thucdon_id;
	}

	public int getSo_luong() {
		return so_luong;
	}

	public void setSo_luong(int so_luong) {
		this.so_luong = so_luong;
	}

	public float getDon_gia() {
		return don_gia;
	}

	public void setDon_gia(float don_gia) {
		this.don_gia = don_gia;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDon [hoadon_id=" + hoadon_id + ", thucdon_id=" + thucdon_id + ", so_luong=" + so_luong
				+ ", don_gia=" + don_gia + "]";
	}
	
	public ChiTietHoaDon() {}
	
	
		
	
}
