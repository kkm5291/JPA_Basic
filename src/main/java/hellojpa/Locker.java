package hellojpa;

import jakarta.persistence.*;

@Entity
public class Locker {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @OneToOne(mappedBy = "locker")
    private Member member;
}
