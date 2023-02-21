package warehouse;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import ch08.interfaceEx2;

@SuppressWarnings("serial")
public class StockInAWT extends JFrame implements ActionListener{

	JPanel p1,p2,p3;
	static JPanel p4;
	JButton b1,b2,b3,regBtn, search, correct, delete;
	JLabel label, label2, l3,label3;
	static JTextField pf[] = new JTextField[7];
	static JLabel pl[] = new JLabel[7];
	JTextField searchField;
	Font myFont1 = new Font("���� ���", Font.BOLD, 15);
	int menuCheck = 0;
	
	int num[] = new int[7];
	DefaultTableModel model;
	LoadStockin loadStockin;
	
	class imgPanel extends JPanel{ //�԰��ϱ� �ȿ� �ִ� �г�
		Image background=new ImageIcon(StockInAWT.class.getResource("/warehouse/images/releaseBox.png")).getImage();
		public void paint(Graphics g) {//�׸��� �Լ�
				g.drawImage(background, 0, 0, null);//background�� �׷���		
		}
	};
	
	public StockInAWT() {
		setBounds(500, 300, 700, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setTitle("StockInAWT");
		
		menuPanel();
		setVisible(true);
//		validate();
	}
	
	public void menuPanel(){
		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(44,112,147));
		p1.setBounds(0, 0, 133, 461);
		
		
		label = new JLabel();
		label.setIcon(new ImageIcon(StockInAWT.class.getResource("/warehouse/images/receiveTitle.png")));
		label.setBounds(28, 34, 102, 66);
		p1.add(label);
		
		b1 = new JButton("");
		b1.setBounds(20, 130, 100, 50);
		b1.setIcon(new ImageIcon(StockInAWT.class.getResource("/warehouse/images/receiveBtn1_1.png")));
		b1.setRolloverIcon(new ImageIcon(StockInAWT.class.getResource("/warehouse/images/receiveBtn1_2.png")));
		b1.setBorderPainted(false);
		b1.setContentAreaFilled(false);
		b1.setFocusable(false);
		b1.addActionListener(this);
		p1.add(b1);
		
		b2 = new JButton("");
		b2.setBounds(20, 190, 100, 50);
		b2.setIcon(new ImageIcon(StockInAWT.class.getResource("/warehouse/images/receiveBtn2_1.png")));
		b2.setRolloverIcon(new ImageIcon(StockInAWT.class.getResource("/warehouse/images/receiveBtn2_2.png")));
		b2.setBorderPainted(false);
		b2.setContentAreaFilled(false);
		b2.setFocusable(false);
		b2.addActionListener(this);
		p1.add(b2);
		
		b3 = new JButton("");
		b3.setBounds(20, 350, 100, 100);
		b3.setIcon(new ImageIcon(StockInAWT.class.getResource("/warehouse/images/homeBtn.png")));
		b3.setRolloverIcon(new ImageIcon(StockInAWT.class.getResource("/warehouse/images/homeBtn2.png")));
		b3.setBorderPainted(false);
		b3.setContentAreaFilled(false);
		b3.setFocusable(false);
		b3.addActionListener(this);
		p1.add(b3);
		add(p1);
	
		rightPanel();	//�԰��ϱ� ������ ����
	}

	public void rightPanel(){ //�԰��ϱ�
		
		
		JLabel bar[] = new JLabel[7];
		
		
		p2 = new JPanel();
		p2.setLayout(null); 
		p2.setBackground(new Color(0,32,96));
		p2.setBounds(132, 0, 552, 461);
		add(p2);
		
		label2 = new JLabel();
		label2.setIcon(new ImageIcon(StockInAWT.class.getResource("/warehouse/images/receiving.png")));
		label2.setBounds(28, 34, 150, 50);
		p2.add(label2);

		Panel startP = new Panel();
		startP.setBackground(Color.white);
		startP.setLayout(null);
		startP.setBounds(50, 130, 450, 300);
		p2.add(startP);
		
		pl[0] = new JLabel("��ǰ�ڵ� : ");
		pl[1] = new JLabel("ī�װ� : ");
		pl[2] = new JLabel("��ǰ�� : ");
		pl[3] = new JLabel("������ : ");
		pl[4] = new JLabel("���� : ");
		pl[5] = new JLabel("�԰���� : ");
		pl[6] = new JLabel("����ȣ : ");
		
		for (int i = 0; i < 7; i++) {
			if(i%2 == 1) {
				pl[i].setBounds(220, 20+(60*(i/2)), 80, 30);
			} else {
				pl[i].setBounds(20, 20+(60*(i/2)), 80, 30);
			}
			pl[i].setFont(myFont1);
			startP.add(pl[i]);
		}
		
		for (int i = 0; i < 7; i++) {
			pf[i] = new JTextField("");
			if(i%2 == 1) {
				pf[i].setBounds(300, 20+(60*(i/2)), 100, 30);
			} else {
				pf[i].setBounds(100, 20+(60*(i/2)), 100, 30);
			}
			pf[i].setBorder(null);
			startP.add(pf[i]);
		}
		
		regBtn = new JButton();
		regBtn.setBounds(310, 250, 130, 40);
		regBtn.setIcon(new ImageIcon(StockInAWT.class.getResource("/warehouse/images/regist.png")));
		regBtn.addActionListener(this);
		startP.add(regBtn);
		
		for (int i = 0; i < 7; i++) {
			bar[i] = new JLabel();
			if(i%2 == 1) {
				bar[i].setBounds(220,20+(60*(i/2)),200,70);
			} else {
				bar[i].setBounds(20,20+(60*(i/2)),200,70);
			}
			bar[i].setIcon(new ImageIcon(StockInAWT.class.getResource("/warehouse/images/panelBar.png")));
			startP.add(bar[i]);
		}
		
	}
	
