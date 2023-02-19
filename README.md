```
          __          __                                       .__  __
  _______/  |______ _/  |_ __ __  ______   _____   ____   ____ |__|/  |_  ___________
 /  ___/\   __\__  \\   __\  |  \/  ___/  /     \ /  _ \ /    \|  \   __\/  _ \_  __ \
 \___ \  |  |  / __ \|  | |  |  /\___ \  |  Y Y  (  <_> )   |  \  ||  | (  <_> )  | \/
/____  > |__| (____  /__| |____//____  > |__|_|  /\____/|___|  /__||__|  \____/|__|
     \/            \/                \/        \/            \/

```

The status-monitor-service provides a server-side web dashboard for visualizing the operational status of various services.

Code from this project is shared via the repository: https://github.com/practicalli/status-monitor.

[![CircleCI](https://circleci.com/gh/circleci/circleci-docs.svg?style=svg)](https://circleci.com/gh/practicalli/status-monitor)

- [ascii banner generation](http://patorjk.com/software/taag/#p=display&f=Graffiti&t=status%20monitor)


## Project Creation

The project was created with [Leiningen](https://github.com/technomancy/leiningen) 2.8.1, using the compojure template.

<!-- ```shell -->
<!-- TODO: update to Clojure CLI tools -->
<!-- clojure -M:project/new app practicalli/status-monitor-service -->
<!-- ``` -->

## Development
Open the `src/practicalli/status-monitor-service.clj` file in a Clojure aware editor and start a REPL

Run all the project tests using Cognitect Labs test runner, which is included in the project `deps.edn` file.

`:dev` adds the ring-mock library for generating request data.  `:test` adds the `test/` directory to the class path to include the unit test code.

```shell
clojure -A:dev:test:runner
```

Cognitect Labs, eftest and kaocha test runners are available in the [practicalli/clojure-deps-edn](https://github.com/practicalli/clojure-deps-edn) repository

## Running the webserver on the command line
Run the application by specifying the main namespace and Clojure will look for the `-main` function in that namespace and run the application.

```shell
clojure -m practicalli.status-monitor-service
```


## Deploying

Create an uberjar using the `depstar` library for Clojure Tools

```shell
clojure -A:uberjar
```

Then run the application on the comand line using the uberjar created

```shell
java -jar status-monitor-service.jar
```


## License
Copyright © 2020 Practicalli

Distributed under the Creative Commons Attribution Share-Alike 4.0 International
