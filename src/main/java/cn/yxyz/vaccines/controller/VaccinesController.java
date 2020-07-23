package cn.yxyz.vaccines.controller;

import cn.yxyz.vaccines.pojo.Vaccines;
import cn.yxyz.vaccines.service.VaccinesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VaccinesController {
    private VaccinesService vaccinesService;

    public VaccinesController(VaccinesService vaccinesService) {
        this.vaccinesService = vaccinesService;
    }
    //获得所有疫苗信息
    @PostMapping("vaccines/findAllVaccines")
    public ResponseEntity<List<Vaccines>> findAllVaccines() {
        return ResponseEntity.status(HttpStatus.OK).body(vaccinesService.findAllVaccines());

    }
    //添加疫苗
    @PostMapping("vaccines/addVaccines")
    public ResponseEntity<Integer> addVaccines(@RequestBody Vaccines vaccines) {
        return ResponseEntity.status(HttpStatus.OK).body(vaccinesService.addVaccines(vaccines));

    }
    //修改疫苗
    @PostMapping("vaccines/modifyVaccines")
    public ResponseEntity<Integer> modifyVaccines(@RequestBody Vaccines vaccines) {
        return ResponseEntity.status(HttpStatus.OK).body(vaccinesService.modifyVaccines(vaccines));

    }
    //删除疫苗
    @PostMapping("vaccines/deleteVaccines")
    public ResponseEntity<Integer> deleteVaccines(@RequestParam int vid) {
        return ResponseEntity.status(HttpStatus.OK).body(vaccinesService.deleteVaccines(vid));
    }
    //根据vid获得疫苗详情信息
    @PostMapping("vaccines/findVaccinesByVid")
    public ResponseEntity<Vaccines> findVaccinesByVid(int vid) {
        return ResponseEntity.status(HttpStatus.OK).body(vaccinesService.findVaccinesByVid(vid));

    }
}
