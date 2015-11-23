from __future__ import print_function,division
from algorithms.data_structures.adjacency_matrix import build_random_graph, print_nice
from algorithms.dijkstra import dijkstra_heap

graph = build_random_graph(20)
print(dijkstra_heap(graph,10))