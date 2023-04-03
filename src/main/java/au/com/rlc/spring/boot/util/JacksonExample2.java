package au.com.rlc.spring.boot.util;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import au.com.rlc.spring.boot.models.ERole;
import au.com.rlc.spring.boot.models.Role;
import org.springframework.security.crypto.password.PasswordEncoder;
public class JacksonExample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strRole ="ROLE_ADMIN";
		Set<Role> roles = new HashSet<>();

			Role role = new Role();
			role.setName(ERole.valueOf(strRole));
			roles.add(role);
		for (Role role1 : roles) {
			System.out.println(" role ::==> "+ role1.getName());
		}	
		
			String passStr="$2a$10$AjX0UQWjHdTluNxCGYGUUOSIPjxbc.QRifBXF/VP9Kj7q6Hbcbie2";
			//Team123
	}
	
	public static boolean isJSONValid(String test) {
	    try {
	        new JSONObject(test);
	    } catch (JSONException ex) {
	        // edited, to include @Arthur's comment
	        // e.g. in case JSONArray is valid as well...
	        try {
	            new JSONArray(test);
	        } catch (JSONException ex1) {
	            return false;
	        }
	    }
	    return true;
	}

}
