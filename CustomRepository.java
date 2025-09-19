package org.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomRepository extends JpaRepository<Item,Integer> {

    Item findByName(String name);

}
