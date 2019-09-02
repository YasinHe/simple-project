package com.company.pjname.util;

import android.util.Log;


/**
 * Log统一管理类
 * 
 * @author way
 * 
 */
public class L
{
	private L()
	{
		/* cannot be instantiated */
		throw new UnsupportedOperationException("cannot be instantiated");
	}
	private static final boolean isDebug = true;// 是否需要打印bug，可以在application的onCreate函数里面初始化
	private static final String TAG = "pjname";
	private static final boolean isTesting = false;

	// 下面四个是默认tag的函数
	public static void i(String msg)
	{
		if(testingLog(msg))return;
		if (isDebug)
			Log.i(TAG, msg);
	}

	public static void d(String msg)
	{
		if(testingLog(msg))return;
		if (isDebug)
			Log.d(TAG, msg);
	}

	public static void e(String msg)
	{
		if(testingLog(msg))return;
		if (isDebug)
			Log.e(TAG, msg);
	}

	public static void v(String msg)
	{
		if(testingLog(msg))return;
		if (isDebug)
			Log.v(TAG, msg);
	}

	// 下面是传入自定义tag的函数
	public static void i(String tag, String msg)
	{
		if(testingLog(msg))return;
		if (isDebug)
			Log.i(tag, msg);
	}

	public static void d(String tag, String msg)
	{
		if(testingLog(msg))return;
		if (isDebug)
			Log.i(tag, msg);
	}

	public static void e(String tag, String msg)
	{
		if (testingLog(msg)) return;
		if(msg.length() > 4000) {
			for(int i=0;i<msg.length();i+=4000){
				if(i+4000<msg.length())
					if (isDebug)
						L.d(tag+i,msg.substring(i, i+4000));
				else
					if (isDebug)
						L.d(tag+i,msg.substring(i, msg.length()));
			}
		} else {
			if (testingLog(msg)) return;
			if (isDebug)
				Log.e(tag, msg);
		}
	}

	public static void v(String tag, String msg)
	{
		if(testingLog(msg))return;
		if (isDebug)
			Log.i(tag, msg);
	}

	public static boolean testingLog(String msg) {
		if (isTesting) {
			System.out.println(msg);
			return true;
		}
		return false;
	}
}