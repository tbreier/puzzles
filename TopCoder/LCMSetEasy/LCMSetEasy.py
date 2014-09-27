from fractions import gcd

class LCMSetEasy:

  def possible(self, i, k): # possible improvement: Use Dynamic Programming
    if k == self.x: # the LCM k is the x we're looking for
      return True
    if i == self.n or k > self.x: # reached end of array, or have LCM that is bigger than x
      return False

    if self.possible(i+1, k): # Recursion # 1 : Do not include S[i] in LCM subset
      return True

    curr = self.S[i]
    g = gcd(curr, k)
    curr = curr / g # If our current LCM is 6, and S[i] is 4, the new LCM is 6 * -> 2 <- = 12
    return self.possible(i+1, k * curr) # Recursion # 2 : Do include S[i] in LCM subset

  def include(self, S, x):
    self.S = S
    self.x = x
    self.n = len(S)
    if self.possible(0, 1):
      return "Possible"
    else:
      return "Impossible"

if __name__ == "__main__":
  solver = LCMSetEasy()
  print "Possible" == solver.include([2,3,4,5], 20)
  print "Impossible" == solver.include([2,3,4], 611)
  print "Possible" == solver.include([2,3,4], 12)
  print "Possible" == solver.include([1,2,3,4,5,6,7,8,9,10], 24)
  print "Possible" == solver.include([100,200,300,400,500,600], 2000)
  print "Impossible" == solver.include([100,200,300,400,500,600], 8000)
  print "Possible" == solver.include([1000000000,999999999,999999998], 999999999)