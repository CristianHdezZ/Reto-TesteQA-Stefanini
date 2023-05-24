package co.com.stefanini.certification.testfront.model.builder;

import co.com.stefanini.certification.testfront.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class UserBuilder {
    private final String userType;

    public UserBuilder(String userType) {
        this.userType = userType;
    }

    public static UserBuilder getValue(String userType) {
        return new UserBuilder(userType);
    }


    public User getObject(){
        User result = null;
        try {

            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert a JSON string to a Book object
            List<User> users = Arrays.asList(mapper.readValue(Paths.get("src/test/resources/dataDriven/UserData.json").toFile(), User[].class));


            result = users.stream()
                    .filter(user->user.getUserType()!=null && user.getUserType().equals(userType))
                    .findFirst()
                    .orElse(null);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
