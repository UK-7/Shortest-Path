"""Fibonacci Heap

   Fibonacci heaps are especially desirable when the number of
   extract_min() and delete() operations is small relative to the
   number of other operations performed.
"""
def torange(a, b, step=1):
    return xrange(a, b+1, step)

class FibonacciHeap:
    def __init__(self):
        self.min = None
        self.n = 0

class FibonacciHeapNode:
    def __init__(self, key):
        self.key = key
        self.refresh()

    def refresh(self):
        self.degree = 0
        self.parent = None
        self.child = None
        self.left = self
        self.right = self
        self.mark = False
        
def make_heap():
    return FibonacciHeap()

def make_node(k):
    return FibonacciHeapNode(k)

def minimum(H):
    return H.min

def is_empty(H):
    return H.n == 0

def insert(H, x):
    x.refresh()
    if H.min == None:
        H.min = x
    else:
        w = H.min.left
        y = H.min
        x.left = w
        x.right = y
        w.right = x
        y.left = x
        if x.key < H.min.key:
            H.min = x
    H.n = H.n + 1

def extract(H):
    x = H.min
    if x != None:
        if x.child != None:
            __add_list(x.child, x)
        x.left.right = x.right
        x.right.left = x.left
        if x == x.right:
            H.min = None
        else:
            H.min = x.right
            __consolidate(H)
        H.n = H.n - 1
        x.refresh()
    return x

def decrease_key(H, x, k):
    assert(k <= x.key)
    if k == x.key:
        return
    x.key = k
    y = x.parent
    if y != None and x.key < y.key:
        __cut(H, x, y)
        __cascading_cut(H, y)
    if x.key < H.min.key:
        H.min = x

def __cut(H, x, y):
    # remove x from the child list of y, decrementing y.degree.
    x.left.right = x.right
    x.right.left = x.left
    y.degree = y.degree - 1
    y.child = x.right
    if x == x.right:
        y.child = None
    # add x to the root list of H
    x.parent = None
    x.mark = False
    x.left = H.min.left
    x.right = H.min
    x.left.right = x
    x.right.left = x
    #__add_list(x, H.min)

def __cascading_cut(H, y):
    z = y.parent
    if z != None:
        if y.mark == False:
            y.mark = True
        else:
            __cut(H, y, z)
            __cascading_cut(H, z)

def __add_list(y, x):
    """Add list y to x."""
    if y == None or x == None:
        return
    z = y
    while z.right != y:
        z.parent = x.parent
        z = z.right
    z.parent = x.parent
    y.left = x.left
    x.left.right = y
    z.right = x
    x.left = z

        

def __union(H1, H2):
    H = FibonacciHeap()
    if H1.min != None and H2.min == None:
        H.min = H1.min
        H.n = H1.n
    elif H1.min == None and H2.min != None:
        H.min = H2.min
        H.n = H2.n
    elif H1.min != None and H2.min != None:
        __add_list(H2.min, H1.min)
        if H1.min.key <= H2.min.key:
            H.min = H1.min
        else:
            H.min = H2.min
        H.n = H1.n + H2.n
    return H

def __consolidate(H):
    max_degree = __max_degree(H.n)
    A = []
    for i in torange(0, max_degree):
        A.append(None)
    root_list = []
    x = H.min
    x.left.right = None
    while x != None:
        next_x = x.right
        x.left = x
        x.right = x
        root_list.append(x)
        x = next_x
    for x in root_list:
        #__print_node_info(x)
        d = x.degree
        #print "index=", d, "max_degree=", max_degree, "H.n=",H.n
        while A[d] != None:
            y = A[d]
            if y.key < x.key:
                x,y = y,x
            __link(y, x)
            A[d] = None
            d = d + 1
        A[d] = x
    H.min = None
    for x in A:
        if x != None:
            x.left = x
            x.right = x
            x.parent = None
            if H.min == None:
                H.min = x
            else:
                __add_list(x, H.min)
                if x.key < H.min.key:
                    H.min = x

def __print_node_info(x):
    
    print """
    --- node info ---
    key = %.1f
    """ % (x.key)


def __max_degree(n):
    """floor(lg(n))"""
    lg = 0
    while n/2 > 0:
        lg = lg + 1
        n = n / 2
    return lg

def __link(y, x):
    y.left.right = y.right
    y.right.left = y.left
    y.parent = x
    if x.child != None:
        x.child.left.right = y
        y.left = x.child.left
        y.right = x.child
        x.child.left = y
    else:
        x.child = y
        y.left = y
        y.right = y
    x.degree = x.degree + 1
    y.mark = False

######################################################################
        
def print_heap(s, indent='#', char='#'):
    x = s
    first_iteration = True
    while x != None and (first_iteration or x != s):
        first_iteration = False
        print "%s %s [%d]" %(indent, x.key, x.degree)
        if x.child != None:
            print_heap(x.child, indent+char, char)
        x = x.right

def iterate_heap(s):
    all_elems = set()
    x = s
    first_iteration = True
    while x != None and (first_iteration or x != s):
        first_iteration = False
        all_elems.add(x)
        if x.child != None:
            all_elems = all_elems | iterate_heap(x.child)
        x = x.right
    return all_elems


def show_heap(H):
    print_heap(H.min, 'o', '->')

def test():
    #data = [31,40,50,37,45,60,65,73,23,76]
    #data = [10,20,30,40,50,60,70,80,90]
    data = [(30,0),(10,1),(90,2),(80,3),(60,4),(70,5),(20,6),(50,7),(40,8)]
    #data = [3,3,2,1,8,3,7]

    print "Input data:", data

    ############################################################
    print """
    We print out the state of the heap as each data item is wrapped in
    a node and inserted into the heap.  Depth of the tree is indicated
    by the indentation.  The first number is the key, and the number
    in square brackets the degree of the node.
    """

    min = None
    max = None
    nodes = []
    H = make_heap()
    for d in data:
        n = make_node(d)
        if min == None or n.key < min.key:
            min = n
        if max == None or n.key > max.key:
            max = n
        nodes.append(n)
        insert(H, n)
        print_heap(H.min, 'o', '->')

    print_heap(H.min, 'before o', '->')
    

    #note(jg): what I have added
    z = iterate_heap(H.min)
    print([x.key for x in z])


    decrease_key(H, max, (10,2))
    print
    print_heap(H.min, 'after  o', '->')

    ############################################################
    factor = 2
    repetitions = 10


######################################################################
######################################################################
if __name__ == '__main__': test()