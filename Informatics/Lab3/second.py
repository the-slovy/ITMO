import re


# 336072 % 6 -> 0

class Second:
    @staticmethod
    def find_haiku(string):
        if len(re.findall("/", string)) != 2:
            return "Не хайку. Должно быть 3 строки"
        elif re.fullmatch(
                "([^уеыаоэяиюё]*[уеыаоэяиюё][^уеыаоэяиюё]*){5}/([^уеыаоэяиюё]*[уеыаоэяиюё][^уеыаоэяиюё]*){7}/([^уеыаоэяиюё]*[уеыаоэяиюё][^уеыаоэяиюё]*){5}",
                string.lower(), flags=re.I):
            return "Хайку!"
        else:
            return "Не хайку."
