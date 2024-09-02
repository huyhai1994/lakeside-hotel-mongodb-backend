package com.codegym.lakesidehotelmongodb.service.interfac;

import com.codegym.lakesidehotelmongodb.dto.LoginRequest;
import com.codegym.lakesidehotelmongodb.dto.Response;
import com.codegym.lakesidehotelmongodb.entity.User;

public interface IUserService {
    Response register(User user);

    Response login(LoginRequest loginRequest);

    Response getAllUsers();

    Response getUSerBookingHistory(String userId);

    Response deleteUser(String userId);

    Response getUserById(String userId);

    Response getMyInfo(String email);
}
