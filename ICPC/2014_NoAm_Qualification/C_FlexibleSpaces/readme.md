```bash
$ javac FlexibleSpaces.java 
$ cmp <(for f in tests/*.in; do Java FlexibleSpaces < $f; done) <(for f in tests/*.ans; do cat $f; done)
$ # (no output)
```