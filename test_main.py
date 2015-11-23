from __future__ import print_function,division
from algorithms.data_structures.adjacency_matrix import build_random_graph, print_nice

from algorithms.dijkstra import dijkstra_heap
from algorithms.bellman_ford import bellman_ford_naive

#dijkstra tests
graph = build_random_graph(20)
print(dijkstra_heap(graph,10))

#build graph negative weight test
graph = build_random_graph(5,low_weight = -15,high_weight = 15,p_edge = 1)
print_nice(graph)

#bellman ford test - negative cycle
graph = build_random_graph(5,low_weight = -15,high_weight = 1,p_edge = 1)
assert(bellman_ford_naive(graph,4) == False)

#dijkstra and bellman compared
print('\n*10')
print('bellman vs dijkstra')
graph = build_random_graph(25)
sol_1 = dijkstra_heap(graph,10)
sol_2 = bellman_ford_naive(graph,10)
print(sol_1)
print(sol_2)
assert(sol_1 == sol_2)