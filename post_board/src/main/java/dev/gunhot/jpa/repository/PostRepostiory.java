package dev.gunhot.jpa.repository;

import dev.gunhot.jpa.entity.BoardEntity;
import dev.gunhot.jpa.entity.PostEntity;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//  <Table이름, ID타입>
//  얘는 annotation 필요 없음 extends 했으므로
public interface PostRepostiory extends CrudRepository<PostEntity, Long> {
//    findBy OR findAllBy 외워두기
    List<PostEntity> findAllByWriter(String writer);
    List<PostEntity> findAllByWriterAndBoardEntity(String writer, BoardEntity boardEntity);
    List<PostEntity> findAllByWriterContaining(String writer); //writer의 일부를 가지는~
}
