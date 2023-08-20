public static int findSecondHighestNo(int[] arr) {
	if(arr.length < 2){
		return -1;
	}
	int largest = Integer.MIN_VALUE;
	for(int i: arr){
	   largest = Math.max(largest, i);
	}
	int secondLargest = Integer.MIN_VALUE;
	for(int i: arr){
		if(i != largest){
			secondLargest = Math.max(secondLargest, i);
		}
	}
	if(secondLargest == Integer.MIN_VALUE){
		return -1;
	}else{
		return secondLargest;
	}
}
//second solution
public static int findSecondHighestNo(int[] arr) {
	if (arr.length < 2){
		return -1;
	}
	int first = Integer.MIN_VALUE;
	int second = Integer.MIN_VALUE;
	for(int value: arr){
		if(value > first){
			second = first;
			first = value;
		}else if (value > second && value != first){
			second = value;
		}
	}
	if(second == Integer.MIN_VALUE){
		return -1;
	}else{
		return second;
}