from fib import *
import copy
class Fib_Heap():
	def __init__(self):
		self.heap = FibonacciHeap()

	def add(self,data):
		n = make_node(data)
		insert(self.heap,n)
	
	def pop(self):
		return extract(self.heap)

	def adjust_node(self,inc_node,alt):
		nodes = iterate_heap(self.heap.min)
		for node in nodes:
			if node.key[1] == inc_node:
				decrease_key(self.heap,node,(alt,inc_node))
				return True
		return False
	def print_nice(self):
		return print_heap(self.heap.min)