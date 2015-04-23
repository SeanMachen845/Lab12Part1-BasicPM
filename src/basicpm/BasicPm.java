/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicpm;

import java.text.DecimalFormat;
import java.util.Random;

public class BasicPm
{

    // order of the polynomials
      static int N = 2000;
    // storing first polynomial, no of coefficients = order+1 hence size = order + 1
    static double[] p = new double[N+1];
    // storing second polynomial, no of coefficients = order+1 hence size = order + 1
    static double[] q = new double[N+1];
    // storing the product of the polynomials
    // the order of the product will always be 2*order, hence size will be 2*order+1
    static double[] pq = new double[(2*N)+1];
    // function that prints the polynomials
    static void printPoly(double []a, int length)
    {
        for(int z=0 ; z<length ; z++)
        {
            System.out.print(a[z]);
            if(z>0)
                System.out.print(" X^"+z);
            System.out.println();
        }
    }
    public static void main(String[] args)
    {
        double forDistribution;
        //assign sizes and values randomly
        Random randomGenerator = new Random();
        //format to 5 decimal place
        DecimalFormat oneDigit = new DecimalFormat("#.#####");
        // Fill in size and values of items with random numbers between -1 and 1 inclusive
        for(int i=0 ; i<=N ; i++)
        {
            // the nextdouble method gives values from 0 to 1 but we want to have values from -1 to 1
            // hence we multiply by 2 and then subtract 1 from it to get values between that range
            forDistribution = randomGenerator.nextDouble() * 2 - 1;
            p[i] = Double.valueOf(oneDigit.format(forDistribution));
            forDistribution = randomGenerator.nextDouble() * 2 - 1;
            q[i] = Double.valueOf(oneDigit.format(forDistribution));
        }
        System.out.println("------------------------------------");
        System.out.println("The first polynomial=");
        System.out.println("------------------------------------");
        long startTime = System.currentTimeMillis();
        printPoly(p, p.length);
        long endTime1 = System.currentTimeMillis();
        System.out.println("First Polynomial time = " + (endTime1 - startTime));
        System.out.println("------------------------------------");
        System.out.println("The second polynomial=");
        System.out.println("------------------------------------");
        startTime = System.currentTimeMillis();
        printPoly(q, q.length);
        long endTime2 = System.currentTimeMillis();
        System.out.println("Second Polynomial time = " + (endTime2 - startTime));
        System.out.println("------------------------------------");
        // multiply coefficients of p to all the coefficient of q and store in pq
        for(int i=0 ; i<(N+1) ; i++)
        {
            for(int j=0 ; j<(N+1) ; j++)
            {
                pq[i+j] += Double.valueOf(oneDigit.format(p[i]*q[j]));
            }
        }
        // printing the product
        System.out.println("The multiplication product");
        System.out.println("------------------------------------");
        startTime = System.currentTimeMillis();
        printPoly(pq, pq.length);
        long endTime3 = System.currentTimeMillis();
        System.out.println("Product Polynomial time = " + (endTime3 - startTime));
    }
}