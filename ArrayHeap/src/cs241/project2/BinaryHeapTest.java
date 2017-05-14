package cs241.project2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BinaryHeapTest {
	public static void main(String[] args){
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		int userChoice = 0;
		do{
			System.out.println("================================================================================");
			printMenu();
			userChoice = keyboard.nextInt();
			switch(userChoice){
				case 1:
					int averageSeq = 0;
					int averageOpti = 0;
					for(int i = 0; i < 20; i++){
						BinaryHeapArray heapRandSeq = new BinaryHeapArray(100);
						Integer[] array = new Integer[100];
						for(int j = 0; j < array.length; j++){
							array[j] = j+1;
						}
						Collections.shuffle(Arrays.asList(array));
						for(int j = 0; j < array.length;j++){
							heapRandSeq.insertSeq(array[j]);
						}
						averageSeq+=heapRandSeq.getSwapNum();
					}
					
					for(int i = 0; i < 20; i++){
						BinaryHeapArray heapRandOpti = new BinaryHeapArray(100);
						Integer[] array1 = new Integer[100];
						for(int j = 0; j < array1.length; j++){
							array1[j] = j+1;
						}
						Collections.shuffle(Arrays.asList(array1));
						for(int j = 0; j < array1.length;j++){
							heapRandOpti.insertNoReHeap(array1[j]);
						}
						System.out.print("\n");
						heapRandOpti.reheapOptimize();
						averageOpti+=heapRandOpti.getSwapNum();
					}
					averageSeq = averageSeq/20;
					averageOpti = averageOpti/20;
					System.out.println("Average swaps for series of insertions: " + averageSeq);
					System.out.println("Average swaps for optimal method: " + averageOpti);
					break;
				case 2:
					BinaryHeapArray heapFixedSeq = new BinaryHeapArray(100);
					for(int i = 0; i < 100; i++){
						heapFixedSeq.insertSeq(i+1);
					}
					System.out.print("Heap built using series of insertions: ");
					heapFixedSeq.printFirstTen();
					System.out.println("...");
					System.out.println("Number of swaps: " + heapFixedSeq.getSwapNum());
					System.out.print("Heap after 10 removals: ");
					for(int i = 0; i < 10; i++){
						heapFixedSeq.deleteRoot();
					}
					heapFixedSeq.printFirstTen();
					System.out.println("...\n");

					
					BinaryHeapArray heapFixedOpti = new BinaryHeapArray(100);
					for(int i = 0; i < 100; i++){
						heapFixedOpti.insertNoReHeap(i+1);
					}
					heapFixedOpti.reheapOptimize();
					System.out.print("Heap built using optimal method: ");
					heapFixedOpti.printFirstTen();
					System.out.println("...");
					System.out.println("Number of swaps: " + heapFixedOpti.getSwapNum());
					System.out.print("Heap after 10 removals: ");
					for(int i = 0; i < 10; i++){
						heapFixedOpti.deleteRoot();
					}
					heapFixedOpti.printFirstTen();
					System.out.println("...\n");
					break;
				case 3:
					break;
				default:
					System.out.println("Invalid choice. Re-enter.");
					break;
			}
		}while(userChoice!=3);
	}
	private static void printMenu(){
		System.out.println("Please select how to test the program:");
		System.out.println("(1) 20 sets of 100 randomly generated integers");
		System.out.println("(2) Fixed integer values 1-100");
		System.out.println("(3) Exit");
	}
}
