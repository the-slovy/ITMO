import re

from Informatics.Lab3.first import First
from Informatics.Lab3.second import Second
from Informatics.Lab3.third import Third


def num0():
    tests = ["X-O___X-OX-O", "123X-O", "123X-O_X-O123", ":->)", ":^(X-O"]
    print("Запуск тестов: " + "; ".join(tests))
    for test in tests:
        print("Нажмите 'Enter', чтобы перейти к следующиму тесту")
        print("Тестовая строка: \"" + test + "\"")
        print("Ответ: " + str(First.count_of_smiles(test)))

        com = input()
        while com != "":
            com = input()
    print("Тесты кончились(")


def num1():
    tests = ["Прямо сейчас/Я сдаю лабу", "аоаоа/аоаоаоа/аоаоа", "Вы читаете это", "ПРИВЕЕЕЕТ/ААааААа/АоАоА", "аоаоаффа/аоаоаоа/аоаффаоффф"]
    print("Запуск тестов: " + "; ".join(tests))
    for test in tests:
        print("Нажмите 'Enter', чтобы перейти к следующиму тесту")
        print("Тестовая строка: \"" + test + "\"")
        print("Ответ: " + str(Second.find_haiku(test)))

        com = input()
        while com != "":
            com = input()
    print("Тесты кончились(")


def num2():
    tests = ["123@ya.ru", "_asd1@ya.ru", "#123@ya.ru", "213@e23.ru", "123s@ya.ru123"]
    print("Запуск тестов: " + "; ".join(tests))
    for test in tests:
        print("Нажмите 'Enter', чтобы перейти к следующиму тесту")
        print("Тестовая строка: \"" + test + "\"")
        print("Ответ: " + str(Third.check_email(test)))

        com = input()
        while com != "":
            com = input()
    print("Тесты кончились(")


def main():
    while True:
        print("""Команды:
    quit: выйти
    draw: нарисовать смайлик
    0: тест задания №1
    1: доп задание №1
    2: доп задание №2""")
        com = input()
        if com == "quit":
            exit()
        elif com == "0":
            num0()
        elif com == "draw":
            First.draw_smile()
        elif com == "1":
            num1()
        elif com == "2":
            num2()
        else:
            print("Такой команды неть")


if __name__ == '__main__':
    main()
