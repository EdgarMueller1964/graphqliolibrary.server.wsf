package com.thinkenterprise.graphqlio.server.wsf.domain;

public final class WsfFrame {

	private String fid;
	private String rid;
	private WsfFrameType type;
	private String data;

	private WsfFrame(Builder builder) {
		this.fid = builder.fid;
		this.rid = builder.rid;
		this.type = builder.type;
		this.data = builder.data;
	}

	public String getFid() {
		return fid;
	}

	public String getRid() {
		return rid;
	}

	public WsfFrameType getType() {
		return type;
	}

	public String getData() {
		return data;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {

		private String fid;
		private String rid;
		private WsfFrameType type;
		private String data;

		private Builder() {
		}

		public Builder fid(String fid) {
			this.fid = fid;
			return this;
		}

		public Builder rid(String rid) {
			this.rid = rid;
			return this;
		}

		public Builder data(String data) {
			this.data = data;
			return this;
		}

		public Builder type(WsfFrameType type) {
			this.type = type;
			return this;
		}

		public WsfFrame build() {
			return new WsfFrame(this);
		} 
		
		public Builder fromRequestMessage(WsfFrame message) {
			this.fid=message.getFid();

			Long ridValue = Long.decode(message.getRid());
			++ridValue;
			this.rid= ridValue.toString();

			this.type=WsfFrameType.GRAPHQLRESPONSE;

			return this;
		}
		


	}
	

}
