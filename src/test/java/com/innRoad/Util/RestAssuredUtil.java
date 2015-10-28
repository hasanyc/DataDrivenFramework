package com.innRoad.Util;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.config.RestAssuredConfig;
import com.jayway.restassured.config.EncoderConfig;

public class RestAssuredUtil {

	public static String ResponseContentType;

	public static void RestAssuredSetup(AllGetterSetter gs) throws InterruptedException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
		RestAssured.config = new RestAssuredConfig().encoderConfig(EncoderConfig.encoderConfig().defaultContentCharset("UTF-8"));
		ResponseContentType = gs.getResponseContentType();
		RestAssured.baseURI = gs.getBaseURL();
		RestAssured.port = gs.getPort();
	}

	public static Response executeTest(AllGetterSetter gs) throws IOException, InterruptedException, NoSuchAlgorithmException, InvalidKeyException, SignatureException
	{
		Response response = null;
		RestAssuredSetup(gs);
		if (gs.getMethod().equalsIgnoreCase("GET")){           
			response = RestAssured
					.given()
					.request()
					.get(gs.getEndpoint());
		}
		if (gs.getMethod().equalsIgnoreCase("POST")) {
			String reqContentType = "", bodyText = "";
			if (gs.getResponseContentType().equalsIgnoreCase("xml")){
				reqContentType = "application/xml";
			} if (gs.getResponseContentType().equalsIgnoreCase("json")){
				reqContentType = "application/json";
			} else {
				response = RestAssured
						.given()
						.request()
						.contentType(reqContentType)
						.body(bodyText)
						.post();
			}

		}
		if (gs.getMethod().equalsIgnoreCase("DELETE"))
		{
			response = RestAssured
					.given()
					.request()
					.delete(gs.getEndpoint());
		}
		return response;
	}

}