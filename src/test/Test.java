/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hakan
 */
public class Test {
    
    static long GCDtime = 0;
    static long primeTime = 0;
    
    public static List<Integer> primeFactors(int number) {
        int n = number;
        List<Integer> factors = new ArrayList<Integer>();
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        return factors;
    }
    
    // hoayydaa
    
    public static boolean primeCheck(int num){
        long startTime = System.nanoTime();
        boolean isPrime=true;
        
        if (num == 1){
            long endTime = System.nanoTime();
        
            primeTime = primeTime + (endTime - startTime);
            return false;
        }
            
        int temp;
	
        
	for(int i=2;i<=num/2;i++)
	{
           temp=num%i;
	   if(temp==0)
	   {
	      isPrime=false;
	      break;
	   }
	}
        
        long endTime = System.nanoTime();
        
        primeTime = primeTime + (endTime - startTime);
        
        
        return isPrime;
    }
    
    public static int sumOfGCD(int N){
        int sum = 0;
        
        for (int i = 1; i <= N; i++){
            boolean check = false;
            check = primeCheck(i);

            for(int j = 1; j<=i; j++){
                if(i == j){
                    sum = sum + i;
                }
                else if (check)
                {
                    sum = sum + 1;
                }
                else
                    sum = sum + GCD(i,j);
            }
        } 
        return sum;
    }
    
    public static int GCD(int n1, int n2){
        
        long startTime = System.nanoTime();
        
        int gcd = 1;
        int high;
        int low;
        boolean check = true;
       
        if (n1 > n2)
        {
            high = n1;
            low = n2;
        }
        else if (n2 > n1)
        {
            high = n2;
            low = n1;
        }
        else return n1;
        
        while(check == true){
            double div = (double)high/(double)low;
            if (div % 1 == 0.0){
                gcd = low;
                break;
            }
            else
            {
                int temp1 = high % low;
                int temp2 = low;
            
                high = temp2;
                low = temp1;   
            }
        }
        
        
        long endTime = System.nanoTime();
        
        GCDtime = GCDtime + (endTime - startTime);
        
        return gcd;
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int x = sumOfGCD(10); // %998244353
        
        List<Integer> primeFactor = primeFactors(12);
        
        
        System.out.println(x);
        
        //System.out.println(GCDtime);
        //System.out.println(primeTime);
    }
    
    
    
    
}
