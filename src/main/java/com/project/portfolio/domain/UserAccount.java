package com.project.portfolio.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Getter
@ToString
@Table(indexes={
        @Index(columnList = "email", unique = true),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAccount that)) return false;
        return this.getUserId() != null && this.getUserId().equals(that.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getUserId());
    }


}
