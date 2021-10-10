import re


# 336072 % 4 -> 0

class Third:
    @staticmethod
    def check_email(string):
        if "".join(re.findall("[a-z0-9._]+@[a-z_]+\.[a-z]+", string.lower())) == string.lower():
            return string[string.index("@") + 1:]
        else:
            return "Fail!"
