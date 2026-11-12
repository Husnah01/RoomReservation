package com.example.hotelreservationsystem.service;

import com.example.hotelreservationsystem.entity.Room;
import com.example.hotelreservationsystem.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
    public Room addRoom(Room room){
        return roomRepository.save(room);
    }
    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }
    public Room getRoomById(Long id){
        return roomRepository.findById(id).orElseThrow(() ->new RuntimeException("Room is Not Found"));
    }

}
