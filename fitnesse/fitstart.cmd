set "port=8081"
REM start new fitnesse server on specified port - in new cmd window, so we can still use this one
start cmd /k java -jar fitnesse-standalone.jar -p %port%
REM open browser and connect with just started FitNesse server on the same port
explorer "http://localhost:%port%"