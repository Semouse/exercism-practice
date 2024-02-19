package com.github.semouse.timfrommarketing;

public class Badge {

    private static final String DELIMITER = " - ";

    public String print(Integer id, String name, String department) {
        return parseId(id) + name + DELIMITER + (department == null ? "OWNER"
            : department.toUpperCase());
    }

    private String parseId(Integer id) {
        return id == null ? "" : String.format("[%d]" + DELIMITER, id);
    }
}
