package com.glick.api.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("glick")
public class GlickApiProperty {

	private String allowedOrigen = "http://localhost:8000";

	private final Security security = new Security();

	public Security getSecurity() {
		return security;
	}

	public String getAllowedOrigen() {
		return allowedOrigen;
	}

	public void setAllowedOrigen(String allowedOrigen) {
		this.allowedOrigen = allowedOrigen;
	}

	public static class Security {

		private boolean enableHttps;

		public boolean isEnableHttps() {
			return enableHttps;
		}

		public void setEnableHttps(boolean enableHttps) {
			this.enableHttps = enableHttps;
		}

	}

}
