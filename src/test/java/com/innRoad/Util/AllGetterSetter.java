package com.innRoad.Util;

import com.jayway.restassured.response.Response;

public class AllGetterSetter {

	private Long 		TestID;
	private String 		BaseURL;
	private int 		Port;
	private String 		Method;
	private String 		Endpoint;
	private String 		ResponseContentType;
	private Long 		DataID;
	private Response 	HTTPresp;
	private String		JSONSchema;

	public Long getId(){
		return TestID;
	}
	public void setTestID(Long TestID){
		this.TestID = TestID;
	}
	// ================================================
	public String getBaseURL(){
		return BaseURL;
	}
	public void setBaseURL(String BaseURL){
		this.BaseURL = BaseURL;
	}
	// ================================================
	public int getPort(){
		return Port;
	}
	public void setPort(int Port){
		this.Port = Port;
	}
	// ================================================
	public String getMethod(){
		return Method;
	}
	public void setMethod(String Method){
		this.Method = Method;
	}
	// ================================================
	public String getEndpoint(){
		return Endpoint;
	}
	public void setEndpoint(String Endpoint){
		this.Endpoint = Endpoint;
	}
	// ================================================
	public String getResponseContentType(){
		return ResponseContentType;
	}
	public void setResponseContentType(String ResponseContentType){
		this.ResponseContentType = ResponseContentType;
	}
	// ================================================
	public Long getDataID() {
		return DataID;
	}
	public void setDataID(Long DataID){
		this.DataID = DataID;
	}
	// ================================================
	public Response getHTTPresp(){
		return HTTPresp;
	}
	public void setHTTPresp(Response HTTPresp){
		this.HTTPresp = HTTPresp;
	}
	// ================================================
	public String getJSONSchema(){
		return JSONSchema;
	}
	public void setJSONSchema(String JSONSchema){
		this.JSONSchema = JSONSchema;
	}
	// ================================================
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
