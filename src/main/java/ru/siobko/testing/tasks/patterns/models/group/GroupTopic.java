package ru.siobko.testing.tasks.patterns.models.group;

public enum GroupTopic {
    CARS{
        public String toString() {
            return "Автомобили";
        }
    },
    CAR_WASH{
        public String toString() {
            return "Автомойка";
        }
    }
}
