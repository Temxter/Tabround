package com.skorina.tabround.repository;

import com.skorina.tabround.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
}
