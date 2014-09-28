https://open.kattis.com/problems/aaah

```bash
$ javac Aaah.java 
$ cmp <(for f in tests/*.in; do java Aaah < $f; done) <(for f in tests/*.ans; do cat $f; done)
$ # (no output)
$ java Aaah < tests/aaah.2.in
go
```