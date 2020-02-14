package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.util.Arrays;

import no.hvl.dat110.TODO;

public class RPCUtils {

	// Utility methods for marshalling and marshalling of parameters and return
	// values
	// in RPC request and RPC responses
	// data bytearrays and return byte arrays is according to the
	// RPC message syntax [rpcid,parameter/return value]

	public static byte[] marshallString(byte rpcid, String str) {

		byte[] encoded = new byte[str.length() + 1];
		encoded[0] = rpcid;
		byte[] res = str.getBytes();

		for (int i = 1; i < encoded.length; i++) {
			
			encoded[i] = res[i - 1];
		}

		// TODO: marshall RPC identifier and string into byte array

		return encoded;
	}

	public static String unmarshallString(byte[] data) {

		String decoded;
		byte[] temp = new byte[data.length - 1];
		
		for (int i = 0; i < temp.length; i++) {
			
			temp[i] = data[i + 1];
		}
		decoded = new String(temp);

		// TODO: unmarshall String contained in data into decoded

		return decoded;
	}

	public static byte[] marshallVoid(byte rpcid) {

		byte[] encoded = new byte[1];
		encoded[0] = rpcid;

		// TODO: marshall RPC identifier in case of void type
		return encoded;
	}

	public static void unmarshallVoid(byte[] data) {

		// TODO: unmarshall void type

	}

	public static byte[] marshallBoolean(byte rpcid, boolean b) {

		byte[] encoded = new byte[2];

		encoded[0] = rpcid;

		if (b) {
			encoded[1] = 1;
		} else {
			encoded[1] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[1] > 0);

	}

	public static byte[] marshallInteger(byte rpcid, int x) {

		byte[] encoded = new byte[5];
		encoded[0] = rpcid;
		ByteBuffer buff = ByteBuffer.allocate(4);

		byte[] num = buff.putInt(x).array();

		for (int i = 1; i < num.length + 1; i++) {
			encoded[i] = num[i - 1];
		}

		// TODO: marshall RPC identifier and string into byte array

		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {

		int decoded;

		// TODO: unmarshall integer contained in data
		ByteBuffer buff = ByteBuffer.wrap(data);
		decoded = buff.getInt(1);

		return decoded;

	}
}
