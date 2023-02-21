package warehouse;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class StatisticsAWT extends JPanel implements ActionListener {
	ImageIcon image;
	JPanel p1, p2, p3, p4, p5, p6, p7;
	JLabel statisticsTitle, history, invenStatus, categoryName, chart;
	JButton p1_btn1, p1_btn2, p1_btn3, p1_btn4;
	JButton p2_btn1, p2_btn2;
	JButton p3_btn1, p3_btn2;
	JButton p4_btn1, p4_btn2;
	JButton p6_btn1;
	JComboBox comboBox, comboBox2, comboBox3;
	JTextField textField, textField2;
	String cbText, tfText;
	String cbText2, tfText2;
	String cbText3;
	JTable table;
	JScrollPane scrollpane;
	Vector<Object> list;
	MainAWT mainAWT;
	int menuCheck = 0; // ��Ȳ�� ���� �޴� ī�װ� ��ư �г� ��ȯ Ȯ��
	int reciept_releaseCheck = 0; // ���׿� ���� �԰� ��� ��ư �г� ��ȯ Ȯ��
	boolean historySeacrhCheck, inventoryStatusSearchCheck;

// ----------------------------------------��� ������ ����----------------------------------------
	public StatisticsAWT(MainAWT mainAWT) {
		this.mainAWT = mainAWT;
		setLayout(null);
		menuPanel();
	}
// ----------------------------------------��� �޴� �г� ����----------------------------------------
	public void menuPanel() {
		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(44, 112, 147));
		p1.setBounds(0, 0, 133, 461);
		// ��� Ÿ��Ʋ
		image = new ImageIcon(".\\images\\statisticsTitle.png");
		statisticsTitle = new JLabel(image);
		statisticsTitle.setBounds(10, 30, 119, 48);
		// ����� ���� ��ư
		p1_btn1 = new JButton();
		p1_btn1.setIcon(new ImageIcon(".\\images\\statusBtn1_1.png"));
		p1_btn1.setRolloverIcon(new ImageIcon(".\\images\\statusBtn1_2.png"));
		p1_btn1.setBounds(20, 150, 110, 30);
		p1_btn1.setBorderPainted(false);// ��ư �׵θ� �����
		p1_btn1.setContentAreaFilled(false);// ��ư �����
		p1_btn1.setFocusable(false);
		p1_btn1.addActionListener(this);
		// ��� ��Ȳ ��ư
		p1_btn2 = new JButton();
		p1_btn2.setIcon(new ImageIcon(".\\images\\statusBtn2_1.png"));
		p1_btn2.setRolloverIcon(new ImageIcon(".\\images\\statusBtn2_2.png"));
		p1_btn2.setBounds(18, 200, 110, 30);
		p1_btn2.setBorderPainted(false);
		p1_btn2.setContentAreaFilled(false);
		p1_btn2.setFocusable(false);
		p1_btn2.addActionListener(this);
		// �Ⱓ�� ��Ʈ ��ư
		p1_btn3 = new JButton();
		p1_btn3.setIcon(new ImageIcon(".\\images\\statusBtn3_1.png"));
		p1_btn3.setRolloverIcon(new ImageIcon(".\\images\\statusBtn3_2.png"));
		p1_btn3.setBounds(18, 250, 110, 30);
		p1_btn3.setBorderPainted(false);
		p1_btn3.setContentAreaFilled(false);
		p1_btn3.setFocusable(false);
		p1_btn3.addActionListener(this);
		// Home ��ư
		p1_btn4 = new JButton();
		p1_btn4.setIcon(new ImageIcon(".\\images\\homeBtn.png"));
		p1_btn4.setRolloverIcon(new ImageIcon(".\\images\\homeBtn2.png"));
		p1_btn4.setBounds(6, 340, 125, 125);
		p1_btn4.setBorderPainted(false);
		p1_btn4.setContentAreaFilled(false);
		p1_btn4.setFocusable(false);
		p1_btn4.addActionListener(this);

		p1.add(statisticsTitle);
		p1.add(p1_btn1);
		p1.add(p1_btn2);
		p1.add(p1_btn3);
		p1.add(p1_btn4);
	
		mainAWT.mainPanel.add(p1);
		historySearchPanel();
	}
