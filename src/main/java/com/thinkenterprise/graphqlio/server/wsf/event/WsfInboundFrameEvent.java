package com.thinkenterprise.graphqlio.server.wsf.event;

import org.springframework.context.ApplicationEvent;

import com.thinkenterprise.graphqlio.server.wsf.domain.WsfFrame;

/**
 * InboundFrameEvent
 */
public class WsfInboundFrameEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1L;

    private String cid;
    private WsfFrame frame;

    public WsfInboundFrameEvent(WsfFrame frame, String cid ) {
        super(frame);
        this.cid=cid;
        this.frame=frame;
    }    

   public String getCid() {
        return this.cid;
    }

    public WsfFrame getFrame() {
        return this.frame;
    }


    
}