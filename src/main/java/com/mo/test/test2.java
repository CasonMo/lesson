package com.mo.test;

import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: PeiHsien Mo
 * Date: 2019/11/12
 * Time: 13:10
 */
public class test2 {
    public static double cpair1(int []S,int n){//S为一维空间的点的集合，n为点的个数
        if (n < 2) return Integer.MAX_VALUE;//点的个数小于2，点对的距离无穷大
        //m是S各点坐标中位数，将S分解为S1和S2，使得S1={x|x<=m} S2={x|x>m}；
        int m=(min(S,0,n)+max(S,0,n))/2;
        int []S1 = new int[n];
        int []S2 = new int[n];
        //记录两个分组的长度
        int j=0,k=0;
        //s1全部小于=m，s2全部大于m
        for (int i = 0; i < n; i++)
        {
            if(S[i]<=m)
            {
                S1[j]=S[i];
                j++;
            }
            else
            {
                S2[k] = S[i];
                k++;
            }
        }
        double d1=cpair1(S1,j);//S1中有j个点，递归求得S1中最接近点对的距离
        double d2=cpair1(S2,k); //S2中有k个点，递归求得S2中最接近点对的距离
        int p=max(S1,0,j);//S1中最大的点
        int q=min(S2,0,k); //S2中最小的点
        double d=Math.min(Math.min(d1,d2),q-p);//d1、d2和(q-p)三者间的最小距离者
        return d;
    }

    public static int max(int[] S, int begin, int end)
    {
        int m1 = S[begin];
        for (int i = begin+1; i < end; i++)
        {
            if(S[i]>m1)
            {
                m1 = S[i];
            }
        }
        return m1;
    }

    public static int min(int[] S, int begin, int end)
    {
        int m2 = S[begin];
        for (int i = begin+1; i < end; i++)
        {
            if(S[i]<m2)
            {
                m2 = S[i];
            }
        }
        return m2;
    }

    public static void main(String[] args){
    int []s = { 1, 3, 4, 6, 9, 10, 20, 24, 30, 33 };
        System.out.println("最近点对距离:"+cpair1(s,s.length));
    }
}
