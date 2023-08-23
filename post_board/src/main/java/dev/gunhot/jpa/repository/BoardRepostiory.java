package dev.gunhot.jpa.repository;

import dev.gunhot.jpa.entity.BoardEntity;
import dev.gunhot.jpa.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//  <Table이름, ID타입>
public interface BoardRepostiory extends CrudRepository<BoardEntity, Long> {
//   커스터마이징
}
