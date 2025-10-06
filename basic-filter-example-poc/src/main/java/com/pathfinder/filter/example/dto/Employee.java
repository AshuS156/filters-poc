package com.pathfinder.filter.example.dto;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
public class Employee{

    private String employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String newJoiner;
    private String learningPending;
    private Long salary;
    private int rating;

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this,ToStringStyle.JSON_STYLE);
    }

}
