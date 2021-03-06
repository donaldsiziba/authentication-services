# Authentication Services
This documentation is part of this blog [post](https://awesomaticblog.wordpress.com/2019/08/08/requirements-as-first-class-citizens-2/).

## Acceptance Tests
To run the _Acceptance Tests_, execute the following in command line on the project's root directory:
```bash
mvn verify
```
>Note: Use _mvn clean verify_ for subsequent builds
### Acceptance Test Reports
After the build, the Acceptance Test reports can be found in _target/site/serenity_. Use a browser to view the _index.html_ file.

#### Test Results Page
![Test Results Page](src/test/resources/images/test-results.png)