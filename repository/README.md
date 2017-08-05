# FIX Repository XML Bindings and Loader
The module is based on the XML bindings source code generated with `xjc` command line tool
from JDK and is providing an JAXB style access API for the FIX repository
of the [FIX Trading Community](https://www.fixtrading.org).

The primary usage is for the modelgen code generator.

The code from FIX Repository XSD Schema included with the repository, both can be downloaded
[here](https://www.fixtrading.org/standards/fix-repository/).

To generate the sources download and commit the latest FIX repository
to `/path-to-git/ufixj/repository/src/main/resources/net/bobah/ufixj/repository`

Then run
```
$ xjc -p net.bobah.ufixj.repository.repo -d /path-to-git/ufixj/repository/src/main/java  /path-to-downloaded/FixRepository.xsd
$ xjc -p net.bobah.ufixj.repository.phrases -d /path-to-git/ufixj/repository/src/main/java  /path-to-downloaded/FixPhrases.xsd
```