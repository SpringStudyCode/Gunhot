package dev.gunhot.jpa.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
id int
name varchar
 */
@Entity
public class BoardEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

//하나의 Board에 여러개의 Post가 속해있잖아 => 그래서 리스트
    @OneToMany(targetEntity = PostEntity.class, fetch = FetchType.LAZY,
//    PostEntity쪽에 있는 ManyToOne과 set임을 알려준다. (변수이름)
//    lazy는 그것만 eager는 table까지 싹다
    mappedBy = "boardEntity")
    private List<PostEntity> postEntityList = new ArrayList<>();
    public BoardEntity() {
    }

    public BoardEntity(Long id, String name, List<PostEntity> postEntityList) {
        this.id = id;
        this.name = name;
        this.postEntityList = postEntityList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPostEntityList(List<PostEntity> postEntityList) {
        this.postEntityList = postEntityList;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<PostEntity> getPostEntityList() {
        return postEntityList;
    }

    @Override
    public String toString() {
        return "BoardEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", postEntityList=" + postEntityList +
                '}';
    }
}
