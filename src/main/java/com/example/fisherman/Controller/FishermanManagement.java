package com.example.fisherman.Controller;

import com.example.fisherman.DTO.FishermanDTO;
import com.example.fisherman.api.FishermanManagementApi;
import com.example.fisherman.model.Fisherman;
import com.example.fisherman.service.FishermanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;
import org.w3c.dom.ls.LSInput;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class FishermanManagement implements FishermanManagementApi {
    @Autowired
    FishermanService fs;
    @Override
    public Optional<NativeWebRequest> getRequest() {
        return FishermanManagementApi.super.getRequest();
    }

    @Override
    public ResponseEntity<List<FishermanDTO>> fishermenGet(String name) {
        List<FishermanDTO> ddf = fs.findFishermenByName(name);
        return new ResponseEntity<>(ddf,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> fishermenIdDelete(String id) {
        fs.deleteFishermanById(Long.parseLong(id));
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<FishermanDTO> fishermenIdPut(String id, FishermanDTO body) {
        //Fisherman(String name,String password,int age,String email,String phone){
        Fisherman s = fs.updateFisherman(body.tomodel(), Long.valueOf(id));
        if(s != null){
            return new ResponseEntity<>(s.toDTO(s),HttpStatus.OK);
        }
        System.out.println("param was retuned");
        return new ResponseEntity<>(body,HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Void> fishermenPost(FishermanDTO body) {
        fs.addFisherman(body.tomodel());
        System.out.println("hello");
        return ResponseEntity.ok().build();
    }
}
