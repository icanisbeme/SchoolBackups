import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AsciiArt {
	private char[][] image;
	private int nrRow;
	private int nrCol;

	public AsciiArt(String filename, int nrRow, int nrCol){
		image = new char[nrRow][nrCol];
		Scanner imageInput = null;
		File imageFile = new File(filename);
		try{
			imageInput = new Scanner(imageFile);
		}catch (FileNotFoundException e){
			System.out.println("Sorry, that file is invalid. Please try again.");
		}
		String line = "";
		for(int row = 0; row < nrCol; row++){
			line = imageInput.nextLine();
			for(int col = 0; col < nrCol; col++){
				image[row][col] = line.charAt(col);
			}
		}
	}

	private class Node{
		int row;
		int col;

		public Node(int row, int col){
			this.row = row;
			this.col = col;
		}
		public int getRow(){
			return row;
		}
		public int getCol(){
			return col;
		}
	}

	public void floodFill(int row, int col, char target, char replacement){
		Node newNode = new Node(row, col);
		floodFillNode(newNode, target, replacement);
	}
	
	
	public void floodFillNode(Node node, char target, char replacement){
		if(target == replacement){
			return;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		while(q.isEmpty() == false){
			Node n = q.remove();
			int nodeRow = n.getRow();
			int nodeCol = n.getCol();
			if(image[nodeRow][nodeCol] == target){
				image[nodeRow][nodeCol] = replacement;
				if(n.getCol()-1 > 0){
					Node westn = new Node(n.getRow(), n.getCol()-1);
					q.add(westn);
				}
				if(n.getCol()+1 < image.length){
					Node eastn = new Node(n.getRow(), n.getCol()+1);
					q.add(eastn);
				}
				if(n.getRow()-1 > 0){
					Node northn = new Node(n.getRow()-1, n.getCol());
					q.add(northn);
				}
				if(n.getRow()+1 < image[0].length){
					Node southn = new Node(n.getRow()+1, n.getCol());
					q.add(southn);
				}
			}
			return;
		}
	}

	public void replaceChar(char target, char replacement){
		for(int row = 0; row < image.length; row++){
			for(int col = 0; col < image[0].length; row++){
				if(image[row][col] == target){
					image[row][col] = replacement;
				}
			}
		}
	}

	public String toString(){
		String finalImage = "";
		for (int row = 0; row < nrRow; row++){
			for (int col = 0; col < nrCol; col++){
				finalImage += image[row][col];
			}
			finalImage += "\n";
		}
		return finalImage;
	}

	public void replaceArea(int row1, int col1, int row2, int col2, char replacement){
		for(int row = row1; row <= row2; row++){
			for(int col = col1; col <= col2; col++){
				image[row][col] = replacement;
			}
		}
	}

	public void save(String filename) throws IOException{
		PrintWriter saver = new PrintWriter(filename);
		saver.write(toString());
		saver.close();
	}
}