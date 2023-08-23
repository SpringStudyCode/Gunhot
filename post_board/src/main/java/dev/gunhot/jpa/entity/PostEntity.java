package dev.gunhot.jpa.entity;

import javax.persistence.*;

/*
id int
title varchar
content varchar
writer varchar
board int
 */
/*
얘는 entity가 된다.
위에 있는 속성들을 적어주자
 */
@Entity
//이름은 post로 하겠다.
@Table(name="post")
public class PostEntity extends BaseEntity{
    @Id
//    private long id; -> Primitive 자제하고 클래스 기반 쓸 것
    @GeneratedValue(strategy = GenerationType.IDENTITY)//PK인 것을 알려주는
    private Long id;
    private String title;
    private String content;
    private String writer;

//    Foreign Key는 정의하는 법 -> workbench에서도 잘생김
//    관계 명시해주면 끝 ㄹㅈㄷ
//    여러개의 Post가 하나의 Board에 속해있잖아. => 그래서 변수 하나
    @ManyToOne(targetEntity = BoardEntity.class, fetch = FetchType.LAZY)
//    이름은 board_id로 참조
    @JoinColumn(name="board_id")
    private BoardEntity boardEntity;
    public void setId(Long id) {
        this.id = id;
    }
//    쨋든 위의 지랄하면 workbench에 table생기는 게 ㄹㅈㄷ임

//    당연히 클래스니깐 Getter Setter Constructor필요함
//    FK만 들고 Constructor 만들기

    public PostEntity(Long id, String title, String content, String writer, BoardEntity boardEntity) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.boardEntity = boardEntity;
    }

    public PostEntity() {
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getWriter() {
        return writer;
    }

    public void setBoardEntity(BoardEntity boardEntity) {
        this.boardEntity = boardEntity;
    }

    public BoardEntity getBoardEntity() {
        return boardEntity;
    }

    @Override
    public String toString() {
        return "PostEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", boardEntity=" + boardEntity +
                '}';
    }
}
