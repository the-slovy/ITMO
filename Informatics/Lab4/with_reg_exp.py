import re


class RegExp:
    @staticmethod
    def read_xml_file(name="timetable.xml"):
        file = open(name, mode="r", encoding="utf-8")
        data = []

        string = ""
        for symbol in re.sub("\t", "", re.sub("\r", "", file.read())):
            string += symbol
            if symbol == ">":
                data.append(string.lstrip())
                string = ""

        file.close()
        return data

    @staticmethod
    def xml_to_blocks(name="timetable.xml"):
        data = RegExp.read_xml_file(name)
        blocks_dict = {}

        # разбиваем xml на блоки, выделяя теги и аргументы тегов
        for block in data:
            block = re.sub("<", "", block)
            block = re.sub(">", "", block)
            block = re.sub("\n", " ", block)
            block = block.replace(" ", "*", 1).strip().split("*")

            if block[0] not in blocks_dict.keys():
                blocks_dict[block[0]] = [[block[1].split("\" ")]] if len(block) == 2 else []
            else:
                blocks_dict[block[0]].append([block[1].split("\" ")] if len(block) == 2 else [])

        return blocks_dict

    @staticmethod
    def blocks_to_json(blocks_dict: dict, file_name="timetable.json"):
        tabs, output_string = 0, "{\n"
        for key, value in blocks_dict.items():
            if "/" not in key:
                tabs += 1
                output_string += '  ' * tabs + '"' + key + '": '
                output_string += "{\n" if len(value) < 2 else "[\n"

                if output_string[-2] == "{" and value:
                    tabs += 1
                    for v in value[0][0]:
                        arg = v.split("=")
                        output_string += '  ' * tabs + '"' + arg[0] + '": ' + arg[1] + "\",\n"
                    output_string = output_string[:-3] + ",\n"
                    tabs -= 1
                elif output_string[-2] == "[" and value:
                    tabs += 1
                    output_string += '  ' * tabs + '{\n'
                    for v in value:
                        for a in v[0]:
                            arg = a.split("=")
                            output_string += '  ' * (tabs + 1) + '"' + arg[0] + '": ' + arg[1] + "\",\n"
                        output_string = output_string[:-4] + "\n"
                        output_string += '  ' * tabs + "},\n"
                        output_string += '  ' * tabs + '{\n'
                    output_string = output_string[:-12] + "\n"
                    tabs -= 1
                    output_string += '  ' * tabs + ']\n'

            else:
                value = blocks_dict[re.sub("/", "", key)]
                tabs -= 1
                output_string += '  ' * tabs + "}\n" if len(value) < 2 else "]\n"
        output_string += "}"

        file = open(file_name, mode="w", encoding="utf-8")
        file.write(output_string)
        file.close()
