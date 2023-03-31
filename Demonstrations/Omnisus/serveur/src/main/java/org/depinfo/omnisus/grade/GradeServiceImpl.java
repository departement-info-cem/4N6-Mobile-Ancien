package org.depinfo.omnisus.grade;

import jakarta.transaction.Transactional;
import org.depinfo.omnisus.grade.dto.GradeResponse;
import org.depinfo.omnisus.grade.dto.ScoreBoardResponse;
import org.depinfo.omnisus.grade.dto.UserDetailsResponse;
import org.depinfo.omnisus.user.MUser;
import org.depinfo.omnisus.user.MUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class GradeServiceImpl implements GradeService {
    @Autowired
    MGradeRepository gradeRepository;
    @Autowired
    MUserRepository userRepository;

    @Override
    public UserDetailsResponse detail(MUser student) {
        UserDetailsResponse response = new UserDetailsResponse();
        response.publicName = student.publicName;
        response.username = student.username;
        for (MGrade grade : student.grades) {
            GradeResponse gradeResponse = new GradeResponse();
            gradeResponse.gradeId = grade.id;
            gradeResponse.grade = grade.grade;
            gradeResponse.name = grade.name;
            response.grades.add(gradeResponse);
        }
        return response;
    }

    @Override
    public List<ScoreBoardResponse> allDetails() {
        List<Object[]> grades = userRepository.findAllOrdered();
        List<ScoreBoardResponse> response = new ArrayList<>();
        for (Object[] grade : grades) {
            ScoreBoardResponse scoreBoardResponse = new ScoreBoardResponse();
            scoreBoardResponse.publicName = (String) grade[0];
            scoreBoardResponse.username = (String) grade[1];
            scoreBoardResponse.gradeId = (Long) grade[2];
            scoreBoardResponse.grade = (Integer) grade[3];
            scoreBoardResponse.name = (String) grade[4];
            response.add(scoreBoardResponse);
        }
        return response;
    }

    @Override
    public void deleteAll() {

        gradeRepository.deleteAll();
    }
}
