package org.depinfo.omnisus.user;


import org.depinfo.omnisus.grade.MGrade;
import org.depinfo.omnisus.grade.MGradeRepository;
import org.depinfo.omnisus.user.dto.SignupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.ArrayList;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MUserRepository userRepository;
    @Autowired
    private MGradeRepository gradeRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(final DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MUser student = userRepository.findByUsername(username.trim().toLowerCase()).get();
        User u = new User(student.username, student.password, new ArrayList<>());
        return u;
    }

    @Override
    @Transactional(rollbackFor = UsernameAlreadyTaken.class)
    public void signup(SignupRequest req) throws UsernameTooShort, PasswordTooShort, UsernameAlreadyTaken {
        String username = req.username.toLowerCase().trim();
        if (username.length() < 2) throw new UsernameTooShort();
        if (req.password.length() < 4) throw new PasswordTooShort();
        try {
            MUser p = new MUser();
            MGrade grade = new MGrade();
            p.username = username;
            p.password = passwordEncoder.encode(req.password);
            p.publicName = "Jean Drapeau";
            grade.grade = 15;
            grade.name = "Examen 1";
            grade.user = p;
            userRepository.saveAndFlush(p);
            gradeRepository.saveAndFlush(grade);
        } catch (DataIntegrityViolationException e) {
            throw new UsernameAlreadyTaken();
        }
    }

    @Override
    public MUser studentFromUsername(String username) {
        return userRepository.findByUsername(username).get();
    }

    @Override
    public int updateUser(Long userId, String publicUsername) {
        // TODO Mon collègue m'a dit qu'il y a un problème avec les injections SQL mais je vois pas trop où est le problème...
        return jdbcTemplate.update("UPDATE MUSER SET PUBLIC_NAME = '" + publicUsername + "' WHERE ID = " + userId + "");
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }
}
