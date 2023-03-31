package org.depinfo.omnisus.user;

import org.depinfo.omnisus.user.dto.SignupRequest;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void deleteAll();

    class UsernameTooShort extends Exception {}
    class UsernameAlreadyTaken extends Exception {}
    class PasswordTooShort extends Exception {}

    void signup(SignupRequest req) throws BadCredentialsException, UsernameTooShort, PasswordTooShort, UsernameAlreadyTaken;

    MUser studentFromUsername(String username);

    int updateUser(Long userId, String publicUsername);
}