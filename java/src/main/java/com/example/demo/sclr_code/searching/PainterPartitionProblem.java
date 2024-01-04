package com.example.demo.sclr_code.searching;

public class PainterPartitionProblem {

	public static void main(String[] args) {
		int[] arr = {1000000, 1000000};
		int painter = 1;
		int unitCost = 1000000; 
		
		System.out.println(paint(painter, unitCost, arr));

	}
	
	 public static int timeToPaint(int[] arr, int painter, int t){
	        //find search space 
	        int max = arr[0]; 
	        long totalTime = 0;
	        for(int i=0; i<arr.length; i++){        //getting max of array and total time to paint all board by one painter 
	            if(arr[i] > max){
	                max = arr[i];
	            }
	            totalTime = totalTime + arr[i]*t; 
	        }
	        long L = max*t; long R = totalTime; 
	        long ans = 0;
	        while(L<=R){
	            long mid = (L+R)/2; 
	            int painterCount = minimumPainter(arr, mid, t);
	            if(painterCount == painter){
	                ans = mid; 
	                R=mid-1;
	            }
	            else if(painterCount > painter){
	                L = mid+1; 
	            }else{
	                R = mid-1;
	            }
	        }
	        return (int)ans%10000003;
	    }
	    public static int minimumPainter(int[] arr, long maxTime, int t){     //t = time required to paint 1 unit
	        int painter = 1; long timeLeft = maxTime; 
	        for(int i=0; i<arr.length; i++){
	            if(arr[i]*t > maxTime) return -1; 
	            if (arr[i]*t <= timeLeft){
	                timeLeft = timeLeft - arr[i]*t;

	            }else{
	                painter++; 
	                timeLeft = maxTime - arr[i]*t ; 
	            }
	        } 
	        return painter; 
	    }
	    

	    
	//correct one , understand this     
	public static int paint(int A, int B, int[] C) {
		int mod=10000003;
	   	int n=C.length;
	   	int max=0;
	    int sum=0;
	    int ans=-1;
	    //finding max and sum
	   	for(int i=0;i<n;i++){
	   		max=Math.max(max,C[i]);
	    	sum+=C[i];
	    }

	    int left=max;
	   	int right=sum;

	    while(left<=right){
	    	int mid=(left+right)/2;
	    	if(possible(C,A,mid)){
	    		ans=mid;
	    		right=mid-1;// move to left
	    	}
	    	else{
	    		left=mid+1; // move to right
	    	}
	    }
	    return (int) (ans * (long) B % 10000003);
    }
	
	public static boolean possible(int [] C, int A, int mid){
		int need=1;
	   	int painted=0;

	    for(int i=0;i<C.length;i++){
	    	painted+=C[i];
	    	if(painted>mid){
	    		need++;
	    		painted=C[i];
	    	}
	    }
	    return need<=A;
	}
	        
}//class end

	














