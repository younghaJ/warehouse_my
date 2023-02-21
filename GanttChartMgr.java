package warehouse;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.HorizontalAlignment;

import net.DBConnectionMgr;

public class GanttChartMgr extends JPanel {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private DBConnectionMgr pool;
	String cbText;
	StatisticsAWT statisticsAWT;

	public GanttChartMgr(StatisticsAWT statisticsAWT, String cbText) {
		this.statisticsAWT = statisticsAWT;
		this.cbText = cbText;
		setLayout(null);
		setBackground(Color.white);
		setBounds(25, 15, 505, 340);

		if (cbText.equals("�԰�")) { // �԰� ī�װ� 
			JFreeChart chart = ChartFactory.createBarChart("��ǰ�� �� �԰���Ʈ", "", "", createDataset());
			ChartPanel chartPanel = new ChartPanel(chart);

			// Ÿ��Ʋ
			chart.getTitle().setFont(new Font("�������", Font.BOLD, 20));
			chart.getTitle().setPadding(15, 0, 0, 0);
			// ���� Ÿ��Ʋ
			TextTitle copyright = new TextTitle("2023��", new Font("�������", Font.PLAIN, 12));
			copyright.setHorizontalAlignment(HorizontalAlignment.RIGHT);
			chart.addSubtitle(copyright); // ��Ʈ ���� Ÿ��Ʋ
			// ����
			chart.getLegend().setItemFont(new Font("�������", Font.BOLD, 10));
			// plot ����
			CategoryPlot plot = chart.getCategoryPlot();
			Font font = plot.getDomainAxis().getLabelFont();
			// X�� ��
			plot.getDomainAxis().setLabelFont(new Font("�������", font.getStyle(), font.getSize()));
			// X�� ������
			plot.getDomainAxis().setTickLabelFont(new Font("�������", font.getStyle(), 10));
			font = plot.getRangeAxis().getLabelFont();
			// Y�� ��
			plot.getRangeAxis().setLabelFont(new Font("�������", font.getStyle(), font.getSize()));
			// Y�� ����
			plot.getRangeAxis().setTickLabelFont(new Font("�������", font.getStyle(), 10));

			chartPanel.setBounds(0, 0, 505, 330);

			add(chartPanel);
		} else if (cbText.equals("���")) { // ��� ī�װ� 
			JFreeChart chart2 = ChartFactory.createBarChart("��ǰ�� �� �����Ʈ", "", "", createDataset2());
			ChartPanel chartPanel2 = new ChartPanel(chart2);

			// Ÿ��Ʋ
			chart2.getTitle().setFont(new Font("�������", Font.BOLD, 20));
			chart2.getTitle().setPadding(15, 0, 0, 0);
			// ���� Ÿ��Ʋ
			TextTitle copyright2 = new TextTitle("2023��", new Font("�������", Font.PLAIN, 12));
			copyright2.setHorizontalAlignment(HorizontalAlignment.RIGHT);
			chart2.addSubtitle(copyright2); // ��Ʈ ���� Ÿ��Ʋ
			// ����
			chart2.getLegend().setItemFont(new Font("�������", Font.BOLD, 10));
			// plot ����
			CategoryPlot plot2 = chart2.getCategoryPlot();
			Font font = plot2.getDomainAxis().getLabelFont();
			// X�� ��
			plot2.getDomainAxis().setLabelFont(new Font("�������", font.getStyle(), font.getSize()));
			// X�� ������
			plot2.getDomainAxis().setTickLabelFont(new Font("�������", font.getStyle(), 10));
			font = plot2.getRangeAxis().getLabelFont();
			// Y�� ��
			plot2.getRangeAxis().setLabelFont(new Font("�������", font.getStyle(), font.getSize()));
			// Y�� ����
			plot2.getRangeAxis().setTickLabelFont(new Font("�������", font.getStyle(), 10));

			chartPanel2.setBounds(0, 0, 505, 330);

			add(chartPanel2);

		}
		statisticsAWT.p7.add(this);
	}

	public CategoryDataset createDataset() { // �Է� ��Ʈ ������
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		String sql = null;
		pool = DBConnectionMgr.getInstance();
		try {
			con = pool.getConnection();
			sql = "select *\r\n" + "from product\r\n" + "where PROD_STOCK>0";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				dataset.addValue(rs.getInt("PROD_STOCK"), rs.getString("PROD_NAME"), rs.getString("PROD_NAME"));
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
		return dataset;
	}
	
	public CategoryDataset createDataset2() { // ��� ��Ʈ ������
		DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
		String sql = null;
		pool = DBConnectionMgr.getInstance();
		try {
			con = pool.getConnection();
			sql = "select p.PROD_NAME, sum(t.TAKEOUT_AMOUNT)\r\n"
					+ "from takeout_log t, product p \r\n"
					+ "where p.PROD_CODE = t.PROD_CODE \r\n"
					+ "group by t.PROD_CODE";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				dataset2.addValue(rs.getInt("sum(t.TAKEOUT_AMOUNT)"), rs.getString("p.PROD_NAME"), rs.getString("p.PROD_NAME"));
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
		return dataset2;
	}
}
