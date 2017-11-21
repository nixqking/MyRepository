package com.neil.tools;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.neil.exceptions.UserException;

public class UserUtil {
	public static Object assertNotNull(Object target) {
		if (target instanceof String) {
			String realTarget = (String) target;
			if (realTarget == null || realTarget.trim().length() == 0)
				throw new UserException("字符串为空！");
		}
		if (target == null) {
			throw new UserException("空指针异常！");
		}
		return target;
	}

	public static String getMD5(String str) {
		try {
			// 生成一个MD5加密计算摘要
			MessageDigest md = MessageDigest.getInstance("MD5");
			// 计算md5函数
			md.update(str.getBytes());
			// digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
			// BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
			return new BigInteger(1, md.digest()).toString(16);
		} catch (Exception e) {
			throw new UserException("MD5加密出现错误");
		}
	}

	public static boolean isNum(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (isNum.matches()) {
			return true;
		}
		return false;
	}
}
