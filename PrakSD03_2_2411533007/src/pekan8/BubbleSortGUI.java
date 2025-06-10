package pekan8;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class BubbleSortGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private int[] array;
	private JLabel[] labelArray;
	private JButton stepButton, resetButton, setButton;
	private JTextField inputField;
	private JPanel panelArray;
	private JTextArea stepArea;
	
	private int i = 1, j;
	private boolean sorting = false;
	private int stepCount = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BubbleSortGUI frame = new BubbleSortGUI();
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
	public BubbleSortGUI() {
		setTitle("Bubbl Sort Langkah per Langkah");
		setSize(750, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		//Panel input
		JPanel inputPanel = new JPanel (new FlowLayout());
		inputField = new JTextField(30);
		setButton = new JButton("Set Array");
		inputPanel.add(new JLabel("Masukan angka (pisahkan dengan koma):"));
		inputPanel.add(inputField);
		inputPanel.add(setButton);
		
		//Panel array visual
		panelArray = new JPanel();
		panelArray.setLayout(new FlowLayout());
		
		//Panel kontrol
		JPanel controlPanel = new JPanel();
		stepButton = new JButton("Langkah selanjutnya");
		resetButton = new JButton ("Reset");
		stepButton.setEnabled(false);
		controlPanel.add(stepButton);
		controlPanel.add(resetButton);
		
		//Area teks unutk log langkah-langkah
		stepArea = new JTextArea(8, 60);
		stepArea.setEditable(false);
		stepArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
		JScrollPane scrollPane = new JScrollPane(stepArea);
		
		//Tambahkan panel ke frame
		add(inputPanel, BorderLayout.NORTH);
		add(panelArray, BorderLayout.CENTER);
		add(controlPanel, BorderLayout.SOUTH);
		add(scrollPane, BorderLayout.EAST);
		
		//Even   t Set Array
		setButton.addActionListener(e -> setArrayFromInput());
		
		//Event Langkah Selanjutnya
		stepButton.addActionListener(e -> performStep());
		
		//Event reset
		resetButton.addActionListener(e -> reset());	
	}
	
	//Function setArray
	private void setArrayFromInput() {
		String text = inputField.getText().trim();
		if (text.isEmpty()) return;
		String[] parts = text.split(",");
		array = new int[parts.length];
		try {
			for (int k = 0; k < parts.length; k++) {
				array[k] = Integer.parseInt(parts[k].trim()); }
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Masukkan hanya angka " + " yang dipisahkan dengan koma!", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		i = 0;
		j = 0;
		stepCount = 1;
		sorting = true;
		stepButton.setEnabled (true);
		stepArea.setText("");
		panelArray.removeAll();
		labelArray = new JLabel [array.length];
		for (int k = 0; k < array.length; k++) {
			labelArray[k] = new JLabel (String.valueOf(array[k]));
			labelArray[k].setFont(new Font("Arial", Font.BOLD, 24));
			labelArray[k].setOpaque(true);
			labelArray[k].setBackground(Color.WHITE);			
			labelArray[k].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			labelArray[k].setPreferredSize(new Dimension(50,50));
			labelArray[k].setHorizontalAlignment(SwingConstants.CENTER);
			panelArray.add(labelArray[k]);
		}
		panelArray.revalidate();
		panelArray.repaint();
	}
	
	
	//Functon 
	private void performStep() {
		if (!sorting || i >= array.length - 1) {
			sorting = false;
			stepButton.setEnabled(false);
			JOptionPane.showMessageDialog(this, "Sorting selesei!");
			return;
		}
		resetHighLights();
		StringBuilder stepLog = new StringBuilder();
		labelArray[j].setBackground(Color.CYAN);
		labelArray[j + 1].setBackground(Color.CYAN);
		if (array[j] > array[j + 1]) {
			//swap
			int temp = array[j];
			array[j] = array [j + 1];
			array [j + 1] = temp;
			labelArray[j].setBackground(Color.RED);
			labelArray[j + 1].setBackground(Color.RED);
			stepLog.append("Langkah ").append(array[j + 1]).append(": Menukar elemen ke-")
			.append(j).append(" (").append(array[j + 1]).append(") dengan ke -")
			.append(j + 1).append(" (").append(array[j]).append(") \n");
		} else {
			stepLog.append("Langkah ").append(stepCount).append(": Tidak ada pertukaran antara ke-")
			.append(j).append(" dan ke -").append(j + 1).append("\n");	
		}
		stepLog.append("Hasil: ").append(arrayToString(array)).append("\n\n");
		stepArea.append(stepLog.toString());
		updateLabels();
		j++;
		if (j >= array.length - i - 1) {
			j = 0;
			i++;
		}
		stepCount++;
		if (i >= array.length - 1) {
			sorting = false;
			stepButton.setEnabled(false);
			JOptionPane.showMessageDialog(this, "Sorting selesei!");
		}
	}
	
	//Function
	private void updateLabels() {
		for (int k = 0; k < array.length; k++) {
			labelArray[k].setText(String.valueOf(array[k]));
		}
	}
	
	//Function
	private void resetHighLights() {
		for (JLabel label : labelArray) {
			label.setBackground(Color.WHITE);
		}
	}
	
	//Function
	private void reset () {
		inputField.setText("");
		panelArray.removeAll();
		panelArray.revalidate();
		panelArray.repaint();
		stepArea.setText("");
		stepButton.setEnabled(false);
		sorting = false;
		i = 0;
		j = 0;
		stepCount = 1;
	}
	
	//Function
	private String arrayToString(int[] arr) {
		StringBuilder sb = new StringBuilder();
		for (int k = 0; k < arr.length; k++) {
			sb.append(arr[k]);
			if (k < arr.length - 1) sb.append(", ");
		}
		return sb.toString();
	}
}