// ----------------------------------------����� ���� ��ȸ �г�----------------------------------------
	public void historySearchPanel() {
		p2 = new JPanel();
		p2.setLayout(null);
		p2.setBackground(new Color(0, 32, 96));
		p2.setBounds(132, 0, 552, 135);
		// ����� ���� Ÿ��Ʋ
		image = new ImageIcon(".\\images\\history.png");
		history = new JLabel(image);
		history.setBounds(10, 30, 290, 48);

		list = new Vector<>();
		list.add("��ǰ�ڵ�");
		list.add("����ȣ");
		comboBox = new JComboBox(list);
		comboBox.setBounds(25, 95, 90, 32);
		comboBox.addActionListener(this);
		cbText = "��ǰ�ڵ�";

		textField = new JTextField("");
		textField.setBounds(119, 95, 180, 32);
		textField.setColumns(10);
		// ��ȸ�ϱ� ��ư
		p2_btn1 = new JButton();
		p2_btn1.setIcon(new ImageIcon(".\\images\\check.png"));
		p2_btn1.setRolloverIcon(new ImageIcon(".\\images\\check_1.png"));
		p2_btn1.setBounds(305, 94, 115, 38);
		p2_btn1.setBorderPainted(false);
		p2_btn1.setContentAreaFilled(false);
		p2_btn1.setFocusable(false);
		p2_btn1.addActionListener(this);
		// ��ü��ȸ ��ư
		p2_btn2 = new JButton();
		p2_btn2.setIcon(new ImageIcon(".\\images\\checkAll.png"));
		p2_btn2.setRolloverIcon(new ImageIcon(".\\images\\checkAll_1.png"));
		p2_btn2.setBounds(420, 94, 115, 38);
		p2_btn2.setBorderPainted(false);
		p2_btn2.setContentAreaFilled(false);
		p2_btn2.setFocusable(false);
		p2_btn2.addActionListener(this);

		p2.add(history);
		p2.add(comboBox);
		p2.add(textField);
		p2.add(p2_btn1);
		p2.add(p2_btn2);

		mainAWT.mainPanel.add(p2);
		historyTablePanel();
	}
// ----------------------------------------����� ���� ���̺� �г�----------------------------------------
	public void historyTablePanel() {
		p3 = new JPanel();
		p3.setLayout(null);
		p3.setBackground(new Color(0, 32, 96));
		p3.setBounds(132, 135, 552, 326);

		// �԰��� ��ư
		p3_btn1 = new JButton();
		p3_btn1.setIcon(new ImageIcon(".\\images\\receiptHistoryBtn1.png"));
		p3_btn1.setRolloverIcon(new ImageIcon(".\\images\\receiptHistoryBtn2.png"));
		p3_btn1.setBounds(333, 280, 115, 38);
		p3_btn1.setBorderPainted(false);
		p3_btn1.setContentAreaFilled(false);
		p3_btn1.setFocusable(false);
		p3_btn1.addActionListener(this);
		// ����� ��ư
		p3_btn2 = new JButton();
		p3_btn2.setIcon(new ImageIcon(".\\images\\releaseHistoryBtn1.png"));
		p3_btn2.setRolloverIcon(new ImageIcon(".\\images\\releaseHistoryBtn2.png"));
		p3_btn2.setBounds(428, 280, 115, 38);
		p3_btn2.setBorderPainted(false);
		p3_btn2.setContentAreaFilled(false);
		p3_btn2.setFocusable(false);
		p3_btn2.addActionListener(this);
		p3.add(p3_btn1);
		p3.add(p3_btn2);
		// ������� ���̺� Ŭ���� ȣ��
		if (historySeacrhCheck) {
			new HistorySearchMgr(this, reciept_releaseCheck, cbText, tfText);
			mainAWT.mainPanel.add(p3);
		} else {
			new HistoryMgr(this, reciept_releaseCheck);
			mainAWT.mainPanel.add(p3);
		}
	}
