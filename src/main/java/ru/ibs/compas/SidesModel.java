package ru.ibs.compas;

import java.util.HashMap;
import java.util.Map;

public class SidesModel {
    private static final SidesModel instance = new SidesModel();

    private final Map<String, AngleRange> model;

    public SidesModel() {
        model = new HashMap<String, AngleRange>();
    }

    public static SidesModel getInstance() {
        return instance;
    }

    public void initList(Map<String, String> sides) {
        for (Map.Entry<String, String> entry : sides.entrySet()) {
            AngleRange range = new AngleRange();
            String[] angle = entry.getValue().split("-");
            range.setAngleStart(Integer.parseInt(angle[0]));
            range.setAngleEnd(Integer.parseInt(angle[1]));

            model.put(entry.getKey(), range);
        }
    }

    public Map<String, String> getSideNameByAngle(int angle) {
        Map<String, String> result = new HashMap<>();
        for (Map.Entry<String, AngleRange> entry : model.entrySet()) {
            AngleRange range = entry.getValue();
            if (range.inRange(angle)) {
                result.put("Side", entry.getKey());
                return result;
            }
        }
        return null;
    }
}
