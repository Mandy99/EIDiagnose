package com.hp.ei.diagnose.util;
import java.util.*;
import java.io.File;
import java.lang.*;

public class Global_Parameter {
	public static String installationPath="C:\\ProgramData\\HP\\ALM\\"; 
	public static String serverConfPath="server\\conf\\";
	public static String jettySSLPath=installationPath+serverConfPath+"jetty-ssl.xml";
	public static String startiniPath=installationPath+serverConfPath+"start.ini";
	public static String webappsClassPath="webapps\\qcbin\\WEB-INF\\classes\\";
	public static String WSDL_STATUS="";
	public Global_Parameter(){
		initialize();
	}
	private static void initialize() {
		checkWSDLStatus();

	}
	static {
		initialize();
	}
	private static void checkWSDLStatus(){
		File fileSAML = new File(installationPath+webappsClassPath+"wsdl\\SAML\\AGS_SM_TESTDATA_API.WSDL");
		File fileUsed = new File(installationPath+webappsClassPath+"wsdl\\AGS_SM_TESTDATA_API.WSDL");
		boolean isSAML = fileUsed.equals(fileSAML);
		if(isSAML){
			WSDL_STATUS="SAML";
		}else{
			WSDL_STATUS="NON SAML";
		}
	}
}
