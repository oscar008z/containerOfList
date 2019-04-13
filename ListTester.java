import java.util.*;
import java.io.*;

public class ListTester {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		final int[] N = {10, 100, 1000, 10000};
		MyArrayList dArray = new MyArrayList(5);
		MyLinkedList dLinkList = new MyLinkedList(Integer.class);
		ArrayList aList = new ArrayList();
		LinkedList lList = new LinkedList();
		
		String outPutInfo = "";
		
		double program_duration_millisecond;
		long program_start_time;
		long program_end_time;
		long program_duration;
		String[][] arrTimeInsert = new String[5][4];
		String[][] arrTimeRemove = new String[5][5];
		
		arrTimeInsert[0][1] = "Insert@start(ms)";
		arrTimeInsert[0][2] = "Insert@end(ms)";
		arrTimeInsert[0][3] = "Insert@random (ms)";
		
		arrTimeInsert[1][0] = "MyArrayList";
		arrTimeInsert[2][0] = "ArrayList";
		arrTimeInsert[3][0] = "MyLinkedList";
		arrTimeInsert[4][0] = "LinkedList";
		
		arrTimeRemove[0][1] = "Remove@start(ms)";
		arrTimeRemove[0][2] = "Remove@end(ms)";
		arrTimeRemove[0][3] = "Remove@random (ms)";
		arrTimeRemove[0][4] = "Removebyvalue (ms)";
		
		arrTimeRemove[1][0] = "MyArrayList";
		arrTimeRemove[2][0] = "ArrayList";
		arrTimeRemove[3][0] = "MyLinkedList";
		arrTimeRemove[4][0] = "LinkedList";
		
