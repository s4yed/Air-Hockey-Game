import pandas as pd
import pickle
import os

HARD = True
if HARD:
    hokey_data = pd.read_csv('../dataset/DataToTrain.csv')
else:
    hokey_data = pd.read_csv('../dataset/DataToTrain1.csv')
    hokey_data = hokey_data[:hokey_data.shape[0] // 4]

print(f'Loaded {hokey_data.shape[0]} row and {hokey_data.shape[1]} columns\n')
print(hokey_data.head(5))
hokey_data = hokey_data.drop_duplicates()

from sklearn.model_selection import train_test_split

X = hokey_data.drop(columns=['Player.x', 'Player.y'])
y = hokey_data[['Player.x', 'Player.y']]
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.33)

from sklearn.neighbors import KNeighborsRegressor

print(f'Training the model...')
model = KNeighborsRegressor()
model.fit(X_train, y_train)

with open('../models/model_easy.dat', 'wb') as h:
    pickle.dump(model, h)

accuracy = model.score(X_test, y_test)
print(f'Accuracy {float(accuracy * 100)}')


def predict(x: float, y: float, speed: float):
    df = pd.DataFrame(columns=['x', 'y', 'speed'])
    toPredict = df.append({'x': x, 'y': y, 'speed': speed}, ignore_index=True)
    newPos = model.predict(toPredict)
    return newPos
