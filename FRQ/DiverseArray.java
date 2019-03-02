public class DiverseArray{
	public static int arraySum(int[] arr){
		int sum = 0;
		for(int i=0;i<arr.length;i++){
			sum+=arr[i];
		}
		return sum;
	}
	public static int[] rowSums(int[][] arr2D){
		int[] array = new int[arr2D[0].length];
		for(int i=0;i<arr2D.length;i++){
			array[i]=arraySum(arr2D[i]);
		}
		return array;
	}
	public static boolean isDiverse(int[][] arr2D){
		int[] array = rowSums(arr2D);
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array.length;j++){
				if(array[i] == array[j])
					return false;
			}
		}
		return true;
	} 
}