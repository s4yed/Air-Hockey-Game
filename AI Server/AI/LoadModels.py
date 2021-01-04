import pickle
import pandas as pd
import numpy

global model
with open('../models/model_hard.dat', 'rb') as m:
    print('Loading easy server...')
    model = pickle.load(m)
    print(numpy.version.version)
    print(pd.__version__)


def predict(x: float, y: float, speed: float):
    df = pd.DataFrame(columns=['x', 'y', 'speed'])
    toPredict = df.append({'x': x, 'y': y, 'speed': speed}, ignore_index=True)
    newPos = model.predict(toPredict)
    return newPos
