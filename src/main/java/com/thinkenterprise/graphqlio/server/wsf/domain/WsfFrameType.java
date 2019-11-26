package com.thinkenterprise.graphqlio.server.wsf.domain;

public enum WsfFrameType {
	GRAPHQLREQUEST {
		@Override
        public String toString() {
            return "GRAPHQL-REQUEST";
        }
    },
    GRAPHQLRESPONSE {
        @Override
        public String toString() {
            return "GRAPHQL-RESPONSE";
        }
    },
    GRAPHQLNOTIFIER {
        @Override
        public String toString() {
            return "GRAPHQL-NOTIFIER";
        }
    }
    
}
