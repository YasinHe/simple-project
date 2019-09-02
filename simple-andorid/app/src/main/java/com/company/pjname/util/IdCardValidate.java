package com.company.pjname.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdCardValidate {
	public static String IDCardValidate(String IDStr) {  
		String errorInfo = "";// 记录错误信息  
		String[] ValCodeArr = {"1","0","x","9","8","7","6","5","4","3","2"};  
		String[] Wi = {"7","9","10","5","8","4","2","1","6","3","7","9","10","5","8","4","2"};  
		String Ai = "";  
		// ================ 号码的长度 15位或18位 ================  
		if (IDStr.length() != 15 && IDStr.length() != 18) {  
			errorInfo = "身份证号码长度应该为15位或18位。";  
			return errorInfo;  
		}
		// =======================(end)========================  
		  
		// ================ 数字 除最后以为都为数字 ================  
		if (IDStr.length() == 18) {  
			Ai = IDStr.substring(0, 17);  
		} else if (IDStr.length() == 15) {  
			Ai = IDStr.substring(0, 6) + "19" + IDStr.substring(6, 15);  
		}  
		if (isNumeric(Ai) == false) {  
			errorInfo = "身份证15位号码都应为数字 ; 18位号码除最后一位外，都应为数字。";  
			return errorInfo;  
		}  
		// =======================(end)========================  
		  
		// ================ 出生年月是否有效 ================  
		String strYear = Ai.substring(6, 10);// 年份  
		String strMonth = Ai.substring(10, 12);// 月份  
		String strDay = Ai.substring(12, 14);// 月份  
		if (isDate(strYear + "-" + strMonth + "-" + strDay) == false) {  
			errorInfo = "身份证生日无效。";  
			return errorInfo;  
		}  
		GregorianCalendar gc = new GregorianCalendar();  
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");  
		try {  
			if ((gc.get(Calendar.YEAR) - Integer.parseInt(strYear)) > 150 || (gc.getTime().getTime() - s.parse(  
		                            strYear + "-" + strMonth + "-" + strDay).getTime()) < 0) {  
				errorInfo = "身份证生日不在有效范围。";  
				return errorInfo;  
			}  
		} catch (NumberFormatException e) {  
			e.printStackTrace();  
		} catch (java.text.ParseException e) {  
			e.printStackTrace();  
		}  
		if (Integer.parseInt(strMonth) > 12 || Integer.parseInt(strMonth) == 0) {  
			errorInfo = "身份证月份无效";  
			return errorInfo;  
		}  
		if (Integer.parseInt(strDay) > 31 || Integer.parseInt(strDay) == 0) {  
			errorInfo = "身份证日期无效";  
			return errorInfo;  
		}  
		// =====================(end)=====================  
		  
		// ================ 判断最后一位的值 ================  
		int TotalmulAiWi = 0;  
		for (int i = 0; i < 17; i++) {  
			TotalmulAiWi = TotalmulAiWi + Integer.parseInt(String.valueOf(Ai.charAt(i))) * Integer.parseInt(Wi[i]);  
		}  
		int modValue = TotalmulAiWi % 11;  
		String strVerifyCode = ValCodeArr[modValue];  
		Ai = Ai + strVerifyCode;  
		  
		if (IDStr.length() == 18) {  
			if (Ai.equalsIgnoreCase(IDStr) == false) {  
				errorInfo = "身份证无效，不是合法的身份证号码";  
				return errorInfo;  
			}  
		} else {  
			return "";  
		}  
		// =====================(end)=====================  
		return "";  
	}  
	
	/**
	 * 判断字符串是否为数字 
	 * @param str 字符串
	 * @return 是否数字
	 */
	private static boolean isNumeric(String str) {  
		Pattern pattern = Pattern.compile("[0-9]*");  
		Matcher isNum = pattern.matcher(str);  
		if (isNum.matches()) {  
			return true;  
		} else {  
			return false;  
		}  
	}  
	  
	/**
	 * 判断字符串是否为日期格式      
	 * @param strDate 日期字符串
	 * @return 是否日期
	 */
	public static boolean isDate(String strDate) {  
		Pattern pattern = Pattern  
			.compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");  
		Matcher m = pattern.matcher(strDate);  
		if (m.matches()) {  
			return true;  
		} else {  
			return false;  
		}  
	}  
}
