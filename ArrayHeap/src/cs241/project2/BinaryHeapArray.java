package cs241.project2;

public class BinaryHeapArray {
	private int[] heapArray;
	private int size;
	private int swapNum;
	public BinaryHeapArray(){
		size = 0;
		swapNum = 0;
		heapArray = new int[size];
	}
	public BinaryHeapArray(int num){
		size = 0;
		heapArray = new int[size];
	}
	public boolean isEmpty(){
		return size == 0;
	}
	public boolean isFull(){
		return size == heapArray.length;
	}
	private void resize(){
		int[] tempArray = new int[heapArray.length+1];
		for(int i = 0; i < heapArray.length;i++){
			tempArray[i] = heapArray[i];
		}
		heapArray = tempArray;
	}
	public void insertSeq(int num){
		if(!isFull()){
			heapArray[size] = num;
			reheapifyUp(size);
			size+=1;
		}
		else{
			resize();
			heapArray[size] = num;
			reheapifyUp(size);
			size+=1;
		}
	}
	private void reheapifyUp(int index){
		while(heapArray[index] > heapArray[((index-1)/2)] && index!=0){
			int temp = heapArray[index];
			heapArray[index]= heapArray[(index-1)/2];
			heapArray[(index-1)/2]= temp;
			index = (index-1)/2;
			swapNum+=1;
		}
	}
	public boolean deleteRoot(){
		if(isEmpty()){
			System.out.println("Tree is Empty");
			return false;
		}
		else{
			heapArray[0] = heapArray[size-1];
			reheapifyDown(0);
			size-=1;
			return true;
		}
	}
	public boolean deleteIndex(int index){
		if(isEmpty() || index > size-1){
			System.out.println("Invalid index or tree is Empty");
			return false;
		}
		else{
			heapArray[index]= heapArray[size-1];
			reheapifyDown(index);
			size-=1;
			return true;
		}
	}
	private void reheapifyDown(int index){
		while((2*index)+1 < size){
			int biggerChild = (2*index)+1;
			if((2*index)+2 < size){
				if(heapArray[2*index+1] < heapArray[(2*index)+2]){
					biggerChild = (2*index)+2;
				}
			}
			if(heapArray[index] < heapArray[biggerChild]){
				int temp = heapArray[index];
				heapArray[index] = heapArray[biggerChild];
				heapArray[biggerChild] = temp;
				swapNum+=1;
			}
			else{
				swapNum+=1;
				break;
			}
			index = biggerChild;
		}
	}
	
	public void printFirstTen(){
		for(int i = 0; i < 10; i++){
			System.out.print(heapArray[i] + ",");
		}
	}
	public void insertNoReHeap(int num){
		if(!isFull()){
			heapArray[size] = num;
			size+=1;
		}
		else{
			resize();
			heapArray[size] = num;
			size+=1;
		}
	}
	public void reheapOptimize(){
		int index = (size/2)-1;
		for(int i = index; i >= 0; i--){
			reheapifyDown(i);
		}
	}
	public int getSwapNum(){
		return swapNum;
	}

	
	public void clear(){
		size = 0;
	}
	
}
