package com.thinkenterprise.graphqlio.server.wsf.codec;

import java.io.IOException;

import org.msgpack.core.MessageBufferPacker;
import org.msgpack.core.MessageFormat;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessageUnpacker;

/**
 * MsgPackCodec
 */
public class WsfMsgPackCodec implements WsfCodec {

	@Override
	public String decode(byte[] data) throws IOException {
		MessageUnpacker unpacker = MessagePack.newDefaultUnpacker(data);
		String result = null;
		 while(unpacker.hasNext()) {
		     MessageFormat f = unpacker.getNextFormat();
		     switch(f) {	
			     case STR8:
			     case STR16:
			     case STR32: {
			 		result = unpacker.unpackString();   // may be null
			 		break;
			     }
			     default: {
			    	 result = null;
			    	 break;
			     }
		     }
		 }
		unpacker.close();
		return result;
	}

	@Override
	public byte[] encode(String data) throws IOException {
		MessageBufferPacker packer = MessagePack.newDefaultBufferPacker();
		if (data == null) {
			packer.packNil();
		} else {
			packer.packString(data);
		}
		packer.close();
		return packer.toByteArray();
	}
    
}