	public void setBorder(Border border) {
		
	}
	
	public void rightPanel2() { //�԰���Ȳ
		p3 = new JPanel();
		p3.setLayout(null); 
		p3.setBackground(new Color(0,32,96));
		p3.setBounds(132, 0, 552, 461);
		add(p3);
		
		label3 = new JLabel();
		label3.setIcon(new ImageIcon(StockInAWT.class.getResource("/warehouse/images/recieptStatus.png")));
		label3.setBounds(28, 34, 150, 50);
		p3.add(label3);
		
		JButton search = new JButton();
		search.setBounds(120, 100, 50, 25);
		search.setIcon(new ImageIcon(StockInAWT.class.getResource("/warehouse/images/search.png")));
		search.setFocusable(false);
		p3.add(search);
		
		searchField = new JTextField("�˻�â");
		searchField.setBounds(200, 100, 200, 25);
		p3.add(searchField);
		
		JButton searchBtn = new JButton();
		searchBtn.setBounds(400, 100, 30, 25);
		searchBtn.setIcon(new ImageIcon(StockInAWT.class.getResource("/warehouse/images/searchBtn.png")));
		searchBtn.setFocusable(false);
		p3.add(searchBtn);
		
		correct = new JButton();
		correct.setBounds(350, 400, 50, 25);
		correct.setIcon(new ImageIcon(StockInAWT.class.getResource("/warehouse/images/modifyBtn.png")));
		correct.addActionListener(this);
		correct.setFocusable(false);
		p3.add(correct);
		
		delete = new JButton();
		delete.setBounds(420, 400, 50, 25);
		delete.setIcon(new ImageIcon(StockInAWT.class.getResource("/warehouse/images/deleteBtn.png")));
		delete.addActionListener(this);
		delete.setFocusable(false);
		p3.add(delete);
		
		p4 = new JPanel();
		p4.setBounds(25, 160, 505, 230);
		p3.add(p4);
		
		loadStockin = new LoadStockin(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String str[] = new String[6];
		
		int check = 0;
		if(obj == b1) {
			if(menuCheck == 0) {
			} else if(menuCheck == 1) {
				p3.setVisible(false);
				rightPanel();
				revalidate();
				repaint();
				menuCheck = 0;
			}
			System.out.println("1�� ��ư!!!!!!!!!" + menuCheck);
		}else if(obj==b2){
			if(menuCheck == 0) {
				p2.setVisible(false);
				rightPanel2();
				revalidate();
				repaint();
				menuCheck = 1;
			} else if(menuCheck == 1) {
			}
			
			System.out.println("2�� ��ư!!!!!!!!!" + menuCheck);
		}else if(obj==b3) {			
			for (int i = 0; i < 6; i++) {
				str[i] = pf[i].getText();
				System.out.println(str[i]);
			}
			
		}else if(obj == regBtn){	//��� ��ư
			for (int i = 0; i < 6; i++) {
				str[i] = pf[i].getText();
				if(str[i].isEmpty()) { //�� üũ
					System.out.println("��");
					JOptionPane.showMessageDialog(null, pl[i].getText() + "�� ���� �ֽ��ϴ�");
					check++;
				}
			}
			
			if(check == 0) { //�� ������ ���̺� �߰�
				new startStockIn(model,str);
			}
			for (int i = 0; i < 6; i++) {
				pf[i].setText("");
			} //������
			check = 0;
		}else if(obj==correct) {	//���� ��ư
			int row = loadStockin.row;
			int col = loadStockin.col;
			loadStockin.correct(row,col);
			System.out.println(row + "�� ���� �Ϸ�");
			
		}else if(obj==delete) {		//���� ��ư
			int row = loadStockin.mrow;
			loadStockin.delete(row);
			p3.setVisible(false);
			rightPanel2();
			revalidate();
			repaint();
			System.out.println(row + "�� ���� �Ϸ�");
		}
	}

	public static void main(String[] args) {
		new StockInAWT();
	}
}
