from __future__ import print_function,division

from algorithms.data_structures.adjacency_matrix import build_random_graph, print_nice
from algorithms.dijkstra import dijkstra_heap, dijkstra_naive, dijkstra_fib
from algorithms.bellman_ford import bellman_ford_naive, bellman_ford_less_naive
from algorithms.utilities.plotting import build_size_data,build_connectivity_data,basic_plot

import time

#graph = build_random_graph(10000)
#test_1 = dijkstra_naive(graph,10)
#test_2 = dijkstra_fib(graph,10)
#test_3 = dijkstra_heap(graph,10)
#print(test_1)
#print(test_2)


for i in range(10,100):
    print(i)
    for j in range(50):
        graph = build_random_graph(i)
        x = bellman_ford_naive(graph,0)
        y = bellman_ford_less_naive(graph,0)
        if not x:
            if x[0] != y[0]:
                print(x[0])
                print(y[0])
                
                break





'''
for i in range(6000):
    graph = build_random_graph(50)
    x = bellman_ford_less_naive(graph,10)
    y = bellman_ford_naive(graph,10)
    if not x:
        print('negative cycle')
    else:
        if x[0] != y[0]:
            print(x[0])
            print(y[0])'
#############################
#######Build Plots###########
#############################
size_data = build_size_data(functions = [bellman_ford_naive,bellman_ford_less_naive],
						min_size = 10,max_size = 50, num_iter = 10)

connectivity_data = build_connectivity_data(functions = [bellman_ford_naive,bellman_ford_less_naive],
						size = 50, min_p = 0.2, max_p = 1.0, step_p = .1, num_iter = 50)

algorithm_names = ['bellman_ford','bellman_less_naive']

basic_plot(algorithm_names,size_data, title = 'Run Time vs. Graph Size', x_axis = 'graph size')
basic_plot(algorithm_names,connectivity_data, title = 'Run Time vs. Connectivity', x_axis = 'p connected')


### Testing Fibonocci Implementation ###
for i in range(10000):
    graph = build_random_graph(20)
    test_1 = dijkstra_naive(graph,10)
    test_2 = dijkstra_fib(graph,10)
    test_3 = dijkstra_heap(graph,10)
    if test_1 != test_2:
        print(test_1)
        print(test_2)

# they agree on ten thousand solutions

##############################################################
############How many nodes does it toake to break#############
##############################################################
start = time.time()
g = build_random_graph(10000, stress = True)
dijkstra_heap(g, 0, stress = True)

print('Run Time for 10,000 nodes')
print(time.time()-start)

####################################
############Basic Tests#############
####################################

#dijkstra tests
graph = build_random_graph(20)
print(dijkstra_heap(graph,10))

#build graph negative weight test
graph = build_random_graph(5, low_weight = -15, high_weight = 15, p_edge = 1)
print_nice(graph)

#bellman ford test - negative cycle
graph = build_random_graph(5, low_weight = -15, high_weight = 1, p_edge = 1)
assert(bellman_ford_naive(graph,4) == False)

#dijkstra and bellman compared
print('\n*10')
print('bellman vs dijkstra')
graph = build_random_graph(25)
sol_1 = dijkstra_heap(graph,10)
sol_2 = bellman_ford_naive(graph,10)
print(sol_1)

'''




