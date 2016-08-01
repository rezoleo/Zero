package fr.service_authentification.tool;

/*
 * Copyright 2015-2016 Emmanuel ZIDEL-CAUFFET
 *
 * This class is used in a project designed by some Ecole Centrale de Lille students.
 * This program is distributed in the hope that it will be useful.
 * 
 * It is a free code: you can redistribute it and/or modify it under the terms of the GNU General Public License 
 * as published by the Free Software Foundation, either Version 3 of the License.
 *
 * However the source code is distributed without any warranty
 * See the GNU General Public License for more details.
 *
 */


import java.security.MessageDigest;

/* 
 * Class 	: Hash
 * Author(s): Zidmann
 * Function : This class contains some functions to hash a password 
 * Version  : 1.0.0 
 */
public class Hash {
	public static String sha512(String str) throws Exception{
		if(str==null){
			return null;
		}

		MessageDigest sha512 = getMessageDigest("SHA-512");
		sha512.update(str.getBytes());

		return convertByteToHex(sha512.digest());	
	}

	public static String sha512(String str, String salt) throws Exception{
		if(salt==null || str==null){
			return sha512(str);
		}
		return sha512(str+salt);
	}

	protected static String convertByteToHex(byte data[]){
        StringBuffer hexData = new StringBuffer();
        for (int byteIndex = 0; byteIndex < data.length; byteIndex++){
            hexData.append(Integer.toString((data[byteIndex] & 0xff) + 0x100, 16).substring(1));
        }
        return hexData.toString();
    }

	protected static MessageDigest getMessageDigest(String str) throws Exception{
		return MessageDigest.getInstance(str);
	}
}