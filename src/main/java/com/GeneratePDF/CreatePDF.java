package com.GeneratePDF;

import java.io.FileOutputStream;
import java.util.List;



import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import dao.ChiTietHoaDonDao;
import dao.HoaDonDao;
import model.ChiTietHoaDon;
import model.HoaDon;



public class CreatePDF{
	
	
	
	public CreatePDF() { }
	
	
	public void generatePDF(int id_user) {
		// TODO Auto-generated method stub
		try {
			
			String file_name = "D:\\Final_of_term_Java\\hoadon\\hoadon.pdf";
			
			Document document = new Document();
			
			PdfWriter.getInstance(document, new FileOutputStream(file_name));
			
			document.open();
			

			BaseFont bf;
			
			bf = BaseFont.createFont("D:\\Final_of_term_Java\\vuArial\\vuArial.ttf",BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			//document.add(new Paragraph("Font: " + bf.getPostscriptFontName() + "with encoding: " + bf.getEncoding()));
			
			// add ten quan
			Paragraph name = new Paragraph("THE COFFEE HEART ", new Font(bf,34,Font.BOLDITALIC));
			name.setAlignment(Element.ALIGN_CENTER);
			
			Paragraph address = new Paragraph("280 Đ.An Dương Vương, Phường 4, Quận 5, Thành phố Hồ Chí Minh", new Font(bf,10));
			address.setAlignment(Element.ALIGN_CENTER);
			
			document.add(name);
			document.add(address);
			//duong phan cach
			Chunk linebreak1 = new Chunk(new LineSeparator());
			document.add(linebreak1);
			
			
			
			 HoaDonDao hoaDonDao = new HoaDonDao();
			 HoaDon hoaDon = hoaDonDao.getNewHoaDonById(id_user);
			 String hoadon_id = String.valueOf(hoaDon.getHoadon_id());
			String ban_id = String.valueOf(hoaDon.getBan_id());
			String total = String.valueOf(hoaDon.getThanh_tien());
			String user_id = String.valueOf(hoaDon.getUser_id());
			String create_at = hoaDon.getCreate_at();
			String tennguomua =	hoaDon.getTen_nguoi_mua();
			String sodienthoai =hoaDon.getSo_dien_thoai();
			
			Paragraph p = new Paragraph("Hóa Đơn ", new Font(bf,30));
			p.setAlignment(Element.ALIGN_CENTER);
			
			document.add(p);
			
			//khoang trang
			Paragraph paraline = new Paragraph();
			paraline.add(Chunk.NEWLINE);
			//document.add(paraline);
			
			// add ten cua hoa don
			document.add(new Paragraph("Id Hóa đơn: "+ hoadon_id , new Font(bf,12)));
			document.add(new Paragraph("Id Người bán: "+ user_id , new Font(bf,12)));
			document.add(new Paragraph("Id Bàn: "+ban_id , new Font(bf,12)));
			document.add(new Paragraph("Ngày tạo: "+ create_at , new Font(bf,12)));
			document.add(new Paragraph("Tên người mua: "+tennguomua, new Font(bf,12)));
			document.add(new Paragraph("Số điện thoại: "+ sodienthoai, new Font(bf,12)));
			
			// add line
			
			
			Chunk linebreak = new Chunk(new LineSeparator(1, 100, BaseColor.GRAY, 0, 0));
			document.add(linebreak);
			
			
			//add table
			
			
			PdfPTable table  = new PdfPTable(4);
			table.getDefaultCell().setBorder(0);
		

			
			table.setWidthPercentage(100);
						
			
			
			table.setHeaderRows(1);

			table.addCell(new Paragraph("Tên món",new Font(bf,13,1)));
			

			PdfPCell hdon_gia = new PdfPCell(new Paragraph("Đơn giá",new Font(bf,13,1)));
			hdon_gia.setHorizontalAlignment(Element.ALIGN_CENTER);
			hdon_gia.setBorder(0);
			table.addCell(hdon_gia);
			
			
			PdfPCell hso_luong = new PdfPCell(new Paragraph("Số lượng",new Font(bf,13,1)));
			hso_luong.setHorizontalAlignment(Element.ALIGN_CENTER);
			hso_luong.setBorder(0);
			table.addCell(hso_luong);

			
			PdfPCell hthanh_tien = new PdfPCell(new Paragraph("Thành tiền",new Font(bf,13,1)));
			hthanh_tien.setHorizontalAlignment(Element.ALIGN_CENTER);
			hthanh_tien.setBorder(0);
			table.addCell(hthanh_tien);

		

			
			ChiTietHoaDonDao chiTietHoaDonDao = new ChiTietHoaDonDao();
			List<ChiTietHoaDon> chiTietHoaDon = chiTietHoaDonDao.selectAllChiTietHoaDonByIdHoaDon(hoaDon.getHoadon_id());
			for (ChiTietHoaDon chiTietHoaDon2 : chiTietHoaDon) {
				
				PdfPCell td_id = new PdfPCell(new Paragraph(chiTietHoaDon2.tenThucDonById(chiTietHoaDon2.getThucdon_id()),new Font(bf, 12)));
				//td_id.setHorizontalAlignment(Element.ALIGN_CENTER);
				td_id.setBorder(0);
				table.addCell(td_id);
				

				PdfPCell don_gia = new PdfPCell(new Paragraph(String.valueOf(chiTietHoaDon2.getDon_gia()),new Font(bf, 12)));
				don_gia.setHorizontalAlignment(Element.ALIGN_CENTER);
				don_gia.setBorder(0);
				table.addCell(don_gia);
				
				
				PdfPCell so_luong = new PdfPCell( new Paragraph(String.valueOf(chiTietHoaDon2.getSo_luong()),new Font(bf, 12)));
				so_luong.setHorizontalAlignment(Element.ALIGN_CENTER);
				so_luong.setBorder(0);
				table.addCell(so_luong);
				
				
				
				PdfPCell thanh_tien = new PdfPCell(new Paragraph(String.valueOf(chiTietHoaDon2.getDon_gia()*chiTietHoaDon2.getSo_luong())));
				thanh_tien.setHorizontalAlignment(Element.ALIGN_CENTER);
				thanh_tien.setBorder(0);
				table.addCell(thanh_tien);
				
			}
			
			document.add(table);
			
			document.add(linebreak);
			
			// them dong tong tien
			Paragraph totalParagraph = new Paragraph("Tổng cộng: "+ total +" đ", new Font(bf, 13,1));
			totalParagraph.setAlignment(Element.ALIGN_RIGHT);
			document.add(totalParagraph);
			
			
			document.add(paraline);
			document.add(paraline);
			
			Paragraph thankParagraph = new Paragraph("Cảm ơn bạn rất nhiều vì đã sử dụng dịch vụ của chúng tôi!", new Font(bf, 12, Font.ITALIC));
			thankParagraph.setAlignment(Element.ALIGN_CENTER);
			document.add(thankParagraph);
			
			document.close();
			
			
			
			System.out.println("finished");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
		
		System.out.println("co chay qua day");
	}
	

	

	

}