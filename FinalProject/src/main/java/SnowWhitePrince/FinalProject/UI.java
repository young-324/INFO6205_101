package SnowWhitePrince.FinalProject;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class UI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI frame = new UI();
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
	public UI() {

		in = new Involke();
		setTitle("Best Pattern of Game");
		findBestPattern.addActionListener(new findBestPattern());
		startGameBtn.addActionListener(new StartGameActioner());
		buttonPanel.add(findBestPattern);
		buttonPanel.add(startGameBtn);
		buttonPanel.setBackground(Color.WHITE);
		getContentPane().add("North", buttonPanel);
		startGameBtn.setEnabled(false);
		this.setSize(1000, 1000);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private class findBestPattern implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!startGameBtn.isEnabled()) {
				//String geneCells = in.Start(100, 15);	
				String geneCells="001100010110011110111011110110010101001101110101111010111011011011000011000000011010010000010101111111101001001001011100000101101010110110000110110010101100010110011110010110010110101011110011001010101101010111000010110000110";
				cellMatrix = MorphologicalTransformation.transferFromGenotypeToArray(geneCells, 15);
				cellMatrix = MorphologicalTransformation.transSmallArrayToLargeArray(cellMatrix);
				
				

				startGameBtn.setEnabled(true);

			} else {
				stop = true;
				isStart = false;
				startGameBtn.setEnabled(false);
		
				startGameBtn.setText("Start");
			}
		}

	}

	private void showMatrix(int[][] cells) {

		// int[][] matrix = cellMatrix.getMatrix();
		for (int y = 0; y < cells.length; y++) {
			for (int x = 0; x < cells[0].length; x++) {
				if (cells[y][x] == 1) {
					textMatrix[y][x].setBackground(Color.BLACK);
				} else {
					textMatrix[y][x].setBackground(Color.WHITE);
				}
			}
		}
	}

	/**
	 * Create gridlayout
	 */
	private void initGridLayout(int[][] cells) {
		int rows = cells.length;
		int cols = cells[0].length;
		gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(rows, cols));
		textMatrix = new JTextField[rows][cols];
		for (int y = 0; y < rows; y++) {
			for (int x = 0; x < cols; x++) {
				JTextField text = new JTextField();
				textMatrix[y][x] = text;
				gridPanel.add(text);
			}
		}
		add("Center", gridPanel);
	}

	private class StartGameActioner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!isStart) {
				findBestPattern.setEnabled(false);
				new Thread(new GameControlTask(cellMatrix)).start();
				isStart = true;
				stop = false;
				startGameBtn.setText("Stop");
			} else {
				stop = true;
				isStart = false;
				startGameBtn.setText("Start");
				findBestPattern.setEnabled(true);
			}
		}

	}

	private class GameControlTask implements Runnable {
		int[][] cells;

		public GameControlTask(int[][] cell) {
			cells = cell;
		}

		@Override
		public void run() {
			Next nextGen = new Next();
			while (!stop) {
				// cellMatrix.transform();
				cells = nextGen.nextGenration(cells);
				initGridLayout(cells);
				showMatrix(cells);
				gridPanel.updateUI();

				try {
					Thread.sleep(duration);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}

		}
	}
	
	

	private Involke in;
	private JButton findBestPattern = new JButton("Find a best pattern");
	private JButton startGameBtn = new JButton("Start Game of Life");
	private boolean isStart = false;
	private boolean stop = false;
	private JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
	private JPanel gridPanel = new JPanel();
	private int[][] cellMatrix;
	private JTextField[][] textMatrix;
	/**
	 * thread sleep time 1 second
	 */
	private int duration = 1000;

}
