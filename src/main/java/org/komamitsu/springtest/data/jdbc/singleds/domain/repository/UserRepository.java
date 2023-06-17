package org.komamitsu.springtest.data.jdbc.singleds.domain.repository;

import org.komamitsu.springtest.data.jdbc.singleds.domain.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface UserRepository extends PagingAndSortingRepository<User, String> {
}
