```bash
$ javac EightQueens.java 
$ cmp <(for f in tests/*.in; do java EightQueens < $f; done) <(for f in tests/*.ans; do cat $f; done)
$ # (no output)
$ java EightQueens < tests/missing00.in
invalid
```