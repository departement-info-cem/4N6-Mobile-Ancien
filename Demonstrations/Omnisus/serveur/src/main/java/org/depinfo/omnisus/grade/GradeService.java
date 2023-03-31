package org.depinfo.omnisus.grade;

import org.depinfo.omnisus.grade.dto.ScoreBoardResponse;
import org.depinfo.omnisus.grade.dto.UserDetailsResponse;
import org.depinfo.omnisus.user.MUser;

import java.util.List;

public interface GradeService {

    UserDetailsResponse detail(MUser student);

    List<ScoreBoardResponse> allDetails();
    void deleteAll();
}