// ----------------------------------------��� ��Ȳ ��ȸ �г�----------------------------------------
	public void inventoryStatusSearchPanel() {
		p4 = new JPanel();
		p4.setLayout(null);
		p4.setBackground(new Color(0, 32, 96));
		p4.setBounds(132, 0, 552, 160);
		// �� ��� ��Ȳ Ÿ��Ʋ
		image = new ImageIcon(".\\images\\invenStatus.png");
		invenStatus = new JLabel(image);
		invenStatus.setBounds(10, 30, 290, 48);
		// ī�װ� ��ǰ�� ��
		image = new ImageIcon(".\\images\\category&name.png");
		categoryName = new JLabel(image);
		categoryName.setBounds(164, 85, 210, 48);

		list = new Vector<>();
		list.add("����");
		list.add("��3");
		list.add("��2");
		list.add("��1");

		comboBox2 = new JComboBox(list);
		comboBox2.setBounds(175, 123, 65, 27);
		comboBox2.addActionListener(this);
		cbText2 = "����";

		textField2 = new JTextField("");
		textField2.setBounds(240, 123, 130, 27);
		textField2.setColumns(10);
		textField2.addActionListener(this);

		// ��ȸ�ϱ� ��ư
		p4_btn1 = new JButton();
		p4_btn1.setIcon(new ImageIcon(".\\images\\check2.png"));
		p4_btn1.setRolloverIcon(new ImageIcon(".\\images\\check2_1.png"));
		p4_btn1.setBounds(360, 94, 115, 62);
		p4_btn1.setBorderPainted(false);
		p4_btn1.setContentAreaFilled(false);
		p4_btn1.setFocusable(false);
		p4_btn1.addActionListener(this);
		// ��ü��ȸ ��ư
		p4_btn2 = new JButton();
		p4_btn2.setIcon(new ImageIcon(".\\images\\checkAll2.png"));
		p4_btn2.setRolloverIcon(new ImageIcon(".\\images\\checkAll2_1.png"));
		p4_btn2.setBounds(440, 94, 115, 62);
		p4_btn2.setBorderPainted(false);
		p4_btn2.setContentAreaFilled(false);
		p4_btn2.setFocusable(false);
		p4_btn2.addActionListener(this);

		p4.add(invenStatus);
		p4.add(categoryName);
		p4.add(comboBox2);
		p4.add(textField2);
		p4.add(p4_btn1);
		p4.add(p4_btn2);

		mainAWT.mainPanel.add(p4);
		inventoryStatusTablePanel();
	}
// ----------------------------------------��� ��Ȳ ���̺� �г�----------------------------------------
	public void inventoryStatusTablePanel() {
		p5 = new JPanel();
		p5.setLayout(null);
		p5.setBackground(new Color(0, 32, 96));
		p5.setBounds(132, 135, 552, 326);

		if (inventoryStatusSearchCheck) {
			new InventoryStatusSearchMgr(this, cbText2, tfText2);
			mainAWT.mainPanel.add(p5);
		} else {
			new InventoryStatusMgr(this);
			mainAWT.mainPanel.add(p5);
		}
	}
// ----------------------------------------�Ⱓ�� ��Ʈ �г�----------------------------------------
	public void chartPanel() {
		p6 = new JPanel();
		p6.setLayout(null);
		p6.setBackground(new Color(0, 32, 96));
		p6.setBounds(132, 0, 552, 90);
		// �� ��� ��Ȳ Ÿ��Ʋ
		image = new ImageIcon(".\\images\\chart.png");
		chart = new JLabel(image);
		chart.setBounds(10, 30, 290, 48);

		list = new Vector<>();
		list.add("�԰�");
		list.add("���");
	
		comboBox3 = new JComboBox(list);
		comboBox3.setBounds(327, 35, 90, 32);
		comboBox3.addActionListener(this);
		cbText3 = "�԰�";
		// ��ȸ�ϱ� ��ư
		p6_btn1 = new JButton();
		p6_btn1.setIcon(new ImageIcon(".\\images\\check.png"));
		p6_btn1.setRolloverIcon(new ImageIcon(".\\images\\check_1.png"));
		p6_btn1.setBounds(420, 34, 115, 38);
		p6_btn1.setBorderPainted(false);
		p6_btn1.setContentAreaFilled(false);
		p6_btn1.setFocusable(false);
		p6_btn1.addActionListener(this);
		p6.add(chart);
		p6.add(comboBox3);
		p6.add(p6_btn1);
	
		mainAWT.mainPanel.add(p6);
		chartInputPanel();
	}
// ----------------------------------------�Ⱑ�� ��Ʈ �ִ� �г�----------------------------------------	
	public void chartInputPanel() {
		p7 = new JPanel();
		p7.setLayout(null);
		p7.setBounds(133, 90, 551, 371);
		p7.setBackground(new Color(0, 32, 96));
		new GanttChartMgr(this, cbText3);
		mainAWT.mainPanel.add(p7);
	}
