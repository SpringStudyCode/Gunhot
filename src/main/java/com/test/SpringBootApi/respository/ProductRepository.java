package com.test.SpringBootApi.respository;

import com.test.SpringBootApi.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//jpa에서 제공하는 거 사용할 거여서 필요 X
//데이터베이스에 직접 요청 전달해서 수정되게 함
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
