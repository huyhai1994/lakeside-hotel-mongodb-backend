package com.codegym.lakesidehotelmongodb.repo;

import com.codegym.lakesidehotelmongodb.entity.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RoomRepository extends MongoRepository<Room, String> {
    List<String> findDistinctRoomType();

    List<Room> findAllAvailableRooms();

    List<Room> findByRoomTypeLikeAndIdNotIn(String roomType, List<String> bookedRoomIds);
}
