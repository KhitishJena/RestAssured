package jiraAPITest;

public class JiraPayloads {
	
	public static String LoginPayload() {
		
		return "{\r\n"
				+ "    \"username\": \"satishj90\",\r\n"
				+ "    \"password\": \"!Lulu123\"\r\n"
				+ "}";
	}
	
	public static String AddcommentPayload() {
		return "{\r\n"
				+ "    \"body\": \"Added 1st comment by API\",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}";
	}

}
