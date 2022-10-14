package com.project.portfolio.domain;

import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserAccount extends AuditingFields {
    @Id
    @Column(length = 50)
    private String userId;

    @Setter
    @Column(nullable = false) private String userPassword;

    @Setter @Column(length = 50) private String userName;

    @Setter @Column(length = 8) private String birth;

    @Setter @Column(length = 100) private String email;

    @Setter private String report;

    @Setter private String reported;

    private UserAccount(String userId, String userPassword, String userName, String birth, String email, String report, String reported){
        this.userId = userId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.birth = birth;
        this.email = email;
        this.report = report;
        this.reported = reported;

    }

    protected UserAccount() {}

    public static UserAccount of(String userId, String userPassword, String userName, String birth, String email, String report, String reported) {
        return new UserAccount(userId, userPassword, userName, birth, email, report, reported);
    }


}
