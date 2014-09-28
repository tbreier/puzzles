```bash
$ javac NarrowArtGallery.java
$ cmp <(for f in tests/*.in; do java NarrowArtGallery < $f; done) <(for f in tests/*.ans; do cat $f; done)
$ # (no output)
$ java NarrowArtGallery < tests/problem200b200.in
10233
```