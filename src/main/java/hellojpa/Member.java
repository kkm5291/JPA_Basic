package hellojpa;

import jakarta.persistence.*;
import jdk.jfr.Unsigned;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.Lock;

@Entity
public class Member extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String name;


    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Long getId() {
        return id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Team getTeam() {
//        return team;
//    }
//
//    // 편의 메서드 (연관관계 주인에게 작성시키도록 하자!)
//    public void changeTeam(Team team) {
//        this.team = team;
//        team.getMembers().add(this);
//    }


}
