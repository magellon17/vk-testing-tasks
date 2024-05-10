package ru.siobko.testing.tasks.patterns.models.group;

public class Group {
    private final String name;
    private final GroupType type;
    private final GroupCategory category;

    public Group(GroupType type, GroupCategory category, String name) {
        this.type = type;
        this.category = category;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public GroupType getType() {
        return type;
    }

    public GroupCategory getCategory() {
        return category;
    }
}
