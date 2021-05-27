package com.shop.dynamo.repo;

import com.shop.dynamo.model.UserDetail;
import org.springframework.data.repository.CrudRepository;

public interface UserDetailRepository
        extends CrudRepository<UserDetail, String> {
}
