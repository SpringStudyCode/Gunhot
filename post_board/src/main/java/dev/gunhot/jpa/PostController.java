package dev.gunhot.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostService postService;

    public PostController(@Autowired PostService postService)
    {
        this.postService = postService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody PostDto postDto){
        this.postService.createPost(postDto);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updatePost(@PathVariable("id") int id, @RequestBody PostDto postDto){
        this.postService.updatePost(id, postDto);
    }

    @GetMapping("{id}")
    public PostDto readPost(@PathVariable("id") int id)
    {
        return this.postService.readPost(id);
    }

    @GetMapping("")
    public List<PostDto> readAllPost()
    {
        return this.postService.readAllPost();
    }

    @DeleteMapping("{id}")
    public void deletePost(@PathVariable("id") int id)
    {
        this.postService.deletePost(id);
    }
}
