/*
 * Brittanie Pham
 * CSIS 1410
 * A07 changing images
 */

package a07_changing_images;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * the class DressUp allows you to change articles of clothing on a human body by selecting certain items
 * @author Brittanie Pham
 *
 */
public class DressUp extends JFrame {

	private JPanel contentPane;
	int shirtNum = 4;
	int pantsNum = 1;
	int hatNum = 1;
	int bgNum = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DressUp frame = new DressUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DressUp() {
		makeWindow();
		JPanel panel = makeControlPanel();
		JLabel lblNewLabel = youChooseLabel();
		JCheckBox shirtBox = shirtCheckBox();
		JCheckBox pantsBox = pantsCheckBox();
		JCheckBox hatBox = hatCheckBox();
		JPanel panel_1 = makeDressUpPanel();
		JLabel backgroundImage = makeBackgroundImage(panel_1);
		JLabel hatImage = makeHatImage(panel_1);
		JLabel shirtImage = makeShirtImage(panel_1);
		JLabel pantsImage = makePantsImage(panel_1);
		makeBodyImage(panel_1);
		JButton btnUpdate = updateButtonListener(shirtBox, pantsBox, hatBox, backgroundImage, hatImage, shirtImage, pantsImage);
		groupLayoutPanel(panel, lblNewLabel, shirtBox, pantsBox, hatBox, btnUpdate);
	}

	/**
	 * creates a panel with the layout of group layout
	 * @param panel
	 * @param lblNewLabel
	 * @param shirtBox
	 * @param pantsBox
	 * @param hatBox
	 * @param btnUpdate
	 */
	private void groupLayoutPanel(JPanel panel, JLabel lblNewLabel, JCheckBox shirtBox, JCheckBox pantsBox,
			JCheckBox hatBox, JButton btnUpdate) {
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 85, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 4, Short.MAX_VALUE)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addGap(14))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addComponent(pantsBox, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(19, Short.MAX_VALUE))))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(shirtBox, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
					.addGap(14))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(hatBox, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(47)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(shirtBox)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pantsBox)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(hatBox, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnUpdate)
					.addContainerGap(187, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}

	/**
	 * creates a new button called "update" that allows a person to submit what items they want to change
	 * @param shirtBox
	 * @param pantsBox
	 * @param hatBox
	 * @param backgroundImage
	 * @param hatImage
	 * @param shirtImage
	 * @param pantsImage
	 * @return
	 */
	private JButton updateButtonListener(JCheckBox shirtBox, JCheckBox pantsBox, JCheckBox hatBox,
			JLabel backgroundImage, JLabel hatImage, JLabel shirtImage, JLabel pantsImage) {
		JButton btnUpdate = new JButton("update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(shirtBox.isSelected() == true) {
					if(shirtNum < 9) {
						shirtNum += 1;
					} else {
						shirtNum = 4;
					}
					shirtImage.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass()
							.getResource("/a07_changing_images/body/shirt" + shirtNum + ".png"))
							.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
				}
				
				if(pantsBox.isSelected() == true) {
					if(pantsNum < 7) {
						pantsNum += 1;
					} else {
						pantsNum = 1;
					}
					pantsImage.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass()
							.getResource("/a07_changing_images/body/pants" + pantsNum + ".png"))
							.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH)));
				}
				
				if(hatBox.isSelected() == true) {
					if(hatNum < 10) {
						hatNum += 1;
					} else {
						hatNum = 1;
					}
					hatImage.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass()
							.getResource("/a07_changing_images/body/hat" + hatNum + ".png"))
							.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
				}
				
				if(shirtBox.isSelected() == false && pantsBox.isSelected() == false && hatBox.isSelected() == false) {
					if(bgNum < 3) {
						bgNum += 1;
					} else {
						bgNum = 1;
					}
					backgroundImage.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass()
							.getResource("/a07_changing_images/body/bg" + bgNum + ".png"))
							.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
				}
			}
		});
		return btnUpdate;
	}

	/**
	 * makes a new label and sets the icon to a body image
	 * @param panel_1
	 */
	private void makeBodyImage(JPanel panel_1) {
		JLabel bodyImage = new JLabel("");
		bodyImage.setBounds(-11, 0, 354, 500);
		bodyImage.setIcon(new ImageIcon(DressUp.class
				.getResource("/a07_changing_images/body/body.png")));
		panel_1.add(bodyImage);
	}

	/**
	 * makes a new label and sets the icon to an image of pants
	 * @param panel_1
	 * @return
	 */
	private JLabel makePantsImage(JPanel panel_1) {
		JLabel pantsImage = new JLabel("");
		pantsImage.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/a07_changing_images/body/pants1.png"))
				.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH)));
		pantsImage.setBounds(17, 125, 217, 292);
		panel_1.add(pantsImage);
		return pantsImage;
	}

	/**
	 * makes a new label and sets the icon to a shirt image
	 * @param panel_1
	 * @return
	 */
	private JLabel makeShirtImage(JPanel panel_1) {
		JLabel shirtImage = new JLabel("");
		shirtImage.setSize(new Dimension(10, 10));
		shirtImage.setBackground(Color.WHITE);
		shirtImage.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/a07_changing_images/body/shirt4.png"))
				.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
		shirtImage.setBounds(63, 82, 161, 177);
		panel_1.add(shirtImage);
		return shirtImage;
	}

	/**
	 * makes a new label and sets the icon to an image of a hat
	 * @param panel_1
	 * @return
	 */
	private JLabel makeHatImage(JPanel panel_1) {
		JLabel hatImage = new JLabel("");
		hatImage.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/a07_changing_images/body/hat1.png"))
				.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		hatImage.setBounds(104, 6, 84, 85);
		panel_1.add(hatImage);
		return hatImage;
	}

	/**
	 * makes a new label and sets the icon to an image of a background accent
	 * @param panel_1
	 * @return
	 */
	private JLabel makeBackgroundImage(JPanel panel_1) {
		JLabel backgroundImage = new JLabel("");
		backgroundImage.setBounds(26, -45, 232, 182);
		panel_1.add(backgroundImage);
		return backgroundImage;
	}

	/**
	 * creates a new panel
	 * @return
	 */
	private JPanel makeDressUpPanel() {
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		return panel_1;
	}

	/**
	 * creates a checkbox for the hat item
	 * @return
	 */
	private JCheckBox hatCheckBox() {
		JCheckBox hatBox = new JCheckBox("hat");
		hatBox.setHorizontalAlignment(SwingConstants.CENTER);
		return hatBox;
	}

	/**
	 * creates a checkbox for the pants item
	 * @return
	 */
	private JCheckBox pantsCheckBox() {
		JCheckBox pantsBox = new JCheckBox("pants");
		pantsBox.setHorizontalAlignment(SwingConstants.CENTER);
		return pantsBox;
	}

	/**
	 * creates a checkbox for the shirt item
	 * @return
	 */
	private JCheckBox shirtCheckBox() {
		JCheckBox shirtBox = new JCheckBox("shirt");
		shirtBox.setHorizontalAlignment(SwingConstants.CENTER);
		return shirtBox;
	}

	/**
	 * creates a label to prompt the user to select checkboxes
	 * @return
	 */
	private JLabel youChooseLabel() {
		JLabel lblNewLabel = new JLabel("You choose...");
		return lblNewLabel;
	}

	/**
	 * creates the control panel
	 * @return
	 */
	private JPanel makeControlPanel() {
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		return panel;
	}

	/**
	 * makes the window
	 */
	private void makeWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 385, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
}
