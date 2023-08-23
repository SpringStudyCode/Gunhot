package dev.gunhot.jpa;

import dev.gunhot.jpa.entity.PostEntity;
import dev.gunhot.jpa.repository.PostRepostiory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;


@Repository
public class PostDao {
    private static final Logger logger = LoggerFactory.getLogger(PostDao.class);
    private final PostRepostiory postRepostiory;
    public PostDao(@Autowired PostRepostiory postRepostiory)
    {
        this.postRepostiory = postRepostiory;
    }
//    실질적인 저장은 Entity에 해야지
    public void createPost(PostDto postDto){
//        PostEntity postEntity = new PostEntity(postDto.getId(),
//                postDto.getTitle(),
//                postDto.getContent(),
//                postDto.getWriter(),
//                null);
        PostEntity postEntity = new PostEntity();
//        postEntity.setId(postDto.getId()); 자동생성됨
        postEntity.setTitle(postDto.getTitle());
        postEntity.setContent(postDto.getContent());
        postEntity.setWriter(postDto.getWriter());
        postEntity.setBoardEntity(null);
        this.postRepostiory.save(postEntity);

    }

    public void updatePost(int id, PostDto postDto){
        Optional<PostEntity> targetEntity = postRepostiory.findById(Long.valueOf(id));
        if (targetEntity.isEmpty())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        PostEntity postEntity = targetEntity.get();
        postEntity.setTitle(
                postDto.getTitle() == null ? postEntity.getTitle() : postDto.getTitle()
        );
        postEntity.setContent(
                postDto.getContent() == null ? postEntity.getContent() : postDto.getContent()
        );
        this.postRepostiory.save(postEntity);
    }

    public PostEntity readPost(int id)
    {
        Optional<PostEntity> postEntity = this.postRepostiory.findById((long)id);
        if (postEntity.isEmpty())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return postEntity.get();
    }

//    findAll -> Iterator이다.
    public Iterator<PostEntity> readAllPost()
    {
        return this.postRepostiory.findAll().iterator();
    }

    public void deletePost(int id)
    {
        Optional<PostEntity> targetEntity = this.postRepostiory.findById((long)id);
        if (targetEntity.isEmpty())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        this.postRepostiory.delete(targetEntity.get());
    }

}
