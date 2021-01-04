# AI Game Server

This is the AI Python server developed especially for the Air Hockey Game. It's actually a **Machine Learning** model
trained on a dataset. The dataset based on 3 main features:

1. The hockey's coordinates on the canvas. `(x, y)`.
2. The hockey's speed. `speed`.
3. The paddle's coordinates on the same canvas. `(Paddle.x, Paddle.y)`

The dataset trained on a supervised machine learning regression algorithm called **K-NN (K-Nearest Neighbors)**. The
algorithm works by finding the distance between a point and all the other data points, selecting the specified number
**K** closest to that point, then uses the **averages** of the specified **K** points. You can read more
about [K-NN](https://towardsdatascience.com/machine-learning-basics-with-the-k-nearest-neighbors-algorithm-6a6e71d01761)
.

### Installation

First you have to install [`Python 3.9`](https://www.python.org/downloads/) on your machine, after that run the
following command in order to install the required libraries.

```commandline
pip install numpy pandas
```

### Start the Server

The following command will start the load the trained model and start the local server.

```commandline
python main.py
```

### Important Notes

In order to train the model from the beginning, you have to replace the following line

```python
from AI.LoadModels import predict
```

to

```python
from AI.AirHokeyAI import predict
```

in `Server.py` file.




