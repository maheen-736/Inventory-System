import java.util.ArrayList;
import java.util.List;

public class UserData {

    private List<user> users = new ArrayList<>();

    public UserData()
    {
        users.add(new user("admin", "admin123"));
        users.add(new user("user", "pass"));
        users.add(new user("burhan", "burhan123"));
        users.add(new user("fiza", "fiza123"));
        users.add(new user("Rehan" , "rehan123"));
    }

    public boolean authenticate(String username, String password)
    {
        for (user user : users)
        {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}