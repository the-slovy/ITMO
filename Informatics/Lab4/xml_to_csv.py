from xml.etree import ElementTree

file = 'timetable.xml'

tree = ElementTree.parse(file)
root = tree.getroot()
string = "lang;group;day;time;address;room;lesson;teacher\n"

for info in root.iter('timetable'):
    for lesson in info.iter("lessons"):
        for les_info in lesson.iter('lesson'):
            string += ';'.join([info.attrib['lang'], info.attrib['group'], info.attrib['day'], les_info.attrib['time'], les_info.attrib['address'], les_info.attrib['room'], les_info.attrib['lesson'], les_info.attrib['teacher']]) + '\n'
open("timetable.csv", mode="w", encoding="utf-8").write(string)



