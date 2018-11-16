//Bond Ragsdale 16081102

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import static javafx.scene.chart.XYChart.*;
import javafx.geometry.Insets;
import java.util.ArrayList;
import java.util.Random;

public class RagsdaleP2 extends Application {
	public static void main(String[] args) {
		RagsdaleP2.launch(args);
	}

	private static final int
	BAR_COUNT = 14,
	MAX_BAR_HEIGHT = 50;

	private static final String
	COLOR_ACTIVE = "-fx-bar-fill: #f64",
	COLOR_INITIAL = "-fx-bar-fill: #888",
	COLOR_FINALIZED = "-fx-bar-fill: #3cf",
	COLOR_MIN = "-fx-bar-fill: #0f0",
	COLOR_INTERMEDIATE = "-fx-bar-fill: #ff0";

	private static int
	DELAY_MILLIS = 700;

	@Override
	public void start(Stage stage) {
		stage.setTitle("Sorting Animations");
		stage.setWidth(800);
		stage.setHeight(600);

		final BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(10));

		final BarChart<String,Number> chart = new BarChart<>(new CategoryAxis(), new NumberAxis(0, MAX_BAR_HEIGHT, 0));
		chart.setLegendVisible(false);
		chart.getYAxis().setTickLabelsVisible(false);
		chart.getYAxis().setOpacity(0);
		chart.getXAxis().setTickLabelsVisible(false);
		chart.getXAxis().setOpacity(0);
		chart.setHorizontalGridLinesVisible(false);
		chart.setVerticalGridLinesVisible(false);

		bars = new ArrayList<Data<String,Number>>();
		final Series<String,Number> data = new Series<>();
		chart.getData().add(data);
		for (int i = 0; i < BAR_COUNT; i++) {
			bars.add(new Data<>(Integer.toString(i+1), 1));
			data.getData().add(bars.get(i));
			paint(i, COLOR_INITIAL);
		}
		pane.setCenter(chart);

		inputs = new FlowPane();
		inputs.setHgap(5);
		inputs.setVgap(5);
		createButton("Randomize", () -> randomizeAll());
		createButton("Swap Halves", () -> swapHalves());
		createButton("Reverse", () -> reverse());
		createButton("Bubble Sort", () -> bubbleSort());
		createButton("Selection Sort", () -> selectionSort());
		createButton("Insertion Sort", () -> insertionSort());
		createButton("Delay: 50ms", () -> delay50());
		createButton("Delay: 350ms", () -> delay350());
		createButton("Delay: 700ms", () -> delay700());
		createButton("Delay: 1400ms", () -> delay1400());
		pane.setBottom(inputs);

		stage.setScene(new Scene(pane));
		stage.show();

