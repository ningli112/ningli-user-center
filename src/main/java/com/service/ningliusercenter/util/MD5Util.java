package com.service.ningliusercenter.util;

import java.security.MessageDigest;
import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.service.ningliusercenter.enums.exception.UtilExceptionCodeEnum;
import com.service.ningliusercenter.exception.base.SignException;

public class MD5Util {
	private static final Logger LOGGER = LoggerFactory.getLogger(MD5Util.class);

	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D",
			"E", "F" };
	private static String[] chars36 = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
			"N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "", "1", "2", "3", "4", "5", "6", "7", "8",
			"9" };

	/**
	 * 
	 * @Title: byteArrayToHexString
	 * @Description: 转换字节数组为16进制字串
	 * @param b
	 * @return
	 * 		String
	 * @author: 宁黎
	 * @date:2019年5月9日上午11:39:39
	 *
	 */
	private static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	/**
	 * 
	 * @Title: byteToHexString
	 * @Description: 转换byte到16进制
	 * @param b
	 * @return
	 * 		String
	 * @author: 宁黎
	 * @date:2019年5月9日上午11:40:21
	 *
	 */
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0) {
			n = 256 + n;
		}
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	/**
	 * 
	 * @Title: MD5Encode
	 * @Description: 对数据进行MD5计算
	 * @param origin
	 * @return
	 * @throws SignException
	 *                       String
	 * @author: 宁黎
	 * @date:2019年5月9日上午11:38:34
	 *
	 */
	public static String MD5Encode(String origin) throws SignException {
		if (origin == null)
			return null;
		String resultString = null;
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
		} catch (Exception ex) {
			LOGGER.error(" --MD5计算异常：" + ex.getMessage());
		}
		if (StringUtils.isEmpty(resultString)) {
			throw new SignException(UtilExceptionCodeEnum.SIGN_EXCEPTION.getErrorCode(),
					UtilExceptionCodeEnum.SIGN_EXCEPTION.getErrorMsg());
		}
		return resultString;
	}

	/**
	 * 
	 * @Title: getUUID
	 * @Description: 获取UUID
	 * @return
	 * 		String
	 * @author: 宁黎
	 * @date:2019年5月10日下午3:12:05
	 *
	 */
	public static String getUUID() {
		String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
		return uuid;
	}

	/**
	 * 
	 * @Title: generateInviteCode
	 * @Description: 生成32位唯一码
	 * @return
	 * 		String
	 * @author: 宁黎
	 * @date:2019年5月22日上午11:12:17
	 *
	 */
	public static String generateInviteCode() {
		StringBuffer shortBuffer = new StringBuffer();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		for (int i = 0; i < 32; i++) {
			String str = uuid.substring(i * 1, i * 1 + 1);
			int x = Integer.parseInt(str, 16);
			// 如果是 chars62,则是x%62
			shortBuffer.append(chars36[x % 36]);
		}
		return shortBuffer.toString();
	}

	/**
	 * 
	 * @Title: getAppIdByUUId
	 * @Description: 生成APPID
	 * @return
	 * 		String
	 * @author: 宁黎
	 * @date:2019年5月22日上午11:19:58
	 *
	 */
	public static String getAppIdByUUId() {
		int first = new Random(10).nextInt(8) + 1;
		int hashCodeV = UUID.randomUUID().toString().hashCode();
		if (hashCodeV < 0) {// 有可能是负数
			hashCodeV = -hashCodeV;
		}
		// 0 代表前面补充0
		// 4 代表长度为4
		// d 代表参数为正数型
		return first + String.format("%015d", hashCodeV);
	}
}
