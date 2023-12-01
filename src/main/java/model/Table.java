package model;

public class Table {
	
	private int ban_id;
	private String ten_ban;
	private boolean status;
	public Table(int ban_id, String ten_ban, boolean status) {
		super();
		this.ban_id = ban_id;
		this.ten_ban = ten_ban;
		this.status = status;
	}
	public int getBan_id() {
		return ban_id;
	}
	public void setBan_id(int ban_id) {
		this.ban_id = ban_id;
	}
	public String getTen_ban() {
		return ten_ban;
	}
	public void setTen_ban(String ten_ban) {
		this.ten_ban = ten_ban;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Table [ban_id=" + ban_id + ", ten_ban=" + ten_ban + ", status=" + status + "]";
	}
	
	
}
