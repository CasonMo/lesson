package com.mo.tools;

import java.lang.reflect.Method;

public class ClassAndMethods
{
	public static String getCM(Class c1)
	{

		String classname=c1.getSimpleName();

		Method[] allmethods=c1.getDeclaredMethods();
		String currentmethod = Thread.currentThread().getStackTrace()[2].getMethodName();

		String strtemp=null;
		for(Method m:allmethods)
		{
			if (currentmethod.equals(m.getName()))
			{
				strtemp="/"+classname+"/"+m.getName();
				break;
			}
		}

		return strtemp;
	}
}
