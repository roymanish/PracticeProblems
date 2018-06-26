class TestClass {
    public static void main(String args[] ) throws Exception {
    	
            int i=0;
            int X = 22;
            int[] arr = new int[] {10,22,22,2,5,4};
            for(;i<arr.length;i++ ){
                
                if(arr[i] == X)
                    arr[i] = 0;
            }
            
            moveToEnd(arr);
            
            fillWithOne(arr);
        
            printArray(arr);

    }

	private static void printArray(int[] arr) {
		int j = 0;
		while(j<arr.length){
		    
		    System.out.println(arr[j]);
		    
		    j++;
		}
	}
    
    private static void moveToEnd(int[] arr){
        
        int size = arr.length;
        int numIndex = size-1, zeroIndex = size-1;
        
        while(numIndex >=0){
            
            while(numIndex >0 && arr[numIndex] == 0)
                numIndex--;
            
            while(zeroIndex >0 && arr[zeroIndex] != 0)
                zeroIndex--;
            
            if(numIndex < zeroIndex){
                swap(arr, numIndex, zeroIndex);
                zeroIndex--;
            }
            else{
                numIndex--;
            }
        }
    }
    
    private static void swap(int[] arr, int numIndex, int zeroIndex){
        
        int temp = arr[numIndex];
        arr[numIndex] = arr[zeroIndex];
        arr[zeroIndex] = temp;
    }
    
    private static void fillWithOne(int[] arr){
        
        int i = 0;
        while(i<arr.length){
            
            if(arr[i] == 0)
                arr[i] = 1;
            
            i++;
        }
    }
}
