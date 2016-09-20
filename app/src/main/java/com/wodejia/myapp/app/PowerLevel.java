package com.wodejia.myapp.app;

/**
 * Created by clarence on 16/9/19.
 */
public enum PowerLevel {
    Manager(100, "管理员"), Civilian(1, "平民");

    private int level;
    private String name;

    PowerLevel(int level, String name) {
        this.level = level;
        this.name = name;
    }

    public static PowerLevel getName(int level) {
        for (PowerLevel powerLevel : PowerLevel.values()) {
            if (powerLevel.level == level) {
                return powerLevel;
            }
        }
        return null;
    }
}
