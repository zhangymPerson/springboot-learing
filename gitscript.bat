@echo off
rem git checkout 
call:gitcheckout dev
call:gitmerge person
call:gitcheckout master
call:gitmerge dev
call:gitcheckout person
exit

rem git branch change
:gitcheckout
git checkout %1
goto:eof

rem git merge branch
:gitmerge
git merge %1
goto:eof