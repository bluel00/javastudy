package javaEx;

import org.apache.commons.lang3.StringUtils;

public class CompareVersion {

	public static void main(String[] args) {
		String curVer = "2.0.1";
		String minVer = "2.0";
		boolean result = false;
		
		result = compareVer(curVer, minVer);
		
		System.out.print("현재버전(" + curVer + ")에서 ");
		if (result) {
			System.out.println("가능.");
		} else {
			System.out.println("불가능");
		}
	}

	private static boolean compareVer(String curVer, String minVer) {
		int intCurVer = 0;
		int intMinVer = 0;
		
		if (StringUtils.isEmpty(curVer)) {
			return false;
		} else if( StringUtils.isEmpty(minVer)) {
			System.out.println("최소버전 없음. 모든 버전에서 가능");
		} else {
			if (Integer.parseInt(curVer.split("[.]")[0]) > Integer.parseInt(minVer.split("[.]")[0])) {
				System.out.println(Integer.parseInt(curVer.split("[.]")[0]) + " > " + Integer.parseInt(minVer.split("[.]")[0]));
				return true;
			} else {
				curVer = curVer.replaceAll("[.]", "");
				minVer = minVer.replaceAll("[.]", "");
				
				if (Integer.parseInt(curVer) >= 0 && Integer.parseInt(minVer) >= 0) {
					while (curVer.length() != minVer.length()) {
						if (curVer.length() > minVer.length()) {
							minVer += "0";
						} else {
							curVer += "0";
						}
					}
					System.out.println(curVer + " >= " + minVer);
					
					intCurVer = Integer.parseInt(curVer);
					intMinVer = Integer.parseInt(minVer);
				}
			}
		}
		
		return intCurVer >= intMinVer;
	}

}
