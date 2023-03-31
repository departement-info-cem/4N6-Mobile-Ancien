package org.depinfo.omnisus.grade;

import org.depinfo.omnisus.grade.dto.UserDetailsResponse;
import org.depinfo.omnisus.user.MUser;
import org.depinfo.omnisus.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GradeController {

    @Autowired
    private GradeService gradeService;
    @Autowired
    private UserService userService;

    @GetMapping("/api/grade")
    public @ResponseBody UserDetailsResponse detail() {
        MUser student = currentStudent();
        return gradeService.detail(student);
    }

    private MUser currentStudent() {
        UserDetails ud = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userService.studentFromUsername(ud.getUsername());
    }
}
