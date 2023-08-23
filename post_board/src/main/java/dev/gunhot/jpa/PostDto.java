package dev.gunhot.jpa;

public class PostDto {
    private int id;
    private String content;
    private String title;
    private String writer;

    public PostDto() {
    }

    public PostDto(int id, String content, String title, String writer, int boardId) {
        this.id = id;
        this.content = content;
        this.title = title;
        this.writer = writer;
        this.boardId = boardId;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", boardId=" + boardId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    private int boardId;
}
