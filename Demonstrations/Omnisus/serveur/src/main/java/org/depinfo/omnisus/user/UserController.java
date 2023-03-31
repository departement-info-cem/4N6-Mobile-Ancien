package org.depinfo.omnisus.user;

import org.depinfo.omnisus.user.dto.SigninRequest;
import org.depinfo.omnisus.user.dto.SigninResponse;
import org.depinfo.omnisus.user.exception.BadCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private UserService userService;
    @PostMapping("/api/id/signin")
    public @ResponseBody SigninResponse signin(@RequestBody SigninRequest s) throws BadCredentialsException {
        System.out.println("ID : SIGNIN request " + s);
        s.username = s.username.trim().toLowerCase();
        try {
            Authentication auth = new UsernamePasswordAuthenticationToken(s.username, s.password);
            authManager.authenticate(auth);
            SecurityContextHolder.getContext().setAuthentication(auth);
            System.out.println("Logged as " + s.username);
            SigninResponse resp = new SigninResponse();
            MUser loggedUser = userService.studentFromUsername(s.username);
            resp.id = loggedUser.id;
            resp.username = loggedUser.username;
            return resp;
        } catch (org.springframework.security.authentication.BadCredentialsException bce) {
            throw new BadCredentialsException();
        }
    }

    @PostMapping("/api/id/signout")
    public @ResponseBody String signout() {
        SecurityContextHolder.getContext().setAuthentication(null);
        return "Ok!";
    }

    @PutMapping("/api/student")
    public @ResponseBody String updateUser(@RequestBody String publicName) {
        MUser student = currentStudent();
        this.userService.updateUser(student.id, publicName);
        return "Ok!";
    }

    private MUser currentStudent() {
        UserDetails ud = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userService.studentFromUsername(ud.getUsername());
    }

}
