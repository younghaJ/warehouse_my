package warehouse;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

public class Main4PoiWrite {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private DBConnectionMgr pool;

	public Main4PoiWrite() {
		String sql = null;
		String file_size = null;
		String file_path = null;
		Workbook xworkbook = null; // �������� ��ü ����
		Sheet xSheet = null; // ��Ʈ ��ü ����
		Row xRow = null; // �� ��ü ����
		Cell xCell = null; // �� ��ü ����
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			xworkbook = new SXSSFWorkbook(); // �������� ����
			xSheet = xworkbook.createSheet("sheet1"); // ��Ʈ ����
			con = pool.getConnection();
			sql = "SELECT PROD_CODE, CATEGORY, PROD_NAME, PROD_SIZE, PROD_COLOR, PROD_STOCK\r\n" + "FROM product\r\n"
					+ "ORDER BY PROD_CODE DESC";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			File file = new File(file_path + ".xlsx"); // ���� Ȯ���� .xlsx�� ����
			FileOutputStream fos = new FileOutputStream(file);
			
			xRow = xSheet.createRow(0);
			xCell = xRow.createCell(0);
			xCell.setCellValue("PROD_CODE");
			xCell = xRow.createCell(1);
			xCell.setCellValue("CATEGORY");
			xCell = xRow.createCell(2);
			xCell.setCellValue("PROD_NAME");
			xCell = xRow.createCell(3);
			xCell.setCellValue("PROD_SIZE");
			xCell = xRow.createCell(4);
			xCell.setCellValue("PROD_COLOR");
			xCell = xRow.createCell(5);
			xCell.setCellValue("PROD_STOCK");
			
			int row = 1; // row��° ��

			while (rs.next()) {

				// quary ������� ������ ��������
				String prodCode = rs.getString(1); // ���� select���� ù��° ��
				String category = rs.getString(2); // ���� select���� ù��° ��
				String prodName = rs.getString(3); // ���� select���� ù��° ��
				String prodSize = rs.getString(4); // ���� select���� ù��° ��
				String prodColor = rs.getString(5); // ���� select���� �ι�° ��
				String prodStock = rs.getString(6); // ���� select���� �ι�° ��
				// String description = rs.getString(description) ó�� ���� ��� �÷��� �Է��ص� ���� ����

				// ������ �Է�
				xRow = xSheet.createRow(row);
				xCell = xRow.createCell(0);
				xCell.setCellValue(prodCode);
				xCell = xRow.createCell(1);
				xCell.setCellValue(category);
				xCell = xRow.createCell(2);
				xCell.setCellValue(prodName);
				xCell = xRow.createCell(3);
				xCell.setCellValue(prodSize);
				xCell = xRow.createCell(4);
				xCell.setCellValue(prodColor);
				xCell = xRow.createCell(5);
				xCell.setCellValue(prodStock);

				row++;
				// ���� ����
				xworkbook.write(fos);
				if (fos != null) {
					fos.close();
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e2) {

			}
		}
	}

	public static void main(String[] args) throws IOException {
		Main4PoiWrite main = new Main4PoiWrite();

	}

}