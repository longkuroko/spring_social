package social.Network.projectsocial.security.email;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class EmailValidator implements Predicate<String> {

    @Override
    public boolean test(String s) {
        //TODO :  REGEX EMAIL
        return true;
    }
}
