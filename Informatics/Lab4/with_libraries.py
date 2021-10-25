import xmltodict
import json


class LibrariesMethod:
    @staticmethod
    def method():
        file_name = "timetable.xml"
        file = open(file_name, mode="r", encoding="utf-8").read()

        d = xmltodict.parse(file)

        with open("timetable_libraries.json", mode="w") as output_file:
            json.dump(d, output_file, ensure_ascii=False)

