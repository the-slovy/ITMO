import re
import turtle

# 336072 % 5 -> 2
# 336072 % 4 -> 0
# 336072 % 7 -> 2
# smile: X-O


class First:
    @staticmethod
    def count_of_smiles(string):
        return len(re.findall("X-O", string))

    @staticmethod
    def draw_smile():
        try:
            # Settings
            turtle.hideturtle()
            turtle.bgcolor("#121212")
            turtle.pensize(4)

            # Draw circle
            turtle.speed(20)
            turtle.up()
            turtle.setpos(0, -300)
            turtle.begin_fill()
            turtle.fillcolor("#FFBF00")  # draw head
            turtle.circle(300)
            turtle.end_fill()

            # Draw X
            turtle.speed(5)
            turtle.up()
            turtle.setpos(-100, 200)
            turtle.down()
            turtle.right(30)
            turtle.forward(((100 * 100) + (200 * 200)) ** 0.5)
            turtle.up()
            turtle.left(120)
            turtle.goto(turtle.xcor(), 200)
            turtle.left(120)
            turtle.down()
            turtle.forward(((100 * 100) + (200 * 200)) ** 0.5)
            turtle.up()

            # Draw -
            turtle.goto(0, 50)
            turtle.left(60)
            turtle.down()
            turtle.forward(80)

            # Draw O
            turtle.up()
            turtle.goto(-215 / 3, -200)
            turtle.down()
            turtle.left(45)

            for loop in range(2):
                turtle.circle(100, 90)
                turtle.circle(100 / 2, 90)

            turtle.exitonclick()
        except Exception:
            First.draw_smile()


First.draw_smile()