		Random r = new Random();
		System.out.println("\n============================================================BEGIN TEST============================================================\n");
		outPutInfo += "\n============================================================BEGIN TEST============================================================"+System.lineSeparator(); 
		for(int i=0; i<N.length; i++) {
			arrTimeInsert[0][0] = "N = " + N[i];
			arrTimeRemove[0][0] = "N = " + N[i];
			int randomSeed = 2*N[i]+1;
			int numberOfElements = N[i];
			
			program_start_time = System.nanoTime();
			for(int j=0; j<numberOfElements; j++) {
				int randomValue = r.nextInt(randomSeed);	//insertion from the head to myArraylist
				dArray.add(0,randomValue);
			}
			program_end_time = System.nanoTime();
			program_duration = program_end_time-program_start_time;
			program_duration_millisecond = ((double) program_duration/1000000);
			arrTimeInsert[1][1] = Double.toString(program_duration_millisecond);
			
			program_start_time = System.nanoTime();
			for(int j=0; j<numberOfElements; j++) {
				int randomValue = r.nextInt(randomSeed);	//insertion from the end to myArraylist
				dArray.add(randomValue);
			}
			program_end_time = System.nanoTime();
			program_duration = program_end_time-program_start_time;
			program_duration_millisecond = ((double) program_duration/1000000);
			arrTimeInsert[1][2] = Double.toString(program_duration_millisecond);
			
			program_start_time = System.nanoTime();
			for(int j=0; j<numberOfElements; j++) {
				int randomValue = r.nextInt(randomSeed);	//insertion in the random to location myArraylist
				int randomLocation = r.nextInt(dArray.size());
				dArray.add(randomLocation,randomValue);
			}
			program_end_time = System.nanoTime();
			program_duration = program_end_time-program_start_time;
			program_duration_millisecond = ((double) program_duration/1000000);
			arrTimeInsert[1][3] = Double.toString(program_duration_millisecond);
			
			program_start_time = System.nanoTime();
			for(int j=0; j<numberOfElements; j++) {
				int randomValue = r.nextInt(randomSeed);	//insertion from the head to Arraylist
				aList.add(0,randomValue);
			}
			program_end_time = System.nanoTime();
			program_duration = program_end_time-program_start_time;
			program_duration_millisecond = ((double) program_duration/1000000);
			arrTimeInsert[2][1] = Double.toString(program_duration_millisecond);
			
			program_start_time = System.nanoTime();
			for(int j=0; j<numberOfElements; j++) {
				int randomValue = r.nextInt(randomSeed);	//insertion from the end to Arraylist
				aList.add(randomValue);
			}
			program_end_time = System.nanoTime();
			program_duration = program_end_time-program_start_time;
			program_duration_millisecond = ((double) program_duration/1000000);
			arrTimeInsert[2][2] = Double.toString(program_duration_millisecond);
			
			program_start_time = System.nanoTime();
			for(int j=0; j<numberOfElements; j++) {
				int randomValue = r.nextInt(randomSeed);	//insertion in the random to location Arraylist
				int randomLocation = r.nextInt(aList.size());
				aList.add(randomLocation,randomValue);
			}
			program_end_time = System.nanoTime();
			program_duration = program_end_time-program_start_time;
			program_duration_millisecond = ((double) program_duration/1000000);
			arrTimeInsert[2][3] = Double.toString(program_duration_millisecond);
			
			program_start_time = System.nanoTime();
			for(int j=0; j<numberOfElements; j++) {		//insertion from the head to myLinkedlist
				int randomValue = r.nextInt(randomSeed);
				dLinkList.add(0,randomValue);
			}
			program_end_time = System.nanoTime();
			program_duration = program_end_time-program_start_time;
			program_duration_millisecond = ((double) program_duration/1000000);
			arrTimeInsert[3][1] = Double.toString(program_duration_millisecond);
			
			program_start_time = System.nanoTime();
			for(int j=0; j<numberOfElements; j++) {		//insertion from the end to myLinkedlist
				int randomValue = r.nextInt(randomSeed);
				dLinkList.add(randomValue);
			}
			program_end_time = System.nanoTime();
			program_duration = program_end_time-program_start_time;
			program_duration_millisecond = ((double) program_duration/1000000);
			arrTimeInsert[3][2] = Double.toString(program_duration_millisecond);
			
			program_start_time = System.nanoTime();
			for(int j=0; j<numberOfElements; j++) {
				int randomValue = r.nextInt(randomSeed);	//insertion in the random location to myLinkedlist
				int randomLocation = r.nextInt(dLinkList.size());
				dLinkList.add(randomLocation,randomValue);
			}
			program_end_time = System.nanoTime();
			program_duration = program_end_time-program_start_time;
			program_duration_millisecond = ((double) program_duration/1000000);
			arrTimeInsert[3][3] = Double.toString(program_duration_millisecond);
			
			program_start_time = System.nanoTime();
			for(int j=0; j<numberOfElements; j++) {		//insertion from the head to Linkedlist
				int randomValue = r.nextInt(randomSeed);
				lList.add(0,randomValue);
			}
			program_end_time = System.nanoTime();
			program_duration = program_end_time-program_start_time;
			program_duration_millisecond = ((double) program_duration/1000000);
			arrTimeInsert[4][1] = Double.toString(program_duration_millisecond);
			
			program_start_time = System.nanoTime();
			for(int j=0; j<numberOfElements; j++) {		//insertion from the end to Linkedlist
				int randomValue = r.nextInt(randomSeed);
				lList.add(randomValue);
			}
			program_end_time = System.nanoTime();
			program_duration = program_end_time-program_start_time;
			program_duration_millisecond = ((double) program_duration/1000000);
			arrTimeInsert[4][2] = Double.toString(program_duration_millisecond);
			
			program_start_time = System.nanoTime();
			for(int j=0; j<numberOfElements; j++) {
				int randomValue = r.nextInt(randomSeed);	//insertion in the random location to Linkedlist
				int randomLocation = r.nextInt(lList.size());
				lList.add(randomLocation,randomValue);
			}
			program_end_time = System.nanoTime();
			program_duration = program_end_time-program_start_time;
			program_duration_millisecond = ((double) program_duration/1000000);
			arrTimeInsert[4][3] = Double.toString(program_duration_millisecond);
			
			System.out.println("\n---------------------------------------------------Run Time for Insert Operations---------------------------------------------------\n");
			outPutInfo += "\n---------------------------------------------------Run Time for Insert Operations---------------------------------------------------"+System.lineSeparator();
			outPutInfo += createTable(arrTimeInsert, 5, 4);
			
			program_start_time = System.nanoTime();
			for(int j=0; j<numberOfElements; j++) {		//remove from head of myArrayLIst
				
				dArray.removeStart();
				//System.out.println(dArray.getRear());
				//System.out.println(dArray.getFront());
			}
			program_end_time = System.nanoTime();
			program_duration = program_end_time-program_start_time;
			program_duration_millisecond = ((double) program_duration/1000000);
			arrTimeRemove[1][1] = Double.toString(program_duration_millisecond);
			
			program_start_time = System.nanoTime();
			for(int j=0; j<numberOfElements; j++) {		//remove from end of myArrayLIst
				dArray.remove(dArray.getRear()-1);
			}
			program_end_time = System.nanoTime();
			program_duration = program_end_time-program_start_time;
			program_duration_millisecond = ((double) program_duration/1000000);
			arrTimeRemove[1][2] = Double.toString(program_duration_millisecond);
			
			program_start_time = System.nanoTime();
			for(int j=0; j<numberOfElements; j++) {		//remove from random location of myArrayList
				int min = dArray.getFront();
				int max = dArray.getRear();
				int randomLocation = r.nextInt((max - min) + 1) + min;
				dArray.remove(randomLocation);
			}
			program_end_time = System.nanoTime();
			program_duration = program_end_time-program_start_time;
			program_duration_millisecond = ((double) program_duration/1000000);
			arrTimeRemove[1][3] = Double.toString(program_duration_millisecond);
			
			for(int j=0; j<numberOfElements; j++) {
				int randomValue = r.nextInt(randomSeed);	
				dArray.add(randomValue);
			}
			
			program_start_time = System.nanoTime();
			int m=0;
			boolean flag;
			
			while(m<numberOfElements) {		//remove from myArrayList by value
				Object randomValue = r.nextInt(randomSeed);
				
				flag = dArray.remove(randomValue);
				//if(flag==true) {		
					m++;
				//}
			}
			program_end_time = System.nanoTime();
			program_duration = program_end_time-program_start_time;
			program_duration_millisecond = ((double) program_duration/1000000);
			arrTimeRemove[1][4] = Double.toString(program_duration_millisecond);
			
			//System.out.println("size:"+dArray.size());
			
			program_start_time = System.nanoTime();
			for(int j=0; j<numberOfElements; j++) {		//remove from head of ArrayLIst
				aList.remove(0);
			}
			program_end_time = System.nanoTime();
			program_duration = program_end_time-program_start_time;
			program_duration_millisecond = ((double) program_duration/1000000);
			arrTimeRemove[2][1] = Double.toString(program_duration_millisecond);
			
			program_start_time = System.nanoTime();
			for(int j=0; j<numberOfElements; j++) {		//remove from end of ArrayLIst
				aList.remove(aList.size()-1);
			}
			program_end_time = System.nanoTime();
			program_duration = program_end_time-program_start_time;
			program_duration_millisecond = ((double) program_duration/1000000);
			arrTimeRemove[2][2] = Double.toString(program_duration_millisecond);
			
			program_start_time = System.nanoTime();
			for(int j=0; j<numberOfElements; j++) {		//remove from random location of ArrayList
				int randomLocation = r.nextInt(aList.size());
				aList.remove(randomLocation);
			}
			program_end_time = System.nanoTime();
			program_duration = program_end_time-program_start_time;
			program_duration_millisecond = ((double) program_duration/1000000);
			arrTimeRemove[2][3] = Double.toString(program_duration_millisecond);
			
			for(int j=0; j<numberOfElements; j++) {
				int randomValue = r.nextInt(randomSeed);	
				aList.add(randomValue);
			}
			
			program_start_time = System.nanoTime();
			m=0;
			flag = false;
			while(m<numberOfElements) {		//remove from ArrayList by value
				Object randomValue = r.nextInt(randomSeed);
				flag = aList.remove(randomValue);
				//if(flag==true) {
					m++;
				//}
			}
			program_end_time = System.nanoTime();
			program_duration = program_end_time-program_start_time;
			program_duration_millisecond = ((double) program_duration/1000000);
			arrTimeRemove[2][4] = Double.toString(program_duration_millisecond);
			
			//System.out.println("size:"+dLinkList.size());
			
			program_start_time = System.nanoTime();
			for(int j=0; j<numberOfElements; j++) {		//remove from head of myLinkedLIst
				dLinkList.remove(0);
			}
			program_end_time = System.nanoTime();
			program_duration = program_end_time-program_start_time;
			program_duration_millisecond = ((double) program_duration/1000000);
			arrTimeRemove[3][1] = Double.toString(program_duration_millisecond);
			
			
			
			program_start_time = System.nanoTime();
			for(int j=0; j<numberOfElements; j++) {		//remove from end of myLinkLIst
				dLinkList.remove(dLinkList.size()-1);
			}
			program_end_time = System.nanoTime();
			program_duration = program_end_time-program_start_time;
			program_duration_millisecond = ((double) program_duration/1000000);
			arrTimeRemove[3][2] = Double.toString(program_duration_millisecond);
			
			
			program_start_time = System.nanoTime();
			for(int j=0; j<numberOfElements; j++) {		//remove from random location of myLinkList
				int randomLocation = r.nextInt(dLinkList.size());
				dLinkList.remove(randomLocation);
			}
			program_end_time = System.nanoTime();
			program_duration = program_end_time-program_start_time;
			program_duration_millisecond = ((double) program_duration/1000000);
			arrTimeRemove[3][3] = Double.toString(program_duration_millisecond);
			
			
			for(int j=0; j<numberOfElements; j++) {
				int randomValue = r.nextInt(randomSeed);	
				dLinkList.add(randomValue);
			}
			
			program_start_time = System.nanoTime();
			m=0;
			flag = false;
			while(m<numberOfElements) {		//remove from myLinkList by value
				Object randomValue = r.nextInt(randomSeed);
				flag = dLinkList.remove(randomValue);
				//if(flag==true) {
					m++;
				//}
			}
			program_end_time = System.nanoTime();
			program_duration = program_end_time-program_start_time;
			program_duration_millisecond = ((double) program_duration/1000000);
			arrTimeRemove[3][4] = Double.toString(program_duration_millisecond);
			
			program_start_time = System.nanoTime();
			for(int j=0; j<numberOfElements; j++) {		//remove from head of LinkedLIst
				lList.remove(0);
			}
			program_end_time = System.nanoTime();
			program_duration = program_end_time-program_start_time;
			program_duration_millisecond = ((double) program_duration/1000000);
			arrTimeRemove[4][1] = Double.toString(program_duration_millisecond);
			
			program_start_time = System.nanoTime();
			for(int j=0; j<numberOfElements; j++) {		//remove from end of LinkLIst
				lList.remove(lList.size()-1);
			}
			program_end_time = System.nanoTime();
			program_duration = program_end_time-program_start_time;
			program_duration_millisecond = ((double) program_duration/1000000);
			arrTimeRemove[4][2] = Double.toString(program_duration_millisecond);
			
			program_start_time = System.nanoTime();
			for(int j=0; j<numberOfElements; j++) {		//remove from random location of LinkList
				int randomLocation = r.nextInt(lList.size());
				lList.remove(randomLocation);
			}
			program_end_time = System.nanoTime();
			program_duration = program_end_time-program_start_time;
			program_duration_millisecond = ((double) program_duration/1000000);
			arrTimeRemove[4][3] = Double.toString(program_duration_millisecond);
			
			for(int j=0; j<numberOfElements; j++) {
				int randomValue = r.nextInt(randomSeed);	
				lList.add(randomValue);
			}
			
			program_start_time = System.nanoTime();
			m=0;
			flag = false;
			while(m<numberOfElements) {		//remove from LinkList by value
				Object randomValue = r.nextInt(randomSeed);
				flag = lList.remove(randomValue);
				//if(flag==true) {
					m++;
				//}
			}
			program_end_time = System.nanoTime();
			program_duration = program_end_time-program_start_time;
			program_duration_millisecond = ((double) program_duration/1000000);
			arrTimeRemove[4][4] = Double.toString(program_duration_millisecond);
			System.out.println("\n---------------------------------------------------Run Time for Remove Operations---------------------------------------------------\n");
			outPutInfo += "\n---------------------------------------------------Run Time for Remove Operations---------------------------------------------------"+System.lineSeparator();
			outPutInfo += createTable(arrTimeRemove, 5, 5);
			if(i!=N.length-1) {
				System.out.println("\n============================================================NEXT TEST============================================================\n");
				outPutInfo += "\n============================================================NEXT TEST============================================================"+System.lineSeparator();
			}
			else {
				System.out.println("\n=============================================================END TEST=============================================================\n");
				outPutInfo += "\n=============================================================END TEST============================================================="+System.lineSeparator();
			}	
		}
		File file = new File("testrun.txt");	//create an object of File class for storing the result of program execution
		if(!file.exists())
			file.createNewFile();	//if the file doesn't exist, create the file
		BufferedWriter bwr = new BufferedWriter(new FileWriter(file,true));	//create the object of IO write stream
		bwr.write(outPutInfo);	//write the result of program execution to the target file
		bwr.close();	//close the IO stream	
	}
	
	public static String createTable(String[][] cells, int rows, int columns) {
		String outPut = "";
		for(int i=0; i<rows;i++) {
			for(int j=0; j<columns; j++) {
				cells[i][j] = String.format("%-30s", cells[i][j]);
				System.out.print(cells[i][j]);
				outPut += cells[i][j];
			}
			System.out.print("\n");
			outPut += System.lineSeparator();
		}
		return outPut;
	}
}