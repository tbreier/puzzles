```bash
$ javac FlexibleSpaces.java 
$ cmp <(for f in tests/*.in; do Java FlexibleSpaces < $f; done) <(for f in tests/*.ans; do cat $f; done)
$ # (no output)
$ java FlexibleSpaces < tests/L.in
1 2 3 4 6 7 8 12 14 15 16 24 28 30 31 32 48 56 60 62 63 64
```