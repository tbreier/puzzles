from fractions import gcd

class LCMSetEasy:

  def possible(self, i, k):
    if k == self.x:
      return True
    if i == self.n or k > self.x:
      return False

    if self.possible(i+1, k):
      return True

    curr = self.S[i]
    g = gcd(curr, k)
    curr = curr / g
    return self.possible(i+1, k * curr)

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
  print solver.include([2,3,4,5], 20)
  print solver.include([2,3,4], 611)
  print solver.include([2,3,4], 12)
  print solver.include([1,2,3,4,5,6,7,8,9,10], 24)
  print solver.include([100,200,300,400,500,600], 2000)
  print solver.include([100,200,300,400,500,600], 8000)
  print solver.include([1000000000,999999999,999999998], 999999999)