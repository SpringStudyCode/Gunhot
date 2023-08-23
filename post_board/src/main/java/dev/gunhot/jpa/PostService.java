package dev.gunhot.jpa;

import dev.gunhot.jpa.entity.PostEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class PostService {
    private static final Logger logger = LoggerFactory.getLogger(PostService.class);
    private final PostDao postDao;

    public PostService(@Autowired PostDao postDao) {
        this.postDao = postDao;
    }

    public void createPost(PostDto postDto){
        this.postDao.createPost(postDto);
    }

    public void updatePost(int id, PostDto postDto){
        this.postDao.updatePost(id, postDto);
    }

    public PostDto readPost(int id)
    {
        PostEntity postEntity = this.postDao.readPost(id);
        return new PostDto(
//                postEntity.getId(),
              Math.toIntExact(postEntity.getId()),
                postEntity.getTitle(),
                postEntity.getContent(),
                postEntity.getWriter(),
                postEntity.getBoardEntity() == null ? 0 : Math.toIntExact(postEntity.getBoardEntity().getId()));
    }

    public List<PostDto> readAllPost()
    {
        Iterator<PostEntity> postEntityIterator = this.postDao.readAllPost();
        List<PostDto> postDtoList = new ArrayList<PostDto>();
        while (postEntityIterator.hasNext())
        {
            PostEntity postEntity = postEntityIterator.next();
            postDtoList.add(new PostDto(
//                postEntity.getId(),
              Math.toIntExact(postEntity.getId()),
                postEntity.getTitle(),
                postEntity.getContent(),
                postEntity.getWriter(),
                postEntity.getBoardEntity() == null ? 0 : Math.toIntExact(postEntity.getBoardEntity().getId()))
            );
        }
        return postDtoList;
    }

    public void deletePost(int id)
    {
        this.postDao.deletePost(id);
    }

}
