# labseq-calculator

The labseq-calculator is a simple RESTful web service that calculates the nth number in the Labseq sequence, defined as follows:

$$
\begin{equation}
l(n)=
\begin{cases}
 0 & \text{if } n=0 & \lor & n=2\\
 1 & \text{if } n=1 & \lor & n=3\\
 l(n-4) + l(n-3) & \text{if } n>3 \\
\end{cases}
\end{equation}
$$

It is built using Quarkus, a modern Java framework designed for building high-performance applications.

The JDK used to build this project is Eclipse Temurin 25.0.2. You can download it from the official website: <https://adoptium.net/>.

> [!NOTE]
> This project uses Quarkus, the Supersonic Subatomic Java Framework.
>
> If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.
>
> ## Running the application in dev mode
>
> You can run your application in dev mode that enables live coding using:
>
> ```shell script
> ./mvnw quarkus:dev
> ```
>
> > **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.
>
> ## Packaging and running the application
>
> The application can be packaged using:
>
> ```shell script
> ./mvnw package
> ```
>
> It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
> Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.
>
> The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.
>
> If you want to build an _über-jar_, execute the following command:
>
> ```shell script
> ./mvnw package -Dquarkus.package.jar.type=uber-jar
> ```
>
> The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.
>
> ## Creating a native executable
>
> You can create a native executable using:
>
> ```shell script
> ./mvnw package -Dnative
> ```
>
> Or, if you don't have GraalVM installed, you can run the native executable build in a container using:
>
> ```shell script
> ./mvnw package -Dnative -Dquarkus.native.container-build=true
> ```
>
> You can then execute your native executable with: `./target/labseq-calculator-1.0.0-SNAPSHOT-runner`
>
> If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.
>
> ## Related Guides
>
> - REST ([guide](https://quarkus.io/guides/rest)): A Jakarta REST implementation utilizing build time processing and Vert.x. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it.
>
> ## Provided Code
>
> ### REST
>
> Easily start your REST Web Services
>
> [Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
