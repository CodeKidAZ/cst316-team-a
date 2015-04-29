Set oWS = WScript.CreateObject("WScript.Shell")
If wscript.arguments.count < 3 then
  WScript.Echo "usage: makeshortcut.vbs src dest icon "
  WScript.Quit
end If
targetPath = wscript.arguments(0)
shortcutPath = wscript.arguments(1)
iconLocation = wscript.arguments(2)

Set oLink = oWS.CreateShortcut(shortcutPath) 
oLink.TargetPath = "java"
oLink.Description = "CST316 Final Project"
oLink.IconLocation = iconLocation
oLink.Arguments = "-jar """ & targetPath & """"
oLink.Save
