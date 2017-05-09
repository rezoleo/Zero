# Project Zer0

By [Zidmann](mailto:emmanuel.zidel@gmail.com) :bow:

## Description

Project Zer0 is a project created by engineering students of l'Ecole Centrale de Lille.

It consists in developing a repository of information shared by several applications or websites used by the students of the engineering school.
The repository contains information about students (firstname, lastname, age, photo identification, ...), about the different associations, clubs or commissions (members, managers, ...) and about the student cards (ID, ...).

This project also provides an identification system.

Project Zer0 is the touchstone of the projects belonged to RezoLution : they rely on the information provided by this repository and use the identification system.

### Cloning the project

When you clone the project, use a user different from 'root'.

The NodeJS servers are restricted and can't run in root user.

### After cloning the project

* If you are behind a proxy, you must update your proxy settings.

Note : You have to type 'HTTP_PROXY' (in capital letter), not 'http_proxy' (in small letter), otherwise the bower installation will fail.

Moreover, the proxy settings must be typed in the same console window that the installation scripts; if you close the console window you will have to retype the proxy settings commands.

```bash
export HTTP_PROXY="http://<proxy_adress>:<proxy_port>"
export HTTPS_PROXY="http://<proxy_adress>:<proxy_port>"
npm config set proxy http://<proxy_adress>:<proxy_port>
npm config set https-proxy http://<proxy_adress>:<proxy_port>
```

* Update your Linux version and install the different program necessary.

Note : This script must be launched with root user.

```bash
./Development/Utils/scripts/dependencies-installation.sh
```

* Create a symbolic link to the project
```bash
ln -s <path_of_the_git_project> /opt/centrale-datacore;
```

* Create the log directory and install the NodeJS dependancies

Note :
Some error messages can appear during the execution of install-modules.sh
Moreover, sometimes the install-module freezes with a root user, then do not use it.

```bash
./Development/Utils/scripts/create-log-dir.sh
./Development/Utils/scripts/create-module-links.sh
./Development/Utils/scripts/install-modules.sh
./Development/Utils/scripts/create-front.sh
```

Moreover, during the module installation choose :

- for 'angular.js' choose "1) angular#1.3.x which resolved to 1.3.17 and is required by angular-material-icons#0.4.0"

- for 'moment.js' choose "3) moment#>=2.8.0 <2.11.0 which resolved to 2.9.0 and is required by angular-moment#0.10.3"


### Before a test

* Prepare the data in Mongo databases for unit test suites
! WARNING ! The bases used by the services and the applications are cleared by this script
```bash
./Development/Utils/scripts/prepare-mongo.sh
```

### To manage the NodeJS servers

* Start all the NodeJS servers
```bash
./Development/Utils/scripts/start-servers.sh
```

* Restart all the NodeJS servers
```bash
./Development/Utils/scripts/restart-servers.sh
```

* Stop all the NodeJS servers
```bash
./Development/Utils/scripts/stop-servers.sh
```

### To generate the final files (JAR and DEB packages)

The final DEB packages will be in the directory Integration/packages/All/DEB.

The final JAR librairies will be in the directory Integration/packages/All/JAR.

* Copy the NodeJS codes from Development to Integration branch (before compiling)

Note : This script doesn't copy the tools yet.

```bash
./Integration/packages/copy-nodejs.sh
```

* Compile the DEB packages (after copying the NodeJS codes to Integration branch)

Note : This script must be launched with root user.

```bash
./Integration/packages/compile-deb.sh
```

* Copy the JAR packages from the Development branch to Integration branch
```bash
./Integration/packages/copy-jar.sh
```


### Something else useful

* To create new (self-signed) SSL certificate
```bash
./Development/Utils/scripts/generate-ssl.sh
```

* To purge log directories
```bash
./Development/Utils/scripts/purge-log.sh
```

* To purge the database
```bash
./Development/Utils/scripts/prepare-mongo.sh
```

* To remove the dependancies in node_modules/ and bower_components/
```bash
./Development/Utils/scripts/purge-modules.sh
```

## Components

Each application relies on several services and modules.
Each service relies on modules and also services.

The communication between an application and a service or between the two services is based on HTTP.

## Contributors

* [Emmanuel ZIDEL-CAUFFET](mailto:emmanuel.zidel@gmail.com) :bow:
* [Hugo LEHMANN](mailto:shogi31@gmail.com) :bow:
* [Thomas GAUDIN](mailto:t.goudine@gmail.com) :bow:
* [Tarik MEGZARI](mailto:tarikmegzari@gmail.com) :bow:
