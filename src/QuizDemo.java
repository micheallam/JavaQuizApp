import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class QuizDemo extends JFrame implements ActionListener, ItemListener {
	//============================================================================
	//Variables
	final int SCREEN_WIDTH = 350;
	final int SCREEN_HEIGHT = 360;
	
	int totalscore = 0;
	int points = 5;
	boolean correctAnswer = false;
	
	JLabel label;
	JLabel question1;
	JLabel question2;
	JLabel question3;
	JLabel question4;
	JLabel score;
	JButton submit;
	
	//Answer checkboxes
	JCheckBox q1a1;
	JCheckBox q1a2;
	JCheckBox q1a3;
	JCheckBox q1a4;
	
	JCheckBox q2a1;
	JCheckBox q2a2;
	JCheckBox q2a3;
	JCheckBox q2a4;
	
	JCheckBox q4a1;
	JCheckBox q4a2;
	JCheckBox q4a3;
	JCheckBox q4a4;
	
	ButtonGroup aGroup = new ButtonGroup(); // for question1
	ButtonGroup bGroup = new ButtonGroup(); // for question2 
	ButtonGroup cGroup = new ButtonGroup(); // for question4 
	
	String[] trueFalse = {"Pick Answer","True", "False"};
	JComboBox q3 = new JComboBox(trueFalse); // the drop down answers for question3
	//===========================================================================
	//Constructor
	public QuizDemo() {
		super("JAVA QUIZ");
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		label = new JLabel("233J Quiz Application");
		label.setFont(new Font("Arial", Font.BOLD, 25));
		
		score = new JLabel("Score: /20");
		score.setFont(new Font("Arial", Font.BOLD, 25));
		
		submit = new JButton("Submit");
		
		//===============================
		//Setting questions
		question1 = new JLabel("1) A variable can be referenced from its");
		question1.setFont(new Font("Arial", Font.ITALIC, 13));
		
		question2 = new JLabel("2) Methods referenced wigth individual objects are");
		question2.setFont(new Font("Arial", Font.ITALIC, 13));
		
		question3 = new JLabel("3) Most Class Data Fields are Private");
		question3.setFont(new Font("Arial", Font.ITALIC, 13));
		
		question4 = new JLabel("4) Java classes are stored in a folder of");
		question4.setFont(new Font("Arial", Font.ITALIC, 13));
		//===============================
		//Settings up the answers fro each question
		q1a1 = new JCheckBox("Range", false);
		q1a2 = new JCheckBox("Space", false);
		q1a3 = new JCheckBox("Domain", false);
		q1a4 = new JCheckBox("Scope", false);
		
		aGroup.add(q1a1);
		aGroup.add(q1a2);
		aGroup.add(q1a3);
		aGroup.add(q1a4);
		
		q2a1 = new JCheckBox("Private", false);
		q2a2 = new JCheckBox("Public", false);
		q2a3 = new JCheckBox("Static", false);
		q2a4 = new JCheckBox("NonStatic", false);
		
		bGroup.add(q2a1);
		bGroup.add(q2a2);
		bGroup.add(q2a3);
		bGroup.add(q2a4);
		
		q4a1 = new JCheckBox("Packet", false);
		q4a2 = new JCheckBox("Package", false);
		q4a3 = new JCheckBox("Bundle", false);
		q4a4 = new JCheckBox("Gaggle", false);
		
		cGroup.add(q4a1);
		cGroup.add(q4a2);
		cGroup.add(q4a3);
		cGroup.add(q4a4);
		
		//Item Listener for checkbox answers
		q1a1.addItemListener(this);
		q1a2.addItemListener(this);
		q1a3.addItemListener(this);
		q1a4.addItemListener(this);
		q2a1.addItemListener(this);
		q2a2.addItemListener(this);
		q2a3.addItemListener(this);
		q2a4.addItemListener(this);
		q4a1.addItemListener(this);
		q4a2.addItemListener(this);
		q4a3.addItemListener(this);
		q4a4.addItemListener(this);
		q3.addItemListener(this);
		//Action Listener for button
		submit.addActionListener(this);
		
		//==========================
		//Add them to the GUI
		add(label);
		add(question1); //Question1 and answers
		add(q1a1);
		add(q1a2);
		add(q1a3);
		add(q1a4);
		add(question2); //Question 2 and answers
		add(q2a1);
		add(q2a2);
		add(q2a3);
		add(q2a4);
		add(question3); //Question 3 and booleans
		add(q3);
		add(question4); //Question4  and answers
		add(q4a1);
		add(q4a2);
		add(q4a3);
		add(q4a4);
		add(submit);
		add(score);
	}

	//===========================================================================
	//Submit button
	@Override
	public void actionPerformed(ActionEvent ae) {
		score.setText("Score: " + totalscore + "/20");
		totalscore = 0; //reset the score
	}
	//===========================================================================
	//Deals with the fields and right answers
	@Override
	public void itemStateChanged(ItemEvent e) {
		Object source = e.getSource();
		int select = e.getStateChange(); //the selection
		//Question 1
		if(source == q1a4) {
			if(select == ItemEvent.SELECTED) {
				correctAnswer = true;
			}else if(select == ItemEvent.DESELECTED) {
				correctAnswer = false;
			}
		}
		//Question 2
		else if(source == q2a4) {
			if(select == ItemEvent.SELECTED) {
				correctAnswer = true;
			}else if(select == ItemEvent.DESELECTED) {
				correctAnswer = false;
			}
		}
		//question 3
		else if(source == q3) {
			int positionOfSelection = q3.getSelectedIndex();
			if(select == ItemEvent.SELECTED) {
				if(positionOfSelection == 1) {
					correctAnswer = true;
				}else {
					correctAnswer = false;
				}
			}
		}
		//question 4
		else if(source == q4a2) {
			if(select == ItemEvent.SELECTED) {
				correctAnswer = true;
			}else if(select == ItemEvent.DESELECTED) {
				correctAnswer = false;
			}
		}
		//Calculates the answer
		if(correctAnswer) {
			totalscore += points;
			correctAnswer = false;
		}

	}
}
