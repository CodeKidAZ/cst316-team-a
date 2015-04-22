#!/bin/sh
mkdir -p debian/DEBIAN debian/usr/share/applications debian/usr/share/enterpreneurship-simulator debian/usr/share/icons/hicolor/128x128/apps debian/usr/share/icons/hicolor/scalable/apps
cp ../enterpreneurship-simulator.png debian/usr/share/icons/hicolor/128x128/apps
cp ../enterpreneurship-simulator.svg debian/usr/share/icons/hicolor/scalable/apps
cp ../enterpreneurship-simulator.desktop debian/usr/share/applications
cp ../Cst316/dist/Cst316.jar debian/usr/share/enterpreneurship-simulator
cp control debian/DEBIAN
dpkg-deb --build debian
mv debian.deb enterpreneurship-simulator-0.1-1.deb

