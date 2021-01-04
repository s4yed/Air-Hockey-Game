#!/usr/bin/env python3

import socket as s
import threading
import logging
from AI.LoadModels import predict

BUFFER_LEN = 1024


class Server:
    def __init__(self, port):
        logging.basicConfig(format='[%(name)s]-[%(asctime)s]-[%(levelname)s]-%(message)s')
        self.logger = logging.getLogger('Air Hokey AI')
        self.logger.setLevel(logging.INFO)
        self.port = port
        self.ip = s.gethostbyname(s.gethostname())
        self.addr = (self.ip, self.port)
        self.server = s.socket(s.AF_INET, s.SOCK_STREAM)
        self.server.bind(self.addr)

    def client(self, conn, addr):
        self.logger.info(f'[NEW CONNECTION]: {addr} connected.')
        connected = True
        while connected:
            try:
                x, y, speed = conn.recv(BUFFER_LEN).decode().strip().split(',')
                self.logger.info(f'[TO PREDICT]: {float(x), float(y), float(speed)}')
                newX, newY = list(predict(x, y, speed)[0])
                self.logger.info(f'[PREDICTED]: {float(newX), float(newY)}')
                conn.send(f'{newX} {newY}\r\n'.encode('utf-8'))
            except Exception as e:
                self.logger.error(f'{e}')
                conn.close()
                break
        conn.close()

    def start(self):
        self.logger.info('[STARTING]: Server is starting...')
        self.logger.info(f'[LISTENING]: Server is listening on {self.addr}')
        self.server.listen()
        while True:
            conn, addr = self.server.accept()
            thread = threading.Thread(target=self.client, args=(conn, addr))
            thread.start()
            self.logger.info(f'[ACTIVE CONNECTIONS]: {threading.activeCount() - 1}')
