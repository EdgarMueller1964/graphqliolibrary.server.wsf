package com.thinkenterprise.graphqlio.server.wsf.converter;

import com.thinkenterprise.graphqlio.server.wsf.domain.WsfFrame;

public interface WsfFrameToMessageConverter {
	
	WsfFrame convert(String frame);

}
