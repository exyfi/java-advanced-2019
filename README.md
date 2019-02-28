# Тесты к курсу «Технологии Java»

[Условия домашних заданий](http://www.kgeorgiy.info/courses/java-advanced/homeworks.html)

## Домашнее задание 4. Implementor

Класс должен реализовывать интерфейс
[Impler](modules/info.kgeorgiy.java.advanced.implementor/info/kgeorgiy/java/advanced/implementor/Impler.java).

Тестирование

 * простой вариант:
    ```info.kgeorgiy.java.advanced.implementor interface <полное имя класса>```
 * сложный вариант:
    ```info.kgeorgiy.java.advanced.implementor class <полное имя класса>```

Исходный код тестов:

* [простой вариант](modules/info.kgeorgiy.java.advanced.implementor/info/kgeorgiy/java/advanced/implementor/InterfaceImplementorTest.java)
* [сложный вариант](modules/info.kgeorgiy.java.advanced.implementor/info/kgeorgiy/java/advanced/implementor/ClassImplementorTest.java)


## Домашнее задание 3. Студенты

Тестирование

 * простой вариант:
    ```info.kgeorgiy.java.advanced.student StudentQuery <полное имя класса>```
 * сложный вариант:
    ```info.kgeorgiy.java.advanced.student StudentGroupQuery <полное имя класса>```

Исходный код

 * простой вариант:
    [интерфейс](modules/info.kgeorgiy.java.advanced.student/info/kgeorgiy/java/advanced/student/StudentQuery.java),
    [тесты](modules/info.kgeorgiy.java.advanced.student/info/kgeorgiy/java/advanced/student/FullStudentQueryTest.java)
 * сложный вариант:
    [интерфейс](modules/info.kgeorgiy.java.advanced.student/info/kgeorgiy/java/advanced/student/StudentGroupQuery.java),
    [тесты](modules/info.kgeorgiy.java.advanced.student/info/kgeorgiy/java/advanced/student/FullStudentGroupQueryTest.java)
 * продвинутый вариант:
    [интерфейс](modules/info.kgeorgiy.java.advanced.student/info/kgeorgiy/java/advanced/student/AdvancedStudentGroupQuery.java),
    [тесты](modules/info.kgeorgiy.java.advanced.student/info/kgeorgiy/java/advanced/student/AdvancedStudentGroupQueryTest.java)


## Домашнее задание 2. ArraySortedSet

Тестирование

 * простой вариант:
    ```info.kgeorgiy.java.advanced.arrayset SortedSet <полное имя класса>```
 * сложный вариант:
    ```info.kgeorgiy.java.advanced.arrayset NavigableSet <полное имя класса>```

Исходный код тестов:

 * [простой вариант](modules/info.kgeorgiy.java.advanced.arrayset/info/kgeorgiy/java/advanced/arrayset/SortedSetTest.java)
 * [сложный вариант](modules/info.kgeorgiy.java.advanced.arrayset/info/kgeorgiy/java/advanced/arrayset/NavigableSetTest.java)


## Домашнее задание 1. Обход файлов

Для того, чтобы протестировать программу:

<<<<<<< HEAD
 * Скачайте тесты ([WalkTest.jar](artifacts/WalkTest.jar)) и библиотеки к ним:
    [junit-4.11.jar](out/production/java-advanced-2019/junit-4.11.jar), [hamcrest-core-1.3.jar](out/production/java-advanced-2019/hamcrest-core-1.3.jar)
=======
 * Скачайте
    * тесты
        * [info.kgeorgiy.java.advanced.base.jar](artifacts/info.kgeorgiy.java.advanced.base.jar)
        * [info.kgeorgiy.java.advanced.walk.jar](artifacts/info.kgeorgiy.java.advanced.walk.jar)
    * и библиотеки к ним:
        * [junit-4.11.jar](lib/junit-4.11.jar)
        * [hamcrest-core-1.3.jar](lib/hamcrest-core-1.3.jar)
>>>>>>> 9384ec2bfe8ab168b381e1a44fdf5fc25df5e78c
 * Откомпилируйте решение домашнего задания
 * Протестируйте домашнее задание
    * Текущая директория должна:
       * содержать все скачанные `.jar` файлы;
       * содержать скомпилированное решение;
       * __не__ содержать скомпилированные самостоятельно тесты.
    * простой вариант:
        ```java -cp . -p . -m info.kgeorgiy.java.advanced.walk Walk <полное имя класса>```
    * сложный вариант:
        ```java -cp . -p . -m info.kgeorgiy.java.advanced.walk RecursiveWalk <полное имя класса>```

Исходный код тестов:

 * [простой вариант](modules/info.kgeorgiy.java.advanced.walk/info/kgeorgiy/java/advanced/walk/WalkTest.java)
 * [сложный вариант](modules/info.kgeorgiy.java.advanced.walk/info/kgeorgiy/java/advanced/walk/RecursiveWalkTest.java)
