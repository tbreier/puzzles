https://open.kattis.com/problems/different

```bash
$ javac ADifferentProblem.java 
$ cmp <(for f in tests/*.in; do java ADifferentProblem < $f; done) <(for f in tests/*.ans; do cat $f; done)
$ # (no output)
$ java ADifferentProblem < tests/sample.in
2
1871293781685339
9223372036854775806
```