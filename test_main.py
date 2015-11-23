from __future__ import print_function,division
from algorithms.data_structures.adjacency_matrix import build_random_graph, print_nice
from algorithms.dijkstra import dijkstra_heap


#dijkstra tests
graph = build_random_graph(20)
print(dijkstra_heap(graph,10))




#build graph negative weight test
graph = build_random_graph(5,low_weight = -15,high_weight = 15,p_edge = 1)
print_nice(graph)