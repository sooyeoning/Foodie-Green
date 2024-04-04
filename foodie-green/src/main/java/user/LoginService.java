package user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import lombok.extern.slf4j.Slf4j;

import user.model.GetKakaoUserInfoRes;

@Service
@Slf4j
public class LoginService {
	
	@Value("${oauth.token.url}")
	private String getTokenURL;
	
	@Value("${oauth.getInfo.url}")
	private String getInfoURL;
	
	@Value("${oauth.logout.url}")
	private String logoutURL;
	
	@Value("${oauth.unlink.url}")
	private String unlinkURL;
	
	@Value("${oauth.clientId}")
	private String clientId;
	
	@Value("${oauth.redirect.url}")
	private String redirectURL;
	
	public String getKakaoAccessToken (String code) {
	    String result = getTokenResult(getTokenURL, code);
	    
	    JsonElement element = JsonParser.parseString(result);
	    String accessToken = element.getAsJsonObject().get("access_token").getAsString();
	    String refreshToken = element.getAsJsonObject().get("refresh_token").getAsString();

	    log.info("accessToken : " + accessToken);
	    log.info("refreshToken : " + refreshToken);

	    return accessToken;
	}
	
	public GetKakaoUserInfoRes getUserInfo(String accessToken) {
	    GetKakaoUserInfoRes res = new GetKakaoUserInfoRes();
	    
	    String result = getURLConnectionResult(accessToken,getInfoURL);
        log.info("response body : " + result);

        JsonElement element = JsonParser.parseString(result);
        JsonObject kakaoAccount = element.getAsJsonObject().get("kakao_account").getAsJsonObject();
        JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
        
        String email = kakaoAccount.getAsJsonObject().get("email").getAsString();
        String nickname = properties.getAsJsonObject().get("nickname").getAsString();

        res.setNickname(nickname);
        res.setEmail(email);
        
	    return res;
	}
	
	public String tempPassword(int leng){
		int index = 0;
		char[] charSet = new char[] {
				'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
				'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
				'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
				'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
		};	//배열안의 문자 숫자는 원하는대로

		StringBuffer password = new StringBuffer();
		Random random = new Random();

		for (int i = 0; i < leng ; i++) {
			double rd = random.nextDouble();
			index = (int) (charSet.length * rd);
			
			password.append(charSet[index]);
			
			log.info("index:: {} charSet:: {}", index, charSet[index]);
		}
		
		return password.toString(); 
	    //StringBuffer를 String으로 변환해서 return 하려면 toString()을 사용하면 된다.
	}
	
	public void logout(String accessToken) {
		String result = getURLConnectionResult(accessToken,logoutURL);
	    log.info(result);   
	}
	
	public void unlink(String accessToken) {
		String result = getURLConnectionResult(accessToken,unlinkURL);
		log.info(result);    
	}
	
	public String getURLConnectionResult(String accessToken, String reqURL) {
	    String result = "";

		try { 
			URL url = new URL(reqURL);
		    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		    conn.setRequestMethod("POST");
	
		    conn.setRequestProperty("Authorization", "Bearer " + accessToken);
	
		    int responseCode = conn.getResponseCode();
		    log.info("responseCode : " + responseCode);

		    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		    String line = "";
	
		    while ((line = br.readLine()) != null) {
		    	result += line;
		    }
		} catch (IOException e) {
	        e.printStackTrace();
	    }
		return result; 
	}
	
	public String getTokenResult(String reqURL, String code) {
		String result = "";
		try {
	        URL url = new URL(reqURL);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

	        conn.setRequestMethod("POST");
	        conn.setDoOutput(true);

	        // POST 요청에서 필요한 파라미터를 OutputStream을 통해 전송
	        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
	        String sb = "grant_type=authorization_code" +
	                "&client_id=" + clientId + "&redirect_uri=" + redirectURL + "&code=" + code;
	        bufferedWriter.write(sb);
	        bufferedWriter.flush();

	        int responseCode = conn.getResponseCode();
	        log.info("responseCode : {}", responseCode);

	        // 요청을 통해 얻은 데이터를 InputStreamReader을 통해 읽어 오기
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        String line = "";

	        while ((line = bufferedReader.readLine()) != null) {
	            result+=line;
	        }
	        log.info("response body : {}", result);

	        bufferedReader.close();
	        bufferedWriter.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	return result;
	}
}
