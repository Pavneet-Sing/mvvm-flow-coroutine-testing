<h1 align="center"> MVVM-Flow-Coroutine-Unit-Testing </h1>

Flow can emit the data asynchronously(like streams) which can be transformed and collected as Live Data to implement MVVM.

This project demonstrated the implementation of MVVM with Flow and coroutines to implement unit testing for multiple flow emissions.

Structure
---------
- MainActivity: Host Activity
- di: Contain factory and provider helper classes
- usecase: Project specific implementations to mimic asynchronous call with Flow and coroutines
- main: Fragment and ViewModel implementations

Libraries
---------
- Mockito : For mock environment setup
- ViewModel: To implement MVVM
- Arch-core-testing: For LiveData synchronous event testing
- Kotlinx-coroutines-test: For coroutines synchronous testing setup
- KTX-libs: For kotlin support and extensions

Contribution
------------
PRs are welcome though for major changes, raise an issue otherwise
1. Fork the repo
2. Create a new branch e.g. feature/feature-name, issue/issue-name
3. Commit your changes
4. Raise a PR

LICENSE
-------

<details>
<summary>MIT License</summary>

```
Copyright (c) 2020 Pavneet Singh

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
</details>