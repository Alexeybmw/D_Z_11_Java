package ru.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TasksTest {


    @Test
    public void shouldMatchesSimpleTasksTrue() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");


        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить родителям");
        Assertions.assertEquals(expected, actual);
    }

    // 2) Тест, когда нет совпадения в SimpleTask

    @Test
    public void shouldMatchesSimpleTasksFalse() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean expected = false;
        boolean actual = simpleTask.matches("Позвонить друзьям");
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void shouldMatchesEpicTrue() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("Хлеб");
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void shouldMatchesEpicFalse() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("Помидоры");
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void shouldMatchesMeetingInTopicFieldTrue() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("Выкатка 3й версии приложения");
        Assertions.assertEquals(expected, actual);

    }


    @Test
    public void shouldMatchesMeetingInProjectFieldTrue() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("Приложение НетоБанка");
        Assertions.assertEquals(expected, actual);

    }


    @Test
    public void shouldMatchesMeetingInTopicFieldFalse() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = false;
        boolean actual = meeting.matches("Выкатка 4й версии приложения");
        Assertions.assertEquals(expected, actual);

    }


    @Test
    public void shouldMatchesMeetingInProjectFieldFalse() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = false;
        boolean actual = meeting.matches("Приложение Банка");
        Assertions.assertEquals(expected, actual);

    }
}