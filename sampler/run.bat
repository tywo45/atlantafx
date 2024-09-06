@echo off
setlocal & pushd

set APP_ENTRY=atlantafx.sampler.Launcher2

set BASE=%~dp0
set CP=%BASE%\config;%BASE%\lib\*
set PM=%PM% -Xms64m -Xmx8000m
set PM=%PM% -Djava.util.Arrays.useLegacyMergeSort=true

set PM=%PM% --add-opens=java.base/java.lang=ALL-UNNAMED
set PM=%PM% --add-opens=java.base/java.math=ALL-UNNAMED
set PM=%PM% --add-opens=java.base/java.util=ALL-UNNAMED
set PM=%PM% --add-opens=java.base/java.util.concurrent=ALL-UNNAMED
set PM=%PM% --add-opens=java.base/java.util.concurrent.atomic=ALL-UNNAMED
set PM=%PM% --add-opens=java.base/java.util.concurrent.locks=ALL-UNNAMED
set PM=%PM% --add-opens=java.base/java.net=ALL-UNNAMED
set PM=%PM% --add-opens=java.base/java.text=ALL-UNNAMED
set PM=%PM% --add-opens=java.base/sun.nio.ch=ALL-UNNAMED
set PM=%PM% --add-opens=java.sql/java.sql=ALL-UNNAMED
set PM=%PM% --add-opens=java.base/java.io=ALL-UNNAMED
set PM=%PM% --add-opens=java.base/java.lang.reflect=ALL-UNNAMED

set PM=%PM% -XX:+HeapDumpOnOutOfMemoryError
set PM=%PM% -XX:HeapDumpPath=/java-tio-pid.hprof
echo %PM%
java %PM% -cp "%CP%" %APP_ENTRY%