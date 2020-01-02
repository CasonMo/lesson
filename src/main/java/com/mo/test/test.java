package com.mo.test;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import org.apache.ibatis.io.Resources;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: PeiHsien Mo
 * Date: 2019/11/10
 * Time: 13:25
 */
public class test {


         static class CPair
        {
            int dist;
            int d1,d2;
            public CPair(int dist, int d1, int d2)
            {
                this.dist = dist;
                this.d1 = d1;
                this.d2 = d2;
            }
            public String toString()
            {
                return "最近点对距离："+dist + "-------点对：（" + d1 + "，" + d2+"）";
            }
        }


        public static CPair cpair1(int[] S, int n)
        {
            if(n<2) return new test.CPair(Integer.MAX_VALUE, 0, 0);

            //获取S中的最大值
            int m1 = max(S, 0, n);

            //获取S中的最小值
            int m2 = min(S, 0, n);

            //取得中位数
            int m = (m1+m2)/2;  //中位数

            //记录两个分组的长度
            int j=0,k=0;

            //根据中位数来分组（最长不会超过n）
            int[] s1 = new int[n];
            int[] s2 = new int[n];
            //s1全部小于=m，s2全部大于m
            for (int i = 0; i < n; i++)
            {
                if(S[i]<=m)
                {
                    s1[j]=S[i];
                    j++;
                }
                else
                {
                    s2[k] = S[i];
                    k++;
                }
            }

            //递归求解S1,S2
            CPair d1 = cpair1(s1, j);
            CPair d2 = cpair1(s2, k);

            //找出S1中的最大值和S2中的最小值
            int p = max(s1, 0, j);
            int q = min(s2, 0, k);

            //比较S1中的最小距离和S2中的最小距离，以及S1中最大的数字和S2中最小的数字的距离，取三者的最小值
            //返回s[]中的具有最近距离的点对及其距离
            if(d1.dist<d2.dist)
            {
                if((q-p) < d1.dist)
                {
                    return new CPair(q-p, q, p);
                }
                else
                {
                    return d1;
                }
            }
            else
            {
                if((q-p)<d2.dist)
                {
                    return new CPair(q-p, q, p);
                }
                else
                {
                    return d2;
                }
            }
        }

        public static int min(int a, int b, int c)
        {
            int min = a;
            if(b<min)
            {
                min = b;
            }
            if(c<min)
            {
                min = c;
            }
            return min;
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
        System.out.println(cpair1(s,s.length));
    }

}
