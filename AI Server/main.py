# coding=utf-8
# This is a sample Python script.
from Server import Server

# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    port = 1337  # randint(1000, 65535)
    Server(port).start()
