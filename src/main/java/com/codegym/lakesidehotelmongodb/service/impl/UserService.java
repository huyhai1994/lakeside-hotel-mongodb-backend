package com.codegym.lakesidehotelmongodb.service.impl;

import com.codegym.lakesidehotelmongodb.dto.LoginRequest;
import com.codegym.lakesidehotelmongodb.dto.Response;
import com.codegym.lakesidehotelmongodb.entity.User;
import com.codegym.lakesidehotelmongodb.service.interfac.IUserService;

public class UserService implements IUserService {
    @Override
    public Response register(User user) {
        return null;
    }

    @Override
    public Response login(LoginRequest loginRequest) {
        return null;
    }

    @Override
    public Response getAllUsers() {
        return null;
    }

    @Override
    public Response getUSerBookingHistory(String userId) {
        return null;
    }

    @Override
    public Response deleteUser(String userId) {
        return null;
    }

    @Override
    public Response getUserById(String userId) {
        return null;
    }

    @Override
    public Response getMyInfo(String email) {
        return null;
    }
}
