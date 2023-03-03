package hellojpa;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Member {
    @Id
    private Long id;

    @Column(name = "name")
    private String username;

    private int age;

    // db에서 ENUM처럼 사용할 수 있게 해주는 것
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;

    // 해당 필드는 테이블로 들어가지 않고 메모리상으로만 사용하겠다
    @Transient
    private int tmp;

    public Member() {

    }
}
