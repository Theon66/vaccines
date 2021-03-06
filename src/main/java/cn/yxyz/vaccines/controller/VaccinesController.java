package cn.yxyz.vaccines.controller;

import cn.yxyz.vaccines.pojo.User;
import cn.yxyz.vaccines.pojo.Vaccines;
import cn.yxyz.vaccines.service.VaccinesService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value="获得所有疫苗信息", httpMethod = "POST",response = Vaccines.class,notes="获得所有疫苗信息")
    //获得所有疫苗信息
    @PostMapping("vaccines/findAllVaccines")
    public ResponseEntity<List<Vaccines>> findAllVaccines() {
        return ResponseEntity.status(HttpStatus.OK).body(vaccinesService.findAllVaccines());

    }

    @ApiOperation(value="添加疫苗", httpMethod = "POST",response =Integer.class,notes="添加疫苗")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "vaccines", value = "疫苗对象", required = true, dataType = "Vaccines")
    })
    //添加疫苗
    @PostMapping("vaccines/addVaccines")
    public ResponseEntity<Integer> addVaccines(@RequestBody Vaccines vaccines) {
        return ResponseEntity.status(HttpStatus.OK).body(vaccinesService.addVaccines(vaccines));

    }

    @ApiOperation(value="修改疫苗", httpMethod = "POST",response =Integer.class,notes="修改疫苗")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "vaccines", value = "疫苗对象", required = true, dataType = "Vaccines")
    })
    //修改疫苗
    @PostMapping("vaccines/modifyVaccines")
    public ResponseEntity<Integer> modifyVaccines(@RequestBody Vaccines vaccines) {
        return ResponseEntity.status(HttpStatus.OK).body(vaccinesService.modifyVaccines(vaccines));

    }
    @ApiOperation(value="删除疫苗", httpMethod = "POST",response =Integer.class,notes="删除疫苗")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "vid", value = "疫苗ID", required = true, dataType = "int", paramType = "query")
    })
    //删除疫苗
    @PostMapping("vaccines/deleteVaccines")
    public ResponseEntity<Integer> deleteVaccines(@RequestParam int vid) {
        return ResponseEntity.status(HttpStatus.OK).body(vaccinesService.deleteVaccines(vid));
    }

    @ApiOperation(value="根据vid获得疫苗详情信息", httpMethod = "POST",response =Vaccines.class,notes="根据vid获得疫苗详情信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "vid", value = "疫苗ID", required = true, dataType = "int", paramType = "query")
    })
    //根据vid获得疫苗详情信息
    @PostMapping("vaccines/findVaccinesByVid")
    public ResponseEntity<Vaccines> findVaccinesByVid(@RequestParam int vid) {
        return ResponseEntity.status(HttpStatus.OK).body(vaccinesService.findVaccinesByVid(vid));

    }

    @ApiOperation(value="根据vname获得疫苗详情信息", httpMethod = "POST",response =Vaccines.class,notes="根据vname获得疫苗详情信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "vname", value = "疫苗名称", required = true, dataType = "String", paramType = "query")
    })
    //根据vname获得疫苗详情信息
    @PostMapping("vaccines/findVaccinesByVname")
    public ResponseEntity<List<Vaccines>> findVaccinesByVname(@RequestParam String vname) {
        return ResponseEntity.status(HttpStatus.OK).body(vaccinesService.findVaccinesByVname(vname));

    }


    @ApiOperation(value="根据vname和vclass获得疫苗详情信息", httpMethod = "POST",response =Vaccines.class,notes="根据vname和vclass获得疫苗详情信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "vname", value = "疫苗名称", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "vclass", value = "疫苗类别", required = true, dataType = "String", paramType = "query")
    })
    //根据vname和vclass获得疫苗详情信息
    @PostMapping("vaccines/findVaccinesByVnameVclass")
    public ResponseEntity<List<Vaccines>> findVaccinesByVnameVclass(@RequestParam String vname,@RequestParam String vclass) {
        return ResponseEntity.status(HttpStatus.OK).body(vaccinesService.findVaccinesByVnameVclass(vname,vclass));

    }

    @ApiOperation(value="根据类别获取疫苗", httpMethod = "POST",response =Vaccines.class,notes="根据类别获取疫苗")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "vclass", value = "疫苗类别", required = true, dataType = "String", paramType = "query")
    })
    //根据类别获取疫苗
    @PostMapping("vaccines/findVaccinesByVclass")
    public ResponseEntity<List<Vaccines>> findVaccinesByVclass(@RequestParam String vclass) {
        return ResponseEntity.status(HttpStatus.OK).body(vaccinesService.findVaccinesByVclass(vclass));

    }

    @ApiOperation(value="根据年龄段获取疫苗", httpMethod = "POST",response =Vaccines.class,notes="根据年龄段获取疫苗")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "age", value = "年龄", required = true, dataType = "String", paramType = "query")
    })
    //根据年龄段获取疫苗
    @PostMapping("vaccines/findVaccinesByAge")
    public ResponseEntity<List<Vaccines>> findVaccinesByVage(@RequestParam String age) {
        return ResponseEntity.status(HttpStatus.OK).body(vaccinesService.findVaccinesByVage(age));

    }


}
