package ru.ibs.compas;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/compas", produces = "application/json; charset=utf-8")
public class CompasController {

    private static final SidesModel sidesModel = SidesModel.getInstance();

    @PostMapping(value = "/init", consumes = "application/json")
    public void sideOfTheWorldInitiate(@RequestBody Map<String, String> map) {
        sidesModel.initList(map);
    }

    @PostMapping(value = "/getSide", consumes = "application/json", produces = "application/json")
    public Map<String, String> getSideOfTheWorld(@RequestBody Map<String, Integer> map) {
        return sidesModel.getSideNameByAngle(map.get("Degree"));
    }
}
