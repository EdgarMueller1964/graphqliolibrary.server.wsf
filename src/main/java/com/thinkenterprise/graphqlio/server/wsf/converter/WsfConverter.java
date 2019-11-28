package com.thinkenterprise.graphqlio.server.wsf.converter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thinkenterprise.graphqlio.server.wsf.domain.WsfFrame;
import com.thinkenterprise.graphqlio.server.wsf.domain.WsfFrameType;
import com.thinkenterprise.graphqlio.server.wsf.exception.WsfException;

/**
 * WsfConverter
 */
public class WsfConverter implements WsfFrameToMessageConverter, WsfMessageToFrameConverter {

	private WsfFrameType frameType;	

	private ObjectMapper objectMapper;

	public WsfConverter(ObjectMapper objectMapper, WsfFrameType frameType) {
		this.objectMapper = objectMapper;
		this.frameType = frameType;
	}
	
		
	@Override
	public String convert(WsfFrame message) {
		if(message.getType()!=frameType)
			throw new WsfException();

		// Create Frame from Response Message
		String frame = "[" + message.getFid() + "," + message.getRid() + "," + "\""+ WsfFrameType.GRAPHQLRESPONSE + "\"" + "," + message.getData() + "]";
		return frame;
	}


	@Override
	public WsfFrame convert(String frame) {
		String fid;
		String rid;
		WsfFrameType type;
		String data;

		// Delete not nedded characters 
		frame = StringUtils.deleteAny(frame, "[");
		frame = StringUtils.deleteAny(frame, "]");

		// Tokenize String 
		String[] messageValues = StringUtils.tokenizeToStringArray(frame, ",");

		// Check count of values 
		if (messageValues.length != 4)
			throw new WsfException();

		// Delete excape characters for double quotas 
		// ToDo: not 2 insted 3 or?
		System.out.println("messageValues[2] = " + messageValues[2]);
		messageValues[2] = StringUtils.deleteAny(messageValues[2], "\"");

		// Actually we only convert the GRAPHQLREQUEST frame type  
		WsfFrameType graphQLIOMessageType = WsfFrameType
				.valueOf(frameType.name());

		// Check the right frame type 
		if (!messageValues[2].equals(graphQLIOMessageType.toString()))
			throw new WsfException();

		// Set local variables more readable 
		fid=messageValues[0];
		rid=messageValues[1];
		type=graphQLIOMessageType;
		data=messageValues[3];

		// Build Message  
		return  WsfFrame.builder().fid(fid).rid(rid).type(type).data(data).build();
	}
    
	
	public String createData(Set<String> set) {
        // ToDo : Build Response Data with JSON - JSON-field: data, JSON-Data: Array of sids 
        // "data":["5c989173-0eed-55b6-8f48-44890f621aaa"]
		return null;
	}
	
	
}