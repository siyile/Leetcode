class disjoint_set:
    def __init__(self, n):
        self.rank = [0] * n
        self.size = [1] * n
        self.max = 1
        self.parent = [i for i in range(n)]
    
    def find(self, x):
        if x != self.parent[x]:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]
    
    def union(self, x, y):
        x, y = self.find(x), self.find(y)
        if x == y:
            return
        if self.rank[x] > self.rank[y]:
            self.parent[y] = x
            self.size[x] += self.size[y]
        else:
            self.parent[x] = y
            self.size[y] += self.size[x]
            if self.rank[x] == self.rank[y]:
                self.rank[y] += 1
        self.max = max(self.max, self.size[x], self.size[y])
    
    def group(self):
        s = set()
        for x in self.parent:
            s.add(self.find(x))
        return len(s)
    
    def get_max(self):
        return self.max