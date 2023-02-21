package warehouse;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainAWT extends JFrame implements ActionListener {
	ImageIcon image;
	JLabel mainTitle;
	JPanel mainPanel;
	JButton mainReceivingBtn, mainReleaseBtn, mainStatisticsBtn;

	public MainAWT() {
		setTitle("â�� ���� ���α׷�");
		setSize(700, 500);// �������� ũ��
		setResizable(false);// â�� ũ�⸦ �������� ���ϰ�
		setLocationRelativeTo(null);// â�� ��� ������
		getContentPane().setLayout(null);
		mainPanel();
	}
// ----------------------------------------���� �г�----------------------------------------
	public void mainPanel() {
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBackground(new Color(0, 32, 96));
		mainPanel.setBounds(0,0,684,461);
		// �ΰ� �̹���
		image = new ImageIcon(".\\images\\mainTitle.png");
		mainTitle = new JLabel(image);
		mainTitle.setBounds(0, 15, 310, 90);
		// �԰�
		mainReceivingBtn = new JButton(new ImageIcon(".\\images\\mainReceivingBtn.png"));
		mainReceivingBtn.setRolloverIcon(new ImageIcon(".\\images\\mainReceivingBtn2.png"));
		mainReceivingBtn.setBounds(100, 170, 188, 188);
		mainReceivingBtn.setFocusPainted(false);
		mainReceivingBtn.setBorderPainted(false);
		mainReceivingBtn.setContentAreaFilled(false);
		mainReceivingBtn.addActionListener(this);
		// ���
		mainReleaseBtn = new JButton(new ImageIcon(".\\images\\mainReleaseBtn.png"));
		mainReleaseBtn.setRolloverIcon(new ImageIcon(".\\images\\mainReleaseBtn2.png"));
		mainReleaseBtn.setBounds(400, 170, 188, 188);
		mainReleaseBtn.setBorderPainted(false);
		mainReleaseBtn.setFocusPainted(false);
		mainReleaseBtn.setContentAreaFilled(false);
		mainReleaseBtn.addActionListener(this);
		// ���
		mainStatisticsBtn = new JButton(new ImageIcon(".\\images\\mainStatisticsBtn.png"));
		mainStatisticsBtn.setRolloverIcon(new ImageIcon(".\\images\\mainStatisticsBtn2.png"));
		mainStatisticsBtn.setBounds(620, 390, 50, 50);
		mainStatisticsBtn.setBorderPainted(false);
		mainStatisticsBtn.setContentAreaFilled(false);
		mainStatisticsBtn.setFocusable(false);
		mainStatisticsBtn.setContentAreaFilled(false);
		mainStatisticsBtn.addActionListener(this);
		

		mainPanel.add(mainReceivingBtn);
		mainPanel.add(mainReleaseBtn);
		mainPanel.add(mainStatisticsBtn);
		mainPanel.add(mainTitle);
		add(mainPanel);
		setVisible(true);
	}
// ----------------------------------------���� �г� ��ư �̺�Ʈ----------------------------------------
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == mainReceivingBtn) { // �԰� ��ư
			//TODO
		} else if (obj == mainReleaseBtn) { // ��� ��ư
			//TODO
		} else if (obj == mainStatisticsBtn) { // ��� ��ư
			//ainPanel.setVisible(false);
			mainPanel.removeAll();
			mainPanel.revalidate();
			mainPanel.repaint();
			new StatisticsAWT(this);
		}
	}
	public static void main(String[] args) {
		MainAWT main = new MainAWT();
	}
}