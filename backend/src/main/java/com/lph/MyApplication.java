package com.lph;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * author Alex J Costa
 */
@ApplicationPath("rest")
public class MyApplication extends ResourceConfig {
	
	public MyApplication() {
		packages("com.lph.controller");
	}

}
