call runcrud.bat
if "%ERRORLEVEL%" == "0" goto web_browser
echo.
echo runcrud.bat has errors - breaking work
goto fail


:web_browser
@echo Choose web _browser
@echo  1 brave
@echo  2 edge
@echo  3 opera

@set /p "cho=>"
@if %cho%==1 h brave http://localhost:8080/crud/v1/task/getTasks
@if %cho%==2 start /MIN /B  microsoft-edge:"http://localhost:8080/crud/v1/task/getTasks"
@if %cho%==3 start opera http://localhost:8080/crud/v1/task/getTasks
@goto end

:fail
echo.
echo There were errors

:end
@echo.
