@echo off
echo Welcome to PMS !!
echo Please give your choice ...
color 0c
echo 1. Run AdminLogin page.
echo 2. Run AdminControlPanel page.
echo 3. Run WardenControlPanel page.
echo 4. Run AddPrisoner page.
echo 5. Run AddWarden page.
echo 6. Run UpdateWarden page.
echo 7. Run UpdatePrisoner page.
echo 8. Run ReleasePrisoner page.
echo 9. Run DeleteWarden page.
echo 10. Run SearchWarden page.

set /p choice=Select your choice...

if '%choice%'=='1' java AdminLogin
if '%choice%'=='2' java ControlPanel
if '%choice%'=='3' java WardenControlPanel

cls
echo Now running......