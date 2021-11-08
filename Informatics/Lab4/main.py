import time

from Lab4.parser import Parser
from Lab4.with_libraries import LibrariesMethod
from Lab4.with_reg_exp import RegExp


def test1():
    Parser.blocks_to_json(Parser.xml_to_blocks())


def test2():
    LibrariesMethod.method()


def test3():
    RegExp.blocks_to_json(RegExp.xml_to_blocks())


for i in range(3):
    start_time = time.perf_counter()
    for j in range(10):
        eval("test" + str(i + 1) + "()")
    print("Время выполнения программы " + str(i + 1) + " " + str(time.perf_counter() - start_time) + " сек.")