// ----------------------------------------��ư �̺�Ʈ----------------------------------------
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == p1_btn1) { // ����� ���� ��ư
			if (menuCheck == 0) {
				menuCheck = 0;
				p2.setVisible(false);
				p3.setVisible(false);
				historySearchPanel();
			} else if (menuCheck == 1) {
				menuCheck = 0;
				p4.setVisible(false);
				p5.setVisible(false);
				historySearchPanel();
			} else if (menuCheck == 2) {
				menuCheck = 0;
				p6.setVisible(false);
				p7.setVisible(false);//�߰�
				historySearchPanel();
			}
		} else if (obj == p1_btn2) { // ��� ��Ȳ ��ư
			if (menuCheck == 0) {
				menuCheck = 1;
				p2.setVisible(false);
				p3.setVisible(false);
				inventoryStatusSearchPanel();
			} else if (menuCheck == 1) {
				menuCheck = 1;
				p4.setVisible(false);
				p5.setVisible(false);
				inventoryStatusSearchPanel();
			} else if (menuCheck == 2) {
				menuCheck = 1;
				p6.setVisible(false);
				p7.setVisible(false);//�߰�
				inventoryStatusSearchPanel();
			}

		} else if (obj == p1_btn3) { // �Ⱓ�� ��Ʈ ��ư
			if (menuCheck == 0) {
				menuCheck = 2;
				p2.setVisible(false);
				p3.setVisible(false);
				chartPanel();
			} else if (menuCheck == 1) {
				menuCheck = 2;
				p4.setVisible(false);
				p5.setVisible(false);
				chartPanel();
			} else if (menuCheck == 2) {
				menuCheck = 2;
				p6.setVisible(false);
				p7.setVisible(false);
				chartPanel();
			}

		} else if (obj == p1_btn4) { // Home ��ư	
			mainAWT.mainPanel.setVisible(false);
			mainAWT.mainPanel();
		
		} else if (obj == comboBox) { // ����� ���� �޺� �ڽ�
			cbText = comboBox.getSelectedItem().toString();
		} else if (obj == p2_btn1) { // ����� ���� ��ȸ�ϱ� ��ư
			if (textField.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "�Էµ� ���� �����ϴ�.", "����", JOptionPane.INFORMATION_MESSAGE);
			} else {
				tfText = textField.getText();
				textField.setText("");
				textField.setFocusable(true);
				historySeacrhCheck = true;
				p3.setVisible(false);
				historyTablePanel();
			}
		} else if (obj == p2_btn2) { // ����� ���� ��ü��ȸ ��ư
			if (reciept_releaseCheck == 0) {
				historySeacrhCheck = false;
				p3.setVisible(false);
				historyTablePanel();
			} else if (reciept_releaseCheck == 1) {
				historySeacrhCheck = false;
				p3.setVisible(false);
				historyTablePanel();
			}
		} else if (obj == p3_btn1) { // �԰��� ��ư
			reciept_releaseCheck = 0;
			historySeacrhCheck = false;
			p3.setVisible(false);
			historyTablePanel();
		} else if (obj == p3_btn2) { // ����� ��ư
			reciept_releaseCheck = 1;
			historySeacrhCheck = false;
			p3.setVisible(false);
			historyTablePanel();
		} else if (obj == comboBox2) { // ��� ��Ȳ �޺� �ڽ�
			cbText2 = comboBox2.getSelectedItem().toString();
		} else if (obj == p4_btn1) { // ��� ��Ȳ ��ȸ�ϱ� ��ư
			if (textField2.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "�Էµ� ���� �����ϴ�.", "����", JOptionPane.INFORMATION_MESSAGE);
			} else {
				tfText2 = textField2.getText();
				textField2.setText("");
				textField2.setFocusable(true);
				inventoryStatusSearchCheck = true;
				p5.setVisible(false);
				inventoryStatusTablePanel();
			}
		} else if (obj == p4_btn2) { // ��� ��Ȳ ��ü��ȸ ��ư
			inventoryStatusSearchCheck = false;
			p5.setVisible(false);
			inventoryStatusTablePanel();
		} else if (obj == comboBox3) { // �Ⱑ�� ��Ʈ �޺� �ڽ�
			cbText3 = comboBox3.getSelectedItem().toString();
		} else if (obj == p6_btn1) { // �Ⱑ�� ��Ʈ ��ȸ�ϱ� ��ư
			p7.setVisible(false);
			chartInputPanel();
		}
	}
}
