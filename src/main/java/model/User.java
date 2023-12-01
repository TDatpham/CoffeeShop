package model;
//chứa các entity 
public class User {
	private int user_id;
	private String user_name;
	private String pass_word;
	private String ten_nguoi_dung;
	private String sdt;
	
	public User(int user_id, String user_name, String pass_word, String ten_nguoi_dung, String sdt) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.pass_word = pass_word;
		this.ten_nguoi_dung = ten_nguoi_dung;
		this.sdt = sdt;
	}
	
	public User( String user_name, String pass_word, String ten_nguoi_dung, String sdt) {
		super();
		this.user_name = user_name;
		this.pass_word = pass_word;
		this.ten_nguoi_dung = ten_nguoi_dung;
		this.sdt = sdt;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPass_word() {
		return pass_word;
	}

	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}

	public String getTen_nguoi_dung() {
		return ten_nguoi_dung;
	}

	public void setTen_nguoi_dung(String ten_nguoi_dung) {
		this.ten_nguoi_dung = ten_nguoi_dung;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", pass_word=" + pass_word
				+ ", ten_nguoi_dung=" + ten_nguoi_dung + ", sdt=" + sdt + "]";
	}
	
	
}
