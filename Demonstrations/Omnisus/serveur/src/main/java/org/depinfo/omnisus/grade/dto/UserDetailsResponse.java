package org.depinfo.omnisus.grade.dto;

import java.util.ArrayList;
import java.util.List;

public class UserDetailsResponse {
    public String publicName;
    public String username;
    public List<GradeResponse> grades = new ArrayList<>();
}
