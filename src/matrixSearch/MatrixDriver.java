package matrixSearch;

public class MatrixDriver {

	public static void main(String[] args) 
	{
		int[][] matrix = {{0, 1, 2, 3, 4,},
						 {5, 6, 7, 8, 9,},
						 {10, 11, 12, 13, 14,},
						 {15, 16, 17, 18, 19},
						 {20, 21, 22, 23, 24}};
		
		int[] index = MatrixSearch(matrix, 15);
		
		if(index[0] != -1 && index[1] != -1)
		{
			System.out.println("Value Found at: (" + index[0] + ", " + index[1] + ")");
			System.out.println(" (Row: " + (index[0] + 1) + " - Column: " + (index[1] + 1) + ")");
		}
		else
		{
			System.out.println("Value not found");
		}

	}
	
	public static int getIndex(int[] input, int target)
	{
		for(int k = 0; k < input.length; k++)
		{
			if(input[k] == target)
			{
				return k;
			}
		}
		return -1;
	}
	
	public static int[] MatrixSearch(int[][] arr, int key)
	{
		int maxRowNum = arr.length;
		
		int[] answer = {-1, -1};
		
		for(int i = 0; i < maxRowNum; i++)
		{
			if(key >= arr[i][0] && key <= arr[i][arr[i].length - 1])
			{
				int high = arr[i][arr[i].length - 1];
				int low = arr[i][0];
				int mid = (high + low) / 2;
				
				int colIndex = getIndex(arr[i],key);
				
				while(key >= low && key <= high)
				{
					
					if(mid > key)
					{
						high = mid - 1;
						mid = (low + high) / 2;
					}
					else if(mid < key)
					{
						low = mid + 1;
						mid = (low + high ) / 2;
					}
					else
					{
						answer[0] = i;
						answer[1] = colIndex;
						return answer;
					}
					
				} 
			}
		}
		return answer;
	}

}
