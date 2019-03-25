package com.shky.network.vpn.core.helpers;

import javax.xml.bind.DatatypeConverter;

public class DataTypeConversionHelpers {

	public static String ByteToString(byte[] arr)
	{
		/*String s = "";
		for(int i = 0; i < arr.length; i++ )
		{
			s += ((int)arr[i]) + ", ";
		}
		return s;*/
		return DatatypeConverter.printHexBinary(arr);
	}
}
