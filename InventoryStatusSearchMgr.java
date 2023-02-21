package warehouse;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class InventoryStatusSearchMgr extends JPanel {
	private JTable table;
	private JScrollPane scrollPane;
	private String colNames[] = { "��ǰ�ڵ�", "ī�װ�", "��ǰ��", "��ǰ������", "��ǰ����", "������" };
	private DefaultTableModel model;
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private DBConnectionMgr pool;
	private String cbText, tfText;
	StatisticsAWT statisticsAWT;

	// ��� ��Ȳ ���̺�
	public InventoryStatusSearchMgr(StatisticsAWT statisticsAWT, String cbText, String tfText) {
		this.statisticsAWT = statisticsAWT;
		this.cbText = cbText;
		this.tfText = tfText;

		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBounds(25, 30, 505, 275);

		model = new DefaultTableModel(colNames, 0) { // ���̺� ���� �Ұ�
			@Override
			public boolean isCellEditable(int row, int column) {
				if (column >= 0) {
					return false;
				} else {
					return true;
				}
			}
		};

		table = new JTable(model);
	
		TableCellRenderer renderer = new MyTableCellRenderer(table);
		try {
			table.setDefaultRenderer(Class.forName("java.lang.Object"), renderer);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		scrollPane = new JScrollPane(table);
		add(scrollPane);
		pool = DBConnectionMgr.getInstance();
		select();
	}

	// ��ȸ�ϱ�
	public void select() {
		String sql = null;
		try {
			con = pool.getConnection();
			sql = "SELECT PROD_CODE, CATEGORY, PROD_NAME, PROD_SIZE, PROD_COLOR, PROD_STOCK\r\n" + "FROM product\r\n"
					+ "where CATEGORY like";

			if (cbText.equals("����")) {
				pstmt = con.prepareStatement(
						sql + " '" + cbText + "' and PROD_NAME LIKE '" + tfText + "' ORDER BY PROD_CODE DESC");
			} else if (cbText.equals("��3")) {
				pstmt = con.prepareStatement(
						sql + " '" + cbText + "' and PROD_NAME LIKE '" + tfText + "' ORDER BY PROD_CODE DESC");

			} else if (cbText.equals("��2")) {
				pstmt = con.prepareStatement(
						sql + " '" + cbText + "' and PROD_NAME LIKE '" + tfText + "' ORDER BY PROD_CODE DESC");

			} else if (cbText.equals("��1")) {
				pstmt = con.prepareStatement(
						sql + " '" + cbText + "' and PROD_NAME LIKE '" + tfText + "' ORDER BY PROD_CODE DESC");
			}

			rs = pstmt.executeQuery();

			while (rs.next()) {
				model.addRow(
						new Object[] { rs.getString("PROD_CODE"), rs.getString("CATEGORY"), rs.getString("PROD_NAME"),
								rs.getString("PROD_SIZE"), rs.getString("PROD_COLOR"), rs.getInt("PROD_STOCK") });
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
		statisticsAWT.p5.add(this);
	}
}