		Platform.runLater(() -> randomizeAll());
	}

	private ArrayList<Data<String,Number>> bars;
	private FlowPane inputs;

	private void createButton(String label, Runnable method) {
		final Button test = new Button(label);
		test.setOnAction(event -> new Thread(() -> {
			Platform.runLater(() -> inputs.setDisable(true));
			method.run();
			Platform.runLater(() -> inputs.setDisable(false));
		}).start());
		inputs.getChildren().add(test);
	}

	// CHART ACCESSORS AND MUTATORS

	private void assign(int index, int value) {
		bars.get(index).setYValue(value);
	}

	private int retrieve(int index) {
		return (int) bars.get(index).getYValue();
	}

	// ANIMATION CONTROLS

	private void paint(int index, final String style) {
		Platform.runLater(() -> {
			bars.get(index).getNode().setStyle(style);
		});
	}

	private void paintAll(final String style) {
		Platform.runLater(() -> {
			for (int i = 0; i < BAR_COUNT; i++) paint(i, style);
		});
	}

	private void delay() {
		try {
			Thread.sleep(DELAY_MILLIS);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// ALGORITHMS FOR BUTTONS

	private void randomizeAll() {
		Random random = new Random();
		for (int i = 0; i < BAR_COUNT; i++) {
			assign(i, random.nextInt(MAX_BAR_HEIGHT) + 1);
		}
	}

	private void swapHalves() {
		final int half = bars.size()/2;
		final int offset = bars.size() % 2;
		for (int i = 0; i < half; i++) {
			final int j = i + half + offset;

			paint(i, COLOR_ACTIVE);
			paint(j, COLOR_ACTIVE);

			int temp = retrieve(i);
			assign(i, retrieve(j));
			assign(j, temp);

			delay();

			paint(i, COLOR_FINALIZED);
			paint(j, COLOR_FINALIZED);
		}
		paintAll(COLOR_INITIAL);
	}
/**
 * This reverse method takes the bars that are on opposite ends of the set, and swaps their height values
 */
	private void reverse(){
		for (int i = 0; i < BAR_COUNT - BAR_COUNT/2; i++){
			int barComp = BAR_COUNT- i - 1;
			paint(barComp, COLOR_ACTIVE);
			paint(i, COLOR_ACTIVE);
			int temp = retrieve(i);
			assign(i, retrieve(barComp));
			assign(barComp, temp);
			delay();	
			paint(i, COLOR_FINALIZED);
			paint(barComp, COLOR_FINALIZED);
		}paintAll(COLOR_INITIAL);
	}
/**
 * The bubbleSort method evaluates the height of two adjacent bars, and if the bar in the greater index position
 * is lower, the bar heights are swapped, and the method moves down the set
 */
	private void bubbleSort(){
		for (int i = 0; i < BAR_COUNT; i++){
			for(int j = 0; j < BAR_COUNT-i-1; j++){
				paint(j, COLOR_ACTIVE);
				paint(j+1, COLOR_ACTIVE);
				if (retrieve(j) > retrieve(j+1)){
					int height = retrieve(j);
					assign(j, retrieve(j+1));
					assign(j+1, height);
				}
				delay();
				paint(j,COLOR_INITIAL);
			}
			paint(BAR_COUNT-i-1,COLOR_FINALIZED);
		}paintAll(COLOR_INITIAL);
	}
/**
 * This selectionSort method evaluates two bars, and sets the first bar in the set as the minimum. If there 
 * is a new bar that is the smallest thus far, then it is assigned to the value 
 * minIndex, and is the new minimum standard, and is also moved to the space to the right of 
 * the previous minIndex
 */
	private void selectionSort(){
		for (int i = 0; i < BAR_COUNT-1; i++)
		{
			paint(i, COLOR_MIN);
			int minIndex = i;
			for (int j = i + 1; j <= BAR_COUNT - 1; j++){
				paint(j, COLOR_ACTIVE);
				delay();
				if (retrieve(j) < retrieve(minIndex)){
					{
						paint(minIndex, COLOR_INITIAL);
						minIndex = j;
						
						paint(minIndex, COLOR_MIN);	
					}
				} else {
					paint(j, COLOR_INITIAL);
				}
			}
			int temp = retrieve(minIndex);
			assign(minIndex, retrieve(i));
			assign(i, temp);
			paint(minIndex, COLOR_INITIAL);
			paint(i, COLOR_FINALIZED);
			delay();
			
		}paintAll(COLOR_INITIAL);
	}

/**
 * The insertionSort method functions in such a way that the bar at index i is compared to the bars ahead of
 * it, and based on those heights, it is inserted into its proper place so that the bars below it 
 * are shorter and the one to the right of it is taller
 */
	
	private void insertionSort(){
		int temp;
		for(int i = 1; i < bars.size(); i++){
			for(int j = i; j > 0; j--){
				if(retrieve(j) < retrieve(j-1)){
					temp = retrieve(j);
					assign(j, retrieve(j-1));
					assign(j-1, temp);
					paint(0, COLOR_INTERMEDIATE);
					paint(j, COLOR_INTERMEDIATE);
					paint(i, COLOR_ACTIVE);
					delay();
					paint(i, COLOR_INITIAL);
				}
			}
			delay();
		}paintAll(COLOR_INITIAL);
	}
/**
 * lines 247-261 are methods that adjust the delay time based on what button the user clicks
 */
	private void delay50(){
		DELAY_MILLIS = 50;
	}

	private void delay350(){
		DELAY_MILLIS = 350;
	}

	private void delay700(){
		DELAY_MILLIS = 700;
	}

	private void delay1400(){
		DELAY_MILLIS = 1400;
	}
}